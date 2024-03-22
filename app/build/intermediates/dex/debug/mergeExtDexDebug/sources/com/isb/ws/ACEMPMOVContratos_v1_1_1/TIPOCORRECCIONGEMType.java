package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_CORRECCION_GEM_Type", propOrder = {"operaciongem", "tipodeelemento", "codtipocorreccion"})
public class TIPOCORRECCIONGEMType {
    @XmlElement(name = "COD_TIPO_CORRECCION", required = true)
    protected String codtipocorreccion;
    @XmlElement(name = "OPERACION_GEM", required = true)
    protected OPERACIONGEMType operaciongem;
    @XmlElement(name = "TIPO_DE_ELEMENTO", required = true)
    protected String tipodeelemento;

    public OPERACIONGEMType getOPERACIONGEM() {
        return this.operaciongem;
    }

    public void setOPERACIONGEM(OPERACIONGEMType oPERACIONGEMType) {
        this.operaciongem = oPERACIONGEMType;
    }

    public String getTIPODEELEMENTO() {
        return this.tipodeelemento;
    }

    public void setTIPODEELEMENTO(String str) {
        this.tipodeelemento = str;
    }

    public String getCODTIPOCORRECCION() {
        return this.codtipocorreccion;
    }

    public void setCODTIPOCORRECCION(String str) {
        this.codtipocorreccion = str;
    }
}
