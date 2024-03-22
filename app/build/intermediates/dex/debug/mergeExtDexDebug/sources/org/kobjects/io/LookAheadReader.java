package org.kobjects.io;

import java.io.IOException;
import java.io.Reader;

public class LookAheadReader extends Reader {
    char[] buf;
    int bufPos;
    int bufValid;
    Reader reader;

    public LookAheadReader(Reader r) {
        this.buf = new char[(Runtime.getRuntime().freeMemory() > 1000000 ? 16384 : 128)];
        this.bufPos = 0;
        this.bufValid = 0;
        this.reader = r;
    }

    public int read(char[] cbuf, int off, int len) throws IOException {
        if (this.bufValid == 0 && peek(0) == -1) {
            return -1;
        }
        if (len > this.bufValid) {
            len = this.bufValid;
        }
        char[] cArr = this.buf;
        int length = cArr.length;
        int i = this.bufPos;
        if (len > length - i) {
            len = cArr.length - i;
        }
        System.arraycopy(cArr, i, cbuf, off, len);
        this.bufValid -= len;
        int i2 = this.bufPos + len;
        this.bufPos = i2;
        char[] cArr2 = this.buf;
        if (i2 > cArr2.length) {
            this.bufPos = i2 - cArr2.length;
        }
        return len;
    }

    public String readTo(String chars) throws IOException {
        StringBuffer buf2 = new StringBuffer();
        while (peek(0) != -1 && chars.indexOf((char) peek(0)) == -1) {
            buf2.append((char) read());
        }
        return buf2.toString();
    }

    public String readTo(char c) throws IOException {
        StringBuffer buf2 = new StringBuffer();
        while (peek(0) != -1 && peek(0) != c) {
            buf2.append((char) read());
        }
        return buf2.toString();
    }

    public void close() throws IOException {
        this.reader.close();
    }

    public int read() throws IOException {
        int result = peek(0);
        if (result != -1) {
            int i = this.bufPos + 1;
            this.bufPos = i;
            if (i == this.buf.length) {
                this.bufPos = 0;
            }
            this.bufValid--;
        }
        return result;
    }

    public int peek(int delta) throws IOException {
        if (delta <= 127) {
            while (true) {
                int i = this.bufValid;
                if (delta >= i) {
                    char[] cArr = this.buf;
                    int startPos = (this.bufPos + i) % cArr.length;
                    int count = this.reader.read(this.buf, startPos, Math.min(cArr.length - startPos, cArr.length - i));
                    if (count == -1) {
                        return -1;
                    }
                    this.bufValid += count;
                } else {
                    char[] cArr2 = this.buf;
                    return cArr2[this.bufPos + (delta % cArr2.length)];
                }
            }
        } else {
            throw new RuntimeException("peek > 127 not supported!");
        }
    }

    public String readLine() throws IOException {
        if (peek(0) == -1) {
            return null;
        }
        String s = readTo("\r\n");
        if (read() == 13 && peek(0) == 10) {
            read();
        }
        return s;
    }

    public String readWhile(String chars) throws IOException {
        StringBuffer buf2 = new StringBuffer();
        while (peek(0) != -1 && chars.indexOf((char) peek(0)) != -1) {
            buf2.append((char) read());
        }
        return buf2.toString();
    }

    public void skip(String chars) throws IOException {
        new StringBuffer();
        while (peek(0) != -1 && chars.indexOf((char) peek(0)) != -1) {
            read();
        }
    }
}
