package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_OPERACION_MISPAG_Type", propOrder = {"naturalezapagomispag", "indtipoperacion"})
public class TIPOOPERACIONMISPAGType {
    @XmlElement(name = "IND_TIP_OPERACION", required = true)
    protected String indtipoperacion;
    @XmlElement(name = "NATURALEZA_PAGO_MISPAG", required = true)
    protected NATURALEZAPAGOMISPAGType naturalezapagomispag;

    public NATURALEZAPAGOMISPAGType getNATURALEZAPAGOMISPAG() {
        return this.naturalezapagomispag;
    }

    public void setNATURALEZAPAGOMISPAG(NATURALEZAPAGOMISPAGType nATURALEZAPAGOMISPAGType) {
        this.naturalezapagomispag = nATURALEZAPAGOMISPAGType;
    }

    public String getINDTIPOPERACION() {
        return this.indtipoperacion;
    }

    public void setINDTIPOPERACION(String str) {
        this.indtipoperacion = str;
    }
}
