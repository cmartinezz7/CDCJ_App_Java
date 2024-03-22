package es.santander.justicia.minisJusticia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import es.santander.justicia.utils.FontsUtil;

public class BienvenidaInfoFragment extends Fragment {
   private TextView tvRow1;
   private TextView tvRow2;
   private TextView tvRow4;

   public static BienvenidaInfoFragment newInstance() {
      BienvenidaInfoFragment fragment = new BienvenidaInfoFragment();
      return fragment;
   }

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      return inflater.inflate(2131558567, container, false);
   }

   public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      this.tvRow1 = (TextView)view.findViewById(2131363041);
      this.tvRow2 = (TextView)view.findViewById(2131363042);
      this.tvRow4 = (TextView)view.findViewById(2131363043);
      FontsUtil.changeFont(this.getContext(), this.tvRow1, "FiraSans-Medium.ttf");
      FontsUtil.changeFont(this.getContext(), this.tvRow2, "FiraSans-Medium.ttf");
      FontsUtil.changeFont(this.getContext(), this.tvRow4, "FiraSans-Medium.ttf");
   }
}
