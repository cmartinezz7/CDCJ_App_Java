package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_FINAN_COMPRA_ESP_PCAS_Type", propOrder = {"numcompraespecialpcas", "numfinanciacion"})
public class NUMFINANCOMPRAESPPCASType {
    @XmlElement(name = "NUM_COMPRA_ESPECIAL_PCAS", required = true)
    protected NUMCOMPRAESPECIALPCASType numcompraespecialpcas;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_FINANCIACION")
    protected int numfinanciacion;

    public NUMCOMPRAESPECIALPCASType getNUMCOMPRAESPECIALPCAS() {
        return this.numcompraespecialpcas;
    }

    public void setNUMCOMPRAESPECIALPCAS(NUMCOMPRAESPECIALPCASType nUMCOMPRAESPECIALPCASType) {
        this.numcompraespecialpcas = nUMCOMPRAESPECIALPCASType;
    }

    public int getNUMFINANCIACION() {
        return this.numfinanciacion;
    }

    public void setNUMFINANCIACION(int i) {
        this.numfinanciacion = i;
    }
}
