package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BLOQUE_CONCEPTOS_PB_Type", propOrder = {"subtipodeproducto", "codbloquefactura"})
public class BLOQUECONCEPTOSPBType {
    @XmlElement(name = "COD_BLOQUE_FACTURA", required = true)
    protected String codbloquefactura;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public String getCODBLOQUEFACTURA() {
        return this.codbloquefactura;
    }

    public void setCODBLOQUEFACTURA(String str) {
        this.codbloquefactura = str;
    }
}
