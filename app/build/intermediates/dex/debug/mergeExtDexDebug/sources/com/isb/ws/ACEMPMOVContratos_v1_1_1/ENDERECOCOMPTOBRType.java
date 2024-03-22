package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ENDERECO_COMPTO_BR_Type", propOrder = {"enderecobr", "bairro1BR", "bairro2BR", "tipoderesidenciabr", "residedesde", "endcomprovado", "indicadoratacado", "indicadorpab"})
public class ENDERECOCOMPTOBRType {
    @XmlElement(name = "BAIRRO_1_BR", required = true)
    protected String bairro1BR;
    @XmlElement(name = "BAIRRO_2_BR", required = true)
    protected String bairro2BR;
    @XmlElement(name = "END_COMPROVADO", required = true)
    protected String endcomprovado;
    @XmlElement(name = "ENDERECO_BR", required = true)
    protected String enderecobr;
    @XmlElement(name = "INDICADOR_ATACADO", required = true)
    protected String indicadoratacado;
    @XmlElement(name = "INDICADOR_PAB", required = true)
    protected String indicadorpab;
    @XmlElement(name = "RESIDE_DESDE", required = true)
    protected String residedesde;
    @XmlElement(name = "TIPO_DE_RESIDENCIA_BR", required = true)
    protected String tipoderesidenciabr;

    public String getENDERECOBR() {
        return this.enderecobr;
    }

    public void setENDERECOBR(String str) {
        this.enderecobr = str;
    }

    public String getBAIRRO1BR() {
        return this.bairro1BR;
    }

    public void setBAIRRO1BR(String str) {
        this.bairro1BR = str;
    }

    public String getBAIRRO2BR() {
        return this.bairro2BR;
    }

    public void setBAIRRO2BR(String str) {
        this.bairro2BR = str;
    }

    public String getTIPODERESIDENCIABR() {
        return this.tipoderesidenciabr;
    }

    public void setTIPODERESIDENCIABR(String str) {
        this.tipoderesidenciabr = str;
    }

    public String getRESIDEDESDE() {
        return this.residedesde;
    }

    public void setRESIDEDESDE(String str) {
        this.residedesde = str;
    }

    public String getENDCOMPROVADO() {
        return this.endcomprovado;
    }

    public void setENDCOMPROVADO(String str) {
        this.endcomprovado = str;
    }

    public String getINDICADORATACADO() {
        return this.indicadoratacado;
    }

    public void setINDICADORATACADO(String str) {
        this.indicadoratacado = str;
    }

    public String getINDICADORPAB() {
        return this.indicadorpab;
    }

    public void setINDICADORPAB(String str) {
        this.indicadorpab = str;
    }
}
