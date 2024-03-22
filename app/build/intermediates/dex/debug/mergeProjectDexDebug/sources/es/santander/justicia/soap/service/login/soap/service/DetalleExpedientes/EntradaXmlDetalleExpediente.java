package es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes;

import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.ParamsRequestDetalleExpediente.DatosAccesoProfesionales;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class EntradaXmlDetalleExpediente implements KvmSerializable {
    private DatosAccesoProfesionales datosAccesoProfesionales;

    public EntradaXmlDetalleExpediente() {
    }

    public EntradaXmlDetalleExpediente(DatosAccesoProfesionales datosAccesoProfesionales2) {
        this.datosAccesoProfesionales = datosAccesoProfesionales2;
    }

    public Object getProperty(int index) {
        if (index != 0) {
            return null;
        }
        return this.datosAccesoProfesionales;
    }

    public int getPropertyCount() {
        return 1;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.datosAccesoProfesionales = (DatosAccesoProfesionales) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosAccesoProfesionales";
        }
    }
}
