package es.santander.justicia.soap.service.login.soap.service.buscarExpedientes;

import es.santander.justicia.soap.service.login.soap.service.SoapPropertiesParser;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ParamsRequestBuscarExpediente.DatosAcesooProfesionalesBuscar;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.soap.service.login.soap.service.petitions.params.FilterData;
import org.ksoap2.serialization.PropertyInfo;

public class XmlBodyExpedientsRequest extends SoapPropertiesParser {
    public XmlBodyExpedientsRequest(DatosAcesooProfesionalesBuscar professionalDataAccess, FilterData filterData, DatosPaginacion paginationData) {
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
