package es.santander.justicia.minisJusticia.filters;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexInputFilter implements InputFilter {
   private Pattern mPattern;
   private static final String CLASS_NAME = RegexInputFilter.class.getSimpleName();

   public RegexInputFilter(String pattern) {
      this(Pattern.compile(pattern));
   }

   public RegexInputFilter(Pattern pattern) {
      if (pattern == null) {
         throw new IllegalArgumentException(CLASS_NAME + " requires a regex.");
      } else {
         this.mPattern = pattern;
      }
   }

   public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
      Matcher matcher = this.mPattern.matcher(source);
      return !matcher.matches() ? "" : null;
   }
}
