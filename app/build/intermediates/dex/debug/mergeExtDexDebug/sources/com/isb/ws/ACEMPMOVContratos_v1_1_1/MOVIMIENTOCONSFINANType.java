package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOVIMIENTO_CONS_FINAN_Type", propOrder = {"entornoconsolidacfinan", "codescenario", "codsociedadaccionista", "codsociedadparticipada", "codtipocartera", "codigoemisorpartenon", "fechaoperacion", "codigoajuste", "desgloseconsofinan"})
public class MOVIMIENTOCONSFINANType {
    @XmlElement(name = "COD_ESCENARIO", required = true)
    protected String codescenario;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_AJUSTE")
    protected int codigoajuste;
    @XmlElement(name = "CODIGO_EMISOR_PARTENON", required = true)
    protected String codigoemisorpartenon;
    @XmlElement(name = "COD_SOCIEDAD_ACCIONISTA", required = true)
    protected String codsociedadaccionista;
    @XmlElement(name = "COD_SOCIEDAD_PARTICIPADA", required = true)
    protected String codsociedadparticipada;
    @XmlElement(name = "COD_TIPO_CARTERA", required = true)
    protected String codtipocartera;
    @XmlElement(name = "DESGLOSE_CONSO_FINAN", required = true)
    protected String desgloseconsofinan;
    @XmlElement(name = "ENTORNO_CONSOLIDAC_FINAN", required = true)
    protected ENTORNOCONSOLIDACFINANType entornoconsolidacfinan;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_OPERACION", required = true)
    protected XMLGregorianCalendar fechaoperacion;

    public ENTORNOCONSOLIDACFINANType getENTORNOCONSOLIDACFINAN() {
        return this.entornoconsolidacfinan;
    }

    public void setENTORNOCONSOLIDACFINAN(ENTORNOCONSOLIDACFINANType eNTORNOCONSOLIDACFINANType) {
        this.entornoconsolidacfinan = eNTORNOCONSOLIDACFINANType;
    }

    public String getCODESCENARIO() {
        return this.codescenario;
    }

    public void setCODESCENARIO(String str) {
        this.codescenario = str;
    }

    public String getCODSOCIEDADACCIONISTA() {
        return this.codsociedadaccionista;
    }

    public void setCODSOCIEDADACCIONISTA(String str) {
        this.codsociedadaccionista = str;
    }

    public String getCODSOCIEDADPARTICIPADA() {
        return this.codsociedadparticipada;
    }

    public void setCODSOCIEDADPARTICIPADA(String str) {
        this.codsociedadparticipada = str;
    }

    public String getCODTIPOCARTERA() {
        return this.codtipocartera;
    }

    public void setCODTIPOCARTERA(String str) {
        this.codtipocartera = str;
    }

    public String getCODIGOEMISORPARTENON() {
        return this.codigoemisorpartenon;
    }

    public void setCODIGOEMISORPARTENON(String str) {
        this.codigoemisorpartenon = str;
    }

    public XMLGregorianCalendar getFECHAOPERACION() {
        return this.fechaoperacion;
    }

    public void setFECHAOPERACION(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechaoperacion = xMLGregorianCalendar;
    }

    public int getCODIGOAJUSTE() {
        return this.codigoajuste;
    }

    public void setCODIGOAJUSTE(int i) {
        this.codigoajuste = i;
    }

    public String getDESGLOSECONSOFINAN() {
        return this.desgloseconsofinan;
    }

    public void setDESGLOSECONSOFINAN(String str) {
        this.desgloseconsofinan = str;
    }
}
