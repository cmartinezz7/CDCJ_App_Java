package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosPaginacion", propOrder = {"numeroPagina", "tamannoPagina", "totalPaginas"})
public class DatosPaginacion {
    protected Integer numeroPagina;
    protected Integer tamannoPagina;
    protected Integer totalPaginas;

    public Integer getNumeroPagina() {
        return this.numeroPagina;
    }

    public void setNumeroPagina(Integer num) {
        this.numeroPagina = num;
    }

    public Integer getTamannoPagina() {
        return this.tamannoPagina;
    }

    public void setTamannoPagina(Integer num) {
        this.tamannoPagina = num;
    }

    public Integer getTotalPaginas() {
        return this.totalPaginas;
    }

    public void setTotalPaginas(Integer num) {
        this.totalPaginas = num;
    }
}
