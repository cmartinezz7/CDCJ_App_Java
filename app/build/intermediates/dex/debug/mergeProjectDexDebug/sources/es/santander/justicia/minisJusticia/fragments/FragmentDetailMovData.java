package es.santander.justicia.minisJusticia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import es.santander.justicia.R;

public class FragmentDetailMovData extends Fragment {
    public static FragmentDetailMovData newInstance() {
        return new FragmentDetailMovData();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (ViewGroup) inflater.inflate(R.layout.fragment_detail_move_data, container, false);
    }
}
