package com.isb.ws.WSSupernetMobile_1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "WSSupernetMobile", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
@XmlSeeAlso({ObjectFactory.class})
public interface WSSupernetMobile {
    @WebResult(targetNamespace = "")
    @RequestWrapper(className = "com.isb.ws.WSSupernetMobile_1.BuscarExpedientes", localName = "buscarExpedientes", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @ResponseWrapper(className = "com.isb.ws.WSSupernetMobile_1.BuscarExpedientesResponse", localName = "buscarExpedientesResponse", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @WebMethod
    ResultadoConsultaExpedientes buscarExpedientes(@WebParam(name = "arg0", targetNamespace = "") CriterioConsultaExpedientesProfesionales criterioConsultaExpedientesProfesionales);

    @WebResult(targetNamespace = "")
    @RequestWrapper(className = "com.isb.ws.WSSupernetMobile_1.BuscarPeticionesAcceso", localName = "buscarPeticionesAcceso", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @ResponseWrapper(className = "com.isb.ws.WSSupernetMobile_1.BuscarPeticionesAccesoResponse", localName = "buscarPeticionesAccesoResponse", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @WebMethod
    ResultadoListadoPeticiones buscarPeticionesAcceso(@WebParam(name = "arg0", targetNamespace = "") CriterioListadoPeticionesProfesionales criterioListadoPeticionesProfesionales);

    @WebResult(targetNamespace = "")
    @RequestWrapper(className = "com.isb.ws.WSSupernetMobile_1.ConsultaJuzgados", localName = "consultaJuzgados", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @ResponseWrapper(className = "com.isb.ws.WSSupernetMobile_1.ConsultaJuzgadosResponse", localName = "consultaJuzgadosResponse", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @WebMethod
    ResultadoConsultaJuzgados consultaJuzgados(@WebParam(name = "arg0", targetNamespace = "") CriterioConsultaJuzgadosProfesionales criterioConsultaJuzgadosProfesionales);

    @WebResult(targetNamespace = "")
    @RequestWrapper(className = "com.isb.ws.WSSupernetMobile_1.ConsultaMovimientos", localName = "consultaMovimientos", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @ResponseWrapper(className = "com.isb.ws.WSSupernetMobile_1.ConsultaMovimientosResponse", localName = "consultaMovimientosResponse", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @WebMethod
    ResultadoConsultaMovimientos consultaMovimientos(@WebParam(name = "arg0", targetNamespace = "") CriterioConsultaMovimientosProfesionales criterioConsultaMovimientosProfesionales);

    @WebResult(targetNamespace = "")
    @RequestWrapper(className = "com.isb.ws.WSSupernetMobile_1.DetalleExpediente", localName = "detalleExpediente", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @ResponseWrapper(className = "com.isb.ws.WSSupernetMobile_1.DetalleExpedienteResponse", localName = "detalleExpedienteResponse", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @WebMethod
    ResultadoDetalleExpediente detalleExpediente(@WebParam(name = "arg0", targetNamespace = "") CriterioDetalleExpedienteProfesionales criterioDetalleExpedienteProfesionales);

    @WebResult(targetNamespace = "")
    @RequestWrapper(className = "com.isb.ws.WSSupernetMobile_1.DetalleJuzgado", localName = "detalleJuzgado", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @ResponseWrapper(className = "com.isb.ws.WSSupernetMobile_1.DetalleJuzgadoResponse", localName = "detalleJuzgadoResponse", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @WebMethod
    ResultadoDetalleJuzgado detalleJuzgado(@WebParam(name = "arg0", targetNamespace = "") CriterioDetalleJuzgadoProfesionales criterioDetalleJuzgadoProfesionales);

    @WebResult(targetNamespace = "")
    @RequestWrapper(className = "com.isb.ws.WSSupernetMobile_1.DetalleMovimiento", localName = "detalleMovimiento", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @ResponseWrapper(className = "com.isb.ws.WSSupernetMobile_1.DetalleMovimientoResponse", localName = "detalleMovimientoResponse", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @WebMethod
    ResultadoDetalleOperacion detalleMovimiento(@WebParam(name = "arg0", targetNamespace = "") CriterioDetalleOperacionProfesionales criterioDetalleOperacionProfesionales);

    @WebResult(targetNamespace = "")
    @RequestWrapper(className = "com.isb.ws.WSSupernetMobile_1.DetallesUsuario", localName = "detallesUsuario", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @ResponseWrapper(className = "com.isb.ws.WSSupernetMobile_1.DetallesUsuarioResponse", localName = "detallesUsuarioResponse", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @WebMethod
    ResultadoDetalleUsuarioProfesionales detallesUsuario();

    @WebResult(targetNamespace = "")
    @RequestWrapper(className = "com.isb.ws.WSSupernetMobile_1.ObtenerTokenSSOProfesionales", localName = "obtenerTokenSSOProfesionales", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @ResponseWrapper(className = "com.isb.ws.WSSupernetMobile_1.ObtenerTokenSSOProfesionalesResponse", localName = "obtenerTokenSSOProfesionalesResponse", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @WebMethod
    ResultadoLogadoProfesionales obtenerTokenSSOProfesionales(@WebParam(name = "arg0", targetNamespace = "") CriterioLogadoProfesionales criterioLogadoProfesionales);

    @WebResult(targetNamespace = "")
    @RequestWrapper(className = "com.isb.ws.WSSupernetMobile_1.SolicitudAcceso", localName = "solicitudAcceso", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @ResponseWrapper(className = "com.isb.ws.WSSupernetMobile_1.SolicitudAccesoResponse", localName = "solicitudAccesoResponse", targetNamespace = "http://localhost:8081/cdcj-wssupernet-mobile/WSSupernetMobile/")
    @WebMethod
    ResultadoSolicitudAcceso solicitudAcceso(@WebParam(name = "arg0", targetNamespace = "") CriterioSolicitudAccesoProfesionales criterioSolicitudAccesoProfesionales);
}
