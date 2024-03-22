package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_FUENTE_APV_CE_Type", propOrder = {"codtipofuenteapvce", "codgrupoentidadbis"})
public class TIPOFUENTEAPVCEType {
    @XmlElement(name = "COD_GRUPO_ENTIDAD_BIS", required = true)
    protected String codgrupoentidadbis;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_TIPO_FUENTE_APV_CE")
    protected int codtipofuenteapvce;

    public int getCODTIPOFUENTEAPVCE() {
        return this.codtipofuenteapvce;
    }

    public void setCODTIPOFUENTEAPVCE(int i) {
        this.codtipofuenteapvce = i;
    }

    public String getCODGRUPOENTIDADBIS() {
        return this.codgrupoentidadbis;
    }

    public void setCODGRUPOENTIDADBIS(String str) {
        this.codgrupoentidadbis = str;
    }
}
