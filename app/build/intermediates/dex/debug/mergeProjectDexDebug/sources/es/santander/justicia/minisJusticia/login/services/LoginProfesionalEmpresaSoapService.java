package es.santander.justicia.minisJusticia.login.services;

public class LoginProfesionalEmpresaSoapService {
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x029c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String login(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31) {
        /*
            r27 = this;
            r1 = r29
            java.lang.String r2 = "JusticiaSoapService"
            r3 = 0
            es.santander.justicia.soap.service.login.RealizarLoginLA r0 = new es.santander.justicia.soap.service.login.RealizarLoginLA
            r0.<init>()
            r4 = r0
            es.santander.justicia.soap.service.login.DocumentoPersonaRealizarLoginParams r0 = new es.santander.justicia.soap.service.login.DocumentoPersonaRealizarLoginParams
            r5 = r28
            r0.<init>(r5, r1)
            r6 = r0
            es.santander.justicia.soap.service.login.EntradaRealizarLoginParams r0 = new es.santander.justicia.soap.service.login.EntradaRealizarLoginParams
            r0.<init>()
            r7 = r0
            r8 = r30
            r7.setAlias(r8)
            r9 = r31
            r7.setPassword(r9)
            r7.setDocumentoPersona(r6)
            r4.setEntrada(r7)
            es.santander.justicia.utils.Constants$ConstantesRealizarLogonLA r0 = es.santander.justicia.utils.Constants.ConstantesRealizarLogonLA.NAMESPACE
            java.lang.String r10 = r0.valor()
            es.santander.justicia.minisJusticia.common.MainApplication r0 = es.santander.justicia.minisJusticia.common.MainApplication.getAppContext()
            java.lang.String r0 = r0.getEnvironment()
            java.lang.String r11 = "wsLoginLA"
            es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO r11 = es.santander.justicia.minisJusticia.models.WebServiceModel.getWebServiceSettings(r11, r0)
            es.santander.justicia.soap.service.login.DocumentoPersonaRealizarLoginParams r0 = new es.santander.justicia.soap.service.login.DocumentoPersonaRealizarLoginParams
            es.santander.justicia.soap.service.login.EntradaRealizarLoginParams r12 = r4.getEntrada()
            es.santander.justicia.soap.service.login.DocumentoPersonaRealizarLoginParams r12 = r12.getDocumentoPersona()
            java.lang.String r12 = r12.getTIPO_DOCUMENTO_OFIC()
            es.santander.justicia.soap.service.login.EntradaRealizarLoginParams r13 = r4.getEntrada()
            es.santander.justicia.soap.service.login.DocumentoPersonaRealizarLoginParams r13 = r13.getDocumentoPersona()
            java.lang.String r13 = r13.getCODIGO_DE_DOCUMENTO()
            r0.<init>(r12, r13)
            r12 = r0
            es.santander.justicia.soap.service.login.EntradaRealizarLoginParams r0 = new es.santander.justicia.soap.service.login.EntradaRealizarLoginParams
            es.santander.justicia.soap.service.login.EntradaRealizarLoginParams r13 = r4.getEntrada()
            java.lang.String r13 = r13.getAlias()
            es.santander.justicia.soap.service.login.EntradaRealizarLoginParams r14 = r4.getEntrada()
            java.lang.String r14 = r14.getPassword()
            es.santander.justicia.utils.Constants$ServiciosComerciales r15 = es.santander.justicia.utils.Constants.ServiciosComerciales.DEFAULT
            java.lang.String r15 = r15.valor()
            r0.<init>(r13, r14, r15, r12)
            r13 = r0
            es.santander.justicia.soap.service.login.DatosConexionRealziarLoginParams r0 = new es.santander.justicia.soap.service.login.DatosConexionRealziarLoginParams
            java.lang.String r14 = "EMP"
            java.lang.String r15 = "0049"
            r0.<init>(r14, r15)
            r14 = r0
            es.santander.justicia.soap.service.login.IdiomaRealizarLogonPrams r0 = new es.santander.justicia.soap.service.login.IdiomaRealizarLogonPrams
            java.lang.String r15 = "es"
            r16 = r3
            java.lang.String r3 = "ES"
            r0.<init>(r15, r3)
            r3 = r0
            es.santander.justicia.soap.service.login.DatosCabeceraRealizarLogonParams r0 = new es.santander.justicia.soap.service.login.DatosCabeceraRealizarLogonParams
            r0.<init>(r3)
            r15 = r0
            org.ksoap2.serialization.SoapObject r0 = new org.ksoap2.serialization.SoapObject
            es.santander.justicia.utils.Constants$ConstantesRealizarLogonLA r17 = es.santander.justicia.utils.Constants.ConstantesRealizarLogonLA.NOMBRE_SERVICIO
            r18 = r3
            java.lang.String r3 = r17.valor()
            r0.<init>(r10, r3)
            r3 = r0
            java.lang.String r0 = "facade"
            r17 = r4
            java.lang.String r4 = "ACEMPMOVContratos"
            r3.addAttribute(r0, r4)
            org.ksoap2.serialization.PropertyInfo r0 = new org.ksoap2.serialization.PropertyInfo
            r0.<init>()
            r4 = r0
            java.lang.String r0 = "entrada"
            r4.setName(r0)
            r4.setValue(r13)
            java.lang.Class r0 = r13.getClass()
            r4.setType(r0)
            r3.addProperty(r4)
            org.ksoap2.serialization.PropertyInfo r0 = new org.ksoap2.serialization.PropertyInfo
            r0.<init>()
            r19 = r0
            java.lang.String r0 = "datosConexion"
            r20 = r4
            r4 = r19
            r4.setName(r0)
            r4.setValue(r14)
            java.lang.Class r0 = r14.getClass()
            r4.setType(r0)
            r3.addProperty(r4)
            org.ksoap2.serialization.PropertyInfo r0 = new org.ksoap2.serialization.PropertyInfo
            r0.<init>()
            r19 = r0
            java.lang.String r0 = "datosCabecera"
            r21 = r4
            r4 = r19
            r4.setName(r0)
            r4.setValue(r15)
            java.lang.Class r0 = r15.getClass()
            r4.setType(r0)
            r3.addProperty(r4)
            org.ksoap2.serialization.SoapSerializationEnvelope r0 = new org.ksoap2.serialization.SoapSerializationEnvelope
            r4 = 110(0x6e, float:1.54E-43)
            r0.<init>(r4)
            r4 = r0
            r4.setOutputSoapObject(r3)
            org.ksoap2.serialization.MarshalFloat r0 = new org.ksoap2.serialization.MarshalFloat
            r0.<init>()
            r22 = r0
            r23 = r3
            r3 = r22
            r3.register(r4)
            r0 = 1
            r4.dotNet = r0
            r4.implicitTypes = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r10)
            es.santander.justicia.utils.Constants$ConstantesRealizarLogonLA r22 = es.santander.justicia.utils.Constants.ConstantesRealizarLogonLA.NOMBRE_SERVICIO
            r24 = r3
            java.lang.String r3 = r22.valor()
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = r11.getUrl()     // Catch:{ SoapFault -> 0x0263, XmlPullParserException -> 0x0241, HttpResponseException -> 0x021f, IOException -> 0x01fd, Exception -> 0x01da }
            java.lang.String r5 = r11.getUrlCertificate()     // Catch:{ SoapFault -> 0x0263, XmlPullParserException -> 0x0241, HttpResponseException -> 0x021f, IOException -> 0x01fd, Exception -> 0x01da }
            r22 = r6
            int r6 = r11.getConnectionTimeout()     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            es.santander.justicia.utils.NetworkUtils.callSoapService(r0, r5, r3, r4, r6)     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            java.lang.Object r0 = r4.getResponse()     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            org.ksoap2.serialization.SoapObject r0 = (org.ksoap2.serialization.SoapObject) r0     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            es.santander.justicia.soap.service.login.RealizarLoginResponse r5 = new es.santander.justicia.soap.service.login.RealizarLoginResponse     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            r5.<init>(r0)     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            es.santander.justicia.utils.Constants$ServiciosComerciales r6 = es.santander.justicia.utils.Constants.ServiciosComerciales.JUSTICIA     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            boolean r6 = r5.tieneAccesoAlServicioComercial(r6)     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            if (r6 == 0) goto L_0x019b
            es.santander.justicia.minisJusticia.login.manager.LoginManager r6 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            r25 = r0
            java.lang.String r0 = r5.getToken()     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            r6.setTokenConTemp(r0)     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            es.santander.justicia.minisJusticia.login.manager.LoginManager r0 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            r6.<init>()     // Catch:{ SoapFault -> 0x01d5, XmlPullParserException -> 0x01d0, HttpResponseException -> 0x01cc, IOException -> 0x01c8, Exception -> 0x01c4 }
            r26 = r3
            java.lang.String r3 = r5.getTipoPersona()     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            java.lang.String r6 = "-"
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            java.lang.String r6 = r5.getCodigoPersona()     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            java.lang.String r3 = r3.toString()     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            r0.setCodClienteTemp(r3)     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            es.santander.justicia.minisJusticia.login.manager.LoginManager r0 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            java.lang.String r3 = r5.getNombreTitular()     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            r0.setNombreUsuario(r3)     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            r3 = r16
            goto L_0x0262
        L_0x019b:
            r25 = r0
            r26 = r3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            r0.<init>()     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            java.lang.String r3 = "El usuario no tiene acceso al servicio de justicia, no "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            es.santander.justicia.utils.Constants$ServiciosComerciales r3 = es.santander.justicia.utils.Constants.ServiciosComerciales.JUSTICIA     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            java.lang.String r0 = r0.toString()     // Catch:{ SoapFault -> 0x01c1, XmlPullParserException -> 0x01be, HttpResponseException -> 0x01bb, IOException -> 0x01b9, Exception -> 0x01b7 }
            r3 = r0
            goto L_0x0262
        L_0x01b7:
            r0 = move-exception
            goto L_0x01df
        L_0x01b9:
            r0 = move-exception
            goto L_0x0202
        L_0x01bb:
            r0 = move-exception
            goto L_0x0224
        L_0x01be:
            r0 = move-exception
            goto L_0x0246
        L_0x01c1:
            r0 = move-exception
            goto L_0x0268
        L_0x01c4:
            r0 = move-exception
            r26 = r3
            goto L_0x01df
        L_0x01c8:
            r0 = move-exception
            r26 = r3
            goto L_0x0202
        L_0x01cc:
            r0 = move-exception
            r26 = r3
            goto L_0x0224
        L_0x01d0:
            r0 = move-exception
            r26 = r3
            goto L_0x0246
        L_0x01d5:
            r0 = move-exception
            r26 = r3
            goto L_0x0268
        L_0x01da:
            r0 = move-exception
            r26 = r3
            r22 = r6
        L_0x01df:
            java.lang.String r3 = "Exception"
            android.util.Log.e(r2, r3, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Throwable : "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r2.toString()
            goto L_0x0294
        L_0x01fd:
            r0 = move-exception
            r26 = r3
            r22 = r6
        L_0x0202:
            java.lang.String r3 = "IOException"
            android.util.Log.e(r2, r3, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "IOException : "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r2.toString()
            goto L_0x0262
        L_0x021f:
            r0 = move-exception
            r26 = r3
            r22 = r6
        L_0x0224:
            java.lang.String r3 = "HttpResponseException"
            android.util.Log.e(r2, r3, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "HttpResponseException : "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r2.toString()
            goto L_0x0262
        L_0x0241:
            r0 = move-exception
            r26 = r3
            r22 = r6
        L_0x0246:
            java.lang.String r3 = "XmlPullParserException"
            android.util.Log.e(r2, r3, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "XmlPullParserException : "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r2.toString()
        L_0x0262:
            goto L_0x0294
        L_0x0263:
            r0 = move-exception
            r26 = r3
            r22 = r6
        L_0x0268:
            java.lang.String r2 = "soapFault"
            es.santander.justicia.soap.service.login.ErrorResponseLoginProfesionalesEmpresa r3 = new es.santander.justicia.soap.service.login.ErrorResponseLoginProfesionalesEmpresa
            r3.<init>(r0)
            java.lang.String r5 = r3.getErrorDesc()
            if (r5 == 0) goto L_0x0292
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "ERROR_PROFESIONAL_EMPRESA"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = r3.getErrorDesc()
            java.lang.String r6 = r6.trim()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r2 = r5.toString()
            r3 = r2
            goto L_0x0262
        L_0x0292:
            r3 = r2
            goto L_0x0262
        L_0x0294:
            java.lang.String r0 = "LoginProfEmpSoapService"
            if (r3 == 0) goto L_0x029c
            android.util.Log.i(r0, r3)
            goto L_0x02b2
        L_0x029c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Login OK: "
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r0, r2)
        L_0x02b2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.login.services.LoginProfesionalEmpresaSoapService.login(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
