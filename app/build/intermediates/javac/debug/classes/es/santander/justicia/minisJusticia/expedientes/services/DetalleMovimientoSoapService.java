package es.santander.justicia.minisJusticia.expedientes.services;

import android.util.Log;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.minisJusticia.common.services.JusticiaSoapService;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.soap.service.login.soap.service.DetailMovements.XmlBodyDetailMovements;
import es.santander.justicia.soap.service.login.soap.service.DetailMovements.params.DatosAccesoProfesionalesMovementData;
import es.santander.justicia.soap.service.login.soap.service.DetailMovements.params.DatosExpedienteDetail;
import es.santander.justicia.utils.DateUtils;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class DetalleMovimientoSoapService extends JusticiaSoapService {
   public DetalleMovimientoSoapService() {
      super(SoapWebServicesEnum.DETAIL_MOVEMENTS, "wsAccessRequestLS");
   }

   public MovementItemDTO getDetalleMovimiento(MovementItemDTO movementItemDTO, String juzga, String jnuoper) {
      SoapObject requestResult = null;

      try {
         DatosExpedienteDetail datosExpedienteDetail = new DatosExpedienteDetail(juzga);
         DatosAccesoProfesionalesMovementData datosAccesoProfesionalesMovementData = new DatosAccesoProfesionalesMovementData(datosExpedienteDetail, jnuoper);
         XmlBodyDetailMovements xmlBody = new XmlBodyDetailMovements(datosAccesoProfesionalesMovementData);
         PropertyInfo body = new PropertyInfo();
         body.setName("arg0");
         body.setValue(xmlBody);
         body.setType(xmlBody.getClass());
         requestResult = this.sendRequest(body);
      } catch (Exception var11) {
         Log.e("DetalleMovSoapService", "Error al formatear la respuesta: " + var11.getMessage(), var11);
      }

      try {
         movementItemDTO.setDetail(true);
         SoapObject datosOperacion = (SoapObject)requestResult.getProperty("datosOperacion");
         SoapObject datosExpediente = (SoapObject)datosOperacion.getProperty("datosExpediente");
         SoapObject datosExpedienteDestino = datosOperacion.hasProperty("datosExpedienteDestino") ? (SoapObject)datosOperacion.getProperty("datosExpedienteDestino") : null;
         SoapObject datosSaldo = (SoapObject)datosExpediente.getProperty("saldos");
         SoapObject datosRepresentante = datosOperacion.hasProperty("datosRepresentante") ? (SoapObject)datosOperacion.getProperty("datosRepresentante") : null;
         if (datosExpedienteDestino != null) {
            movementItemDTO.setExpedienteDestino(datosExpedienteDestino.hasProperty("codExpediente") ? datosExpedienteDestino.getProperty("codExpediente").toString() : "");
         }

         if (datosRepresentante != null) {
            movementItemDTO.setRepresentante(datosRepresentante.hasProperty("genombre") ? datosRepresentante.getProperty("genombre").toString() : "");
         }

         movementItemDTO.setImporteSaldo(datosSaldo.hasProperty("impsaldo") ? datosSaldo.getProperty("impsaldo").toString() : "");
         movementItemDTO.setRepresentado(datosOperacion.hasProperty("jnors") ? datosOperacion.getProperty("jnors").toString() : "");
         movementItemDTO.setDocumento(datosOperacion.hasProperty("coddocum") ? datosOperacion.getProperty("coddocum").toString() : "");
         movementItemDTO.setConcepto(datosOperacion.hasProperty("conc30") ? datosOperacion.getProperty("conc30").toString() : "");
         movementItemDTO.setFecha(datosOperacion.hasProperty("jfecconf") ? DateUtils.formatDate(datosOperacion.getProperty("jfecconf").toString()) : "");
         movementItemDTO.setImporteDetalle(datosOperacion.hasProperty("jimpnomi") ? datosOperacion.getProperty("jimpnomi").toString() : "");
         movementItemDTO.setJfechare(datosOperacion.hasProperty("jfechare") ? DateUtils.formatDate(datosOperacion.getProperty("jfechare").toString()) : "");
         movementItemDTO.setjFechaFirma(datosOperacion.hasProperty("jfecfirma") ? DateUtils.formatDate(datosOperacion.getProperty("jfecfirma").toString()) : "");
         movementItemDTO.setjFechaFirmeza(datosOperacion.hasProperty("jfecfirmeza") ? DateUtils.formatDate(datosOperacion.getProperty("jfecfirmeza").toString()) : "");
         movementItemDTO.setjFechaAutorizacion(datosOperacion.hasProperty("jfecautoriza") ? DateUtils.formatDate(datosOperacion.getProperty("jfecautoriza").toString()) : "");
         movementItemDTO.setjFechaConfirmacion(datosOperacion.hasProperty("jfecconf") ? DateUtils.formatDate(datosOperacion.getProperty("jfecconf").toString()) : "");
         movementItemDTO.setjFechaCaducidad(datosOperacion.hasProperty("jfeccaduc") ? DateUtils.formatDate(datosOperacion.getProperty("jfeccaduc").toString()) : "");
         movementItemDTO.setjResponsableAlta(datosOperacion.hasProperty("jusrhare") ? datosOperacion.getProperty("jusrhare").toString() : "");
         movementItemDTO.setjResponsableFirma(datosOperacion.hasProperty("jusrfirma") ? datosOperacion.getProperty("jusrfirma").toString() : "");
         movementItemDTO.setjResponsableFirmeza(datosOperacion.hasProperty("jusrfirmeza") ? datosOperacion.getProperty("jusrfirmeza").toString() : "");
         movementItemDTO.setjResponsableAutorizacion(datosOperacion.hasProperty("jusrautoriza") ? datosOperacion.getProperty("jusrautoriza").toString() : "");
         movementItemDTO.setjResponsableConfirmacion(datosOperacion.hasProperty("jusrconf") ? datosOperacion.getProperty("jusrconf").toString() : "");
         return movementItemDTO;
      } catch (Exception var10) {
         Log.e("DetalleMovSoapService", "Error al formatear la respuesta: " + var10.getMessage(), var10);
         return null;
      }
   }
}
