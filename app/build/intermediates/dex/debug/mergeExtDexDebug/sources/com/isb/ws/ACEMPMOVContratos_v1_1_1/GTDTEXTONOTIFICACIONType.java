package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GTD_TEXTO_NOTIFICACION_Type", propOrder = {"gtdnotificacion", "ordenprfo"})
public class GTDTEXTONOTIFICACIONType {
    @XmlElement(name = "GTD_NOTIFICACION", required = true)
    protected GTDNOTIFICACIONType gtdnotificacion;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ORDENPRFO")
    protected int ordenprfo;

    public GTDNOTIFICACIONType getGTDNOTIFICACION() {
        return this.gtdnotificacion;
    }

    public void setGTDNOTIFICACION(GTDNOTIFICACIONType gTDNOTIFICACIONType) {
        this.gtdnotificacion = gTDNOTIFICACIONType;
    }

    public int getORDENPRFO() {
        return this.ordenprfo;
    }

    public void setORDENPRFO(int i) {
        this.ordenprfo = i;
    }
}
