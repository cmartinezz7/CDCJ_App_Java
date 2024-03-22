package org.simpleframework.xml.filter;

import java.util.Map;

public class MapFilter implements Filter {
    private Filter filter;
    private Map map;

    public MapFilter(Map map2) {
        this(map2, (Filter) null);
    }

    public MapFilter(Map map2, Filter filter2) {
        this.filter = filter2;
        this.map = map2;
    }

    public String replace(String text) {
        Object value = null;
        Map map2 = this.map;
        if (map2 != null) {
            value = map2.get(text);
        }
        if (value != null) {
            return value.toString();
        }
        Filter filter2 = this.filter;
        if (filter2 != null) {
            return filter2.replace(text);
        }
        return null;
    }
}
