package es.santander.justicia.http.interfaces;

import es.santander.justicia.http.enums.SoapWebServicesEnum;

public interface WsSoapResponse {
    void onWsSoapError(SoapWebServicesEnum soapWebServicesEnum, Object obj);

    void onWsSoapSuccess(SoapWebServicesEnum soapWebServicesEnum, Object obj);
}
