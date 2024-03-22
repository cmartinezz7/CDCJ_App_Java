package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.ws.WebFault;

@WebFault(name = "Exception", targetNamespace = "http://www.gruposantander.es/webservices/genericFault")
public class RealizarLogonLAFault extends Exception {
    private Exception faultInfo;

    public RealizarLogonLAFault(String str, Exception exception) {
        super(str);
        this.faultInfo = exception;
    }

    public RealizarLogonLAFault(String str, Exception exception, Throwable th) {
        super(str, th);
        this.faultInfo = exception;
    }

    public Exception getFaultInfo() {
        return this.faultInfo;
    }
}
