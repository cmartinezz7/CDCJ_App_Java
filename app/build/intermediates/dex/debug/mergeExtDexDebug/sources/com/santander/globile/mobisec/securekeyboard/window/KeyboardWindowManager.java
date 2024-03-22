package com.santander.globile.mobisec.securekeyboard.window;

import android.view.Window;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

public class KeyboardWindowManager {
    private boolean areFlagsInitiatedForShowingKeyboard;
    private Window currentWindow;
    private boolean isAutoFillShown = false;
    private boolean isWindowDrawSystemBarBackgrounds;
    private boolean isWindowTranslucentNavigationFlag;
    private boolean isWindowTranslucentStatusFlag;
    private int windowDecorViewSystemUiVisibility;

    KeyboardWindowManager(Window currentWindow2) {
        this.currentWindow = currentWindow2;
        this.areFlagsInitiatedForShowingKeyboard = false;
    }

    /* access modifiers changed from: package-private */
    public Window getManagedWindow() {
        return this.currentWindow;
    }

    public boolean isAutoFillShown() {
        return this.isAutoFillShown;
    }

    public void setAutoFillShown(boolean autoFillShown) {
        this.isAutoFillShown = autoFillShown;
    }

    public void initFlagsForShowingKeyboard() {
        if (!this.areFlagsInitiatedForShowingKeyboard) {
            backupOriginalFlags();
            if (this.isWindowTranslucentNavigationFlag) {
                this.currentWindow.clearFlags(134217728);
                if (!this.isWindowTranslucentStatusFlag) {
                    this.currentWindow.addFlags(Integer.MIN_VALUE);
                    this.currentWindow.getDecorView().setSystemUiVisibility(LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY);
                }
            }
            this.areFlagsInitiatedForShowingKeyboard = true;
        }
    }

    public void restoreOriginalFlags() {
        if (this.areFlagsInitiatedForShowingKeyboard) {
            restoreFlag(134217728, this.isWindowTranslucentNavigationFlag);
            restoreFlag(67108864, this.isWindowTranslucentStatusFlag);
            restoreFlag(Integer.MIN_VALUE, this.isWindowDrawSystemBarBackgrounds);
            this.currentWindow.getDecorView().setSystemUiVisibility(this.windowDecorViewSystemUiVisibility);
            this.areFlagsInitiatedForShowingKeyboard = false;
        }
    }

    private void restoreFlag(int flag, boolean newValue) {
        if (newValue) {
            this.currentWindow.addFlags(flag);
        } else {
            this.currentWindow.clearFlags(flag);
        }
    }

    private void backupOriginalFlags() {
        boolean z = true;
        this.isWindowTranslucentNavigationFlag = (this.currentWindow.getAttributes().flags & 134217728) != 0;
        this.isWindowTranslucentStatusFlag = (this.currentWindow.getAttributes().flags & 67108864) != 0;
        if ((this.currentWindow.getAttributes().flags & Integer.MIN_VALUE) == 0) {
            z = false;
        }
        this.isWindowDrawSystemBarBackgrounds = z;
        this.windowDecorViewSystemUiVisibility = this.currentWindow.getDecorView().getSystemUiVisibility();
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        this.currentWindow = null;
    }
}
