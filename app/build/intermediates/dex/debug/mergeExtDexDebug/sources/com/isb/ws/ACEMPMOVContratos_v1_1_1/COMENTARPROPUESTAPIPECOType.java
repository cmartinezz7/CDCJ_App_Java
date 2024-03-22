package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMENTAR_PROPUESTA_PIPECO_Type", propOrder = {"propuestapipeco", "tipocomentariopipeco"})
public class COMENTARPROPUESTAPIPECOType {
    @XmlElement(name = "PROPUESTA_PIPECO", required = true)
    protected PROPUESTAPIPECOType propuestapipeco;
    @XmlElement(name = "TIPO_COMENTARIO_PIPECO", required = true)
    protected String tipocomentariopipeco;

    public PROPUESTAPIPECOType getPROPUESTAPIPECO() {
        return this.propuestapipeco;
    }

    public void setPROPUESTAPIPECO(PROPUESTAPIPECOType pROPUESTAPIPECOType) {
        this.propuestapipeco = pROPUESTAPIPECOType;
    }

    public String getTIPOCOMENTARIOPIPECO() {
        return this.tipocomentariopipeco;
    }

    public void setTIPOCOMENTARIOPIPECO(String str) {
        this.tipocomentariopipeco = str;
    }
}
