package es.santander.justicia.soap.service.login.soap.service.movementsQuery;

import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.soap.service.login.soap.service.movementsQuery.params.FilterData;
import es.santander.justicia.soap.service.login.soap.service.movementsQuery.params.ProfessionalOperationData;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class XmlBodyMovementsQuery implements KvmSerializable {
    public FilterData filterData;
    public DatosPaginacion paginationData;
    public ProfessionalOperationData professionalOperationData;

    public XmlBodyMovementsQuery(FilterData filterData2, ProfessionalOperationData professionalOperationData2, DatosPaginacion paginationData2) {
        this.filterData = filterData2;
        this.professionalOperationData = professionalOperationData2;
        this.paginationData = paginationData2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.filterData;
        }
        if (index == 1) {
            return this.professionalOperationData;
        }
        if (index != 2) {
            return null;
        }
        return this.paginationData;
    }

    public int getPropertyCount() {
        return 3;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.filterData = (FilterData) value;
        } else if (index == 1) {
            this.professionalOperationData = (ProfessionalOperationData) value;
        } else if (index == 2) {
            this.paginationData = (DatosPaginacion) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "datosFiltrado";
        } else if (index == 1) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosOperacionProfesionales";
        } else if (index == 2) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosPaginacion";
        }
    }
}
