package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_OCURRENCIA_EXCOGL_Type", propOrder = {"iddirectrizexcogl", "ocdirectriz"})
public class IDOCURRENCIAEXCOGLType {
    @XmlElement(name = "ID_DIRECTRIZ_EXCOGL", required = true)
    protected IDDIRECTRIZEXCOGLType iddirectrizexcogl;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "OC_DIRECTRIZ")
    protected int ocdirectriz;

    public IDDIRECTRIZEXCOGLType getIDDIRECTRIZEXCOGL() {
        return this.iddirectrizexcogl;
    }

    public void setIDDIRECTRIZEXCOGL(IDDIRECTRIZEXCOGLType iDDIRECTRIZEXCOGLType) {
        this.iddirectrizexcogl = iDDIRECTRIZEXCOGLType;
    }

    public int getOCDIRECTRIZ() {
        return this.ocdirectriz;
    }

    public void setOCDIRECTRIZ(int i) {
        this.ocdirectriz = i;
    }
}
