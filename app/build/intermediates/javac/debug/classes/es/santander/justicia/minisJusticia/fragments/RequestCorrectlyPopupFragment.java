package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import es.santander.justicia.minisJusticia.fragments.RequestCorrectlyPopupFragment.1;
import es.santander.justicia.minisJusticia.fragments.RequestCorrectlyPopupFragment.2;
import es.santander.justicia.minisJusticia.tasks.PetitionsListTask;

public class RequestCorrectlyPopupFragment extends Fragment {
   private ImageView closeButton;
   private Context context;

   public static RequestCorrectlyPopupFragment newInstance() {
      RequestCorrectlyPopupFragment fragment = new RequestCorrectlyPopupFragment();
      return fragment;
   }

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = this.getActivity().getBaseContext();
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(2131558576, container, false);
      view.setOnClickListener(new 1(this));
      return view;
   }

   public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      this.closeButton = (ImageView)view.findViewById(2131362344);
   }

   public void onActivityCreated(@Nullable Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);
      this.closeButton.setOnClickListener(new 2(this));
   }

   private void showRequestList() {
      PetitionsListTask listPetitions = new PetitionsListTask(this.getActivity());
      listPetitions.execute(new Object[0]);
   }

   // $FF: synthetic method
   static void access$000(RequestCorrectlyPopupFragment x0) {
      x0.showRequestList();
   }
}
