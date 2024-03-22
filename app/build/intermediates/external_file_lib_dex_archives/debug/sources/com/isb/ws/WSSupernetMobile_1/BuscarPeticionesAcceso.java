package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarPeticionesAcceso", propOrder = {"arg0"})
public class BuscarPeticionesAcceso {
    protected CriterioListadoPeticionesProfesionales arg0;

    public CriterioListadoPeticionesProfesionales getArg0() {
        return this.arg0;
    }

    public void setArg0(CriterioListadoPeticionesProfesionales criterioListadoPeticionesProfesionales) {
        this.arg0 = criterioListadoPeticionesProfesionales;
    }
}
