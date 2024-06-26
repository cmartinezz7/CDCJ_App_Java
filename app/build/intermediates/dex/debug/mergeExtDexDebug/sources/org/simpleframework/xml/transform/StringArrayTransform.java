package org.simpleframework.xml.transform;

import java.util.regex.Pattern;

class StringArrayTransform implements Transform<String[]> {
    private final Pattern pattern;
    private final String token;

    public StringArrayTransform() {
        this(",");
    }

    public StringArrayTransform(String token2) {
        this.pattern = Pattern.compile(token2);
        this.token = token2;
    }

    public String[] read(String value) {
        return read(value, this.token);
    }

    private String[] read(String value, String token2) {
        String[] list = this.pattern.split(value);
        for (int i = 0; i < list.length; i++) {
            String text = list[i];
            if (text != null) {
                list[i] = text.trim();
            }
        }
        return list;
    }

    public String write(String[] list) {
        return write(list, this.token);
    }

    private String write(String[] list, String token2) {
        StringBuilder text = new StringBuilder();
        for (String item : list) {
            if (item != null) {
                if (text.length() > 0) {
                    text.append(token2);
                    text.append(' ');
                }
                text.append(item);
            }
        }
        return text.toString();
    }
}
