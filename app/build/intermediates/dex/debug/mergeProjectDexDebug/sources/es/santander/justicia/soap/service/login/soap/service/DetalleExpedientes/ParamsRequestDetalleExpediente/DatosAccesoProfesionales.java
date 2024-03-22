package es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.ParamsRequestDetalleExpediente;

import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosAccesoProfesionales implements KvmSerializable {
    private DatosExpediente datosExpediente;
    private String motsolic;

    public DatosAccesoProfesionales() {
    }

    public DatosAccesoProfesionales(DatosExpediente datosExpediente2) {
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
            this.datosExpediente = (DatosExpediente) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosExpediente";
        }
    }
}
