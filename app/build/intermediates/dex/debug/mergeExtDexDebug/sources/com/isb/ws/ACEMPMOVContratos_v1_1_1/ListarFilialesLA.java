package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "listarFiliales_LA", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1")
@XmlType(name = "", propOrder = {"entrada", "datosConexion", "datosCabecera"})
public class ListarFilialesLA {
    @XmlElement(nillable = true, required = true)
    protected ComIsbMoemc2ContratosLaFCbCBCabeceraLAKType datosCabecera;
    @XmlElement(nillable = true, required = true)
    protected ComIsbMoemc2ContratosLaFCbCBConexionLAKType datosConexion;
    @XmlElement(nillable = true, required = true)
    protected ComIsbMoemc2ContratosLaFCbCBListarFilialesLAEType entrada;
    @XmlAttribute(name = "facade")
    protected String facade;

    public ComIsbMoemc2ContratosLaFCbCBListarFilialesLAEType getEntrada() {
        return this.entrada;
    }

    public void setEntrada(ComIsbMoemc2ContratosLaFCbCBListarFilialesLAEType comIsbMoemc2ContratosLaFCbCBListarFilialesLAEType) {
        this.entrada = comIsbMoemc2ContratosLaFCbCBListarFilialesLAEType;
    }

    public ComIsbMoemc2ContratosLaFCbCBConexionLAKType getDatosConexion() {
        return this.datosConexion;
    }

    public void setDatosConexion(ComIsbMoemc2ContratosLaFCbCBConexionLAKType comIsbMoemc2ContratosLaFCbCBConexionLAKType) {
        this.datosConexion = comIsbMoemc2ContratosLaFCbCBConexionLAKType;
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
