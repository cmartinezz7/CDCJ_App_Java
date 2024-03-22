package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AGR_PRODUCTO_COMERCIAL_Type", propOrder = {"productocomercial", "agrproductocomercial"})
public class AGRPRODUCTOCOMERCIALType {
    @XmlElement(name = "AGR_PRODUCTO_COMERCIAL", required = true)
    protected String agrproductocomercial;
    @XmlElement(name = "PRODUCTO_COMERCIAL", required = true)
    protected PRODUCTOCOMERCIALType productocomercial;

    public PRODUCTOCOMERCIALType getPRODUCTOCOMERCIAL() {
        return this.productocomercial;
    }

    public void setPRODUCTOCOMERCIAL(PRODUCTOCOMERCIALType pRODUCTOCOMERCIALType) {
        this.productocomercial = pRODUCTOCOMERCIALType;
    }

    public String getAGRPRODUCTOCOMERCIAL() {
        return this.agrproductocomercial;
    }

    public void setAGRPRODUCTOCOMERCIAL(String str) {
        this.agrproductocomercial = str;
    }
}
