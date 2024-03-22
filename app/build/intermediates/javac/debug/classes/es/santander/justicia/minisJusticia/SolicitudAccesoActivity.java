package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.1;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.10;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.11;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.12;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.13;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.14;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.2;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.3;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.4;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.5;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.6;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.7;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.8;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity.9;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.controllers.AccessRequestController;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.enums.PopupTypeEnum;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;
import es.santander.justicia.minisJusticia.interfaces.AccessRequestCallback;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;
import java.util.ArrayList;

public class SolicitudAccesoActivity extends MainActivity implements AccessRequestCallback {
   private Context context;
   private EditText etJuzga;
   private EditText etJuzgori;
   private EditText etJproced;
   private EditText etJnumexp;
   private EditText etJanoapex;
   private Spinner spnMotive;
   private Button sendButton;
   private Activity activity;
   private String environment;
   private TextView tvUserName;
   private ConstraintLayout parentLayout;
   private AccessRequestController accessRequestController;
   private ProgressDialog dialog;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setTealiumName("/solicitud_acceso");
      this.setNavigationId(2131362713);
      this.context = this.getBaseContext();
      this.activity = this;
      this.accessRequestController = new AccessRequestController(this);
      this.environment = MainApplication.getAppContext().getEnvironment();
      this.setContentView(2131558457);
      Toolbar toolbar = (Toolbar)this.findViewById(2131362965);
      ((QFontTextView)this.findViewById(2131361919)).setText(2131886800);
      DrawerLayout drawer = (DrawerLayout)this.findViewById(2131362106);
      ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 2131886647, 2131886646);
      drawer.addDrawerListener(toggle);
      toggle.syncState();
      drawer.addDrawerListener(new 1(this));
      NavigationView navigationView = (NavigationView)this.findViewById(2131362529);
      navigationView.setNavigationItemSelectedListener(this);
      navigationView.getMenu().getItem(1).setChecked(true);
      navigationView.getMenu().getItem(4).getIcon().setColorFilter(ContextCompat.getColor(this, 2131100891), Mode.SRC_IN);
      this.parentLayout = (ConstraintLayout)this.findViewById(2131362565);
      this.etJuzga = (EditText)this.findViewById(2131362153);
      this.etJuzgori = (EditText)this.findViewById(2131362154);
      this.etJproced = (EditText)this.findViewById(2131362155);
      this.etJnumexp = (EditText)this.findViewById(2131362156);
      this.etJanoapex = (EditText)this.findViewById(2131362157);
      this.etJuzga.setCustomSelectionActionModeCallback(new 2(this));
      this.etJuzgori.setCustomSelectionActionModeCallback(new 3(this));
      this.etJproced.setCustomSelectionActionModeCallback(new 4(this));
      this.etJnumexp.setCustomSelectionActionModeCallback(new 5(this));
      this.etJanoapex.setCustomSelectionActionModeCallback(new 6(this));
      this.etJuzga.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(4)});
      this.etJuzgori.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(4)});
      this.etJproced.setFilters(new InputFilter[]{new RegexInputFilter("^[A-Z0-9]*$"), new LengthFilter(2)});
      this.etJnumexp.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(4)});
      this.etJanoapex.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(2)});
      this.spnMotive = (Spinner)this.findViewById(2131362714);
      ArrayList<SpinnerValuesDTO> spnValues = SpinnerContentModel.getSpinnerValues("spnAccessRequestReason");
      ArrayAdapter<SpinnerValuesDTO> spnAdapter = new ArrayAdapter(this.context, 2131558752, 2131362922, spnValues);
      spnAdapter.setDropDownViewResource(2131558753);
      this.spnMotive.setAdapter(spnAdapter);
      this.sendButton = (Button)this.findViewById(2131361962);
      this.sendButton.setEnabled(false);
      this.etJuzga.addTextChangedListener(new 7(this));
      this.etJuzgori.addTextChangedListener(new 8(this));
      this.etJproced.addTextChangedListener(new 9(this));
      this.etJnumexp.addTextChangedListener(new 10(this));
      this.etJanoapex.addTextChangedListener(new 11(this));
      this.sendButton.setOnClickListener(new 12(this));
      this.parentLayout.setOnTouchListener(new 13(this));
      String username = "";
      if (LoginManager.getInstance() != null && LoginManager.getInstance().getNombreUsuario() != null) {
         username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
      }

      this.tvUserName = (TextView)navigationView.getHeaderView(0).findViewById(2131363086);
      if (this.tvUserName != null) {
         this.tvUserName.setText(CommonUtils.wordCapitalize(username));
      }

      LinearLayout closeLayout = (LinearLayout)this.findViewById(2131362033);
      closeLayout.setOnClickListener(new 14(this));
   }

   public void onFinishRequest(String faultCode, String faultMessage, boolean success) {
      if (this.dialog != null && this.dialog.isShowing()) {
         this.dialog.dismiss();
      }

      if (success) {
         TealiumHelper.trackEvent("/solicitud_acceso", "solicitud_acceso (popup enviado)");
         Intent popup = new Intent(this.context, PopupActivity.class);
         popup.putExtra("popupName", PopupTypeEnum.ACCESS_REQUEST_SENT_CORRECTLY.getId());
         this.startActivity(popup);
      } else {
         Toast.makeText(this.context, faultMessage, 0).show();
      }

   }

   protected void onDestroy() {
      super.onDestroy();
      this.accessRequestController = null;
   }

   private void showDialog() {
      this.dialog = new ProgressDialog(this);
      this.dialog.setCancelable(false);
      this.dialog.setMessage(this.context.getResources().getString(2131886762));
      this.dialog.show();
   }

   private void validateEnableSendButton() {
      if (!this.etJuzga.getText().toString().trim().isEmpty() && this.etJuzga.getText().length() == 4 && !this.etJuzgori.getText().toString().trim().isEmpty() && this.etJuzgori.getText().length() == 4 && !this.etJproced.getText().toString().trim().isEmpty() && this.etJproced.getText().length() == 2 && !this.etJnumexp.getText().toString().trim().isEmpty() && this.etJnumexp.getText().length() == 4 && !this.etJanoapex.getText().toString().trim().isEmpty() && this.etJanoapex.getText().length() == 2) {
         this.sendButton.setEnabled(true);
      } else {
         this.sendButton.setEnabled(false);
      }

   }

   // $FF: synthetic method
   static Activity access$000(SolicitudAccesoActivity x0) {
      return x0.activity;
   }

   // $FF: synthetic method
   static void access$100(SolicitudAccesoActivity x0) {
      x0.validateEnableSendButton();
   }

   // $FF: synthetic method
   static void access$200(SolicitudAccesoActivity x0) {
      x0.showDialog();
   }

   // $FF: synthetic method
   static Spinner access$300(SolicitudAccesoActivity x0) {
      return x0.spnMotive;
   }

   // $FF: synthetic method
   static EditText access$400(SolicitudAccesoActivity x0) {
      return x0.etJuzga;
   }

   // $FF: synthetic method
   static EditText access$500(SolicitudAccesoActivity x0) {
      return x0.etJuzgori;
   }

   // $FF: synthetic method
   static EditText access$600(SolicitudAccesoActivity x0) {
      return x0.etJproced;
   }

   // $FF: synthetic method
   static EditText access$700(SolicitudAccesoActivity x0) {
      return x0.etJnumexp;
   }

   // $FF: synthetic method
   static EditText access$800(SolicitudAccesoActivity x0) {
      return x0.etJanoapex;
   }

   // $FF: synthetic method
   static String access$900(SolicitudAccesoActivity x0) {
      return x0.environment;
   }

   // $FF: synthetic method
   static AccessRequestController access$1000(SolicitudAccesoActivity x0) {
      return x0.accessRequestController;
   }
}
