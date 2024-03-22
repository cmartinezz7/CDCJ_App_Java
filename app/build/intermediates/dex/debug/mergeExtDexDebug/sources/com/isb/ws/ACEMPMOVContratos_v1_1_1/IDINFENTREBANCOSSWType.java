package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_INF_ENTRE_BANCOS_SW_Type", propOrder = {"idmensajesw", "numcampofto", "tiposubcampo", "valorfijosubcamp"})
public class IDINFENTREBANCOSSWType {
    @XmlElement(name = "ID_MENSAJE_SW", required = true)
    protected IDMENSAJESWType idmensajesw;
    @XmlElement(name = "NUM_CAMPO_FTO", required = true)
    protected String numcampofto;
    @XmlElement(name = "TIPO_SUBCAMPO", required = true)
    protected String tiposubcampo;
    @XmlElement(name = "VALOR_FIJO_SUBCAMP", required = true)
    protected String valorfijosubcamp;

    public IDMENSAJESWType getIDMENSAJESW() {
        return this.idmensajesw;
    }

    public void setIDMENSAJESW(IDMENSAJESWType iDMENSAJESWType) {
        this.idmensajesw = iDMENSAJESWType;
    }

    public String getNUMCAMPOFTO() {
        return this.numcampofto;
    }

    public void setNUMCAMPOFTO(String str) {
        this.numcampofto = str;
    }

    public String getTIPOSUBCAMPO() {
        return this.tiposubcampo;
    }

    public void setTIPOSUBCAMPO(String str) {
        this.tiposubcampo = str;
    }

    public String getVALORFIJOSUBCAMP() {
        return this.valorfijosubcamp;
    }

    public void setVALORFIJOSUBCAMP(String str) {
        this.valorfijosubcamp = str;
    }
}
