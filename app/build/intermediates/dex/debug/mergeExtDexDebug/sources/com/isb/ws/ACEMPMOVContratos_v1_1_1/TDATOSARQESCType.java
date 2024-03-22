package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDATOSARQESC_Type", propOrder = {"idMaquina", "centroCompuesto", "tknRACF", "usuNotes", "password", "centro", "empresa"})
public class TDATOSARQESCType {
    @XmlElement(name = "Centro", required = true)
    protected String centro;
    @XmlElement(name = "CentroCompuesto", required = true)
    protected CENTRODECONTRATOType centroCompuesto;
    @XmlElement(name = "Empresa", required = true)
    protected String empresa;
    @XmlElement(name = "IdMaquina", required = true)
    protected String idMaquina;
    @XmlElement(name = "Password", required = true)
    protected String password;
    @XmlElement(name = "TknRACF", required = true)
    protected String tknRACF;
    @XmlElement(name = "UsuNotes", required = true)
    protected String usuNotes;

    public String getIdMaquina() {
        return this.idMaquina;
    }

    public void setIdMaquina(String str) {
        this.idMaquina = str;
    }

    public CENTRODECONTRATOType getCentroCompuesto() {
        return this.centroCompuesto;
    }

    public void setCentroCompuesto(CENTRODECONTRATOType cENTRODECONTRATOType) {
        this.centroCompuesto = cENTRODECONTRATOType;
    }

    public String getTknRACF() {
        return this.tknRACF;
    }

    public void setTknRACF(String str) {
        this.tknRACF = str;
    }

    public String getUsuNotes() {
        return this.usuNotes;
    }

    public void setUsuNotes(String str) {
        this.usuNotes = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getCentro() {
        return this.centro;
    }

    public void setCentro(String str) {
        this.centro = str;
    }

    public String getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(String str) {
        this.empresa = str;
    }
}
