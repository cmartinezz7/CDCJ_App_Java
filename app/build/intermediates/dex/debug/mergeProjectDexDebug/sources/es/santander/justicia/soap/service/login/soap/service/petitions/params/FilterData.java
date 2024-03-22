package es.santander.justicia.soap.service.login.soap.service.petitions.params;

import es.santander.justicia.soap.service.login.soap.service.SoapPropertiesParser;
import org.ksoap2.serialization.PropertyInfo;

public class FilterData extends SoapPropertiesParser {
    public FilterData(String dateFrom, String dateTo, String selectionType) {
        if (!dateFrom.isEmpty()) {
            createElement("jfechareDe", (Object) PropertyInfo.STRING_CLASS, dateFrom);
        }
        if (!dateTo.isEmpty()) {
            createElement("jfechareHasta", (Object) PropertyInfo.STRING_CLASS, dateTo);
        }
        if (!selectionType.isEmpty()) {
            createElement("tipsel", (Object) PropertyInfo.STRING_CLASS, selectionType);
        }
    }
}
