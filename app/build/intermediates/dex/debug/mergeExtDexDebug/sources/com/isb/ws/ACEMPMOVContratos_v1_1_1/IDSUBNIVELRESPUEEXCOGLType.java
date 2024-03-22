package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_SUBNIVEL_RESPUE_EXCOGL_Type", propOrder = {"idrespuestaaccioexcogl", "codsubtiporesp"})
public class IDSUBNIVELRESPUEEXCOGLType {
    @XmlElement(name = "COD_SUBTIPO_RESP", required = true)
    protected String codsubtiporesp;
    @XmlElement(name = "ID_RESPUESTA_ACCIO_EXCOGL", required = true)
    protected IDRESPUESTAACCIOEXCOGLType idrespuestaaccioexcogl;

    public IDRESPUESTAACCIOEXCOGLType getIDRESPUESTAACCIOEXCOGL() {
        return this.idrespuestaaccioexcogl;
    }

    public void setIDRESPUESTAACCIOEXCOGL(IDRESPUESTAACCIOEXCOGLType iDRESPUESTAACCIOEXCOGLType) {
        this.idrespuestaaccioexcogl = iDRESPUESTAACCIOEXCOGLType;
    }

    public String getCODSUBTIPORESP() {
        return this.codsubtiporesp;
    }

    public void setCODSUBTIPORESP(String str) {
        this.codsubtiporesp = str;
    }
}
