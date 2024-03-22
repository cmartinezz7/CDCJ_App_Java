package es.santander.justicia.minisJusticia;

import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import es.santander.justicia.minisJusticia.ActivityAbstractBusqueda.1;
import es.santander.justicia.minisJusticia.ActivityAbstractBusqueda.2;
import es.santander.justicia.minisJusticia.ActivityAbstractBusqueda.3;
import es.santander.justicia.minisJusticia.ActivityAbstractBusqueda.4;
import es.santander.justicia.minisJusticia.ActivityAbstractBusqueda.5;
import es.santander.justicia.minisJusticia.ActivityAbstractBusqueda.6;
import es.santander.justicia.minisJusticia.views.QEditText;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.regex.Pattern;

public abstract class ActivityAbstractBusqueda extends ActivityAbstractLetrados {
   protected QTextView mTextJuzga;
   protected QEditText mEditJuzori;
   protected QEditText mEditJproced;
   protected QEditText mEditJnumexp;
   protected QEditText mEditJanoapex;
   private TextWatcher mTextWhatcher;
   private static int mViewIdSelected;
   private OnClickListener mDateListener;
   protected static QTextView mTextDateFrom;
   protected static QTextView mTextDateTo;
   protected static String mDateDesde;
   protected static String mDateHasta;
   protected LinearLayout mLinearLayoutGlobal;

   protected void initUi() {
      mDateDesde = null;
      mDateHasta = null;
      this.defineListeners();
      this.mLinearLayoutGlobal = (LinearLayout)this.findViewById(2131362411);
      this.mLinearLayoutGlobal.setOnClickListener(new 1(this));
      this.findViewById(2131362403).setOnClickListener(new 2(this));
      this.mTextJuzga = (QTextView)this.findViewById(2131362887);
      this.mEditJuzori = (QEditText)this.findViewById(2131362149);
      this.mEditJproced = (QEditText)this.findViewById(2131362150);
      this.mEditJnumexp = (QEditText)this.findViewById(2131362151);
      this.mEditJanoapex = (QEditText)this.findViewById(2131362152);
      InputFilter filter = new 3(this);
      if (this.mEditJuzori != null) {
         this.mEditJuzori.setFilters(new InputFilter[]{filter});
         this.mEditJuzori.addTextChangedListener(this.mTextWhatcher);
      }

      if (this.mEditJproced != null) {
         this.mEditJproced.setFilters(new InputFilter[]{filter});
         this.mEditJproced.addTextChangedListener(this.mTextWhatcher);
      }

      if (this.mEditJnumexp != null) {
         this.mEditJnumexp.setFilters(new InputFilter[]{filter});
         this.mEditJnumexp.addTextChangedListener(this.mTextWhatcher);
      }

      if (this.mEditJanoapex != null) {
         this.mEditJanoapex.setFilters(new InputFilter[]{filter});
         this.mEditJanoapex.addTextChangedListener(this.mTextWhatcher);
      }

      mTextDateFrom = (QTextView)this.findViewById(2131362880);
      mTextDateTo = (QTextView)this.findViewById(2131362882);
      mTextDateFrom.setOnClickListener(this.mDateListener);
      mTextDateTo.setOnClickListener(this.mDateListener);
      this.findViewById(2131362869).setOnClickListener(new 4(this));
      this.defineSpinners();
      if (this.mTextJuzga != null) {
         this.mTextJuzga.setText(PreferencesHelper.newInstance(this).getString("preference_cod_uo"));
      }

   }

   protected abstract void defineSpinners();

   protected abstract void buscarClick();

   private void nextFocus(int currentId) {
      switch(currentId) {
      case 2131362149:
         this.mEditJproced.requestFocus();
         break;
      case 2131362150:
         this.mEditJnumexp.requestFocus();
         break;
      case 2131362151:
         this.mEditJanoapex.requestFocus();
         break;
      case 2131362152:
         CommonUtils.hideKeyboard(this);
      }

   }

   public boolean checkFields() {
      if (checkTextCorrect(this.mEditJanoapex) && checkTextCorrect(this.mEditJnumexp) && checkTextCorrect(this.mEditJproced) && checkTextCorrect(this.mEditJuzori)) {
         return false;
      } else {
         Toast.makeText(this, this.getString(2131886804), 1).show();
         return true;
      }
   }

   public static boolean checkTextCorrect(QEditText text) {
      if (text != null && !text.getText().toString().isEmpty()) {
         Pattern punct = Pattern.compile("[ª!\"·$%&/()=?¿*^Ç¨_:;><]");
         return punct.matcher(text.toString()).find();
      } else {
         return true;
      }
   }

   private void defineListeners() {
      this.mDateListener = new 5(this);
      this.mTextWhatcher = new 6(this);
   }

   public void showTimePickerDialog() {
      DialogFragment newFragment = new es.santander.justicia.minisJusticia.ActivityAbstractBusqueda.DatePickerFragment();
      newFragment.show(this.getSupportFragmentManager(), "timePicker");
   }

   // $FF: synthetic method
   static int access$002(int x0) {
      mViewIdSelected = x0;
      return x0;
   }

   // $FF: synthetic method
   static void access$100(ActivityAbstractBusqueda x0, int x1) {
      x0.nextFocus(x1);
   }

   // $FF: synthetic method
   static int access$000() {
      return mViewIdSelected;
   }
}
