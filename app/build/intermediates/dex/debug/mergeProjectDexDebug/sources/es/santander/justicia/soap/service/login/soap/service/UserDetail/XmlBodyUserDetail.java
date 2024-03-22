package es.santander.justicia.soap.service.login.soap.service.UserDetail;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class XmlBodyUserDetail implements KvmSerializable {
    public Object getProperty(int index) {
        if (index != 0) {
            return null;
        }
        return "";
    }

    public int getPropertyCount() {
        return 1;
    }

    public void setProperty(int index, Object value) {
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
    }
}
