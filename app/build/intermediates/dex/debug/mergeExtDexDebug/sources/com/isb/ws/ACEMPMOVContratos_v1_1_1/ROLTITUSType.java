package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROL_TITUS_Type", propOrder = {"areafuncionaltitus", "codrol"})
public class ROLTITUSType {
    @XmlElement(name = "AREA_FUNCIONAL_TITUS", required = true)
    protected AREAFUNCIONALTITUSType areafuncionaltitus;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_ROL")
    protected int codrol;

    public AREAFUNCIONALTITUSType getAREAFUNCIONALTITUS() {
        return this.areafuncionaltitus;
    }

    public void setAREAFUNCIONALTITUS(AREAFUNCIONALTITUSType aREAFUNCIONALTITUSType) {
        this.areafuncionaltitus = aREAFUNCIONALTITUSType;
    }

    public int getCODROL() {
        return this.codrol;
    }

    public void setCODROL(int i) {
        this.codrol = i;
    }
}
