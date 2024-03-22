package es.santander.justicia.minisJusticia.fragments.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.views.QTextView;

public class DialogOperativa extends DialogFragment {
    private static final String BUTTON_TEXT_RESOURCE = "button_text_resource";
    private static final String POSITION = "position";
    private static final String SHOW_MOTVE = "show_motive";
    private DialogSolicitudCalback mListener;

    public static DialogOperativa newInstance(boolean showMotive, int buttonTextResource, int position) {
        DialogOperativa dialogOperativa = new DialogOperativa();
        Bundle bundle = new Bundle();
        bundle.putBoolean(SHOW_MOTVE, showMotive);
        bundle.putInt(BUTTON_TEXT_RESOURCE, buttonTextResource);
        bundle.putInt("position", position);
        dialogOperativa.setArguments(bundle);
        return dialogOperativa;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i = 0;
        View rootView = inflater.inflate(R.layout.popup_motivo_solicitud, container, false);
        ((QTextView) rootView.findViewById(R.id.text_title_state)).setText(getArguments().getString(BUTTON_TEXT_RESOURCE));
        ((QTextView) rootView.findViewById(R.id.text_title_state)).setText(getArguments().getString(BUTTON_TEXT_RESOURCE));
        View findViewById = rootView.findViewById(R.id.image_close_popup);
        if (!getArguments().getBoolean(SHOW_MOTVE)) {
            i = 8;
        }
        findViewById.setVisibility(i);
        return rootView;
    }

    public void onAttach(Context context) {
        DialogOperativa.super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (parentFragment instanceof DialogSolicitudCalback)) {
            this.mListener = (DialogSolicitudCalback) parentFragment;
        } else if (context instanceof DialogSolicitudCalback) {
            this.mListener = (DialogSolicitudCalback) context;
        } else if (getChildFragmentManager() instanceof DialogSolicitudCalback) {
            this.mListener = getChildFragmentManager();
        } else {
            throw new RuntimeException("Sorry man, debes implementar la interfaz " + DialogSolicitudCalback.class.getSimpleName() + " para poder hacer algo");
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new Dialog(getActivity(), R.style.DialogGlobal);
    }
}
