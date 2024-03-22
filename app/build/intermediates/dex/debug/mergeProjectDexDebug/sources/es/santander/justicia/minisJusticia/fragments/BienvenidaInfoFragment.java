package es.santander.justicia.minisJusticia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import es.santander.justicia.R;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.FontsUtil;

public class BienvenidaInfoFragment extends Fragment {
    private TextView tvRow1;
    private TextView tvRow2;
    private TextView tvRow4;

    public static BienvenidaInfoFragment newInstance() {
        return new BienvenidaInfoFragment();
    }

    public void onCreate(Bundle savedInstanceState) {
        BienvenidaInfoFragment.super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bienvenida_info, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        BienvenidaInfoFragment.super.onViewCreated(view, savedInstanceState);
        this.tvRow1 = (TextView) view.findViewById(R.id.tv_row1);
        this.tvRow2 = (TextView) view.findViewById(R.id.tv_row2);
        this.tvRow4 = (TextView) view.findViewById(R.id.tv_row4);
        FontsUtil.changeFont(getContext(), this.tvRow1, Constants.FIRASANS_MEDIUM);
        FontsUtil.changeFont(getContext(), this.tvRow2, Constants.FIRASANS_MEDIUM);
        FontsUtil.changeFont(getContext(), this.tvRow4, Constants.FIRASANS_MEDIUM);
    }
}
