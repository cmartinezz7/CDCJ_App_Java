package es.santander.justicia.soap.service.login.soap.service.petitions;

import es.santander.justicia.soap.service.login.soap.service.SoapPropertiesParser;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.soap.service.login.soap.service.petitions.params.FilterData;
import es.santander.justicia.soap.service.login.soap.service.petitions.params.ProfessionalDataAccess;
import org.ksoap2.serialization.PropertyInfo;

public class XmlBodyPetitionsRequest extends SoapPropertiesParser {
    public XmlBodyPetitionsRequest(ProfessionalDataAccess professionalDataAccess, FilterData filterData, DatosPaginacion paginationData) {
        if (professionalDataAccess != null) {
            createElement("datosAccesoProfesionales", (Object) PropertyInfo.OBJECT_CLASS, (Object) professionalDataAccess);
        }
        if (filterData != null) {
            createElement("datosFiltrado", (Object) PropertyInfo.OBJECT_CLASS, (Object) filterData);
        }
        if (paginationData != null) {
            createElement("datosPaginacion", (Object) PropertyInfo.OBJECT_CLASS, (Object) paginationData);
        }
    }
}
