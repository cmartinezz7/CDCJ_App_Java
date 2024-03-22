package es.santander.justicia.minisJusticia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;

public class FragmentHelp extends ActivityHomeLetrados.PlaceholderFragment {
    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/ayuda");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_help, container, false);
        initUi(rootView);
        return rootView;
    }

    private void initUi(ViewGroup rootView) {
        String value = KeyValueModel.getInstance().getValue(KeyValueModel.AYUDA_INFO, "letrados.superlinea1");
        if (CommonUtils.isNotNullNotBlack(value)) {
            ((QTextView) rootView.findViewById(R.id.QTextView2)).setText(value);
        }
        String value2 = KeyValueModel.getInstance().getValue(KeyValueModel.AYUDA_INFO, "letrados.superlinea2");
        if (CommonUtils.isNotNullNotBlack(value)) {
            ((QTextView) rootView.findViewById(R.id.QTextView3)).setText(value2);
        }
    }
}
