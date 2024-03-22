package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBESTADO_SWIFT_Type", propOrder = {"estadomensajeswift", "codsubestadoswift"})
public class SUBESTADOSWIFTType {
    @XmlElement(name = "COD_SUBESTADO_SWIFT", required = true)
    protected String codsubestadoswift;
    @XmlElement(name = "ESTADO_MENSAJE_SWIFT", required = true)
    protected String estadomensajeswift;

    public String getESTADOMENSAJESWIFT() {
        return this.estadomensajeswift;
    }

    public void setESTADOMENSAJESWIFT(String str) {
        this.estadomensajeswift = str;
    }

    public String getCODSUBESTADOSWIFT() {
        return this.codsubestadoswift;
    }

    public void setCODSUBESTADOSWIFT(String str) {
        this.codsubestadoswift = str;
    }
}
