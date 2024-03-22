package es.santander.justicia.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import es.santander.justicia.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtils {
    public static String formatDate(String dateToFormat) {
        if (dateToFormat == null) {
            return "";
        }
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            return new SimpleDateFormat("dd/MM/yyyy").format(parser.parse(dateToFormat));
        } catch (ParseException e) {
            Log.e("DateUtils", "ParseException", e);
            return "";
        }
    }

    public static Calendar calendarFromString(String date) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal;
    }

    public static String formatDate(String dateToFormat, String format) {
        if (dateToFormat == null) {
            return "";
        }
        SimpleDateFormat parser = new SimpleDateFormat(format);
        try {
            return new SimpleDateFormat("dd/MM/yyyy").format(parser.parse(dateToFormat));
        } catch (ParseException e) {
            Log.e("DateUtils", "ParseException", e);
            return "";
        }
    }

    public static String formatDateToRequest(String dateToFormat) {
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(parser.parse(dateToFormat));
        } catch (ParseException e) {
            Log.e("formatDateToRequest", "ParseException", e);
            return "";
        }
    }

    public static String formatDateToRequest(String dateToFormat, String format) {
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return new SimpleDateFormat(format).format(parser.parse(dateToFormat));
        } catch (ParseException e) {
            Log.e("formatDateToRequest", "ParseException", e);
            return "";
        }
    }

    public static void getDateFromPicker(Activity activity, final EditText dateView) {
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Calendar newCalendar = Calendar.getInstance();
        new DatePickerDialog(activity, R.style.picker_theme, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                dateView.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(1), newCalendar.get(2), newCalendar.get(5)).show();
    }

    public static String getDateMonthBeforeCurrent(String stringDate) {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        if (stringDate != null) {
            try {
                cal.setTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(stringDate));
            } catch (ParseException e) {
            }
        }
        cal.add(2, -1);
        return formater.format(cal.getTime());
    }

    public static boolean dateToHigherThanFrom(String dateFrom, String dateTo) {
        if (dateFrom == null || dateTo == null || dateFrom.isEmpty() || dateTo.isEmpty()) {
            return true;
        }
        return calendarFromString(dateTo).after(calendarFromString(dateFrom));
    }
}
