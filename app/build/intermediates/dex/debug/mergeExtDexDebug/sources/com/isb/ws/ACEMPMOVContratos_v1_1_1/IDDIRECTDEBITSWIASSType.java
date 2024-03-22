package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_DIRECT_DEBIT_SWIASS_Type", propOrder = {"idsolicitudcasopn", "mandatetype", "dirdrefer", "dirdsec"})
public class IDDIRECTDEBITSWIASSType {
    @XmlElement(name = "DIRDREFER", required = true)
    protected String dirdrefer;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "DIRDSEC")
    protected int dirdsec;
    @XmlElement(name = "ID_SOLICITUD_CASO_PN", required = true)
    protected IDSOLICITUDCASOPNType idsolicitudcasopn;
    @XmlElement(name = "MANDATE_TYPE", required = true)
    protected String mandatetype;

    public IDSOLICITUDCASOPNType getIDSOLICITUDCASOPN() {
        return this.idsolicitudcasopn;
    }

    public void setIDSOLICITUDCASOPN(IDSOLICITUDCASOPNType iDSOLICITUDCASOPNType) {
        this.idsolicitudcasopn = iDSOLICITUDCASOPNType;
    }

    public String getMANDATETYPE() {
        return this.mandatetype;
    }

    public void setMANDATETYPE(String str) {
        this.mandatetype = str;
    }

    public String getDIRDREFER() {
        return this.dirdrefer;
    }

    public void setDIRDREFER(String str) {
        this.dirdrefer = str;
    }

    public int getDIRDSEC() {
        return this.dirdsec;
    }

    public void setDIRDSEC(int i) {
        this.dirdsec = i;
    }
}
