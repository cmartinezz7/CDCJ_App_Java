package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOTIVO_INCIDENCIA_TJT_Type", propOrder = {"incidenciafacttjt", "motivoincidencia"})
public class MOTIVOINCIDENCIATJTType {
    @XmlElement(name = "INCIDENCIA_FACT_TJT", required = true)
    protected INCIDENCIAFACTTJTType incidenciafacttjt;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "MOTIVO_INCIDENCIA")
    protected int motivoincidencia;

    public INCIDENCIAFACTTJTType getINCIDENCIAFACTTJT() {
        return this.incidenciafacttjt;
    }

    public void setINCIDENCIAFACTTJT(INCIDENCIAFACTTJTType iNCIDENCIAFACTTJTType) {
        this.incidenciafacttjt = iNCIDENCIAFACTTJTType;
    }

    public int getMOTIVOINCIDENCIA() {
        return this.motivoincidencia;
    }

    public void setMOTIVOINCIDENCIA(int i) {
        this.motivoincidencia = i;
    }
}
