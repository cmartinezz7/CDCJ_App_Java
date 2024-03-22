package es.santander.justicia.soap.service.login;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosConexionRealziarLoginParams implements KvmSerializable {
    private String canalMarco;
    private String empresa;

    public DatosConexionRealziarLoginParams() {
    }

    public DatosConexionRealziarLoginParams(String canalMarco2, String empresa2) {
        this.canalMarco = canalMarco2;
        this.empresa = empresa2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.canalMarco;
        }
        if (index != 1) {
            return null;
        }
        return this.empresa;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.canalMarco = (String) value;
        } else if (index != 1) {
            return;
        }
        this.empresa = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "canalMarco";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "empresa";
        }
    }
}
