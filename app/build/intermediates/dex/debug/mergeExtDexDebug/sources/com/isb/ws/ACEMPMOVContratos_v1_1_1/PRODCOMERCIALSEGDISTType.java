package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PROD_COMERCIAL_SEG_DIST_Type", propOrder = {"codramo", "codprodcomercial"})
public class PRODCOMERCIALSEGDISTType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_PROD_COMERCIAL")
    protected int codprodcomercial;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_RAMO")
    protected int codramo;

    public int getCODRAMO() {
        return this.codramo;
    }

    public void setCODRAMO(int i) {
        this.codramo = i;
    }

    public int getCODPRODCOMERCIAL() {
        return this.codprodcomercial;
    }

    public void setCODPRODCOMERCIAL(int i) {
        this.codprodcomercial = i;
    }
}
