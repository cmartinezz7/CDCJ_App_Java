package es.santander.justicia.soap.service.login.soap.service.courtSearcher.params;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class PlaceData implements KvmSerializable {
    public String codPlaza;
    public String codProva;
    public String desPlaza;

    public PlaceData(String codPlaza2, String desPlaza2, String codProva2) {
        this.codPlaza = codPlaza2;
        this.desPlaza = desPlaza2;
        this.codProva = codProva2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.codPlaza;
        }
        if (index == 1) {
            return this.desPlaza;
        }
        if (index != 2) {
            return null;
        }
        return this.codProva;
    }

    public int getPropertyCount() {
        return 3;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.codPlaza = (String) value;
        } else if (index == 1) {
            this.desPlaza = (String) value;
        } else if (index == 2) {
            this.codProva = (String) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "codplaza";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "desplaza";
        } else if (index == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "codprova";
        }
    }
}
