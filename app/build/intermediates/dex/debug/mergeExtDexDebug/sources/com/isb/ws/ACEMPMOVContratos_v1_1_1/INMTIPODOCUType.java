package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INM_TIPO_DOCU_Type", propOrder = {"inmgrupotipdoc", "codtipodoc"})
public class INMTIPODOCUType {
    @XmlElement(name = "COD_TIPO_DOC", required = true)
    protected String codtipodoc;
    @XmlElement(name = "INM_GRUPO_TIP_DOC", required = true)
    protected String inmgrupotipdoc;

    public String getINMGRUPOTIPDOC() {
        return this.inmgrupotipdoc;
    }

    public void setINMGRUPOTIPDOC(String str) {
        this.inmgrupotipdoc = str;
    }

    public String getCODTIPODOC() {
        return this.codtipodoc;
    }

    public void setCODTIPODOC(String str) {
        this.codtipodoc = str;
    }
}
