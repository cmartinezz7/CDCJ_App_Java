package es.santander.justicia.minisJusticia;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import es.santander.justicia.utils.DateUtils;
import java.util.Calendar;

public class ActivityDetalleAuthorizacion$DatePickerFragment extends DialogFragment implements OnDateSetListener {
   public Dialog onCreateDialog(Bundle savedInstanceState) {
      Calendar c = DateUtils.calendarFromString(ActivityDetalleAuthorizacion.access$000().getText().toString());
      int year = c.get(1);
      int month = c.get(2);
      int day = c.get(5);
      return new DatePickerDialog(this.getActivity(), this, year, month, day);
   }

   public void onDateSet(DatePicker view, int year, int month, int day) {
      ++month;
      String stringDay = day < 10 ? "0" + day : String.valueOf(day);
      String stringMonth = month < 10 ? "0" + month : String.valueOf(month);
      ActivityDetalleAuthorizacion.access$000().setText(stringDay + "/" + stringMonth + "/" + year);
   }
}
