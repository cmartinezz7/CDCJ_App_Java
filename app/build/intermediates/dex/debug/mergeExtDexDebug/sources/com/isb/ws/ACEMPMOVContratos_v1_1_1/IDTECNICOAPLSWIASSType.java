package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_TECNICO_APL_SWIASS_Type", propOrder = {"idsolicitudcasopn", "codtecnicoerror", "codmensaje", "seccampo"})
public class IDTECNICOAPLSWIASSType {
    @XmlElement(name = "COD_MENSAJE", required = true)
    protected String codmensaje;
    @XmlElement(name = "COD_TECNICO_ERROR", required = true)
    protected String codtecnicoerror;
    @XmlElement(name = "ID_SOLICITUD_CASO_PN", required = true)
    protected IDSOLICITUDCASOPNType idsolicitudcasopn;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SEC_CAMPO")
    protected int seccampo;

    public IDSOLICITUDCASOPNType getIDSOLICITUDCASOPN() {
        return this.idsolicitudcasopn;
    }

    public void setIDSOLICITUDCASOPN(IDSOLICITUDCASOPNType iDSOLICITUDCASOPNType) {
        this.idsolicitudcasopn = iDSOLICITUDCASOPNType;
    }

    public String getCODTECNICOERROR() {
        return this.codtecnicoerror;
    }

    public void setCODTECNICOERROR(String str) {
        this.codtecnicoerror = str;
    }

    public String getCODMENSAJE() {
        return this.codmensaje;
    }

    public void setCODMENSAJE(String str) {
        this.codmensaje = str;
    }

    public int getSECCAMPO() {
        return this.seccampo;
    }

    public void setSECCAMPO(int i) {
        this.seccampo = i;
    }
}
