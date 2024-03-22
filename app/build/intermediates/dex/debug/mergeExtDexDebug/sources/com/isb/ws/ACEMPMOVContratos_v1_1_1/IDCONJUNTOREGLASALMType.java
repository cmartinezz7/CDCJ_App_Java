package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_CONJUNTO_REGLAS_ALM_Type", propOrder = {"codigotiporiesgoalm", "codigocatalogoalm", "codigotipocontratoalm", "codigoconjreglas"})
public class IDCONJUNTOREGLASALMType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_CATALOGO_ALM")
    protected long codigocatalogoalm;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_CONJ_REGLAS")
    protected long codigoconjreglas;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_TIPO_CONTRATO_ALM")
    protected int codigotipocontratoalm;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_TIPO_RIESGO_ALM")
    protected int codigotiporiesgoalm;

    public int getCODIGOTIPORIESGOALM() {
        return this.codigotiporiesgoalm;
    }

    public void setCODIGOTIPORIESGOALM(int i) {
        this.codigotiporiesgoalm = i;
    }

    public long getCODIGOCATALOGOALM() {
        return this.codigocatalogoalm;
    }

    public void setCODIGOCATALOGOALM(long j) {
        this.codigocatalogoalm = j;
    }

    public int getCODIGOTIPOCONTRATOALM() {
        return this.codigotipocontratoalm;
    }

    public void setCODIGOTIPOCONTRATOALM(int i) {
        this.codigotipocontratoalm = i;
    }

    public long getCODIGOCONJREGLAS() {
        return this.codigoconjreglas;
    }

    public void setCODIGOCONJREGLAS(long j) {
        this.codigoconjreglas = j;
    }
}
