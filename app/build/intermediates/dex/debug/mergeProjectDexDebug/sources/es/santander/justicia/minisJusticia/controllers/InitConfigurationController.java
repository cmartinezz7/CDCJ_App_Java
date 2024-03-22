package es.santander.justicia.minisJusticia.controllers;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.http.WSClientUtility;
import es.santander.justicia.http.beans.HttpClientSettings;
import es.santander.justicia.http.interfaces.WsResponse;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.interfaces.InitConfigurationInterface;
import es.santander.justicia.utils.MinJusticeDBHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class InitConfigurationController implements WsResponse {
    private InitConfigurationInterface callback;
    private Context context;

    public InitConfigurationController(Context context2) {
        this.context = context2;
    }

    public void setCallback(InitConfigurationInterface callback2) {
        this.callback = callback2;
    }

    public void getInitConfiguration() {
        if (MainApplication.getInfo("LrVMkDw7vt7+iDkX9q6zPQ==").equals(MainApplication.getAppContext().getUrlConfigInit())) {
            BufferedReader reader = null;
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(this.context.getAssets().open("initConfigAppJuzgados")));
                while (true) {
                    String readLine = reader2.readLine();
                    String mLine = readLine;
                    if (readLine != null) {
                        sb.append(mLine);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                        }
                    }
                }
                reader2.close();
            } catch (IOException e2) {
                if (reader != null) {
                    reader.close();
                }
            } catch (Throwable th) {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
            onWsSuccess(0, sb.toString());
            return;
        }
        HttpClientSettings settings = new HttpClientSettings();
        URL url = null;
        try {
            url = new URL(MainApplication.getAppContext().getUrlConfigInit());
        } catch (MalformedURLException e4) {
            Log.e("InitConfigController", MainApplication.getAppContext().getUrlConfigInit() + " - MalformedURLException", e4);
        }
        settings.setUrl(url);
        settings.setRequestType("GET");
        new WSClientUtility(this.context, this).execute(new HttpClientSettings[]{settings});
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0334 A[Catch:{ all -> 0x033f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onWsSuccess(int r25, java.lang.String r26) {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r0 = "facebookURL"
            java.lang.String r2 = "twitterURL"
            java.lang.String r3 = "aInfo."
            com.fasterxml.jackson.databind.ObjectMapper r4 = new com.fasterxml.jackson.databind.ObjectMapper
            r4.<init>()
            r5 = 0
            r7 = r26
            com.fasterxml.jackson.databind.JsonNode r8 = r4.readTree(r7)     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            es.santander.justicia.utils.MinJusticeDBHelper.deleteAllData()     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            net.sqlcipher.database.SQLiteDatabase r9 = es.santander.justicia.utils.MinJusticeDBHelper.getWritableDatabase()     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            r5 = r9
            java.lang.String r9 = "spinnerValues"
            com.fasterxml.jackson.databind.JsonNode r9 = r8.path(r9)     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            java.util.Iterator r10 = r9.iterator()     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
        L_0x0026:
            boolean r11 = r10.hasNext()     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            java.lang.String r12 = "name"
            if (r11 == 0) goto L_0x00af
            java.lang.Object r11 = r10.next()     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            com.fasterxml.jackson.databind.JsonNode r11 = (com.fasterxml.jackson.databind.JsonNode) r11     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            com.fasterxml.jackson.databind.JsonNode r12 = r11.path(r12)     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            java.lang.String r12 = r12.asText()     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            long r13 = es.santander.justicia.minisJusticia.models.SpinnerContentModel.insert(r5, r12)     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            java.lang.String r15 = "values"
            com.fasterxml.jackson.databind.JsonNode r15 = r11.path(r15)     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            java.util.ArrayList r16 = new java.util.ArrayList     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            r16.<init>()     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            r17 = r16
            java.util.Iterator r16 = r15.iterator()     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
        L_0x0051:
            boolean r18 = r16.hasNext()     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            if (r18 == 0) goto L_0x00a2
            java.lang.Object r18 = r16.next()     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            com.fasterxml.jackson.databind.JsonNode r18 = (com.fasterxml.jackson.databind.JsonNode) r18     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            r19 = r18
            es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO r18 = new es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            r18.<init>()     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            r20 = r18
            r6 = r20
            r6.setSpinnerContentId(r13)     // Catch:{ IOException -> 0x0326, all -> 0x0322 }
            r20 = r4
            java.lang.String r4 = "code"
            r7 = r19
            com.fasterxml.jackson.databind.JsonNode r4 = r7.path(r4)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r4 = r4.asText()     // Catch:{ IOException -> 0x0320 }
            r6.setCode(r4)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r4 = "esp_value"
            com.fasterxml.jackson.databind.JsonNode r4 = r7.path(r4)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r4 = r4.asText()     // Catch:{ IOException -> 0x0320 }
            r6.setEspValue(r4)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r4 = "eng_value"
            com.fasterxml.jackson.databind.JsonNode r4 = r7.path(r4)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r4 = r4.asText()     // Catch:{ IOException -> 0x0320 }
            r6.setEngValue(r4)     // Catch:{ IOException -> 0x0320 }
            r4 = r17
            r4.add(r6)     // Catch:{ IOException -> 0x0320 }
            r7 = r26
            r17 = r4
            r4 = r20
            goto L_0x0051
        L_0x00a2:
            r20 = r4
            r4 = r17
            es.santander.justicia.minisJusticia.models.SpinnerContentModel.insertSpinnerValues(r5, r12, r4)     // Catch:{ IOException -> 0x0320 }
            r7 = r26
            r4 = r20
            goto L_0x0026
        L_0x00af:
            r20 = r4
            java.lang.String r4 = "webServices"
            com.fasterxml.jackson.databind.JsonNode r4 = r8.path(r4)     // Catch:{ IOException -> 0x0320 }
            java.util.Iterator r6 = r4.iterator()     // Catch:{ IOException -> 0x0320 }
        L_0x00bb:
            boolean r7 = r6.hasNext()     // Catch:{ IOException -> 0x0320 }
            java.lang.String r10 = "environment"
            if (r7 == 0) goto L_0x0174
            java.lang.Object r7 = r6.next()     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r7 = (com.fasterxml.jackson.databind.JsonNode) r7     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r11 = r7.path(r12)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r11 = r11.asText()     // Catch:{ IOException -> 0x0320 }
            long r13 = es.santander.justicia.minisJusticia.models.WebServiceModel.insert(r5, r11)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r15 = "settings"
            com.fasterxml.jackson.databind.JsonNode r15 = r7.path(r15)     // Catch:{ IOException -> 0x0320 }
            java.util.ArrayList r16 = new java.util.ArrayList     // Catch:{ IOException -> 0x0320 }
            r16.<init>()     // Catch:{ IOException -> 0x0320 }
            r17 = r16
            java.util.Iterator r16 = r15.iterator()     // Catch:{ IOException -> 0x0320 }
        L_0x00e6:
            boolean r19 = r16.hasNext()     // Catch:{ IOException -> 0x0320 }
            if (r19 == 0) goto L_0x015f
            java.lang.Object r19 = r16.next()     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r19 = (com.fasterxml.jackson.databind.JsonNode) r19     // Catch:{ IOException -> 0x0320 }
            r21 = r19
            es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO r19 = new es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO     // Catch:{ IOException -> 0x0320 }
            r19.<init>()     // Catch:{ IOException -> 0x0320 }
            r22 = r19
            r19 = r4
            r4 = r22
            r4.setWebServiceId(r13)     // Catch:{ IOException -> 0x0320 }
            r22 = r6
            r6 = r21
            com.fasterxml.jackson.databind.JsonNode r21 = r6.path(r10)     // Catch:{ IOException -> 0x0320 }
            r23 = r7
            java.lang.String r7 = r21.asText()     // Catch:{ IOException -> 0x0320 }
            r4.setEnvironment(r7)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r7 = "url"
            com.fasterxml.jackson.databind.JsonNode r7 = r6.path(r7)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r7 = r7.asText()     // Catch:{ IOException -> 0x0320 }
            r4.setUrl(r7)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r7 = es.santander.justicia.minisJusticia.common.MainApplication.ENV_DEFAULT     // Catch:{ IOException -> 0x0320 }
            r21 = r9
            java.lang.String r9 = "PROD"
            if (r7 != r9) goto L_0x0135
            java.lang.String r7 = "urlCertificate"
            com.fasterxml.jackson.databind.JsonNode r7 = r6.path(r7)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r7 = r7.asText()     // Catch:{ IOException -> 0x0320 }
            r4.setUrlCertificate(r7)     // Catch:{ IOException -> 0x0320 }
        L_0x0135:
            java.lang.String r7 = "connectionTimeout"
            com.fasterxml.jackson.databind.JsonNode r7 = r6.path(r7)     // Catch:{ IOException -> 0x0320 }
            int r7 = r7.asInt()     // Catch:{ IOException -> 0x0320 }
            r4.setConnectionTimeout(r7)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r7 = "readTimeout"
            com.fasterxml.jackson.databind.JsonNode r7 = r6.path(r7)     // Catch:{ IOException -> 0x0320 }
            int r7 = r7.asInt()     // Catch:{ IOException -> 0x0320 }
            r4.setReadTimeout(r7)     // Catch:{ IOException -> 0x0320 }
            r7 = r17
            r7.add(r4)     // Catch:{ IOException -> 0x0320 }
            r17 = r7
            r4 = r19
            r9 = r21
            r6 = r22
            r7 = r23
            goto L_0x00e6
        L_0x015f:
            r19 = r4
            r22 = r6
            r23 = r7
            r21 = r9
            r7 = r17
            es.santander.justicia.minisJusticia.models.WebServiceSettingsModel.insertWebServiceSettings(r5, r7)     // Catch:{ IOException -> 0x0320 }
            r4 = r19
            r9 = r21
            r6 = r22
            goto L_0x00bb
        L_0x0174:
            r19 = r4
            r21 = r9
            java.lang.String r4 = "videoLogin"
            com.fasterxml.jackson.databind.JsonNode r4 = r8.path(r4)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r6 = "horarios"
            com.fasterxml.jackson.databind.JsonNode r6 = r4.path(r6)     // Catch:{ IOException -> 0x0320 }
            java.util.Iterator r7 = r6.fields()     // Catch:{ IOException -> 0x0320 }
        L_0x0188:
            boolean r9 = r7.hasNext()     // Catch:{ IOException -> 0x0320 }
            if (r9 == 0) goto L_0x01af
            java.lang.Object r9 = r7.next()     // Catch:{ IOException -> 0x0320 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.models.KeyValueModel r11 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()     // Catch:{ IOException -> 0x0320 }
            java.lang.String r12 = "horarioSaludo."
            java.lang.Object r13 = r9.getKey()     // Catch:{ IOException -> 0x0320 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ IOException -> 0x0320 }
            java.lang.Object r14 = r9.getValue()     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r14 = (com.fasterxml.jackson.databind.JsonNode) r14     // Catch:{ IOException -> 0x0320 }
            java.lang.String r14 = r14.asText()     // Catch:{ IOException -> 0x0320 }
            r11.insertValue(r5, r12, r13, r14)     // Catch:{ IOException -> 0x0320 }
            goto L_0x0188
        L_0x01af:
            java.lang.String r9 = "estaciones"
            com.fasterxml.jackson.databind.JsonNode r9 = r4.path(r9)     // Catch:{ IOException -> 0x0320 }
            java.util.Iterator r11 = r9.fields()     // Catch:{ IOException -> 0x0320 }
            r7 = r11
        L_0x01ba:
            boolean r11 = r7.hasNext()     // Catch:{ IOException -> 0x0320 }
            if (r11 == 0) goto L_0x01e1
            java.lang.Object r11 = r7.next()     // Catch:{ IOException -> 0x0320 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.models.KeyValueModel r12 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()     // Catch:{ IOException -> 0x0320 }
            java.lang.String r13 = "estacionesVideo."
            java.lang.Object r14 = r11.getKey()     // Catch:{ IOException -> 0x0320 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ IOException -> 0x0320 }
            java.lang.Object r15 = r11.getValue()     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r15 = (com.fasterxml.jackson.databind.JsonNode) r15     // Catch:{ IOException -> 0x0320 }
            java.lang.String r15 = r15.asText()     // Catch:{ IOException -> 0x0320 }
            r12.insertValue(r5, r13, r14, r15)     // Catch:{ IOException -> 0x0320 }
            goto L_0x01ba
        L_0x01e1:
            java.lang.String r11 = "tealium"
            com.fasterxml.jackson.databind.JsonNode r11 = r8.path(r11)     // Catch:{ IOException -> 0x0320 }
            java.util.Iterator r12 = r11.iterator()     // Catch:{ IOException -> 0x0320 }
        L_0x01eb:
            boolean r13 = r12.hasNext()     // Catch:{ IOException -> 0x0320 }
            if (r13 == 0) goto L_0x021b
            java.lang.Object r13 = r12.next()     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r13 = (com.fasterxml.jackson.databind.JsonNode) r13     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.models.KeyValueModel r14 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()     // Catch:{ IOException -> 0x0320 }
            java.lang.String r15 = "tealiumProp.environment."
            com.fasterxml.jackson.databind.JsonNode r16 = r13.path(r10)     // Catch:{ IOException -> 0x0320 }
            r17 = r4
            java.lang.String r4 = r16.asText()     // Catch:{ IOException -> 0x0320 }
            r16 = r6
            java.lang.String r6 = "label"
            com.fasterxml.jackson.databind.JsonNode r6 = r13.path(r6)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r6 = r6.asText()     // Catch:{ IOException -> 0x0320 }
            r14.insertValue(r5, r15, r4, r6)     // Catch:{ IOException -> 0x0320 }
            r6 = r16
            r4 = r17
            goto L_0x01eb
        L_0x021b:
            r17 = r4
            r16 = r6
            java.lang.String r4 = "ayuda"
            com.fasterxml.jackson.databind.JsonNode r4 = r8.path(r4)     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.models.KeyValueModel r6 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r10 = r4.path(r2)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r10 = r10.asText()     // Catch:{ IOException -> 0x0320 }
            r6.insertValue(r5, r3, r2, r10)     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.models.KeyValueModel r2 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r6 = r4.path(r0)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r6 = r6.asText()     // Catch:{ IOException -> 0x0320 }
            r2.insertValue(r5, r3, r0, r6)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r0 = "pInfo"
            com.fasterxml.jackson.databind.JsonNode r0 = r4.path(r0)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r2 = "supernet"
            java.lang.String r6 = "select"
            java.lang.String r10 = "retail"
            java.lang.String r12 = "pb"
            java.lang.String r13 = "letrados"
            java.lang.String[] r2 = new java.lang.String[]{r2, r6, r10, r12, r13}     // Catch:{ IOException -> 0x0320 }
            int r6 = r2.length     // Catch:{ IOException -> 0x0320 }
            r10 = 0
        L_0x0259:
            if (r10 >= r6) goto L_0x0306
            r12 = r2[r10]     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.models.KeyValueModel r13 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()     // Catch:{ IOException -> 0x0320 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0320 }
            r14.<init>()     // Catch:{ IOException -> 0x0320 }
            java.lang.StringBuilder r14 = r14.append(r12)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r15 = ".superlinea1"
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r15 = r0.path(r12)     // Catch:{ IOException -> 0x0320 }
            r22 = r2
            java.lang.String r2 = "superlinea1"
            com.fasterxml.jackson.databind.JsonNode r2 = r15.path(r2)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r2 = r2.asText()     // Catch:{ IOException -> 0x0320 }
            r13.insertValue(r5, r3, r14, r2)     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.models.KeyValueModel r2 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()     // Catch:{ IOException -> 0x0320 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0320 }
            r13.<init>()     // Catch:{ IOException -> 0x0320 }
            java.lang.StringBuilder r13 = r13.append(r12)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r14 = ".superlinea2"
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r14 = r0.path(r12)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r15 = "superlinea2"
            com.fasterxml.jackson.databind.JsonNode r14 = r14.path(r15)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r14 = r14.asText()     // Catch:{ IOException -> 0x0320 }
            r2.insertValue(r5, r3, r13, r14)     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.models.KeyValueModel r2 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()     // Catch:{ IOException -> 0x0320 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0320 }
            r13.<init>()     // Catch:{ IOException -> 0x0320 }
            java.lang.StringBuilder r13 = r13.append(r12)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r14 = ".tarjeta1"
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r14 = r0.path(r12)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r15 = "tarjeta1"
            com.fasterxml.jackson.databind.JsonNode r14 = r14.path(r15)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r14 = r14.asText()     // Catch:{ IOException -> 0x0320 }
            r2.insertValue(r5, r3, r13, r14)     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.models.KeyValueModel r2 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()     // Catch:{ IOException -> 0x0320 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0320 }
            r13.<init>()     // Catch:{ IOException -> 0x0320 }
            java.lang.StringBuilder r13 = r13.append(r12)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r14 = ".tarjeta2"
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x0320 }
            com.fasterxml.jackson.databind.JsonNode r14 = r0.path(r12)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r15 = "tarjeta2"
            com.fasterxml.jackson.databind.JsonNode r14 = r14.path(r15)     // Catch:{ IOException -> 0x0320 }
            java.lang.String r14 = r14.asText()     // Catch:{ IOException -> 0x0320 }
            r2.insertValue(r5, r3, r13, r14)     // Catch:{ IOException -> 0x0320 }
            int r10 = r10 + 1
            r2 = r22
            goto L_0x0259
        L_0x0306:
            r22 = r2
            r5.close()     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.common.MainApplication r2 = es.santander.justicia.minisJusticia.common.MainApplication.getAppContext()     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.common.tealium.TealiumHelper.initialize(r2)     // Catch:{ IOException -> 0x0320 }
            es.santander.justicia.minisJusticia.interfaces.InitConfigurationInterface r2 = r1.callback     // Catch:{ IOException -> 0x0320 }
            if (r2 == 0) goto L_0x031c
            java.lang.String r3 = ""
            r6 = 1
            r2.onFinishInitConfiguration(r6, r3)     // Catch:{ IOException -> 0x0320 }
        L_0x031c:
            r5.close()
            goto L_0x033e
        L_0x0320:
            r0 = move-exception
            goto L_0x0329
        L_0x0322:
            r0 = move-exception
            r20 = r4
            goto L_0x0340
        L_0x0326:
            r0 = move-exception
            r20 = r4
        L_0x0329:
            java.lang.String r2 = "InitConfigController"
            java.lang.String r3 = "IOException"
            android.util.Log.e(r2, r3, r0)     // Catch:{ all -> 0x033f }
            es.santander.justicia.minisJusticia.interfaces.InitConfigurationInterface r2 = r1.callback     // Catch:{ all -> 0x033f }
            if (r2 == 0) goto L_0x033a
            java.lang.String r3 = "Error"
            r4 = 0
            r2.onFinishInitConfiguration(r4, r3)     // Catch:{ all -> 0x033f }
        L_0x033a:
            r5.close()
        L_0x033e:
            return
        L_0x033f:
            r0 = move-exception
        L_0x0340:
            r5.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.controllers.InitConfigurationController.onWsSuccess(int, java.lang.String):void");
    }

    public void onWsError(int responseStatus, String wsResponse) {
        try {
            if (this.context.getDatabasePath(MinJusticeDBHelper.DATABASE_NAME).exists()) {
                new MinJusticeDBHelper(this.context);
                InitConfigurationInterface initConfigurationInterface = this.callback;
                if (initConfigurationInterface != null) {
                    initConfigurationInterface.onFinishInitConfiguration(true, "");
                }
                return;
            }
            InitConfigurationInterface initConfigurationInterface2 = this.callback;
            if (initConfigurationInterface2 != null) {
                initConfigurationInterface2.onFinishInitConfiguration(false, "Error");
            }
        } catch (Exception e) {
            InitConfigurationInterface initConfigurationInterface3 = this.callback;
            if (initConfigurationInterface3 != null) {
                initConfigurationInterface3.onFinishInitConfiguration(false, "Error");
            }
        }
    }
}
