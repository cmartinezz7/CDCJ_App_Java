package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POLIZA_SEG_DIST_Type", propOrder = {"codcompania", "productocomercial", "numeropoliza"})
public class POLIZASEGDISTType {
    @XmlElement(name = "COD_COMPANIA", required = true)
    protected String codcompania;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_POLIZA")
    protected int numeropoliza;
    @XmlElement(name = "PRODUCTO_COMERCIAL", required = true)
    protected PRODCOMERCIALSEGDISTType productocomercial;

    public String getCODCOMPANIA() {
        return this.codcompania;
    }

    public void setCODCOMPANIA(String str) {
        this.codcompania = str;
    }

    public PRODCOMERCIALSEGDISTType getPRODUCTOCOMERCIAL() {
        return this.productocomercial;
    }

    public void setPRODUCTOCOMERCIAL(PRODCOMERCIALSEGDISTType pRODCOMERCIALSEGDISTType) {
        this.productocomercial = pRODCOMERCIALSEGDISTType;
    }

    public int getNUMEROPOLIZA() {
        return this.numeropoliza;
    }

    public void setNUMEROPOLIZA(int i) {
        this.numeropoliza = i;
    }
}
