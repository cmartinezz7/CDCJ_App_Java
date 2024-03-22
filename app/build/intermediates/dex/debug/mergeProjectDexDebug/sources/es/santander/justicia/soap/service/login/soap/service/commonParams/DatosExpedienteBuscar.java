package es.santander.justicia.soap.service.login.soap.service.commonParams;

import es.santander.justicia.soap.service.login.soap.service.SoapPropertiesParser;
import es.santander.justicia.utils.Constants;
import org.ksoap2.serialization.PropertyInfo;

public class DatosExpedienteBuscar extends SoapPropertiesParser {
    public DatosExpedienteBuscar(String juzga, String juzgori, String jnumexp, String jproced, String janoapex, String situationType, String currencyType) {
        if (!juzga.isEmpty()) {
            createElement(Constants.EXPEDIENT_JUZGA, (Object) PropertyInfo.STRING_CLASS, juzga);
        }
        if (!juzgori.isEmpty()) {
            createElement(Constants.EXPEDIENT_JUZGORI, (Object) PropertyInfo.STRING_CLASS, juzgori);
        }
        if (!jnumexp.isEmpty()) {
            createElement(Constants.EXPEDIENT_JNUMEXP, (Object) PropertyInfo.STRING_CLASS, jnumexp);
        }
        if (!jproced.isEmpty()) {
            createElement(Constants.EXPEDIENT_JPROCED, (Object) PropertyInfo.STRING_CLASS, jproced);
        }
        if (!janoapex.isEmpty()) {
            createElement(Constants.EXPEDIENT_JANOAPEX, (Object) PropertyInfo.STRING_CLASS, janoapex);
        }
        if (!situationType.isEmpty()) {
            createElement("sitexp", (Object) PropertyInfo.STRING_CLASS, situationType);
        }
        if (!currencyType.isEmpty()) {
            createElement("codmon", (Object) PropertyInfo.STRING_CLASS, currencyType);
        }
    }
}
