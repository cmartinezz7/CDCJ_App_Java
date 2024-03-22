package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOPORTE_ORIGINAL_FACTOR_Type", propOrder = {"soporterecibidofactor", "numeroregistro"})
public class SOPORTEORIGINALFACTORType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_REGISTRO")
    protected int numeroregistro;
    @XmlElement(name = "SOPORTE_RECIBIDO_FACTOR", required = true)
    protected SOPORTERECIBIDOFACTORType soporterecibidofactor;

    public SOPORTERECIBIDOFACTORType getSOPORTERECIBIDOFACTOR() {
        return this.soporterecibidofactor;
    }

    public void setSOPORTERECIBIDOFACTOR(SOPORTERECIBIDOFACTORType sOPORTERECIBIDOFACTORType) {
        this.soporterecibidofactor = sOPORTERECIBIDOFACTORType;
    }

    public int getNUMEROREGISTRO() {
        return this.numeroregistro;
    }

    public void setNUMEROREGISTRO(int i) {
        this.numeroregistro = i;
    }
}
