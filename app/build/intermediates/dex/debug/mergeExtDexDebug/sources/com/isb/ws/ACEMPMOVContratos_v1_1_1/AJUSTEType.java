package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AJUSTE_Type", propOrder = {"periodoconsolidacfinan", "codigoajuste"})
public class AJUSTEType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_AJUSTE")
    protected int codigoajuste;
    @XmlElement(name = "PERIODO_CONSOLIDAC_FINAN", required = true)
    protected PERIODOCONSOLIDACFINANType periodoconsolidacfinan;

    public PERIODOCONSOLIDACFINANType getPERIODOCONSOLIDACFINAN() {
        return this.periodoconsolidacfinan;
    }

    public void setPERIODOCONSOLIDACFINAN(PERIODOCONSOLIDACFINANType pERIODOCONSOLIDACFINANType) {
        this.periodoconsolidacfinan = pERIODOCONSOLIDACFINANType;
    }

    public int getCODIGOAJUSTE() {
        return this.codigoajuste;
    }

    public void setCODIGOAJUSTE(int i) {
        this.codigoajuste = i;
    }
}
