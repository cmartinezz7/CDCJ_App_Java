package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Exception", namespace = "http://www.gruposantander.es/webservices/genericFault")
@XmlType(name = "", propOrder = {"faultCode", "code", "reasons", "processInfo", "technicalException", "additionalInfo"})
public class Exception {
    @XmlElement(required = true)
    protected String additionalInfo;
    @XmlElement(required = true)
    protected Faultcode code;
    @XmlElement(required = true)
    protected String faultCode;
    @XmlElement(required = true)
    protected ProcessInfo processInfo;
    @XmlElement(required = true)
    protected Faultreasons reasons;
    @XmlElement(required = true)
    protected TechnicalException technicalException;

    public String getFaultCode() {
        return this.faultCode;
    }

    public void setFaultCode(String str) {
        this.faultCode = str;
    }

    public Faultcode getCode() {
        return this.code;
    }

    public void setCode(Faultcode faultcode) {
        this.code = faultcode;
    }

    public Faultreasons getReasons() {
        return this.reasons;
    }

    public void setReasons(Faultreasons faultreasons) {
        this.reasons = faultreasons;
    }

    public ProcessInfo getProcessInfo() {
        return this.processInfo;
    }

    public void setProcessInfo(ProcessInfo processInfo2) {
        this.processInfo = processInfo2;
    }

    public TechnicalException getTechnicalException() {
        return this.technicalException;
    }

    public void setTechnicalException(TechnicalException technicalException2) {
        this.technicalException = technicalException2;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(String str) {
        this.additionalInfo = str;
    }
}
