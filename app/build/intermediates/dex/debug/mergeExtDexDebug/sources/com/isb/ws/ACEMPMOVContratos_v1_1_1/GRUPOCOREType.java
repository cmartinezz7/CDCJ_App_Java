package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GRUPO_CORE_Type", propOrder = {"tipogrupo", "codigogrupo"})
public class GRUPOCOREType {
    @XmlElement(name = "CODIGO_GRUPO", required = true)
    protected String codigogrupo;
    @XmlElement(name = "TIPO_GRUPO", required = true)
    protected TIPOGRUPOType tipogrupo;

    public TIPOGRUPOType getTIPOGRUPO() {
        return this.tipogrupo;
    }

    public void setTIPOGRUPO(TIPOGRUPOType tIPOGRUPOType) {
        this.tipogrupo = tIPOGRUPOType;
    }

    public String getCODIGOGRUPO() {
        return this.codigogrupo;
    }

    public void setCODIGOGRUPO(String str) {
        this.codigogrupo = str;
    }
}
