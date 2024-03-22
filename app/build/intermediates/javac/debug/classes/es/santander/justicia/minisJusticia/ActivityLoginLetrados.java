package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.VideoView;
import es.santander.justicia.minisJusticia.ActivityLoginLetrados.1;
import es.santander.justicia.minisJusticia.ActivityLoginLetrados.2;
import es.santander.justicia.minisJusticia.ActivityLoginLetrados.3;
import es.santander.justicia.minisJusticia.ActivityLoginLetrados.4;
import es.santander.justicia.minisJusticia.ActivityLoginLetrados.5;
import es.santander.justicia.minisJusticia.ActivityLoginLetrados.6;
import es.santander.justicia.minisJusticia.ActivityLoginLetrados.7;
import es.santander.justicia.minisJusticia.ActivityLoginLetrados.8;
import es.santander.justicia.minisJusticia.ActivityLoginLetrados.9;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.utils.MinJusticeDBHelper;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.sqlcipher.database.SQLiteDatabase;

public class ActivityLoginLetrados extends ActivityAbstractLetrados {
   private PreferencesHelper mPreferencesHelper;
   private EditText etCode;
   private EditText etDocumentNumber;
   private EditText etPass;
   private LinearLayout liAreNotYou;
   private LinearLayout rememberMeContainer;
   private CheckBox mCheckRemember;
   private TextView textInputPass;
   private TextView tvSaludo;
   private TextView tvName;
   protected Spinner spnDocumentTypes;
   private ArrayList<SpinnerValuesDTO> documentTypes;
   private ArrayAdapter<SpinnerValuesDTO> documentTypesAdapter;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558448);
      this.initUi();
   }

   public void onStart() {
      super.onStart();
      Map<String, String> data = new HashMap();
      data.put("perfil_app", "LETRA");
      TealiumHelper.trackView("/login", data);
   }

   private void initUi() {
      this.etCode = (EditText)this.findViewById(2131362144);
      this.etDocumentNumber = (EditText)this.findViewById(2131362147);
      this.etPass = (EditText)this.findViewById(2131362164);
      this.liAreNotYou = (LinearLayout)this.findViewById(2131362415);
      this.textInputPass = (TextView)this.findViewById(2131362911);
      this.mCheckRemember = (CheckBox)this.findViewById(2131361983);
      this.spnDocumentTypes = (Spinner)this.findViewById(2131362731);
      this.tvSaludo = (TextView)this.findViewById(2131363018);
      this.tvName = (TextView)this.findViewById(2131363026);
      this.rememberMeContainer = (LinearLayout)this.findViewById(2131362016);
      this.etPass.setCustomSelectionActionModeCallback(new 1(this));
      this.etDocumentNumber.setCustomSelectionActionModeCallback(new 2(this));
      this.etCode.setCustomSelectionActionModeCallback(new 3(this));
      this.mPreferencesHelper = PreferencesHelper.newInstance(this);
      this.documentTypes = SpinnerContentModel.getSpinnerValues("spnDocumentTypeForLetrados");
      this.documentTypesAdapter = new ArrayAdapter(this, 2131558752, 2131362922, this.documentTypes);
      this.documentTypesAdapter.setDropDownViewResource(2131558753);
      this.spnDocumentTypes.setAdapter(this.documentTypesAdapter);
      this.mCheckRemember.setChecked(true);
      this.mCheckRemember.setOnCheckedChangeListener(new 4(this));
      Button buttonEntrar = (Button)this.findViewById(2131361945);
      TextWatcher textWatcher = new 5(this, buttonEntrar);
      this.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter("^[a-zA-Z0-9]*$"), new LengthFilter(9)});
      this.etCode.setFilters(new InputFilter[]{new RegexInputFilter("^[a-zA-Z0-9]*$"), new LengthFilter(8)});
      this.etDocumentNumber.addTextChangedListener(textWatcher);
      this.etCode.addTextChangedListener(textWatcher);
      this.etPass.addTextChangedListener(textWatcher);
      this.spnDocumentTypes.setOnItemSelectedListener(new 6(this));
      this.initFields(this.mPreferencesHelper.getBoolean("preference_remember_data", false));
      this.findViewById(2131362627).setOnClickListener(new 7(this));
   }

   private void initFields(boolean remembering) {
      if (remembering) {
         this.etDocumentNumber.setText(this.mPreferencesHelper.getString("preference_user_document"));
         this.etCode.setText(this.mPreferencesHelper.getString("preference_user_login"));
         this.etPass.setText(this.mPreferencesHelper.getString("preference_user_pass"));
         this.etDocumentNumber.setVisibility(8);
         this.etCode.setVisibility(8);
         this.spnDocumentTypes.setVisibility(8);
         this.rememberMeContainer.setVisibility(8);
         this.liAreNotYou.setVisibility(0);
         this.textInputPass.setVisibility(0);
         this.findViewById(2131362626).setVisibility(8);
         this.tvName.setVisibility(0);
         this.spnDocumentTypes.setSelection(this.findPositionType(this.mPreferencesHelper.getString("preference_user_type_document")));
         String name = this.getFormattedName(this.mPreferencesHelper.getString("preference_user_login_name"));
         this.tvName.setText(name);
      } else {
         this.etDocumentNumber.setText("");
         this.etCode.setText("");
         this.etPass.setText("");
         this.spnDocumentTypes.setVisibility(0);
         this.spnDocumentTypes.setSelection(0);
         this.findViewById(2131362626).setVisibility(0);
         this.etDocumentNumber.setVisibility(0);
         this.etCode.setVisibility(0);
         this.rememberMeContainer.setVisibility(0);
         this.liAreNotYou.setVisibility(8);
         this.textInputPass.setVisibility(8);
         this.tvName.setVisibility(8);
      }

   }

   private String getFormattedName(String name) {
      String[] splitName = name.split(" ");
      StringBuilder nameFormatted = new StringBuilder();

      for(int i = 0; i < splitName.length; ++i) {
         nameFormatted.append(this.capitalizeFirstLetter(splitName[i]));
         if (i != splitName.length - 1) {
            nameFormatted.append(" ");
         }
      }

      return nameFormatted.toString();
   }

   private String capitalizeFirstLetter(String name) {
      return name.isEmpty() ? name : name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1).toLowerCase(Locale.ROOT);
   }

   private int findPositionType(String code) {
      int posistion = 0;

      for(int i = 0; i < this.documentTypes.size(); ++i) {
         if (((SpinnerValuesDTO)this.documentTypes.get(i)).getCode().equals(code)) {
            posistion = i;
            break;
         }
      }

      return posistion;
   }

   private void saveCredentials() {
      if (this.mCheckRemember.isChecked()) {
         this.mPreferencesHelper.setString("preference_user_document", this.etDocumentNumber.getText().toString());
         this.mPreferencesHelper.setString("preference_user_login", this.etCode.getText().toString());
         this.mPreferencesHelper.setString("preference_user_type_document", ((SpinnerValuesDTO)this.spnDocumentTypes.getSelectedItem()).getCode());
         this.mPreferencesHelper.setBoolean("preference_remember_data", true);
      } else {
         this.mPreferencesHelper.clear();
      }

   }

   public void onEntryClick(View v) {
      ConnectionBuilder.getLoginCall(this.etDocumentNumber.getText().toString().toUpperCase(Locale.US), this.etCode.getText().toString().toUpperCase(Locale.US), this.etPass.getText().toString(), this.spnDocumentTypes.getSelectedItem() != null ? ((SpinnerValuesDTO)this.spnDocumentTypes.getSelectedItem()).getCode() : this.mPreferencesHelper.getString("preference_user_type_document")).enqueue(new 8(this, this, true, false));
   }

   private void getDataUser(boolean loginOk) {
      ConnectionBuilder.getDetalleUsuarioCall().enqueue(new 9(this, this, false, true, loginOk));
   }

   public void onNoEntryClick(View v) {
      Bundle bundle = new Bundle();
      bundle.putBoolean("flag_ayuda", true);
      Intent intent = new Intent(this, ActivityHelpLetrados.class);
      intent.putExtras(bundle);
      this.startActivity(intent);
   }

   public void onNoYouClick(View v) {
      this.mPreferencesHelper.clear();
      this.initFields(false);
   }

   public void onBackPressed() {
      Intent intent = new Intent(this, NewsActivity.class);
      this.startActivity(intent);
      this.finish();
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
         this.tvSaludo.setText("Buenos días");
      } else if ("tardes".equals(diaST)) {
         this.tvSaludo.setText("Buenas tardes");
      } else if ("noches".equals(diaST)) {
         this.tvSaludo.setText("Buenas noches");
      } else {
         this.tvSaludo.setText("Hola");
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

   // $FF: synthetic method
   static PreferencesHelper access$000(ActivityLoginLetrados x0) {
      return x0.mPreferencesHelper;
   }

   // $FF: synthetic method
   static EditText access$100(ActivityLoginLetrados x0) {
      return x0.etCode;
   }

   // $FF: synthetic method
   static EditText access$200(ActivityLoginLetrados x0) {
      return x0.etDocumentNumber;
   }

   // $FF: synthetic method
   static EditText access$300(ActivityLoginLetrados x0) {
      return x0.etPass;
   }

   // $FF: synthetic method
   static void access$400(ActivityLoginLetrados x0) {
      x0.saveCredentials();
   }

   // $FF: synthetic method
   static void access$500(ActivityLoginLetrados x0, boolean x1) {
      x0.getDataUser(x1);
   }
}
