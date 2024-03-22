package es.santander.justicia.soap.service.login.soap.service.commonParams;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosPaginacion implements KvmSerializable {
    private String numeroPagina;
    private String tamannoPagina;

    public DatosPaginacion() {
    }

    public DatosPaginacion(String numeroPagina2, String tamannoPagina2) {
        this.numeroPagina = numeroPagina2;
        this.tamannoPagina = tamannoPagina2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.numeroPagina;
        }
        if (index != 1) {
            return null;
        }
        return this.tamannoPagina;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.numeroPagina = (String) value;
        } else if (index == 1) {
            this.tamannoPagina = (String) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "numeroPagina";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "tamannoPagina";
        }
    }
}
