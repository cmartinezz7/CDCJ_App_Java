package es.santander.justicia.minisJusticia.connections;

import android.content.Context;
import es.santander.justicia.minisJusticia.connections.CallInteface.AcpetarSolicitud;
import es.santander.justicia.minisJusticia.connections.CallInteface.ActivarExpediente;
import es.santander.justicia.minisJusticia.connections.CallInteface.AdvicesAppi;
import es.santander.justicia.minisJusticia.connections.CallInteface.AltaAutorizacion;
import es.santander.justicia.minisJusticia.connections.CallInteface.AnularOpPteCobro;
import es.santander.justicia.minisJusticia.connections.CallInteface.AnularOpPteConfirmacion;
import es.santander.justicia.minisJusticia.connections.CallInteface.AnularOpPteIngreso;
import es.santander.justicia.minisJusticia.connections.CallInteface.BajaEmbargo;
import es.santander.justicia.minisJusticia.connections.CallInteface.BajaSolicitud;
import es.santander.justicia.minisJusticia.connections.CallInteface.BuscPetAcceso;
import es.santander.justicia.minisJusticia.connections.CallInteface.BuscarAutorizaciones;
import es.santander.justicia.minisJusticia.connections.CallInteface.BuscarEmbargos;
import es.santander.justicia.minisJusticia.connections.CallInteface.BuscarExpedientes;
import es.santander.justicia.minisJusticia.connections.CallInteface.CambiarOrganismo;
import es.santander.justicia.minisJusticia.connections.CallInteface.ConfirmarOpPteConfi;
import es.santander.justicia.minisJusticia.connections.CallInteface.ConsultaJuzgados;
import es.santander.justicia.minisJusticia.connections.CallInteface.ConsultaOperacionesEjecutadas;
import es.santander.justicia.minisJusticia.connections.CallInteface.ConsultaOperacionesPendientes;
import es.santander.justicia.minisJusticia.connections.CallInteface.ConsultaOrganosAsignados;
import es.santander.justicia.minisJusticia.connections.CallInteface.ConsultasOperacion;
import es.santander.justicia.minisJusticia.connections.CallInteface.DenegarSolicitud;
import es.santander.justicia.minisJusticia.connections.CallInteface.DetalleAutorizacion;
import es.santander.justicia.minisJusticia.connections.CallInteface.DetalleExpediente;
import es.santander.justicia.minisJusticia.connections.CallInteface.DetalleJuzgados;
import es.santander.justicia.minisJusticia.connections.CallInteface.DetalleMovimiento;
import es.santander.justicia.minisJusticia.connections.CallInteface.DetallePetAccesoResponse;
import es.santander.justicia.minisJusticia.connections.CallInteface.GetContratos;
import es.santander.justicia.minisJusticia.connections.CallInteface.GetContratosConexion;
import es.santander.justicia.minisJusticia.connections.CallInteface.ListaMovimientos;
import es.santander.justicia.minisJusticia.connections.CallInteface.Login;
import es.santander.justicia.minisJusticia.connections.CallInteface.LoginUnico;
import es.santander.justicia.minisJusticia.connections.CallInteface.Logout;
import es.santander.justicia.minisJusticia.connections.CallInteface.ModificarAutorizacion;
import es.santander.justicia.minisJusticia.connections.CallInteface.ModificarSolicitud;
import es.santander.justicia.minisJusticia.connections.CallInteface.ObtenerDatosLogin;
import es.santander.justicia.minisJusticia.connections.CallInteface.OnlineParameters;
import es.santander.justicia.minisJusticia.connections.CallInteface.ResolverAutorizacion;
import es.santander.justicia.minisJusticia.connections.CallInteface.UserDetail;
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
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

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
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      AdvicesAppi advicesAppi = (AdvicesAppi)retrofit.create(AdvicesAppi.class);
      return advicesAppi.requestStateInfo(envelope);
   }

   public static Call<Void> logout() {
      LogoutRequestBodyRequest body = new LogoutRequestBodyRequest();
      String object = "";
      body.setObject(object);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(body);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      Logout logout = (Logout)retrofit.create(Logout.class);
      return logout.requestStateInfo(envelope);
   }

   public static Call<DetalleUsuarioResponseEnvelop> getDetalleUsuarioCall() {
      UserDetailRequestBodyRequest body = new UserDetailRequestBodyRequest();
      String object = "";
      body.setObject(object);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(body);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      UserDetail userDetail = (UserDetail)retrofit.create(UserDetail.class);
      return userDetail.requestStateInfo(envelope);
   }

   public static Call<LoginResponseEnvelope> getLoginCall(String codDoc, String juser, String pass, String tipoDoc) {
      LoginArg0Detail loginArg0Detail = new LoginArg0Detail(codDoc, juser, pass, tipoDoc == null ? "N" : tipoDoc);
      LoginArg0 loginArg0 = new LoginArg0(loginArg0Detail);
      LoginBodyRequestBody body = new LoginBodyRequestBody();
      body.setLoginArg0(loginArg0);
      LoginRequestEnvelope envelope = new LoginRequestEnvelope();
      envelope.setBody(body);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(true);
      Login login = (Login)retrofit.create(Login.class);
      return login.requestStateInfo(envelope);
   }

   public static Call<CambiarOrganismoRespEnvelopment> getCambiarOrganismoCall(String cod) {
      CambiarOrganismoArg0Detail cambiarOrganismoArg0Detail = new CambiarOrganismoArg0Detail(cod);
      CambarOrganismoAsigArg0 cambarOrganismoAsigArg0 = new CambarOrganismoAsigArg0();
      cambarOrganismoAsigArg0.setCambiarOrganismoArg0Detail(cambiarOrganismoArg0Detail);
      CambiarOrganismoRequestBody cambiarOrganismoRequestBody = new CambiarOrganismoRequestBody();
      cambiarOrganismoRequestBody.setCambarOrganismoAsigArg0(cambarOrganismoAsigArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(cambiarOrganismoRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      CambiarOrganismo cambiarOrganismo = (CambiarOrganismo)retrofit.create(CambiarOrganismo.class);
      return cambiarOrganismo.requestStateInfo(envelope);
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
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      BuscPetAcceso buscPetAcceso = (BuscPetAcceso)retrofit.create(BuscPetAcceso.class);
      return buscPetAcceso.requestStateInfo(envelope);
   }

   public static Call<AceptarSolicitudResponseEnvelopment> getAceptSoliCall(OperativasGlobalArg0Detail detallePetAcceDetail) {
      OperativasGlobalArg0 operativasGlobalArg0 = new OperativasGlobalArg0(detallePetAcceDetail);
      AceptarSolicitudRequesBody aceptarSolicitudRequesBody = new AceptarSolicitudRequesBody(operativasGlobalArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(aceptarSolicitudRequesBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      AcpetarSolicitud acpetarSolicitud = (AcpetarSolicitud)retrofit.create(AcpetarSolicitud.class);
      return acpetarSolicitud.requestStateInfo(envelope);
   }

   public static Call<DenegarSolicitudResponseEnvelope> getDeniedSoliCall(OperativasGlobalArg0Detail detallePetAcceDetail) {
      OperativasGlobalArg0 operativasGlobalArg0 = new OperativasGlobalArg0(detallePetAcceDetail);
      DenegarSolicitudRequestBody denegarSolicitudRequestBody = new DenegarSolicitudRequestBody(operativasGlobalArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(denegarSolicitudRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      DenegarSolicitud denegarSolicitud = (DenegarSolicitud)retrofit.create(DenegarSolicitud.class);
      return denegarSolicitud.requestStateInfo(envelope);
   }

   public static Call<BajaSolicitudResponseEnvelope> getBajaSoliCall(OperativasGlobalArg0Detail detallePetAcceDetail) {
      OperativasGlobalArg0 operativasGlobalArg0 = new OperativasGlobalArg0(detallePetAcceDetail);
      BajaSolicitudRequestBody bajaSolicitudRequestBody = new BajaSolicitudRequestBody(operativasGlobalArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(bajaSolicitudRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      BajaSolicitud bajaSolicitud = (BajaSolicitud)retrofit.create(BajaSolicitud.class);
      return bajaSolicitud.requestStateInfo(envelope);
   }

   public static Call<ModificarSolicitudResponseEnvelope> getModificarSoliCall(OperativasGlobalArg0Detail detallePetAcceDetail) {
      OperativasGlobalArg0 operativasGlobalArg0 = new OperativasGlobalArg0(detallePetAcceDetail);
      ModificarSolicitudRequestBody modificarSolicitudRequestBody = new ModificarSolicitudRequestBody(operativasGlobalArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(modificarSolicitudRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      ModificarSolicitud modificarSolicitud = (ModificarSolicitud)retrofit.create(ModificarSolicitud.class);
      return modificarSolicitud.requestStateInfo(envelope);
   }

   public static Call<OpeEjectResponseEnvelop> getOpeEjectConsultaCall(String coduo, String codMod, int rango) {
      OperEjectArg0Detail operEjectArg0Detail = new OperEjectArg0Detail(coduo, codMod, rango);
      OperEjectArg0 operEjectArg0 = new OperEjectArg0(operEjectArg0Detail);
      OperEjectRequestBody body = new OperEjectRequestBody(operEjectArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(body);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      ConsultaOperacionesEjecutadas consultaOperEjecj = (ConsultaOperacionesEjecutadas)retrofit.create(ConsultaOperacionesEjecutadas.class);
      return consultaOperEjecj.requestStateInfo(envelope);
   }

   public static Call<OpePenResponseEnvelop> getOpePendientesConsultaCall(String coduo) {
      OpePendArg0Detail operPendArg0Detail = new OpePendArg0Detail(coduo);
      OpePendArg0 operPendArg0 = new OpePendArg0(operPendArg0Detail);
      OperPendRequestBody body = new OperPendRequestBody(operPendArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(body);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      ConsultaOperacionesPendientes consultaOperacionesPendientes = (ConsultaOperacionesPendientes)retrofit.create(ConsultaOperacionesPendientes.class);
      return consultaOperacionesPendientes.requestStateInfo(envelope);
   }

   public static Call<ConsuOperResponseEnvelope> getConsultaOperacionCall(String juzgadoDestino, String modeda, String operacion, String operacionSeleccinada, String fechaInicio) {
      DatosPaginacionRequest datosPaginacionRequest = new DatosPaginacionRequest(1, 1000);
      ConsultaOperacionArg0Detail consultaOperacionArg0Detail = new ConsultaOperacionArg0Detail(datosPaginacionRequest, juzgadoDestino, modeda, operacion, operacionSeleccinada, CommonUtils.getCurrentDateToOperations(), fechaInicio);
      ConsultaOperacionArg0 consultaOperacionArg0 = new ConsultaOperacionArg0(consultaOperacionArg0Detail);
      ConsultaOperacionRequestBody consultaOperacionRequestBody = new ConsultaOperacionRequestBody(consultaOperacionArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(consultaOperacionRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      ConsultasOperacion consultasOperacion = (ConsultasOperacion)retrofit.create(ConsultasOperacion.class);
      return consultasOperacion.requestStateInfo(envelope);
   }

   public static Call<BuscExpResponseEnvelope> getBuscarExpedientesCall(String juzg, String juzgori, String jproced, String jnumexp, String janoapex, String moneda, String sitaucion, String fechaDe, String fechaHast, String tipsel) {
      DatosExpediente datosExpediente = new DatosExpediente(juzg, juzgori, jproced, jnumexp, janoapex, moneda, sitaucion);
      DatosAcceso datosAcceso = new DatosAcceso(datosExpediente);
      DatosFiltradoRequest datosFiltradoRequest = new DatosFiltradoRequest(fechaDe, fechaHast, (String)null, (String)null, tipsel);
      DatosPaginacionRequest datosPaginacionRequest = new DatosPaginacionRequest(1, 1000);
      BuscarExpedientesArg0Detail buscarExpedientesArg0Detail = new BuscarExpedientesArg0Detail(datosAcceso, datosFiltradoRequest, datosPaginacionRequest);
      BuscarExpedientesArg0 buscarExpedientesArg0 = new BuscarExpedientesArg0(buscarExpedientesArg0Detail);
      BuscarExpedientesRequestBody buscarExpedientesRequestBody = new BuscarExpedientesRequestBody(buscarExpedientesArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(buscarExpedientesRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      BuscarExpedientes buscarExpedientes = (BuscarExpedientes)retrofit.create(BuscarExpedientes.class);
      return buscarExpedientes.requestStateInfo(envelope);
   }

   public static Call<DetalleMovimientoResponseEnvelope> getDetalleMovimientoCall(String jnuoper, String juzga) {
      DetalleMovDatosExp detalleMovDatosExp = new DetalleMovDatosExp(juzga);
      DetalleMovDatosOperRequest detalleMovDatosOperRequest = new DetalleMovDatosOperRequest(detalleMovDatosExp, jnuoper);
      DetalleMovArg0Detail detalleMovArg0Detail = new DetalleMovArg0Detail(detalleMovDatosOperRequest);
      DetalleMovArg0 detalleMovArg0 = new DetalleMovArg0(detalleMovArg0Detail);
      DetalleMovRequestBody detalleMovRequestBody = new DetalleMovRequestBody(detalleMovArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(detalleMovRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      DetalleMovimiento detalleMovimiento = (DetalleMovimiento)retrofit.create(DetalleMovimiento.class);
      return detalleMovimiento.requestStateInfo(envelope);
   }

   public static Call<DetalleExpResponseEnvelope> getDetalleExpCall(DatosExpedienteNew datosExp) {
      DetalleExpDatosExpDetail detalleExpDatosExpDetail = new DetalleExpDatosExpDetail(datosExp.getJanoapex(), datosExp.getJnumexp(), datosExp.getJproced(), datosExp.getJuzga(), datosExp.getJuzgori());
      DetalleExpDatosExp detalleExpDatosExp = new DetalleExpDatosExp(detalleExpDatosExpDetail);
      DetalleExpArg0Detail detalleExpArg0Detail = new DetalleExpArg0Detail(detalleExpDatosExp);
      DetalleExpArg0 detalleExpArg0 = new DetalleExpArg0(detalleExpArg0Detail);
      DetalleExpRequestBody detalleExpRequestBody = new DetalleExpRequestBody(detalleExpArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(detalleExpRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      DetalleExpediente detalleExpediente = (DetalleExpediente)retrofit.create(DetalleExpediente.class);
      return detalleExpediente.requestStateInfo(envelope);
   }

   public static Call<DetallePetAccReponseEnvelope> getDetallePetAcc(String anioAp, String codDocumen, String condExp, String codTipo, String fechaRegi) {
      DetallePetAccArg0Detail detallePetAccArg0Detail = new DetallePetAccArg0Detail(anioAp, codDocumen, condExp, codTipo, fechaRegi);
      DetallePetAccArg0 detallePetAccArg0 = new DetallePetAccArg0(detallePetAccArg0Detail);
      DetallePetAcceRequestBody detallePetAcceRequestBody = new DetallePetAcceRequestBody(detallePetAccArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(detallePetAcceRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      DetallePetAccesoResponse detallePetAccesoResponse = (DetallePetAccesoResponse)retrofit.create(DetallePetAccesoResponse.class);
      return detallePetAccesoResponse.requestStateInfo(envelope);
   }

   public static Call<ConsultaOrganosAsigRespEnvelope> getConsultaOrganosAsigandosCall() {
      ConsultaOrganosAsignadosReqBody consultaOrganosAsignadosReqBody = new ConsultaOrganosAsignadosReqBody();
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(consultaOrganosAsignadosReqBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      ConsultaOrganosAsignados consultaOrganosAsignados = (ConsultaOrganosAsignados)retrofit.create(ConsultaOrganosAsignados.class);
      return consultaOrganosAsignados.requestStateInfo(envelope);
   }

   public static Call<ListaMovimientosResponseEnvelope> getListaMovimientos(String janoapex, String jnumexp, String jproced, String juzga, String juzgori, String jfechareDe, String jfechareHasta, String jimpnomiDe, String jimpnomiHasta, String codMon, String tipoMod) {
      new DetalleMovementSaldos(codMon, tipoMod);
      DatosExpedienteDetail datosExpedienteDetail = new DatosExpedienteDetail(janoapex, jnumexp, jproced, juzga, juzgori);
      es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpediente datosExpediente = new es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpediente(datosExpedienteDetail, codMon, tipoMod);
      DatosPaginacionRequest datosPaginacionRequest = new DatosPaginacionRequest(1, 1000);
      DatosFiltradoRequest datosFiltradoRequest = new DatosFiltradoRequest(jfechareDe, jfechareHasta, jimpnomiDe, jimpnomiHasta, (String)null);
      ListaMoveArg0Detail listaMoveArg0Detail = new ListaMoveArg0Detail(datosExpediente, datosPaginacionRequest, datosFiltradoRequest);
      ListaMoveArg0 listaMoveArg0 = new ListaMoveArg0(listaMoveArg0Detail);
      ListaMovimientosRequestBody listaMovimientosRequestBody = new ListaMovimientosRequestBody(listaMoveArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(listaMovimientosRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      ListaMovimientos listaMovimientos = (ListaMovimientos)retrofit.create(ListaMovimientos.class);
      return listaMovimientos.requestStateInfo(envelope);
   }

   public static Call<EmbargoResponseEnvelope> getEmbargos(String juzgadoDestinoExp, String juzgadoOrigenExp, String procedimientoExp, String anoAperturaExpediente, String numeroExp, String importeEmbargadoDesde, String importeEmbargadoHasta, String fechaDesde, String fechaHasta, String codigoTipoEmbargo, String codigoEstado) {
      EmbargoArgo0Detail embargoArgo0Detail = new EmbargoArgo0Detail(new DatosPaginacionRequest(1, 1000), juzgadoDestinoExp, juzgadoOrigenExp, procedimientoExp, anoAperturaExpediente, numeroExp, importeEmbargadoDesde, importeEmbargadoHasta, fechaDesde, fechaHasta, codigoTipoEmbargo, codigoEstado);
      EmbargoArg0 embargoArg0 = new EmbargoArg0(embargoArgo0Detail);
      EmbargoRequestBody embargoRequestBody = new EmbargoRequestBody(embargoArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(embargoRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      BuscarEmbargos buscarEmbargos = (BuscarEmbargos)retrofit.create(BuscarEmbargos.class);
      return buscarEmbargos.requestStateInfo(envelope);
   }

   public static Call<ConsultaJuzgadosResponseEnvelope> getConsultaJuzgados(String codProva, String codEntja) {
      ConsultaJuzgadosArg0Detail consultaJuzgadosArg0Detail = new ConsultaJuzgadosArg0Detail(new DatosJuzgado(codProva, codEntja), new DatosPaginacionRequest(1, 1000));
      ConsultaJuzgadosArg0 consultaJuzgadosArg0 = new ConsultaJuzgadosArg0(consultaJuzgadosArg0Detail);
      ConsultaJuzgadosRequestBody consultaJuzgadoRequestBody = new ConsultaJuzgadosRequestBody(consultaJuzgadosArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(consultaJuzgadoRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      ConsultaJuzgados consultaJuzgados = (ConsultaJuzgados)retrofit.create(ConsultaJuzgados.class);
      return consultaJuzgados.requestStateInfo(envelope);
   }

   public static Call<DetalleJuzgadosResponseEnvelope> getDetalleJuzgados(String juzga) {
      es.santander.justicia.minisJusticia.models.requests.detalleJuzgado.DatosJuzgado datosJuzgado = new es.santander.justicia.minisJusticia.models.requests.detalleJuzgado.DatosJuzgado(juzga);
      DetalleJuzgadoArg0Detail detalleJuzgadoArg0Detail = new DetalleJuzgadoArg0Detail(datosJuzgado);
      DetalleJuzgadoArg0 detalleJuzgadoArg0 = new DetalleJuzgadoArg0(detalleJuzgadoArg0Detail);
      DetalleJuzgadoRequestBody detalleJuzgadoRequestBody = new DetalleJuzgadoRequestBody(detalleJuzgadoArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(detalleJuzgadoRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      DetalleJuzgados detalleJuzgados = (DetalleJuzgados)retrofit.create(DetalleJuzgados.class);
      return detalleJuzgados.requestStateInfo(envelope);
   }

   public static Call<BajaEmbargoResponseEnvelope> getBajaEmbargoCall(String codigoUnidadOrganizativa, String numeroEmbargo, String firma, String observaciones) {
      BajaEmbargoArg0Detail bajaEmbargoArg0Detail = new BajaEmbargoArg0Detail(codigoUnidadOrganizativa, numeroEmbargo, firma, observaciones);
      BajaEmbargoArg0 bajaEmbargoArg0 = new BajaEmbargoArg0(bajaEmbargoArg0Detail);
      BajaEmbargoRequestBody bajaEmbargoRequestBody = new BajaEmbargoRequestBody(bajaEmbargoArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(bajaEmbargoRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      BajaEmbargo bajaEmbargo = (BajaEmbargo)retrofit.create(BajaEmbargo.class);
      return bajaEmbargo.requestStateInfo(envelope);
   }

   public static Call<ActivarExpedienteResponseEnvelope> getActivarExpedienteCall(String anoAperturaExpediente, String numeroExpediente, String codigoJuzgadoDestino, String codigoJuzgadoOrigen, String codigoProcedimiento, String codigoExpediente, String codigoMoneda, String firma) {
      ActivarExpedienteArg0Detail activarExpedienteArg0Detail = new ActivarExpedienteArg0Detail(anoAperturaExpediente, numeroExpediente, codigoJuzgadoDestino, codigoJuzgadoOrigen, codigoProcedimiento, codigoExpediente, codigoMoneda, firma);
      ActivarExpedienteArg0 activarExpedienteArg0 = new ActivarExpedienteArg0(activarExpedienteArg0Detail);
      ActivarExpedienteRequestBody activarExpedienteRequestBody = new ActivarExpedienteRequestBody(activarExpedienteArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(activarExpedienteRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      ActivarExpediente activarExpediente = (ActivarExpediente)retrofit.create(ActivarExpediente.class);
      return activarExpediente.requestStateInfo(envelope);
   }

   public static Call<AnularOpPteCobroResponseEnvelope> getAnularOpPteCobrCall(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
      OperGlobalArg0Detail operGlobalArg0Detail = new OperGlobalArg0Detail(datosOperacion, firma, motivoAnulacion);
      OperGlobalArg0 operGlobalArg0 = new OperGlobalArg0(operGlobalArg0Detail);
      AnularOpPteCobroRequestBody anularOpPteCobroRequestBody = new AnularOpPteCobroRequestBody(operGlobalArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(anularOpPteCobroRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      AnularOpPteCobro anularOpPteCobro = (AnularOpPteCobro)retrofit.create(AnularOpPteCobro.class);
      return anularOpPteCobro.requestStateInfo(envelope);
   }

   public static Call<AnularOpPteConfirmacionResponseEnvelope> getAnularOpPteConfirmacion(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
      OperGlobalArg0Detail operGlobalArg0Detail = new OperGlobalArg0Detail(datosOperacion, firma, motivoAnulacion);
      OperGlobalArg0 operGlobalArg0 = new OperGlobalArg0(operGlobalArg0Detail);
      AnularOpPteConfRequesBody anularOpPteConfRequesBody = new AnularOpPteConfRequesBody(operGlobalArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(anularOpPteConfRequesBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      AnularOpPteConfirmacion anularOpPteConfirmacion = (AnularOpPteConfirmacion)retrofit.create(AnularOpPteConfirmacion.class);
      return anularOpPteConfirmacion.requestStateInfo(envelope);
   }

   public static Call<AnularOpPteIngresoResponseEnvelope> getAnularOpPteIngreso(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
      OperGlobalArg0Detail operGlobalArg0Detail = new OperGlobalArg0Detail(datosOperacion, firma, motivoAnulacion);
      OperGlobalArg0 operGlobalArg0 = new OperGlobalArg0(operGlobalArg0Detail);
      AnularOpPteIngresoRequestBody anularOpPteIngresoRequestBody = new AnularOpPteIngresoRequestBody(operGlobalArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(anularOpPteIngresoRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      AnularOpPteIngreso anularOpPteIngreso = (AnularOpPteIngreso)retrofit.create(AnularOpPteIngreso.class);
      return anularOpPteIngreso.requestStateInfo(envelope);
   }

   public static Call<ConfirmarOpPteConfResponseEnvelope> getConfirmOpPteConfir(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
      OperGlobalArg0Detail operGlobalArg0Detail = new OperGlobalArg0Detail(datosOperacion, firma, motivoAnulacion);
      OperGlobalArg0 operGlobalArg0 = new OperGlobalArg0(operGlobalArg0Detail);
      ConfirmarOpPteConfiRequestBody confirmarOpPteConfiRequestBody = new ConfirmarOpPteConfiRequestBody(operGlobalArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(confirmarOpPteConfiRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      ConfirmarOpPteConfi confirmarOpPteConfi = (ConfirmarOpPteConfi)retrofit.create(ConfirmarOpPteConfi.class);
      return confirmarOpPteConfi.requestStateInfo(envelope);
   }

   public static Call<ResolverAutorizacionEnvelope> getResolverAutorizacon(AutorizacionRetrocesionDto autorizacionRetrocesionDto, String firma) {
      ResolverAutorizacionArg0Detail resolverAutorizacionArg0Detail = new ResolverAutorizacionArg0Detail(autorizacionRetrocesionDto, firma);
      ResolverAutorizacionArg0 resolverAutorizacionArg0 = new ResolverAutorizacionArg0(resolverAutorizacionArg0Detail);
      ResolverAutorizacionRequestBody resolverAutorizacionRequestBody = new ResolverAutorizacionRequestBody(resolverAutorizacionArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(resolverAutorizacionRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      ResolverAutorizacion resolverAutorizacion = (ResolverAutorizacion)retrofit.create(ResolverAutorizacion.class);
      return resolverAutorizacion.requestStateInfo(envelope);
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
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      BuscarAutorizaciones buscarAutorizaciones = (BuscarAutorizaciones)retrofit.create(BuscarAutorizaciones.class);
      return buscarAutorizaciones.requestStateInfo(envelope);
   }

   public static Call<DetalleAutorizacionEnvelope> getDetalleAutorizacion(DetalleAutorizacionUsuario detalleAutorizacionUsuario) {
      DetalleAutorizacionArg0Detail detalleAutorizacionArg0Detail = new DetalleAutorizacionArg0Detail(detalleAutorizacionUsuario);
      DetalleAutorizacionArg0 detalleAutorizacionArg0 = new DetalleAutorizacionArg0(detalleAutorizacionArg0Detail);
      DetalleAutorizacionRequestBody detalleAutorizacionRequestBody = new DetalleAutorizacionRequestBody(detalleAutorizacionArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(detalleAutorizacionRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      DetalleAutorizacion detalleAutorizacion = (DetalleAutorizacion)retrofit.create(DetalleAutorizacion.class);
      return detalleAutorizacion.requestStateInfo(envelope);
   }

   public static Call<GlobalReponseEnvelope> mdificarAutorizacion(ModificarAutorizacionArg0Detail modificarAutorizacionArg0Detail) {
      ModificarAutorizacionArg0 modificarAutorizacionArg0 = new ModificarAutorizacionArg0(modificarAutorizacionArg0Detail);
      ModificarAutorizacionRequestBody modificarAutorizacionRequestBody = new ModificarAutorizacionRequestBody(modificarAutorizacionArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(modificarAutorizacionRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      ModificarAutorizacion modificarAutorizacion = (ModificarAutorizacion)retrofit.create(ModificarAutorizacion.class);
      return modificarAutorizacion.requestStateInfo(envelope);
   }

   public static Call<GlobalReponseEnvelope> altaAutorizacion(AltaAutorizationArg0Detail altaAutorizationArg0Detail) {
      AltaAutorizacionArg0 altaAutorizacionArg0 = new AltaAutorizacionArg0(altaAutorizationArg0Detail);
      AltaAutorizacionRequestBody altaAutorizacionRequestBody = new AltaAutorizacionRequestBody(altaAutorizacionArg0);
      GlobalRequestEnvelope envelope = new GlobalRequestEnvelope();
      envelope.setBody(altaAutorizacionRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance(false);
      AltaAutorizacion altaAutorizacion = (AltaAutorizacion)retrofit.create(AltaAutorizacion.class);
      return altaAutorizacion.requestStateInfo(envelope);
   }

   public static Call<LoginUnicoResponseEnvelope> loginUnico(LoginUnicoEntradaDetail loginUnicoEntradaDetail, Context context) {
      LoginUnicoEntrada loginUnicoEntrada = new LoginUnicoEntrada(loginUnicoEntradaDetail);
      LoginUnicoRequestBody loginUnicoRequestBody = new LoginUnicoRequestBody(loginUnicoEntrada);
      GlobalContratosRequestEnvelope envelope = new GlobalContratosRequestEnvelope();
      envelope.setBody(loginUnicoRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance("wsLoginLAUnico", context);
      LoginUnico loginUnico = (LoginUnico)retrofit.create(LoginUnico.class);
      return loginUnico.requestStateInfo(envelope);
   }

   public static Call<ContratosParaguasResponseEnvelope> getContratosParaguas(ContratoEntradaDetail contratoEntradaDetail, Context context) {
      ContratosEntrada contratosEntrada = new ContratosEntrada(contratoEntradaDetail);
      Object contratosBody;
      if (contratoEntradaDetail.getAliasUsuConexion() == null) {
         contratosBody = new ContratosParaguasBody(contratosEntrada);
      } else {
         contratosBody = new ContratosConexionBody(contratosEntrada);
      }

      GlobalContratosRequestEnvelope envelope = new GlobalContratosRequestEnvelope();
      envelope.setBody(contratosBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance("wsLoginLAUnico", context);
      GetContratos getContratos = (GetContratos)retrofit.create(GetContratos.class);
      return getContratos.requestStateInfo(envelope);
   }

   public static Call<ContratosConexionResponseEnvelope> getContratosConexion(ContratoEntradaDetail contratoEntradaDetail, Context context) {
      ContratosEntrada contratosEntrada = new ContratosEntrada(contratoEntradaDetail);
      ContratosConexionBody contratosBody = new ContratosConexionBody(contratosEntrada);
      GlobalContratosRequestEnvelope envelope = new GlobalContratosRequestEnvelope();
      envelope.setBody(contratosBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance("wsLoginLAUnico", context);
      GetContratosConexion getContratosConexion = (GetContratosConexion)retrofit.create(GetContratosConexion.class);
      return getContratosConexion.requestStateInfo(envelope);
   }

   public static Call<ObtenerDatosLoginResponseEnvelope> obtenerDatosLogin(ObtenerDatosLoginEntradaDetail obtenerDatosLoginEntradaDetail, Context context) {
      ObtenerDatosLoginEntrada obtenerDatosLoginEntrada = new ObtenerDatosLoginEntrada(obtenerDatosLoginEntradaDetail);
      ObtenerDatosLoginRequestBody obtenerDatosLoginRequestBody = new ObtenerDatosLoginRequestBody(obtenerDatosLoginEntrada);
      GlobalContratosRequestEnvelope envelope = new GlobalContratosRequestEnvelope();
      envelope.setBody(obtenerDatosLoginRequestBody);
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstance("wsLoginLAUnico", context);
      ObtenerDatosLogin obtejerDatosLogin = (ObtenerDatosLogin)retrofit.create(ObtenerDatosLogin.class);
      return obtejerDatosLogin.requestStateInfo(envelope);
   }

   public static Call<ResponseBody> onlineParameteres(Context context) {
      RetrofitUtility retrofitUtility = new RetrofitUtility();
      Retrofit retrofit = retrofitUtility.getRetrofitInstanceJson("wsOnlineParameters", context);
      OnlineParameters onlineParameters = (OnlineParameters)retrofit.create(OnlineParameters.class);
      return onlineParameters.onlineParameters();
   }
}
