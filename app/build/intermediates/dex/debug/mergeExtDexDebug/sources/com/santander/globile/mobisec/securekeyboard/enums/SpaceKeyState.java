package com.santander.globile.mobisec.securekeyboard.enums;

import com.santander.globile.mobisec.securekeyboard.R;
import java.util.Arrays;

public enum SpaceKeyState {
    NORMAL(R.drawable.keyboard_key_space_background_normal),
    PRESSED(R.drawable.keyboard_key_space_background_pressed);
    
    private final int drawableResId;

    private SpaceKeyState(int drawableResId2) {
        this.drawableResId = drawableResId2;
    }

    public int getDrawableResId() {
        return this.drawableResId;
    }

    public int getIndex() {
        return Arrays.binarySearch(values(), this);
    }
}
