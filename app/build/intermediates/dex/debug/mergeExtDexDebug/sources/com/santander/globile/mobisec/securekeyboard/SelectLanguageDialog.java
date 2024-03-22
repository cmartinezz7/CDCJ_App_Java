package com.santander.globile.mobisec.securekeyboard;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.santander.globile.mobisec.securekeyboard.enums.InputLanguage;
import com.santander.globile.mobisec.securekeyboard.keyboard.SanKeyboardManager;
import com.santander.globile.mobisec.securekeyboard.utils.SanKeyboardUtils;

public class SelectLanguageDialog {
    private SelectLanguageDialog() {
    }

    static void showSelectLanguageDialog(Activity activity, InputLanguage currentLanguage, DialogInterface.OnClickListener onPositiveClickListener, DialogInterface.OnDismissListener onDismissListener) {
        if (SanKeyboardManager.getPossibleLanguages().length >= 2 || activity != null) {
            AlertDialog alertDialog = new AlertDialog.Builder(activity).setTitle(activity.getString(R.string.securekeyboard_title_select_keyboard_language)).setSingleChoiceItems(getSingleChoiceItems(activity, currentLanguage), currentLanguage.ordinal(), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int selectedIndex) {
                }
            }).setPositiveButton(activity.getString(R.string.securekeyboard_OK), onPositiveClickListener).setNegativeButton(activity.getString(R.string.securekeyboard_cancel), (DialogInterface.OnClickListener) null).create();
            alertDialog.setOnDismissListener(onDismissListener);
            alertDialog.show();
        }
    }

    private static String[] getSingleChoiceItems(Activity activity, InputLanguage currentLanguage) {
        String[] singleChoiceItems = new String[InputLanguage.values().length];
        Context contextLocalized = SanKeyboardUtils.getContextForLocale(activity, currentLanguage.getLocale());
        for (int i = 0; i < InputLanguage.values().length; i++) {
            singleChoiceItems[i] = InputLanguage.values()[i].getText(contextLocalized.getResources());
        }
        return singleChoiceItems;
    }
}
