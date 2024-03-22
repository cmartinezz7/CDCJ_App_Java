package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BLOQUE_FUNCIONAL_OPERMART_Type", propOrder = {"idopermart", "codbloquefuncional"})
public class BLOQUEFUNCIONALOPERMARTType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_BLOQUE_FUNCIONAL")
    protected int codbloquefuncional;
    @XmlElement(name = "ID_OPERMART", required = true)
    protected IDOPERMARTType idopermart;

    public IDOPERMARTType getIDOPERMART() {
        return this.idopermart;
    }

    public void setIDOPERMART(IDOPERMARTType iDOPERMARTType) {
        this.idopermart = iDOPERMARTType;
    }

    public int getCODBLOQUEFUNCIONAL() {
        return this.codbloquefuncional;
    }

    public void setCODBLOQUEFUNCIONAL(int i) {
        this.codbloquefuncional = i;
    }
}
