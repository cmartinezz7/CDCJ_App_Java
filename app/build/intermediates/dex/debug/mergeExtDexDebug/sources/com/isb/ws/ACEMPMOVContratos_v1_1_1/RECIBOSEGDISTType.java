package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RECIBO_SEG_DIST_Type", propOrder = {"poliza", "numerorecibo"})
public class RECIBOSEGDISTType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_RECIBO")
    protected int numerorecibo;
    @XmlElement(name = "POLIZA", required = true)
    protected POLIZASEGDISTType poliza;

    public POLIZASEGDISTType getPOLIZA() {
        return this.poliza;
    }

    public void setPOLIZA(POLIZASEGDISTType pOLIZASEGDISTType) {
        this.poliza = pOLIZASEGDISTType;
    }

    public int getNUMERORECIBO() {
        return this.numerorecibo;
    }

    public void setNUMERORECIBO(int i) {
        this.numerorecibo = i;
    }
}
