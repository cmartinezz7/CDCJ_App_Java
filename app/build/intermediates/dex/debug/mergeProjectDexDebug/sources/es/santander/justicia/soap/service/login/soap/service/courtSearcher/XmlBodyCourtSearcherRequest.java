package es.santander.justicia.soap.service.login.soap.service.courtSearcher;

import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.soap.service.login.soap.service.courtSearcher.params.CourtData;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class XmlBodyCourtSearcherRequest implements KvmSerializable {
    public CourtData courtData;
    public DatosPaginacion paginationData;

    public XmlBodyCourtSearcherRequest(CourtData courtData2, DatosPaginacion paginationData2) {
        this.courtData = courtData2;
        this.paginationData = paginationData2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.courtData;
        }
        if (index != 1) {
            return null;
        }
        return this.paginationData;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.courtData = (CourtData) value;
        } else if (index == 1) {
            this.paginationData = (DatosPaginacion) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosJuzgado";
        } else if (index == 1) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosPaginacion";
        }
    }
}
