package com.tealium.internal.tagbridge;

import android.net.Uri;
import com.tealium.internal.e;
import com.tealium.internal.tagbridge.RemoteCommand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

class b extends RemoteCommand {
    public b() {
        super("_http", "Perform a native HTTP operation");
    }

    private String a(String str, JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("authenticate");
        if (optJSONObject == null) {
            return str;
        }
        String optString = optJSONObject.optString("username");
        String optString2 = optJSONObject.optString("password");
        if (optString == null || optString2 == null) {
            return str;
        }
        String str2 = "http://";
        if (!str.startsWith(str2)) {
            if (str.startsWith("https://")) {
                str2 = "https://";
            } else {
                throw new JSONException("Unsupported URL protocol.");
            }
        }
        try {
            return String.format(Locale.ROOT, "%s%s:%s@%s", new Object[]{str2, URLEncoder.encode(optString, "UTF-8"), URLEncoder.encode(optString2, "UTF-8"), str.substring(str2.length())});
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private void a(final RemoteCommand.Response response, final String str, final String str2) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    b.b(response, httpURLConnection);
                    httpURLConnection.setRequestMethod(str2);
                    httpURLConnection.setDoInput(true);
                    if ("POST".equals(str2) || "PUT".equals(str2)) {
                        httpURLConnection.setDoOutput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(b.b(response.getRequestPayload()));
                        outputStream.flush();
                        outputStream.close();
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine).append(10);
                        } else {
                            bufferedReader.close();
                            response.setStatus(httpURLConnection.getResponseCode()).setBody(sb.toString()).send();
                            return;
                        }
                    }
                } catch (IOException | JSONException e) {
                    response.setStatus(555).setBody(e.c.a(e)).send();
                }
            }
        }).start();
    }

    private String b(String str, JSONObject jSONObject) throws JSONException {
        char c;
        JSONObject optJSONObject = jSONObject.optJSONObject("parameters");
        if (optJSONObject == null) {
            return str;
        }
        Iterator<String> keys = optJSONObject.keys();
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                boolean hasNext = keys.hasNext();
                c = Typography.amp;
                if (!hasNext) {
                    break;
                }
                String next = keys.next();
                String obj = optJSONObject.get(next).toString();
                if (sb.length() > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(URLEncoder.encode(next, "UTF-8")).append('=').append(URLEncoder.encode(obj, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                return str;
            }
        }
        if (str.indexOf(63) <= 0) {
            c = '?';
        }
        sb.insert(0, c);
        return sb.insert(0, str).toString();
    }

    /* access modifiers changed from: private */
    public static void b(RemoteCommand.Response response, HttpURLConnection httpURLConnection) {
        JSONObject optJSONObject = response.getRequestPayload().optJSONObject("headers");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                httpURLConnection.setRequestProperty(next, optJSONObject.optString(next, ""));
            }
        }
    }

    /* access modifiers changed from: private */
    public static byte[] b(JSONObject jSONObject) throws JSONException, UnsupportedEncodingException {
        Charset forName = Charset.forName("UTF-8");
        Object opt = jSONObject.opt("body");
        if (!(opt instanceof JSONObject)) {
            return opt instanceof String ? URLEncoder.encode((String) opt, "UTF-8").getBytes(forName) : opt == null ? new byte[0] : URLEncoder.encode(opt.toString(), "UTF-8").getBytes(forName);
        }
        JSONObject jSONObject2 = (JSONObject) opt;
        Iterator<String> keys = jSONObject2.keys();
        Uri.Builder builder = new Uri.Builder();
        while (keys.hasNext()) {
            String next = keys.next();
            builder.appendQueryParameter(next, jSONObject2.optString(next, ""));
        }
        return builder.build().getEncodedQuery().getBytes(forName);
    }

    /* access modifiers changed from: protected */
    public void onInvoke(RemoteCommand.Response response) throws Exception {
        String optString = response.getRequestPayload().optString("url", (String) null);
        String optString2 = response.getRequestPayload().optString("method", (String) null);
        if (optString == null || optString2 == null) {
            response.setStatus(RemoteCommand.Response.STATUS_BAD_REQUEST).setBody(String.format(Locale.ROOT, "Missing required keys \"%s\" or \"%s\".", new Object[]{"method", "url"})).send();
            return;
        }
        a(response, b(a(optString, response.getRequestPayload()), response.getRequestPayload()), optString2.toUpperCase(Locale.ROOT));
    }
}
