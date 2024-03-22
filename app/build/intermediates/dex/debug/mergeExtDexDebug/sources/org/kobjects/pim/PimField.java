package org.kobjects.pim;

import java.util.Enumeration;
import java.util.Hashtable;

public class PimField {
    String name;
    Hashtable properties;
    Object value;

    public PimField(PimField orig) {
        this(orig.name);
        Object obj = orig.value;
        if (obj instanceof String[]) {
            String[] val = new String[((String[]) obj).length];
            System.arraycopy((String[]) obj, 0, val, 0, val.length);
            this.value = val;
        } else {
            this.value = obj;
        }
        if (orig.properties != null) {
            this.properties = new Hashtable();
            Enumeration e = orig.properties.keys();
            while (e.hasMoreElements()) {
                String name2 = (String) e.nextElement();
                this.properties.put(name2, orig.properties.get(name2));
            }
        }
    }

    public PimField(String name2) {
        this.name = name2;
    }

    public Enumeration propertyNames() {
        return this.properties.keys();
    }

    public void setProperty(String name2, String value2) {
        if (this.properties == null) {
            if (value2 != null) {
                this.properties = new Hashtable();
            } else {
                return;
            }
        }
        if (value2 == null) {
            this.properties.remove(name2);
        } else {
            this.properties.put(name2, value2);
        }
    }

    public void setValue(Object object) {
        this.value = object;
    }

    public Object getValue() {
        return this.value;
    }

    public String toString() {
        return this.name + (this.properties != null ? ";" + this.properties : "") + ":" + this.value;
    }

    public String getProperty(String name2) {
        Hashtable hashtable = this.properties;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(name2);
    }

    public boolean getAttribute(String name2) {
        String s = getProperty("type");
        return (s == null || s.indexOf(name2) == -1) ? false : true;
    }

    public void setAttribute(String name2, boolean value2) {
        if (getAttribute(name2) != value2) {
            String s = getProperty("type");
            if (!value2) {
                int i = s.indexOf(name2);
                if (i > 0) {
                    i--;
                }
                if (i != -1) {
                    s = s.substring(0, i) + s.substring(name2.length() + i + 1);
                }
            } else if (s == null || s.length() == 0) {
                s = name2;
            } else {
                s = s + name2;
            }
            setProperty("type", s);
        }
    }
}
