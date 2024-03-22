package com.santander.globile.mobisec.securekeyboard.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.santander.globile.mobisec.securekeyboard.R;
import com.santander.globile.mobisec.securekeyboard.aosp.KeyAOSP;
import com.santander.globile.mobisec.securekeyboard.aosp.KeyboardAOSP;
import com.santander.globile.mobisec.securekeyboard.enums.ShiftMode;
import com.santander.globile.mobisec.securekeyboard.enums.TopRowButtonsOptions;
import com.santander.globile.mobisec.securekeyboard.utils.DrawableUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SanKeyboard extends KeyboardAOSP {
    private static final String CANCEL = "Cancel";
    private static final String CONTINUE = "Continue";
    private static final String CONTINUE_ONLY = "ContinueOnly";
    private static final String DONE = "Done";
    public static final int KEYCODE_CONTINUE = -8;
    public static final int KEYCODE_DECIMAL_COMMA = 44;
    public static final int KEYCODE_DECIMAL_POINT = 46;
    public static final int KEYCODE_SECURE_KEYBOARD = -9;
    public static final int KEYCODE_SPACE = 32;
    public static final int KEYCODE_SPECIAL_CHANGE = -7;
    private Context context;
    private ShiftMode initialShift;
    private List<Integer> keyCodesList;
    private Map<String, SanCustomKeyData> sanCustomKeyDatas;
    private TopRowButtonsOptions topRowButtonsSelected;
    private List<Integer> topRowKeyCodesList;

    public SanKeyboard(Context context2, int xmlLayoutResId) {
        super(context2, xmlLayoutResId);
        init(context2);
    }

    public SanKeyboard(Context context2, int xmlLayoutResId, int modeId, int width, int height) {
        super(context2, xmlLayoutResId, modeId, width, height);
        init(context2);
    }

    public SanKeyboard(Context context2, int xmlLayoutResId, int modeId) {
        super(context2, xmlLayoutResId, modeId);
        init(context2);
    }

    public SanKeyboard(Context context2, int layoutTemplateResId, CharSequence characters, int columns, int horizontalPadding) {
        super(context2, layoutTemplateResId, characters, columns, horizontalPadding);
        init(context2);
    }

    public ShiftMode getInitialShift() {
        return this.initialShift;
    }

    public void setInitialShift(ShiftMode initialShift2) {
        this.initialShift = initialShift2;
    }

    public TopRowButtonsOptions getTopRowButtonsSelected() {
        return this.topRowButtonsSelected;
    }

    private void init(Context context2) {
        this.context = context2;
        generateCustomKeyData(context2.getResources());
        initializeKeys();
    }

    private void initializeKeys() {
        List<KeyAOSP> keys = getKeys();
        this.keyCodesList = new ArrayList(keys.size());
        this.topRowKeyCodesList = new ArrayList();
        int[] topRowKeys = this.context.getResources().getIntArray(R.array.topRowKeys);
        for (KeyAOSP key : keys) {
            int keyCode = key.codes[0];
            this.keyCodesList.add(Integer.valueOf(keyCode));
            for (int topRowKey : topRowKeys) {
                if (keyCode == topRowKey) {
                    this.topRowKeyCodesList.add(Integer.valueOf(key.codes[0]));
                }
            }
            if (getSanCustomKeyDataForKeyCode(keyCode) != null) {
                enableDisableCustomKey(key.codes[0], true);
            }
        }
        int size = this.topRowKeyCodesList.size();
        if (size == 1) {
            this.topRowButtonsSelected = TopRowButtonsOptions.CONTINUE_ONLY;
        } else if (size != 2) {
            this.topRowButtonsSelected = TopRowButtonsOptions.NONE;
        } else {
            this.topRowButtonsSelected = TopRowButtonsOptions.CANCEL_CONTINUE;
        }
    }

    public int[] getNearestKeys(int x, int y) {
        List<KeyAOSP> keys = getKeys();
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).isInside(x, y)) {
                return new int[]{i};
            }
        }
        return new int[0];
    }

    public KeyAOSP getKeyByCode(int keyCode) {
        int keyIndex = getKeyIndexByCode(keyCode);
        if (keyIndex == Integer.MIN_VALUE) {
            return null;
        }
        return getKeys().get(keyIndex);
    }

    public int getKeyIndexByCode(int keyCode) {
        int index = this.keyCodesList.indexOf(Integer.valueOf(keyCode));
        if (index >= 0) {
            return index;
        }
        return Integer.MIN_VALUE;
    }

    public void enableDisableCustomKey(int code, boolean enabled) {
        KeyAOSP key = getKeyByCode(code);
        SanCustomKeyData sanCustomKeyData = getSanCustomKeyDataForKeyCode(code);
        if (sanCustomKeyData != null && key != null) {
            boolean unused = sanCustomKeyData.enabled = enabled;
            key.icon = generateCustomKeyDrawable(key, enabled);
        }
    }

    public boolean isKeyEnabled(int code) {
        SanCustomKeyData sanCustomKeyData = getSanCustomKeyDataForKeyCode(code);
        if (sanCustomKeyData != null) {
            return sanCustomKeyData.enabled;
        }
        return true;
    }

    private Drawable generateCustomKeyDrawable(KeyAOSP key, boolean enabled) {
        SanCustomKeyData sanCustomKeyData = getSanCustomKeyDataForKeyCode(key.codes[0]);
        if (sanCustomKeyData != null) {
            return DrawableUtils.generateTextViewCanvas(this.context, key.width, key.height, sanCustomKeyData.getBgColor(enabled), sanCustomKeyData.getTextColor(enabled), sanCustomKeyData.text, sanCustomKeyData.roundBorders);
        }
        return null;
    }

    private SanCustomKeyData getSanCustomKeyDataForKeyCode(int code) {
        if (code != -8) {
            if (code == -4) {
                return this.sanCustomKeyDatas.get(DONE);
            }
            if (code != -3) {
                return null;
            }
            return this.sanCustomKeyDatas.get(CANCEL);
        } else if (this.topRowKeyCodesList.size() == 1) {
            return this.sanCustomKeyDatas.get(CONTINUE_ONLY);
        } else {
            return this.sanCustomKeyDatas.get(CONTINUE);
        }
    }

    private void generateCustomKeyData(Resources res) {
        TreeMap treeMap = new TreeMap();
        this.sanCustomKeyDatas = treeMap;
        treeMap.put(CONTINUE_ONLY, new SanCustomKeyData(CONTINUE_ONLY, -8, res.getColor(R.color.keyboard_sanred), -1, 0, -7829368, res.getString(R.string.securekeyboard_continue), false));
        this.sanCustomKeyDatas.put(CONTINUE, new SanCustomKeyData(CONTINUE, -8, 0, res.getColor(R.color.keyboard_sanred), 0, -7829368, res.getString(R.string.securekeyboard_continue), false));
        this.sanCustomKeyDatas.put(CANCEL, new SanCustomKeyData(CANCEL, -3, 0, -16777216, 0, -7829368, res.getString(R.string.securekeyboard_cancel), false));
        this.sanCustomKeyDatas.put(DONE, new SanCustomKeyData(DONE, -4, res.getColor(R.color.keyboard_done_key_background), -1, -7829368, -1, res.getString(R.string.securekeyboard_done), true));
    }

    private static class SanCustomKeyData {
        private final int code;
        private final int disabledBgColor;
        private final int disabledTextColor;
        /* access modifiers changed from: private */
        public boolean enabled = true;
        private final int enabledBgColor;
        private final int enabledTextColor;
        private final String id;
        /* access modifiers changed from: private */
        public final boolean roundBorders;
        /* access modifiers changed from: private */
        public final String text;

        SanCustomKeyData(String id2, int code2, int enabledBgColor2, int enabledTextColor2, int disabledBgColor2, int disabledTextColor2, String text2, boolean roundBorders2) {
            this.id = id2;
            this.code = code2;
            this.enabledBgColor = enabledBgColor2;
            this.disabledBgColor = disabledBgColor2;
            this.enabledTextColor = enabledTextColor2;
            this.disabledTextColor = disabledTextColor2;
            this.text = text2;
            this.roundBorders = roundBorders2;
        }

        /* access modifiers changed from: private */
        public int getBgColor(boolean enabled2) {
            return enabled2 ? this.enabledBgColor : this.disabledBgColor;
        }

        /* access modifiers changed from: private */
        public int getTextColor(boolean enabled2) {
            return enabled2 ? this.enabledTextColor : this.disabledTextColor;
        }
    }
}
