package es.santander.justicia.minisJusticia.controllers;

import es.santander.justicia.http.WSSoapClientUtility;
import es.santander.justicia.http.beans.SoapClientSettings;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.http.interfaces.WsSoapResponse;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.PeticionDTO;
import es.santander.justicia.minisJusticia.interfaces.PetitionsCallback;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.soap.service.login.soap.service.petitions.XmlBodyPetitionsRequest;
import es.santander.justicia.soap.service.login.soap.service.petitions.params.FilterData;
import es.santander.justicia.soap.service.login.soap.service.petitions.params.ProfessionalDataAccess;
import es.santander.justicia.utils.DateUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class PetitionController implements WsSoapResponse {
   private PetitionsCallback callback;

   public PetitionController(PetitionsCallback callback) {
      this.callback = callback;
   }

   public void getPetitions(ExpedienteDTO expedient, String petitionStatus, String dateFrom, String dateTo, String selectionType) {
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

      DatosExpediente expedientData;
      if (expedient != null) {
         expedientData = new DatosExpediente(expedient.getJuzga(), expedient.getJuzgori(), expedient.getJnumexp(), expedient.getJproced(), expedient.getJanoapex());
      } else {
         expedientData = new DatosExpediente("", "", "", "", "");
      }

      ProfessionalDataAccess professionalDataAccess = new ProfessionalDataAccess(expedientData, petitionStatus);
      FilterData filterData = new FilterData(dateFrom, dateTo, selectionType);
      DatosPaginacion pagination = new DatosPaginacion("1", "1000");
      XmlBodyPetitionsRequest xmlBody = new XmlBodyPetitionsRequest(professionalDataAccess, filterData, pagination);
      WSSoapClientUtility wsSoapClientUtility = new WSSoapClientUtility(this);
      PropertyInfo body = new PropertyInfo();
      body.setName("arg0");
      body.setValue(xmlBody);
      body.setType(xmlBody.getClass());
      SoapClientSettings soapSettings = new SoapClientSettings();
      soapSettings.setEnvironment(MainApplication.getAppContext().getEnvironment());
      soapSettings.setSoapWebServicesEnum(SoapWebServicesEnum.PETITIONS_LIST);
      soapSettings.setBody(body);
      soapSettings.setInitConfigName("wsAccessRequestLS");
      wsSoapClientUtility.execute(new SoapClientSettings[]{soapSettings});
   }

   public void onWsSoapSuccess(SoapWebServicesEnum wsRequest, Object response) {
      SoapObject requestResult = (SoapObject)response;
      ArrayList<SoapObject> petitionObjectList = new ArrayList();
      int responseSize = requestResult.getPropertyCount() - 1;

      for(int i = 0; i < responseSize; ++i) {
         SoapObject item = (SoapObject)requestResult.getProperty(i);
         petitionObjectList.add(item);
      }

      ArrayList<PeticionDTO> petitionList = new ArrayList();

      PeticionDTO petition;
      for(Iterator var12 = petitionObjectList.iterator(); var12.hasNext(); petitionList.add(petition)) {
         SoapObject petitionItem = (SoapObject)var12.next();
         petition = new PeticionDTO();
         if (petitionItem.hasProperty("datosExpediente")) {
            SoapObject expedientData = (SoapObject)petitionItem.getProperty("datosExpediente");
            if (expedientData.hasProperty("codExpediente")) {
               petition.setCodExpediente(expedientData.getPropertyAsString("codExpediente"));
            }
         }

         if (petitionItem.hasProperty("fecacept")) {
            petition.setFecacept(petitionItem.getPrimitivePropertyAsString("fecacept"));
         }

         if (petitionItem.hasProperty("fecpetic")) {
            petition.setFecpetic(petitionItem.getPrimitivePropertyAsString("fecpetic"));
         }

         if (petitionItem.hasProperty("jestactu")) {
            petition.setJestactu(petitionItem.getPrimitivePropertyAsString("jestactu"));
         }
      }

      Collections.sort(petitionList);
      this.callback.onFinishGetPetitions(petitionList, true, "");
   }

   public void onWsSoapError(SoapWebServicesEnum wsRequest, Object response) {
      SoapFault error = (SoapFault)response;
      String errorMessage = error != null ? error.faultstring : "Error al invocar al servicio, vuelva a intentarlo";
      this.callback.onFinishGetPetitions((ArrayList)null, false, errorMessage);
   }
}
