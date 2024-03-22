package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ENTRADA_SACBAS_Type", propOrder = {"aplicacionextsacbas", "codentradasacbas"})
public class ENTRADASACBASType {
    @XmlElement(name = "APLICACION_EXT_SACBAS", required = true)
    protected APLICACIONEXTSACBASType aplicacionextsacbas;
    @XmlElement(name = "COD_ENTRADA_SACBAS", required = true)
    protected String codentradasacbas;

    public APLICACIONEXTSACBASType getAPLICACIONEXTSACBAS() {
        return this.aplicacionextsacbas;
    }

    public void setAPLICACIONEXTSACBAS(APLICACIONEXTSACBASType aPLICACIONEXTSACBASType) {
        this.aplicacionextsacbas = aPLICACIONEXTSACBASType;
    }

    public String getCODENTRADASACBAS() {
        return this.codentradasacbas;
    }

    public void setCODENTRADASACBAS(String str) {
        this.codentradasacbas = str;
    }
}
