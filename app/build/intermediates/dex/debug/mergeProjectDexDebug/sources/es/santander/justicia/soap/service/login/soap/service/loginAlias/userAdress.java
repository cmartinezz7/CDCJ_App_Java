package es.santander.justicia.soap.service.login.soap.service.loginAlias;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class userAdress implements KvmSerializable {
    private String userAddress;

    public userAdress() {
    }

    public userAdress(String userAddress2) {
        this.userAddress = userAddress2;
    }

    public Object getProperty(int index) {
        if (index != 0) {
            return null;
        }
        return this.userAddress;
    }

    public int getPropertyCount() {
        return 1;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.userAddress = (String) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "userAddress";
        }
    }
}
