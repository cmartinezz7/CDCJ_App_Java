package es.santander.justicia.minisJusticia.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.FontsUtil;

public class BienvenidaSeleccionFragment extends Fragment {
    private Activity activity;
    private Button letradoPerfilButton;
    private Button profesionalPerfilButton;
    private TextView tvContinuar;

    public static BienvenidaSeleccionFragment newInstance() {
        return new BienvenidaSeleccionFragment();
    }

    public void onCreate(Bundle savedInstanceState) {
        BienvenidaSeleccionFragment.super.onCreate(savedInstanceState);
        this.activity = getActivity();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bienvenida_seleccion, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        BienvenidaSeleccionFragment.super.onViewCreated(view, savedInstanceState);
        this.profesionalPerfilButton = (Button) view.findViewById(R.id.btn_profesional_perfil);
        this.letradoPerfilButton = (Button) view.findViewById(R.id.btn_letrado_perfil);
        this.tvContinuar = (TextView) view.findViewById(R.id.textView13);
        view.findViewById(R.id.tv_welcome).setVisibility(4);
        FontsUtil.changeFont(getContext(), this.tvContinuar, Constants.FIRASANS_MEDIUM);
        this.profesionalPerfilButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(BienvenidaSeleccionFragment.this.getActivity());
                progressDialog.setCancelable(false);
                progressDialog.setMessage(BienvenidaSeleccionFragment.this.getString(2131886514));
                progressDialog.show();
                KeyValueModel.getInstancePermanent().insertValue(KeyValueModel.PROFESIONAL_LETRADO_SELECCION, "", ActivityDetalleOperacion.CODIGO_ESTADO_P);
                BienvenidaSeleccionFragment.this.startActivity(new Intent(BienvenidaSeleccionFragment.this.getActivity().getBaseContext(), NewsActivity.class));
                BienvenidaSeleccionFragment.this.getActivity().finish();
            }
        });
        this.letradoPerfilButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(BienvenidaSeleccionFragment.this.getActivity());
                progressDialog.setCancelable(false);
                progressDialog.setMessage(BienvenidaSeleccionFragment.this.getString(2131886514));
                progressDialog.show();
                KeyValueModel.getInstancePermanent().insertValue(KeyValueModel.PROFESIONAL_LETRADO_SELECCION, "", "L");
                BienvenidaSeleccionFragment.this.startActivity(new Intent(BienvenidaSeleccionFragment.this.getActivity().getBaseContext(), NewsActivity.class));
                BienvenidaSeleccionFragment.this.getActivity().finish();
            }
        });
    }
}
