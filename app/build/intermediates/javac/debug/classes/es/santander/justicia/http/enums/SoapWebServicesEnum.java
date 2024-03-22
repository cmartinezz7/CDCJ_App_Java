package es.santander.justicia.http.enums;

import androidx.core.util.Pair;
import es.santander.justicia.http.enums.SoapWebServicesEnum.1;
import es.santander.justicia.http.enums.SoapWebServicesEnum.2;
import es.santander.justicia.http.enums.SoapWebServicesEnum.3;
import es.santander.justicia.http.enums.SoapWebServicesEnum.4;
import es.santander.justicia.http.enums.SoapWebServicesEnum.5;  
import es.santander.justicia.http.enums.SoapWebServicesEnum.6;
import es.santander.justicia.http.enums.SoapWebServicesEnum.7;
import es.santander.justicia.http.enums.SoapWebServicesEnum.8;
import es.santander.justicia.http.enums.SoapWebServicesEnum.9;
import java.util.ArrayList;

public enum SoapWebServicesEnum {
   USER_DETAIL("detallesUsuario", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:detallesUsuario", new 1()),
   DETAIL_MOVEMENTS("detalleMovimiento", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:detalleMovimiento", new 2()),
   SEARCH_COURTS("searchCourt", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:consultaJuzgados", new 3()),
   COURT_DETAIL("courtDetail", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:detalleJuzgado", new 4()),
   ACCESS_REQUEST("accessRequest", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:solicitudAcceso", new 5()),
   MOVEMENT_QUERY("accessRequest", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "wss:consultaMovimientos", new 6()),
   PETITIONS_LIST("accessRequest", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:buscarPeticionesAcceso", new 7()),
   EXPEDIENTS_LIST("accessRequest", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:buscarExpedientes", new 8()),
   EXPEDIENTS_DETAIL("accessRequest", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:detalleExpediente", new 9());

   private String wsName;
   private String nameSpace;
   private String methodName;
   private ArrayList<Pair<String, String>> attributes;

   private SoapWebServicesEnum(String wsName, String nameSpace, String metodeName, ArrayList<Pair<String, String>> attributes) {
      this.wsName = wsName;
      this.nameSpace = nameSpace;
      this.methodName = metodeName;
      this.attributes = attributes;
   }

   public String getWsName() {
      return this.wsName;
   }

   public String getNameSpace() {
      return this.nameSpace;
   }

   public String getMethodName() {
      return this.methodName;
   }

   public ArrayList<Pair<String, String>> getAttributes() {
      return this.attributes;
   }

   public String getSoapAction() {
      String soapAction = this.nameSpace + this.methodName;
      return soapAction;
   }
}
