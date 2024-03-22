package com.santander.globile.mobisec.securekeyboard.enums;

import com.santander.globile.mobisec.securekeyboard.R;
import java.util.Arrays;

public enum ShiftMode {
    LOWER_CASE(R.drawable.key_shift_default),
    UPPER_CASE_SINGLE(R.drawable.key_shift_upper),
    UPPER_CASE_CONTINUOUS(R.drawable.key_shift_upper_perm);
    
    private final int drawableResId;

    private ShiftMode(int drawableResId2) {
        this.drawableResId = drawableResId2;
    }

    public int getDrawableResId() {
        return this.drawableResId;
    }

    public ShiftMode getNext() {
        int index = Arrays.binarySearch(values(), this);
        return index < values().length + -1 ? values()[index + 1] : values()[0];
    }
}
