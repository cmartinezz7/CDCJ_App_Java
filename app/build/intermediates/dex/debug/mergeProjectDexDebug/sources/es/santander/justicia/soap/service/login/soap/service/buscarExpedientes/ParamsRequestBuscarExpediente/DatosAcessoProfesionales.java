package es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ParamsRequestBuscarExpediente;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosAcessoProfesionales implements KvmSerializable {
    private String datosExpediente;

    public DatosAcessoProfesionales() {
    }

    public DatosAcessoProfesionales(String datosExpediente2) {
        this.datosExpediente = datosExpediente2;
    }

    public Object getProperty(int index) {
        if (index != 0) {
            return null;
        }
        return this.datosExpediente;
    }

    public int getPropertyCount() {
        return 1;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.datosExpediente = (String) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "datosExpediente";
        }
    }
}
