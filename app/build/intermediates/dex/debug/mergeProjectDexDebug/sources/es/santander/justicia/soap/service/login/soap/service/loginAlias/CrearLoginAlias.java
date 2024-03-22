package es.santander.justicia.soap.service.login.soap.service.loginAlias;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class CrearLoginAlias implements KvmSerializable {
    private String part1;
    private String part2;

    public CrearLoginAlias() {
    }

    public CrearLoginAlias(String part12, String part22) {
        this.part1 = part12;
        this.part2 = part22;
    }

    public void setPart1(String part12) {
        this.part1 = part12;
    }

    public void setPart2(String part22) {
        this.part2 = part22;
    }

    public String getPart1() {
        return this.part1;
    }

    public String getPart2() {
        return this.part2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.part1;
        }
        if (index != 1) {
            return null;
        }
        return this.part2;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.part1 = (String) value;
        } else if (index != 1) {
            return;
        }
        this.part2 = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "parte1";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "parte2";
        }
    }
}
