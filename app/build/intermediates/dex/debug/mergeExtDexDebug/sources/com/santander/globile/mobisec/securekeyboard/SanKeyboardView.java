package com.santander.globile.mobisec.securekeyboard;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.santander.globile.mobisec.securekeyboard.aosp.KeyAOSP;
import com.santander.globile.mobisec.securekeyboard.aosp.KeyboardAOSP;
import com.santander.globile.mobisec.securekeyboard.aosp.KeyboardViewAOSP;
import com.santander.globile.mobisec.securekeyboard.enums.InputLanguage;
import com.santander.globile.mobisec.securekeyboard.enums.ShiftMode;
import com.santander.globile.mobisec.securekeyboard.enums.SpaceKeyState;
import com.santander.globile.mobisec.securekeyboard.enums.TopRowButtonsOptions;
import com.santander.globile.mobisec.securekeyboard.keyboard.SanKeyboard;
import com.santander.globile.mobisec.securekeyboard.keyboard.SanKeyboardManager;
import com.santander.globile.mobisec.securekeyboard.keyboard.SanKeyboardType;
import com.santander.globile.mobisec.securekeyboard.listeners.SanEventCallbacks;
import com.santander.globile.mobisec.securekeyboard.listeners.SanTapJackedCallback;
import com.santander.globile.mobisec.securekeyboard.utils.AnimationsManager;
import com.santander.globile.mobisec.securekeyboard.utils.SanKeyboardUtils;
import com.santander.globile.mobisec.securekeyboard.utils.SpaceKeyStateManager;
import java.util.Timer;
import java.util.TimerTask;

public class SanKeyboardView extends KeyboardViewAOSP implements KeyboardViewAOSP.OnKeyboardActionListener {
    private static final long CHANGE_LANGUAGE_WAIT = 1500;
    private boolean animating;
    private AnimationsManager animationsManager;
    private TextView.OnEditorActionListener editorActionListener;
    private SanEventCallbacks eventListener;
    private InputConnection inputConnection;
    private InputLanguage inputLanguage;
    private boolean isDeletePressed;
    /* access modifiers changed from: private */
    public boolean isLanguageSelectorShown;
    private boolean isLongPressDownDetected;
    private boolean isLongPressUpDetected;
    /* access modifiers changed from: private */
    public boolean isSpacePressed;
    /* access modifiers changed from: private */
    public SanKeyboardManager keyboardsManager;
    private OnKeyListener onKeyListener;
    private SanKeyboardCallback sanKeyboardCallback;
    /* access modifiers changed from: private */
    public BaseSecureEditText secureEditText;
    private ShiftMode shiftMode;
    /* access modifiers changed from: private */
    public int spaceKeyIndex;
    private SpaceKeyStateManager spaceKeyStateManager;
    private TimerTask spaceLongPressTask;

    public interface OnKeyListener {
        void onKey(int i);
    }

    public interface SanKeyboardCallback {
        void onCancelClick();

        void onContinueClick();
    }

    public SanKeyboardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SanKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SanKeyboardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.spaceKeyIndex = Integer.MIN_VALUE;
        this.shiftMode = ShiftMode.LOWER_CASE;
        this.animating = false;
        setFilterTouchesWhenObscured(true);
        setOnKeyboardActionListener(this);
        initLanguages();
        checkIfAntiTapJackingIsSetted();
        this.isLongPressDownDetected = false;
        this.isLongPressUpDetected = false;
    }

    private void initLanguages() {
        this.inputLanguage = InputLanguage.forLocale(getContext().getResources().getConfiguration().locale);
        InputLanguage deviceLanguage = InputLanguage.forLocale(getContext().getResources().getConfiguration().locale);
        this.inputLanguage = InputLanguage.defaultLanguage;
        InputLanguage[] possibleLanguages = SanKeyboardManager.getPossibleLanguages();
        int length = possibleLanguages.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (possibleLanguages[i] == deviceLanguage) {
                this.inputLanguage = deviceLanguage;
                break;
            } else {
                i++;
            }
        }
        this.keyboardsManager = new SanKeyboardManager(SanKeyboardUtils.getContextForLocale(getContext(), this.inputLanguage.getLocale()));
    }

    private void checkIfAntiTapJackingIsSetted() {
        if (SanKeyboardManager.getSanTapJackedCallback() == null) {
            throw new IllegalStateException("SanTapJackedCallback not initialized. In order to use the SanKeyboard you must set SanKeyboardManager.sanTapJackedCallback");
        }
    }

    public void initAnimationsManager() {
        this.animationsManager = new AnimationsManager(this);
    }

    public SanKeyboard getKeyboard() {
        return (SanKeyboard) super.getKeyboard();
    }

    public void setSanKeyboardCallback(SanKeyboardCallback sanKeyboardCallback2) {
        this.sanKeyboardCallback = sanKeyboardCallback2;
    }

    public SanEventCallbacks getEventListener() {
        return this.eventListener;
    }

    public void setEventListener(SanEventCallbacks eventListener2) {
        this.eventListener = eventListener2;
    }

    public SanKeyboardType getKeyboardType() {
        SanKeyboardManager sanKeyboardManager = this.keyboardsManager;
        if (sanKeyboardManager != null) {
            return sanKeyboardManager.getKeyboardType();
        }
        return null;
    }

    public boolean isLanguageSelectorShown() {
        return this.isLanguageSelectorShown;
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener listener) {
        this.editorActionListener = listener;
    }

    public void setOnKeyListener(OnKeyListener listener) {
        this.onKeyListener = listener;
    }

    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        boolean touchEventDispatched = super.onFilterTouchEventForSecurity(event);
        SanTapJackedCallback sanKeyboardTapJackedCallback = SanKeyboardManager.getSanTapJackedCallback();
        if (touchEventDispatched || sanKeyboardTapJackedCallback == null) {
            return touchEventDispatched;
        }
        return sanKeyboardTapJackedCallback.onObscuredTouchEvent(event);
    }

    public boolean onTouchEvent(MotionEvent me) {
        TimerTask timerTask;
        if (this.isDeletePressed && me.getAction() == 1) {
            this.isDeletePressed = false;
            KeyAOSP deleteKey = getKeyboard().getKeyByCode(-5);
            if (deleteKey != null) {
                deleteKey.icon = getResources().getDrawable(R.drawable.key_backspace_default);
            }
        }
        if (this.isSpacePressed && me.getAction() == 1) {
            this.isSpacePressed = false;
            if (!(getKeyboard().getKeyByCode(32) == null || (timerTask = this.spaceLongPressTask) == null)) {
                timerTask.cancel();
            }
        }
        if (!this.isLongPressDownDetected || !this.isLongPressUpDetected || me.getAction() != 1) {
            if (this.isLongPressDownDetected && !this.isLongPressUpDetected && me.getAction() == 1) {
                this.isLongPressUpDetected = true;
            }
            return super.onTouchEvent(me);
        }
        handleBack();
        return true;
    }

    public void invalidateKey(int keyIndex) {
        if (this.isSpacePressed || keyIndex == this.spaceKeyIndex) {
            setupSpaceKey(getKeyboard());
        }
        super.invalidateKey(keyIndex);
    }

    public void setKeyboard(KeyboardAOSP keyboard) {
        if (keyboard instanceof SanKeyboard) {
            setupSpaceKey((SanKeyboard) keyboard);
            super.setKeyboard(keyboard);
            shiftTo(getKeyboard().getInitialShift());
            return;
        }
        throw new IllegalArgumentException("Keyboard object not an instance of " + SanKeyboard.class.getName());
    }

    public void setInputConnection(BaseSecureEditText editText) {
        this.secureEditText = editText;
        setKeyboard(this.keyboardsManager.getKeyboardForType(editText.getKeyboardType(), editText.getTopRowButtons()));
        this.inputConnection = editText.onCreateInputConnection(new EditorInfo());
    }

    private void shiftTo(ShiftMode shiftMode2) {
        this.shiftMode = shiftMode2;
        if (shiftMode2 != null) {
            setShifted(ShiftMode.LOWER_CASE != shiftMode2);
            KeyAOSP shiftKey = getKeyboard().getKeyByCode(-1);
            if (shiftKey != null) {
                shiftKey.icon = getResources().getDrawable(shiftMode2.getDrawableResId());
            }
        }
    }

    private void changeModeTo(SanKeyboard sanKeyboard) {
        setKeyboard(sanKeyboard);
    }

    private void setupSpaceKey(SanKeyboard keyboard) {
        if (!keyboard.equals(getKeyboard())) {
            this.spaceKeyIndex = keyboard.getKeyIndexByCode(32);
        }
        if (this.spaceKeyIndex != Integer.MIN_VALUE) {
            final KeyAOSP spaceKey = keyboard.getKeys().get(this.spaceKeyIndex);
            if (this.spaceKeyStateManager == null) {
                this.spaceKeyStateManager = new SpaceKeyStateManager(getContext(), spaceKey.width, spaceKey.height);
                spaceKey.label = null;
            }
            if (spaceKey.pressed) {
                this.isSpacePressed = true;
                spaceKey.pressed = false;
                spaceKey.icon = this.spaceKeyStateManager.getDrawableForState(this.inputLanguage, SpaceKeyState.PRESSED);
                if (SanKeyboardManager.getPossibleLanguages().length > 1) {
                    TimerTask timerTask = this.spaceLongPressTask;
                    if (timerTask != null) {
                        timerTask.cancel();
                    }
                    this.spaceLongPressTask = new TimerTask() {
                        public void run() {
                            if (SanKeyboardView.this.isSpacePressed) {
                                SanKeyboardView.this.startLanguageDialog(spaceKey);
                            }
                        }
                    };
                    new Timer().schedule(this.spaceLongPressTask, CHANGE_LANGUAGE_WAIT);
                    return;
                }
                return;
            }
            spaceKey.icon = this.spaceKeyStateManager.getDrawableForState(this.inputLanguage, SpaceKeyState.NORMAL);
            if (this.isSpacePressed) {
                this.isSpacePressed = false;
                invalidateKey(this.spaceKeyIndex);
            }
        }
    }

    /* access modifiers changed from: private */
    public void startLanguageDialog(KeyAOSP spaceKey) {
        final Activity activity = getActivity();
        spaceKey.icon = this.spaceKeyStateManager.getDrawableForState(this.inputLanguage, SpaceKeyState.NORMAL);
        this.isSpacePressed = false;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    SanKeyboardView sanKeyboardView = SanKeyboardView.this;
                    sanKeyboardView.invalidateKey(sanKeyboardView.spaceKeyIndex);
                    boolean unused = SanKeyboardView.this.isLanguageSelectorShown = true;
                    SelectLanguageDialog.showSelectLanguageDialog(activity, SanKeyboardView.this.keyboardsManager.getCurrentLanguage(), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            SanKeyboardView.this.onLanguageSelected(dialog);
                            boolean unused = SanKeyboardView.this.isLanguageSelectorShown = false;
                            SanKeyboardView.this.secureEditText.retainFocus();
                        }
                    }, new DialogInterface.OnDismissListener() {
                        public void onDismiss(DialogInterface dialog) {
                            SanKeyboardView.this.undoInsertSpace();
                            boolean unused = SanKeyboardView.this.isLanguageSelectorShown = false;
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void undoInsertSpace() {
        if (!TextUtils.isEmpty(this.secureEditText.getText())) {
            String pre = this.secureEditText.getText().toString();
            this.secureEditText.setText(pre.substring(0, pre.length() - 1));
        }
    }

    /* access modifiers changed from: private */
    public void onLanguageSelected(DialogInterface dialog) {
        InputLanguage currentLanguage = InputLanguage.values()[((AlertDialog) dialog).getListView().getCheckedItemPosition()];
        this.inputLanguage = currentLanguage;
        this.keyboardsManager.updateKeyboards(currentLanguage);
        SanKeyboardManager sanKeyboardManager = this.keyboardsManager;
        changeModeTo(sanKeyboardManager.getKeyboardForType(sanKeyboardManager.getKeyboardType(), this.keyboardsManager.getCurrent().getTopRowButtonsSelected()));
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean onLongPress(KeyAOSP popupKey) {
        this.isLongPressDownDetected = true;
        return super.onLongPress(popupKey);
    }

    /* JADX WARNING: type inference failed for: r4v13, types: [android.widget.TextView, com.santander.globile.mobisec.securekeyboard.BaseSecureEditText] */
    public void onKey(int primaryCode, int[] keyCodes) {
        if (this.inputConnection != null) {
            notifyOnKey(primaryCode);
            this.isLongPressUpDetected = false;
            this.isLongPressDownDetected = false;
            SanKeyboardType keyboardType = this.keyboardsManager.getKeyboardType();
            SanKeyboard current = this.keyboardsManager.getCurrent();
            TopRowButtonsOptions topRowButtons = TopRowButtonsOptions.NONE;
            if (current != null) {
                topRowButtons = current.getTopRowButtonsSelected();
            }
            if (!getKeyboard().isKeyEnabled(primaryCode) || primaryCode == -9) {
                return;
            }
            if (primaryCode == -8) {
                hide();
                SanKeyboardCallback sanKeyboardCallback2 = this.sanKeyboardCallback;
                if (sanKeyboardCallback2 != null) {
                    sanKeyboardCallback2.onContinueClick();
                }
                this.inputConnection.performEditorAction(5);
            } else if (primaryCode == -7) {
                int i = AnonymousClass3.$SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[keyboardType.ordinal()];
                if (i == 1) {
                    changeModeTo(this.keyboardsManager.getKeyboardForType(SanKeyboardType.SPECIAL_CHARACTER_NEXT, topRowButtons));
                } else if (i != 2) {
                    changeModeTo(this.keyboardsManager.getKeyboardForType(SanKeyboardType.ALPHA, topRowButtons));
                } else {
                    changeModeTo(this.keyboardsManager.getKeyboardForType(SanKeyboardType.SPECIAL_CHARACTER, topRowButtons));
                }
            } else if (primaryCode == -5) {
                CharSequence selectedText = this.inputConnection.getSelectedText(0);
                disableComposerRegion();
                if (TextUtils.isEmpty(selectedText)) {
                    this.inputConnection.deleteSurroundingText(1, 0);
                } else {
                    this.inputConnection.commitText("", 1);
                }
            } else if (primaryCode == -4) {
                TextView.OnEditorActionListener onEditorActionListener = this.editorActionListener;
                if (onEditorActionListener != null) {
                    onEditorActionListener.onEditorAction(this.secureEditText, 6, (KeyEvent) null);
                }
                hide();
            } else if (primaryCode == -3) {
                hide();
                SanKeyboardCallback sanKeyboardCallback3 = this.sanKeyboardCallback;
                if (sanKeyboardCallback3 != null) {
                    sanKeyboardCallback3.onCancelClick();
                }
            } else if (primaryCode == -2) {
                int i2 = AnonymousClass3.$SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[keyboardType.ordinal()];
                if (i2 == 1 || i2 == 2) {
                    changeModeTo(this.keyboardsManager.getKeyboardForType(SanKeyboardType.ALPHA, topRowButtons));
                } else {
                    changeModeTo(this.keyboardsManager.getKeyboardForType(SanKeyboardType.SPECIAL_CHARACTER, topRowButtons));
                }
            } else if (primaryCode == -1) {
                shiftTo(this.shiftMode.getNext());
            } else if (primaryCode != 44) {
                if (primaryCode != 46) {
                    processRegularChar(primaryCode);
                } else if (keyboardType != SanKeyboardType.DECIMAL) {
                    processRegularChar(primaryCode);
                } else if (this.inputLanguage == InputLanguage.ENGLISH_UK && this.secureEditText.getText() != null && !this.secureEditText.getText().toString().contains(".")) {
                    processRegularChar(primaryCode);
                }
            } else if (keyboardType != SanKeyboardType.DECIMAL) {
                processRegularChar(primaryCode);
            } else if (this.inputLanguage != InputLanguage.ENGLISH_UK && this.secureEditText.getText() != null && !this.secureEditText.getText().toString().contains(",")) {
                processRegularChar(primaryCode);
            }
        }
    }

    /* renamed from: com.santander.globile.mobisec.securekeyboard.SanKeyboardView$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType;

        static {
            int[] iArr = new int[SanKeyboardType.values().length];
            $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType = iArr;
            try {
                iArr[SanKeyboardType.SPECIAL_CHARACTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[SanKeyboardType.SPECIAL_CHARACTER_NEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private void processRegularChar(int primaryCode) {
        String character = String.valueOf((char) primaryCode);
        if (isShifted()) {
            character = character.toUpperCase();
        }
        disableComposerRegion();
        this.inputConnection.commitText(character, 1);
        if (ShiftMode.UPPER_CASE_SINGLE == this.shiftMode) {
            shiftTo(ShiftMode.LOWER_CASE);
        }
    }

    private void disableComposerRegion() {
        this.inputConnection.setComposingRegion(0, 0);
    }

    private void notifyOnKey(int primaryCode) {
        OnKeyListener onKeyListener2 = this.onKeyListener;
        if (onKeyListener2 != null) {
            onKeyListener2.onKey(primaryCode);
        }
    }

    public void onPress(int primaryCode) {
        if (primaryCode == -5) {
            this.isDeletePressed = true;
            getKeyboard().getKeyByCode(-5).icon = getResources().getDrawable(R.drawable.key_backspace_pressed);
        }
    }

    public void onRelease(int primaryCode) {
    }

    public void onText(CharSequence text) {
    }

    public void swipeLeft() {
    }

    public void swipeRight() {
    }

    public void swipeDown() {
    }

    public void swipeUp() {
    }

    public void slideIn() {
        startAnimation(this.animationsManager.getSlideInAnimation());
    }

    public void slideOut() {
        startAnimation(this.animationsManager.getSlideOutAnimation());
    }

    private void hide() {
        this.secureEditText.hideSanSecureKeyboard();
    }

    /* access modifiers changed from: protected */
    public void onAnimationStart() {
        super.onAnimationStart();
        this.animating = true;
    }

    /* access modifiers changed from: protected */
    public void onAnimationEnd() {
        super.onAnimationEnd();
        this.animating = false;
    }

    public boolean isAnimating() {
        return this.animating;
    }

    public boolean handleBack() {
        this.isLongPressUpDetected = false;
        this.isLongPressDownDetected = false;
        return super.handleBack();
    }

    public void onDestroyView() {
        this.secureEditText = null;
        this.sanKeyboardCallback = null;
        this.inputConnection = null;
        this.onKeyListener = null;
    }
}
