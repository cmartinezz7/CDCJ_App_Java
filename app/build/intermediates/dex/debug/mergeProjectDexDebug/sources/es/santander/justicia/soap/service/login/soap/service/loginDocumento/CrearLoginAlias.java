package es.santander.justicia.soap.service.login.soap.service.loginDocumento;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class CrearLoginAlias implements KvmSerializable {
    private String alias;
    private String password;

    public CrearLoginAlias() {
    }

    public CrearLoginAlias(String alias2, String password2) {
        this.alias = alias2;
        this.password = password2;
    }

    public void setAlias(String alias2) {
        this.alias = alias2;
    }

    public void setPassword(String password2) {
        this.password = password2;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getPassword() {
        return this.password;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.alias;
        }
        if (index != 1) {
            return null;
        }
        return this.password;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.alias = (String) value;
        } else if (index != 1) {
            return;
        }
        this.password = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "alias";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "password";
        }
    }
}
