package com.santander.globile.mobisec.securekeyboard.watchers;

import com.santander.globile.mobisec.securekeyboard.BaseSecureEditText;
import java.lang.ref.WeakReference;

public class NotEmptyTextWatcher extends SecureTextWatcher {
    private final int keycode;
    private final WeakReference<BaseSecureEditText> weakSecureEditText;

    public NotEmptyTextWatcher(int keycode2, BaseSecureEditText sanEditText) {
        this.keycode = keycode2;
        this.weakSecureEditText = new WeakReference<>(sanEditText);
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (this.weakSecureEditText.get() != null) {
            ((BaseSecureEditText) this.weakSecureEditText.get()).enableDisableCustomKey(this.keycode, s.length() > 0);
        }
    }
}
