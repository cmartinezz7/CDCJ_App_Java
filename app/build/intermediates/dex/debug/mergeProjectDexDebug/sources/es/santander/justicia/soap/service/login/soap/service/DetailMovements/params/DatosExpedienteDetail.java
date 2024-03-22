package es.santander.justicia.soap.service.login.soap.service.DetailMovements.params;

import es.santander.justicia.utils.Constants;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosExpedienteDetail implements KvmSerializable {
    private String juzga;

    public DatosExpedienteDetail(String juzga2) {
        this.juzga = juzga2;
    }

    public Object getProperty(int index) {
        if (index != 0) {
            return null;
        }
        return this.juzga;
    }

    public int getPropertyCount() {
        return 1;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.juzga = (String) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = Constants.EXPEDIENT_JUZGA;
        }
    }
}
