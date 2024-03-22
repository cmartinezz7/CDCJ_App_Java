package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_DE_CONSUMO_Type", propOrder = {"codigogrupodeconsumo", "codigotipodeconsumo"})
public class TIPODECONSUMOType {
    @XmlElement(name = "CODIGO_GRUPO_DE_CONSUMO", required = true)
    protected String codigogrupodeconsumo;
    @XmlElement(name = "CODIGO_TIPO_DE_CONSUMO", required = true)
    protected String codigotipodeconsumo;

    public String getCODIGOGRUPODECONSUMO() {
        return this.codigogrupodeconsumo;
    }

    public void setCODIGOGRUPODECONSUMO(String str) {
        this.codigogrupodeconsumo = str;
    }

    public String getCODIGOTIPODECONSUMO() {
        return this.codigotipodeconsumo;
    }

    public void setCODIGOTIPODECONSUMO(String str) {
        this.codigotipodeconsumo = str;
    }
}
