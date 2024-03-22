package es.santander.justicia.minisJusticia.expedientes.services;

import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.minisJusticia.common.services.JusticiaSoapService;

public class DetalleMovimientoSoapService extends JusticiaSoapService {
    public DetalleMovimientoSoapService() {
        super(SoapWebServicesEnum.DETAIL_MOVEMENTS, "wsAccessRequestLS");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x022c A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0235 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0242 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x024b A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0258 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0261 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x026e A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0279 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0286 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bb A[SYNTHETIC, Splitter:B:25:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d8 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e4 A[SYNTHETIC, Splitter:B:38:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fa A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0114 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011d A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0128 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0131 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013c A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0145 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0150 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0159 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0164 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0171 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017c A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0185 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0192 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019f A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ac A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b9 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c6 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d3 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01e0 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01ed A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01f8 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0205 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0212 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x021f A[Catch:{ Exception -> 0x0296 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public es.santander.justicia.minisJusticia.dto.MovementItemDTO getDetalleMovimiento(es.santander.justicia.minisJusticia.dto.MovementItemDTO r29, java.lang.String r30, java.lang.String r31) {
        /*
            r28 = this;
            r1 = r29
            java.lang.String r2 = "jusrfirmeza"
            java.lang.String r3 = "jusrfirma"
            java.lang.String r4 = "jusrhare"
            java.lang.String r5 = "jfeccaduc"
            java.lang.String r6 = "jfecautoriza"
            java.lang.String r7 = "jfecfirmeza"
            java.lang.String r8 = "jfecfirma"
            java.lang.String r9 = "jfechare"
            java.lang.String r10 = "jimpnomi"
            java.lang.String r11 = "conc30"
            java.lang.String r12 = "coddocum"
            java.lang.String r13 = "jnors"
            java.lang.String r14 = "genombre"
            java.lang.String r15 = "impsaldo"
            r16 = r2
            java.lang.String r2 = "codExpediente"
            r17 = r3
            java.lang.String r3 = "datosRepresentante"
            r18 = r4
            java.lang.String r4 = "datosExpedienteDestino"
            r19 = r5
            java.lang.String r5 = "Error al formatear la respuesta: "
            r20 = r6
            java.lang.String r6 = "DetalleMovSoapService"
            r21 = r7
            java.lang.String r7 = "jfecconf"
            r22 = 0
            es.santander.justicia.soap.service.login.soap.service.DetailMovements.params.DatosExpedienteDetail r0 = new es.santander.justicia.soap.service.login.soap.service.DetailMovements.params.DatosExpedienteDetail     // Catch:{ Exception -> 0x0080 }
            r23 = r8
            r8 = r30
            r0.<init>(r8)     // Catch:{ Exception -> 0x007a }
            es.santander.justicia.soap.service.login.soap.service.DetailMovements.params.DatosAccesoProfesionalesMovementData r8 = new es.santander.justicia.soap.service.login.soap.service.DetailMovements.params.DatosAccesoProfesionalesMovementData     // Catch:{ Exception -> 0x007a }
            r24 = r9
            r9 = r31
            r8.<init>(r0, r9)     // Catch:{ Exception -> 0x0078 }
            r25 = r0
            es.santander.justicia.soap.service.login.soap.service.DetailMovements.XmlBodyDetailMovements r0 = new es.santander.justicia.soap.service.login.soap.service.DetailMovements.XmlBodyDetailMovements     // Catch:{ Exception -> 0x0078 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x0078 }
            org.ksoap2.serialization.PropertyInfo r26 = new org.ksoap2.serialization.PropertyInfo     // Catch:{ Exception -> 0x0078 }
            r26.<init>()     // Catch:{ Exception -> 0x0078 }
            r27 = r26
            r26 = r8
            java.lang.String r8 = "arg0"
            r9 = r27
            r9.setName(r8)     // Catch:{ Exception -> 0x0078 }
            r9.setValue(r0)     // Catch:{ Exception -> 0x0078 }
            java.lang.Class r8 = r0.getClass()     // Catch:{ Exception -> 0x0078 }
            r9.setType(r8)     // Catch:{ Exception -> 0x0078 }
            r8 = r28
            org.ksoap2.serialization.SoapObject r27 = r8.sendRequest(r9)     // Catch:{ Exception -> 0x0076 }
            r22 = r27
            r8 = r22
            goto L_0x00a1
        L_0x0076:
            r0 = move-exception
            goto L_0x0087
        L_0x0078:
            r0 = move-exception
            goto L_0x0085
        L_0x007a:
            r0 = move-exception
            r8 = r28
            r24 = r9
            goto L_0x0087
        L_0x0080:
            r0 = move-exception
            r23 = r8
            r24 = r9
        L_0x0085:
            r8 = r28
        L_0x0087:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r5)
            java.lang.String r8 = r0.getMessage()
            java.lang.StringBuilder r8 = r9.append(r8)
            java.lang.String r8 = r8.toString()
            android.util.Log.e(r6, r8, r0)
            r8 = r22
        L_0x00a1:
            r0 = 1
            r1.setDetail(r0)     // Catch:{ Exception -> 0x0298 }
            java.lang.String r0 = "datosOperacion"
            java.lang.Object r0 = r8.getProperty(r0)     // Catch:{ Exception -> 0x0298 }
            org.ksoap2.serialization.SoapObject r0 = (org.ksoap2.serialization.SoapObject) r0     // Catch:{ Exception -> 0x0298 }
            java.lang.String r9 = "datosExpediente"
            java.lang.Object r9 = r0.getProperty(r9)     // Catch:{ Exception -> 0x0298 }
            org.ksoap2.serialization.SoapObject r9 = (org.ksoap2.serialization.SoapObject) r9     // Catch:{ Exception -> 0x0298 }
            boolean r25 = r0.hasProperty(r4)     // Catch:{ Exception -> 0x0298 }
            if (r25 == 0) goto L_0x00c7
            java.lang.Object r4 = r0.getProperty(r4)     // Catch:{ Exception -> 0x00c2 }
            org.ksoap2.serialization.SoapObject r4 = (org.ksoap2.serialization.SoapObject) r4     // Catch:{ Exception -> 0x00c2 }
            goto L_0x00c8
        L_0x00c2:
            r0 = move-exception
            r25 = r8
            goto L_0x029b
        L_0x00c7:
            r4 = 0
        L_0x00c8:
            r25 = r8
            java.lang.String r8 = "saldos"
            java.lang.Object r8 = r9.getProperty(r8)     // Catch:{ Exception -> 0x0296 }
            org.ksoap2.serialization.SoapObject r8 = (org.ksoap2.serialization.SoapObject) r8     // Catch:{ Exception -> 0x0296 }
            boolean r26 = r0.hasProperty(r3)     // Catch:{ Exception -> 0x0296 }
            if (r26 == 0) goto L_0x00df
            java.lang.Object r3 = r0.getProperty(r3)     // Catch:{ Exception -> 0x0296 }
            org.ksoap2.serialization.SoapObject r3 = (org.ksoap2.serialization.SoapObject) r3     // Catch:{ Exception -> 0x0296 }
            goto L_0x00e0
        L_0x00df:
            r3 = 0
        L_0x00e0:
            java.lang.String r26 = ""
            if (r4 == 0) goto L_0x00f8
            boolean r27 = r4.hasProperty(r2)     // Catch:{ Exception -> 0x0296 }
            if (r27 == 0) goto L_0x00f3
            java.lang.Object r2 = r4.getProperty(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            goto L_0x00f5
        L_0x00f3:
            r2 = r26
        L_0x00f5:
            r1.setExpedienteDestino(r2)     // Catch:{ Exception -> 0x0296 }
        L_0x00f8:
            if (r3 == 0) goto L_0x010e
            boolean r2 = r3.hasProperty(r14)     // Catch:{ Exception -> 0x0296 }
            if (r2 == 0) goto L_0x0109
            java.lang.Object r2 = r3.getProperty(r14)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            goto L_0x010b
        L_0x0109:
            r2 = r26
        L_0x010b:
            r1.setRepresentante(r2)     // Catch:{ Exception -> 0x0296 }
        L_0x010e:
            boolean r2 = r8.hasProperty(r15)     // Catch:{ Exception -> 0x0296 }
            if (r2 == 0) goto L_0x011d
            java.lang.Object r2 = r8.getProperty(r15)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            goto L_0x011f
        L_0x011d:
            r2 = r26
        L_0x011f:
            r1.setImporteSaldo(r2)     // Catch:{ Exception -> 0x0296 }
            boolean r2 = r0.hasProperty(r13)     // Catch:{ Exception -> 0x0296 }
            if (r2 == 0) goto L_0x0131
            java.lang.Object r2 = r0.getProperty(r13)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            goto L_0x0133
        L_0x0131:
            r2 = r26
        L_0x0133:
            r1.setRepresentado(r2)     // Catch:{ Exception -> 0x0296 }
            boolean r2 = r0.hasProperty(r12)     // Catch:{ Exception -> 0x0296 }
            if (r2 == 0) goto L_0x0145
            java.lang.Object r2 = r0.getProperty(r12)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            goto L_0x0147
        L_0x0145:
            r2 = r26
        L_0x0147:
            r1.setDocumento(r2)     // Catch:{ Exception -> 0x0296 }
            boolean r2 = r0.hasProperty(r11)     // Catch:{ Exception -> 0x0296 }
            if (r2 == 0) goto L_0x0159
            java.lang.Object r2 = r0.getProperty(r11)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            goto L_0x015b
        L_0x0159:
            r2 = r26
        L_0x015b:
            r1.setConcepto(r2)     // Catch:{ Exception -> 0x0296 }
            boolean r2 = r0.hasProperty(r7)     // Catch:{ Exception -> 0x0296 }
            if (r2 == 0) goto L_0x0171
            java.lang.Object r2 = r0.getProperty(r7)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = es.santander.justicia.utils.DateUtils.formatDate(r2)     // Catch:{ Exception -> 0x0296 }
            goto L_0x0173
        L_0x0171:
            r2 = r26
        L_0x0173:
            r1.setFecha(r2)     // Catch:{ Exception -> 0x0296 }
            boolean r2 = r0.hasProperty(r10)     // Catch:{ Exception -> 0x0296 }
            if (r2 == 0) goto L_0x0185
            java.lang.Object r2 = r0.getProperty(r10)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            goto L_0x0187
        L_0x0185:
            r2 = r26
        L_0x0187:
            r1.setImporteDetalle(r2)     // Catch:{ Exception -> 0x0296 }
            r2 = r24
            boolean r10 = r0.hasProperty(r2)     // Catch:{ Exception -> 0x0296 }
            if (r10 == 0) goto L_0x019f
            java.lang.Object r2 = r0.getProperty(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = es.santander.justicia.utils.DateUtils.formatDate(r2)     // Catch:{ Exception -> 0x0296 }
            goto L_0x01a1
        L_0x019f:
            r2 = r26
        L_0x01a1:
            r1.setJfechare(r2)     // Catch:{ Exception -> 0x0296 }
            r2 = r23
            boolean r10 = r0.hasProperty(r2)     // Catch:{ Exception -> 0x0296 }
            if (r10 == 0) goto L_0x01b9
            java.lang.Object r2 = r0.getProperty(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = es.santander.justicia.utils.DateUtils.formatDate(r2)     // Catch:{ Exception -> 0x0296 }
            goto L_0x01bb
        L_0x01b9:
            r2 = r26
        L_0x01bb:
            r1.setjFechaFirma(r2)     // Catch:{ Exception -> 0x0296 }
            r2 = r21
            boolean r10 = r0.hasProperty(r2)     // Catch:{ Exception -> 0x0296 }
            if (r10 == 0) goto L_0x01d3
            java.lang.Object r2 = r0.getProperty(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = es.santander.justicia.utils.DateUtils.formatDate(r2)     // Catch:{ Exception -> 0x0296 }
            goto L_0x01d5
        L_0x01d3:
            r2 = r26
        L_0x01d5:
            r1.setjFechaFirmeza(r2)     // Catch:{ Exception -> 0x0296 }
            r2 = r20
            boolean r10 = r0.hasProperty(r2)     // Catch:{ Exception -> 0x0296 }
            if (r10 == 0) goto L_0x01ed
            java.lang.Object r2 = r0.getProperty(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = es.santander.justicia.utils.DateUtils.formatDate(r2)     // Catch:{ Exception -> 0x0296 }
            goto L_0x01ef
        L_0x01ed:
            r2 = r26
        L_0x01ef:
            r1.setjFechaAutorizacion(r2)     // Catch:{ Exception -> 0x0296 }
            boolean r2 = r0.hasProperty(r7)     // Catch:{ Exception -> 0x0296 }
            if (r2 == 0) goto L_0x0205
            java.lang.Object r2 = r0.getProperty(r7)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = es.santander.justicia.utils.DateUtils.formatDate(r2)     // Catch:{ Exception -> 0x0296 }
            goto L_0x0207
        L_0x0205:
            r2 = r26
        L_0x0207:
            r1.setjFechaConfirmacion(r2)     // Catch:{ Exception -> 0x0296 }
            r2 = r19
            boolean r7 = r0.hasProperty(r2)     // Catch:{ Exception -> 0x0296 }
            if (r7 == 0) goto L_0x021f
            java.lang.Object r2 = r0.getProperty(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = es.santander.justicia.utils.DateUtils.formatDate(r2)     // Catch:{ Exception -> 0x0296 }
            goto L_0x0221
        L_0x021f:
            r2 = r26
        L_0x0221:
            r1.setjFechaCaducidad(r2)     // Catch:{ Exception -> 0x0296 }
            r2 = r18
            boolean r7 = r0.hasProperty(r2)     // Catch:{ Exception -> 0x0296 }
            if (r7 == 0) goto L_0x0235
            java.lang.Object r2 = r0.getProperty(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            goto L_0x0237
        L_0x0235:
            r2 = r26
        L_0x0237:
            r1.setjResponsableAlta(r2)     // Catch:{ Exception -> 0x0296 }
            r2 = r17
            boolean r7 = r0.hasProperty(r2)     // Catch:{ Exception -> 0x0296 }
            if (r7 == 0) goto L_0x024b
            java.lang.Object r2 = r0.getProperty(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            goto L_0x024d
        L_0x024b:
            r2 = r26
        L_0x024d:
            r1.setjResponsableFirma(r2)     // Catch:{ Exception -> 0x0296 }
            r2 = r16
            boolean r7 = r0.hasProperty(r2)     // Catch:{ Exception -> 0x0296 }
            if (r7 == 0) goto L_0x0261
            java.lang.Object r2 = r0.getProperty(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            goto L_0x0263
        L_0x0261:
            r2 = r26
        L_0x0263:
            r1.setjResponsableFirmeza(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = "jusrautoriza"
            boolean r2 = r0.hasProperty(r2)     // Catch:{ Exception -> 0x0296 }
            if (r2 == 0) goto L_0x0279
            java.lang.String r2 = "jusrautoriza"
            java.lang.Object r2 = r0.getProperty(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0296 }
            goto L_0x027b
        L_0x0279:
            r2 = r26
        L_0x027b:
            r1.setjResponsableAutorizacion(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r2 = "jusrconf"
            boolean r2 = r0.hasProperty(r2)     // Catch:{ Exception -> 0x0296 }
            if (r2 == 0) goto L_0x0290
            java.lang.String r2 = "jusrconf"
            java.lang.Object r2 = r0.getProperty(r2)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r26 = r2.toString()     // Catch:{ Exception -> 0x0296 }
        L_0x0290:
            r2 = r26
            r1.setjResponsableConfirmacion(r2)     // Catch:{ Exception -> 0x0296 }
            return r1
        L_0x0296:
            r0 = move-exception
            goto L_0x029b
        L_0x0298:
            r0 = move-exception
            r25 = r8
        L_0x029b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r3 = r0.getMessage()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r6, r2, r0)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.expedientes.services.DetalleMovimientoSoapService.getDetalleMovimiento(es.santander.justicia.minisJusticia.dto.MovementItemDTO, java.lang.String, java.lang.String):es.santander.justicia.minisJusticia.dto.MovementItemDTO");
    }
}
