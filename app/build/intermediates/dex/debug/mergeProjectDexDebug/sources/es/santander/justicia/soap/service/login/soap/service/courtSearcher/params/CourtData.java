package es.santander.justicia.soap.service.login.soap.service.courtSearcher.params;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class CourtData implements KvmSerializable {
    public String codEntJa;
    public String codEst;
    public String codProva;
    public PlaceData placeData;

    public CourtData(String codProva2, String codEntJa2, String codEst2, PlaceData placeData2) {
        this.codProva = codProva2;
        this.codEntJa = codEntJa2;
        this.codEst = codEst2;
        this.placeData = placeData2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.codProva;
        }
        if (index == 1) {
            return this.codEntJa;
        }
        if (index == 2) {
            return this.codEst;
        }
        if (index != 3) {
            return null;
        }
        return this.placeData;
    }

    public int getPropertyCount() {
        return 4;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.codProva = (String) value;
        } else if (index == 1) {
            this.codEntJa = (String) value;
        } else if (index == 2) {
            this.codEst = (String) value;
        } else if (index == 3) {
            this.placeData = (PlaceData) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "codprova";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "codentja";
        } else if (index == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "codest";
        } else if (index == 3) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosPlaza";
        }
    }
}
