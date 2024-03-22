package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_MOVIMIENTO_PCAS_Type", propOrder = {"numeroextractopcas", "nummovimiento"})
public class NUMMOVIMIENTOPCASType {
    @XmlElement(name = "NUMERO_EXTRACTO_PCAS", required = true)
    protected NUMEXTRACTOPCASType numeroextractopcas;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_MOVIMIENTO")
    protected int nummovimiento;

    public NUMEXTRACTOPCASType getNUMEROEXTRACTOPCAS() {
        return this.numeroextractopcas;
    }

    public void setNUMEROEXTRACTOPCAS(NUMEXTRACTOPCASType nUMEXTRACTOPCASType) {
        this.numeroextractopcas = nUMEXTRACTOPCASType;
    }

    public int getNUMMOVIMIENTO() {
        return this.nummovimiento;
    }

    public void setNUMMOVIMIENTO(int i) {
        this.nummovimiento = i;
    }
}
