package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CIUDAD_EEUU_Type", propOrder = {"codestadoeeuu", "codigocondado", "codciudadusa"})
public class CIUDADEEUUType {
    @XmlElement(name = "COD_CIUDAD_USA", required = true)
    protected String codciudadusa;
    @XmlElement(name = "COD_ESTADO_EEUU", required = true)
    protected String codestadoeeuu;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_CONDADO")
    protected int codigocondado;

    public String getCODESTADOEEUU() {
        return this.codestadoeeuu;
    }

    public void setCODESTADOEEUU(String str) {
        this.codestadoeeuu = str;
    }

    public int getCODIGOCONDADO() {
        return this.codigocondado;
    }

    public void setCODIGOCONDADO(int i) {
        this.codigocondado = i;
    }

    public String getCODCIUDADUSA() {
        return this.codciudadusa;
    }

    public void setCODCIUDADUSA(String str) {
        this.codciudadusa = str;
    }
}
