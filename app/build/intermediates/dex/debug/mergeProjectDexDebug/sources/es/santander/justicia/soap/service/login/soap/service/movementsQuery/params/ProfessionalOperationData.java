package es.santander.justicia.soap.service.login.soap.service.movementsQuery.params;

import es.santander.justicia.soap.service.login.soap.service.SoapPropertiesParser;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
import org.ksoap2.serialization.PropertyInfo;

public class ProfessionalOperationData extends SoapPropertiesParser {
    public ProfessionalOperationData(DatosExpediente fileData, String codmon, String jtipomod) {
        if (fileData != null) {
            createElement("datosExpediente", (Object) PropertyInfo.OBJECT_CLASS, (Object) fileData);
        }
        if (!codmon.isEmpty()) {
            createElement("codmon", (Object) PropertyInfo.STRING_CLASS, codmon);
        }
        if (!jtipomod.isEmpty()) {
            createElement("jtipomod", (Object) PropertyInfo.STRING_CLASS, jtipomod);
        }
    }
}
