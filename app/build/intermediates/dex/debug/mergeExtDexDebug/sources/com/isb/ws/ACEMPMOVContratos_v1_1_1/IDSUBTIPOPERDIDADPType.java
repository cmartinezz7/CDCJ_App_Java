package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_SUBTIPO_PERDIDA_DP_Type", propOrder = {"idtipoperdidadp", "codsubtipoperdida"})
public class IDSUBTIPOPERDIDADPType {
    @XmlElement(name = "COD_SUBTIPO_PERDIDA", required = true)
    protected String codsubtipoperdida;
    @XmlElement(name = "ID_TIPO_PERDIDA_DP", required = true)
    protected IDTIPOPERDIDADPType idtipoperdidadp;

    public IDTIPOPERDIDADPType getIDTIPOPERDIDADP() {
        return this.idtipoperdidadp;
    }

    public void setIDTIPOPERDIDADP(IDTIPOPERDIDADPType iDTIPOPERDIDADPType) {
        this.idtipoperdidadp = iDTIPOPERDIDADPType;
    }

    public String getCODSUBTIPOPERDIDA() {
        return this.codsubtipoperdida;
    }

    public void setCODSUBTIPOPERDIDA(String str) {
        this.codsubtipoperdida = str;
    }
}
