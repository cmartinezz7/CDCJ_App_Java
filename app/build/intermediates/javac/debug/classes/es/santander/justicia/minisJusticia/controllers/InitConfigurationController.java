package es.santander.justicia.minisJusticia.controllers;

import android.content.Context;
import android.util.Log;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.santander.justicia.http.WSClientUtility;
import es.santander.justicia.http.beans.HttpClientSettings;
import es.santander.justicia.http.interfaces.WsResponse;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.interfaces.InitConfigurationInterface;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.minisJusticia.models.WebServiceSettingsModel;
import es.santander.justicia.utils.MinJusticeDBHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import net.sqlcipher.database.SQLiteDatabase;

public class InitConfigurationController implements WsResponse {
   private Context context;
   private InitConfigurationInterface callback;

   public InitConfigurationController(Context context) {
      this.context = context;
   }

   public void setCallback(InitConfigurationInterface callback) {
      this.callback = callback;
   }

   public void getInitConfiguration() {
      if (MainApplication.getInfo("LrVMkDw7vt7+iDkX9q6zPQ==").equals(MainApplication.getAppContext().getUrlConfigInit())) {
         BufferedReader reader = null;
         StringBuilder sb = new StringBuilder();

         try {
            reader = new BufferedReader(new InputStreamReader(this.context.getAssets().open("initConfigAppJuzgados")));

            String mLine;
            while((mLine = reader.readLine()) != null) {
               sb.append(mLine);
            }
         } catch (IOException var14) {
         } finally {
            if (reader != null) {
               try {
                  reader.close();
               } catch (IOException var12) {
               }
            }

         }

         this.onWsSuccess(0, sb.toString());
      } else {
         HttpClientSettings settings = new HttpClientSettings();
         URL url = null;

         try {
            url = new URL(MainApplication.getAppContext().getUrlConfigInit());
         } catch (MalformedURLException var13) {
            Log.e("InitConfigController", MainApplication.getAppContext().getUrlConfigInit() + " - MalformedURLException", var13);
         }

         settings.setUrl(url);
         settings.setRequestType("GET");
         WSClientUtility wsClientUtility = new WSClientUtility(this.context, this);
         wsClientUtility.execute(new HttpClientSettings[]{settings});
      }

   }

   public void onWsSuccess(int responseStatus, String wsResponse) {
      ObjectMapper mapper = new ObjectMapper();
      SQLiteDatabase db = null;

      try {
         JsonNode root = mapper.readTree(wsResponse);
         MinJusticeDBHelper.deleteAllData();
         db = MinJusticeDBHelper.getWritableDatabase();
         JsonNode spinnerValuesArray = root.path("spinnerValues");
         Iterator var7 = spinnerValuesArray.iterator();

         JsonNode videoLoginArray;
         JsonNode tealiumArray;
         while(var7.hasNext()) {
            videoLoginArray = (JsonNode)var7.next();
            String spinnerContentName = videoLoginArray.path("name").asText();
            long spinnerContentId = SpinnerContentModel.insert(db, spinnerContentName);
            tealiumArray = videoLoginArray.path("values");
            ArrayList<SpinnerValuesDTO> valuesArrayList = new ArrayList();
            Iterator var14 = tealiumArray.iterator();

            while(var14.hasNext()) {
               JsonNode values = (JsonNode)var14.next();
               SpinnerValuesDTO spinnerValues = new SpinnerValuesDTO();
               spinnerValues.setSpinnerContentId(spinnerContentId);
               spinnerValues.setCode(values.path("code").asText());
               spinnerValues.setEspValue(values.path("esp_value").asText());
               spinnerValues.setEngValue(values.path("eng_value").asText());
               valuesArrayList.add(spinnerValues);
            }

            SpinnerContentModel.insertSpinnerValues(db, spinnerContentName, valuesArrayList);
         }

         JsonNode webServiceValuesArray = root.path("webServices");
         Iterator var26 = webServiceValuesArray.iterator();

         JsonNode horariosArray;
         JsonNode helpArray;
         while(var26.hasNext()) {
            horariosArray = (JsonNode)var26.next();
            String webServiceName = horariosArray.path("name").asText();
            long webServiceId = WebServiceModel.insert(db, webServiceName);
            helpArray = horariosArray.path("settings");
            ArrayList<WebServiceSettingsDTO> settingsArrayList = new ArrayList();
            Iterator var37 = helpArray.iterator();

            while(var37.hasNext()) {
               JsonNode settings = (JsonNode)var37.next();
               WebServiceSettingsDTO wsSettings = new WebServiceSettingsDTO();
               wsSettings.setWebServiceId(webServiceId);
               wsSettings.setEnvironment(settings.path("environment").asText());
               wsSettings.setUrl(settings.path("url").asText());
               if (MainApplication.ENV_DEFAULT == "PROD") {
                  wsSettings.setUrlCertificate(settings.path("urlCertificate").asText());
               }

               wsSettings.setConnectionTimeout(settings.path("connectionTimeout").asInt());
               wsSettings.setReadTimeout(settings.path("readTimeout").asInt());
               settingsArrayList.add(wsSettings);
            }

            WebServiceSettingsModel.insertWebServiceSettings(db, settingsArrayList);
         }

         videoLoginArray = root.path("videoLogin");
         horariosArray = videoLoginArray.path("horarios");
         Iterator iterator = horariosArray.fields();

         while(iterator.hasNext()) {
            Entry<String, JsonNode> entry = (Entry)iterator.next();
            KeyValueModel.getInstance().insertValue(db, "horarioSaludo.", (String)entry.getKey(), ((JsonNode)entry.getValue()).asText());
         }

         JsonNode estacionesArray = videoLoginArray.path("estaciones");
         iterator = estacionesArray.fields();

         while(iterator.hasNext()) {
            Entry<String, JsonNode> entry = (Entry)iterator.next();
            KeyValueModel.getInstance().insertValue(db, "estacionesVideo.", (String)entry.getKey(), ((JsonNode)entry.getValue()).asText());
         }

         tealiumArray = root.path("tealium");
         Iterator var34 = tealiumArray.iterator();

         JsonNode pInfoArray;
         while(var34.hasNext()) {
            pInfoArray = (JsonNode)var34.next();
            KeyValueModel.getInstance().insertValue(db, "tealiumProp.environment.", pInfoArray.path("environment").asText(), pInfoArray.path("label").asText());
         }

         helpArray = root.path("ayuda");
         KeyValueModel.getInstance().insertValue(db, "aInfo.", "twitterURL", helpArray.path("twitterURL").asText());
         KeyValueModel.getInstance().insertValue(db, "aInfo.", "facebookURL", helpArray.path("facebookURL").asText());
         pInfoArray = helpArray.path("pInfo");
         String[] pInfoTypes = new String[]{"supernet", "select", "retail", "pb", "letrados"};
         String[] var40 = pInfoTypes;
         int var41 = pInfoTypes.length;

         for(int var18 = 0; var18 < var41; ++var18) {
            String type = var40[var18];
            KeyValueModel.getInstance().insertValue(db, "aInfo.", type + ".superlinea1", pInfoArray.path(type).path("superlinea1").asText());
            KeyValueModel.getInstance().insertValue(db, "aInfo.", type + ".superlinea2", pInfoArray.path(type).path("superlinea2").asText());
            KeyValueModel.getInstance().insertValue(db, "aInfo.", type + ".tarjeta1", pInfoArray.path(type).path("tarjeta1").asText());
            KeyValueModel.getInstance().insertValue(db, "aInfo.", type + ".tarjeta2", pInfoArray.path(type).path("tarjeta2").asText());
         }

         db.close();
         TealiumHelper.initialize(MainApplication.getAppContext());
         if (this.callback != null) {
            this.callback.onFinishInitConfiguration(true, "");
         }
      } catch (IOException var23) {
         Log.e("InitConfigController", "IOException", var23);
         if (this.callback != null) {
            this.callback.onFinishInitConfiguration(false, "Error");
         }
      } finally {
         db.close();
      }

   }

   public void onWsError(int responseStatus, String wsResponse) {
      try {
         File dbFile = this.context.getDatabasePath("santander_justicia_crypt.db");
         if (dbFile.exists()) {
            new MinJusticeDBHelper(this.context);
            if (this.callback != null) {
               this.callback.onFinishInitConfiguration(true, "");
            }
         } else if (this.callback != null) {
            this.callback.onFinishInitConfiguration(false, "Error");
         }
      } catch (Exception var5) {
         if (this.callback != null) {
            this.callback.onFinishInitConfiguration(false, "Error");
         }
      }

   }
}
