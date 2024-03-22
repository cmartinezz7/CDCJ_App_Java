package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_CONCEPTO_FIDELIZA_BNF_Type", propOrder = {"empresa", "codparamfideliza", "codsubparamfideliza"})
public class IDCONCEPTOFIDELIZABNFType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_PARAM_FIDELIZA")
    protected int codparamfideliza;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_SUBPARAM_FIDELIZA")
    protected int codsubparamfideliza;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODPARAMFIDELIZA() {
        return this.codparamfideliza;
    }

    public void setCODPARAMFIDELIZA(int i) {
        this.codparamfideliza = i;
    }

    public int getCODSUBPARAMFIDELIZA() {
        return this.codsubparamfideliza;
    }

    public void setCODSUBPARAMFIDELIZA(int i) {
        this.codsubparamfideliza = i;
    }
}
