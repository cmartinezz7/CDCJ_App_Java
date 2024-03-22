package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHEQUE_BANCARIO_Type", propOrder = {"claveclasificacion", "numerocuentacheque", "digitodecontrol", "numerodecheque"})
public class CHEQUEBANCARIOType {
    @XmlElement(name = "CLAVE_CLASIFICACION", required = true)
    protected String claveclasificacion;
    @XmlElement(name = "DIGITO_DE_CONTROL", required = true)
    protected String digitodecontrol;
    @XmlElement(name = "NUMERO_CUENTA_CHEQUE", required = true)
    protected String numerocuentacheque;
    @XmlElement(name = "NUMERO_DE_CHEQUE", required = true)
    protected String numerodecheque;

    public String getCLAVECLASIFICACION() {
        return this.claveclasificacion;
    }

    public void setCLAVECLASIFICACION(String str) {
        this.claveclasificacion = str;
    }

    public String getNUMEROCUENTACHEQUE() {
        return this.numerocuentacheque;
    }

    public void setNUMEROCUENTACHEQUE(String str) {
        this.numerocuentacheque = str;
    }

    public String getDIGITODECONTROL() {
        return this.digitodecontrol;
    }

    public void setDIGITODECONTROL(String str) {
        this.digitodecontrol = str;
    }

    public String getNUMERODECHEQUE() {
        return this.numerodecheque;
    }

    public void setNUMERODECHEQUE(String str) {
        this.numerodecheque = str;
    }
}
