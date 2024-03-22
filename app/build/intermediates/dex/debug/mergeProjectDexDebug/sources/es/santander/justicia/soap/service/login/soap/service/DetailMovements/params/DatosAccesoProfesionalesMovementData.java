package es.santander.justicia.soap.service.login.soap.service.DetailMovements.params;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosAccesoProfesionalesMovementData implements KvmSerializable {
    private DatosExpedienteDetail datosExpediente;
    private String jnuoper;

    public DatosAccesoProfesionalesMovementData(DatosExpedienteDetail datosExpediente2, String jnuoper2) {
        this.datosExpediente = datosExpediente2;
        this.jnuoper = jnuoper2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.datosExpediente;
        }
        if (index != 1) {
            return null;
        }
        return this.jnuoper;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.datosExpediente = (DatosExpedienteDetail) value;
        } else if (index != 1) {
            return;
        }
        this.jnuoper = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosExpediente";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jnuoper";
        }
    }
}
