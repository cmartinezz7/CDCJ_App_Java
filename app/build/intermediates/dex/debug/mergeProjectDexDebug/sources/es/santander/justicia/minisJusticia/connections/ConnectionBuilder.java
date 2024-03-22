package es.santander.justicia.minisJusticia.connections;

import android.content.Context;
import es.santander.justicia.minisJusticia.connections.CallInteface;
import es.santander.justicia.minisJusticia.models.requests.DatosFiltradoRequest;
import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import es.santander.justicia.minisJusticia.models.requests.GlobalContratosRequestEnvelope;
import es.santander.justicia.minisJusticia.models.requests.GlobalRequestEnvelope;
import es.santander.justicia.minisJusticia.models.requests.activarExpediente.ActivarExpedienteArg0;
import es.santander.justicia.minisJusticia.models.requests.activarExpediente.ActivarExpedienteArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.activarExpediente.ActivarExpedienteRequestBody;
import es.santander.justicia.minisJusticia.models.requests.advices.AdvicesArg0;
import es.santander.justicia.minisJusticia.models.requests.advices.AdvicesArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.advices.AdvicesRequestBodyRequest;
import es.santander.justicia.minisJusticia.models.requests.altaAutorizacion.AltaAutorizacionArg0;
import es.santander.justicia.minisJusticia.models.requests.altaAutorizacion.AltaAutorizacionRequestBody;
import es.santander.justicia.minisJusticia.models.requests.altaAutorizacion.AltaAutorizationArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.authJuzgados.AuthJuzgadosArg0;
import es.santander.justicia.minisJusticia.models.requests.authJuzgados.AuthJuzgadosArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.authJuzgados.AuthJuzgadosRequestBody;
import es.santander.justicia.minisJusticia.models.requests.bajaEmbargo.BajaEmbargoArg0;
import es.santander.justicia.minisJusticia.models.requests.bajaEmbargo.BajaEmbargoArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.bajaEmbargo.BajaEmbargoRequestBody;
import es.santander.justicia.minisJusticia.models.requests.buscPetAcceso.BuscPetArg0;
import es.santander.justicia.minisJusticia.models.requests.buscPetAcceso.BuscPetArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.buscPetAcceso.BuscPetRequestBody;
import es.santander.justicia.minisJusticia.models.requests.buscarExpedientes.BuscarExpedientesArg0;
import es.santander.justicia.minisJusticia.models.requests.buscarExpedientes.BuscarExpedientesArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.buscarExpedientes.BuscarExpedientesRequestBody;
import es.santander.justicia.minisJusticia.models.requests.buscarExpedientes.DatosAcceso;
import es.santander.justicia.minisJusticia.models.requests.buscarExpedientes.DatosExpediente;
import es.santander.justicia.minisJusticia.models.requests.cambiarOrganismo.CambarOrganismoAsigArg0;
import es.santander.justicia.minisJusticia.models.requests.cambiarOrganismo.CambiarOrganismoArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.cambiarOrganismo.CambiarOrganismoRequestBody;
import es.santander.justicia.minisJusticia.models.requests.consultaJuzgados.ConsultaJuzgadosArg0;
import es.santander.justicia.minisJusticia.models.requests.consultaJuzgados.ConsultaJuzgadosArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.consultaJuzgados.ConsultaJuzgadosRequestBody;
import es.santander.justicia.minisJusticia.models.requests.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.minisJusticia.models.requests.consultaOperacion.ConsultaOperacionArg0;
import es.santander.justicia.minisJusticia.models.requests.consultaOperacion.ConsultaOperacionArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.consultaOperacion.ConsultaOperacionRequestBody;
import es.santander.justicia.minisJusticia.models.requests.consultaOrganismosAsignados.ConsultaOrganosAsignadosReqBody;
import es.santander.justicia.minisJusticia.models.requests.contratos.ContratoEntradaDetail;
import es.santander.justicia.minisJusticia.models.requests.contratos.ContratosConexionBody;
import es.santander.justicia.minisJusticia.models.requests.contratos.ContratosEntrada;
import es.santander.justicia.minisJusticia.models.requests.contratos.ContratosParaguasBody;
import es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion.DetalleAutorizacionArg0;
import es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion.DetalleAutorizacionArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion.DetalleAutorizacionRequestBody;
import es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion.DetalleAutorizacionUsuario;
import es.santander.justicia.minisJusticia.models.requests.detalleExp.DetalleExpArg0;
import es.santander.justicia.minisJusticia.models.requests.detalleExp.DetalleExpArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.detalleExp.DetalleExpDatosExp;
import es.santander.justicia.minisJusticia.models.requests.detalleExp.DetalleExpDatosExpDetail;
import es.santander.justicia.minisJusticia.models.requests.detalleExp.DetalleExpRequestBody;
import es.santander.justicia.minisJusticia.models.requests.detalleJuzgado.DetalleJuzgadoArg0;
import es.santander.justicia.minisJusticia.models.requests.detalleJuzgado.DetalleJuzgadoArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.detalleJuzgado.DetalleJuzgadoRequestBody;
import es.santander.justicia.minisJusticia.models.requests.detalleMovimiento.DetalleMovArg0;
import es.santander.justicia.minisJusticia.models.requests.detalleMovimiento.DetalleMovArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.detalleMovimiento.DetalleMovDatosExp;
import es.santander.justicia.minisJusticia.models.requests.detalleMovimiento.DetalleMovDatosOperRequest;
import es.santander.justicia.minisJusticia.models.requests.detalleMovimiento.DetalleMovRequestBody;
import es.santander.justicia.minisJusticia.models.requests.detalleMovimiento.DetalleMovementSaldos;
import es.santander.justicia.minisJusticia.models.requests.detallePetAcceso.DetallePetAccArg0;
import es.santander.justicia.minisJusticia.models.requests.detallePetAcceso.DetallePetAccArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.detallePetAcceso.DetallePetAcceRequestBody;
import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpedienteDetail;
import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.ListaMoveArg0;
import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.ListaMoveArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.ListaMovimientosRequestBody;
import es.santander.justicia.minisJusticia.models.requests.login.LoginArg0;
import es.santander.justicia.minisJusticia.models.requests.login.LoginArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.login.LoginBodyRequestBody;
import es.santander.justicia.minisJusticia.models.requests.login.LoginRequestEnvelope;
import es.santander.justicia.minisJusticia.models.requests.login.LogoutRequestBodyRequest;
import es.santander.justicia.minisJusticia.models.requests.loginUnico.LoginUnicoEntrada;
import es.santander.justicia.minisJusticia.models.requests.loginUnico.LoginUnicoEntradaDetail;
import es.santander.justicia.minisJusticia.models.requests.loginUnico.LoginUnicoRequestBody;
import es.santander.justicia.minisJusticia.models.requests.modificarAutorizacion.ModificarAutorizacionArg0;
import es.santander.justicia.minisJusticia.models.requests.modificarAutorizacion.ModificarAutorizacionArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.modificarAutorizacion.ModificarAutorizacionRequestBody;
import es.santander.justicia.minisJusticia.models.requests.obtenerDatosLoginLA.ObtenerDatosLoginEntrada;
import es.santander.justicia.minisJusticia.models.requests.obtenerDatosLoginLA.ObtenerDatosLoginEntradaDetail;
import es.santander.justicia.minisJusticia.models.requests.obtenerDatosLoginLA.ObtenerDatosLoginRequestBody;
import es.santander.justicia.minisJusticia.models.requests.operacionesEjecutadas.OperEjectArg0;
import es.santander.justicia.minisJusticia.models.requests.operacionesEjecutadas.OperEjectArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.operacionesEjecutadas.OperEjectRequestBody;
import es.santander.justicia.minisJusticia.models.requests.operacionesPendientes.OpePendArg0;
import es.santander.justicia.minisJusticia.models.requests.operacionesPendientes.OpePendArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.operacionesPendientes.OperPendRequestBody;
import es.santander.justicia.minisJusticia.models.requests.operativas.AceptarSolicitudRequesBody;
import es.santander.justicia.minisJusticia.models.requests.operativas.BajaSolicitudRequestBody;
import es.santander.justicia.minisJusticia.models.requests.operativas.DenegarSolicitudRequestBody;
import es.santander.justicia.minisJusticia.models.requests.operativas.ModificarSolicitudRequestBody;
import es.santander.justicia.minisJusticia.models.requests.operativas.OperativasGlobalArg0;
import es.santander.justicia.minisJusticia.models.requests.operativas.OperativasGlobalArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.operativasOperaciones.AnularOpPteCobroRequestBody;
import es.santander.justicia.minisJusticia.models.requests.operativasOperaciones.AnularOpPteConfRequesBody;
import es.santander.justicia.minisJusticia.models.requests.operativasOperaciones.AnularOpPteIngresoRequestBody;
import es.santander.justicia.minisJusticia.models.requests.operativasOperaciones.ConfirmarOpPteConfiRequestBody;
import es.santander.justicia.minisJusticia.models.requests.operativasOperaciones.OperDatosOperacion;
import es.santander.justicia.minisJusticia.models.requests.operativasOperaciones.OperGlobalArg0;
import es.santander.justicia.minisJusticia.models.requests.operativasOperaciones.OperGlobalArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.resolverAutorizacion.AutorizacionRetrocesionDto;
import es.santander.justicia.minisJusticia.models.requests.resolverAutorizacion.ResolverAutorizacionArg0;
import es.santander.justicia.minisJusticia.models.requests.resolverAutorizacion.ResolverAutorizacionArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.resolverAutorizacion.ResolverAutorizacionRequestBody;
import es.santander.justicia.minisJusticia.models.requests.seizures.EmbargoArg0;
import es.santander.justicia.minisJusticia.models.requests.seizures.EmbargoArgo0Detail;
import es.santander.justicia.minisJusticia.models.requests.seizures.EmbargoRequestBody;
import es.santander.justicia.minisJusticia.models.requests.userDetail.UserDetailRequestBodyRequest;
import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew;
import es.santander.justicia.minisJusticia.models.responses.GlobalReponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.aceptarSolicitud.AceptarSolicitudResponseEnvelopment;
import es.santander.justicia.minisJusticia.models.responses.activarExpediente.ActivarExpedienteResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.anularOpPteCobro.AnularOpPteCobroResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.anularOpPteConfirmacion.AnularOpPteConfirmacionResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.anularOpPteIngreso.AnularOpPteIngresoResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.authjuzados.AutorizacionesUsuarioEnvelope;
import es.santander.justicia.minisJusticia.models.responses.avisos.AvisosResponseEnvelop;
import es.santander.justicia.minisJusticia.models.responses.bajaEmbargo.BajaEmbargoResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.bajaSolicitud.BajaSolicitudResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscPetAccResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.BuscExpResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.cambiarOrganismo.CambiarOrganismoRespEnvelopment;
import es.santander.justicia.minisJusticia.models.responses.confirmarOpPteConfirmacion.ConfirmarOpPteConfResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.ConsultaJuzgadosResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.consultaOperaciones.ConsuOperResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.consultaOrganosAsignados.ConsultaOrganosAsigRespEnvelope;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratosConexionResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratosParaguasResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.denegarSolicitud.DenegarSolicitudResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.detalleAutorizacion.DetalleAutorizacionEnvelope;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.detalleJuzgado.DetalleJuzgadosResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.detallePetAcceRespose.DetallePetAccReponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.detalleUsuario.DetalleUsuarioResponseEnvelop;
import es.santander.justicia.minisJusticia.models.responses.listaMovimientos.ListaMovimientosResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.login.LoginResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.loginunico.LoginUnicoResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.modificarSolicitud.ModificarSolicitudResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.obtenerDatosLoginLA.ObtenerDatosLoginResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.operacionesEjecutadas.OpeEjectResponseEnvelop;
import es.santander.justicia.minisJusticia.models.responses.operacionesPendientes.OpePenResponseEnvelop;
import es.santander.justicia.minisJusticia.models.responses.resolverAutorizacion.ResolverAutorizacionEnvelope;
import es.santander.justicia.minisJusticia.models.responses.seizures.EmbargoResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.InitConfigConstants;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConnectionBuilder {
    private static final int DATOS_PAG_NUM = 1;
    private static final int DATOS_PAG_TAM = 1000;

    public static Call<AvisosResponseEnvelop> getAdvicesCall(String codUser) {
        AdvicesRequestBodyRequest body = new AdvicesRequestBodyRequest();
        AdvicesArg0 advicesArg0 = new AdvicesArg0();
        AdvicesArg0Detail advicesArg0Detail = new AdvicesArg0Detail();
        advicesArg0Detail.setData(codUser);
        advicesArg0.setCodUo(advicesArg0Detail);
        body.setAdvicesArg0(advicesArg0);
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(body);
        return ((CallInteface.AdvicesAppi) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.AdvicesAppi.class)).requestStateInfo(envelope);
    }

    public static Call<Void> logout() {
        LogoutRequestBodyRequest body = new LogoutRequestBodyRequest();
        body.setObject("");
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(body);
        return ((CallInteface.Logout) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.Logout.class)).requestStateInfo(envelope);
    }

    public static Call<DetalleUsuarioResponseEnvelop> getDetalleUsuarioCall() {
        UserDetailRequestBodyRequest body = new UserDetailRequestBodyRequest();
        body.setObject("");
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(body);
        return ((CallInteface.UserDetail) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.UserDetail.class)).requestStateInfo(envelope);
    }

    public static Call<LoginResponseEnvelope> getLoginCall(String codDoc, String juser, String pass, String tipoDoc) {
        LoginArg0 loginArg0 = new LoginArg0(new LoginArg0Detail(codDoc, juser, pass, tipoDoc == null ? "N" : tipoDoc));
        LoginBodyRequestBody body = new LoginBodyRequestBody();
        body.setLoginArg0(loginArg0);
        LoginRequestEnvelope envelope = new LoginRequestEnvelope();
        envelope.setBody(body);
        return ((CallInteface.Login) new RetrofitUtility().getRetrofitInstance(true).create(CallInteface.Login.class)).requestStateInfo(envelope);
    }

    public static Call<CambiarOrganismoRespEnvelopment> getCambiarOrganismoCall(String cod) {
        CambiarOrganismoArg0Detail cambiarOrganismoArg0Detail = new CambiarOrganismoArg0Detail(cod);
        CambarOrganismoAsigArg0 cambarOrganismoAsigArg0 = new CambarOrganismoAsigArg0();
        cambarOrganismoAsigArg0.setCambiarOrganismoArg0Detail(cambiarOrganismoArg0Detail);
        CambiarOrganismoRequestBody cambiarOrganismoRequestBody = new CambiarOrganismoRequestBody();
        cambiarOrganismoRequestBody.setCambarOrganismoAsigArg0(cambarOrganismoAsigArg0);
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(cambiarOrganismoRequestBody);
        return ((CallInteface.CambiarOrganismo) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.CambiarOrganismo.class)).requestStateInfo(envelope);
    }

    public static Call<BuscPetAccResponseEnvelope> getBuscPetCall(String juzga, String juzgori, String jproced, String jnumexp, String janoapex, String codEstadoPeticion) {
        DatosPaginacionRequest datosPaginacionRequest = new DatosPaginacionRequest(1, 1000);
        BuscPetArg0Detail buscPetArg0Detail = new BuscPetArg0Detail();
        buscPetArg0Detail.setDatosPaginacionRequest(datosPaginacionRequest);
        if (juzga != null) {
            buscPetArg0Detail.setJuzga(juzga);
        }
        if (juzgori != null) {
            buscPetArg0Detail.setJuzgori(juzgori);
        }
        if (jproced != null) {
            buscPetArg0Detail.setJproced(jproced);
        }
        if (jnumexp != null) {
            buscPetArg0Detail.setJnumexp(jnumexp);
        }
        if (janoapex != null) {
            buscPetArg0Detail.setJanoapex(janoapex);
        }
        if (codEstadoPeticion != null) {
            buscPetArg0Detail.setCodEstadoPeticion(codEstadoPeticion);
        }
        BuscPetArg0 buscPetArg0 = new BuscPetArg0();
        buscPetArg0.setBuscPetArg0Detail(buscPetArg0Detail);
        BuscPetRequestBody buscPetRequestBody = new BuscPetRequestBody();
        buscPetRequestBody.setBuscPetArg0(buscPetArg0);
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(buscPetRequestBody);
        return ((CallInteface.BuscPetAcceso) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.BuscPetAcceso.class)).requestStateInfo(envelope);
    }

    public static Call<AceptarSolicitudResponseEnvelopment> getAceptSoliCall(OperativasGlobalArg0Detail detallePetAcceDetail) {
        AceptarSolicitudRequesBody aceptarSolicitudRequesBody = new AceptarSolicitudRequesBody(new OperativasGlobalArg0(detallePetAcceDetail));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(aceptarSolicitudRequesBody);
        return ((CallInteface.AcpetarSolicitud) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.AcpetarSolicitud.class)).requestStateInfo(envelope);
    }

    public static Call<DenegarSolicitudResponseEnvelope> getDeniedSoliCall(OperativasGlobalArg0Detail detallePetAcceDetail) {
        DenegarSolicitudRequestBody denegarSolicitudRequestBody = new DenegarSolicitudRequestBody(new OperativasGlobalArg0(detallePetAcceDetail));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(denegarSolicitudRequestBody);
        return ((CallInteface.DenegarSolicitud) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.DenegarSolicitud.class)).requestStateInfo(envelope);
    }

    public static Call<BajaSolicitudResponseEnvelope> getBajaSoliCall(OperativasGlobalArg0Detail detallePetAcceDetail) {
        BajaSolicitudRequestBody bajaSolicitudRequestBody = new BajaSolicitudRequestBody(new OperativasGlobalArg0(detallePetAcceDetail));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(bajaSolicitudRequestBody);
        return ((CallInteface.BajaSolicitud) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.BajaSolicitud.class)).requestStateInfo(envelope);
    }

    public static Call<ModificarSolicitudResponseEnvelope> getModificarSoliCall(OperativasGlobalArg0Detail detallePetAcceDetail) {
        ModificarSolicitudRequestBody modificarSolicitudRequestBody = new ModificarSolicitudRequestBody(new OperativasGlobalArg0(detallePetAcceDetail));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(modificarSolicitudRequestBody);
        return ((CallInteface.ModificarSolicitud) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.ModificarSolicitud.class)).requestStateInfo(envelope);
    }

    public static Call<OpeEjectResponseEnvelop> getOpeEjectConsultaCall(String coduo, String codMod, int rango) {
        OperEjectRequestBody body = new OperEjectRequestBody(new OperEjectArg0(new OperEjectArg0Detail(coduo, codMod, rango)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(body);
        return ((CallInteface.ConsultaOperacionesEjecutadas) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.ConsultaOperacionesEjecutadas.class)).requestStateInfo(envelope);
    }

    public static Call<OpePenResponseEnvelop> getOpePendientesConsultaCall(String coduo) {
        OperPendRequestBody body = new OperPendRequestBody(new OpePendArg0(new OpePendArg0Detail(coduo)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(body);
        return ((CallInteface.ConsultaOperacionesPendientes) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.ConsultaOperacionesPendientes.class)).requestStateInfo(envelope);
    }

    public static Call<ConsuOperResponseEnvelope> getConsultaOperacionCall(String juzgadoDestino, String modeda, String operacion, String operacionSeleccinada, String fechaInicio) {
        ConsultaOperacionRequestBody consultaOperacionRequestBody = new ConsultaOperacionRequestBody(new ConsultaOperacionArg0(new ConsultaOperacionArg0Detail(new DatosPaginacionRequest(1, 1000), juzgadoDestino, modeda, operacion, operacionSeleccinada, CommonUtils.getCurrentDateToOperations(), fechaInicio)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(consultaOperacionRequestBody);
        return ((CallInteface.ConsultasOperacion) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.ConsultasOperacion.class)).requestStateInfo(envelope);
    }

    public static Call<BuscExpResponseEnvelope> getBuscarExpedientesCall(String juzg, String juzgori, String jproced, String jnumexp, String janoapex, String moneda, String sitaucion, String fechaDe, String fechaHast, String tipsel) {
        BuscarExpedientesRequestBody buscarExpedientesRequestBody = new BuscarExpedientesRequestBody(new BuscarExpedientesArg0(new BuscarExpedientesArg0Detail(new DatosAcceso(new DatosExpediente(juzg, juzgori, jproced, jnumexp, janoapex, moneda, sitaucion)), new DatosFiltradoRequest(fechaDe, fechaHast, (String) null, (String) null, tipsel), new DatosPaginacionRequest(1, 1000))));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(buscarExpedientesRequestBody);
        return ((CallInteface.BuscarExpedientes) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.BuscarExpedientes.class)).requestStateInfo(envelope);
    }

    public static Call<DetalleMovimientoResponseEnvelope> getDetalleMovimientoCall(String jnuoper, String juzga) {
        DetalleMovRequestBody detalleMovRequestBody = new DetalleMovRequestBody(new DetalleMovArg0(new DetalleMovArg0Detail(new DetalleMovDatosOperRequest(new DetalleMovDatosExp(juzga), jnuoper))));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(detalleMovRequestBody);
        return ((CallInteface.DetalleMovimiento) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.DetalleMovimiento.class)).requestStateInfo(envelope);
    }

    public static Call<DetalleExpResponseEnvelope> getDetalleExpCall(DatosExpedienteNew datosExp) {
        DetalleExpRequestBody detalleExpRequestBody = new DetalleExpRequestBody(new DetalleExpArg0(new DetalleExpArg0Detail(new DetalleExpDatosExp(new DetalleExpDatosExpDetail(datosExp.getJanoapex(), datosExp.getJnumexp(), datosExp.getJproced(), datosExp.getJuzga(), datosExp.getJuzgori())))));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(detalleExpRequestBody);
        return ((CallInteface.DetalleExpediente) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.DetalleExpediente.class)).requestStateInfo(envelope);
    }

    public static Call<DetallePetAccReponseEnvelope> getDetallePetAcc(String anioAp, String codDocumen, String condExp, String codTipo, String fechaRegi) {
        DetallePetAcceRequestBody detallePetAcceRequestBody = new DetallePetAcceRequestBody(new DetallePetAccArg0(new DetallePetAccArg0Detail(anioAp, codDocumen, condExp, codTipo, fechaRegi)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(detallePetAcceRequestBody);
        return ((CallInteface.DetallePetAccesoResponse) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.DetallePetAccesoResponse.class)).requestStateInfo(envelope);
    }

    public static Call<ConsultaOrganosAsigRespEnvelope> getConsultaOrganosAsigandosCall() {
        ConsultaOrganosAsignadosReqBody consultaOrganosAsignadosReqBody = new ConsultaOrganosAsignadosReqBody();
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(consultaOrganosAsignadosReqBody);
        return ((CallInteface.ConsultaOrganosAsignados) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.ConsultaOrganosAsignados.class)).requestStateInfo(envelope);
    }

    public static Call<ListaMovimientosResponseEnvelope> getListaMovimientos(String janoapex, String jnumexp, String jproced, String juzga, String juzgori, String jfechareDe, String jfechareHasta, String jimpnomiDe, String jimpnomiHasta, String codMon, String tipoMod) {
        String str = codMon;
        String str2 = tipoMod;
        new DetalleMovementSaldos(str, str2);
        ListaMovimientosRequestBody listaMovimientosRequestBody = new ListaMovimientosRequestBody(new ListaMoveArg0(new ListaMoveArg0Detail(new es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpediente(new DatosExpedienteDetail(janoapex, jnumexp, jproced, juzga, juzgori), str, str2), new DatosPaginacionRequest(1, 1000), new DatosFiltradoRequest(jfechareDe, jfechareHasta, jimpnomiDe, jimpnomiHasta, (String) null))));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(listaMovimientosRequestBody);
        return ((CallInteface.ListaMovimientos) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.ListaMovimientos.class)).requestStateInfo(envelope);
    }

    public static Call<EmbargoResponseEnvelope> getEmbargos(String juzgadoDestinoExp, String juzgadoOrigenExp, String procedimientoExp, String anoAperturaExpediente, String numeroExp, String importeEmbargadoDesde, String importeEmbargadoHasta, String fechaDesde, String fechaHasta, String codigoTipoEmbargo, String codigoEstado) {
        EmbargoRequestBody embargoRequestBody = new EmbargoRequestBody(new EmbargoArg0(new EmbargoArgo0Detail(new DatosPaginacionRequest(1, 1000), juzgadoDestinoExp, juzgadoOrigenExp, procedimientoExp, anoAperturaExpediente, numeroExp, importeEmbargadoDesde, importeEmbargadoHasta, fechaDesde, fechaHasta, codigoTipoEmbargo, codigoEstado)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(embargoRequestBody);
        return ((CallInteface.BuscarEmbargos) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.BuscarEmbargos.class)).requestStateInfo(envelope);
    }

    public static Call<ConsultaJuzgadosResponseEnvelope> getConsultaJuzgados(String codProva, String codEntja) {
        ConsultaJuzgadosRequestBody consultaJuzgadoRequestBody = new ConsultaJuzgadosRequestBody(new ConsultaJuzgadosArg0(new ConsultaJuzgadosArg0Detail(new DatosJuzgado(codProva, codEntja), new DatosPaginacionRequest(1, 1000))));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(consultaJuzgadoRequestBody);
        return ((CallInteface.ConsultaJuzgados) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.ConsultaJuzgados.class)).requestStateInfo(envelope);
    }

    public static Call<DetalleJuzgadosResponseEnvelope> getDetalleJuzgados(String juzga) {
        DetalleJuzgadoRequestBody detalleJuzgadoRequestBody = new DetalleJuzgadoRequestBody(new DetalleJuzgadoArg0(new DetalleJuzgadoArg0Detail(new es.santander.justicia.minisJusticia.models.requests.detalleJuzgado.DatosJuzgado(juzga))));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(detalleJuzgadoRequestBody);
        return ((CallInteface.DetalleJuzgados) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.DetalleJuzgados.class)).requestStateInfo(envelope);
    }

    public static Call<BajaEmbargoResponseEnvelope> getBajaEmbargoCall(String codigoUnidadOrganizativa, String numeroEmbargo, String firma, String observaciones) {
        BajaEmbargoRequestBody bajaEmbargoRequestBody = new BajaEmbargoRequestBody(new BajaEmbargoArg0(new BajaEmbargoArg0Detail(codigoUnidadOrganizativa, numeroEmbargo, firma, observaciones)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(bajaEmbargoRequestBody);
        return ((CallInteface.BajaEmbargo) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.BajaEmbargo.class)).requestStateInfo(envelope);
    }

    public static Call<ActivarExpedienteResponseEnvelope> getActivarExpedienteCall(String anoAperturaExpediente, String numeroExpediente, String codigoJuzgadoDestino, String codigoJuzgadoOrigen, String codigoProcedimiento, String codigoExpediente, String codigoMoneda, String firma) {
        ActivarExpedienteRequestBody activarExpedienteRequestBody = new ActivarExpedienteRequestBody(new ActivarExpedienteArg0(new ActivarExpedienteArg0Detail(anoAperturaExpediente, numeroExpediente, codigoJuzgadoDestino, codigoJuzgadoOrigen, codigoProcedimiento, codigoExpediente, codigoMoneda, firma)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(activarExpedienteRequestBody);
        return ((CallInteface.ActivarExpediente) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.ActivarExpediente.class)).requestStateInfo(envelope);
    }

    public static Call<AnularOpPteCobroResponseEnvelope> getAnularOpPteCobrCall(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
        AnularOpPteCobroRequestBody anularOpPteCobroRequestBody = new AnularOpPteCobroRequestBody(new OperGlobalArg0(new OperGlobalArg0Detail(datosOperacion, firma, motivoAnulacion)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(anularOpPteCobroRequestBody);
        return ((CallInteface.AnularOpPteCobro) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.AnularOpPteCobro.class)).requestStateInfo(envelope);
    }

    public static Call<AnularOpPteConfirmacionResponseEnvelope> getAnularOpPteConfirmacion(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
        AnularOpPteConfRequesBody anularOpPteConfRequesBody = new AnularOpPteConfRequesBody(new OperGlobalArg0(new OperGlobalArg0Detail(datosOperacion, firma, motivoAnulacion)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(anularOpPteConfRequesBody);
        return ((CallInteface.AnularOpPteConfirmacion) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.AnularOpPteConfirmacion.class)).requestStateInfo(envelope);
    }

    public static Call<AnularOpPteIngresoResponseEnvelope> getAnularOpPteIngreso(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
        AnularOpPteIngresoRequestBody anularOpPteIngresoRequestBody = new AnularOpPteIngresoRequestBody(new OperGlobalArg0(new OperGlobalArg0Detail(datosOperacion, firma, motivoAnulacion)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(anularOpPteIngresoRequestBody);
        return ((CallInteface.AnularOpPteIngreso) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.AnularOpPteIngreso.class)).requestStateInfo(envelope);
    }

    public static Call<ConfirmarOpPteConfResponseEnvelope> getConfirmOpPteConfir(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
        ConfirmarOpPteConfiRequestBody confirmarOpPteConfiRequestBody = new ConfirmarOpPteConfiRequestBody(new OperGlobalArg0(new OperGlobalArg0Detail(datosOperacion, firma, motivoAnulacion)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(confirmarOpPteConfiRequestBody);
        return ((CallInteface.ConfirmarOpPteConfi) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.ConfirmarOpPteConfi.class)).requestStateInfo(envelope);
    }

    public static Call<ResolverAutorizacionEnvelope> getResolverAutorizacon(AutorizacionRetrocesionDto autorizacionRetrocesionDto, String firma) {
        ResolverAutorizacionRequestBody resolverAutorizacionRequestBody = new ResolverAutorizacionRequestBody(new ResolverAutorizacionArg0(new ResolverAutorizacionArg0Detail(autorizacionRetrocesionDto, firma)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(resolverAutorizacionRequestBody);
        return ((CallInteface.ResolverAutorizacion) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.ResolverAutorizacion.class)).requestStateInfo(envelope);
    }

    public static Call<AutorizacionesUsuarioEnvelope> getAutorizacionesJuzagado(String codNumDocumento, String codOrganismo, String codTipoDocumento, String fechaFinal, String fechaInicial, String indCaducadas) {
        DatosPaginacionRequest datosPaginacionRequest = new DatosPaginacionRequest(1, 1000);
        AuthJuzgadosArg0Detail authJuzgadosArg0Detail = new AuthJuzgadosArg0Detail();
        authJuzgadosArg0Detail.setDatosPaginacionRequest(datosPaginacionRequest);
        if (codNumDocumento != null) {
            authJuzgadosArg0Detail.setCodNumDocumento(codNumDocumento);
        }
        if (codOrganismo != null) {
            authJuzgadosArg0Detail.setCodOrganismo(codOrganismo);
        }
        if (codTipoDocumento != null) {
            authJuzgadosArg0Detail.setCodTipoDocumento(codTipoDocumento);
        }
        if (fechaFinal != null) {
            authJuzgadosArg0Detail.setFechaFinal(fechaFinal);
        }
        if (fechaInicial != null) {
            authJuzgadosArg0Detail.setFechaInicial(fechaInicial);
        }
        if (indCaducadas != null) {
            authJuzgadosArg0Detail.setIndCaducadas(indCaducadas);
        }
        AuthJuzgadosArg0 authJuzgadosArg0 = new AuthJuzgadosArg0();
        authJuzgadosArg0.setAuthJuzgadosArg0Detail(authJuzgadosArg0Detail);
        AuthJuzgadosRequestBody authJuzgadosRequestBody = new AuthJuzgadosRequestBody();
        authJuzgadosRequestBody.setAuthJuzgadosArg0(authJuzgadosArg0);
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(authJuzgadosRequestBody);
        return ((CallInteface.BuscarAutorizaciones) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.BuscarAutorizaciones.class)).requestStateInfo(envelope);
    }

    public static Call<DetalleAutorizacionEnvelope> getDetalleAutorizacion(DetalleAutorizacionUsuario detalleAutorizacionUsuario) {
        DetalleAutorizacionRequestBody detalleAutorizacionRequestBody = new DetalleAutorizacionRequestBody(new DetalleAutorizacionArg0(new DetalleAutorizacionArg0Detail(detalleAutorizacionUsuario)));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(detalleAutorizacionRequestBody);
        return ((CallInteface.DetalleAutorizacion) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.DetalleAutorizacion.class)).requestStateInfo(envelope);
    }

    public static Call<GlobalReponseEnvelope> mdificarAutorizacion(ModificarAutorizacionArg0Detail modificarAutorizacionArg0Detail) {
        ModificarAutorizacionRequestBody modificarAutorizacionRequestBody = new ModificarAutorizacionRequestBody(new ModificarAutorizacionArg0(modificarAutorizacionArg0Detail));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(modificarAutorizacionRequestBody);
        return ((CallInteface.ModificarAutorizacion) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.ModificarAutorizacion.class)).requestStateInfo(envelope);
    }

    public static Call<GlobalReponseEnvelope> altaAutorizacion(AltaAutorizationArg0Detail altaAutorizationArg0Detail) {
        AltaAutorizacionRequestBody altaAutorizacionRequestBody = new AltaAutorizacionRequestBody(new AltaAutorizacionArg0(altaAutorizationArg0Detail));
        GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
        envelope.setBody(altaAutorizacionRequestBody);
        return ((CallInteface.AltaAutorizacion) new RetrofitUtility().getRetrofitInstance(false).create(CallInteface.AltaAutorizacion.class)).requestStateInfo(envelope);
    }

    public static Call<LoginUnicoResponseEnvelope> loginUnico(LoginUnicoEntradaDetail loginUnicoEntradaDetail, Context context) {
        LoginUnicoRequestBody loginUnicoRequestBody = new LoginUnicoRequestBody(new LoginUnicoEntrada(loginUnicoEntradaDetail));
        GlobalContratosRequestEnvelope envelope = new GlobalContratosRequestEnvelope();
        envelope.setBody(loginUnicoRequestBody);
        return ((CallInteface.LoginUnico) new RetrofitUtility().getRetrofitInstance(InitConfigConstants.WS_LOGIN_LA_UNICO, context).create(CallInteface.LoginUnico.class)).requestStateInfo(envelope);
    }

    public static Call<ContratosParaguasResponseEnvelope> getContratosParaguas(ContratoEntradaDetail contratoEntradaDetail, Context context) {
        Object contratosBody;
        ContratosEntrada contratosEntrada = new ContratosEntrada(contratoEntradaDetail);
        if (contratoEntradaDetail.getAliasUsuConexion() == null) {
            contratosBody = new ContratosParaguasBody(contratosEntrada);
        } else {
            contratosBody = new ContratosConexionBody(contratosEntrada);
        }
        GlobalContratosRequestEnvelope envelope = new GlobalContratosRequestEnvelope();
        envelope.setBody(contratosBody);
        return ((CallInteface.GetContratos) new RetrofitUtility().getRetrofitInstance(InitConfigConstants.WS_LOGIN_LA_UNICO, context).create(CallInteface.GetContratos.class)).requestStateInfo(envelope);
    }

    public static Call<ContratosConexionResponseEnvelope> getContratosConexion(ContratoEntradaDetail contratoEntradaDetail, Context context) {
        ContratosConexionBody contratosBody = new ContratosConexionBody(new ContratosEntrada(contratoEntradaDetail));
        GlobalContratosRequestEnvelope envelope = new GlobalContratosRequestEnvelope();
        envelope.setBody(contratosBody);
        return ((CallInteface.GetContratosConexion) new RetrofitUtility().getRetrofitInstance(InitConfigConstants.WS_LOGIN_LA_UNICO, context).create(CallInteface.GetContratosConexion.class)).requestStateInfo(envelope);
    }

    public static Call<ObtenerDatosLoginResponseEnvelope> obtenerDatosLogin(ObtenerDatosLoginEntradaDetail obtenerDatosLoginEntradaDetail, Context context) {
        ObtenerDatosLoginRequestBody obtenerDatosLoginRequestBody = new ObtenerDatosLoginRequestBody(new ObtenerDatosLoginEntrada(obtenerDatosLoginEntradaDetail));
        GlobalContratosRequestEnvelope envelope = new GlobalContratosRequestEnvelope();
        envelope.setBody(obtenerDatosLoginRequestBody);
        return ((CallInteface.ObtenerDatosLogin) new RetrofitUtility().getRetrofitInstance(InitConfigConstants.WS_LOGIN_LA_UNICO, context).create(CallInteface.ObtenerDatosLogin.class)).requestStateInfo(envelope);
    }

    public static Call<ResponseBody> onlineParameteres(Context context) {
        return ((CallInteface.OnlineParameters) new RetrofitUtility().getRetrofitInstanceJson(InitConfigConstants.WS_ONLINE_PARAMETERS, context).create(CallInteface.OnlineParameters.class)).onlineParameters();
    }
}
