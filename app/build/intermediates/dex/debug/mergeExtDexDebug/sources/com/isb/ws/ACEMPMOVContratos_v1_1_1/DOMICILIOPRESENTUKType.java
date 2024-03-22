package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOMICILIO_PRESENT_UK_Type", propOrder = {"identificadordecasa", "nombredeledificio", "nombredecalle1", "nombredecalle2", "nombrededistrito1", "nombrededistrito2", "codpaisuk", "codpostalciudad", "codpostaldomicilio"})
public class DOMICILIOPRESENTUKType {
    @XmlElement(name = "COD_PAIS_UK", required = true)
    protected String codpaisuk;
    @XmlElement(name = "COD_POSTAL_CIUDAD", required = true)
    protected String codpostalciudad;
    @XmlElement(name = "COD_POSTAL_DOMICILIO", required = true)
    protected String codpostaldomicilio;
    @XmlElement(name = "IDENTIFICADOR_DE_CASA", required = true)
    protected String identificadordecasa;
    @XmlElement(name = "NOMBRE_DE_CALLE1", required = true)
    protected String nombredecalle1;
    @XmlElement(name = "NOMBRE_DE_CALLE2", required = true)
    protected String nombredecalle2;
    @XmlElement(name = "NOMBRE_DE_DISTRITO1", required = true)
    protected String nombrededistrito1;
    @XmlElement(name = "NOMBRE_DE_DISTRITO2", required = true)
    protected String nombrededistrito2;
    @XmlElement(name = "NOMBRE_DEL_EDIFICIO", required = true)
    protected String nombredeledificio;

    public String getIDENTIFICADORDECASA() {
        return this.identificadordecasa;
    }

    public void setIDENTIFICADORDECASA(String str) {
        this.identificadordecasa = str;
    }

    public String getNOMBREDELEDIFICIO() {
        return this.nombredeledificio;
    }

    public void setNOMBREDELEDIFICIO(String str) {
        this.nombredeledificio = str;
    }

    public String getNOMBREDECALLE1() {
        return this.nombredecalle1;
    }

    public void setNOMBREDECALLE1(String str) {
        this.nombredecalle1 = str;
    }

    public String getNOMBREDECALLE2() {
        return this.nombredecalle2;
    }

    public void setNOMBREDECALLE2(String str) {
        this.nombredecalle2 = str;
    }

    public String getNOMBREDEDISTRITO1() {
        return this.nombrededistrito1;
    }

    public void setNOMBREDEDISTRITO1(String str) {
        this.nombrededistrito1 = str;
    }

    public String getNOMBREDEDISTRITO2() {
        return this.nombrededistrito2;
    }

    public void setNOMBREDEDISTRITO2(String str) {
        this.nombrededistrito2 = str;
    }

    public String getCODPAISUK() {
        return this.codpaisuk;
    }

    public void setCODPAISUK(String str) {
        this.codpaisuk = str;
    }

    public String getCODPOSTALCIUDAD() {
        return this.codpostalciudad;
    }

    public void setCODPOSTALCIUDAD(String str) {
        this.codpostalciudad = str;
    }

    public String getCODPOSTALDOMICILIO() {
        return this.codpostaldomicilio;
    }

    public void setCODPOSTALDOMICILIO(String str) {
        this.codpostaldomicilio = str;
    }
}
