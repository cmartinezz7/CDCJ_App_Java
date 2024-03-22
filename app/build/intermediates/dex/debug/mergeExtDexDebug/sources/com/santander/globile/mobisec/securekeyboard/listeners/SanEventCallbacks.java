package com.santander.globile.mobisec.securekeyboard.listeners;

import com.santander.globile.mobisec.securekeyboard.SanKeyboardView;

public interface SanEventCallbacks {
    void onSanKeyboardHidden(SanKeyboardView sanKeyboardView);

    void onSanKeyboardReady(SanKeyboardView sanKeyboardView);

    void onSanKeyboardShown(SanKeyboardView sanKeyboardView);
}
