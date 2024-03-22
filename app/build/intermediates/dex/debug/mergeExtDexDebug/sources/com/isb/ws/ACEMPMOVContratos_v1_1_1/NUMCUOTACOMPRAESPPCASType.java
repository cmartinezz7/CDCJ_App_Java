package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_CUOTA_COMPRA_ESP_PCAS_Type", propOrder = {"numfinancompraesppcas", "asignacioncuota"})
public class NUMCUOTACOMPRAESPPCASType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ASIGNACION_CUOTA")
    protected int asignacioncuota;
    @XmlElement(name = "NUM_FINAN_COMPRA_ESP_PCAS", required = true)
    protected NUMFINANCOMPRAESPPCASType numfinancompraesppcas;

    public NUMFINANCOMPRAESPPCASType getNUMFINANCOMPRAESPPCAS() {
        return this.numfinancompraesppcas;
    }

    public void setNUMFINANCOMPRAESPPCAS(NUMFINANCOMPRAESPPCASType nUMFINANCOMPRAESPPCASType) {
        this.numfinancompraesppcas = nUMFINANCOMPRAESPPCASType;
    }

    public int getASIGNACIONCUOTA() {
        return this.asignacioncuota;
    }

    public void setASIGNACIONCUOTA(int i) {
        this.asignacioncuota = i;
    }
}
