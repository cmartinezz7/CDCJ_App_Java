package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "com.isb.moemc2.contratos.la.f.cb.CB_DatosSalidaInfoDesc_LA_K_Type", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/santander/internet/cbTypes/v1", propOrder = {"errorDesc", "errorCode", "token"})
public class ComIsbMoemc2ContratosLaFCbCBDatosSalidaInfoDescLAKType {
    protected String errorCode;
    protected String errorDesc;
    protected String token;

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public void setErrorDesc(String str) {
        this.errorDesc = str;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
