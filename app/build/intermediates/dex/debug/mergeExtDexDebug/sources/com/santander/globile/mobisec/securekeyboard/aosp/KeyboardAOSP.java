package com.santander.globile.mobisec.securekeyboard.aosp;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.santander.globile.mobisec.securekeyboard.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

public class KeyboardAOSP {
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    private static final int GRID_HEIGHT = 5;
    private static final int GRID_SIZE = 50;
    private static final int GRID_WIDTH = 10;
    public static final int KEYCODE_ALT = -6;
    public static final int KEYCODE_CANCEL = -3;
    public static final int KEYCODE_DELETE = -5;
    public static final int KEYCODE_DONE = -4;
    public static final int KEYCODE_MODE_CHANGE = -2;
    public static final int KEYCODE_SHIFT = -1;
    private static float SEARCH_DISTANCE = 1.8f;
    static final String TAG = "Keyboard";
    private static final String TAG_KEY = "Key";
    private static final String TAG_KEYBOARD = "Keyboard";
    private static final String TAG_ROW = "Row";
    private int mCellHeight;
    private int mCellWidth;
    private int mDefaultHeight;
    private int mDefaultHorizontalGap;
    private int mDefaultVerticalGap;
    private int mDefaultWidth;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private int[][] mGridNeighbors;
    private int mKeyHeight;
    private int mKeyWidth;
    private int mKeyboardMode;
    private List<KeyAOSP> mKeys;
    private CharSequence mLabel;
    private List<KeyAOSP> mModifierKeys;
    private int mProximityThreshold;
    private int[] mShiftKeyIndices;
    private KeyAOSP[] mShiftKeys;
    private boolean mShifted;
    private int mTotalHeight;
    private int mTotalWidth;
    private ArrayList<RowAOSP> rows;

    public KeyboardAOSP(Context context, int xmlLayoutResId) {
        this(context, xmlLayoutResId, 0);
    }

    public KeyboardAOSP(Context context, int xmlLayoutResId, int modeId, int width, int height) {
        this.mShiftKeys = new KeyAOSP[]{null, null};
        this.mShiftKeyIndices = new int[]{-1, -1};
        this.rows = new ArrayList<>();
        this.mDisplayWidth = width;
        this.mDisplayHeight = height;
        this.mDefaultHorizontalGap = 0;
        int i = width / 10;
        this.mDefaultWidth = i;
        this.mDefaultVerticalGap = 0;
        this.mDefaultHeight = i;
        this.mKeys = new ArrayList();
        this.mModifierKeys = new ArrayList();
        this.mKeyboardMode = modeId;
        loadKeyboard(context, context.getResources().getXml(xmlLayoutResId));
    }

    public KeyboardAOSP(Context context, int xmlLayoutResId, int modeId) {
        this.mShiftKeys = new KeyAOSP[]{null, null};
        this.mShiftKeyIndices = new int[]{-1, -1};
        this.rows = new ArrayList<>();
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        this.mDisplayWidth = dm.widthPixels;
        this.mDisplayHeight = dm.heightPixels;
        this.mDefaultHorizontalGap = 0;
        int i = this.mDisplayWidth / 10;
        this.mDefaultWidth = i;
        this.mDefaultVerticalGap = 0;
        this.mDefaultHeight = i;
        this.mKeys = new ArrayList();
        this.mModifierKeys = new ArrayList();
        this.mKeyboardMode = modeId;
        loadKeyboard(context, context.getResources().getXml(xmlLayoutResId));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: int[]} */
    /* JADX WARNING: type inference failed for: r10v0, types: [char] */
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KeyboardAOSP(android.content.Context r15, int r16, java.lang.CharSequence r17, int r18, int r19) {
        /*
            r14 = this;
            r0 = r14
            r14.<init>(r15, r16)
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r0.mTotalWidth = r4
            com.santander.globile.mobisec.securekeyboard.aosp.RowAOSP r5 = new com.santander.globile.mobisec.securekeyboard.aosp.RowAOSP
            r5.<init>(r14)
            int r6 = r0.mDefaultHeight
            r5.defaultHeight = r6
            int r6 = r0.mDefaultWidth
            r5.defaultWidth = r6
            int r6 = r0.mDefaultHorizontalGap
            r5.defaultHorizontalGap = r6
            int r6 = r0.mDefaultVerticalGap
            r5.verticalGap = r6
            r6 = 12
            r5.rowEdgeFlags = r6
            r6 = -1
            r7 = r18
            if (r7 != r6) goto L_0x002c
            r6 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x002d
        L_0x002c:
            r6 = r7
        L_0x002d:
            r8 = 0
        L_0x002e:
            int r9 = r17.length()
            if (r8 >= r9) goto L_0x007d
            r9 = r17
            char r10 = r9.charAt(r8)
            if (r3 >= r6) goto L_0x0045
            int r11 = r0.mDefaultWidth
            int r11 = r11 + r1
            int r11 = r11 + r19
            int r12 = r0.mDisplayWidth
            if (r11 <= r12) goto L_0x004d
        L_0x0045:
            r1 = 0
            int r11 = r0.mDefaultVerticalGap
            int r12 = r0.mDefaultHeight
            int r11 = r11 + r12
            int r2 = r2 + r11
            r3 = 0
        L_0x004d:
            com.santander.globile.mobisec.securekeyboard.aosp.KeyAOSP r11 = new com.santander.globile.mobisec.securekeyboard.aosp.KeyAOSP
            r11.<init>(r5)
            r11.x = r1
            r11.y = r2
            java.lang.String r12 = java.lang.String.valueOf(r10)
            r11.label = r12
            r12 = 1
            int[] r13 = new int[r12]
            r13[r4] = r10
            r11.codes = r13
            int r3 = r3 + r12
            int r12 = r11.width
            int r13 = r11.gap
            int r12 = r12 + r13
            int r1 = r1 + r12
            java.util.List<com.santander.globile.mobisec.securekeyboard.aosp.KeyAOSP> r12 = r0.mKeys
            r12.add(r11)
            java.util.ArrayList<com.santander.globile.mobisec.securekeyboard.aosp.KeyAOSP> r12 = r5.mKeys
            r12.add(r11)
            int r12 = r0.mTotalWidth
            if (r1 <= r12) goto L_0x007a
            r0.mTotalWidth = r1
        L_0x007a:
            int r8 = r8 + 1
            goto L_0x002e
        L_0x007d:
            r9 = r17
            int r4 = r0.mDefaultHeight
            int r4 = r4 + r2
            r0.mTotalHeight = r4
            java.util.ArrayList<com.santander.globile.mobisec.securekeyboard.aosp.RowAOSP> r4 = r0.rows
            r4.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.santander.globile.mobisec.securekeyboard.aosp.KeyboardAOSP.<init>(android.content.Context, int, java.lang.CharSequence, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public final void resize(int newWidth, int newHeight) {
        int numRows = this.rows.size();
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            RowAOSP row = this.rows.get(rowIndex);
            int numKeys = row.mKeys.size();
            int totalGap = 0;
            int totalWidth = 0;
            for (int keyIndex = 0; keyIndex < numKeys; keyIndex++) {
                KeyAOSP key = row.mKeys.get(keyIndex);
                if (keyIndex > 0) {
                    totalGap += key.gap;
                }
                totalWidth += key.width;
            }
            if (totalGap + totalWidth > newWidth) {
                int x = 0;
                float scaleFactor = ((float) (newWidth - totalGap)) / ((float) totalWidth);
                for (int keyIndex2 = 0; keyIndex2 < numKeys; keyIndex2++) {
                    KeyAOSP key2 = row.mKeys.get(keyIndex2);
                    key2.width = (int) (((float) key2.width) * scaleFactor);
                    key2.x = x;
                    x += key2.width + key2.gap;
                }
            }
        }
        this.mTotalWidth = newWidth;
    }

    public List<KeyAOSP> getKeys() {
        return this.mKeys;
    }

    public List<KeyAOSP> getModifierKeys() {
        return this.mModifierKeys;
    }

    /* access modifiers changed from: protected */
    public int getHorizontalGap() {
        return this.mDefaultHorizontalGap;
    }

    /* access modifiers changed from: protected */
    public void setHorizontalGap(int gap) {
        this.mDefaultHorizontalGap = gap;
    }

    /* access modifiers changed from: protected */
    public int getVerticalGap() {
        return this.mDefaultVerticalGap;
    }

    /* access modifiers changed from: protected */
    public void setVerticalGap(int gap) {
        this.mDefaultVerticalGap = gap;
    }

    /* access modifiers changed from: protected */
    public int getKeyHeight() {
        return this.mDefaultHeight;
    }

    /* access modifiers changed from: protected */
    public void setKeyHeight(int height) {
        this.mDefaultHeight = height;
    }

    /* access modifiers changed from: protected */
    public int getKeyWidth() {
        return this.mDefaultWidth;
    }

    /* access modifiers changed from: protected */
    public void setKeyWidth(int width) {
        this.mDefaultWidth = width;
    }

    public int getHeight() {
        return this.mTotalHeight;
    }

    public int getMinWidth() {
        return this.mTotalWidth;
    }

    public boolean setShifted(boolean shiftState) {
        for (KeyAOSP shiftKey : this.mShiftKeys) {
            if (shiftKey != null) {
                shiftKey.on = shiftState;
            }
        }
        if (this.mShifted == shiftState) {
            return false;
        }
        this.mShifted = shiftState;
        return true;
    }

    public boolean isShifted() {
        return this.mShifted;
    }

    public int[] getShiftKeyIndices() {
        return this.mShiftKeyIndices;
    }

    public int getShiftKeyIndex() {
        return this.mShiftKeyIndices[0];
    }

    private void computeNearestNeighbors() {
        this.mCellWidth = ((getMinWidth() + 10) - 1) / 10;
        this.mCellHeight = ((getHeight() + 5) - 1) / 5;
        this.mGridNeighbors = new int[GRID_SIZE][];
        int[] indices = new int[this.mKeys.size()];
        int gridWidth = this.mCellWidth * 10;
        int gridHeight = this.mCellHeight * 5;
        int x = 0;
        while (x < gridWidth) {
            int y = 0;
            while (y < gridHeight) {
                int count = 0;
                for (int i = 0; i < this.mKeys.size(); i++) {
                    KeyAOSP key = this.mKeys.get(i);
                    if (key.squaredDistanceFrom(x, y) < this.mProximityThreshold || key.squaredDistanceFrom((this.mCellWidth + x) - 1, y) < this.mProximityThreshold || key.squaredDistanceFrom((this.mCellWidth + x) - 1, (this.mCellHeight + y) - 1) < this.mProximityThreshold || key.squaredDistanceFrom(x, (this.mCellHeight + y) - 1) < this.mProximityThreshold) {
                        indices[count] = i;
                        count++;
                    }
                }
                int[] cell = new int[count];
                System.arraycopy(indices, 0, cell, 0, count);
                int[][] iArr = this.mGridNeighbors;
                int i2 = this.mCellHeight;
                iArr[((y / i2) * 10) + (x / this.mCellWidth)] = cell;
                y += i2;
            }
            x += this.mCellWidth;
        }
    }

    public int[] getNearestKeys(int x, int y) {
        int index;
        if (this.mGridNeighbors == null) {
            computeNearestNeighbors();
        }
        if (x < 0 || x >= getMinWidth() || y < 0 || y >= getHeight() || (index = ((y / this.mCellHeight) * 10) + (x / this.mCellWidth)) >= GRID_SIZE) {
            return new int[0];
        }
        return this.mGridNeighbors[index];
    }

    /* access modifiers changed from: protected */
    public RowAOSP createRowFromXml(Resources res, XmlResourceParser parser) {
        return new RowAOSP(res, this, parser);
    }

    /* access modifiers changed from: protected */
    public KeyAOSP createKeyFromXml(Resources res, RowAOSP parent, int x, int y, XmlResourceParser parser) {
        return new KeyAOSP(res, parent, x, y, parser);
    }

    private void loadKeyboard(Context context, XmlResourceParser parser) {
        int event;
        int y;
        int row;
        boolean leftMostKey;
        XmlResourceParser xmlResourceParser = parser;
        boolean event2 = false;
        Resources res = context.getResources();
        int row2 = 0;
        int x = 0;
        int y2 = 0;
        int x2 = 0;
        KeyAOSP key = null;
        KeyAOSP key2 = null;
        RowAOSP currentRow = null;
        while (true) {
            try {
                int next = parser.next();
                event = next;
                if (next == 1) {
                    break;
                } else if (event == 2) {
                    String tag = parser.getName();
                    if (TAG_ROW.equals(tag)) {
                        try {
                            currentRow = createRowFromXml(res, xmlResourceParser);
                            this.rows.add(currentRow);
                            boolean skipRow = (currentRow.mode == 0 || currentRow.mode == this.mKeyboardMode) ? false : true;
                            if (skipRow) {
                                try {
                                    skipToEndOfRow(xmlResourceParser);
                                    boolean z = skipRow;
                                    leftMostKey = event2;
                                    x = 0;
                                    row = row2;
                                    y = y2;
                                    x2 = 0;
                                    int i = event;
                                } catch (Exception e) {
                                    e = e;
                                    boolean z2 = skipRow;
                                    boolean z3 = event2;
                                    int i2 = row2;
                                    Log.e("Keyboard", "Parse error:" + e);
                                    this.mTotalHeight = y2 - this.mDefaultVerticalGap;
                                }
                            } else {
                                boolean z4 = skipRow;
                                leftMostKey = event2;
                                x = 0;
                                row = row2;
                                y = y2;
                                x2 = 1;
                                int i3 = event;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            boolean z5 = event2;
                            int i4 = row2;
                            Log.e("Keyboard", "Parse error:" + e);
                            this.mTotalHeight = y2 - this.mDefaultVerticalGap;
                        }
                    } else if (TAG_KEY.equals(tag)) {
                        leftMostKey = event2;
                        int i5 = event;
                        row = row2;
                        RowAOSP currentRow2 = currentRow;
                        y = y2;
                        try {
                            KeyAOSP key3 = createKeyFromXml(res, currentRow, x, y2, parser);
                            try {
                                this.mKeys.add(key3);
                                if (key3.codes[0] == -1) {
                                    int i6 = 0;
                                    while (true) {
                                        KeyAOSP[] keyAOSPArr = this.mShiftKeys;
                                        if (i6 >= keyAOSPArr.length) {
                                            break;
                                        } else if (keyAOSPArr[i6] == null) {
                                            keyAOSPArr[i6] = key3;
                                            this.mShiftKeyIndices[i6] = this.mKeys.size() - 1;
                                            break;
                                        } else {
                                            i6++;
                                        }
                                    }
                                    this.mModifierKeys.add(key3);
                                } else if (key3.codes[0] == -6) {
                                    this.mModifierKeys.add(key3);
                                }
                                currentRow2.mKeys.add(key3);
                                key2 = key3;
                                currentRow = currentRow2;
                                key = 1;
                            } catch (Exception e3) {
                                e = e3;
                                KeyAOSP keyAOSP = key3;
                                RowAOSP rowAOSP = currentRow2;
                                y2 = y;
                                Log.e("Keyboard", "Parse error:" + e);
                                this.mTotalHeight = y2 - this.mDefaultVerticalGap;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            RowAOSP rowAOSP2 = currentRow2;
                            KeyAOSP keyAOSP2 = key2;
                            y2 = y;
                            Log.e("Keyboard", "Parse error:" + e);
                            this.mTotalHeight = y2 - this.mDefaultVerticalGap;
                        }
                    } else {
                        leftMostKey = event2;
                        row = row2;
                        y = y2;
                        int i7 = event;
                        RowAOSP currentRow3 = currentRow;
                        KeyAOSP key4 = key2;
                        try {
                            if ("Keyboard".equals(tag)) {
                                parseKeyboardAttributes(res, xmlResourceParser);
                            }
                            currentRow = currentRow3;
                            key2 = key4;
                        } catch (Exception e5) {
                            e = e5;
                            RowAOSP rowAOSP3 = currentRow3;
                            KeyAOSP keyAOSP3 = key4;
                            y2 = y;
                            Log.e("Keyboard", "Parse error:" + e);
                            this.mTotalHeight = y2 - this.mDefaultVerticalGap;
                        }
                    }
                    event2 = leftMostKey;
                    row2 = row;
                    y2 = y;
                } else {
                    boolean leftMostKey2 = event2;
                    int row3 = row2;
                    int y3 = y2;
                    RowAOSP currentRow4 = currentRow;
                    KeyAOSP key5 = key2;
                    if (event == 3) {
                        if (key != null) {
                            key = null;
                            x += key5.gap + key5.width;
                            if (x > this.mTotalWidth) {
                                this.mTotalWidth = x;
                            }
                        } else if (x2 != 0) {
                            x2 = 0;
                            int y4 = y3 + currentRow4.verticalGap;
                            try {
                                currentRow = currentRow4;
                                key2 = key5;
                                event2 = leftMostKey2;
                                y2 = currentRow4.defaultHeight + y4;
                                row2 = row3 + 1;
                            } catch (Exception e6) {
                                e = e6;
                                RowAOSP rowAOSP4 = currentRow4;
                                KeyAOSP keyAOSP4 = key5;
                                y2 = y4;
                                Log.e("Keyboard", "Parse error:" + e);
                                this.mTotalHeight = y2 - this.mDefaultVerticalGap;
                            }
                        }
                    }
                    currentRow = currentRow4;
                    key2 = key5;
                    event2 = leftMostKey2;
                    row2 = row3;
                    y2 = y3;
                }
            } catch (Exception e7) {
                e = e7;
                boolean z6 = event2;
                int i8 = row2;
                int i9 = y2;
                RowAOSP rowAOSP5 = currentRow;
                KeyAOSP keyAOSP5 = key2;
                y2 = i9;
                Log.e("Keyboard", "Parse error:" + e);
                this.mTotalHeight = y2 - this.mDefaultVerticalGap;
            }
        }
        boolean leftMostKey3 = event2;
        int i10 = row2;
        int y5 = y2;
        int i11 = event;
        RowAOSP rowAOSP6 = currentRow;
        KeyAOSP keyAOSP6 = key2;
        y2 = y5;
        this.mTotalHeight = y2 - this.mDefaultVerticalGap;
    }

    private void skipToEndOfRow(XmlResourceParser parser) throws XmlPullParserException, IOException {
        while (true) {
            int next = parser.next();
            int event = next;
            if (next == 1) {
                return;
            }
            if (event == 3 && parser.getName().equals(TAG_ROW)) {
                return;
            }
        }
    }

    private void parseKeyboardAttributes(Resources res, XmlResourceParser parser) {
        TypedArray a = res.obtainAttributes(Xml.asAttributeSet(parser), R.styleable.KeyboardAOSP);
        int i = R.styleable.KeyboardAOSP_keyWidth;
        int i2 = this.mDisplayWidth;
        this.mDefaultWidth = getDimensionOrFraction(a, i, i2, i2 / 10);
        this.mDefaultHeight = getDimensionOrFraction(a, R.styleable.KeyboardAOSP_keyHeight, this.mDisplayHeight, GRID_SIZE);
        this.mDefaultHorizontalGap = getDimensionOrFraction(a, R.styleable.KeyboardAOSP_horizontalGap, this.mDisplayWidth, 0);
        this.mDefaultVerticalGap = getDimensionOrFraction(a, R.styleable.KeyboardAOSP_verticalGap, this.mDisplayHeight, 0);
        int i3 = (int) (((float) this.mDefaultWidth) * SEARCH_DISTANCE);
        this.mProximityThreshold = i3;
        this.mProximityThreshold = i3 * i3;
        a.recycle();
    }

    static int getDimensionOrFraction(TypedArray a, int index, int base, int defValue) {
        TypedValue value = a.peekValue(index);
        if (value == null) {
            return defValue;
        }
        if (value.type == 5) {
            return a.getDimensionPixelOffset(index, defValue);
        }
        if (value.type == 6) {
            return Math.round(a.getFraction(index, base, base, (float) defValue));
        }
        return defValue;
    }

    public int getmDefaultWidth() {
        return this.mDefaultWidth;
    }

    public int getmDefaultHeight() {
        return this.mDefaultHeight;
    }

    public int getmDisplayWidth() {
        return this.mDisplayWidth;
    }

    public int getmDisplayHeight() {
        return this.mDisplayHeight;
    }
}
