package org.kobjects.pim;

import java.io.IOException;
import java.io.Reader;
import java.util.Vector;
import org.kobjects.io.LookAheadReader;

public class PimParser {
    LookAheadReader reader;
    Class type;

    public PimParser(Reader reader2, Class type2) {
        this.reader = new LookAheadReader(reader2);
        this.type = type2;
    }

    public PimItem readItem() throws IOException {
        Object value;
        String beg = readName();
        if (beg == null) {
            return null;
        }
        if (beg.equals("begin")) {
            try {
                PimItem item = (PimItem) this.type.newInstance();
                this.reader.read();
                if (item.getType().equals(readStringValue().toLowerCase())) {
                    while (true) {
                        String name = readName();
                        if (name.equals("end")) {
                            this.reader.read();
                            System.out.println("end:" + readStringValue());
                            return item;
                        }
                        PimField field = new PimField(name);
                        readProperties(field);
                        if (item.getType(name) != 1) {
                            value = readStringValue();
                        } else {
                            value = readArrayValue(item.getArraySize(name));
                        }
                        field.setValue(value);
                        System.out.println("value:" + value);
                        item.addField(field);
                    }
                } else {
                    throw new RuntimeException("item types do not match!");
                }
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        } else {
            throw new RuntimeException("'begin:' expected");
        }
    }

    /* access modifiers changed from: package-private */
    public String readName() throws IOException {
        String name = this.reader.readTo(":;").trim().toLowerCase();
        System.out.println("name:" + name);
        if (this.reader.peek(0) == -1) {
            return null;
        }
        return name;
    }

    /* access modifiers changed from: package-private */
    public String[] readArrayValue(int size) throws IOException {
        Vector values = new Vector();
        StringBuffer buf = new StringBuffer();
        boolean stay = true;
        do {
            buf.append(this.reader.readTo(";\n\r"));
            int read = this.reader.read();
            if (read != 10) {
                if (read != 13) {
                    if (read != 59) {
                        continue;
                    } else {
                        values.addElement(buf.toString());
                        buf.setLength(0);
                        continue;
                    }
                } else if (this.reader.peek(0) == 10) {
                    this.reader.read();
                }
            }
            if (this.reader.peek(0) != 32) {
                stay = false;
                continue;
            } else {
                this.reader.read();
                continue;
            }
        } while (stay);
        if (buf.length() != 0) {
            values.addElement(buf.toString());
        }
        String[] ret = new String[size];
        for (int i = 0; i < Math.min(ret.length, values.size()); i++) {
            ret[i] = (String) values.elementAt(i);
        }
        return ret;
    }

    /* access modifiers changed from: package-private */
    public String readStringValue() throws IOException {
        String value = this.reader.readLine();
        while (this.reader.peek(0) == 32) {
            this.reader.read();
            value = value + this.reader.readLine();
        }
        return value;
    }

    /* access modifiers changed from: package-private */
    public void readProperties(PimField field) throws IOException {
        int c;
        int c2 = this.reader.read();
        while (c == 32) {
            c2 = this.reader.read();
        }
        while (c != 58) {
            String name = this.reader.readTo(":;=").trim().toLowerCase();
            c = this.reader.read();
            if (c == 61) {
                field.setProperty(name, this.reader.readTo(":;").trim().toLowerCase());
                c = this.reader.read();
            } else {
                field.setAttribute(name, true);
            }
        }
    }
}
