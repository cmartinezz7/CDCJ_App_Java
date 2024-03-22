package es.santander.justicia.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion;
import es.santander.justicia.minisJusticia.ActivityLoginLetrados;
import es.santander.justicia.minisJusticia.LoginProfesionalesActivity;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.enums.MovementStatusEnum;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew;
import es.santander.justicia.minisJusticia.models.responses.authjuzados.AutorizacionesUsuario;
import es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscarPeticionesAcceso;
import es.santander.justicia.minisJusticia.models.responses.consultaOperaciones.ConsultaOperaciones;
import es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DatosOperacion;
import es.santander.justicia.minisJusticia.views.QEditText;
import es.santander.justicia.minisJusticia.views.QFontButton;
import es.santander.justicia.minisJusticia.views.QTextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class CommonUtils {
    public static void hideKeyboard(Activity activity) {
        View view = activity.findViewById(16908290).getRootView();
        if (view != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public static String formatImport(String currencyImport) {
        if (TextUtils.isEmpty(currencyImport)) {
            currencyImport = "0";
        }
        try {
            return new DecimalFormat("###,##0.00").format(Double.parseDouble(currencyImport));
        } catch (Exception e) {
            Log.i("CommonUtils", "Error al formatear: " + currencyImport, e);
            return currencyImport;
        }
    }

    public static ExpedienteDTO parseExpedientToObject(String expedientNumber) {
        String juzga = expedientNumber.substring(0, 4);
        String juzgori = expedientNumber.substring(4, 8);
        String jproced = expedientNumber.substring(8, 10);
        String jnumexp = expedientNumber.substring(10, 14);
        String janoapex = expedientNumber.substring(14, 16);
        ExpedienteDTO expedient = new ExpedienteDTO();
        expedient.setJuzga(juzga);
        expedient.setJuzgori(juzgori);
        expedient.setJproced(jproced);
        expedient.setJnumexp(jnumexp);
        expedient.setJanoapex(janoapex);
        return expedient;
    }

    public static boolean isNotNullNotBlack(String texto) {
        if (texto == null || texto.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isNotNullNotBlackNotStringNull(String texto) {
        if (texto == null || texto.isEmpty() || "null".equals(texto.trim())) {
            return false;
        }
        return true;
    }

    public static void addMarker(GoogleMap map, LatLng latLng, String nombre, BitmapDescriptor iconDesciptor) {
        map.addMarker(new MarkerOptions().position(latLng).title(nombre).icon(iconDesciptor));
    }

    public static int findIdPosition(TypedArray array, int id) {
        for (int i = 0; i < array.length(); i++) {
            if (array.getResourceId(i, -1) == id) {
                return i;
            }
        }
        return -1;
    }

    public static void showOptionsPopUp(Context context, View viewParent, View.OnClickListener listener) {
        View popUpView = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popup_options_swipe, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(popUpView, -1, -1, true);
        popupWindow.showAtLocation(viewParent, 17, 0, 0);
        popUpView.findViewById(R.id.text_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popUpView.findViewById(R.id.relative_popup).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        popUpView.findViewById(R.id.text_accpet).setOnClickListener(listener);
        popUpView.findViewById(R.id.text_denie).setOnClickListener(listener);
        popUpView.findViewById(R.id.text_baja).setOnClickListener(listener);
    }

    public static void showOperativaPopUp(Context context, View viewParent, DialogSolicitudCalback callback, boolean showMotive, int buttonTextResource, int position) {
        String textAux;
        int i;
        final Context context2 = context;
        int i2 = buttonTextResource;
        LayoutInflater layoutInflater = (LayoutInflater) context2.getSystemService("layout_inflater");
        View popUpView = layoutInflater.inflate(R.layout.popup_motivo_solicitud, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(popUpView, -1, -1, true);
        int i3 = 0;
        if (viewParent != null) {
            popupWindow.showAtLocation(viewParent.getRootView(), 17, 0, 0);
        }
        QEditText editMotive = (QEditText) popUpView.findViewById(R.id.edit_box_comments);
        QEditText editClave = (QEditText) popUpView.findViewById(R.id.edit_clave);
        QFontButton textButton = (QFontButton) popUpView.findViewById(R.id.text_button);
        popUpView.findViewById(R.id.scroll_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((InputMethodManager) context2.getSystemService("input_method")).hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });
        popUpView.findViewById(R.id.relative_popup).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((InputMethodManager) context2.getSystemService("input_method")).hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });
        String textAux2 = context2.getString(i2);
        if (textAux2.equals(context2.getString(R.string.baja_swype))) {
            textAux = "dar de baja";
        } else {
            textAux = textAux2;
        }
        QTextView qTextView = (QTextView) popUpView.findViewById(R.id.text_title_state);
        StringBuilder sb = new StringBuilder();
        if (showMotive) {
            i = R.string.popup_solicitud_motive_title;
        } else {
            i = R.string.popup_solicitud_pass_title;
        }
        qTextView.setText(sb.append(context2.getString(i)).append(" ").append(textAux.toLowerCase()).toString());
        textButton.setText(context2.getString(i2));
        RelativeLayout relativeMotive = (RelativeLayout) popUpView.findViewById(R.id.relative_motive);
        if (!showMotive) {
            i3 = 8;
        }
        relativeMotive.setVisibility(i3);
        final boolean z = showMotive;
        final QEditText qEditText = editMotive;
        final Context context3 = context;
        final QEditText qEditText2 = editClave;
        final DialogSolicitudCalback dialogSolicitudCalback = callback;
        AnonymousClass5 r10 = r0;
        final int i4 = buttonTextResource;
        RelativeLayout relativeLayout = relativeMotive;
        final int i5 = position;
        LayoutInflater layoutInflater2 = layoutInflater;
        final QFontButton textButton2 = textButton;
        final PopupWindow popupWindow2 = popupWindow;
        AnonymousClass5 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                if (z && (qEditText.getText() == null || qEditText.getText().toString().length() == 0)) {
                    Context context = context3;
                    Toast.makeText(context, context.getString(R.string.popup_solicitud_motive_nedded), 1).show();
                } else if (z && CommonUtils.checkTextCorrect(qEditText.getText().toString())) {
                    Context context2 = context3;
                    Toast.makeText(context2, context2.getString(R.string.popup_solicitud_motive_incorrect), 1).show();
                } else if (qEditText2.getText() == null || qEditText2.getText().toString().length() == 0) {
                    Context context3 = context3;
                    Toast.makeText(context3, context3.getString(R.string.popup_solicitud_clave_nedded), 1).show();
                } else {
                    dialogSolicitudCalback.onOperativaClicked(qEditText.getText().toString(), qEditText2.getText().toString(), i4, i5);
                    popupWindow2.dismiss();
                }
            }
        };
        textButton2.setOnClickListener(r10);
        popUpView.findViewById(R.id.image_close_popup).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        editClave.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId != 6) {
                    return false;
                }
                CommonUtils.hideKeyboard(context2);
                textButton2.requestFocus();
                return true;
            }
        });
    }

    public static void showPopUpEndSession(final Context context) {
        View popUpView = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.pop_up_token_caducado, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(popUpView, -1, -1, true);
        popupWindow.showAtLocation(((AppCompatActivity) context).findViewById(16908290).getRootView(), 17, 0, 0);
        popUpView.findViewById(R.id.text_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popupWindow.dismiss();
                Intent intent = new Intent(context, ActivityLoginLetrados.class);
                intent.addFlags(67108864);
                context.startActivity(intent);
            }
        });
    }

    public static void showPopUpActionDone(Context context, View viewParent, int textAction, final PopUpActionDone listener) {
        View popUpView = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.pop_up_action_done, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(popUpView, -1, -1, true);
        popupWindow.showAtLocation(viewParent, 17, 0, 0);
        ((QTextView) popUpView.findViewById(R.id.text_action_ok)).setText(context.getString(textAction));
        popUpView.findViewById(R.id.image_close_popup).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popupWindow.dismiss();
                PopUpActionDone popUpActionDone = listener;
                if (popUpActionDone != null) {
                    popUpActionDone.onPopUpClosed();
                }
            }
        });
        popUpView.findViewById(R.id.linear_global).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popupWindow.dismiss();
                PopUpActionDone popUpActionDone = listener;
                if (popUpActionDone != null) {
                    popUpActionDone.onPopUpClosed();
                }
            }
        });
    }

    public static String getDateFromExp(String dateIn) {
        if (dateIn == null) {
            return "";
        }
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
            return new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(inputFormat.parse(dateIn));
        } catch (ParseException e) {
            Log.e("getDateFromExp", "ParseException", e);
            return "";
        }
    }

    public static boolean checkTextCorrect(String text) {
        if (text.length() > 254) {
            return false;
        }
        return Pattern.compile("[ª!\"·$%&/()=?¿*^Ç¨_:;><]").matcher(text).find();
    }

    public static String getDateFromExpToSend(String dateIn) {
        if (dateIn == null) {
            return "";
        }
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(inputFormat.parse(dateIn));
        } catch (ParseException e) {
            Log.e("getDateFromExpToSend", "ParseException", e);
            return "";
        }
    }

    public static List<BuscarPeticionesAcceso> removeDatosPaginacionInBusqueda(ArrayList<BuscarPeticionesAcceso> items) {
        if (items != null) {
            int itemToRemove = -1;
            int i = 0;
            while (true) {
                if (i >= items.size()) {
                    break;
                } else if (items.get(i).getNumerPagina() == 0 && items.get(i).getTamannoPagina() == 0 && items.get(i).getTotalPaginas() == 0) {
                    i++;
                } else {
                    itemToRemove = i;
                }
            }
            itemToRemove = i;
            if (itemToRemove != -1) {
                items.remove(itemToRemove);
            }
        }
        return items;
    }

    public static List<ConsultaOperaciones> removeDatosPaginacionInOperaciones(ArrayList<ConsultaOperaciones> items) {
        if (items != null) {
            int itemToRemove = -1;
            int i = 0;
            while (true) {
                if (i >= items.size()) {
                    break;
                } else if (items.get(i).getNumerPagina() == 0 && items.get(i).getTamannoPagina() == 0 && items.get(i).getTotalPaginas() == 0) {
                    i++;
                } else {
                    itemToRemove = i;
                }
            }
            itemToRemove = i;
            if (itemToRemove != -1) {
                items.remove(itemToRemove);
            }
        }
        return items;
    }

    public static List<DatosExpedienteNew> removeDatosPaginacionInBuscarExp(ArrayList<DatosExpedienteNew> items) {
        if (items != null) {
            int itemToRemove = -1;
            int i = 0;
            while (true) {
                if (i >= items.size()) {
                    break;
                } else if (items.get(i).getNumerPagina() == 0 && items.get(i).getTamannoPagina() == 0 && items.get(i).getTotalPaginas() == 0) {
                    i++;
                } else {
                    itemToRemove = i;
                }
            }
            itemToRemove = i;
            if (itemToRemove != -1) {
                items.remove(itemToRemove);
            }
        }
        return items;
    }

    public static List<AutorizacionesUsuario> removeDatosPaginacionInAutorizacionUsuario(ArrayList<AutorizacionesUsuario> items) {
        if (items != null) {
            int itemToRemove = -1;
            int i = 0;
            while (true) {
                if (i >= items.size()) {
                    break;
                } else if (items.get(i).getNumerPagina() == 0 && items.get(i).getTamannoPagina() == 0 && items.get(i).getTotalPaginas() == 0) {
                    i++;
                } else {
                    itemToRemove = i;
                }
            }
            itemToRemove = i;
            if (itemToRemove != -1) {
                items.remove(itemToRemove);
            }
        }
        return items;
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-dd-MM", Locale.US).format(Calendar.getInstance(TimeZone.getDefault()).getTime());
    }

    public static String getCurrentDateToShow() {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(Calendar.getInstance(TimeZone.getDefault()).getTime());
    }

    public static String getDateMonthAgo() {
        DateFormat df = new SimpleDateFormat("yyyy-dd-MM", Locale.US);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(2, -1);
        return df.format(calendar.getTime());
    }

    public static String getDateMonthAgoToShow() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(2, -1);
        return df.format(calendar.getTime());
    }

    public static String getDateNextMonthToShow() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(2, 1);
        return df.format(calendar.getTime());
    }

    public static String getCurrentDateToOperations() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance(TimeZone.getDefault()).getTime());
    }

    public static String getDateWeekAgo() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(4, -1);
        return df.format(calendar.getTime());
    }

    public static String getDateFourMonthsAgo() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(2, -4);
        return df.format(calendar.getTime());
    }

    public static String getDateSevenMonthsAgo() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(2, -7);
        return df.format(calendar.getTime());
    }

    public static String getDateTwoMonthsAgo() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(2, -2);
        return df.format(calendar.getTime());
    }

    public static String getDateFromFristDayOfTheYear() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.set(2, 0);
        calendar.set(6, 1);
        return df.format(calendar.getTime());
    }

    public static Date getDateFromString(String dateIn) {
        if (dateIn == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(dateIn);
        } catch (ParseException e) {
            Log.e("getDateFromString", "ParseException", e);
            return null;
        }
    }

    public static String formatExpedientWithSpaces(String field1, String field2, String field3, String field4, String field5) {
        return add0(field1, 4) + " " + add0(field2, 4) + " " + add0(field3, 2) + " " + add0(field4, 4) + " " + add0(field5, 2);
    }

    public static String formatExpedient(String field1, String field2, String field3, String field4, String field5) {
        try {
            return add0(field1, 4) + add0(field2, 4) + add0(field3, 2) + add0(field4, 4) + add0(field5, 2);
        } catch (Exception e) {
            return "";
        }
    }

    private static String add0(String field, int num) {
        while (field.length() < num) {
            field = "0" + field;
        }
        return field;
    }

    public static MovementItemDTO getMovmentItemDTO(ConsultaOperaciones datosOperacion, DatosOperacion movementObject, String expedienteDestino) {
        MovementItemDTO movement = new MovementItemDTO();
        movement.setDetail(true);
        movement.setEsLetrado(true);
        if (expedienteDestino != null) {
            movement.setExpedienteDestino(expedienteDestino);
        }
        if (datosOperacion.getImporte() != null) {
            movement.setImporteDetalle(datosOperacion.getImporte());
        }
        if (movementObject.getCodmon() != null) {
            movement.setCodmon(movementObject.getCodmon());
        }
        if (movementObject.getDesctipomod() != null) {
            movement.setDesctipomod(movementObject.getDesctipomod());
        }
        if (datosOperacion != null) {
            if (datosOperacion.getJimpnomi() != null) {
                movement.setJimpnomi(datosOperacion.getJimpnomi());
                movement.setMovementStatus(MovementStatusEnum.EXECUTED);
            } else if (datosOperacion.getJfeccaduc() != null) {
                movement.setjFechaCaducidad(datosOperacion.getJfeccaduc());
                movement.setMovementStatus(MovementStatusEnum.EXPIRED);
            }
        }
        if (datosOperacion.getJnors() != null) {
            movement.setJnors(datosOperacion.getJnors());
        }
        if (movementObject.getJnuoper() != null) {
            movement.setJnuoper(movementObject.getJnuoper());
        }
        if (datosOperacion.getCodmon() != null) {
            movement.setJtipomod(datosOperacion.getCodmon());
        }
        if (datosOperacion.getTipoMoneda() != null) {
            movement.setMoneda(datosOperacion.getTipoMoneda());
        }
        if (movementObject.getNumerosr() != null) {
            movement.setNumerosr(movementObject.getNumerosr());
        }
        if (movementObject.getSeralfab() != null) {
            movement.setSeralfab(movementObject.getSeralfab());
        }
        if (movementObject.getSerieYMandamiento() != null) {
            movement.setSerieYMandamiento(movementObject.getSerieYMandamiento());
        }
        if (movementObject.getJusrhare() != null) {
            movement.setjResponsableAlta(movementObject.getJusrhare());
        }
        if (movementObject.getJusrfirma() != null) {
            movement.setjResponsableFirma(movementObject.getJusrfirma());
        }
        if (movementObject.getJusrfirmeza() != null) {
            movement.setjResponsableFirmeza(movementObject.getJusrfirmeza());
        }
        if (movementObject.getJusrautoriza() != null) {
            movement.setjResponsableAutorizacion(movementObject.getJusrautoriza());
        }
        if (movementObject.getJusrconf() != null) {
            movement.setjResponsableConfirmacion(movementObject.getJusrconf());
        }
        if (movementObject.getJfechare() != null) {
            movement.setJfechare(DateUtils.formatDate(movementObject.getJfechare()));
        }
        if (movementObject.getJfecfirma() != null) {
            movement.setjFechaFirma(DateUtils.formatDate(movementObject.getJfecfirma()));
        }
        if (movementObject.getJfecfirmeza() != null) {
            movement.setjFechaFirmeza(DateUtils.formatDate(movementObject.getJfecfirmeza()));
        }
        if (movementObject.getJfecautoriza() != null) {
            movement.setjFechaAutorizacion(DateUtils.formatDate(movementObject.getJfecautoriza()));
        }
        if (movementObject.getJfecconf() != null) {
            movement.setjFechaConfirmacion(DateUtils.formatDate(movementObject.getJfecconf()));
        }
        if (movementObject.getJfeccaduc() != null) {
            movement.setjFechaCaducidad(DateUtils.formatDate(movementObject.getJfeccaduc()));
        }
        if (!(movementObject.getDatosRepresentante() == null || movementObject.getDatosRepresentante().getGenombre() == null)) {
            movement.setRepresentante(movementObject.getDatosRepresentante().getGenombre());
        }
        if (movementObject.getJnors() != null) {
            movement.setRepresentado(movementObject.getJnors());
        }
        if (movementObject.getConc30() != null) {
            movement.setConcepto(movementObject.getConc30());
        }
        if (!(movementObject.getDatosExpediente() == null || movementObject.getDatosExpediente().getSaldos() == null)) {
            movement.setImporteSaldo(movementObject.getDatosExpediente().getSaldos().getImpsald());
            movement.setFecha(getCurrentDateToShow());
        }
        return movement;
    }

    public static MovementItemDTO getMovmentItemDTO(DatosOperacion movementObject, String expedienteDestino) {
        MovementItemDTO movement = new MovementItemDTO();
        movement.setDetail(true);
        movement.setEsLetrado(true);
        if (movementObject.getCodmon() != null) {
            movement.setCodmon(movementObject.getCodmon());
        }
        if (movementObject.getDesctipomod() != null) {
            movement.setDesctipomod(movementObject.getDesctipomod());
        }
        if (movementObject.getJimpnomi() != null) {
            movement.setImporteDetalle(movementObject.getJimpnomi());
        } else if (movementObject.getJfeccaduc() != null) {
            movement.setjFechaCaducidad(movementObject.getJfeccaduc());
            movement.setMovementStatus(MovementStatusEnum.EXPIRED);
        }
        if (movementObject.getJnors() != null) {
            movement.setJnors(movementObject.getJnors());
        }
        if (movementObject.getJnuoper() != null) {
            movement.setJnuoper(movementObject.getJnuoper());
        }
        if (movementObject.getCodmon() != null) {
            movement.setJtipomod(movementObject.getCodmon());
        }
        if (movementObject.getDesctipomod() != null) {
            movement.setMoneda(movementObject.getDesctipomod());
        }
        if (movementObject.getNumerosr() != null) {
            movement.setNumerosr(movementObject.getNumerosr());
        }
        if (movementObject.getSeralfab() != null) {
            movement.setSeralfab(movementObject.getSeralfab());
        }
        if (movementObject.getSerieYMandamiento() != null) {
            movement.setSerieYMandamiento(movementObject.getSerieYMandamiento());
        }
        if (movementObject.getJusrhare() != null) {
            movement.setjResponsableAlta(movementObject.getJusrhare());
        }
        if (movementObject.getJusrfirma() != null) {
            movement.setjResponsableFirma(movementObject.getJusrfirma());
        }
        if (movementObject.getJusrfirmeza() != null) {
            movement.setjResponsableFirmeza(movementObject.getJusrfirmeza());
        }
        if (movementObject.getJusrautoriza() != null) {
            movement.setjResponsableAutorizacion(movementObject.getJusrautoriza());
        }
        if (movementObject.getJusrconf() != null) {
            movement.setjResponsableConfirmacion(movementObject.getJusrconf());
        }
        if (movementObject.getJfechare() != null) {
            movement.setJfechare(DateUtils.formatDate(movementObject.getJfechare()));
        }
        if (movementObject.getJfecfirma() != null) {
            movement.setjFechaFirma(DateUtils.formatDate(movementObject.getJfecfirma()));
        }
        if (movementObject.getJfecfirmeza() != null) {
            movement.setjFechaFirmeza(DateUtils.formatDate(movementObject.getJfecfirmeza()));
        }
        if (movementObject.getJfecautoriza() != null) {
            movement.setjFechaAutorizacion(DateUtils.formatDate(movementObject.getJfecautoriza()));
        }
        if (movementObject.getJfecconf() != null) {
            movement.setjFechaConfirmacion(DateUtils.formatDate(movementObject.getJfecconf()));
        }
        if (movementObject.getJfeccaduc() != null) {
            movement.setjFechaCaducidad(DateUtils.formatDate(movementObject.getJfeccaduc()));
        }
        if (!(movementObject.getDatosRepresentante() == null || movementObject.getDatosRepresentante().getGenombre() == null)) {
            movement.setRepresentante(movementObject.getDatosRepresentante().getGenombre());
        }
        if (movementObject.getJnors() != null) {
            movement.setRepresentado(movementObject.getJnors());
        }
        if (movementObject.getConc30() != null) {
            movement.setConcepto(movementObject.getConc30());
        }
        if (!(movementObject.getDatosExpediente() == null || movementObject.getDatosExpediente().getSaldos() == null)) {
            movement.setImporteSaldo(movementObject.getDatosExpediente().getSaldos().getImpsald());
            movement.setFecha(getCurrentDateToShow());
        }
        return movement;
    }

    private static String getVersionFile(Context context) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(context.getAssets().open("configVersionApp")));
            while (true) {
                String readLine = reader2.readLine();
                String mLine = readLine;
                if (readLine != null) {
                    sb.append(mLine);
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                    }
                }
            }
            reader2.close();
        } catch (IOException e2) {
            if (reader != null) {
                reader.close();
            }
        } catch (Throwable th) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e3) {
                }
            }
            throw th;
        }
        return sb.toString();
    }

    public static String validAppVersion(Context context) {
        try {
            JsonNode android = new ObjectMapper().readTree(getVersionFile(context)).path("android");
            if (android.path("blocking").asBoolean()) {
                return android.path("updateMessage").asText();
            }
            return null;
        } catch (IOException e) {
            Log.d("IOException", e.getMessage());
            return null;
        }
    }

    public static String validAppVersion(Context context, String versionFile) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PreferencesHelper.newInstance(context).setBoolean(Constants.PREFERENCE_OLD_LOGIN, mapper.readTree(versionFile).path("locks").path("lockLoginEmpresa").asBoolean());
        } catch (IOException e) {
            Log.d("IOException", e.getMessage());
        }
        try {
            JsonNode android = mapper.readTree(versionFile).path("android");
            if (android.path("versionCode").asInt() > 44) {
                return android.path("updateMessage").asText();
            }
            return null;
        } catch (IOException e2) {
            Log.d("IOException", e2.getMessage());
            return null;
        }
    }

    public static Class<?> getLoginProfesionalesClass(Context context) {
        return LoginProfesionalesActivity.class;
    }

    public static void showVersionAppDialog(final Activity activity, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.go_to_store, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + activity.getPackageName())).addFlags(1208483840));
                } catch (ActivityNotFoundException e) {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + activity.getPackageName())));
                }
            }
        });
        builder.create().show();
    }

    public static void showDeadlyMessage(final Activity activity, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                activity.finish();
            }
        });
        builder.create().show();
    }

    public static void showAlertMessage(Activity activity, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public static void showAlertNoProceedingData(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.text_expedient_detail);
        builder.setMessage(R.string.text_expedient_detail_no_data);
        builder.setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public static boolean validateDocumentNumber(Activity activity, String docType, EditText editText) {
        boolean isvalid = true;
        if (editText != null && !editText.getText().toString().isEmpty()) {
            isvalid = isValidDocument(docType, editText.getText().toString()).booleanValue();
        }
        if (!isvalid) {
            showAlertMessage(activity, activity.getString(R.string.incorrec_document_number));
        }
        return isvalid;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean isValidDocument(java.lang.String r7, java.lang.String r8) {
        /*
            int r0 = r7.hashCode()
            r1 = 67
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r0 == r1) goto L_0x0054
            r1 = 68
            if (r0 == r1) goto L_0x004a
            r1 = 73
            if (r0 == r1) goto L_0x0040
            r1 = 78
            if (r0 == r1) goto L_0x0036
            r1 = 80
            if (r0 == r1) goto L_0x002c
            r1 = 83
            if (r0 == r1) goto L_0x0022
        L_0x0021:
            goto L_0x005e
        L_0x0022:
            java.lang.String r0 = "S"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0021
            r0 = 0
            goto L_0x005f
        L_0x002c:
            java.lang.String r0 = "P"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0021
            r0 = r3
            goto L_0x005f
        L_0x0036:
            java.lang.String r0 = "N"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0021
            r0 = r6
            goto L_0x005f
        L_0x0040:
            java.lang.String r0 = "I"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0021
            r0 = r2
            goto L_0x005f
        L_0x004a:
            java.lang.String r0 = "D"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0021
            r0 = r4
            goto L_0x005f
        L_0x0054:
            java.lang.String r0 = "C"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0021
            r0 = r5
            goto L_0x005f
        L_0x005e:
            r0 = -1
        L_0x005f:
            if (r0 == 0) goto L_0x0087
            if (r0 == r6) goto L_0x007e
            if (r0 == r5) goto L_0x007e
            if (r0 == r4) goto L_0x0075
            if (r0 == r3) goto L_0x0070
            if (r0 == r2) goto L_0x0070
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r6)
            return r0
        L_0x0070:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r6)
            return r0
        L_0x0075:
            boolean r0 = validateDNI(r8)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x007e:
            boolean r0 = validateNIF_NIE(r8)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x0087:
            java.lang.String r0 = r8.toUpperCase()
            boolean r0 = validateCIF(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.utils.CommonUtils.isValidDocument(java.lang.String, java.lang.String):java.lang.Boolean");
    }

    private static boolean validateDNI(String dni) {
        String str = dni;
        String[] allowedLetters = {"T", "R", "W", ActivityDetalleOperacion.CODIGO_ESTADO_A, "G", "M", "Y", ActivityDetalleOperacion.CODIGO_ESTADO_F, ActivityDetalleOperacion.CODIGO_ESTADO_P, "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        if (!str.matches("\\d{8}[a-zA-Z]")) {
            return false;
        }
        double number = Double.parseDouble(str.substring(0, dni.length() - 1));
        return allowedLetters[(int) (number % 23.0d)].equals(str.substring(8, 9).toUpperCase());
    }

    private static boolean validateNIF_NIE(String nif) {
        if (nif.length() != 9) {
            return false;
        }
        String nif2 = nif.toUpperCase();
        String numeroNIF = nif2.substring(0, nif2.length() - 1).replace("X", "0").replace("Y", "1").replace("Z", "2");
        if (isNumeric(numeroNIF) && nif2.charAt(8) == "TRWAGMYFPDXBNJZSQVHLCKE".charAt(Integer.parseInt(numeroNIF) % 23)) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateCIF(String cif) {
        int digito_de_control;
        String str = cif;
        try {
            if (cif.length() != 9) {
                return false;
            }
            char letra_CIF = str.charAt(0);
            if ("ABCDEFGHJPQRSUV".indexOf(letra_CIF) < 0) {
                return false;
            }
            if (Character.isDigit(str.charAt(8))) {
                digito_de_control = Character.getNumericValue(str.charAt(8));
                if ("PQS".indexOf(letra_CIF) >= 0) {
                    digito_de_control = 100;
                }
            } else {
                digito_de_control = "JABCDEFGHI".indexOf(str.charAt(8));
                if ("ABEH".indexOf(letra_CIF) >= 0) {
                    digito_de_control = 100;
                }
            }
            int a = 0;
            int b = 0;
            byte[] impares = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
            for (int t = 1; t <= 6; t += 2) {
                a += Character.getNumericValue(str.charAt(t + 1));
                b += impares[Character.getNumericValue(str.charAt(t))];
            }
            return 10 - ((a + (b + impares[Character.getNumericValue(str.charAt(7))])) % 10) == digito_de_control;
        } catch (Exception e) {
            return false;
        }
    }

    public static String capitalize(String text) {
        try {
            return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
        } catch (Exception e) {
            return text;
        }
    }

    public static String wordCapitalize(String words) {
        String str = "";
        boolean isCap = false;
        for (int i = 0; i < words.length(); i++) {
            if (isCap) {
                str = str + words.toUpperCase().charAt(i);
            } else if (i == 0) {
                str = str + words.toUpperCase().charAt(i);
            } else {
                str = str + words.toLowerCase().charAt(i);
            }
            if (words.charAt(i) == ' ') {
                isCap = true;
            } else {
                isCap = false;
            }
        }
        return str;
    }

    public static String getProceedingFormatted(String proceeding) {
        try {
            return proceeding.substring(0, 4) + " " + proceeding.substring(4, 8) + " " + proceeding.substring(8, 10) + " " + proceeding.substring(10, 14) + " " + proceeding.substring(14, 16);
        } catch (Exception e) {
            return proceeding;
        }
    }

    public static String getCurrencySymbol(String name) {
        String symbol = name;
        if ("EUR".equalsIgnoreCase(symbol)) {
            return "€";
        }
        if ("USD".equalsIgnoreCase(symbol)) {
            return "$";
        }
        return symbol;
    }
}
