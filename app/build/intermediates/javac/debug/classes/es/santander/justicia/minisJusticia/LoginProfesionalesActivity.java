package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.text.InputFilter.LengthFilter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.1;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.10;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.11;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.12;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.13;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.14;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.15;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.16;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.17;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.18;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.2;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.3;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.4;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.5;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.6;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.7;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.8;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity.9;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.expedientes.task.LoginExpedientesTask;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.login.tasks.LoginProfesionalesTask;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.models.requests.contratos.ContratoEntradaDetail;
import es.santander.justicia.minisJusticia.models.requests.loginUnico.LoginUnicoEntradaDetail;
import es.santander.justicia.minisJusticia.models.requests.obtenerDatosLoginLA.ObtenerDatosLoginEntradaDetail;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratoDetail;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratosMedhodResultDetail;
import es.santander.justicia.minisJusticia.models.responses.loginunico.LoginUnicoMethodResultDetail;
import es.santander.justicia.minisJusticia.tasks.MergeloginUnicoTask;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.MinJusticeDBHelper;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import net.sqlcipher.database.SQLiteDatabase;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class LoginProfesionalesActivity extends MainActivity implements OnRecyclerClickListener, OnClickListener, ActivityCallBack {
   private Activity activity;
   private ProgressDialog progressDialog;
   protected Spinner spnDocumentTypes;
   protected Spinner spnPrivateType;
   protected EditText etDocumentNumber;
   protected EditText etCode;
   protected EditText etPass;
   private Button btnAcceder;
   public String typeDocu;
   private ImageButton backRow;
   protected RelativeLayout firstSpinnerContainer;
   protected RelativeLayout secondSpinnerContainer;
   protected ConstraintLayout radioButtonsContainer;
   protected LinearLayout spinnerContainer;
   protected LinearLayout rememberMeContainer;
   protected LinearLayout linealAreNotYouLink;
   protected RadioButton rbParticular;
   protected RadioButton rbCompany;
   private CheckBox checkRememberMe;
   private TextView areNotYou;
   private boolean companyMode = false;
   private boolean wasCompanyModeChecked = false;
   private boolean privateDocumentSelected = false;
   public String lastValueDocument;
   public String lastVaueCode;
   public String lastValuePass;
   private ArrayList<SpinnerValuesDTO> documentTypes;
   private ArrayAdapter<SpinnerValuesDTO> documentTypesAdapter;
   private boolean rememberMeChecked = false;
   private TextView tv_saludo;
   private TextView tv_problemas_entrar;
   private Boolean FlagAyuda = true;
   private TextView tvUserName;
   private int posDefaultSpDocument = 0;
   private int posDefaultSpPrivate = 0;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558722);
      Map<String, String> data = new HashMap();
      data.put("perfil_app", "PROF");
      TealiumHelper.trackView("/login", data);
      this.activity = this;
      RelativeLayout parentLayout = (RelativeLayout)this.findViewById(2131362565);
      this.spnDocumentTypes = (Spinner)this.findViewById(2131362730);
      this.spnPrivateType = (Spinner)this.findViewById(2131362731);
      this.etDocumentNumber = (EditText)this.findViewById(2131362162);
      this.etCode = (EditText)this.findViewById(2131362161);
      this.etPass = (EditText)this.findViewById(2131362163);
      this.btnAcceder = (Button)this.findViewById(2131361945);
      this.backRow = (ImageButton)this.findViewById(2131362337);
      this.firstSpinnerContainer = (RelativeLayout)this.findViewById(2131362009);
      this.secondSpinnerContainer = (RelativeLayout)this.findViewById(2131362018);
      this.radioButtonsContainer = (ConstraintLayout)this.findViewById(2131362014);
      this.spinnerContainer = (LinearLayout)this.findViewById(2131362726);
      this.rememberMeContainer = (LinearLayout)this.findViewById(2131362015);
      this.linealAreNotYouLink = (LinearLayout)this.findViewById(2131362392);
      this.etPass.setCustomSelectionActionModeCallback(new 1(this));
      this.etDocumentNumber.setCustomSelectionActionModeCallback(new 2(this));
      this.etCode.setCustomSelectionActionModeCallback(new 3(this));
      this.rbParticular = (RadioButton)this.findViewById(2131362617);
      this.rbCompany = (RadioButton)this.findViewById(2131362616);
      this.tv_saludo = (TextView)this.findViewById(2131363018);
      this.tvUserName = (TextView)this.findViewById(2131363085);
      this.areNotYou = (TextView)this.findViewById(2131363001);
      this.tv_problemas_entrar = (TextView)this.findViewById(2131362026);
      this.checkRememberMe = (CheckBox)this.findViewById(2131361983);
      this.btnAcceder.setOnClickListener(this);
      this.btnAcceder.setEnabled(false);
      Paint p = new Paint();
      p.setColor(ContextCompat.getColor(this.checkRememberMe.getContext(), 2131099876));
      this.checkRememberMe.setPaintFlags(p.getColor());
      this.checkRememberMe.setPaintFlags(8);
      this.tv_problemas_entrar.setOnClickListener(new 4(this));
      this.spnPrivateType.setOnItemSelectedListener(new 5(this));
      this.spnDocumentTypes.setOnItemSelectedListener(new 6(this));
      this.backRow.setOnClickListener(new 7(this));
      this.rbParticular.setOnClickListener(new 8(this));
      this.rbCompany.setOnClickListener(new 9(this));
      this.checkRememberMe.setOnCheckedChangeListener(new 10(this));
      this.etDocumentNumber.addTextChangedListener(new 11(this));
      this.etCode.addTextChangedListener(new 12(this));
      this.etPass.addTextChangedListener(new 13(this));
      parentLayout.setOnTouchListener(new 14(this));
      this.areNotYou.setOnClickListener(new 15(this));
   }

   protected void onResume() {
      super.onResume();
      PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(this.getBaseContext(), "loginPreferencesCrypt");
      this.rememberMeChecked = preferencesHelper.getBoolean("rememberMe", false);
      if (this.rememberMeChecked) {
         this.tvUserName.setVisibility(0);
         this.tvUserName.setText(preferencesHelper.getString("userName"));
         this.wasCompanyModeChecked = preferencesHelper.getBoolean("companyMode", false);
         this.changeToRememberMeScreenMode();
         if (this.wasCompanyModeChecked) {
            this.changeToCompanyMode();
         } else {
            this.changeToPrivateMode();
         }

         this.reestablishValues();
      } else {
         this.tvUserName.setVisibility(8);
         if (this.companyMode) {
            this.changeToCompanyMode();
         } else {
            this.changeToPrivateMode();
         }
      }

   }

   public void onClick(View v) {
      if (this.btnAcceder.getId() == v.getId()) {
         SpinnerValuesDTO spnDTO = (SpinnerValuesDTO)this.spnDocumentTypes.getSelectedItem();
         if (spnDTO != null) {
            this.typeDocu = spnDTO.getCode();
         }

         if (this.companyMode && this.isFormValid()) {
            this.saveCredentials();
            this.makeLoginUnico(this.etCode.getText().toString(), this.etPass.getText().toString());
         } else if (!this.companyMode && this.isFormValid()) {
            this.saveCredentials();
            int privateType = this.spnPrivateType.getSelectedItemPosition();
            switch(privateType) {
            case 0:
               this.progressDialog = ProgressDialog.show(this, "", this.getString(2131886730));
               LoginProfesionalesTask loginProfesionalesTask = new LoginProfesionalesTask(this);
               loginProfesionalesTask.execute(new Object[]{this.typeDocu, this.etDocumentNumber.getText().toString().toUpperCase(), null, this.etPass.getText().toString().toUpperCase()});
               break;
            case 1:
               this.progressDialog = ProgressDialog.show(this, "", this.getString(2131886730));
               LoginProfesionalesTask loginProfesionalesAliasTask = new LoginProfesionalesTask(this);
               loginProfesionalesAliasTask.execute(new Object[]{null, this.etDocumentNumber.getText().toString().toUpperCase(), null, this.etPass.getText().toString().toUpperCase()});
            }
         }
      }

   }

   private void makeLoginUnico(String user, String pass) {
      PreferencesHelper.newInstance(this).setString("preference_alias", user);
      ConnectionBuilder.loginUnico(new LoginUnicoEntradaDetail(user, pass), this).enqueue(new 16(this, this));
   }

   private void handleError(String error) {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      try {
         DocumentBuilder builder = factory.newDocumentBuilder();
         Document document = builder.parse(new InputSource(new StringReader(error)));

         try {
            String text = document.getDocumentElement().getChildNodes().item(1).getChildNodes().item(0).getChildNodes().item(3).getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(0).getTextContent();
            Log.d("Silos", text);
            Toast.makeText(this, text, 1).show();
         } catch (NullPointerException var6) {
            Toast.makeText(this, this.getString(2131886346), 1).show();
         }
      } catch (SAXException var7) {
         Log.e("RetrofitCallbackInterf", "SAXException", var7);
      } catch (ParserConfigurationException var8) {
         Log.e("RetrofitCallbackInterf", "ParserConfigurationException", var8);
      } catch (IOException var9) {
         Log.e("RetrofitCallbackInterf", "IOException", var9);
      }

   }

   private void handleLoginResponse(LoginUnicoMethodResultDetail loginUnicoMethodResult) {
      if (loginUnicoMethodResult.getEstadoUsuario() == null) {
         if (loginUnicoMethodResult.getIndCaputarClave() != null && loginUnicoMethodResult.getIndCaputarClave().equals("S")) {
            CommonUtils.showAlertMessage(this, this.getString(2131886355));
         }

         if (loginUnicoMethodResult.getAliasDuplicado() != null && loginUnicoMethodResult.getAliasDuplicado().equals("S")) {
            CommonUtils.showAlertMessage(this, this.getString(2131886355));
         }

         if (loginUnicoMethodResult.getIndAltaFirma() != null && loginUnicoMethodResult.getIndAltaFirma().equals("S")) {
            CommonUtils.showAlertMessage(this, this.getString(2131886355));
         }
      } else {
         String var2 = loginUnicoMethodResult.getEstadoUsuario();
         byte var3 = -1;
         switch(var2.hashCode()) {
         case 1689:
            if (var2.equals("4M")) {
               var3 = 2;
            }
            break;
         case 1692:
            if (var2.equals("4P")) {
               var3 = 1;
            }
            break;
         case 2562:
            if (var2.equals("PR")) {
               var3 = 0;
            }
         }

         switch(var3) {
         case 0:
         case 1:
         case 2:
            break;
         default:
            if (loginUnicoMethodResult.getUsuarioInternoEmp() != null) {
               PreferencesHelper.newInstance(this).setBoolean("extra_show_contracts", false);
               MergeloginUnicoTask mergeloginUnicoTask = new MergeloginUnicoTask(this, PreferencesHelper.newInstance(this).getString("preference_token_sso"));
               mergeloginUnicoTask.execute(new Object[0]);
            } else if (this.popoularFieldsAlright(loginUnicoMethodResult)) {
               this.getContratos(loginUnicoMethodResult.getLoginUnicoInfoDetail().getToken(), loginUnicoMethodResult.getIndApoderadoDelegado(), "L");
            } else {
               CommonUtils.showAlertMessage(this, this.getString(2131886355));
            }
         }
      }

   }

   private void getContratos(String token, String apoderado, String listaReposicion) {
      PreferencesHelper.newInstance(this).setString("preference_apoderado", apoderado);
      ContratoEntradaDetail contratoEntradaDetail = new ContratoEntradaDetail();
      contratoEntradaDetail.setToken(token);
      contratoEntradaDetail.setIndApoderadoDelegado(apoderado);
      contratoEntradaDetail.setIndListaRepos(listaReposicion);
      ConnectionBuilder.getContratosParaguas(contratoEntradaDetail, this).enqueue(new 17(this, this));
   }

   private void hadleContractsResponse(ContratosMedhodResultDetail contratosMedhodResultDetail) {
      PreferencesHelper.newInstance(this).setString("preference_token_login_unico", contratosMedhodResultDetail.getInfoDetail().getToken());
      if (contratosMedhodResultDetail.getContratoDetails().size() > 1) {
         PreferencesHelper.newInstance(this).setBoolean("extra_show_contracts", true);
         Intent intent = new Intent(this, ActivityContratos.class);
         intent.putExtra("extra_contratcs_list", contratosMedhodResultDetail.getContratoDetails());
         intent.putExtra("extra_user_raf", contratosMedhodResultDetail.getDatosRepo().getUsuarioRacfRepos());
         this.startActivity(intent);
         this.finish();
      } else {
         this.obtenerDatosLogin(contratosMedhodResultDetail.getDatosRepo().getUsuarioRacfRepos(), (ContratoDetail)contratosMedhodResultDetail.getContratoDetails().get(0));
      }

   }

   private void obtenerDatosLogin(String usuarioRaf, ContratoDetail contratoDetail) {
      ConnectionBuilder.obtenerDatosLogin(new ObtenerDatosLoginEntradaDetail(contratoDetail.getAlias(), PreferencesHelper.newInstance(this).getString("preference_token_login_unico"), usuarioRaf, ""), this).enqueue(new 18(this, this));
   }

   private boolean popoularFieldsAlright(LoginUnicoMethodResultDetail loginUnicoMethodResult) {
      return loginUnicoMethodResult.getAliasDuplicado().equals("N") && loginUnicoMethodResult.getIndCaputarClave().equals("N") && loginUnicoMethodResult.getIndAltaFirma().equals("N");
   }

   private boolean isFormValid() {
      if (this.companyMode) {
         if (this.etCode.getText().toString().trim().isEmpty()) {
            this.etCode.setError(this.getString(2131886802));
            return false;
         } else if (!this.validField(this.etCode.getText().toString(), true, false, 6, 16)) {
            this.etCode.setError(this.getString(2131886426));
            return false;
         } else if (this.etPass.getText().toString().trim().isEmpty()) {
            this.etPass.setError(this.getString(2131886802));
            return false;
         } else if (!this.validField(this.etPass.getText().toString(), true, true, 5, 8)) {
            this.etPass.setError(this.getString(2131886426));
            return false;
         } else {
            return true;
         }
      } else {
         if (this.privateDocumentSelected) {
            String documentType = ((SpinnerValuesDTO)this.spnDocumentTypes.getSelectedItem()).getCode();
            byte var3 = -1;
            switch(documentType.hashCode()) {
            case 67:
               if (documentType.equals("C")) {
                  var3 = 2;
               }
               break;
            case 78:
               if (documentType.equals("N")) {
                  var3 = 1;
               }
               break;
            case 80:
               if (documentType.equals("P")) {
                  var3 = 3;
               }
               break;
            case 83:
               if (documentType.equals("S")) {
                  var3 = 0;
               }
            }

            switch(var3) {
            case 0:
            case 1:
               if (!this.validField(this.etDocumentNumber.getText().toString(), true, false, 1, 9)) {
                  this.etDocumentNumber.setError(this.getString(2131886426));
                  return false;
               }
               break;
            case 2:
            case 3:
               if (!this.validField(this.etDocumentNumber.getText().toString(), true, false, 1, 14)) {
                  this.etDocumentNumber.setError(this.getString(2131886426));
                  return false;
               }
            }
         } else {
            if (this.etDocumentNumber.getText().toString().trim().isEmpty()) {
               this.etDocumentNumber.setError(this.getString(2131886802));
               return false;
            }

            if (!this.validField(this.etDocumentNumber.getText().toString(), true, false, 1, 20)) {
               this.etDocumentNumber.setError(this.getString(2131886426));
               return false;
            }
         }

         if (this.etPass.getText().toString().trim().isEmpty()) {
            this.etPass.setError(this.getString(2131886802));
            return false;
         } else if (!this.validField(this.etPass.getText().toString(), false, false, 4, 8)) {
            this.etPass.setError(this.getString(2131886426));
            return false;
         } else {
            return true;
         }
      }
   }

   private boolean validField(String text, boolean isAlphanumeric, boolean allCaps, int min, int max) {
      return true;
   }

   public int compararFechas(String d1, String d2) {
      String[] dd1 = d1.split("_");
      String[] dd2 = d2.split("_");
      if (Integer.parseInt(dd1[1]) > Integer.parseInt(dd2[1])) {
         return 1;
      } else if (Integer.parseInt(dd1[1]) < Integer.parseInt(dd2[1])) {
         return -1;
      } else if (Integer.parseInt(dd1[0]) > Integer.parseInt(dd2[0])) {
         return 1;
      } else {
         return Integer.parseInt(dd1[0]) < Integer.parseInt(dd2[0]) ? -1 : 0;
      }
   }

   private void setVideo(VideoView videoView) {
      Calendar calendar = Calendar.getInstance();
      int mes = calendar.get(2) + 1;
      int dia = calendar.get(5);
      int hora = calendar.get(11);
      MinJusticeDBHelper.getInstance();
      SQLiteDatabase db = MinJusticeDBHelper.getReadableDatabase();
      Map mapaHorarios = KeyValueModel.getInstance().getValueMap(db, "horarioSaludo.");
      Map mapaEstaciones = KeyValueModel.getInstance().getValueMap(db, "estacionesVideo.");
      db.close();
      String diaST = "";
      Set<Entry<String, String>> entrySet = mapaHorarios.entrySet();
      Iterator var11 = entrySet.iterator();

      while(var11.hasNext()) {
         Entry<String, String> horario = (Entry)var11.next();
         String[] rangos = ((String)horario.getValue()).split(";");
         String[] var14 = rangos;
         int var15 = rangos.length;

         for(int var16 = 0; var16 < var15; ++var16) {
            String rango = var14[var16];
            String[] dias = rango.split("-");
            if (hora >= Integer.parseInt(dias[0]) && hora <= Integer.parseInt(dias[1])) {
               diaST = (String)horario.getKey();
            }
         }
      }

      String estacionST = "";
      String diaActual = dia + "_" + mes;
      entrySet = mapaEstaciones.entrySet();
      Iterator var23 = entrySet.iterator();

      while(var23.hasNext()) {
         Entry<String, String> estacion = (Entry)var23.next();
         String[] rangos = ((String)estacion.getValue()).split(";");
         String[] var28 = rangos;
         int var29 = rangos.length;

         for(int var30 = 0; var30 < var29; ++var30) {
            String rango = var28[var30];
            String[] dias = rango.split("-");
            if (this.compararFechas(dias[0], dias[1]) < 0 || this.compararFechas(diaActual, dias[0]) < 0 && this.compararFechas(dias[1], diaActual) < 0) {
               if (this.compararFechas(dias[1], dias[0]) >= 0 && this.compararFechas(diaActual, dias[0]) >= 0 && this.compararFechas(dias[1], diaActual) >= 0) {
                  estacionST = (String)estacion.getKey();
               }
            } else {
               estacionST = (String)estacion.getKey();
            }
         }
      }

      estacionST = estacionST.replace("estacionesVideo.", "");
      diaST = diaST.replace("horarioSaludo.", "");
      if ("dias".equals(diaST)) {
         this.tv_saludo.setText("Buenos días");
      } else if ("tardes".equals(diaST)) {
         this.tv_saludo.setText("Buenas tardes");
      } else if ("noches".equals(diaST)) {
         this.tv_saludo.setText("Buenas noches");
      } else {
         this.tv_saludo.setText("Hola");
      }

      String estacionDia = estacionST + "_" + diaST;
      byte var27 = -1;
      switch(estacionDia.hashCode()) {
      case -1741238790:
         if (estacionDia.equals("primavera_noches")) {
            var27 = 1;
         }
         break;
      case -1581950157:
         if (estacionDia.equals("primavera_tardes")) {
            var27 = 2;
         }
         break;
      case -1556220725:
         if (estacionDia.equals("otono_dias")) {
            var27 = 6;
         }
         break;
      case -1426723411:
         if (estacionDia.equals("invierno_noches")) {
            var27 = 10;
         }
         break;
      case -1320549923:
         if (estacionDia.equals("primavera_dias")) {
            var27 = 0;
         }
         break;
      case -1267434778:
         if (estacionDia.equals("invierno_tardes")) {
            var27 = 11;
         }
         break;
      case -587612824:
         if (estacionDia.equals("otono_noches")) {
            var27 = 7;
         }
         break;
      case -487547817:
         if (estacionDia.equals("verano_dias")) {
            var27 = 3;
         }
         break;
      case -428324191:
         if (estacionDia.equals("otono_tardes")) {
            var27 = 8;
         }
         break;
      case -90131980:
         if (estacionDia.equals("verano_noches")) {
            var27 = 4;
         }
         break;
      case 69156653:
         if (estacionDia.equals("verano_tardes")) {
            var27 = 5;
         }
         break;
      case 883126864:
         if (estacionDia.equals("invierno_dias")) {
            var27 = 9;
         }
      }

      switch(var27) {
      case 0:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820575));
         break;
      case 1:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820571));
         break;
      case 2:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820567));
         break;
      case 3:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820578));
         break;
      case 4:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820572));
         break;
      case 5:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820577));
         break;
      case 6:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820564));
         break;
      case 7:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820573));
         break;
      case 8:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820565));
         break;
      case 9:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820576));
         break;
      case 10:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820566));
         break;
      case 11:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820579));
         break;
      default:
         videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + 2131820567));
      }

   }

   private void changeToCompanyMode() {
      this.rbParticular.setChecked(false);
      this.rbCompany.setChecked(true);
      this.companyMode = true;
      this.firstSpinnerContainer.setVisibility(8);
      this.spinnerContainer.setVisibility(8);
      this.etDocumentNumber.setVisibility(8);
      if (!this.rememberMeChecked) {
         this.etCode.setVisibility(0);
      }

      this.etCode.setFilters(new InputFilter[]{new LengthFilter(16)});
      this.etPass.setFilters(new InputFilter[]{new AllCaps(), new RegexInputFilter("^[a-zA-Z0-9]*$"), new LengthFilter(8)});
      this.etPass.setInputType(16513);
   }

   private void changeToPrivateMode() {
      this.documentTypes = SpinnerContentModel.getSpinnerValues("spn_DocumentTypeForPrivates");
      this.documentTypesAdapter = new ArrayAdapter(this, 2131558752, 2131362922, this.documentTypes);
      this.documentTypesAdapter.setDropDownViewResource(2131558753);
      this.spnDocumentTypes.setAdapter(this.documentTypesAdapter);
      ArrayList<SpinnerValuesDTO> authenticationTypeList = SpinnerContentModel.getSpinnerValues("spnAuthenticationTypeForPrivates");
      ArrayAdapter<SpinnerValuesDTO> authenticationTypeAdapter = new ArrayAdapter(this, 2131558752, 2131362922, authenticationTypeList);
      authenticationTypeAdapter.setDropDownViewResource(2131558753);
      this.spnPrivateType.setAdapter(authenticationTypeAdapter);
      this.rbParticular.setChecked(true);
      this.rbCompany.setChecked(false);
      this.companyMode = false;
      this.spinnerContainer.setVisibility(0);
      this.firstSpinnerContainer.setVisibility(0);
      this.etDocumentNumber.setVisibility(0);
      this.etCode.setVisibility(8);
      this.spnPrivateType.setSelection(0);
      this.etPass.setFilters(new InputFilter[]{new AllCaps(), new RegexInputFilter("^\\d+$"), new LengthFilter(8)});
      this.etPass.setInputType(18);
   }

   private void resetFields() {
      this.etDocumentNumber.setText("");
      this.etCode.setText("");
      this.etPass.setText("");
      this.etDocumentNumber.setHint(2131886493);
      this.reestablishValues();
   }

   private void saveCredentials() {
      PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(this.getBaseContext(), "loginPreferencesCrypt");
      if (this.checkRememberMe.isChecked()) {
         preferencesHelper.setBoolean("companyMode", this.companyMode);
         SpinnerValuesDTO spnValues = (SpinnerValuesDTO)this.spnDocumentTypes.getSelectedItem();
         if (spnValues != null) {
            preferencesHelper.setString("documentType", spnValues.getCode());
            preferencesHelper.setString("documentNumber", this.etDocumentNumber.getText().toString());
         }

         if (this.companyMode) {
            preferencesHelper.setString("code", this.etCode.getText().toString());
            preferencesHelper.setString("authenticationTypeCode", "");
         } else {
            SpinnerValuesDTO authenticationValues = (SpinnerValuesDTO)this.spnPrivateType.getSelectedItem();
            preferencesHelper.setString("authenticationTypeCode", authenticationValues.getCode());
            preferencesHelper.setString("code", "");
         }

         preferencesHelper.setBoolean("rememberMe", true);
      } else {
         this.clearLoginPreferences();
      }

   }

   private void clearLoginPreferences() {
      PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(this.getBaseContext(), "loginPreferencesCrypt");
      preferencesHelper.setString("documentType", "");
      preferencesHelper.setString("documentNumber", "");
      preferencesHelper.setString("code", "");
      preferencesHelper.setString("authenticationTypeCode", "");
      preferencesHelper.setBoolean("companyMode", false);
      preferencesHelper.setBoolean("rememberMe", false);
      preferencesHelper.setString("userName", "");
   }

   private void reestablishValues() {
      if (this.rememberMeChecked) {
         this.checkRememberMe.setChecked(true);
         PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(this.getBaseContext(), "loginPreferencesCrypt");
         int documentTypePosition = this.getLastSpinnerPosition(this.spnDocumentTypes, preferencesHelper.getString("documentType"));
         this.wasCompanyModeChecked = preferencesHelper.getBoolean("companyMode", true);
         if (this.wasCompanyModeChecked && this.companyMode) {
            this.spnDocumentTypes.setSelection(documentTypePosition);
            this.etDocumentNumber.setText(preferencesHelper.getString("documentNumber"));
            this.etCode.setText(preferencesHelper.getString("code"));
         } else if (!this.wasCompanyModeChecked && !this.companyMode) {
            int authTypePosition = this.getLastSpinnerPosition(this.spnPrivateType, preferencesHelper.getString("authenticationTypeCode"));
            this.spnPrivateType.setSelection(authTypePosition);
            this.etDocumentNumber.setText(preferencesHelper.getString("documentNumber"));
            if (this.spnDocumentTypes != null && this.spnDocumentTypes.isShown()) {
               this.spnDocumentTypes.setSelection(documentTypePosition);
            } else if (this.spnDocumentTypes != null && !this.spnDocumentTypes.isShown()) {
               this.secondSpinnerContainer.setVisibility(8);
            }
         }
      }

   }

   private int getLastSpinnerPosition(Spinner spn, String spnValueCode) {
      int position = 0;
      ArrayAdapter<SpinnerValuesDTO> arrayAdapter = (ArrayAdapter)spn.getAdapter();
      if (arrayAdapter != null) {
         int arrayAdapterLength = arrayAdapter.getCount();

         for(int i = 0; i < arrayAdapterLength; ++i) {
            SpinnerValuesDTO spnValue = (SpinnerValuesDTO)arrayAdapter.getItem(i);
            if (spnValue.getCode().equals(spnValueCode)) {
               position = i;
               break;
            }
         }
      }

      return position;
   }

   private void validateEnableSubmitButton() {
      if (!this.etCode.getText().toString().trim().isEmpty() && !this.etPass.getText().toString().trim().isEmpty() && this.etPass.getText().length() >= 4) {
         this.btnAcceder.setEnabled(true);
      } else if (!this.etDocumentNumber.getText().toString().trim().isEmpty() && !this.etPass.getText().toString().trim().isEmpty() && this.etPass.getText().length() >= 4) {
         this.btnAcceder.setEnabled(true);
      } else {
         this.btnAcceder.setEnabled(false);
      }

   }

   protected void onDestroy() {
      if (this.progressDialog != null) {
         this.progressDialog.dismiss();
      }

      super.onDestroy();
   }

   public void onTaskFinished(String taskID, Object result) {
      PreferencesHelper preferencesHelper;
      if ("LOGIN_PROFESIONALES".equals(taskID)) {
         if (result == null && LoginManager.getInstance().getUser() != null) {
            preferencesHelper = PreferencesHelper.newInstance(this.getBaseContext(), "loginPreferencesCrypt");
            preferencesHelper.setString("userName", LoginManager.getInstance().getNombreUsuario());
            LoginExpedientesTask loginExpedientesTask = new LoginExpedientesTask(this);
            loginExpedientesTask.execute(new Object[0]);
         } else {
            this.progressDialog.dismiss();
            String error = (String)result;
            if (error == null) {
               error = "error";
            }

            String error_message = null;
            if (error.startsWith("ERROR_PROFESIONAL_EMPRESA")) {
               error_message = error.replaceAll("ERROR_PROFESIONAL_EMPRESA", "");
            } else {
               error_message = this.getStringResourceByName("error_" + error.replaceAll("\\s+", "_") + "_message");
               if (error_message == null) {
                  error_message = this.getString(2131886418);
               }
            }

            Toast.makeText(this.getApplicationContext(), error_message, 1).show();
         }
      } else if ("LOGIN_EXPEDIENTES".equals(taskID)) {
         ArrayList<ExpedienteDTO> misExpedientes = (ArrayList)result;
         if (misExpedientes != null) {
            Intent intent;
            if (misExpedientes.size() == 0) {
               intent = new Intent(this, SolicitudAccesoActivity.class);
               this.startActivity(intent);
               this.finish();
            } else {
               intent = new Intent(this, HomeActivity.class);
               intent.putExtra("expedientes", misExpedientes);
               this.startActivity(intent);
               this.finish();
            }
         } else {
            Toast.makeText(this.activity.getApplicationContext(), this.getString(2131886418), 1).show();
         }
      } else if ("MERGE_LOGIN_UNICO".equals(taskID)) {
         if (result == null && LoginManager.getInstance().getUser() != null) {
            preferencesHelper = PreferencesHelper.newInstance(this.getBaseContext(), "loginPreferencesCrypt");
            preferencesHelper.setString("userName", LoginManager.getInstance().getNombreUsuario());
         }

         this.startActivity(new Intent(this, HomeActivity.class));
      }

   }

   public void onItemClickListener(int position) {
   }

   private void changeToRememberMeScreenMode() {
      this.radioButtonsContainer.setVisibility(8);
      this.spinnerContainer.setVisibility(8);
      this.etDocumentNumber.setVisibility(8);
      this.etCode.setVisibility(8);
      this.rememberMeContainer.setVisibility(8);
      this.tvUserName.setVisibility(0);
      this.linealAreNotYouLink.setVisibility(0);
      PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(this.getBaseContext(), "loginPreferencesCrypt");
      if (this.companyMode) {
         this.etCode.setText(preferencesHelper.getString("code"));
      }

   }

   protected void returnToLoginPage() {
      this.tvUserName.setVisibility(8);
      this.linealAreNotYouLink.setVisibility(8);
      this.radioButtonsContainer.setVisibility(0);
      if (!this.companyMode) {
         this.spinnerContainer.setVisibility(0);
         this.etDocumentNumber.setVisibility(0);
      }

      this.etCode.setVisibility(0);
      this.rememberMeContainer.setVisibility(0);
      this.checkRememberMe.setChecked(true);
      this.clearLoginPreferences();
      this.rememberMeChecked = false;
      this.resetFields();
   }

   // $FF: synthetic method
   static Boolean access$000(LoginProfesionalesActivity x0) {
      return x0.FlagAyuda;
   }

   // $FF: synthetic method
   static int access$100(LoginProfesionalesActivity x0) {
      return x0.posDefaultSpPrivate;
   }

   // $FF: synthetic method
   static int access$102(LoginProfesionalesActivity x0, int x1) {
      return x0.posDefaultSpPrivate = x1;
   }

   // $FF: synthetic method
   static void access$200(LoginProfesionalesActivity x0) {
      x0.resetFields();
   }

   // $FF: synthetic method
   static boolean access$302(LoginProfesionalesActivity x0, boolean x1) {
      return x0.privateDocumentSelected = x1;
   }

   // $FF: synthetic method
   static int access$400(LoginProfesionalesActivity x0) {
      return x0.posDefaultSpDocument;
   }

   // $FF: synthetic method
   static int access$402(LoginProfesionalesActivity x0, int x1) {
      return x0.posDefaultSpDocument = x1;
   }

   // $FF: synthetic method
   static boolean access$500(LoginProfesionalesActivity x0) {
      return x0.companyMode;
   }

   // $FF: synthetic method
   static void access$600(LoginProfesionalesActivity x0) {
      x0.changeToPrivateMode();
   }

   // $FF: synthetic method
   static void access$700(LoginProfesionalesActivity x0) {
      x0.changeToCompanyMode();
   }

   // $FF: synthetic method
   static void access$800(LoginProfesionalesActivity x0) {
      x0.clearLoginPreferences();
   }

   // $FF: synthetic method
   static boolean access$902(LoginProfesionalesActivity x0, boolean x1) {
      return x0.rememberMeChecked = x1;
   }

   // $FF: synthetic method
   static void access$1000(LoginProfesionalesActivity x0) {
      x0.validateEnableSubmitButton();
   }

   // $FF: synthetic method
   static Activity access$1100(LoginProfesionalesActivity x0) {
      return x0.activity;
   }

   // $FF: synthetic method
   static void access$1200(LoginProfesionalesActivity x0, String x1) {
      x0.handleError(x1);
   }

   // $FF: synthetic method
   static void access$1300(LoginProfesionalesActivity x0, LoginUnicoMethodResultDetail x1) {
      x0.handleLoginResponse(x1);
   }

   // $FF: synthetic method
   static void access$1400(LoginProfesionalesActivity x0, ContratosMedhodResultDetail x1) {
      x0.hadleContractsResponse(x1);
   }
}
