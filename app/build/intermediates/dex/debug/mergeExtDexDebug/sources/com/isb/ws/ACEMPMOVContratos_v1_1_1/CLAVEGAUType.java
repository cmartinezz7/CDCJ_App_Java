package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLAVE_GAU_Type", propOrder = {"tipoautorizaciongau", "codinternogau"})
public class CLAVEGAUType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_INTERNO_GAU")
    protected long codinternogau;
    @XmlElement(name = "TIPO_AUTORIZACION_GAU", required = true)
    protected TIPOAUTORIZACIONGAUType tipoautorizaciongau;

    public TIPOAUTORIZACIONGAUType getTIPOAUTORIZACIONGAU() {
        return this.tipoautorizaciongau;
    }

    public void setTIPOAUTORIZACIONGAU(TIPOAUTORIZACIONGAUType tIPOAUTORIZACIONGAUType) {
        this.tipoautorizaciongau = tIPOAUTORIZACIONGAUType;
    }

    public long getCODINTERNOGAU() {
        return this.codinternogau;
    }

    public void setCODINTERNOGAU(long j) {
        this.codinternogau = j;
    }
}
