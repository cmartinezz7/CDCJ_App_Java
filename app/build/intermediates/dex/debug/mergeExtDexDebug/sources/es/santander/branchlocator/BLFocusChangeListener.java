package es.santander.branchlocator;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* compiled from: BLAutoCompleteTextView */
class BLFocusChangeListener implements View.OnFocusChangeListener {
    private Context context;

    BLFocusChangeListener(Context context2) {
        this.context = context2;
    }

    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == R.id.input_search && !hasFocus) {
            ((InputMethodManager) this.context.getSystemService("input_method")).hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}
