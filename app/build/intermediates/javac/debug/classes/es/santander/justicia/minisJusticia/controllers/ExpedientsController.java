package es.santander.justicia.minisJusticia.controllers;

import android.util.Log;
import es.santander.justicia.http.WSSoapClientUtility;
import es.santander.justicia.http.beans.SoapClientSettings;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.http.interfaces.WsSoapResponse;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.controllers.ExpedientsController.1;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.SaldoDTO;
import es.santander.justicia.minisJusticia.interfaces.ExpedientsCallBack;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.EntradaXmlDetalleExpediente;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.ResponseDetalleExpediente;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.ParamsRequestDetalleExpediente.DatosAccesoProfesionales;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.XmlBodyExpedientsRequest;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ParamsRequestBuscarExpediente.DatosAcesooProfesionalesBuscar;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpedienteBuscar;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.soap.service.login.soap.service.petitions.params.FilterData;
import es.santander.justicia.utils.DateUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class ExpedientsController implements WsSoapResponse {
   private ExpedientsCallBack callback;
   private ExpedienteDTO expedient;

   public ExpedientsController(ExpedientsCallBack callback) {
      this.callback = callback;
   }

   public void getExpedients(ExpedienteDTO expedient, String dateFrom, String dateTo, String selectionType, String situationType, String currencyType) {
      if (dateFrom != null && dateFrom.length() >= 5) {
         dateFrom = DateUtils.formatDateToRequest(dateFrom);
      } else {
         dateFrom = "1970-01-01";
      }

      if (dateTo != null && dateTo.length() >= 5) {
         dateTo = DateUtils.formatDateToRequest(dateTo);
      } else {
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         dateTo = df.format(Calendar.getInstance().getTime());
      }

      DatosExpedienteBuscar expedientData;
      if (expedient != null) {
         expedientData = new DatosExpedienteBuscar(expedient.getJuzga(), expedient.getJuzgori(), expedient.getJnumexp(), expedient.getJproced(), expedient.getJanoapex(), situationType, currencyType);
      } else {
         expedientData = new DatosExpedienteBuscar("", "", "", "", "", situationType, currencyType);
      }

      DatosAcesooProfesionalesBuscar professionalDataAccess = new DatosAcesooProfesionalesBuscar(expedientData);
      FilterData filterData = new FilterData(dateFrom, dateTo, selectionType);
      DatosPaginacion pagination = new DatosPaginacion("1", "1000");
      XmlBodyExpedientsRequest xmlBody = new XmlBodyExpedientsRequest(professionalDataAccess, filterData, pagination);
      WSSoapClientUtility wsSoapClientUtility = new WSSoapClientUtility(this);
      PropertyInfo body = new PropertyInfo();
      body.setName("arg0");
      body.setValue(xmlBody);
      body.setType(xmlBody.getClass());
      SoapClientSettings soapSettings = new SoapClientSettings();
      soapSettings.setEnvironment(MainApplication.getAppContext().getEnvironment());
      soapSettings.setSoapWebServicesEnum(SoapWebServicesEnum.EXPEDIENTS_LIST);
      soapSettings.setBody(body);
      soapSettings.setInitConfigName("wsAccessRequestLS");
      wsSoapClientUtility.execute(new SoapClientSettings[]{soapSettings});
   }

   public void getExpedientDetail(ExpedienteDTO expedient) {
      this.expedient = expedient;
      DatosExpediente expedientData = new DatosExpediente(expedient.getJuzga(), expedient.getJuzgori(), expedient.getJnumexp(), expedient.getJproced(), expedient.getJanoapex());
      DatosAccesoProfesionales professionalDataAccess = new DatosAccesoProfesionales(expedientData);
      new DatosPaginacion("1", "1000");
      EntradaXmlDetalleExpediente xmlBody = new EntradaXmlDetalleExpediente(professionalDataAccess);
      WSSoapClientUtility wsSoapClientUtility = new WSSoapClientUtility(this);
      PropertyInfo body = new PropertyInfo();
      body.setName("arg0");
      body.setValue(xmlBody);
      body.setType(xmlBody.getClass());
      SoapClientSettings soapSettings = new SoapClientSettings();
      soapSettings.setEnvironment(MainApplication.getAppContext().getEnvironment());
      soapSettings.setSoapWebServicesEnum(SoapWebServicesEnum.EXPEDIENTS_DETAIL);
      soapSettings.setBody(body);
      soapSettings.setInitConfigName("wsAccessRequestLS");
      wsSoapClientUtility.execute(new SoapClientSettings[]{soapSettings});
   }

   public void onWsSoapSuccess(SoapWebServicesEnum wsRequest, Object response) {
      SoapObject expedientItem;
      switch(1.$SwitchMap$es$santander$justicia$http$enums$SoapWebServicesEnum[wsRequest.ordinal()]) {
      case 1:
         SoapObject requestResult = (SoapObject)response;
         ArrayList<SoapObject> petitionObjectList = new ArrayList();
         int responseSize = requestResult.getPropertyCount() - 1;

         for(int i = 0; i < responseSize; ++i) {
            SoapObject item = (SoapObject)requestResult.getProperty(i);
            petitionObjectList.add(item);
         }

         ArrayList<ExpedienteDTO> expedientList = new ArrayList();

         ExpedienteDTO expediente;
         for(Iterator var18 = petitionObjectList.iterator(); var18.hasNext(); expedientList.add(expediente)) {
            expedientItem = (SoapObject)var18.next();
            expediente = new ExpedienteDTO();
            if (expedientItem.hasProperty("juzga")) {
               expediente.setJuzga(expedientItem.getPropertyAsString("juzga"));
            }

            if (expedientItem.hasProperty("juzgori")) {
               expediente.setJuzgori(expedientItem.getPropertyAsString("juzgori"));
            }

            if (expedientItem.hasProperty("jproced")) {
               expediente.setJproced(expedientItem.getPropertyAsString("jproced"));
            }

            if (expedientItem.hasProperty("jnumexp")) {
               expediente.setJnumexp(expedientItem.getPropertyAsString("jnumexp"));
            }

            if (expedientItem.hasProperty("janoapex")) {
               expediente.setJanoapex(expedientItem.getPropertyAsString("janoapex"));
            }

            if (expedientItem.hasProperty("codExpediente")) {
               expediente.setCodExpediente(expedientItem.getPropertyAsString("codExpediente"));
            }

            if (expedientItem.hasProperty("primov")) {
               expediente.setPrimov(expedientItem.getPropertyAsString("primov"));
            }

            if (expedientItem.hasProperty("ultmov")) {
               expediente.setUltmov(expedientItem.getPropertyAsString("ultmov"));
            }

            if (expedientItem.hasProperty("situacion")) {
               expediente.setSituacion(expedientItem.getPropertyAsString("situacion"));
            }

            if (expedientItem.hasProperty("sitexp")) {
               expediente.setSitexp(expedientItem.getPropertyAsString("sitexp"));
            }

            if (expedientItem.hasProperty("saldos")) {
               SoapObject saldosObject = (SoapObject)expedientItem.getProperty("saldos");
               if (saldosObject.hasProperty("codmon")) {
                  expediente.setCodmon(saldosObject.getPropertyAsString("codmon"));
               }

               if (saldosObject.hasProperty("impsaldo")) {
                  expediente.setSaldo(saldosObject.getPropertyAsString("impsaldo"));
               }

               if (saldosObject.hasProperty("moneda")) {
                  expediente.setMoneda(saldosObject.getPropertyAsString("moneda"));
               }
            }
         }

         this.callback.onFinishGetExpedients(expedientList, true, "");
         break;
      case 2:
         ResponseDetalleExpediente responseDetalleExpediente = new ResponseDetalleExpediente((SoapObject)response);
         expedientItem = responseDetalleExpediente.getDatosExpediente();
         List<SaldoDTO> saldos = new ArrayList();

         for(int i = 0; i < expedientItem.getPropertyCount(); ++i) {
            PropertyInfo saldoSoapProperty = expedientItem.getPropertyInfo(i);
            if ("saldos".equals(saldoSoapProperty.getName()) && saldoSoapProperty.getValue() instanceof SoapObject) {
               SaldoDTO saldoDTO = new SaldoDTO();
               SoapObject saldoSoapObject = (SoapObject)saldoSoapProperty.getValue();

               try {
                  saldoDTO.setCodmon(saldoSoapObject.getProperty("codmon").toString());
                  saldoDTO.setIngpendconso(saldoSoapObject.getProperty("ingpendconso").toString());
                  saldoDTO.setMoneda(saldoSoapObject.getProperty("moneda").toString());
                  saldoDTO.setPagopendconf(saldoSoapObject.getProperty("pagopendconf").toString());
                  saldoDTO.setPagopendconso(saldoSoapObject.getProperty("pagopendconso").toString());
                  saldoDTO.setSaldoconso(saldoSoapObject.getProperty("saldoconso").toString());
                  saldoDTO.setSaldodia(saldoSoapObject.getProperty("saldodia").toString());
                  saldoDTO.setSaldodisp(saldoSoapObject.getProperty("saldodisp").toString());
                  saldoDTO.setSaldoingdeposito(saldoSoapObject.getProperty("saldoingdeposito").toString());
                  saldoDTO.setSaldoingerroneo(saldoSoapObject.getProperty("saldoingerroneo").toString());
                  saldoDTO.setPrincipal(saldoSoapObject.getProperty("principal").toString());
                  this.expedient.setIntCostas(expedientItem.getPropertyAsString("impInterCostas"));
               } catch (Exception var15) {
                  Log.e("ExpedientsController", "Error parseo datos", var15);
               }

               saldos.add(saldoDTO);
            }
         }

         this.expedient.setSaldos(saldos);
         this.expedient.setDetail(true);
         this.callback.onFinishGetExpedientDetail(this.expedient, true, "");
      }

   }

   public void onWsSoapError(SoapWebServicesEnum wsRequest, Object response) {
      SoapFault error = (SoapFault)response;
      String errorMessage = error != null ? error.faultstring : "Error al invocar al servicio, vuelva a intentarlo";
      switch(1.$SwitchMap$es$santander$justicia$http$enums$SoapWebServicesEnum[wsRequest.ordinal()]) {
      case 1:
         this.callback.onFinishGetExpedients((ArrayList)null, false, errorMessage);
         break;
      case 2:
         this.callback.onFinishGetExpedientDetail((ExpedienteDTO)null, false, errorMessage);
      }

   }
}
