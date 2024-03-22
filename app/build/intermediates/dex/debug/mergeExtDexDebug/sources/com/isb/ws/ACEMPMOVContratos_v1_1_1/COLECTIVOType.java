package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COLECTIVO_Type", propOrder = {"tipocolectivo", "codigoalfanum4"})
public class COLECTIVOType {
    @XmlElement(name = "CODIGO_ALFANUM_4", required = true)
    protected String codigoalfanum4;
    @XmlElement(name = "TIPO_COLECTIVO", required = true)
    protected TIPOCOLECTIVOType tipocolectivo;

    public TIPOCOLECTIVOType getTIPOCOLECTIVO() {
        return this.tipocolectivo;
    }

    public void setTIPOCOLECTIVO(TIPOCOLECTIVOType tIPOCOLECTIVOType) {
        this.tipocolectivo = tIPOCOLECTIVOType;
    }

    public String getCODIGOALFANUM4() {
        return this.codigoalfanum4;
    }

    public void setCODIGOALFANUM4(String str) {
        this.codigoalfanum4 = str;
    }
}
