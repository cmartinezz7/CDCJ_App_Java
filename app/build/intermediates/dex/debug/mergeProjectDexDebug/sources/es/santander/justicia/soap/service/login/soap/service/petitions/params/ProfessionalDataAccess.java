package es.santander.justicia.soap.service.login.soap.service.petitions.params;

import es.santander.justicia.soap.service.login.soap.service.SoapPropertiesParser;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
import org.ksoap2.serialization.PropertyInfo;

public class ProfessionalDataAccess extends SoapPropertiesParser {
    public ProfessionalDataAccess(DatosExpediente expedientData, String petitionStatus) {
        if (expedientData != null) {
            createElement("datosExpediente", (Object) PropertyInfo.OBJECT_CLASS, (Object) expedientData);
        }
        if (!petitionStatus.isEmpty()) {
            createElement("jestpeti", (Object) PropertyInfo.STRING_CLASS, petitionStatus);
        }
    }
}
