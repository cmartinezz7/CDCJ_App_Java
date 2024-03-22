package es.santander.justicia.soap.service.login.soap.service.solicitudAcceso.params;

import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosAccesoProfesionales implements KvmSerializable {
    private DatosExpediente datosExpediente;
    private String motsolic;

    public DatosAccesoProfesionales() {
    }

    public DatosAccesoProfesionales(DatosExpediente datosExpediente2, String motsolic2) {
        this.datosExpediente = datosExpediente2;
        this.motsolic = motsolic2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.datosExpediente;
        }
        if (index != 1) {
            return null;
        }
        return this.motsolic;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.datosExpediente = (DatosExpediente) value;
        } else if (index != 1) {
            return;
        }
        this.motsolic = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosExpediente";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "motsolic";
        }
    }
}
