package org.kobjects.rss;

import com.santander.globile.uicomponents.errorhandling.common.ConstantsKt;
import java.io.IOException;
import java.io.Reader;
import org.kobjects.xml.XmlReader;

public class RssReader {
    public static final int AUTHOR = 4;
    public static final int DATE = 3;
    public static final int DESCRIPTION = 2;
    public static final int LINK = 1;
    public static final int TITLE = 0;
    XmlReader xr;

    public RssReader(Reader reader) throws IOException {
        this.xr = new XmlReader(reader);
    }

    /* access modifiers changed from: package-private */
    public void readText(StringBuffer buf) throws IOException {
        while (this.xr.next() != 3) {
            int type = this.xr.getType();
            if (type == 2) {
                readText(buf);
            } else if (type == 4) {
                buf.append(this.xr.getText());
            }
        }
    }

    public String[] next() throws IOException {
        String[] item = new String[5];
        while (this.xr.next() != 1) {
            if (this.xr.getType() == 2) {
                String n = this.xr.getName().toLowerCase();
                if (n.equals("item") || n.endsWith(":item")) {
                    while (this.xr.next() != 3) {
                        if (this.xr.getType() == 2) {
                            String name = this.xr.getName().toLowerCase();
                            int cut = name.indexOf(":");
                            if (cut != -1) {
                                name = name.substring(cut + 1);
                            }
                            StringBuffer buf = new StringBuffer();
                            readText(buf);
                            String text = buf.toString();
                            if (name.equals(ConstantsKt.TITLE_TEXT)) {
                                item[0] = text;
                            } else if (name.equals("link")) {
                                item[1] = text;
                            } else if (name.equals("description")) {
                                item[2] = text;
                            } else if (name.equals("date")) {
                                item[3] = text;
                            } else if (name.equals("author")) {
                                item[4] = text;
                            }
                        }
                    }
                    return item;
                }
            }
        }
        return null;
    }
}
