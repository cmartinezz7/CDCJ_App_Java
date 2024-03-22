package org.ksoap2.transport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.ksoap2.SoapEnvelope;
import org.xmlpull.v1.XmlPullParserException;

public class HttpTransportSE extends Transport {
    public HttpTransportSE(String url) {
        super((Proxy) null, url);
    }

    public HttpTransportSE(Proxy proxy, String url) {
        super(proxy, url);
    }

    public HttpTransportSE(String url, int timeout) {
        super(url, timeout);
    }

    public HttpTransportSE(Proxy proxy, String url, int timeout) {
        super(proxy, url, timeout);
    }

    public HttpTransportSE(String url, int timeout, int contentLength) {
        super(url, timeout);
    }

    public HttpTransportSE(Proxy proxy, String url, int timeout, int contentLength) {
        super(proxy, url, timeout);
    }

    public void call(String soapAction, SoapEnvelope envelope) throws HttpResponseException, IOException, XmlPullParserException {
        call(soapAction, envelope, (List) null);
    }

    public List call(String soapAction, SoapEnvelope envelope, List headers) throws HttpResponseException, IOException, XmlPullParserException {
        return call(soapAction, envelope, headers, (File) null);
    }

    /* Debug info: failed to restart local var, previous not found, register: 18 */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0172 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x018f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List call(java.lang.String r19, org.ksoap2.SoapEnvelope r20, java.util.List r21, java.io.File r22) throws org.ksoap2.transport.HttpResponseException, java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            r18 = this;
            r1 = r18
            r2 = r20
            r3 = r21
            r4 = r22
            if (r19 != 0) goto L_0x000e
            java.lang.String r0 = "\"\""
            r5 = r0
            goto L_0x0010
        L_0x000e:
            r5 = r19
        L_0x0010:
            java.lang.String r0 = "UTF-8"
            byte[] r0 = r1.createRequestData(r2, r0)
            boolean r6 = r1.debug
            r7 = 0
            if (r6 == 0) goto L_0x0021
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0)
            goto L_0x0022
        L_0x0021:
            r6 = r7
        L_0x0022:
            r1.requestDump = r6
            r1.responseDump = r7
            org.ksoap2.transport.ServiceConnection r6 = r18.getServiceConnection()
            java.lang.String r7 = "User-Agent"
            java.lang.String r8 = "ksoap2-android/2.6.0+"
            r6.setRequestProperty(r7, r8)
            int r7 = r2.version
            r8 = 120(0x78, float:1.68E-43)
            if (r7 == r8) goto L_0x003c
            java.lang.String r7 = "SOAPAction"
            r6.setRequestProperty(r7, r5)
        L_0x003c:
            int r7 = r2.version
            java.lang.String r9 = "Content-Type"
            if (r7 != r8) goto L_0x0048
            java.lang.String r7 = "application/soap+xml;charset=utf-8"
            r6.setRequestProperty(r9, r7)
            goto L_0x004d
        L_0x0048:
            java.lang.String r7 = "text/xml;charset=utf-8"
            r6.setRequestProperty(r9, r7)
        L_0x004d:
            java.lang.String r7 = "Accept-Encoding"
            java.lang.String r8 = "gzip"
            r6.setRequestProperty(r7, r8)
            if (r3 == 0) goto L_0x0071
            r7 = 0
        L_0x0057:
            int r10 = r21.size()
            if (r7 >= r10) goto L_0x0071
            java.lang.Object r10 = r3.get(r7)
            org.ksoap2.HeaderProperty r10 = (org.ksoap2.HeaderProperty) r10
            java.lang.String r11 = r10.getKey()
            java.lang.String r12 = r10.getValue()
            r6.setRequestProperty(r11, r12)
            int r7 = r7 + 1
            goto L_0x0057
        L_0x0071:
            java.lang.String r7 = "POST"
            r6.setRequestMethod(r7)
            r1.sendData(r0, r6, r2)
            r7 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 8192(0x2000, float:1.14794E-41)
            r14 = 0
            r15 = 0
            int r3 = r6.getResponseCode()
            java.util.List r0 = r6.getResponseProperties()     // Catch:{ IOException -> 0x014f }
            r11 = r0
            r0 = 0
            r16 = r15
            r15 = r14
            r14 = r13
            r13 = r0
        L_0x0090:
            int r0 = r11.size()     // Catch:{ IOException -> 0x0147 }
            if (r13 >= r0) goto L_0x00ff
            java.lang.Object r0 = r11.get(r13)     // Catch:{ IOException -> 0x0147 }
            org.ksoap2.HeaderProperty r0 = (org.ksoap2.HeaderProperty) r0     // Catch:{ IOException -> 0x0147 }
            r17 = r0
            java.lang.String r0 = r17.getKey()     // Catch:{ IOException -> 0x0147 }
            if (r0 != 0) goto L_0x00a7
            r19 = r5
            goto L_0x00fa
        L_0x00a7:
            java.lang.String r0 = r17.getKey()     // Catch:{ IOException -> 0x0147 }
            r19 = r5
            java.lang.String r5 = "content-length"
            boolean r0 = r0.equalsIgnoreCase(r5)     // Catch:{ IOException -> 0x0123 }
            if (r0 == 0) goto L_0x00c9
            java.lang.String r0 = r17.getValue()     // Catch:{ IOException -> 0x0123 }
            if (r0 == 0) goto L_0x00c9
            java.lang.String r0 = r17.getValue()     // Catch:{ NumberFormatException -> 0x00c5 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x00c5 }
            r14 = r0
            goto L_0x00c9
        L_0x00c5:
            r0 = move-exception
            r5 = 8192(0x2000, float:1.14794E-41)
            r14 = r5
        L_0x00c9:
            java.lang.String r0 = r17.getKey()     // Catch:{ IOException -> 0x0123 }
            boolean r0 = r0.equalsIgnoreCase(r9)     // Catch:{ IOException -> 0x0123 }
            if (r0 == 0) goto L_0x00e2
            java.lang.String r0 = r17.getValue()     // Catch:{ IOException -> 0x0123 }
            java.lang.String r5 = "xml"
            boolean r0 = r0.contains(r5)     // Catch:{ IOException -> 0x0123 }
            if (r0 == 0) goto L_0x00e2
            r0 = 1
            r16 = r0
        L_0x00e2:
            java.lang.String r0 = r17.getKey()     // Catch:{ IOException -> 0x0123 }
            java.lang.String r5 = "Content-Encoding"
            boolean r0 = r0.equalsIgnoreCase(r5)     // Catch:{ IOException -> 0x0123 }
            if (r0 == 0) goto L_0x00fa
            java.lang.String r0 = r17.getValue()     // Catch:{ IOException -> 0x0123 }
            boolean r0 = r0.equalsIgnoreCase(r8)     // Catch:{ IOException -> 0x0123 }
            if (r0 == 0) goto L_0x00fa
            r0 = 1
            r15 = r0
        L_0x00fa:
            int r13 = r13 + 1
            r5 = r19
            goto L_0x0090
        L_0x00ff:
            r19 = r5
            r0 = 200(0xc8, float:2.8E-43)
            if (r3 == r0) goto L_0x0129
            r0 = 202(0xca, float:2.83E-43)
            if (r3 != r0) goto L_0x010a
            goto L_0x0129
        L_0x010a:
            org.ksoap2.transport.HttpResponseException r0 = new org.ksoap2.transport.HttpResponseException     // Catch:{ IOException -> 0x0123 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0123 }
            r5.<init>()     // Catch:{ IOException -> 0x0123 }
            java.lang.String r8 = "HTTP request failed, HTTP status: "
            java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ IOException -> 0x0123 }
            java.lang.StringBuilder r5 = r5.append(r3)     // Catch:{ IOException -> 0x0123 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0123 }
            r0.<init>((java.lang.String) r5, (int) r3, (java.util.List) r11)     // Catch:{ IOException -> 0x0123 }
            throw r0     // Catch:{ IOException -> 0x0123 }
        L_0x0123:
            r0 = move-exception
            r13 = r14
            r14 = r15
            r15 = r16
            goto L_0x0152
        L_0x0129:
            if (r14 <= 0) goto L_0x0146
            if (r15 == 0) goto L_0x013c
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0123 }
            java.io.InputStream r5 = r6.openInputStream()     // Catch:{ IOException -> 0x0123 }
            r0.<init>(r5, r14)     // Catch:{ IOException -> 0x0123 }
            java.io.InputStream r0 = r1.getUnZippedInputStream(r0)     // Catch:{ IOException -> 0x0123 }
            r10 = r0
            goto L_0x0146
        L_0x013c:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0123 }
            java.io.InputStream r5 = r6.openInputStream()     // Catch:{ IOException -> 0x0123 }
            r0.<init>(r5, r14)     // Catch:{ IOException -> 0x0123 }
            r10 = r0
        L_0x0146:
            goto L_0x0185
        L_0x0147:
            r0 = move-exception
            r19 = r5
            r13 = r14
            r14 = r15
            r15 = r16
            goto L_0x0152
        L_0x014f:
            r0 = move-exception
            r19 = r5
        L_0x0152:
            if (r13 <= 0) goto L_0x016e
            if (r14 == 0) goto L_0x0164
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream
            java.io.InputStream r8 = r6.getErrorStream()
            r5.<init>(r8, r13)
            java.io.InputStream r10 = r1.getUnZippedInputStream(r5)
            goto L_0x016e
        L_0x0164:
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream
            java.io.InputStream r8 = r6.getErrorStream()
            r5.<init>(r8, r13)
            r10 = r5
        L_0x016e:
            boolean r5 = r0 instanceof org.ksoap2.transport.HttpResponseException
            if (r5 == 0) goto L_0x0181
            if (r15 != 0) goto L_0x0181
            boolean r5 = r1.debug
            if (r5 == 0) goto L_0x017d
            if (r10 == 0) goto L_0x017d
            r1.readDebug(r10, r13, r4)
        L_0x017d:
            r6.disconnect()
            throw r0
        L_0x0181:
            r16 = r15
            r15 = r14
            r14 = r13
        L_0x0185:
            boolean r0 = r1.debug
            if (r0 == 0) goto L_0x018d
            java.io.InputStream r10 = r1.readDebug(r10, r14, r4)
        L_0x018d:
            if (r10 == 0) goto L_0x0192
            r1.parseResponse(r2, r10, r11)
        L_0x0192:
            r0 = 0
            r5 = 0
            r6.disconnect()
            r6 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ksoap2.transport.HttpTransportSE.call(java.lang.String, org.ksoap2.SoapEnvelope, java.util.List, java.io.File):java.util.List");
    }

    /* access modifiers changed from: protected */
    public void sendData(byte[] requestData, ServiceConnection connection, SoapEnvelope envelope) throws IOException {
        connection.setRequestProperty("Content-Length", "" + requestData.length);
        connection.setFixedLengthStreamingMode(requestData.length);
        OutputStream os = connection.openOutputStream();
        os.write(requestData, 0, requestData.length);
        os.flush();
        os.close();
    }

    /* access modifiers changed from: protected */
    public void parseResponse(SoapEnvelope envelope, InputStream is, List returnedHeaders) throws XmlPullParserException, IOException {
        parseResponse(envelope, is);
    }

    private InputStream readDebug(InputStream is, int contentLength, File outputFile) throws IOException {
        OutputStream bos;
        if (outputFile != null) {
            bos = new FileOutputStream(outputFile);
        } else {
            bos = new ByteArrayOutputStream(contentLength > 0 ? contentLength : ServiceConnection.DEFAULT_BUFFER_SIZE);
        }
        byte[] buf = new byte[256];
        while (true) {
            int rd = is.read(buf, 0, 256);
            if (rd == -1) {
                break;
            }
            bos.write(buf, 0, rd);
        }
        bos.flush();
        if (bos instanceof ByteArrayOutputStream) {
            buf = ((ByteArrayOutputStream) bos).toByteArray();
        }
        this.responseDump = new String(buf);
        is.close();
        if (outputFile != null) {
            return new FileInputStream(outputFile);
        }
        return new ByteArrayInputStream(buf);
    }

    private InputStream getUnZippedInputStream(InputStream inputStream) throws IOException {
        try {
            return (GZIPInputStream) inputStream;
        } catch (ClassCastException e) {
            return new GZIPInputStream(inputStream);
        }
    }

    public ServiceConnection getServiceConnection() throws IOException {
        return new ServiceConnectionSE(this.proxy, this.url, this.timeout);
    }
}
