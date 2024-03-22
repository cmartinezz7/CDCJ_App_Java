package es.santander.justicia.soap.service.login.soap.service.movementsQuery.params;

import es.santander.justicia.soap.service.login.soap.service.SoapPropertiesParser;
import org.ksoap2.serialization.PropertyInfo;

public class FilterData extends SoapPropertiesParser {
    public FilterData(String dateFrom, String dateTo, String importFrom, String importTo) {
        if (!dateFrom.isEmpty()) {
            createElement("jfechareDe", (Object) PropertyInfo.STRING_CLASS, dateFrom);
        }
        if (!dateTo.isEmpty()) {
            createElement("jfechareHasta", (Object) PropertyInfo.STRING_CLASS, dateTo);
        }
        if (!importFrom.isEmpty()) {
            createElement("jimpnomiDe", (Object) PropertyInfo.STRING_CLASS, importFrom);
        }
        if (!importTo.isEmpty()) {
            createElement("jimpnomiHasta", (Object) PropertyInfo.STRING_CLASS, importTo);
        }
    }
}
