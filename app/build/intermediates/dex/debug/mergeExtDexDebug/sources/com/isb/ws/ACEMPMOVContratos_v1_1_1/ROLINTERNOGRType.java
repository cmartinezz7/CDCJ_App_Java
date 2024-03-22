package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROL_INTERNO_GR_Type", propOrder = {"tipofunciongr", "tiporol", "tipidcliente", "idinternorol"})
public class ROLINTERNOGRType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ID_INTERNO_ROL")
    protected long idinternorol;
    @XmlElement(name = "TIP_ID_CLIENTE", required = true)
    protected String tipidcliente;
    @XmlElement(name = "TIPO_FUNCION_GR", required = true)
    protected TIPOFUNCIONGRType tipofunciongr;
    @XmlElement(name = "TIPO_ROL", required = true)
    protected String tiporol;

    public TIPOFUNCIONGRType getTIPOFUNCIONGR() {
        return this.tipofunciongr;
    }

    public void setTIPOFUNCIONGR(TIPOFUNCIONGRType tIPOFUNCIONGRType) {
        this.tipofunciongr = tIPOFUNCIONGRType;
    }

    public String getTIPOROL() {
        return this.tiporol;
    }

    public void setTIPOROL(String str) {
        this.tiporol = str;
    }

    public String getTIPIDCLIENTE() {
        return this.tipidcliente;
    }

    public void setTIPIDCLIENTE(String str) {
        this.tipidcliente = str;
    }

    public long getIDINTERNOROL() {
        return this.idinternorol;
    }

    public void setIDINTERNOROL(long j) {
        this.idinternorol = j;
    }
}
