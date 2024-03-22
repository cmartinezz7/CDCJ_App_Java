package es.santander.justicia.minisJusticia.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class GmapFragment extends Fragment implements OnMapReadyCallback {
   @Nullable
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      return inflater.inflate(2131558573, container, false);
   }

   public void onViewCreated(View view, Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      MapFragment fragment = (MapFragment)this.getChildFragmentManager().findFragmentById(2131362460);
      fragment.getMapAsync(this);
   }

   public void onMapReady(GoogleMap googleMap) {
   }
}
