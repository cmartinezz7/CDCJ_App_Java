package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import androidx.constraintlayout.widget.ConstraintLayout;
import es.santander.justicia.minisJusticia.BusquedaExpedientesActivity.1;
import es.santander.justicia.minisJusticia.BusquedaExpedientesActivity.2;
import es.santander.justicia.minisJusticia.BusquedaExpedientesActivity.3;
import es.santander.justicia.minisJusticia.BusquedaExpedientesActivity.4;
import es.santander.justicia.minisJusticia.BusquedaExpedientesActivity.5;
import es.santander.justicia.minisJusticia.BusquedaExpedientesActivity.6;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import java.util.ArrayList;

public class BusquedaExpedientesActivity extends MainActivity {
   private Activity activity;
   private Context context;
   private ConstraintLayout parentLayout;
   public Spinner spnSelectionType;
   public Spinner spnSituation;
   public Spinner spnMoney;
   public EditText etJusga;
   public EditText etJusgori;
   public EditText etJproced;
   public EditText etJnumexp;
   public EditText etJanoapex;
   public EditText etDateFrom;
   public EditText etDateTo;
   public String typeEstate;
   private Button searchButton;
   private String expedientNumber;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setTealiumName("/busqueda_expediente");
      this.setContentView(2131558717);
      this.activity = this;
      this.context = this.getBaseContext();
      ImageButton btnBack = (ImageButton)this.findViewById(2131361967);
      this.parentLayout = (ConstraintLayout)this.findViewById(2131362013);
      this.etJusga = (EditText)this.findViewById(2131362148);
      this.etJusgori = (EditText)this.findViewById(2131362149);
      this.etJproced = (EditText)this.findViewById(2131362150);
      this.etJnumexp = (EditText)this.findViewById(2131362151);
      this.etJanoapex = (EditText)this.findViewById(2131362152);
      this.etJusga.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(4)});
      this.etJusgori.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(4)});
      this.etJproced.setFilters(new InputFilter[]{new RegexInputFilter("^[A-Z0-9]*$"), new LengthFilter(2)});
      this.etJnumexp.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(4)});
      this.etJanoapex.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(2)});
      this.etDateFrom = (EditText)this.findViewById(2131362145);
      this.etDateTo = (EditText)this.findViewById(2131362146);
      this.etDateFrom.setFilters(new InputFilter[]{new RegexInputFilter("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"), new LengthFilter(10)});
      this.etDateTo.setFilters(new InputFilter[]{new RegexInputFilter("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"), new LengthFilter(10)});
      this.etDateFrom.setOnTouchListener(new 1(this));
      this.etDateTo.setOnTouchListener(new 2(this));
      this.spnSelectionType = (Spinner)this.findViewById(2131362737);
      this.spnSituation = (Spinner)this.findViewById(2131362738);
      this.spnMoney = (Spinner)this.findViewById(2131362733);
      this.searchButton = (Button)this.findViewById(2131361957);
      ArrayList<SpinnerValuesDTO> spnSectionTypeValues = new ArrayList(SpinnerContentModel.getSpinnerValues("spnSelectionTypeExpedient"));
      SpinnerValuesDTO defaultTypeValue = new SpinnerValuesDTO();
      defaultTypeValue.setValueToShow(this.getString(2131886809));
      spnSectionTypeValues.add(0, defaultTypeValue);
      ArrayList<SpinnerValuesDTO> spnSituationValues = new ArrayList(SpinnerContentModel.getSpinnerValues("spnCaseFileStatus"));
      SpinnerValuesDTO defaultSituationValue = new SpinnerValuesDTO();
      defaultSituationValue.setValueToShow(this.getString(2131886764));
      spnSituationValues.add(0, defaultSituationValue);
      ArrayList<SpinnerValuesDTO> spnMoneyValues = new ArrayList(SpinnerContentModel.getSpinnerValues("spnCoins"));
      SpinnerValuesDTO defaultCoinValue = new SpinnerValuesDTO();
      defaultCoinValue.setValueToShow(this.getString(2131886312));
      spnMoneyValues.add(0, defaultCoinValue);
      ArrayAdapter<SpinnerValuesDTO> spnSectionTypeAdapter = new ArrayAdapter(this.context, 2131558752, 2131362922, spnSectionTypeValues);
      spnSectionTypeAdapter.setDropDownViewResource(2131558753);
      this.spnSelectionType.setAdapter(spnSectionTypeAdapter);
      ArrayAdapter<SpinnerValuesDTO> spnSituationAdapter = new ArrayAdapter(this.context, 2131558752, 2131362922, spnSituationValues);
      spnSituationAdapter.setDropDownViewResource(2131558753);
      this.spnSituation.setAdapter(spnSituationAdapter);
      ArrayAdapter<SpinnerValuesDTO> spnMoneyAdapter = new ArrayAdapter(this.context, 2131558752, 2131362922, spnMoneyValues);
      spnMoneyAdapter.setDropDownViewResource(2131558753);
      this.spnMoney.setAdapter(spnMoneyAdapter);
      this.findViewById(2131362350).setOnClickListener(new 3(this));
      btnBack.setOnClickListener(new 4(this));
      this.searchButton.setOnClickListener(new 5(this));
      this.parentLayout.setOnTouchListener(new 6(this));
   }

   // $FF: synthetic method
   static Activity access$000(BusquedaExpedientesActivity x0) {
      return x0.activity;
   }

   // $FF: synthetic method
   static String access$102(BusquedaExpedientesActivity x0, String x1) {
      return x0.expedientNumber = x1;
   }

   // $FF: synthetic method
   static String access$100(BusquedaExpedientesActivity x0) {
      return x0.expedientNumber;
   }
}
