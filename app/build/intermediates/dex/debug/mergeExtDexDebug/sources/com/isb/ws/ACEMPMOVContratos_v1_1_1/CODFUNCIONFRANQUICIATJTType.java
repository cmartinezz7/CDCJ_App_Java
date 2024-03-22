package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODFUNCION_FRANQUICIA_TJT_Type", propOrder = {"empresa", "tipofranquiciadisputa", "codsolucionincidencia", "codfuncionfranquicia", "indchargeback"})
public class CODFUNCIONFRANQUICIATJTType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_FUNCION_FRANQUICIA")
    protected int codfuncionfranquicia;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_SOLUCION_INCIDENCIA")
    protected int codsolucionincidencia;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "IND_CHARGEBACK", required = true)
    protected String indchargeback;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "TIPO_FRANQUICIA_DISPUTA")
    protected int tipofranquiciadisputa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getTIPOFRANQUICIADISPUTA() {
        return this.tipofranquiciadisputa;
    }

    public void setTIPOFRANQUICIADISPUTA(int i) {
        this.tipofranquiciadisputa = i;
    }

    public int getCODSOLUCIONINCIDENCIA() {
        return this.codsolucionincidencia;
    }

    public void setCODSOLUCIONINCIDENCIA(int i) {
        this.codsolucionincidencia = i;
    }

    public int getCODFUNCIONFRANQUICIA() {
        return this.codfuncionfranquicia;
    }

    public void setCODFUNCIONFRANQUICIA(int i) {
        this.codfuncionfranquicia = i;
    }

    public String getINDCHARGEBACK() {
        return this.indchargeback;
    }

    public void setINDCHARGEBACK(String str) {
        this.indchargeback = str;
    }
}
