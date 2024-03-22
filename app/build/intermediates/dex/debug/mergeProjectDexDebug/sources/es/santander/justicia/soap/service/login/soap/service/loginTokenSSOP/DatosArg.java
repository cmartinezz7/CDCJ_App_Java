package es.santander.justicia.soap.service.login.soap.service.loginTokenSSOP;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosArg implements KvmSerializable {
    private String acceso;
    private String token;

    public DatosArg() {
    }

    public DatosArg(String acceso2, String token2) {
        this.acceso = acceso2;
        this.token = token2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.acceso;
        }
        if (index != 1) {
            return null;
        }
        return this.token;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.acceso = (String) value;
        } else if (index != 1) {
            return;
        }
        this.token = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "acceso";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "token";
        }
    }
}
