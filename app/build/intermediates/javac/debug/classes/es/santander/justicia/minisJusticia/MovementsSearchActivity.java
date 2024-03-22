package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import es.santander.justicia.minisJusticia.MovementsSearchActivity.1;
import es.santander.justicia.minisJusticia.MovementsSearchActivity.2;
import es.santander.justicia.minisJusticia.MovementsSearchActivity.3;
import es.santander.justicia.minisJusticia.MovementsSearchActivity.4;
import es.santander.justicia.minisJusticia.MovementsSearchActivity.5;
import es.santander.justicia.minisJusticia.MovementsSearchActivity.6;
import es.santander.justicia.minisJusticia.MovementsSearchActivity.7;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MovementsSearchActivity extends MainActivity {
   private Context context;
   private Activity activity;
   private ConstraintLayout parentLayout;
   private EditText etDateFrom;
   private EditText etDateTo;
   private EditText etImportFrom;
   private EditText etImportTo;
   private ImageView ivCalendarFrom;
   private ImageView ivCalendarTo;
   private Spinner spnMovementType;
   private Spinner spnCurrencyType;
   private Button btnSearch;
   private DatePickerDialog fromDatePickerDialog;
   private DatePickerDialog toDatePickerDialog;
   private SimpleDateFormat dateFormatter;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setTealiumName("/busqueda_movimiento");
      this.setContentView(2131558723);
      this.context = this.getApplicationContext();
      this.activity = this;
      this.parentLayout = (ConstraintLayout)this.findViewById(2131362565);
      TextView toolbarTitle = (TextView)this.findViewById(2131363082);
      ImageButton btnBack = (ImageButton)this.findViewById(2131361967);
      toolbarTitle.setText(2131886599);
      btnBack.setOnClickListener(new 1(this));
      this.etDateFrom = (EditText)this.findViewById(2131362880);
      this.etDateTo = (EditText)this.findViewById(2131362882);
      this.etImportFrom = (EditText)this.findViewById(2131362158);
      this.etImportTo = (EditText)this.findViewById(2131362159);
      this.ivCalendarFrom = (ImageView)this.findViewById(2131362340);
      this.ivCalendarTo = (ImageView)this.findViewById(2131362341);
      this.spnMovementType = (Spinner)this.findViewById(2131362734);
      this.spnCurrencyType = (Spinner)this.findViewById(2131362729);
      this.btnSearch = (Button)this.findViewById(2131361961);
      this.etDateFrom.setFilters(new InputFilter[]{new RegexInputFilter("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"), new LengthFilter(10)});
      this.etDateTo.setFilters(new InputFilter[]{new RegexInputFilter("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"), new LengthFilter(10)});
      this.etDateFrom.setOnTouchListener(new 2(this));
      this.etDateTo.setOnTouchListener(new 3(this));
      if (this.ivCalendarFrom != null) {
         this.ivCalendarFrom.setOnClickListener(new 4(this));
      }

      if (this.ivCalendarTo != null) {
         this.ivCalendarTo.setOnClickListener(new 5(this));
      }

      ArrayList<SpinnerValuesDTO> movementValues = new ArrayList(SpinnerContentModel.getSpinnerValues("spnMotionQuery"));
      SpinnerValuesDTO defaultValue = new SpinnerValuesDTO();
      defaultValue.setValueToShow(this.getString(2131886603));
      movementValues.add(0, defaultValue);
      ArrayAdapter<SpinnerValuesDTO> movementAdapter = new ArrayAdapter(this, 2131558752, 2131362922, movementValues);
      movementAdapter.setDropDownViewResource(2131558753);
      this.spnMovementType.setAdapter(movementAdapter);
      ArrayList<SpinnerValuesDTO> coinValues = new ArrayList(SpinnerContentModel.getSpinnerValues("spnCoins"));
      SpinnerValuesDTO defaultCoinValue = new SpinnerValuesDTO();
      defaultCoinValue.setValueToShow(this.getString(2131886312));
      coinValues.add(0, defaultCoinValue);
      ArrayAdapter<SpinnerValuesDTO> coinAdapter = new ArrayAdapter(this, 2131558752, 2131362922, coinValues);
      coinAdapter.setDropDownViewResource(2131558753);
      this.spnCurrencyType.setAdapter(coinAdapter);
      this.parentLayout.setOnTouchListener(new 6(this));
      this.btnSearch.setOnClickListener(new 7(this));
   }

   // $FF: synthetic method
   static Activity access$000(MovementsSearchActivity x0) {
      return x0.activity;
   }

   // $FF: synthetic method
   static EditText access$100(MovementsSearchActivity x0) {
      return x0.etDateFrom;
   }

   // $FF: synthetic method
   static EditText access$200(MovementsSearchActivity x0) {
      return x0.etDateTo;
   }

   // $FF: synthetic method
   static Spinner access$300(MovementsSearchActivity x0) {
      return x0.spnMovementType;
   }

   // $FF: synthetic method
   static Spinner access$400(MovementsSearchActivity x0) {
      return x0.spnCurrencyType;
   }

   // $FF: synthetic method
   static EditText access$500(MovementsSearchActivity x0) {
      return x0.etImportFrom;
   }

   // $FF: synthetic method
   static EditText access$600(MovementsSearchActivity x0) {
      return x0.etImportTo;
   }
}
