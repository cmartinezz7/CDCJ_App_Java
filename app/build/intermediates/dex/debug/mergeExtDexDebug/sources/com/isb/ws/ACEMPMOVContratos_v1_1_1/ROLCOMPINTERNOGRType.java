package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROL_COMP_INTERNO_GR_Type", propOrder = {"tipofunciongr", "tiporolgr", "tipidentifgr", "codinternorol"})
public class ROLCOMPINTERNOGRType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_INTERNO_ROL")
    protected long codinternorol;
    @XmlElement(name = "TIP_IDENTIF_GR", required = true)
    protected TIPIDENTIFGRType tipidentifgr;
    @XmlElement(name = "TIPO_FUNCION_GR", required = true)
    protected TIPOFUNCIONGRType tipofunciongr;
    @XmlElement(name = "TIPO_ROL_GR", required = true)
    protected TIPOROLGRType tiporolgr;

    public TIPOFUNCIONGRType getTIPOFUNCIONGR() {
        return this.tipofunciongr;
    }

    public void setTIPOFUNCIONGR(TIPOFUNCIONGRType tIPOFUNCIONGRType) {
        this.tipofunciongr = tIPOFUNCIONGRType;
    }

    public TIPOROLGRType getTIPOROLGR() {
        return this.tiporolgr;
    }

    public void setTIPOROLGR(TIPOROLGRType tIPOROLGRType) {
        this.tiporolgr = tIPOROLGRType;
    }

    public TIPIDENTIFGRType getTIPIDENTIFGR() {
        return this.tipidentifgr;
    }

    public void setTIPIDENTIFGR(TIPIDENTIFGRType tIPIDENTIFGRType) {
        this.tipidentifgr = tIPIDENTIFGRType;
    }

    public long getCODINTERNOROL() {
        return this.codinternorol;
    }

    public void setCODINTERNOROL(long j) {
        this.codinternorol = j;
    }
}
