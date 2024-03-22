package es.santander.justicia.http.interfaces;

import es.santander.justicia.http.enums.SoapWebServicesEnum;

public interface WsSoapResponse {
   void onWsSoapSuccess(SoapWebServicesEnum var1, Object var2);

   void onWsSoapError(SoapWebServicesEnum var1, Object var2);
}
