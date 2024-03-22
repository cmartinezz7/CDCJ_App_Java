package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "com.isb.moemc2.contratos.la.f.cb.CB_RealizarLogon_LA_S_Type", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/santander/internet/cbTypes/v1", propOrder = {"info", "usuarioInternoEmp", "usuarioConexionEmp", "cliente", "nombreTitular", "contrato", "subtipoProd", "tipoFirma", "estadoFirma", "tipoRelacionUsu", "estadoUsuario", "firmaUsuario", "indFirmaDestino", "fecUltimoPass", "fecUltimoAcceso", "horaUltimoAcceso", "fecClave", "fecUltFirma", "telefonoOTP", "indCuentasPend", "indMedidas", "indExcepcion", "listaServicios"})
public class ComIsbMoemc2ContratosLaFCbCBRealizarLogonLASType {
    protected NUMPERSONACLIENTEType cliente;
    protected CONTRATOType contrato;
    protected String estadoFirma;
    protected String estadoUsuario;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecClave;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecUltFirma;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecUltimoAcceso;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecUltimoPass;
    protected String firmaUsuario;
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar horaUltimoAcceso;
    protected String indCuentasPend;
    protected String indExcepcion;
    protected String indFirmaDestino;
    protected String indMedidas;
    protected ComIsbMoemc2ContratosLaFCbCBDatosSalidaInfoDescLAKType info;
    protected ComIsbMoemc2ContratosLaFCbCBRealizarLogonLAIType listaServicios;
    protected String nombreTitular;
    protected SUBTIPODEPRODUCTOType subtipoProd;
    protected String telefonoOTP;
    protected String tipoFirma;
    protected String tipoRelacionUsu;
    protected String usuarioConexionEmp;
    protected String usuarioInternoEmp;

    public ComIsbMoemc2ContratosLaFCbCBDatosSalidaInfoDescLAKType getInfo() {
        return this.info;
    }

    public void setInfo(ComIsbMoemc2ContratosLaFCbCBDatosSalidaInfoDescLAKType comIsbMoemc2ContratosLaFCbCBDatosSalidaInfoDescLAKType) {
        this.info = comIsbMoemc2ContratosLaFCbCBDatosSalidaInfoDescLAKType;
    }

    public String getUsuarioInternoEmp() {
        return this.usuarioInternoEmp;
    }

    public void setUsuarioInternoEmp(String str) {
        this.usuarioInternoEmp = str;
    }

    public String getUsuarioConexionEmp() {
        return this.usuarioConexionEmp;
    }

    public void setUsuarioConexionEmp(String str) {
        this.usuarioConexionEmp = str;
    }

    public NUMPERSONACLIENTEType getCliente() {
        return this.cliente;
    }

    public void setCliente(NUMPERSONACLIENTEType nUMPERSONACLIENTEType) {
        this.cliente = nUMPERSONACLIENTEType;
    }

    public String getNombreTitular() {
        return this.nombreTitular;
    }

    public void setNombreTitular(String str) {
        this.nombreTitular = str;
    }

    public CONTRATOType getContrato() {
        return this.contrato;
    }

    public void setContrato(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public SUBTIPODEPRODUCTOType getSubtipoProd() {
        return this.subtipoProd;
    }

    public void setSubtipoProd(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipoProd = sUBTIPODEPRODUCTOType;
    }

    public String getTipoFirma() {
        return this.tipoFirma;
    }

    public void setTipoFirma(String str) {
        this.tipoFirma = str;
    }

    public String getEstadoFirma() {
        return this.estadoFirma;
    }

    public void setEstadoFirma(String str) {
        this.estadoFirma = str;
    }

    public String getTipoRelacionUsu() {
        return this.tipoRelacionUsu;
    }

    public void setTipoRelacionUsu(String str) {
        this.tipoRelacionUsu = str;
    }

    public String getEstadoUsuario() {
        return this.estadoUsuario;
    }

    public void setEstadoUsuario(String str) {
        this.estadoUsuario = str;
    }

    public String getFirmaUsuario() {
        return this.firmaUsuario;
    }

    public void setFirmaUsuario(String str) {
        this.firmaUsuario = str;
    }

    public String getIndFirmaDestino() {
        return this.indFirmaDestino;
    }

    public void setIndFirmaDestino(String str) {
        this.indFirmaDestino = str;
    }

    public XMLGregorianCalendar getFecUltimoPass() {
        return this.fecUltimoPass;
    }

    public void setFecUltimoPass(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fecUltimoPass = xMLGregorianCalendar;
    }

    public XMLGregorianCalendar getFecUltimoAcceso() {
        return this.fecUltimoAcceso;
    }

    public void setFecUltimoAcceso(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fecUltimoAcceso = xMLGregorianCalendar;
    }

    public XMLGregorianCalendar getHoraUltimoAcceso() {
        return this.horaUltimoAcceso;
    }

    public void setHoraUltimoAcceso(XMLGregorianCalendar xMLGregorianCalendar) {
        this.horaUltimoAcceso = xMLGregorianCalendar;
    }

    public XMLGregorianCalendar getFecClave() {
        return this.fecClave;
    }

    public void setFecClave(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fecClave = xMLGregorianCalendar;
    }

    public XMLGregorianCalendar getFecUltFirma() {
        return this.fecUltFirma;
    }

    public void setFecUltFirma(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fecUltFirma = xMLGregorianCalendar;
    }

    public String getTelefonoOTP() {
        return this.telefonoOTP;
    }

    public void setTelefonoOTP(String str) {
        this.telefonoOTP = str;
    }

    public String getIndCuentasPend() {
        return this.indCuentasPend;
    }

    public void setIndCuentasPend(String str) {
        this.indCuentasPend = str;
    }

    public String getIndMedidas() {
        return this.indMedidas;
    }

    public void setIndMedidas(String str) {
        this.indMedidas = str;
    }

    public String getIndExcepcion() {
        return this.indExcepcion;
    }

    public void setIndExcepcion(String str) {
        this.indExcepcion = str;
    }

    public ComIsbMoemc2ContratosLaFCbCBRealizarLogonLAIType getListaServicios() {
        return this.listaServicios;
    }

    public void setListaServicios(ComIsbMoemc2ContratosLaFCbCBRealizarLogonLAIType comIsbMoemc2ContratosLaFCbCBRealizarLogonLAIType) {
        this.listaServicios = comIsbMoemc2ContratosLaFCbCBRealizarLogonLAIType;
    }
}
