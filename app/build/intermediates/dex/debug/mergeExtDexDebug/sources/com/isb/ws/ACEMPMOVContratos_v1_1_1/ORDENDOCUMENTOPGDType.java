package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORDEN_DOCUMENTO_PGD_Type", propOrder = {"ordenserv", "servdoc"})
public class ORDENDOCUMENTOPGDType {
    @XmlElement(name = "ORDENSERV", required = true)
    protected ORDENDESERVICIOType ordenserv;
    @XmlElement(name = "SERVDOC", required = true)
    protected String servdoc;

    public ORDENDESERVICIOType getORDENSERV() {
        return this.ordenserv;
    }

    public void setORDENSERV(ORDENDESERVICIOType oRDENDESERVICIOType) {
        this.ordenserv = oRDENDESERVICIOType;
    }

    public String getSERVDOC() {
        return this.servdoc;
    }

    public void setSERVDOC(String str) {
        this.servdoc = str;
    }
}
