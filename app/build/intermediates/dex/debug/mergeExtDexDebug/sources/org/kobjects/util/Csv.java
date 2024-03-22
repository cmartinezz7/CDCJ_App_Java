package org.kobjects.util;

import java.util.Vector;
import kotlin.text.Typography;

public class Csv {
    public static String encode(String value, char quote) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == quote || c == '^') {
                buf.append(c);
                buf.append(c);
            } else if (c < ' ') {
                buf.append('^');
                buf.append((char) (c + '@'));
            } else {
                buf.append(c);
            }
        }
        return buf.toString();
    }

    public static String encode(Object[] values) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            if (i != 0) {
                buf.append(',');
            }
            Object v = values[i];
            if ((v instanceof Number) || (v instanceof Boolean)) {
                buf.append(v.toString());
            } else {
                buf.append(Typography.quote);
                buf.append(encode(v.toString(), Typography.quote));
                buf.append(Typography.quote);
            }
        }
        return buf.toString();
    }

    public static String[] decode(String line) {
        int p0;
        Vector tmp = new Vector();
        int p02 = 0;
        int len = line.length();
        while (true) {
            if (p02 >= len || line.charAt(p02) > ' ') {
                if (p02 >= len) {
                    break;
                } else if (line.charAt(p02) == '\"') {
                    int p03 = p02 + 1;
                    StringBuffer buf = new StringBuffer();
                    while (true) {
                        p0 = p03 + 1;
                        char c = line.charAt(p03);
                        if (c != '^' || p0 >= len) {
                            if (c == '\"') {
                                if (p0 == len || line.charAt(p0) != '\"') {
                                    tmp.addElement(buf.toString());
                                    int p04 = p0;
                                } else {
                                    p0++;
                                }
                            }
                            buf.append(c);
                            p03 = p0;
                        } else {
                            int p05 = p0 + 1;
                            char c2 = line.charAt(p0);
                            buf.append(c2 == '^' ? c2 : (char) (c2 - '@'));
                            p03 = p05;
                        }
                    }
                    tmp.addElement(buf.toString());
                    int p042 = p0;
                    while (p042 < len && line.charAt(p042) <= ' ') {
                        p042++;
                    }
                    if (p042 >= len) {
                        break;
                    } else if (line.charAt(p042) == ',') {
                        p02 = p042 + 1;
                    } else {
                        throw new RuntimeException("Comma expected at " + p042 + " line: " + line);
                    }
                } else {
                    int p1 = line.indexOf(44, p02);
                    if (p1 == -1) {
                        tmp.addElement(line.substring(p02).trim());
                        break;
                    }
                    tmp.addElement(line.substring(p02, p1).trim());
                    p02 = p1 + 1;
                }
            } else {
                p02++;
            }
        }
        String[] result = new String[tmp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (String) tmp.elementAt(i);
        }
        return result;
    }
}
