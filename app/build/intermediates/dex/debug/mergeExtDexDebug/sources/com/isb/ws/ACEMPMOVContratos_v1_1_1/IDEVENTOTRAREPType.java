package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_EVENTO_TRAREP_Type", propOrder = {"idoperaciontrarep", "codevento"})
public class IDEVENTOTRAREPType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_EVENTO")
    protected long codevento;
    @XmlElement(name = "ID_OPERACION_TRAREP", required = true)
    protected IDOPERACIONTRAREPType idoperaciontrarep;

    public IDOPERACIONTRAREPType getIDOPERACIONTRAREP() {
        return this.idoperaciontrarep;
    }

    public void setIDOPERACIONTRAREP(IDOPERACIONTRAREPType iDOPERACIONTRAREPType) {
        this.idoperaciontrarep = iDOPERACIONTRAREPType;
    }

    public long getCODEVENTO() {
        return this.codevento;
    }

    public void setCODEVENTO(long j) {
        this.codevento = j;
    }
}
