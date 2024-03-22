package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRODUCTO_COMERCIAL_Type", propOrder = {"catalogocomercial", "productocomercial"})
public class PRODUCTOCOMERCIALType {
    @XmlElement(name = "CATALOGO_COMERCIAL", required = true)
    protected CATALOGOCOMERCIALType catalogocomercial;
    @XmlElement(name = "PRODUCTO_COMERCIAL", required = true)
    protected String productocomercial;

    public CATALOGOCOMERCIALType getCATALOGOCOMERCIAL() {
        return this.catalogocomercial;
    }

    public void setCATALOGOCOMERCIAL(CATALOGOCOMERCIALType cATALOGOCOMERCIALType) {
        this.catalogocomercial = cATALOGOCOMERCIALType;
    }

    public String getPRODUCTOCOMERCIAL() {
        return this.productocomercial;
    }

    public void setPRODUCTOCOMERCIAL(String str) {
        this.productocomercial = str;
    }
}
