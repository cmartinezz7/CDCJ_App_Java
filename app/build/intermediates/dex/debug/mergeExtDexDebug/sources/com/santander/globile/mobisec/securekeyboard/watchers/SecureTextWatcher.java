package com.santander.globile.mobisec.securekeyboard.watchers;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class SecureTextWatcher implements TextWatcher {
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void afterTextChanged(Editable s) {
    }
}
