package es.santander.justicia.soap.service.login.soap.service.ListaPeticiones.ParamsRequestListPetition;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosFiltradoPetition implements KvmSerializable {
    private String jfechaDe;
    private String jfechaHasta;
    private String tipsel;

    public DatosFiltradoPetition() {
    }

    public DatosFiltradoPetition(String jfechaDe2, String jfechaHasta2, String tipsel2) {
        this.jfechaDe = jfechaDe2;
        this.jfechaHasta = jfechaHasta2;
        this.tipsel = tipsel2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.jfechaDe;
        }
        if (index == 1) {
            return this.jfechaHasta;
        }
        if (index != 2) {
            return null;
        }
        return this.tipsel;
    }

    public int getPropertyCount() {
        return 3;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.jfechaDe = (String) value;
        } else if (index != 1) {
            if (index != 2) {
                return;
            }
            this.tipsel = (String) value;
        }
        this.jfechaHasta = (String) value;
        this.tipsel = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jfechareDe";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "jfechareHasta";
        } else if (index == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "tipsel";
        }
    }
}
