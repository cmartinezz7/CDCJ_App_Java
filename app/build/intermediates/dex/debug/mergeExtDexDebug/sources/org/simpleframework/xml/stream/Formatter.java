package org.simpleframework.xml.stream;

import java.io.BufferedWriter;
import java.io.Writer;
import kotlin.text.Typography;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

class Formatter {
    private static final char[] AND = {Typography.amp, 'a', 'm', 'p', ';'};
    private static final char[] CLOSE = {' ', '-', '-', Typography.greater};
    private static final char[] DOUBLE = {Typography.amp, 'q', 'u', 'o', 't', ';'};
    private static final char[] GREATER = {Typography.amp, 'g', 't', ';'};
    private static final char[] LESS = {Typography.amp, 'l', 't', ';'};
    private static final char[] NAMESPACE = {'x', 'm', 'l', 'n', 's'};
    private static final char[] OPEN = {Typography.less, '!', '-', '-', ' '};
    private static final char[] SINGLE = {Typography.amp, 'a', 'p', 'o', 's', ';'};
    private OutputBuffer buffer = new OutputBuffer();
    private Indenter indenter;
    private Tag last;
    private String prolog;
    private Writer result;

    private enum Tag {
        COMMENT,
        START,
        TEXT,
        END
    }

    public Formatter(Writer result2, Format format) {
        this.result = new BufferedWriter(result2, LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY);
        this.indenter = new Indenter(format);
        this.prolog = format.getProlog();
    }

    public void writeProlog() throws Exception {
        String str = this.prolog;
        if (str != null) {
            write(str);
            write("\n");
        }
    }

    public void writeComment(String comment) throws Exception {
        String text = this.indenter.top();
        if (this.last == Tag.START) {
            append((char) Typography.greater);
        }
        if (text != null) {
            append(text);
            append(OPEN);
            append(comment);
            append(CLOSE);
        }
        this.last = Tag.COMMENT;
    }

    public void writeStart(String name, String prefix) throws Exception {
        String text = this.indenter.push();
        if (this.last == Tag.START) {
            append((char) Typography.greater);
        }
        flush();
        append(text);
        append((char) Typography.less);
        if (!isEmpty(prefix)) {
            append(prefix);
            append(':');
        }
        append(name);
        this.last = Tag.START;
    }

    public void writeAttribute(String name, String value, String prefix) throws Exception {
        if (this.last == Tag.START) {
            write(' ');
            write(name, prefix);
            write('=');
            write((char) Typography.quote);
            escape(value);
            write((char) Typography.quote);
            return;
        }
        throw new NodeException("Start element required");
    }

    public void writeNamespace(String reference, String prefix) throws Exception {
        if (this.last == Tag.START) {
            write(' ');
            write(NAMESPACE);
            if (!isEmpty(prefix)) {
                write(':');
                write(prefix);
            }
            write('=');
            write((char) Typography.quote);
            escape(reference);
            write((char) Typography.quote);
            return;
        }
        throw new NodeException("Start element required");
    }

    public void writeText(String text) throws Exception {
        writeText(text, Mode.ESCAPE);
    }

    public void writeText(String text, Mode mode) throws Exception {
        if (this.last == Tag.START) {
            write((char) Typography.greater);
        }
        if (mode == Mode.DATA) {
            data(text);
        } else {
            escape(text);
        }
        this.last = Tag.TEXT;
    }

    public void writeEnd(String name, String prefix) throws Exception {
        String text = this.indenter.pop();
        if (this.last == Tag.START) {
            write('/');
            write((char) Typography.greater);
        } else {
            if (this.last != Tag.TEXT) {
                write(text);
            }
            if (this.last != Tag.START) {
                write((char) Typography.less);
                write('/');
                write(name, prefix);
                write((char) Typography.greater);
            }
        }
        this.last = Tag.END;
    }

    private void write(char ch) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(ch);
    }

    private void write(char[] plain) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(plain);
    }

    private void write(String plain) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(plain);
    }

    private void write(String plain, String prefix) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        if (!isEmpty(prefix)) {
            this.result.write(prefix);
            this.result.write(58);
        }
        this.result.write(plain);
    }

    private void append(char ch) throws Exception {
        this.buffer.append(ch);
    }

    private void append(char[] plain) throws Exception {
        this.buffer.append(plain);
    }

    private void append(String plain) throws Exception {
        this.buffer.append(plain);
    }

    private void data(String value) throws Exception {
        write("<![CDATA[");
        write(value);
        write("]]>");
    }

    private void escape(String value) throws Exception {
        int size = value.length();
        for (int i = 0; i < size; i++) {
            escape(value.charAt(i));
        }
    }

    private void escape(char ch) throws Exception {
        char[] text = symbol(ch);
        if (text != null) {
            write(text);
        } else {
            write(ch);
        }
    }

    public void flush() throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.flush();
    }

    private String unicode(char ch) {
        return Integer.toString(ch);
    }

    private boolean isEmpty(String value) {
        if (value == null || value.length() == 0) {
            return true;
        }
        return false;
    }

    private boolean isText(char ch) {
        if (ch == 9 || ch == 10 || ch == 13 || ch == ' ') {
            return true;
        }
        if (ch <= ' ' || ch > '~') {
            return false;
        }
        if (ch != 247) {
            return true;
        }
        return false;
    }

    private char[] symbol(char ch) {
        if (ch == '\"') {
            return DOUBLE;
        }
        if (ch == '<') {
            return LESS;
        }
        if (ch == '>') {
            return GREATER;
        }
        if (ch == '&') {
            return AND;
        }
        if (ch != '\'') {
            return null;
        }
        return SINGLE;
    }
}
