package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONCEPTO_ECONOM_DEB_PCAS_Type", propOrder = {"numeromovimiento", "conceptoeconomico"})
public class CONCEPTOECONOMDEBPCASType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CONCEPTO_ECONOMICO")
    protected int conceptoeconomico;
    @XmlElement(name = "NUMERO_MOVIMIENTO", required = true)
    protected NUMMOVIMIENTODEBPCASType numeromovimiento;

    public NUMMOVIMIENTODEBPCASType getNUMEROMOVIMIENTO() {
        return this.numeromovimiento;
    }

    public void setNUMEROMOVIMIENTO(NUMMOVIMIENTODEBPCASType nUMMOVIMIENTODEBPCASType) {
        this.numeromovimiento = nUMMOVIMIENTODEBPCASType;
    }

    public int getCONCEPTOECONOMICO() {
        return this.conceptoeconomico;
    }

    public void setCONCEPTOECONOMICO(int i) {
        this.conceptoeconomico = i;
    }
}
