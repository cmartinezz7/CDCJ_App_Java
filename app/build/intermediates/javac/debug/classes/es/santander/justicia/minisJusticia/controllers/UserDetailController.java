package es.santander.justicia.minisJusticia.controllers;

import es.santander.justicia.http.WSSoapClientUtility;
import es.santander.justicia.http.beans.SoapClientSettings;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.http.interfaces.WsSoapResponse;
import es.santander.justicia.minisJusticia.dto.UserDetailDTO;
import es.santander.justicia.minisJusticia.interfaces.UserDetailCallBack;
import es.santander.justicia.soap.service.login.soap.service.UserDetail.XmlBodyUserDetail;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class UserDetailController implements WsSoapResponse {
   private UserDetailCallBack callBack;

   public UserDetailController(UserDetailCallBack userDetailCallBack) {
      this.callBack = userDetailCallBack;
   }

   public void getDetailMovementData(String environment) {
      XmlBodyUserDetail xmlBody = new XmlBodyUserDetail();
      WSSoapClientUtility wsSoapClientUtility = new WSSoapClientUtility(this);
      PropertyInfo body = new PropertyInfo();
      body.setName("");
      body.setValue(xmlBody);
      body.setType(xmlBody.getClass());
      SoapClientSettings soapSettings = new SoapClientSettings();
      soapSettings.setEnvironment(environment);
      soapSettings.setSoapWebServicesEnum(SoapWebServicesEnum.USER_DETAIL);
      soapSettings.setBody(body);
      soapSettings.setInitConfigName("wsAccessRequestLS");
      wsSoapClientUtility.execute(new SoapClientSettings[]{soapSettings});
   }

   public void onWsSoapSuccess(SoapWebServicesEnum wsRequest, Object response) {
      SoapObject requestResult = (SoapObject)response;
      UserDetailDTO userDetailDTO = new UserDetailDTO();
      userDetailDTO.setGroupID(requestResult.getProperty("groupId").toString());
      userDetailDTO.setName(requestResult.getProperty("name").toString());
      userDetailDTO.setSurname(requestResult.getProperty("surname").toString());
      userDetailDTO.setSurname2(requestResult.getProperty("surname2").toString());
      this.callBack.onFinishUserDetailData(userDetailDTO, true);
   }

   public void onWsSoapError(SoapWebServicesEnum wsRequest, Object response) {
      this.callBack.onFinishUserDetailData((UserDetailDTO)null, false);
   }
}
