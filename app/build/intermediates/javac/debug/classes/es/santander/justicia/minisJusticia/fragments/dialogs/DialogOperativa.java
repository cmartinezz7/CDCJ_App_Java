package es.santander.justicia.minisJusticia.fragments.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.views.QTextView;

public class DialogOperativa extends DialogFragment {
   private static final String SHOW_MOTVE = "show_motive";
   private static final String BUTTON_TEXT_RESOURCE = "button_text_resource";
   private static final String POSITION = "position";
   private DialogSolicitudCalback mListener;

   public static DialogOperativa newInstance(boolean showMotive, int buttonTextResource, int position) {
      DialogOperativa dialogOperativa = new DialogOperativa();
      Bundle bundle = new Bundle();
      bundle.putBoolean("show_motive", showMotive);
      bundle.putInt("button_text_resource", buttonTextResource);
      bundle.putInt("position", position);
      dialogOperativa.setArguments(bundle);
      return dialogOperativa;
   }

   @Nullable
   public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View rootView = inflater.inflate(2131558713, container, false);
      ((QTextView)rootView.findViewById(2131362928)).setText(this.getArguments().getString("button_text_resource"));
      ((QTextView)rootView.findViewById(2131362928)).setText(this.getArguments().getString("button_text_resource"));
      rootView.findViewById(2131362297).setVisibility(this.getArguments().getBoolean("show_motive") ? 0 : 8);
      return rootView;
   }

   public void onAttach(Context context) {
      super.onAttach(context);
      Fragment parentFragment = this.getParentFragment();
      if (parentFragment != null && parentFragment instanceof DialogSolicitudCalback) {
         this.mListener = (DialogSolicitudCalback)parentFragment;
      } else if (context instanceof DialogSolicitudCalback) {
         this.mListener = (DialogSolicitudCalback)context;
      } else {
         if (!(this.getChildFragmentManager() instanceof DialogSolicitudCalback)) {
            throw new RuntimeException("Sorry man, debes implementar la interfaz " + DialogSolicitudCalback.class.getSimpleName() + " para poder hacer algo");
         }

         this.mListener = (DialogSolicitudCalback)this.getChildFragmentManager();
      }

   }

   public Dialog onCreateDialog(Bundle savedInstanceState) {
      Dialog retVal = new Dialog(this.getActivity(), 2131951969);
      return retVal;
   }
}
