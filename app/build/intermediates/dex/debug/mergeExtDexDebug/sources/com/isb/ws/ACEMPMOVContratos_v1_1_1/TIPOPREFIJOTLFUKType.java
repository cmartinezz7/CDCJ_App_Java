package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_PREFIJO_TLF_UK_Type", propOrder = {"tiponumerotelefonico", "codigoalfanum5"})
public class TIPOPREFIJOTLFUKType {
    @XmlElement(name = "CODIGO_ALFANUM_5", required = true)
    protected String codigoalfanum5;
    @XmlElement(name = "TIPO_NUMERO_TELEFONICO", required = true)
    protected String tiponumerotelefonico;

    public String getTIPONUMEROTELEFONICO() {
        return this.tiponumerotelefonico;
    }

    public void setTIPONUMEROTELEFONICO(String str) {
        this.tiponumerotelefonico = str;
    }

    public String getCODIGOALFANUM5() {
        return this.codigoalfanum5;
    }

    public void setCODIGOALFANUM5(String str) {
        this.codigoalfanum5 = str;
    }
}
