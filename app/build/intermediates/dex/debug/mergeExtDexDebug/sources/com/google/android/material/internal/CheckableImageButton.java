package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = {16842912};
    private boolean checkable;
    private boolean checked;
    private boolean pressable;

    public CheckableImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public CheckableImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.imageButtonStyle);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.google.android.material.internal.CheckableImageButton, android.view.View] */
    public CheckableImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.checkable = true;
        this.pressable = true;
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                CheckableImageButton.super.onInitializeAccessibilityEvent(host, event);
                event.setChecked(CheckableImageButton.this.isChecked());
            }

            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                CheckableImageButton.super.onInitializeAccessibilityNodeInfo(host, info);
                info.setCheckable(CheckableImageButton.this.isCheckable());
                info.setChecked(CheckableImageButton.this.isChecked());
            }
        });
    }

    public void setChecked(boolean checked2) {
        if (this.checkable && this.checked != checked2) {
            this.checked = checked2;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void toggle() {
        setChecked(!this.checked);
    }

    public void setPressed(boolean pressed) {
        if (this.pressable) {
            CheckableImageButton.super.setPressed(pressed);
        }
    }

    public int[] onCreateDrawableState(int extraSpace) {
        if (!this.checked) {
            return CheckableImageButton.super.onCreateDrawableState(extraSpace);
        }
        int[] iArr = DRAWABLE_STATE_CHECKED;
        return mergeDrawableStates(CheckableImageButton.super.onCreateDrawableState(iArr.length + extraSpace), iArr);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.os.Parcelable, com.google.android.material.internal.CheckableImageButton$SavedState] */
    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        ? savedState = new SavedState(CheckableImageButton.super.onSaveInstanceState());
        savedState.checked = this.checked;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            CheckableImageButton.super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        CheckableImageButton.super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    public void setCheckable(boolean checkable2) {
        if (this.checkable != checkable2) {
            this.checkable = checkable2;
            sendAccessibilityEvent(0);
        }
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void setPressable(boolean pressable2) {
        this.pressable = pressable2;
    }

    public boolean isPressable() {
        return this.pressable;
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, (ClassLoader) null);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        boolean checked;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public SavedState(Parcel source, ClassLoader loader) {
            super(source, loader);
            readFromParcel(source);
        }

        public void writeToParcel(Parcel out, int flags) {
            CheckableImageButton.super.writeToParcel(out, flags);
            out.writeInt(this.checked ? 1 : 0);
        }

        private void readFromParcel(Parcel in) {
            boolean z = true;
            if (in.readInt() != 1) {
                z = false;
            }
            this.checked = z;
        }
    }
}
