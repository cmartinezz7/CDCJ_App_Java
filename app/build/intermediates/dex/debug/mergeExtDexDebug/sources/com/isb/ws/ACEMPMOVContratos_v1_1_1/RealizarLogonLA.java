package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "realizarLogon_LA", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1")
@XmlType(name = "", propOrder = {"entrada", "datosConexion", "datosCabecera"})
public class RealizarLogonLA {
    @XmlElement(nillable = true, required = true)
    protected ComIsbMoemc2ContratosLaFCbCBCabeceraLAKType datosCabecera;
    @XmlElement(nillable = true, required = true)
    protected ComIsbMoemc2ContratosLaFCbCBConexionSinClienteLAKType datosConexion;
    @XmlElement(nillable = true, required = true)
    protected ComIsbMoemc2ContratosLaFCbCBRealizarLogonLAEType entrada;
    @XmlAttribute(name = "facade")
    protected String facade;

    public ComIsbMoemc2ContratosLaFCbCBRealizarLogonLAEType getEntrada() {
        return this.entrada;
    }

    public void setEntrada(ComIsbMoemc2ContratosLaFCbCBRealizarLogonLAEType comIsbMoemc2ContratosLaFCbCBRealizarLogonLAEType) {
        this.entrada = comIsbMoemc2ContratosLaFCbCBRealizarLogonLAEType;
    }

    public ComIsbMoemc2ContratosLaFCbCBConexionSinClienteLAKType getDatosConexion() {
        return this.datosConexion;
    }

    public void setDatosConexion(ComIsbMoemc2ContratosLaFCbCBConexionSinClienteLAKType comIsbMoemc2ContratosLaFCbCBConexionSinClienteLAKType) {
        this.datosConexion = comIsbMoemc2ContratosLaFCbCBConexionSinClienteLAKType;
    }

    public ComIsbMoemc2ContratosLaFCbCBCabeceraLAKType getDatosCabecera() {
        return this.datosCabecera;
    }

    public void setDatosCabecera(ComIsbMoemc2ContratosLaFCbCBCabeceraLAKType comIsbMoemc2ContratosLaFCbCBCabeceraLAKType) {
        this.datosCabecera = comIsbMoemc2ContratosLaFCbCBCabeceraLAKType;
    }

    public String getFacade() {
        String str = this.facade;
        if (str == null) {
            return "ACEMPMOVContratos";
        }
        return str;
    }

    public void setFacade(String str) {
        this.facade = str;
    }
}
