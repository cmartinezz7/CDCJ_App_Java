package org.simpleframework.xml.stream;

class Indenter {
    private Cache cache;
    private int count;
    private int indent;
    private int index;

    public Indenter() {
        this(new Format());
    }

    public Indenter(Format format) {
        this(format, 16);
    }

    private Indenter(Format format, int size) {
        this.indent = format.getIndent();
        this.cache = new Cache(size);
    }

    public String top() {
        return indent(this.index);
    }

    public String push() {
        int i = this.index;
        this.index = i + 1;
        String text = indent(i);
        int i2 = this.indent;
        if (i2 > 0) {
            this.count += i2;
        }
        return text;
    }

    public String pop() {
        int i = this.index - 1;
        this.index = i;
        String text = indent(i);
        int i2 = this.indent;
        if (i2 > 0) {
            this.count -= i2;
        }
        return text;
    }

    private String indent(int index2) {
        if (this.indent <= 0) {
            return "";
        }
        String text = this.cache.get(index2);
        if (text == null) {
            text = create();
            this.cache.set(index2, text);
        }
        if (this.cache.size() > 0) {
            return text;
        }
        return "";
    }

    private String create() {
        int i = this.count;
        char[] text = new char[(i + 1)];
        if (i <= 0) {
            return "\n";
        }
        text[0] = 10;
        for (int i2 = 1; i2 <= this.count; i2++) {
            text[i2] = ' ';
        }
        return new String(text);
    }

    private static class Cache {
        private int count;
        private String[] list;

        public Cache(int size) {
            this.list = new String[size];
        }

        public int size() {
            return this.count;
        }

        public void set(int index, String text) {
            if (index >= this.list.length) {
                resize(index * 2);
            }
            if (index > this.count) {
                this.count = index;
            }
            this.list[index] = text;
        }

        public String get(int index) {
            String[] strArr = this.list;
            if (index < strArr.length) {
                return strArr[index];
            }
            return null;
        }

        private void resize(int size) {
            String[] temp = new String[size];
            int i = 0;
            while (true) {
                String[] strArr = this.list;
                if (i < strArr.length) {
                    temp[i] = strArr[i];
                    i++;
                } else {
                    this.list = temp;
                    return;
                }
            }
        }
    }
}
