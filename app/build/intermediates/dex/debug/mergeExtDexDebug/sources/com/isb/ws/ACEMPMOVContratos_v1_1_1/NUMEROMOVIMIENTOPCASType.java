package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUMERO_MOVIMIENTO_PCAS_Type", propOrder = {"numeroextractopcas", "nummovimiento"})
public class NUMEROMOVIMIENTOPCASType {
    @XmlElement(name = "NUMERO_EXTRACTO_PCAS", required = true)
    protected NUMEROEXTRACTOPCASType numeroextractopcas;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_MOVIMIENTO")
    protected int nummovimiento;

    public NUMEROEXTRACTOPCASType getNUMEROEXTRACTOPCAS() {
        return this.numeroextractopcas;
    }

    public void setNUMEROEXTRACTOPCAS(NUMEROEXTRACTOPCASType nUMEROEXTRACTOPCASType) {
        this.numeroextractopcas = nUMEROEXTRACTOPCASType;
    }

    public int getNUMMOVIMIENTO() {
        return this.nummovimiento;
    }

    public void setNUMMOVIMIENTO(int i) {
        this.nummovimiento = i;
    }
}
