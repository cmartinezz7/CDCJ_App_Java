package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLAVE_AVISO_GAU_Type", propOrder = {"tipoautorizaciongau", "naturalezaavisogau", "codintaviso"})
public class CLAVEAVISOGAUType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_INT_AVISO")
    protected long codintaviso;
    @XmlElement(name = "NATURALEZA_AVISO_GAU", required = true)
    protected String naturalezaavisogau;
    @XmlElement(name = "TIPO_AUTORIZACION_GAU", required = true)
    protected TIPOAUTORIZACIONGAUType tipoautorizaciongau;

    public TIPOAUTORIZACIONGAUType getTIPOAUTORIZACIONGAU() {
        return this.tipoautorizaciongau;
    }

    public void setTIPOAUTORIZACIONGAU(TIPOAUTORIZACIONGAUType tIPOAUTORIZACIONGAUType) {
        this.tipoautorizaciongau = tIPOAUTORIZACIONGAUType;
    }

    public String getNATURALEZAAVISOGAU() {
        return this.naturalezaavisogau;
    }

    public void setNATURALEZAAVISOGAU(String str) {
        this.naturalezaavisogau = str;
    }

    public long getCODINTAVISO() {
        return this.codintaviso;
    }

    public void setCODINTAVISO(long j) {
        this.codintaviso = j;
    }
}
