package org.simpleframework.xml.stream;

abstract class Splitter {
    protected StringBuilder builder = new StringBuilder();
    protected int count;
    protected int off;
    protected char[] text;

    /* access modifiers changed from: protected */
    public abstract void commit(char[] cArr, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void parse(char[] cArr, int i, int i2);

    public Splitter(String source) {
        char[] charArray = source.toCharArray();
        this.text = charArray;
        this.count = charArray.length;
    }

    public String process() {
        while (this.off < this.count) {
            while (true) {
                int i = this.off;
                if (i < this.count && isSpecial(this.text[i])) {
                    this.off++;
                }
            }
            if (!acronym()) {
                token();
                number();
            }
        }
        return this.builder.toString();
    }

    private void token() {
        int mark = this.off;
        while (mark < this.count) {
            char ch = this.text[mark];
            if (!isLetter(ch) || (mark > this.off && isUpper(ch))) {
                break;
            }
            mark++;
        }
        int i = this.off;
        if (mark > i) {
            parse(this.text, i, mark - i);
            char[] cArr = this.text;
            int i2 = this.off;
            commit(cArr, i2, mark - i2);
        }
        this.off = mark;
    }

    private boolean acronym() {
        int mark = this.off;
        int size = 0;
        while (mark < this.count && isUpper(this.text[mark])) {
            size++;
            mark++;
        }
        if (size > 1) {
            if (mark < this.count && isUpper(this.text[mark - 1])) {
                mark--;
            }
            char[] cArr = this.text;
            int i = this.off;
            commit(cArr, i, mark - i);
            this.off = mark;
        }
        if (size > 1) {
            return true;
        }
        return false;
    }

    private boolean number() {
        int mark = this.off;
        int size = 0;
        while (mark < this.count && isDigit(this.text[mark])) {
            size++;
            mark++;
        }
        if (size > 0) {
            char[] cArr = this.text;
            int i = this.off;
            commit(cArr, i, mark - i);
        }
        this.off = mark;
        return size > 0;
    }

    private boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    private boolean isSpecial(char ch) {
        return !Character.isLetterOrDigit(ch);
    }

    private boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    private boolean isUpper(char ch) {
        return Character.isUpperCase(ch);
    }

    /* access modifiers changed from: protected */
    public char toUpper(char ch) {
        return Character.toUpperCase(ch);
    }

    /* access modifiers changed from: protected */
    public char toLower(char ch) {
        return Character.toLowerCase(ch);
    }
}
