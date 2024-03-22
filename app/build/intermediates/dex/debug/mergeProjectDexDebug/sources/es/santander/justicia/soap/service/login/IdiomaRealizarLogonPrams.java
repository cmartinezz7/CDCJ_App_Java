package es.santander.justicia.soap.service.login;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class IdiomaRealizarLogonPrams implements KvmSerializable {
    private String DIALECTO_ISO;
    private String IDIOMA_ISO;

    public IdiomaRealizarLogonPrams() {
    }

    public IdiomaRealizarLogonPrams(String IDIOMA_ISO2, String DIALECTO_ISO2) {
        this.IDIOMA_ISO = IDIOMA_ISO2;
        this.DIALECTO_ISO = DIALECTO_ISO2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.IDIOMA_ISO;
        }
        if (index != 1) {
            return null;
        }
        return this.DIALECTO_ISO;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.IDIOMA_ISO = (String) value;
        } else if (index != 1) {
            return;
        }
        this.DIALECTO_ISO = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "IDIOMA_ISO";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DIALECTO_ISO";
        }
    }
}
