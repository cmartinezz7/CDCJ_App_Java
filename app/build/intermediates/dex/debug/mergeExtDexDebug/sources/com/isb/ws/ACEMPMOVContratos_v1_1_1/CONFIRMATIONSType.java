package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONFIRMATIONS_Type", propOrder = {"confirmationtype", "keysignature", "digitalsignature", "otp", "universalsignature"})
public class CONFIRMATIONSType {
    @XmlElement(name = "CONFIRMATION_TYPE", required = true)
    protected String confirmationtype;
    @XmlElement(name = "DIGITAL_SIGNATURE", required = true)
    protected String digitalsignature;
    @XmlElement(name = "KEY_SIGNATURE", required = true)
    protected KEYSIGNATUREType keysignature;
    @XmlElement(name = "OTP", required = true)
    protected String otp;
    @XmlElement(name = "UNIVERSAL_SIGNATURE", required = true)
    protected String universalsignature;

    public String getCONFIRMATIONTYPE() {
        return this.confirmationtype;
    }

    public void setCONFIRMATIONTYPE(String str) {
        this.confirmationtype = str;
    }

    public KEYSIGNATUREType getKEYSIGNATURE() {
        return this.keysignature;
    }

    public void setKEYSIGNATURE(KEYSIGNATUREType kEYSIGNATUREType) {
        this.keysignature = kEYSIGNATUREType;
    }

    public String getDIGITALSIGNATURE() {
        return this.digitalsignature;
    }

    public void setDIGITALSIGNATURE(String str) {
        this.digitalsignature = str;
    }

    public String getOTP() {
        return this.otp;
    }

    public void setOTP(String str) {
        this.otp = str;
    }

    public String getUNIVERSALSIGNATURE() {
        return this.universalsignature;
    }

    public void setUNIVERSALSIGNATURE(String str) {
        this.universalsignature = str;
    }
}
