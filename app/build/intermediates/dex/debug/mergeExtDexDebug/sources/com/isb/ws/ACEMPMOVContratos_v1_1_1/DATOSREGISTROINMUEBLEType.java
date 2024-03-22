package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DATOS_REGISTRO_INMUEBLE_Type", propOrder = {"numeroregistro", "libro", "tomo", "folio", "seccion", "numeroregistral"})
public class DATOSREGISTROINMUEBLEType {
    @XmlElement(name = "FOLIO", required = true)
    protected String folio;
    @XmlElement(name = "LIBRO", required = true)
    protected String libro;
    @XmlElement(name = "NUMERO_REGISTRAL", required = true)
    protected String numeroregistral;
    @XmlElement(name = "NUMERO_REGISTRO", required = true)
    protected String numeroregistro;
    @XmlElement(name = "SECCION", required = true)
    protected String seccion;
    @XmlElement(name = "TOMO", required = true)
    protected String tomo;

    public String getNUMEROREGISTRO() {
        return this.numeroregistro;
    }

    public void setNUMEROREGISTRO(String str) {
        this.numeroregistro = str;
    }

    public String getLIBRO() {
        return this.libro;
    }

    public void setLIBRO(String str) {
        this.libro = str;
    }

    public String getTOMO() {
        return this.tomo;
    }

    public void setTOMO(String str) {
        this.tomo = str;
    }

    public String getFOLIO() {
        return this.folio;
    }

    public void setFOLIO(String str) {
        this.folio = str;
    }

    public String getSECCION() {
        return this.seccion;
    }

    public void setSECCION(String str) {
        this.seccion = str;
    }

    public String getNUMEROREGISTRAL() {
        return this.numeroregistral;
    }

    public void setNUMEROREGISTRAL(String str) {
        this.numeroregistral = str;
    }
}
