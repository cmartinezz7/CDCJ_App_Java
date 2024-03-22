package es.santander.justicia.soap.service.login.soap.service.loginAlias;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class CB_AuthenticationData implements KvmSerializable {
    private String alias;
    private String password;

    public CB_AuthenticationData() {
    }

    public CB_AuthenticationData(String password2, String alias2) {
        this.password = password2;
        this.alias = alias2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.password;
        }
        if (index != 1) {
            return null;
        }
        return this.alias;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.password = (String) value;
        } else if (index != 1) {
            return;
        }
        this.alias = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "password";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "alias";
        }
    }
}
