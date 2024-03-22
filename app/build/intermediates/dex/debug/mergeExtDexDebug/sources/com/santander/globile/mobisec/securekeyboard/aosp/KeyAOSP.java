package com.santander.globile.mobisec.securekeyboard.aosp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.santander.globile.mobisec.securekeyboard.R;
import java.util.StringTokenizer;

public class KeyAOSP {
    private static final int[] KEY_STATE_NORMAL = new int[0];
    private static final int[] KEY_STATE_NORMAL_OFF = {16842911};
    private static final int[] KEY_STATE_NORMAL_ON = {16842911, 16842912};
    private static final int[] KEY_STATE_PRESSED = {16842919};
    private static final int[] KEY_STATE_PRESSED_OFF = {16842919, 16842911};
    private static final int[] KEY_STATE_PRESSED_ON = {16842919, 16842911, 16842912};
    public int[] codes;
    public int edgeFlags;
    public int gap;
    public int height;
    public Drawable icon;
    public Drawable iconPreview;
    private KeyboardAOSP keyboard;
    public CharSequence label;
    public boolean modifier;
    public boolean on;
    public CharSequence popupCharacters;
    public int popupResId;
    public boolean pressed;
    public boolean repeatable;
    public boolean sticky;
    public CharSequence text;
    public int width;
    public int x;
    public int y;

    public KeyAOSP(RowAOSP parent) {
        this.keyboard = parent.getParent();
        this.height = parent.defaultHeight;
        this.width = parent.defaultWidth;
        this.gap = parent.defaultHorizontalGap;
        this.edgeFlags = parent.rowEdgeFlags;
    }

    public KeyAOSP(Resources res, RowAOSP parent, int x2, int y2, XmlResourceParser parser) {
        this(parent);
        this.x = x2;
        this.y = y2;
        TypedArray a = res.obtainAttributes(Xml.asAttributeSet(parser), R.styleable.KeyboardAOSP);
        this.width = KeyboardAOSP.getDimensionOrFraction(a, R.styleable.KeyboardAOSP_keyWidth, this.keyboard.getmDisplayWidth(), parent.defaultWidth);
        this.height = KeyboardAOSP.getDimensionOrFraction(a, R.styleable.KeyboardAOSP_keyHeight, this.keyboard.getmDisplayHeight(), parent.defaultHeight);
        this.gap = KeyboardAOSP.getDimensionOrFraction(a, R.styleable.KeyboardAOSP_horizontalGap, this.keyboard.getmDisplayWidth(), parent.defaultHorizontalGap);
        a.recycle();
        TypedArray a2 = res.obtainAttributes(Xml.asAttributeSet(parser), R.styleable.Keyboard_Key);
        this.x += this.gap;
        TypedValue codesValue = new TypedValue();
        a2.getValue(R.styleable.Keyboard_Key_codes, codesValue);
        if (codesValue.type == 16 || codesValue.type == 17) {
            this.codes = new int[]{codesValue.data};
        } else if (codesValue.type == 3) {
            this.codes = parseCSV(codesValue.string.toString());
        }
        Drawable drawable = a2.getDrawable(R.styleable.Keyboard_Key_iconPreview);
        this.iconPreview = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.iconPreview.getIntrinsicHeight());
        }
        this.popupCharacters = a2.getText(R.styleable.Keyboard_Key_popupCharacters);
        this.popupResId = a2.getResourceId(R.styleable.Keyboard_Key_popupKeyboard, 0);
        this.repeatable = a2.getBoolean(R.styleable.Keyboard_Key_isRepeatable, false);
        this.modifier = a2.getBoolean(R.styleable.Keyboard_Key_isModifier, false);
        this.sticky = a2.getBoolean(R.styleable.Keyboard_Key_isSticky, false);
        int i = a2.getInt(R.styleable.Keyboard_Key_keyEdgeFlags, 0);
        this.edgeFlags = i;
        this.edgeFlags = i | parent.rowEdgeFlags;
        Drawable drawable2 = a2.getDrawable(R.styleable.Keyboard_Key_keyIcon);
        this.icon = drawable2;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.icon.getIntrinsicHeight());
        }
        this.label = a2.getText(R.styleable.Keyboard_Key_keyLabel);
        this.text = a2.getText(R.styleable.Keyboard_Key_keyOutputText);
        if (this.codes == null && !TextUtils.isEmpty(this.label)) {
            this.codes = new int[]{this.label.charAt(0)};
        }
        a2.recycle();
    }

    public void onPressed() {
        this.pressed = !this.pressed;
    }

    public void onReleased(boolean inside) {
        this.pressed = !this.pressed;
        if (this.sticky && inside) {
            this.on = !this.on;
        }
    }

    /* access modifiers changed from: package-private */
    public int[] parseCSV(String value) {
        int count = 0;
        int lastIndex = 0;
        if (value.length() > 0) {
            while (true) {
                count++;
                int indexOf = value.indexOf(",", lastIndex + 1);
                lastIndex = indexOf;
                if (indexOf <= 0) {
                    break;
                }
            }
        }
        int[] values = new int[count];
        int count2 = 0;
        StringTokenizer st = new StringTokenizer(value, ",");
        while (st.hasMoreTokens()) {
            int count3 = count2 + 1;
            try {
                values[count2] = Integer.parseInt(st.nextToken());
            } catch (NumberFormatException e) {
                Log.e("Keyboard", "Error parsing keycodes " + value);
            }
            count2 = count3;
        }
        return values;
    }

    public boolean isInside(int x2, int y2) {
        int i;
        int i2 = this.edgeFlags;
        boolean leftEdge = (i2 & 1) > 0;
        boolean rightEdge = (i2 & 2) > 0;
        boolean topEdge = (i2 & 4) > 0;
        boolean bottomEdge = (i2 & 8) > 0;
        int i3 = this.x;
        return (x2 >= i3 || (leftEdge && x2 <= this.width + i3)) && (x2 < this.width + i3 || (rightEdge && x2 >= i3)) && ((y2 >= (i = this.y) || (topEdge && y2 <= this.height + i)) && (y2 < this.height + i || (bottomEdge && y2 >= i)));
    }

    public int squaredDistanceFrom(int x2, int y2) {
        int xDist = (this.x + (this.width / 2)) - x2;
        int yDist = (this.y + (this.height / 2)) - y2;
        return (xDist * xDist) + (yDist * yDist);
    }

    public int[] getCurrentDrawableState() {
        int[] states = KEY_STATE_NORMAL;
        if (this.on) {
            if (this.pressed) {
                return KEY_STATE_PRESSED_ON;
            }
            return KEY_STATE_NORMAL_ON;
        } else if (this.sticky) {
            if (this.pressed) {
                return KEY_STATE_PRESSED_OFF;
            }
            return KEY_STATE_NORMAL_OFF;
        } else if (this.pressed) {
            return KEY_STATE_PRESSED;
        } else {
            return states;
        }
    }
}
