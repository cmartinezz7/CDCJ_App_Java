package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BENEFICIARIO_SEG_DIST_Type", propOrder = {"poliza", "numeroorden"})
public class BENEFICIARIOSEGDISTType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_ORDEN")
    protected int numeroorden;
    @XmlElement(name = "POLIZA", required = true)
    protected POLIZASEGDISTType poliza;

    public POLIZASEGDISTType getPOLIZA() {
        return this.poliza;
    }

    public void setPOLIZA(POLIZASEGDISTType pOLIZASEGDISTType) {
        this.poliza = pOLIZASEGDISTType;
    }

    public int getNUMEROORDEN() {
        return this.numeroorden;
    }

    public void setNUMEROORDEN(int i) {
        this.numeroorden = i;
    }
}
