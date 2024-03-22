package es.santander.justicia.soap.service.login.soap.service.solicitudAcceso;

import es.santander.justicia.soap.service.login.soap.service.solicitudAcceso.params.DatosAccesoProfesionales;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class XmlBodyAccessRequest implements KvmSerializable {
    private DatosAccesoProfesionales datosAcessoProfesionales;

    public XmlBodyAccessRequest(DatosAccesoProfesionales datosAcessoProfesionales2) {
        this.datosAcessoProfesionales = datosAcessoProfesionales2;
    }

    public Object getProperty(int index) {
        if (index != 0) {
            return null;
        }
        return this.datosAcessoProfesionales;
    }

    public int getPropertyCount() {
        return 1;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.datosAcessoProfesionales = (DatosAccesoProfesionales) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosAccesoProfesionales";
        }
    }
}
