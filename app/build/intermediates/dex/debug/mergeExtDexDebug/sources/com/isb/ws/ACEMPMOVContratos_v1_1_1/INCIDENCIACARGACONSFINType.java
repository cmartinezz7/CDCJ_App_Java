package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INCIDENCIA_CARGA_CONS_FIN_Type", propOrder = {"periodo", "codsociedad", "codincidencia", "tipcarga"})
public class INCIDENCIACARGACONSFINType {
    @XmlElement(name = "COD_INCIDENCIA", required = true)
    protected String codincidencia;
    @XmlElement(name = "COD_SOCIEDAD", required = true)
    protected String codsociedad;
    @XmlElement(name = "PERIODO", required = true)
    protected PERIODOType periodo;
    @XmlElement(name = "TIP_CARGA", required = true)
    protected String tipcarga;

    public PERIODOType getPERIODO() {
        return this.periodo;
    }

    public void setPERIODO(PERIODOType pERIODOType) {
        this.periodo = pERIODOType;
    }

    public String getCODSOCIEDAD() {
        return this.codsociedad;
    }

    public void setCODSOCIEDAD(String str) {
        this.codsociedad = str;
    }

    public String getCODINCIDENCIA() {
        return this.codincidencia;
    }

    public void setCODINCIDENCIA(String str) {
        this.codincidencia = str;
    }

    public String getTIPCARGA() {
        return this.tipcarga;
    }

    public void setTIPCARGA(String str) {
        this.tipcarga = str;
    }
}
