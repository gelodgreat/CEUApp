// Created by JeffMeJones@gmail.com
package decoder;


import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

import java.io.InputStream;
import java.util.Vector;
public class GIFDecode {

    private static final int STATUS_OK = 0;
    private static final int STATUS_FORMAT_ERROR = 1;
    private static final int STATUS_OPEN_ERROR = 2;

    private InputStream in;
    private int status;

    private int width; // full image width
    private int height; // full image height
    private boolean gctFlag; // global color table used
    private int gctSize; // size of global color table
    private int loopCount = 1; // iterations; 0 = repeat forever

    private int[] gct; // global color table
    private int[] lct; // local color table
    private int[] act; // active color table

    private int bgIndex; // background color index
    private int bgColor; // background color
    private int lastBgColor; // previous bg color
    private int pixelAspect; // pixel aspect ratio

    private boolean lctFlag; // local color table flag
    private boolean interlace; // interlace flag
    private int lctSize; // local color table size

    private int ix;
    private int iy;
    private int iw;
    private int ih; // current image rectangle
    private int lrx;
    private int lry;
    private int lrw;
    private int lrh;
    private Bitmap image; // current frame
    private Bitmap lastImage; // previous frame
    private int frameindex = 0;

    public int getFrameindex() {
        return frameindex;
    }


	public void setFrameindex(int frameindex) {
		this.frameindex = frameindex;
		if(frameindex>frames.size()-1){
			frameindex=0;	
		}
	}

    private final byte[] block = new byte[256]; // current data block
    private int blockSize = 0; // block size

    // last graphic control extension info
    private int dispose = 0;
    // 0=no action; 1=leave in place; 2=restore to bg; 3=restore to prev
    private int lastDispose = 0;
    private boolean transparency = false; // use transparent color
    private int delay = 0; // delay in milliseconds
    private int transIndex; // transparent color index

    private static final int MaxStackSize = 4096;
    // max decoder pixel stack size

    // LZW decoder working arrays
    private short[] prefix;
    private byte[] suffix;
    private byte[] pixelStack;
    private byte[] pixels;

    private Vector<GifFrame> frames; // frames read from current file
    private int frameCount;

    static class GifFrame {
        public GifFrame(Bitmap im, int del) {
            image = im;
			delay = del;
		}

        public final Bitmap image;
        public final int delay;
    }

    /**
     * Gets display duration for specified frame.
	*
	* @param n
	*            int index of frame
	* @return delay in milliseconds
	*/
	public int getDelay(int n) {
	delay = -1;
	if ((n >= 0) && (n < frameCount)) {
        delay = frames.elementAt(n).delay;
    }
	return delay;
	}
	
	
	public int getFrameCount() {
		return frameCount;
	}
	
	public Bitmap getImage() {
		return getFrame(0);
	}
	public int getLoopCount() {
		return loopCount;
	}

    private void setPixels() {
        int[] dest = new int[width * height];
        // fill in starting image contents based on last image's dispose code
        if (lastDispose > 0) {
			if (lastDispose == 3) {
				// use image before last
				int n = frameCount - 2;
				if (n > 0) {
					lastImage = getFrame(n - 1);
				} else {
					lastImage = null;
				}
			}
			if (lastImage != null) {
				lastImage.getPixels(dest, 0, width, 0, 0, width, height);
				// copy pixels	
				if (lastDispose == 2) {
					// fill last image rect area with background color
					int c = 0;
					if (!transparency) {
						c = lastBgColor;
					}
					for (int i = 0; i < lrh; i++) {
						int n1 = (lry + i) * width + lrx;
						int n2 = n1 + lrw;
						for (int k = n1; k < n2; k++) {
							dest[k] = c;
						}
					}
				}
			}
		}
	
		// copy each source line to the appropriate place in the destination
		int pass = 1;
		int inc = 8;
		int iline = 0;
		for (int i = 0; i < ih; i++) {
			int line = i;
			if (interlace) {
				if (iline >= ih) {
					pass++;
					switch (pass) {
						case 2:
							iline = 4;
							break;
						case 3:
							iline = 2;
							inc = 4;
							break;
						case 4:
							iline = 1;
							inc = 2;
					}
				}
				line = iline;
				iline += inc;
			}
			line += iy;
			if (line < height) {
				int k = line * width;
				int dx = k + ix; // start of line in dest
				int dlim = dx + iw; // end of dest line
				if ((k + width) < dlim) {
					dlim = k + width; // past dest edge
				}
				int sx = i * iw; // start of line in source
				while (dx < dlim) {
					// map color and insert in destination
					int index = ((int) pixels[sx++]) & 0xff;
					int c = act[index];
					if (c != 0) {
						dest[dx] = c;
					}
					dx++;
				}
			}
		}
		image = Bitmap.createBitmap(dest, width, height,Config.RGB_565);
	}
	
	public Bitmap getFrame(int n) {
		Bitmap im = null;
		if ((n >= 0) && (n < frameCount)) {
            im = frames.elementAt(n).image;
        }
		return im;
	}
	public Bitmap next(){
		frameindex++;
		if(frameindex>frames.size()-1){
			frameindex=0;	
		}
        return frames.elementAt(frameindex).image;
    }

    public void read(InputStream is) {
        init();
        if (is != null) {
            in = is;
			readHeader();
			if (!err()) {
				readContents();
				if (frameCount < 0) {
					status = STATUS_FORMAT_ERROR;
				}
			}
		} else {
			status = STATUS_OPEN_ERROR;
		}
		try {
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    private void decodeImageData() {
        int NullCode = -1;
        int npix = iw * ih;
        int available, clear, code_mask, code_size, end_of_information, in_code, old_code, bits, code, count, i, datum, data_size, first, top, bi, pi;
		
		if ((pixels == null) || (pixels.length < npix)) {
			pixels = new byte[npix]; // allocate new pixel array
		}
		if (prefix == null) {
			prefix = new short[MaxStackSize];
		}
		if (suffix == null) {
			suffix = new byte[MaxStackSize];
		}
		if (pixelStack == null) {
			pixelStack = new byte[MaxStackSize + 1];
		}
		// Initialize GIF data stream decoder.
		data_size = read();
		clear = 1 << data_size;
		end_of_information = clear + 1;
		available = clear + 2;
		old_code = NullCode;
		code_size = data_size + 1;
		code_mask = (1 << code_size) - 1;
		for (code = 0; code < clear; code++) {
			prefix[code] = 0;
			suffix[code] = (byte) code;
		}
	
		// Decode GIF pixel stream.
		datum = bits = count = first = top = pi = bi = 0;
		for (i = 0; i < npix; ) {
			if (top == 0) {
				if (bits < code_size) {
					// Load bytes until there are enough bits for a code.
					if (count == 0) {
						// Read a new data block.
						count = readBlock();
						if (count <= 0) {
							break;
						}
						bi = 0;
					}
					datum += (((int) block[bi]) & 0xff) << bits;
					bits += 8;
					bi++;
					count--;
					continue;
				}
				// Get the next code.
				code = datum & code_mask;
				datum >>= code_size;
				bits -= code_size;
				
				// Interpret the code
				if ((code > available) || (code == end_of_information)) {
					break;
				}
				if (code == clear) {
					// Reset decoder.
					code_size = data_size + 1;
					code_mask = (1 << code_size) - 1;
					available = clear + 2;
					old_code = NullCode;
					continue;
				}
				if (old_code == NullCode) {
					pixelStack[top++] = suffix[code];
					old_code = code;
					first = code;
					continue;
				}
				in_code = code;
				if (code == available) {
					pixelStack[top++] = (byte) first;
					code = old_code;
				} 
				while (code > clear) {
					pixelStack[top++] = suffix[code];
					code = prefix[code];
				}
				first = ((int) suffix[code]) & 0xff;
				// Add a new string to the string table,
				if (available >= MaxStackSize) {
					break;
				}
				pixelStack[top++] = (byte) first;
				prefix[available] = (short) old_code;
				suffix[available] = (byte) first;
				available++;
				if (((available & code_mask) == 0)&& (available < MaxStackSize)) {
					code_size++;
					code_mask += available;
				}
				old_code = in_code;
			}
		
			// Pop a pixel off the pixel stack.
			top--;
			pixels[pi++] = pixelStack[top];
			i++;
		}
		for (i = pi; i < npix; i++) {
			pixels[i] = 0; // clear missing pixels
		}
	}

    private boolean err() {
        return status != STATUS_OK;
    }

    private void init() {
        status = STATUS_OK;
        frameCount = 0;
        frames = new Vector<GifFrame>();
		gct = null;
		lct = null;
	}

    private int read() {
        int curByte = 0;
        try {
            curByte = in.read();
		} catch (Exception e) {
			status = STATUS_FORMAT_ERROR;
		}
		return curByte;
	}

    private int readBlock() {
        blockSize = read();
        int n = 0;
        if (blockSize > 0) {
			try {
				int count = 0;
				while (n < blockSize) {
					count = in.read(block, n, blockSize - n);
					if (count == -1) {
						break;
					}
					n += count;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (n < blockSize) {
				status = STATUS_FORMAT_ERROR;
			}
		}
		return n;
	}

    private int[] readColorTable(int ncolors) {
        int nbytes = 3 * ncolors;
        int[] tab = null;
        byte[] c = new byte[nbytes];
		int n = 0;
		try {
			n = in.read(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (n < nbytes) {
			status = STATUS_FORMAT_ERROR;
		} else {
			tab = new int[256]; // max size to avoid bounds checks
			int i = 0;
			int j = 0;
			while (i < ncolors) {
				int r = ((int) c[j++]) & 0xff;
				int g = ((int) c[j++]) & 0xff;
				int b = ((int) c[j++]) & 0xff;
				tab[i++] = 0xff000000 | (r << 16) | (g << 8) | b;
			}
		}
		return tab;
	}

    private void readContents() {
        // read GIF file content blocks
        boolean done = false;
        while (!(done || err())) {
			int code = read();
			switch (code) {		
			case 0x2C: // image separator
				readImage();
				break;
			case 0x21: // extension
				code = read();
				switch (code) {
					case 0xf9: // graphics control extension
						readGraphicControlExt();
						break;
					case 0xff: // application extension
						readBlock();
                        StringBuilder app = new StringBuilder();
                        for (int i = 0; i < 11; i++) {
                            app.append((char) block[i]);
                        }
                        if (app.toString().equals("NETSCAPE2.0")) {
                            readNetscapeExt();
                        } else {
                            skip(); // don't care
						}
						break;
					default: // uninteresting extension
						skip();
				}
				break;
			case 0x3b: // terminator
				done = true;
				break;
			case 0x00: // bad byte, but keep going and see what happens
				break;
			default:
				status = STATUS_FORMAT_ERROR;
			}
		}
	}

    private void readGraphicControlExt() {
        read(); // block size
        int packed = read(); // packed fields
        dispose = (packed & 0x1c) >> 2; // disposal method
		if (dispose == 0) {
			dispose = 1; // elect to keep old image if discretionary
		}
		transparency = (packed & 1) != 0;
		delay = readShort() * 10; // delay in milliseconds
		transIndex = read(); // transparent color index
		read(); // block terminator
	}

    private void readHeader() {
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            id.append((char) read());
        }
        if (!id.toString().startsWith("GIF")) {
            status = STATUS_FORMAT_ERROR;
            return;
        }
		readLSD();
		if (gctFlag && !err()) {
			gct = readColorTable(gctSize);
			bgColor = gct[bgIndex];
		}
	}

    private void readImage() {
        ix = readShort(); // (sub)image position & size
        iy = readShort();
        iw = readShort();
		ih = readShort();
		int packed = read();
		lctFlag = (packed & 0x80) != 0; // 1 - local color table flag
		interlace = (packed & 0x40) != 0; // 2 - interlace flag
		// 3 - sort flag
		// 4-5 - reserved
		lctSize = 2 << (packed & 7); // 6-8 - local color table size	
		if (lctFlag) {
			lct = readColorTable(lctSize); // read table
			act = lct; // make local table active
		} else {
			act = gct; // make global table active
			if (bgIndex == transIndex) {
				bgColor = 0;
			}
		}
		int save = 0;
		if (transparency) {
			save = act[transIndex];
			act[transIndex] = 0; // set transparent color if specified
		}
		if (act == null) {
			status = STATUS_FORMAT_ERROR; // no color table defined
		}
		if (err()) {
			return;
		}
		decodeImageData(); // decode pixel data
		skip();
		if (err()) {
			return;
		}
		frameCount++;
		// create new image to receive frame data
		image = Bitmap.createBitmap(width, height, Config.RGB_565);
		//createImage(width, height);	
		setPixels(); // transfer pixel data to image	
		frames.addElement(new GifFrame(image, delay)); // add image to frame
		// list
		if (transparency) {
			act[transIndex] = save;
		}
		resetFrame();
	}

    private void readLSD() {
        // logical screen size
        width = readShort();
        height = readShort();
		// packed fields
		int packed = read();
		gctFlag = (packed & 0x80) != 0; // 1 : global color table flag
		// 2-4 : color resolution
		// 5 : gct sort flag
		gctSize = 2 << (packed & 7); // 6-8 : gct size	
		bgIndex = read(); // background color index
		pixelAspect = read(); // pixel aspect ratio
	}

    private void readNetscapeExt() {
        do {
            readBlock();
            if (block[0] == 1) {
				// loop count sub-block
				int b1 = ((int) block[1]) & 0xff;
				int b2 = ((int) block[2]) & 0xff;
				loopCount = (b2 << 8) | b1;
			}
		} while ((blockSize > 0) && !err());
	}

    private int readShort() {
        // read 16-bit value, LSB first
        return read() | (read() << 8);
    }

    private void resetFrame() {
        lastDispose = dispose;
        lrx = ix;
        lry = iy;
		lrw = iw;
		lrh = ih;
		lastImage = image;
		lastBgColor = bgColor;
		dispose = 0;
		transparency = false;
		delay = 0;
		lct = null;
	}
	
	/**
	* Skips variable length blocks up to and including next zero length block.
	*/
    private void skip() {
        do {
            readBlock();
        } while ((blockSize > 0) && !err());
	}
}

