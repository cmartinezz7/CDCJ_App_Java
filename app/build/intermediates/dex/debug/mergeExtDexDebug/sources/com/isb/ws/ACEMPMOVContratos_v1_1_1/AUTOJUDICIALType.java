package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUTO_JUDICIAL_Type", propOrder = {"codigodeauto", "referenciaautojudicial"})
public class AUTOJUDICIALType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_DE_AUTO")
    protected int codigodeauto;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "REFERENCIA_AUTO_JUDICIAL")
    protected int referenciaautojudicial;

    public int getCODIGODEAUTO() {
        return this.codigodeauto;
    }

    public void setCODIGODEAUTO(int i) {
        this.codigodeauto = i;
    }

    public int getREFERENCIAAUTOJUDICIAL() {
        return this.referenciaautojudicial;
    }

    public void setREFERENCIAAUTOJUDICIAL(int i) {
        this.referenciaautojudicial = i;
    }
}
