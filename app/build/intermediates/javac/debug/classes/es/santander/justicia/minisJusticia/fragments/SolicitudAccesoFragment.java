package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import es.santander.justicia.minisJusticia.fragments.SolicitudAccesoFragment.1;

public class SolicitudAccesoFragment extends Fragment {
   private Context context;
   private EditText field1;
   private EditText field2;
   private EditText field3;
   private EditText field4;
   private EditText field5;
   private Spinner motive;
   private Button sendButton;

   public static SolicitudAccesoFragment newInstance() {
      SolicitudAccesoFragment fragment = new SolicitudAccesoFragment();
      return fragment;
   }

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = this.getActivity().getBaseContext();
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(2131558577, container, false);
      return view;
   }

   public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      this.field1 = (EditText)view.findViewById(2131362153);
      this.field2 = (EditText)view.findViewById(2131362154);
      this.field3 = (EditText)view.findViewById(2131362155);
      this.field4 = (EditText)view.findViewById(2131362156);
      this.field5 = (EditText)view.findViewById(2131362157);
      this.motive = (Spinner)view.findViewById(2131362714);
      this.sendButton = (Button)view.findViewById(2131361962);
   }

   public void onActivityCreated(@Nullable Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);
      this.sendButton.setOnClickListener(new 1(this));
   }

   // $FF: synthetic method
   static Context access$000(SolicitudAccesoFragment x0) {
      return x0.context;
   }
}
