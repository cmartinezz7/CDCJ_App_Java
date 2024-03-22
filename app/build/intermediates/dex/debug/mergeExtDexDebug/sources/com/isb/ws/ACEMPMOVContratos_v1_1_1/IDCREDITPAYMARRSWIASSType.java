package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_CREDIT_PAYM_ARR_SWIASS_Type", propOrder = {"idsolicitudcasopn", "cpatype", "cparef", "cpasec"})
public class IDCREDITPAYMARRSWIASSType {
    @XmlElement(name = "CPAREF", required = true)
    protected String cparef;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CPASEC")
    protected int cpasec;
    @XmlElement(name = "CPATYPE", required = true)
    protected String cpatype;
    @XmlElement(name = "ID_SOLICITUD_CASO_PN", required = true)
    protected IDSOLICITUDCASOPNType idsolicitudcasopn;

    public IDSOLICITUDCASOPNType getIDSOLICITUDCASOPN() {
        return this.idsolicitudcasopn;
    }

    public void setIDSOLICITUDCASOPN(IDSOLICITUDCASOPNType iDSOLICITUDCASOPNType) {
        this.idsolicitudcasopn = iDSOLICITUDCASOPNType;
    }

    public String getCPATYPE() {
        return this.cpatype;
    }

    public void setCPATYPE(String str) {
        this.cpatype = str;
    }

    public String getCPAREF() {
        return this.cparef;
    }

    public void setCPAREF(String str) {
        this.cparef = str;
    }

    public int getCPASEC() {
        return this.cpasec;
    }

    public void setCPASEC(int i) {
        this.cpasec = i;
    }
}
