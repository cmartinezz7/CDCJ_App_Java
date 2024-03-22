package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOMICILIO_PRESENT_ESPE_Type", propOrder = {"descripciondomicilio", "localidad", "codigopostal", "distrito", "concelho", "freguesia", "codigoderegion"})
public class DOMICILIOPRESENTESPEType {
    @XmlElement(name = "CODIGO_DE_REGION", required = true)
    protected String codigoderegion;
    @XmlElement(name = "CODIGO_POSTAL", required = true)
    protected String codigopostal;
    @XmlElement(name = "CONCELHO", required = true)
    protected String concelho;
    @XmlElement(name = "DESCRIPCION_DOMICILIO", required = true)
    protected String descripciondomicilio;
    @XmlElement(name = "DISTRITO", required = true)
    protected String distrito;
    @XmlElement(name = "FREGUESIA", required = true)
    protected String freguesia;
    @XmlElement(name = "LOCALIDAD", required = true)
    protected String localidad;

    public String getDESCRIPCIONDOMICILIO() {
        return this.descripciondomicilio;
    }

    public void setDESCRIPCIONDOMICILIO(String str) {
        this.descripciondomicilio = str;
    }

    public String getLOCALIDAD() {
        return this.localidad;
    }

    public void setLOCALIDAD(String str) {
        this.localidad = str;
    }

    public String getCODIGOPOSTAL() {
        return this.codigopostal;
    }

    public void setCODIGOPOSTAL(String str) {
        this.codigopostal = str;
    }

    public String getDISTRITO() {
        return this.distrito;
    }

    public void setDISTRITO(String str) {
        this.distrito = str;
    }

    public String getCONCELHO() {
        return this.concelho;
    }

    public void setCONCELHO(String str) {
        this.concelho = str;
    }

    public String getFREGUESIA() {
        return this.freguesia;
    }

    public void setFREGUESIA(String str) {
        this.freguesia = str;
    }

    public String getCODIGODEREGION() {
        return this.codigoderegion;
    }

    public void setCODIGODEREGION(String str) {
        this.codigoderegion = str;
    }
}
