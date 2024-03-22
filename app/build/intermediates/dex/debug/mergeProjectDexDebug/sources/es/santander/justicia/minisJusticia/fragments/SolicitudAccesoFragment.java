package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.fragment.app.Fragment;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.PopupActivity;
import es.santander.justicia.minisJusticia.enums.PopupTypeEnum;
import es.santander.justicia.utils.Constants;

public class SolicitudAccesoFragment extends Fragment {
    /* access modifiers changed from: private */
    public Context context;
    private EditText field1;
    private EditText field2;
    private EditText field3;
    private EditText field4;
    private EditText field5;
    private Spinner motive;
    private Button sendButton;

    public static SolicitudAccesoFragment newInstance() {
        return new SolicitudAccesoFragment();
    }

    public void onCreate(Bundle savedInstanceState) {
        SolicitudAccesoFragment.super.onCreate(savedInstanceState);
        this.context = getActivity().getBaseContext();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_solicitud_de_acceso, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        SolicitudAccesoFragment.super.onViewCreated(view, savedInstanceState);
        this.field1 = (EditText) view.findViewById(R.id.et_field_1);
        this.field2 = (EditText) view.findViewById(R.id.et_field_2);
        this.field3 = (EditText) view.findViewById(R.id.et_field_3);
        this.field4 = (EditText) view.findViewById(R.id.et_field_4);
        this.field5 = (EditText) view.findViewById(R.id.et_field_5);
        this.motive = (Spinner) view.findViewById(R.id.sp_motive);
        this.sendButton = (Button) view.findViewById(R.id.btn_send);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        SolicitudAccesoFragment.super.onActivityCreated(savedInstanceState);
        this.sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent popup = new Intent(SolicitudAccesoFragment.this.context, PopupActivity.class);
                popup.putExtra(Constants.POPUP_NAME, PopupTypeEnum.ACCESS_REQUEST_SENT_CORRECTLY.getId());
                SolicitudAccesoFragment.this.startActivity(popup);
            }
        });
    }
}
