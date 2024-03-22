package com.santander.globile.mobisec.securekeyboard.enums;

import android.content.res.Resources;
import com.santander.globile.mobisec.securekeyboard.R;
import es.santander.branchlocator.BLConstants;
import java.util.Locale;

public enum InputLanguage {
    ENGLISH_UK("en", BLConstants.GB_COUNTRY_CODE),
    SPANISH_ES("es", BLConstants.ES_COUNTRY_CODE),
    PORTUGUESE_PT("pt", "PT"),
    POLISH_PL("pl", BLConstants.PL_COUNTRY_CODE);
    
    public static final InputLanguage defaultLanguage = null;
    public static final InputLanguage[] defaultLanguages = null;
    private final String country;
    private final String language;

    static {
        InputLanguage[] values = values();
        defaultLanguages = values;
        defaultLanguage = values[0];
    }

    private InputLanguage(String language2, String country2) {
        this.language = language2;
        this.country = country2;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getCountry() {
        return this.country;
    }

    public String getText(Resources resources) {
        return resources.getStringArray(R.array.dialog_languages_array)[ordinal()];
    }

    public Locale getLocale() {
        return new Locale(this.language, this.country);
    }

    public static InputLanguage forLocale(Locale locale) {
        InputLanguage sameLanguage = null;
        for (InputLanguage value : values()) {
            if (locale.getLanguage().equals(value.language)) {
                if (locale.getCountry().equals(value.country)) {
                    return value;
                }
                if (sameLanguage == null) {
                    sameLanguage = value;
                }
            }
        }
        return sameLanguage != null ? sameLanguage : defaultLanguage;
    }
}
