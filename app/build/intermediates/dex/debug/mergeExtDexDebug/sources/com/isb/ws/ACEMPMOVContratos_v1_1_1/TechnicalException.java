package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TechnicalException", namespace = "http://www.gruposantander.es/webservices/genericFault", propOrder = {"technicalPlatform", "platformCode", "message", "stackTrace"})
public class TechnicalException {
    @XmlElement(required = true)
    protected String message;
    @XmlElement(required = true)
    protected String platformCode;
    @XmlElement(required = true)
    protected String stackTrace;
    @XmlElement(required = true)
    protected String technicalPlatform;

    public String getTechnicalPlatform() {
        return this.technicalPlatform;
    }

    public void setTechnicalPlatform(String str) {
        this.technicalPlatform = str;
    }

    public String getPlatformCode() {
        return this.platformCode;
    }

    public void setPlatformCode(String str) {
        this.platformCode = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public void setStackTrace(String str) {
        this.stackTrace = str;
    }
}
