package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import androidx.constraintlayout.widget.ConstraintLayout;
import es.santander.justicia.minisJusticia.BusquedaPeticionesActivity.1;
import es.santander.justicia.minisJusticia.BusquedaPeticionesActivity.2;
import es.santander.justicia.minisJusticia.BusquedaPeticionesActivity.3;
import es.santander.justicia.minisJusticia.BusquedaPeticionesActivity.4;
import es.santander.justicia.minisJusticia.BusquedaPeticionesActivity.5;
import es.santander.justicia.minisJusticia.BusquedaPeticionesActivity.6;
import es.santander.justicia.minisJusticia.BusquedaPeticionesActivity.7;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QFontButton;
import java.util.ArrayList;

public class BusquedaPeticionesActivity extends MainActivity {
   private Activity activity;
   private Context context;
   private ConstraintLayout parentLayout;
   public Spinner spnStatus;
   public EditText etJuzga;
   public EditText etJuzgori;
   public EditText etJproced;
   public EditText etJnumexp;
   public EditText etJanoapex;
   public EditText etDateFrom;
   public EditText etDateTo;
   private QFontButton searchButton;
   private String expedientNumber;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setTealiumName("/busqueda_solicitudes");
      this.setContentView(2131558456);
      this.setNavigationId(2131362421);
      this.activity = this;
      this.context = this.getBaseContext();
      ImageButton btnBack = (ImageButton)this.findViewById(2131361967);
      this.parentLayout = (ConstraintLayout)this.findViewById(2131362565);
      this.etJuzga = (EditText)this.findViewById(2131362887);
      this.etJuzgori = (EditText)this.findViewById(2131362149);
      this.etJproced = (EditText)this.findViewById(2131362150);
      this.etJnumexp = (EditText)this.findViewById(2131362151);
      this.etJanoapex = (EditText)this.findViewById(2131362152);
      this.etJuzga.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(4)});
      this.etJuzgori.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(4)});
      this.etJproced.setFilters(new InputFilter[]{new RegexInputFilter("^[A-Z0-9]*$"), new LengthFilter(2)});
      this.etJnumexp.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(4)});
      this.etJanoapex.setFilters(new InputFilter[]{new RegexInputFilter("^\\d+$"), new LengthFilter(2)});
      this.etDateFrom = (EditText)this.findViewById(2131362880);
      this.etDateTo = (EditText)this.findViewById(2131362882);
      this.etDateFrom.setCustomSelectionActionModeCallback(new 1(this));
      this.etDateTo.setCustomSelectionActionModeCallback(new 2(this));
      this.etDateFrom.setFilters(new InputFilter[]{new RegexInputFilter("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"), new LengthFilter(10)});
      this.etDateTo.setFilters(new InputFilter[]{new RegexInputFilter("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"), new LengthFilter(10)});
      this.etDateFrom.setOnTouchListener(new 3(this));
      this.etDateTo.setOnTouchListener(new 4(this));
      this.spnStatus = (Spinner)this.findViewById(2131362740);
      this.searchButton = (QFontButton)this.findViewById(2131362869);
      ArrayList<SpinnerValuesDTO> spnStatusValues = SpinnerContentModel.getSpinnerValues("spnAccessRequestStatus");
      ArrayAdapter<SpinnerValuesDTO> spnStatusAdapter = new ArrayAdapter(this.context, 2131558752, 2131362922, spnStatusValues);
      spnStatusAdapter.setDropDownViewResource(2131558753);
      this.spnStatus.setAdapter(spnStatusAdapter);
      btnBack.setOnClickListener(new 5(this));
      this.searchButton.setOnClickListener(new 6(this));
      this.parentLayout.setOnTouchListener(new 7(this));
   }

   // $FF: synthetic method
   static Activity access$000(BusquedaPeticionesActivity x0) {
      return x0.activity;
   }

   // $FF: synthetic method
   static String access$102(BusquedaPeticionesActivity x0, String x1) {
      return x0.expedientNumber = x1;
   }
}
