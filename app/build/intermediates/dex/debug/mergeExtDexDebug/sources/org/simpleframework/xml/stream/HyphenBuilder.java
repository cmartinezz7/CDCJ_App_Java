package org.simpleframework.xml.stream;

class HyphenBuilder implements Style {
    HyphenBuilder() {
    }

    public String getAttribute(String name) {
        if (name != null) {
            return new Parser(name).process();
        }
        return null;
    }

    public String getElement(String name) {
        if (name != null) {
            return new Parser(name).process();
        }
        return null;
    }

    private class Parser extends Splitter {
        private Parser(String source) {
            super(source);
        }

        /* access modifiers changed from: protected */
        public void parse(char[] text, int off, int len) {
            text[off] = toLower(text[off]);
        }

        /* access modifiers changed from: protected */
        public void commit(char[] text, int off, int len) {
            this.builder.append(text, off, len);
            if (off + len < this.count) {
                this.builder.append('-');
            }
        }
    }
}
