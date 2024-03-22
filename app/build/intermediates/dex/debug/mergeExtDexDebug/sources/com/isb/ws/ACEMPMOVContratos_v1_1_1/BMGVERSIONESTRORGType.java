package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_VERSION_ESTR_ORG_Type", propOrder = {"bmgestructuorganizativa", "codversion"})
public class BMGVERSIONESTRORGType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "BMG_ESTRUCTU_ORGANIZATIVA")
    protected int bmgestructuorganizativa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_VERSION")
    protected int codversion;

    public int getBMGESTRUCTUORGANIZATIVA() {
        return this.bmgestructuorganizativa;
    }

    public void setBMGESTRUCTUORGANIZATIVA(int i) {
        this.bmgestructuorganizativa = i;
    }

    public int getCODVERSION() {
        return this.codversion;
    }

    public void setCODVERSION(int i) {
        this.codversion = i;
    }
}
