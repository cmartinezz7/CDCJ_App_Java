package es.santander.justicia.minisJusticia.controllers;

import es.santander.justicia.http.WSSoapClientUtility;
import es.santander.justicia.http.beans.SoapClientSettings;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.http.interfaces.WsSoapResponse;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import es.santander.justicia.minisJusticia.interfaces.CourtSearcherCallback;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.soap.service.login.soap.service.courtSearcher.XmlBodyCourtSearcherRequest;
import es.santander.justicia.soap.service.login.soap.service.courtSearcher.params.CourtData;
import es.santander.justicia.soap.service.login.soap.service.courtSearcher.params.PlaceData;
import java.util.ArrayList;
import java.util.Iterator;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class CourtSearcherController implements WsSoapResponse {
   private CourtSearcherCallback callback;

   public CourtSearcherController(CourtSearcherCallback callback) {
      this.callback = callback;
   }

   public void searchCourts(String codProvince, String codJudicialEnvironment) {
      PlaceData placeData = new PlaceData("", "", codProvince);
      CourtData courtData = new CourtData(codProvince, codJudicialEnvironment, "", placeData);
      DatosPaginacion pagination = new DatosPaginacion("1", "1000");
      XmlBodyCourtSearcherRequest xmlBody = new XmlBodyCourtSearcherRequest(courtData, pagination);
      WSSoapClientUtility wsSoapClientUtility = new WSSoapClientUtility(this);
      PropertyInfo body = new PropertyInfo();
      body.setName("arg0");
      body.setValue(xmlBody);
      body.setType(xmlBody.getClass());
      SoapClientSettings soapSettings = new SoapClientSettings();
      soapSettings.setEnvironment(MainApplication.getAppContext().getEnvironment());
      soapSettings.setSoapWebServicesEnum(SoapWebServicesEnum.SEARCH_COURTS);
      soapSettings.setBody(body);
      soapSettings.setInitConfigName("wsAccessRequestLS");
      wsSoapClientUtility.execute(new SoapClientSettings[]{soapSettings});
   }

   public void onWsSoapSuccess(SoapWebServicesEnum wsRequest, Object response) {
      SoapObject requestResult = (SoapObject)response;
      ArrayList<SoapObject> courtObjectList = new ArrayList();
      int responseSize = requestResult.getPropertyCount() - 1;

      for(int i = 0; i < responseSize; ++i) {
         SoapObject item = (SoapObject)requestResult.getProperty(i);
         courtObjectList.add(item);
      }

      ArrayList<CourtDataDto> courtDataList = new ArrayList();
      Iterator var11 = courtObjectList.iterator();

      while(var11.hasNext()) {
         SoapObject courtObject = (SoapObject)var11.next();
         CourtDataDto courtData = new CourtDataDto();
         courtData.setOrganismName(courtObject.getProperty("nombreOrganismo").toString());
         courtData.setJudicialEnvironment(courtObject.getProperty("entornoJudicial").toString());
         courtData.setStatus(courtObject.getProperty("estado").toString());
         courtData.setProvince(courtObject.getProperty("provincia").toString());
         courtData.setCourtCode(courtObject.getProperty("juzga").toString());
         courtDataList.add(courtData);
      }

      this.callback.onFinishSearch(courtDataList, true);
   }

   public void onWsSoapError(SoapWebServicesEnum wsRequest, Object response) {
      this.callback.onFinishSearch((ArrayList)null, false);
   }
}
