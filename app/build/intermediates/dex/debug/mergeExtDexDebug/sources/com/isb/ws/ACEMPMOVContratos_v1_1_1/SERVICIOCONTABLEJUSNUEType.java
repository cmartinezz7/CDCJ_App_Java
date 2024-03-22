package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SERVICIO_CONTABLE_JUSNUE_Type", propOrder = {"subtipodeproducto", "conceptodesaldo", "sectorcontable"})
public class SERVICIOCONTABLEJUSNUEType {
    @XmlElement(name = "CONCEPTO_DE_SALDO", required = true)
    protected String conceptodesaldo;
    @XmlElement(name = "SECTOR_CONTABLE", required = true)
    protected String sectorcontable;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public String getCONCEPTODESALDO() {
        return this.conceptodesaldo;
    }

    public void setCONCEPTODESALDO(String str) {
        this.conceptodesaldo = str;
    }

    public String getSECTORCONTABLE() {
        return this.sectorcontable;
    }

    public void setSECTORCONTABLE(String str) {
        this.sectorcontable = str;
    }
}
