package es.santander.justicia.minisJusticia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import es.santander.justicia.R;

public class FragmentDetailMovTimeline extends Fragment {
    public static FragmentDetailMovTimeline newInstance() {
        return new FragmentDetailMovTimeline();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (ViewGroup) inflater.inflate(R.layout.fragment_detail_mov_timeline, container, false);
    }
}
