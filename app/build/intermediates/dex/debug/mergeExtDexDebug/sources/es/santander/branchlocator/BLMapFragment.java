package es.santander.branchlocator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.SupportMapFragment;

public class BLMapFragment extends SupportMapFragment {
    public View mOriginalContentView;
    public BLTouchableWrapper mTouchView;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        this.mOriginalContentView = BLMapFragment.super.onCreateView(inflater, parent, savedInstanceState);
        BLTouchableWrapper bLTouchableWrapper = new BLTouchableWrapper(getActivity());
        this.mTouchView = bLTouchableWrapper;
        bLTouchableWrapper.addView(this.mOriginalContentView);
        return this.mTouchView;
    }

    public View getView() {
        return this.mOriginalContentView;
    }
}
