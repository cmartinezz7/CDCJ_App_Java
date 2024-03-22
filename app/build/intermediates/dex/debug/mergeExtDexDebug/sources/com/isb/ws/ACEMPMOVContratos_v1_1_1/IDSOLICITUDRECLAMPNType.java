package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_SOLICITUD_RECLAM_PN_Type", propOrder = {"idcasoreclampn", "codreclam"})
public class IDSOLICITUDRECLAMPNType {
    @XmlElement(name = "COD_RECLAM", required = true)
    protected String codreclam;
    @XmlElement(name = "ID_CASO_RECLAM_PN", required = true)
    protected IDCASORECLAMPNType idcasoreclampn;

    public IDCASORECLAMPNType getIDCASORECLAMPN() {
        return this.idcasoreclampn;
    }

    public void setIDCASORECLAMPN(IDCASORECLAMPNType iDCASORECLAMPNType) {
        this.idcasoreclampn = iDCASORECLAMPNType;
    }

    public String getCODRECLAM() {
        return this.codreclam;
    }

    public void setCODRECLAM(String str) {
        this.codreclam = str;
    }
}
