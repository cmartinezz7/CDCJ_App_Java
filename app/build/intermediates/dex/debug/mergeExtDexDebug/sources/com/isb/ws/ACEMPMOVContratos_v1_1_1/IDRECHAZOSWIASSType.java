package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_RECHAZO_SWIASS_Type", propOrder = {"idsolicitudcasopn", "tipodato", "coderror", "seccampo"})
public class IDRECHAZOSWIASSType {
    @XmlElement(name = "COD_ERROR", required = true)
    protected String coderror;
    @XmlElement(name = "ID_SOLICITUD_CASO_PN", required = true)
    protected IDSOLICITUDCASOPNType idsolicitudcasopn;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SEC_CAMPO")
    protected int seccampo;
    @XmlElement(name = "TIPO_DATO", required = true)
    protected String tipodato;

    public IDSOLICITUDCASOPNType getIDSOLICITUDCASOPN() {
        return this.idsolicitudcasopn;
    }

    public void setIDSOLICITUDCASOPN(IDSOLICITUDCASOPNType iDSOLICITUDCASOPNType) {
        this.idsolicitudcasopn = iDSOLICITUDCASOPNType;
    }

    public String getTIPODATO() {
        return this.tipodato;
    }

    public void setTIPODATO(String str) {
        this.tipodato = str;
    }

    public String getCODERROR() {
        return this.coderror;
    }

    public void setCODERROR(String str) {
        this.coderror = str;
    }

    public int getSECCAMPO() {
        return this.seccampo;
    }

    public void setSECCAMPO(int i) {
        this.seccampo = i;
    }
}
