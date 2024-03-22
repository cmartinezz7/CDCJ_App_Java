package es.santander.justicia.minisJusticia.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import es.santander.justicia.R;

public class GmapFragment extends Fragment implements OnMapReadyCallback {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gmaps, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getChildFragmentManager().findFragmentById(2131362460).getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
    }
}
