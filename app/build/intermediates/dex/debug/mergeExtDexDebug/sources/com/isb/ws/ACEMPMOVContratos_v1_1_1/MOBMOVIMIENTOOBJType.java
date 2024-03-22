package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_MOVIMIENTO_OBJ_Type", propOrder = {"mobidentificadorobj", "concecptodgo", "mobcaracteristica", "fechainicio"})
public class MOBMOVIMIENTOOBJType {
    @XmlElement(name = "CONCECPTO_DGO", required = true)
    protected String concecptodgo;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_INICIO", required = true)
    protected XMLGregorianCalendar fechainicio;
    @XmlElement(name = "MOB_CARACTERISTICA", required = true)
    protected MOBCARACTERISTICAType mobcaracteristica;
    @XmlElement(name = "MOB_IDENTIFICADOR_OBJ", required = true)
    protected MOBIDENTIFICADOROBJType mobidentificadorobj;

    public MOBIDENTIFICADOROBJType getMOBIDENTIFICADOROBJ() {
        return this.mobidentificadorobj;
    }

    public void setMOBIDENTIFICADOROBJ(MOBIDENTIFICADOROBJType mOBIDENTIFICADOROBJType) {
        this.mobidentificadorobj = mOBIDENTIFICADOROBJType;
    }

    public String getCONCECPTODGO() {
        return this.concecptodgo;
    }

    public void setCONCECPTODGO(String str) {
        this.concecptodgo = str;
    }

    public MOBCARACTERISTICAType getMOBCARACTERISTICA() {
        return this.mobcaracteristica;
    }

    public void setMOBCARACTERISTICA(MOBCARACTERISTICAType mOBCARACTERISTICAType) {
        this.mobcaracteristica = mOBCARACTERISTICAType;
    }

    public XMLGregorianCalendar getFECHAINICIO() {
        return this.fechainicio;
    }

    public void setFECHAINICIO(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechainicio = xMLGregorianCalendar;
    }
}
