package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MENSAJE_OVERRIDE_Type", propOrder = {"codalfanum3", "codmensajeext"})
public class MENSAJEOVERRIDEType {
    @XmlElement(name = "COD_ALFANUM_3", required = true)
    protected String codalfanum3;
    @XmlElement(name = "COD_MENSAJEEXT", required = true)
    protected String codmensajeext;

    public String getCODALFANUM3() {
        return this.codalfanum3;
    }

    public void setCODALFANUM3(String str) {
        this.codalfanum3 = str;
    }

    public String getCODMENSAJEEXT() {
        return this.codmensajeext;
    }

    public void setCODMENSAJEEXT(String str) {
        this.codmensajeext = str;
    }
}
