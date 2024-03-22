package es.santander.justicia.minisJusticia;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import es.santander.justicia.utils.DateUtils;
import java.util.Calendar;

public class ActivityAbstractBusqueda$DatePickerFragment extends DialogFragment implements OnDateSetListener {
   public Dialog onCreateDialog(Bundle savedInstanceState) {
      Calendar c;
      switch(ActivityAbstractBusqueda.access$000()) {
      case 2131362880:
         if (ActivityAbstractBusqueda.mTextDateFrom != null && !ActivityAbstractBusqueda.mTextDateFrom.getText().toString().isEmpty()) {
            c = DateUtils.calendarFromString(ActivityAbstractBusqueda.mTextDateFrom.getText().toString());
         } else {
            c = Calendar.getInstance();
         }
         break;
      case 2131362882:
         if (ActivityAbstractBusqueda.mTextDateTo != null && !ActivityAbstractBusqueda.mTextDateTo.getText().toString().isEmpty()) {
            c = DateUtils.calendarFromString(ActivityAbstractBusqueda.mTextDateTo.getText().toString());
         } else {
            c = Calendar.getInstance();
         }
         break;
      default:
         c = Calendar.getInstance();
      }

      int year = c.get(1);
      int month = c.get(2);
      int day = c.get(5);
      return new DatePickerDialog(this.getActivity(), this, year, month, day);
   }

   public void onDateSet(DatePicker view, int year, int month, int day) {
      ++month;
      String stringDay = day < 10 ? "0" + day : String.valueOf(day);
      String stringMonth = month < 10 ? "0" + month : String.valueOf(month);
      switch(ActivityAbstractBusqueda.access$000()) {
      case 2131362880:
         ActivityAbstractBusqueda.mTextDateFrom.setText(day + "/" + month + "/" + year);
         ActivityAbstractBusqueda.mDateDesde = year + "-" + stringMonth + "-" + stringDay;
         break;
      case 2131362882:
         ActivityAbstractBusqueda.mTextDateTo.setText(day + "/" + month + "/" + year);
         ActivityAbstractBusqueda.mDateHasta = year + "-" + stringMonth + "-" + stringDay;
      }

   }
}
