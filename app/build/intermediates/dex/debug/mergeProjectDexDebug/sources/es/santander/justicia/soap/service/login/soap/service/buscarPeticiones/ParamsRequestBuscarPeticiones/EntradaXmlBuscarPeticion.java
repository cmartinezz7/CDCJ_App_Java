package es.santander.justicia.soap.service.login.soap.service.buscarPeticiones.ParamsRequestBuscarPeticiones;

import es.santander.justicia.soap.service.login.soap.service.ListaPeticiones.ParamsRequestListPetition.DatosFiltradoPetition;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class EntradaXmlBuscarPeticion implements KvmSerializable {
    private DatosAcessoProfesionalesBusqueda datosAcessoProfesionales;
    private DatosFiltradoPetition datosFiltrado;
    private DatosPaginacion datosPaginacion;

    public EntradaXmlBuscarPeticion() {
    }

    public EntradaXmlBuscarPeticion(DatosAcessoProfesionalesBusqueda datosAcessoProfesionales2, DatosFiltradoPetition datosFiltrado2, DatosPaginacion datosPaginacion2) {
        this.datosAcessoProfesionales = datosAcessoProfesionales2;
        this.datosFiltrado = datosFiltrado2;
        this.datosPaginacion = datosPaginacion2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.datosAcessoProfesionales;
        }
        if (index == 1) {
            return this.datosFiltrado;
        }
        if (index != 2) {
            return null;
        }
        return this.datosPaginacion;
    }

    public int getPropertyCount() {
        return 3;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.datosAcessoProfesionales = (DatosAcessoProfesionalesBusqueda) value;
        } else if (index != 1) {
            if (index != 2) {
                return;
            }
            this.datosPaginacion = (DatosPaginacion) value;
        }
        this.datosFiltrado = (DatosFiltradoPetition) value;
        this.datosPaginacion = (DatosPaginacion) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosAccesoProfesionales";
        } else if (index == 1) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosFiltrado";
        } else if (index == 2) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "datosPaginacion";
        }
    }
}
