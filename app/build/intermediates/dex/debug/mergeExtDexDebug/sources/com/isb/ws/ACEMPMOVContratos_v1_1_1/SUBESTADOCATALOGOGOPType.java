package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBESTADO_CATALOGO_GOP_Type", propOrder = {"estadocatalogogop", "codsubestcatalogogop"})
public class SUBESTADOCATALOGOGOPType {
    @XmlElement(name = "COD_SUBEST_CATALOGO_GOP", required = true)
    protected String codsubestcatalogogop;
    @XmlElement(name = "ESTADO_CATALOGO_GOP", required = true)
    protected ESTADOCATALOGOGOPType estadocatalogogop;

    public ESTADOCATALOGOGOPType getESTADOCATALOGOGOP() {
        return this.estadocatalogogop;
    }

    public void setESTADOCATALOGOGOP(ESTADOCATALOGOGOPType eSTADOCATALOGOGOPType) {
        this.estadocatalogogop = eSTADOCATALOGOGOPType;
    }

    public String getCODSUBESTCATALOGOGOP() {
        return this.codsubestcatalogogop;
    }

    public void setCODSUBESTCATALOGOGOP(String str) {
        this.codsubestcatalogogop = str;
    }
}
