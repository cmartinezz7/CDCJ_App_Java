package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FILE_HANDLER_Type", propOrder = {"repositorioalias", "uri", "filename", "mimetype", "transformations"})
public class FILEHANDLERType {
    @XmlElement(name = "FILE_NAME", required = true)
    protected String filename;
    @XmlElement(name = "MIME_TYPE", required = true)
    protected String mimetype;
    @XmlElement(name = "REPOSITORIO_ALIAS", required = true)
    protected String repositorioalias;
    @XmlElement(name = "TRANSFORMATIONS", required = true)
    protected String transformations;
    @XmlElement(name = "URI", required = true)
    protected String uri;

    public String getREPOSITORIOALIAS() {
        return this.repositorioalias;
    }

    public void setREPOSITORIOALIAS(String str) {
        this.repositorioalias = str;
    }

    public String getURI() {
        return this.uri;
    }

    public void setURI(String str) {
        this.uri = str;
    }

    public String getFILENAME() {
        return this.filename;
    }

    public void setFILENAME(String str) {
        this.filename = str;
    }

    public String getMIMETYPE() {
        return this.mimetype;
    }

    public void setMIMETYPE(String str) {
        this.mimetype = str;
    }

    public String getTRANSFORMATIONS() {
        return this.transformations;
    }

    public void setTRANSFORMATIONS(String str) {
        this.transformations = str;
    }
}
