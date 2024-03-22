package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GRUPO_PROCESO_PCAS_Type", propOrder = {"procesopcas", "codgrupocproceso"})
public class GRUPOPROCESOPCASType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_GRUPOC_PROCESO")
    protected int codgrupocproceso;
    @XmlElement(name = "PROCESO_PCAS", required = true)
    protected PROCESOPCASType procesopcas;

    public PROCESOPCASType getPROCESOPCAS() {
        return this.procesopcas;
    }

    public void setPROCESOPCAS(PROCESOPCASType pROCESOPCASType) {
        this.procesopcas = pROCESOPCASType;
    }

    public int getCODGRUPOCPROCESO() {
        return this.codgrupocproceso;
    }

    public void setCODGRUPOCPROCESO(int i) {
        this.codgrupocproceso = i;
    }
}
