package es.santander.justicia.soap.service.login.soap.service.courtDetail;

import es.santander.justicia.soap.service.login.soap.service.courtDetail.params.CourtData;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class XmlBodyCourtDetailRequest implements KvmSerializable {
    public CourtData courtData;

    public XmlBodyCourtDetailRequest(CourtData courtData2) {
        this.courtData = courtData2;
    }

    public Object getProperty(int index) {
        if (index != 0) {
            return null;
        }
        return this.courtData;
    }

    public int getPropertyCount() {
        return 1;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.courtData = (CourtData) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosJuzgado";
        }
    }
}
