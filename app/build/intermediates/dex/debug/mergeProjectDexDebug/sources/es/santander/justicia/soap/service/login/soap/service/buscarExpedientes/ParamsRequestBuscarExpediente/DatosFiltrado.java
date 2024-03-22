package es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ParamsRequestBuscarExpediente;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosFiltrado implements KvmSerializable {
    private String jfechaDe;
    private String jfechaHasta;

    public DatosFiltrado() {
    }

    public DatosFiltrado(String jfechaDe2, String jfechaHasta2) {
        this.jfechaDe = jfechaDe2;
        this.jfechaHasta = jfechaHasta2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.jfechaDe;
        }
        if (index != 1) {
            return null;
        }
        return this.jfechaHasta;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.jfechaDe = (String) value;
        } else if (index != 1) {
            return;
        }
        this.jfechaHasta = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jfechareDe";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jfechareHasta";
        }
    }
}
