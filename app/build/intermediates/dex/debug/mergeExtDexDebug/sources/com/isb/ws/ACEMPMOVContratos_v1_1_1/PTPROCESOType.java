package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PT_PROCESO_Type", propOrder = {"ptoficina", "ptnumerodecuenta", "ptversionproceso"})
public class PTPROCESOType {
    @XmlElement(name = "PT_NUMERO_DE_CUENTA", required = true)
    protected String ptnumerodecuenta;
    @XmlElement(name = "PT_OFICINA", required = true)
    protected String ptoficina;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "PT_VERSION_PROCESO")
    protected int ptversionproceso;

    public String getPTOFICINA() {
        return this.ptoficina;
    }

    public void setPTOFICINA(String str) {
        this.ptoficina = str;
    }

    public String getPTNUMERODECUENTA() {
        return this.ptnumerodecuenta;
    }

    public void setPTNUMERODECUENTA(String str) {
        this.ptnumerodecuenta = str;
    }

    public int getPTVERSIONPROCESO() {
        return this.ptversionproceso;
    }

    public void setPTVERSIONPROCESO(int i) {
        this.ptversionproceso = i;
    }
}
