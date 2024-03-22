package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_GR_Type", propOrder = {"tipofunciongr", "codigoderol", "tipidentifgr", "tipidentifprivada"})
public class SUBTIPOGRType {
    @XmlElement(name = "CODIGO_DE_ROL", required = true)
    protected String codigoderol;
    @XmlElement(name = "TIP_IDENTIF_GR", required = true)
    protected String tipidentifgr;
    @XmlElement(name = "TIP_IDENTIF_PRIVADA", required = true)
    protected String tipidentifprivada;
    @XmlElement(name = "TIPO_FUNCION_GR", required = true)
    protected TIPOFUNCIONGRType tipofunciongr;

    public TIPOFUNCIONGRType getTIPOFUNCIONGR() {
        return this.tipofunciongr;
    }

    public void setTIPOFUNCIONGR(TIPOFUNCIONGRType tIPOFUNCIONGRType) {
        this.tipofunciongr = tIPOFUNCIONGRType;
    }

    public String getCODIGODEROL() {
        return this.codigoderol;
    }

    public void setCODIGODEROL(String str) {
        this.codigoderol = str;
    }

    public String getTIPIDENTIFGR() {
        return this.tipidentifgr;
    }

    public void setTIPIDENTIFGR(String str) {
        this.tipidentifgr = str;
    }

    public String getTIPIDENTIFPRIVADA() {
        return this.tipidentifprivada;
    }

    public void setTIPIDENTIFPRIVADA(String str) {
        this.tipidentifprivada = str;
    }
}
