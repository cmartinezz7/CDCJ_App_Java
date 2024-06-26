package org.simpleframework.xml.stream;

public class CamelCaseStyle implements Style {
    private final Builder builder;
    private final Style style;

    public CamelCaseStyle() {
        this(true, false);
    }

    public CamelCaseStyle(boolean element) {
        this(element, false);
    }

    public CamelCaseStyle(boolean element, boolean attribute) {
        CamelCaseBuilder camelCaseBuilder = new CamelCaseBuilder(element, attribute);
        this.style = camelCaseBuilder;
        this.builder = new Builder(camelCaseBuilder);
    }

    public String getAttribute(String name) {
        return this.builder.getAttribute(name);
    }

    public void setAttribute(String name, String value) {
        this.builder.setAttribute(name, value);
    }

    public String getElement(String name) {
        return this.builder.getElement(name);
    }

    public void setElement(String name, String value) {
        this.builder.setElement(name, value);
    }
}
