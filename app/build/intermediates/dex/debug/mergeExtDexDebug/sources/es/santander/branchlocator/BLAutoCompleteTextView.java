package es.santander.branchlocator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import es.santander.branchlocator.common.AnalyticsComponentHelper;
import java.util.HashMap;
import java.util.Map;

class BLAutoCompleteTextView extends LinearLayout {
    private AttributeSet attrs;
    /* access modifiers changed from: private */
    public BLAutoCompleteTextViewBase autoCompleteTextView;
    private ImageView btnSearch;
    private Context context;
    /* access modifiers changed from: private */
    public BLOnGetStringFromAutoComplete delegate;
    /* access modifiers changed from: private */
    public ImageView imgRemoveText;
    /* access modifiers changed from: private */
    public CharSequence termSearched;

    public BLAutoCompleteTextView(Context context2) {
        super(context2);
        this.context = context2;
        init();
    }

    public BLAutoCompleteTextView(Context context2, AttributeSet attrs2) {
        super(context2, attrs2);
        this.attrs = attrs2;
        this.context = context2;
        init();
    }

    public BLAutoCompleteTextView(Context context2, AttributeSet attrs2, int defStyleAttr) {
        super(context2, attrs2, defStyleAttr);
        this.attrs = attrs2;
        this.context = context2;
        init();
    }

    private void init() {
        setupUI(inflate(getContext(), R.layout.autocomplete_textview, this));
        setAttributes();
        setupListeners();
    }

    public void setupListener(final BLOnGetStringFromAutoComplete blOnGetStringFromAutoComplete, View.OnFocusChangeListener onFocusChangeListener) {
        this.delegate = blOnGetStringFromAutoComplete;
        this.autoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3) {
                    return false;
                }
                Map<String, String> dataLayer = new HashMap<>(1);
                dataLayer.put("ScreenName", "branch locator:home");
                dataLayer.put("TermSearched", BLUtils.stripAccents(BLAutoCompleteTextView.this.autoCompleteTextView.getText().toString()));
                dataLayer.put("EventAction", "search");
                AnalyticsComponentHelper.trackEvent("search", dataLayer);
                BLAutoCompleteTextView.this.search(blOnGetStringFromAutoComplete);
                return false;
            }
        });
        this.autoCompleteTextView.setOnFocusChangeListener(onFocusChangeListener);
        this.autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i) instanceof BLGeocoderAutoCompleteResult) {
                    BLAutoCompleteTextView.this.autoCompleteTextView.setText(((BLGeocoderAutoCompleteResult) adapterView.getItemAtPosition(i)).getAddress());
                }
                Map<String, String> dataLayer = new HashMap<>(1);
                dataLayer.put("ScreenName", "branch locator:home");
                dataLayer.put("TermSearched", BLUtils.stripAccents(BLAutoCompleteTextView.this.termSearched.toString()));
                dataLayer.put("NSearchResult", String.valueOf(BLAutoCompleteTextView.this.autoCompleteTextView.getAdapter().getCount()));
                dataLayer.put("ClickedResult", BLUtils.stripAccents(BLAutoCompleteTextView.this.autoCompleteTextView.getText().toString()));
                dataLayer.put("EventAction", "tap search result");
                AnalyticsComponentHelper.trackEvent("tap search result", dataLayer);
                BLAutoCompleteTextView.this.search(blOnGetStringFromAutoComplete);
            }
        });
        this.btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BLAutoCompleteTextView.this.search(blOnGetStringFromAutoComplete);
                Map<String, String> dataLayer = new HashMap<>(1);
                dataLayer.put("ScreenName", "branch locator:home");
                dataLayer.put("TermSearched", BLAutoCompleteTextView.this.autoCompleteTextView.getText().toString());
                dataLayer.put("EventAction", "search");
                AnalyticsComponentHelper.trackEvent("search", dataLayer);
            }
        });
    }

    /* access modifiers changed from: private */
    public void search(BLOnGetStringFromAutoComplete BLOnGetStringFromAutoComplete) {
        this.autoCompleteTextView.clearFocus();
        BLOnGetStringFromAutoComplete.onSearch(this.autoCompleteTextView.getText().toString());
        dismissDropdown();
    }

    public void setupAutoCompleteAdapter(BLPlaceAutocompleteAdapter adapter) {
        this.autoCompleteTextView.setAdapter(adapter);
    }

    public void setupAutocompleteAdapter(BLGeocoderAutocompleteAdapter adapter) {
        this.autoCompleteTextView.setAdapter(adapter);
    }

    private void setupUI(View v) {
        this.imgRemoveText = (ImageView) v.findViewById(R.id.img_remove_text);
        this.autoCompleteTextView = (BLAutoCompleteTextViewBase) v.findViewById(R.id.input_search);
        this.btnSearch = (ImageView) v.findViewById(R.id.ic_magnify);
        this.autoCompleteTextView.setInputType(145);
        this.autoCompleteTextView.setTypeface(ResourcesCompat.getFont(this.context, R.font.santander_text_italic));
    }

    private void setAttributes() {
        Context context2;
        Drawable drawable;
        ImageView imageView;
        AttributeSet attributeSet = this.attrs;
        if (attributeSet != null && (context2 = this.context) != null && (drawable = context2.obtainStyledAttributes(attributeSet, R.styleable.CustomAutoCumpleteTextView).getDrawable(R.styleable.CustomAutoCumpleteTextView_buttom_search)) != null && (imageView = this.btnSearch) != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    private void setupListeners() {
        this.autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {
                CharSequence unused = BLAutoCompleteTextView.this.termSearched = charSequence;
            }

            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                if (after > 0) {
                    BLAutoCompleteTextView.this.imgRemoveText.setVisibility(0);
                    BLAutoCompleteTextView.this.imgRemoveText.setEnabled(true);
                    return;
                }
                BLAutoCompleteTextView.this.imgRemoveText.setVisibility(4);
                BLAutoCompleteTextView.this.imgRemoveText.setEnabled(false);
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        this.autoCompleteTextView.setOnFocusChangeListener(new BLFocusChangeListener(getContext()));
        this.imgRemoveText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BLAutoCompleteTextView.this.imgRemoveText.setVisibility(4);
                BLAutoCompleteTextView.this.autoCompleteTextView.setText("");
                BLAutoCompleteTextView.this.delegate.onDelete();
            }
        });
    }

    public void clearFocus() {
        this.autoCompleteTextView.clearFocus();
    }

    private void dismissDropdown() {
        this.autoCompleteTextView.dismissDropDown();
    }

    public void setText(String text) {
        if (text != null) {
            this.autoCompleteTextView.setText(text);
        }
    }

    public void clearText() {
        this.autoCompleteTextView.setText("");
    }
}
