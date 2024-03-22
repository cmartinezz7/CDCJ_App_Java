package es.santander.justicia.minisJusticia.connections;

import es.santander.justicia.minisJusticia.models.requests.GlobalContratosRequestEnvelope;
import es.santander.justicia.minisJusticia.models.requests.GlobalRequestEnvelope;
import es.santander.justicia.minisJusticia.models.requests.login.LoginRequestEnvelope;
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
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CallInteface {

    public interface AcpetarSolicitud {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<AceptarSolicitudResponseEnvelopment> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface ActivarExpediente {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<ActivarExpedienteResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface AdvicesAppi {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<AvisosResponseEnvelop> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface AltaAutorizacion {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<GlobalReponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface AnularOpPteCobro {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<AnularOpPteCobroResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface AnularOpPteConfirmacion {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<AnularOpPteConfirmacionResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface AnularOpPteIngreso {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<AnularOpPteIngresoResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface BajaEmbargo {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<BajaEmbargoResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface BajaSolicitud {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<BajaSolicitudResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface BuscPetAcceso {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<BuscPetAccResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface BuscarAutorizaciones {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<AutorizacionesUsuarioEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface BuscarEmbargos {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<EmbargoResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface BuscarExpedientes {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<BuscExpResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface CambiarOrganismo {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<CambiarOrganismoRespEnvelopment> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface ConfirmarOpPteConfi {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<ConfirmarOpPteConfResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface ConsultaJuzgados {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<ConsultaJuzgadosResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface ConsultaOperacionesEjecutadas {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<OpeEjectResponseEnvelop> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface ConsultaOperacionesPendientes {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<OpePenResponseEnvelop> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface ConsultaOrganosAsignados {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<ConsultaOrganosAsigRespEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface ConsultasOperacion {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<ConsuOperResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface DenegarSolicitud {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<DenegarSolicitudResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface DetalleAutorizacion {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<DetalleAutorizacionEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface DetalleExpediente {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<DetalleExpResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface DetalleJuzgados {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<DetalleJuzgadosResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface DetalleMovimiento {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<DetalleMovimientoResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface DetallePetAccesoResponse {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<DetallePetAccReponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface GetContratos {
        @POST("./SCH_EMPMOV_CONTRATOS_ENS/ws/BAMOBI_WS_Def_Listener")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<ContratosParaguasResponseEnvelope> requestStateInfo(@Body GlobalContratosRequestEnvelope globalContratosRequestEnvelope);
    }

    public interface GetContratosConexion {
        @POST("./SCH_EMPMOV_CONTRATOS_ENS/ws/BAMOBI_WS_Def_Listener")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<ContratosConexionResponseEnvelope> requestStateInfo(@Body GlobalContratosRequestEnvelope globalContratosRequestEnvelope);
    }

    public interface ListaMovimientos {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<ListaMovimientosResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface Login {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<LoginResponseEnvelope> requestStateInfo(@Body LoginRequestEnvelope loginRequestEnvelope);
    }

    public interface LoginUnico {
        @POST("./SCH_EMPMOV_CONTRATOS_ENS/ws/BAMOBI_WS_Def_Listener")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<LoginUnicoResponseEnvelope> requestStateInfo(@Body GlobalContratosRequestEnvelope globalContratosRequestEnvelope);
    }

    public interface Logout {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<Void> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface ModificarAutorizacion {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<GlobalReponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface ModificarSolicitud {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<ModificarSolicitudResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface ObtenerDatosLogin {
        @POST("./SCH_EMPMOV_CONTRATOS_ENS/ws/BAMOBI_WS_Def_Listener")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<ObtenerDatosLoginResponseEnvelope> requestStateInfo(@Body GlobalContratosRequestEnvelope globalContratosRequestEnvelope);
    }

    public interface OnlineParameters {
        @GET("./files/apps/Justicia/onlineparameters.json")
        Call<ResponseBody> onlineParameters();
    }

    public interface ResolverAutorizacion {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<ResolverAutorizacionEnvelope> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }

    public interface UserDetail {
        @POST("./")
        @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
        Call<DetalleUsuarioResponseEnvelop> requestStateInfo(@Body GlobalRequestEnvelope globalRequestEnvelope);
    }
}
