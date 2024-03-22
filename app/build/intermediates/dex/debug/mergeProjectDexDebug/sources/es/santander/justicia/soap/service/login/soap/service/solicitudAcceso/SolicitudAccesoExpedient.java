package es.santander.justicia.soap.service.login.soap.service.solicitudAcceso;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class SolicitudAccesoExpedient implements KvmSerializable {
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private String part5;

    public SolicitudAccesoExpedient() {
    }

    public SolicitudAccesoExpedient(String part12, String part22, String part32, String part42, String part52) {
        this.part1 = part12;
        this.part2 = part22;
        this.part3 = part32;
        this.part4 = part42;
        this.part5 = part52;
    }

    public void setPart1(String part12) {
        this.part1 = part12;
    }

    public void setPart2(String part22) {
        this.part2 = part22;
    }

    public void setPart3(String part32) {
        this.part3 = part32;
    }

    public void setPart4(String part42) {
        this.part4 = part42;
    }

    public void setPart5(String part52) {
        this.part5 = part52;
    }

    public String getPart1() {
        return this.part1;
    }

    public String getPart2() {
        return this.part2;
    }

    public String getPart3() {
        return this.part3;
    }

    public String getPart4() {
        return this.part4;
    }

    public String getPart5() {
        return this.part5;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.part1;
        }
        if (index == 1) {
            return this.part2;
        }
        if (index == 2) {
            return this.part3;
        }
        if (index == 3) {
            return this.part4;
        }
        if (index != 4) {
            return null;
        }
        return this.part5;
    }

    public int getPropertyCount() {
        return 4;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.part1 = (String) value;
        } else if (index != 1) {
            if (index != 2) {
                if (index != 3) {
                    if (index != 4) {
                        return;
                    }
                    this.part5 = (String) value;
                }
                this.part4 = (String) value;
                this.part5 = (String) value;
            }
            this.part3 = (String) value;
            this.part4 = (String) value;
            this.part5 = (String) value;
        }
        this.part2 = (String) value;
        this.part3 = (String) value;
        this.part4 = (String) value;
        this.part5 = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "parte1";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "parte2";
        } else if (index == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "parte3";
        } else if (index == 3) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "parte4";
        } else if (index == 4) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "parte5";
        }
    }
}
