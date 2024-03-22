package com.santander.globile.mobisec.securekeyboard.aosp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import com.santander.globile.mobisec.securekeyboard.R;
import java.util.ArrayList;

public class RowAOSP {
    public int defaultHeight;
    public int defaultHorizontalGap;
    public int defaultWidth;
    ArrayList<KeyAOSP> mKeys = new ArrayList<>();
    public int mode;
    private KeyboardAOSP parent;
    public int rowEdgeFlags;
    public int verticalGap;

    public RowAOSP(KeyboardAOSP parent2) {
        this.parent = parent2;
    }

    public RowAOSP(Resources res, KeyboardAOSP parent2, XmlResourceParser parser) {
        this.parent = parent2;
        TypedArray a = res.obtainAttributes(Xml.asAttributeSet(parser), R.styleable.KeyboardAOSP);
        this.defaultWidth = KeyboardAOSP.getDimensionOrFraction(a, R.styleable.KeyboardAOSP_keyWidth, parent2.getmDisplayWidth(), parent2.getmDefaultWidth());
        this.defaultHeight = KeyboardAOSP.getDimensionOrFraction(a, R.styleable.KeyboardAOSP_keyHeight, parent2.getmDisplayHeight(), parent2.getmDefaultHeight());
        this.defaultHorizontalGap = KeyboardAOSP.getDimensionOrFraction(a, R.styleable.KeyboardAOSP_horizontalGap, parent2.getmDisplayWidth(), parent2.getHorizontalGap());
        this.verticalGap = KeyboardAOSP.getDimensionOrFraction(a, R.styleable.KeyboardAOSP_verticalGap, parent2.getmDisplayHeight(), parent2.getVerticalGap());
        a.recycle();
        TypedArray a2 = res.obtainAttributes(Xml.asAttributeSet(parser), R.styleable.Keyboard_Row);
        this.rowEdgeFlags = a2.getInt(R.styleable.Keyboard_Row_rowEdgeFlags, 0);
        this.mode = a2.getResourceId(R.styleable.Keyboard_Row_keyboardMode, 0);
    }

    public KeyboardAOSP getParent() {
        return this.parent;
    }
}
