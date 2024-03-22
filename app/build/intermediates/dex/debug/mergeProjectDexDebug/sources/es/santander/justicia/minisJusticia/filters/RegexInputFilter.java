package es.santander.justicia.minisJusticia.filters;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

public class RegexInputFilter implements InputFilter {
    private static final String CLASS_NAME = RegexInputFilter.class.getSimpleName();
    private Pattern mPattern;

    public RegexInputFilter(String pattern) {
        this(Pattern.compile(pattern));
    }

    public RegexInputFilter(Pattern pattern) {
        if (pattern != null) {
            this.mPattern = pattern;
            return;
        }
        throw new IllegalArgumentException(CLASS_NAME + " requires a regex.");
    }

    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        if (!this.mPattern.matcher(source).matches()) {
            return "";
        }
        return null;
    }
}
