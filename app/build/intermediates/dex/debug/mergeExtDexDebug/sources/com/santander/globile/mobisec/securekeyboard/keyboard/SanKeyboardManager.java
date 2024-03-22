package com.santander.globile.mobisec.securekeyboard.keyboard;

import android.content.Context;
import com.santander.globile.mobisec.securekeyboard.R;
import com.santander.globile.mobisec.securekeyboard.enums.InputLanguage;
import com.santander.globile.mobisec.securekeyboard.enums.ShiftMode;
import com.santander.globile.mobisec.securekeyboard.enums.TopRowButtonsOptions;
import com.santander.globile.mobisec.securekeyboard.listeners.SanTapJackedCallback;
import com.santander.globile.mobisec.securekeyboard.utils.SanKeyboardUtils;
import java.util.Arrays;

public class SanKeyboardManager {
    private static InputLanguage[] possibleLanguages = InputLanguage.defaultLanguages;
    private static SanTapJackedCallback sanTapJackedCallback;
    private SanKeyboard alphaNumericKeyboard;
    private SanKeyboard alphaNumericTopRowKeyboardOneButton;
    private SanKeyboard alphaNumericTopRowKeyboardTwoButtons;
    private final Context context;
    private Context contextForLanguage;
    private SanKeyboard current;
    private InputLanguage currentLanguage;
    private SanKeyboard decimalKeyboard;
    private SanKeyboard decimalTopRowKeyboardOneButton;
    private SanKeyboard decimalTopRowKeyboardTwoButtons;
    private SanKeyboardType keyboardType = SanKeyboardType.ALPHA;
    private SanKeyboard numericKeyboard;
    private SanKeyboard numericTopRowKeyboardOneButton;
    private SanKeyboard numericTopRowKeyboardTwoButtons;
    private SanKeyboard phoneKeyboard;
    private SanKeyboard phoneTopRowKeyboardOneButton;
    private SanKeyboard phoneTopRowKeyboardTwoButtons;
    private SanKeyboard specialCharacterKeyboard;
    private SanKeyboard specialCharacterKeyboardNext;
    private SanKeyboard specialCharacterTopRowKeyboardNextOneButton;
    private SanKeyboard specialCharacterTopRowKeyboardNextTwoButtons;
    private SanKeyboard specialCharacterTopRowKeyboardOneButton;
    private SanKeyboard specialCharacterTopRowKeyboardTwoButtons;

    public SanKeyboardManager(Context context2) {
        this.context = context2;
        updateKeyboards(InputLanguage.forLocale(context2.getResources().getConfiguration().locale));
    }

    public void updateKeyboards(InputLanguage currentLanguage2) {
        this.currentLanguage = currentLanguage2;
        this.contextForLanguage = SanKeyboardUtils.getContextForLocale(this.context.getApplicationContext(), currentLanguage2.getLocale());
        inflateKeyboards();
    }

    private void inflateKeyboards() {
        this.alphaNumericKeyboard = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_alphanumeric);
        this.alphaNumericTopRowKeyboardOneButton = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_alphanumeric_top_row_one_button);
        this.alphaNumericTopRowKeyboardTwoButtons = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_alphanumeric_top_row_two_buttons);
        this.decimalKeyboard = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_decimal);
        this.decimalTopRowKeyboardOneButton = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_decimal_top_row_one_button);
        this.decimalTopRowKeyboardTwoButtons = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_decimal_top_row_two_buttons);
        this.phoneKeyboard = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_phone);
        this.phoneTopRowKeyboardOneButton = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_phone_top_row_one_button);
        this.phoneTopRowKeyboardTwoButtons = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_phone_top_row_two_buttons);
        this.numericKeyboard = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_numeric);
        this.numericTopRowKeyboardOneButton = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_numeric_top_row_one_button);
        this.numericTopRowKeyboardTwoButtons = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_numeric_top_row_two_buttons);
        this.specialCharacterKeyboard = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_specialcharacters);
        this.specialCharacterTopRowKeyboardOneButton = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_specialcharacters_top_row_one_button);
        this.specialCharacterTopRowKeyboardTwoButtons = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_specialcharacters_top_row_two_buttons);
        this.specialCharacterKeyboardNext = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_specialcharacters_next);
        this.specialCharacterTopRowKeyboardNextOneButton = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_specialcharacters_next_top_row_one_button);
        this.specialCharacterTopRowKeyboardNextTwoButtons = new SanKeyboard(this.contextForLanguage, R.xml.keyboard_specialcharacters_next_top_row_two_buttons);
    }

    public static InputLanguage[] getPossibleLanguages() {
        InputLanguage[] inputLanguageArr = possibleLanguages;
        return (InputLanguage[]) Arrays.copyOf(inputLanguageArr, inputLanguageArr.length);
    }

    public static void setPossibleLanguages(InputLanguage[] possibleLanguages2) {
        possibleLanguages = possibleLanguages2;
    }

    public static SanTapJackedCallback getSanTapJackedCallback() {
        return sanTapJackedCallback;
    }

    public static void setSanTapJackedCallback(SanTapJackedCallback sanTapJackedCallback2) {
        sanTapJackedCallback = sanTapJackedCallback2;
    }

    public InputLanguage getCurrentLanguage() {
        return this.currentLanguage;
    }

    private void setKeyboardType(SanKeyboardType keyboardType2) {
        this.keyboardType = keyboardType2;
    }

    public SanKeyboardType getKeyboardType() {
        return this.keyboardType;
    }

    public SanKeyboard getKeyboardForType(SanKeyboardType keyboardType2, TopRowButtonsOptions topRowButtonsCode) {
        SanKeyboard shown;
        setKeyboardType(keyboardType2);
        switch (AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[keyboardType2.ordinal()]) {
            case 1:
                shown = selectAlphanumericKeyboard(topRowButtonsCode);
                shown.setInitialShift(ShiftMode.LOWER_CASE);
                break;
            case 2:
                shown = selectAlphanumericKeyboard(topRowButtonsCode);
                shown.setInitialShift(ShiftMode.UPPER_CASE_SINGLE);
                break;
            case 3:
                shown = selectAlphanumericKeyboard(topRowButtonsCode);
                shown.setInitialShift(ShiftMode.UPPER_CASE_CONTINUOUS);
                break;
            case 4:
                int i = AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$enums$TopRowButtonsOptions[topRowButtonsCode.ordinal()];
                if (i != 2) {
                    if (i == 3) {
                        shown = this.decimalTopRowKeyboardTwoButtons;
                        break;
                    } else {
                        shown = this.decimalKeyboard;
                        break;
                    }
                } else {
                    shown = this.decimalTopRowKeyboardOneButton;
                    break;
                }
            case 5:
                int i2 = AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$enums$TopRowButtonsOptions[topRowButtonsCode.ordinal()];
                if (i2 != 2) {
                    if (i2 == 3) {
                        shown = this.phoneTopRowKeyboardTwoButtons;
                        break;
                    } else {
                        shown = this.phoneKeyboard;
                        break;
                    }
                } else {
                    shown = this.phoneTopRowKeyboardOneButton;
                    break;
                }
            case 6:
            case 7:
                int i3 = AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$enums$TopRowButtonsOptions[topRowButtonsCode.ordinal()];
                if (i3 != 2) {
                    if (i3 == 3) {
                        shown = this.numericTopRowKeyboardTwoButtons;
                        break;
                    } else {
                        shown = this.numericKeyboard;
                        break;
                    }
                } else {
                    shown = this.numericTopRowKeyboardOneButton;
                    break;
                }
            case 8:
                int i4 = AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$enums$TopRowButtonsOptions[topRowButtonsCode.ordinal()];
                if (i4 != 2) {
                    if (i4 == 3) {
                        shown = this.specialCharacterTopRowKeyboardTwoButtons;
                        break;
                    } else {
                        shown = this.specialCharacterKeyboard;
                        break;
                    }
                } else {
                    shown = this.specialCharacterTopRowKeyboardOneButton;
                    break;
                }
            case 9:
                int i5 = AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$enums$TopRowButtonsOptions[topRowButtonsCode.ordinal()];
                if (i5 != 2) {
                    if (i5 == 3) {
                        shown = this.specialCharacterTopRowKeyboardNextTwoButtons;
                        break;
                    } else {
                        shown = this.specialCharacterKeyboardNext;
                        break;
                    }
                } else {
                    shown = this.specialCharacterTopRowKeyboardNextOneButton;
                    break;
                }
            default:
                throw new IllegalStateException("Keyboard types are not properly updated.");
        }
        this.current = shown;
        return shown;
    }

    /* renamed from: com.santander.globile.mobisec.securekeyboard.keyboard.SanKeyboardManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$santander$globile$mobisec$securekeyboard$enums$TopRowButtonsOptions;
        static final /* synthetic */ int[] $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType;

        static {
            int[] iArr = new int[SanKeyboardType.values().length];
            $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType = iArr;
            try {
                iArr[SanKeyboardType.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[SanKeyboardType.ALPHA_UPPER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[SanKeyboardType.ALPHA_UPPER_PERM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[SanKeyboardType.DECIMAL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[SanKeyboardType.PHONE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[SanKeyboardType.NUMERIC_PASSWORD.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[SanKeyboardType.NUMERIC.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[SanKeyboardType.SPECIAL_CHARACTER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$keyboard$SanKeyboardType[SanKeyboardType.SPECIAL_CHARACTER_NEXT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            int[] iArr2 = new int[TopRowButtonsOptions.values().length];
            $SwitchMap$com$santander$globile$mobisec$securekeyboard$enums$TopRowButtonsOptions = iArr2;
            try {
                iArr2[TopRowButtonsOptions.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$enums$TopRowButtonsOptions[TopRowButtonsOptions.CONTINUE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$enums$TopRowButtonsOptions[TopRowButtonsOptions.CANCEL_CONTINUE.ordinal()] = 3;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    private SanKeyboard selectAlphanumericKeyboard(TopRowButtonsOptions topRowButtonsCode) {
        int i = AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$enums$TopRowButtonsOptions[topRowButtonsCode.ordinal()];
        if (i == 2) {
            return this.alphaNumericTopRowKeyboardOneButton;
        }
        if (i != 3) {
            return this.alphaNumericKeyboard;
        }
        return this.alphaNumericTopRowKeyboardTwoButtons;
    }

    public SanKeyboard getCurrent() {
        return this.current;
    }
}
