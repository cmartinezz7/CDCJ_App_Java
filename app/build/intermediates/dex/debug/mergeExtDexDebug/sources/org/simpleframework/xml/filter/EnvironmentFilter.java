package org.simpleframework.xml.filter;

public class EnvironmentFilter implements Filter {
    private Filter filter;

    public EnvironmentFilter() {
        this((Filter) null);
    }

    public EnvironmentFilter(Filter filter2) {
        this.filter = filter2;
    }

    public String replace(String text) {
        String value = System.getenv(text);
        if (value != null) {
            return value;
        }
        Filter filter2 = this.filter;
        if (filter2 != null) {
            return filter2.replace(text);
        }
        return null;
    }
}
