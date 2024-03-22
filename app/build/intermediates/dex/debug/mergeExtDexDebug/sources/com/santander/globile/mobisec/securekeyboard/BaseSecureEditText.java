package com.santander.globile.mobisec.securekeyboard;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.autofill.AutofillManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.textfield.TextInputEditText;
import com.santander.globile.mobisec.logger.GlobileLog;
import com.santander.globile.mobisec.securekeyboard.SanKeyboardView;
import com.santander.globile.mobisec.securekeyboard.enums.TopRowButtonsOptions;
import com.santander.globile.mobisec.securekeyboard.keyboard.SanKeyboardType;
import com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManager;
import com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManagerStatus;
import com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollSynchronicer;
import com.santander.globile.mobisec.securekeyboard.utils.SanKeyboardUtils;
import com.santander.globile.mobisec.securekeyboard.window.KeyboardWindowManager;
import com.santander.globile.mobisec.securekeyboard.window.KeyboardWindowSoftInputMode;
import com.santander.globile.mobisec.securekeyboard.window.KeyboardWindowSynchronizer;
import java.util.List;

public abstract class BaseSecureEditText extends TextInputEditText implements ViewTreeObserver.OnGlobalLayoutListener, LifecycleObserver {
    private static final String BASE_SECURE_EDIT_TEXT_TAG = "BASE_SECURE_EDIT_TEXT";
    private ViewGroup androidContentRootView;
    private AutoScrollManager autoScrollManager;
    private boolean autoScrollingStrictMode;
    private AutofillManager.AutofillCallback autofillCallback;
    private AutofillManager autofillManager;
    private TextView.OnEditorActionListener editorActionListener;
    /* access modifiers changed from: private */
    public View.OnFocusChangeListener focusListener;
    private boolean hasCheckedInvolvedWidgetsInParents;
    private boolean hasPopupCharsDismissed;
    private boolean hasRequestForShownBeforeInit;
    private InputMethodManager inputMethodManager;
    private boolean isKeyboardReady;
    private SanKeyboardType keyboardType;
    /* access modifiers changed from: private */
    public KeyboardWindowManager keyboardWindowManager;
    private KeyboardWindowSoftInputMode keyboardWindowSoftInputMode;
    private SanKeyboardView.OnKeyListener onKeyListener;
    private String ownerName;
    private Lifecycle parentLifecycle;
    private NestedScrollView parentNestedScrollView;
    private ViewPager parentViewPager;
    private int rootLayoutIdForAutoScrolling;
    private int rootLayoutPageIndexInViewPager;
    private SanKeyboardView.SanKeyboardCallback sanKeyboardCallback;
    private SanKeyboardView sanKeyboardView;
    private TopRowButtonsOptions topRowButtons;

    public BaseSecureEditText(Context context) {
        super(context);
        initializeView(context, (AttributeSet) null);
    }

    public BaseSecureEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView(context, attrs);
    }

    public BaseSecureEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView(context, attrs);
    }

    /* JADX INFO: finally extract failed */
    private void initializeView(Context context, AttributeSet attrs) {
        Context appContext = context.getApplicationContext();
        setFocusable(false);
        if (Build.VERSION.SDK_INT >= 21) {
            setShowSoftInputOnFocus(false);
        } else {
            this.inputMethodManager = (InputMethodManager) appContext.getSystemService("input_method");
        }
        TypedArray typedArray = appContext.obtainStyledAttributes(attrs, R.styleable.BaseSecureEditText, 0, 0);
        try {
            setKeyboardType(SanKeyboardType.values()[typedArray.getInt(R.styleable.BaseSecureEditText_sanKeyboardType, 0)]);
            this.topRowButtons = TopRowButtonsOptions.values()[typedArray.getInt(R.styleable.BaseSecureEditText_sanKeyboardButtons, 0)];
            this.rootLayoutIdForAutoScrolling = typedArray.getResourceId(R.styleable.BaseSecureEditText_rootLayoutIdForAutoScrolling, -1);
            this.autoScrollingStrictMode = typedArray.getBoolean(R.styleable.BaseSecureEditText_autoScrollingStrictMode, false);
            this.keyboardWindowSoftInputMode = KeyboardWindowSoftInputMode.values()[typedArray.getInt(R.styleable.BaseSecureEditText_windowSoftInputMode, 0)];
            typedArray.recycle();
            getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.hasPopupCharsDismissed = false;
            this.rootLayoutPageIndexInViewPager = -1;
            this.isKeyboardReady = false;
            this.hasRequestForShownBeforeInit = false;
            this.parentViewPager = null;
            this.hasCheckedInvolvedWidgetsInParents = false;
            this.ownerName = "";
            if (getInputType() == 1) {
                setInputType(524289);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                setAutofillCallback(context);
            }
        } catch (Throwable th) {
            typedArray.recycle();
            throw th;
        }
    }

    private void enableRootLayoutFocusableInTouchModeIfNecessary() {
        ViewGroup viewGroup = this.androidContentRootView;
        if (viewGroup == null) {
            throw new IllegalStateException("Error setting android.R.id.content Focusable In Touch Mode. Maybe this SecureEditText doesn't exist anymore in the current window?");
        } else if (!viewGroup.isFocusableInTouchMode()) {
            this.androidContentRootView.setFocusableInTouchMode(true);
            this.androidContentRootView.setFocusable(true);
        }
    }

    private void setRootLayoutFocusableInTouchMode(boolean isFocusable) {
        if (this.androidContentRootView == null) {
            this.androidContentRootView = (ViewGroup) getRootView().findViewById(16908290);
        }
        this.androidContentRootView.setFocusableInTouchMode(isFocusable);
        this.androidContentRootView.setFocusable(isFocusable);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.santander.globile.mobisec.securekeyboard.BaseSecureEditText, android.view.View] */
    private void initSanKeyboardInstance() {
        if (this.sanKeyboardView == null) {
            this.sanKeyboardView = SanKeyboardUtils.createKeyboardView(this);
        }
        this.sanKeyboardView.setSanKeyboardCallback(this.sanKeyboardCallback);
        this.sanKeyboardView.setInputConnection(this);
        this.sanKeyboardView.setOnKeyListener(this.onKeyListener);
        this.sanKeyboardView.setOnEditorActionListener(this.editorActionListener);
    }

    private void initAutoScrollManager() {
        if (!this.hasCheckedInvolvedWidgetsInParents) {
            locateInvolvedWidgetsInParents();
        }
        this.autoScrollManager = AutoScrollSynchronicer.getInstance().getAutoScrollManagerFor(getContext(), this.ownerName, this.rootLayoutIdForAutoScrolling, this.rootLayoutPageIndexInViewPager);
    }

    private void initWindowKeyboardManager(FragmentActivity parentActivity) {
        this.keyboardWindowManager = KeyboardWindowSynchronizer.getInstance().getWindowManagerFor(parentActivity.getWindow());
    }

    private void locateViewPagerInParents() {
        ViewPager viewPager = null;
        ViewPager viewPager2 = (ViewGroup) getParent();
        while (viewPager2 != null && viewPager == null && viewPager2.getId() != 16908290) {
            viewPager2 = (ViewGroup) viewPager2.getParent();
            if (viewPager2 instanceof ViewPager) {
                viewPager = viewPager2;
            }
        }
        if (viewPager != null) {
            this.parentViewPager = viewPager;
            int i = 0;
            while (i < viewPager.getChildCount()) {
                BaseSecureEditText secureEditText = (BaseSecureEditText) viewPager.getChildAt(i).findViewById(getId());
                if (secureEditText == null || !secureEditText.equals(this)) {
                    i++;
                } else {
                    this.rootLayoutPageIndexInViewPager = i;
                    return;
                }
            }
        }
        this.hasCheckedInvolvedWidgetsInParents = true;
    }

    private void locateInvolvedWidgetsInParents() {
        ViewPager viewPager = (ViewGroup) getParent();
        while (true) {
            boolean z = true;
            if (viewPager != null && viewPager.getId() != 16908290 && (this.parentViewPager == null || this.parentNestedScrollView == null)) {
                if (viewPager.getId() != this.rootLayoutIdForAutoScrolling) {
                    z = false;
                }
                boolean hasRootLayoutReached = z;
                viewPager = (ViewGroup) viewPager.getParent();
                if (viewPager instanceof ViewPager) {
                    this.parentViewPager = viewPager;
                }
                if (!hasRootLayoutReached && this.parentNestedScrollView == null && (viewPager instanceof NestedScrollView)) {
                    this.parentNestedScrollView = viewPager;
                }
            }
        }
        if (this.parentViewPager != null) {
            int i = 0;
            while (i < this.parentViewPager.getChildCount()) {
                BaseSecureEditText secureEditText = (BaseSecureEditText) this.parentViewPager.getChildAt(i).findViewById(getId());
                if (secureEditText == null || !secureEditText.equals(this)) {
                    i++;
                } else {
                    this.rootLayoutPageIndexInViewPager = i;
                    return;
                }
            }
        }
        this.hasCheckedInvolvedWidgetsInParents = true;
    }

    private FragmentActivity getFragmentActivity() {
        FragmentActivity context = getContext();
        while (!(context instanceof FragmentActivity)) {
            try {
                context = ((ContextWrapper) context).getBaseContext();
            } catch (Exception e) {
                throw new IllegalArgumentException("The Context used to instantiate this BaseSecureEditText it's not valid. Context must belong to an Activity or Fragment. \nAlso, Activities must be allowed to support Fragments (use FragmentActivity or AppCompatActivity)\nMight are you providing applicationContext instead of Activity/Fragment Context where the widget is laid on?");
            }
        }
        return context;
    }

    private void attachToParentLifeCycle(FragmentActivity parentActivity) {
        if (!attachForFragmentIfExists(parentActivity.getSupportFragmentManager().getFragments()) && parentActivity.findViewById(getId()) != null) {
            Lifecycle lifecycle = parentActivity.getLifecycle();
            this.parentLifecycle = lifecycle;
            lifecycle.addObserver(this);
            this.ownerName = parentActivity.getClass().getSimpleName();
        }
    }

    private boolean attachForFragmentIfExists(List<Fragment> fragmentList) {
        boolean found = false;
        for (int i = 0; i < fragmentList.size() && !found; i++) {
            View rootView = fragmentList.get(i).getView();
            if (rootView != null && (!(fragmentList.get(i) instanceof NavHostFragment) || !(found = attachForFragmentIfExists(fragmentList.get(i).getChildFragmentManager().getFragments())))) {
                BaseSecureEditText secureEditText = (BaseSecureEditText) rootView.findViewById(getId());
                if (secureEditText == null || !secureEditText.equals(this)) {
                    found = attachForFragmentIfExists(fragmentList.get(i).getChildFragmentManager().getFragments());
                } else if (this.parentViewPager != null) {
                    return locateParentFragmentInViewPager(fragmentList.get(i));
                } else {
                    found = attachToFragmentLifecycle(fragmentList.get(i));
                }
            }
        }
        return found;
    }

    private boolean locateParentFragmentInViewPager(Fragment viewPagerFragment) {
        List<Fragment> childFragmentsList = viewPagerFragment.getChildFragmentManager().getFragments();
        for (int j = 0; j < childFragmentsList.size(); j++) {
            if (this.parentViewPager.getChildAt(this.rootLayoutPageIndexInViewPager).equals(childFragmentsList.get(j).getView()) && attachToFragmentLifecycle(childFragmentsList.get(j))) {
                return true;
            }
        }
        return false;
    }

    private boolean attachToFragmentLifecycle(Fragment parentFragment) {
        BaseSecureEditText secureEditText;
        if (parentFragment.getView() == null || (secureEditText = (BaseSecureEditText) parentFragment.getView().findViewById(getId())) == null || !secureEditText.equals(this)) {
            return false;
        }
        Lifecycle lifecycle = parentFragment.getViewLifecycleOwner().getLifecycle();
        this.parentLifecycle = lifecycle;
        lifecycle.addObserver(this);
        this.ownerName = parentFragment.getClass().getSimpleName();
        return true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        onDestroyView();
    }

    private void setAutofillCallback(Context context) {
        AutofillManager autofillManager2 = (AutofillManager) context.getSystemService(AutofillManager.class);
        this.autofillManager = autofillManager2;
        if (autofillManager2 != null) {
            AnonymousClass1 r0 = new AutofillManager.AutofillCallback() {
                public void onAutofillEvent(View view, int event) {
                    super.onAutofillEvent(view, event);
                    if (event == 1) {
                        BaseSecureEditText.this.keyboardWindowManager.setAutoFillShown(true);
                        GlobileLog.d("AUTOFILL", "AUTOFILL GETS SHOWN: " + BaseSecureEditText.this.keyboardWindowManager.isAutoFillShown());
                    } else if (event != 2) {
                        BaseSecureEditText.this.keyboardWindowManager.setAutoFillShown(false);
                        GlobileLog.d("AUTOFILL", "AUTOFILL NOT AVAILABLE " + BaseSecureEditText.this.keyboardWindowManager.isAutoFillShown());
                    } else {
                        BaseSecureEditText.this.keyboardWindowManager.setAutoFillShown(false);
                        GlobileLog.d("AUTOFILL", "AUTOFILL GETS HIDDEN??: " + BaseSecureEditText.this.keyboardWindowManager.isAutoFillShown());
                    }
                }

                public void onAutofillEvent(View view, int virtualId, int event) {
                    super.onAutofillEvent(view, virtualId, event);
                    if (event == 1) {
                        BaseSecureEditText.this.keyboardWindowManager.setAutoFillShown(true);
                        GlobileLog.d("AUTOFILL VIRTUAL ID", "AUTOFILL GETS SHOWN: " + BaseSecureEditText.this.keyboardWindowManager.isAutoFillShown());
                    } else if (event != 2) {
                        BaseSecureEditText.this.keyboardWindowManager.setAutoFillShown(false);
                        GlobileLog.d("AUTOFILL VIRTUAL ID", "AUTOFILL NOT AVAILABLE " + BaseSecureEditText.this.keyboardWindowManager.isAutoFillShown());
                    } else {
                        BaseSecureEditText.this.keyboardWindowManager.setAutoFillShown(false);
                        GlobileLog.d("AUTOFILL VIRTUAL ID", "AUTOFILL GETS HIDDEN??: " + BaseSecureEditText.this.keyboardWindowManager.isAutoFillShown());
                    }
                }
            };
            this.autofillCallback = r0;
            this.autofillManager.registerCallback(r0);
        }
    }

    public int getRootLayoutIdForAutoScrolling() {
        return this.rootLayoutIdForAutoScrolling;
    }

    public SanKeyboardType getKeyboardType() {
        return this.keyboardType;
    }

    public TopRowButtonsOptions getTopRowButtons() {
        return this.topRowButtons;
    }

    public boolean isAutoScrollingStrictMode() {
        return this.autoScrollingStrictMode;
    }

    public KeyboardWindowSoftInputMode getKeyboardWindowSoftInputMode() {
        return this.keyboardWindowSoftInputMode;
    }

    public NestedScrollView getParentNestedScrollView() {
        return this.parentNestedScrollView;
    }

    public void setRootLayoutIdForAutoScrolling(int rootLayoutIdForAutoScrolling2) {
        AutoScrollManager autoScrollManager2 = this.autoScrollManager;
        if (autoScrollManager2 == null || autoScrollManager2.getStatus() == AutoScrollManagerStatus.NOT_SETTED) {
            this.rootLayoutIdForAutoScrolling = rootLayoutIdForAutoScrolling2;
            return;
        }
        throw new IllegalStateException("Cannot set Root Layout ID when AutoScroll manager is started");
    }

    public void setKeyboardType(SanKeyboardType keyboardType2) {
        this.keyboardType = keyboardType2;
    }

    public void setSanKeyboardCallback(SanKeyboardView.SanKeyboardCallback sanKeyboardCallback2) {
        this.sanKeyboardCallback = sanKeyboardCallback2;
    }

    public void setTopRowButtons(TopRowButtonsOptions topRowButtonsOptions) {
        this.topRowButtons = topRowButtonsOptions;
    }

    public void setAutoScrollingStrictMode(boolean isStrictMode) {
        this.autoScrollingStrictMode = isStrictMode;
    }

    public void setKeyboardWindowSoftInputMode(KeyboardWindowSoftInputMode windowSoftInputMode) {
        AutoScrollManager autoScrollManager2 = this.autoScrollManager;
        if (autoScrollManager2 == null || autoScrollManager2.getStatus() == AutoScrollManagerStatus.NOT_SETTED) {
            this.keyboardWindowSoftInputMode = windowSoftInputMode;
            return;
        }
        throw new IllegalStateException("Cannot set WindowSoftInputMode when AutoScroll manager is started");
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener l) {
        this.editorActionListener = l;
        SanKeyboardView sanKeyboardView2 = this.sanKeyboardView;
        if (sanKeyboardView2 != null) {
            sanKeyboardView2.setOnEditorActionListener(l);
        }
        super.setOnEditorActionListener(l);
    }

    public void setOnKeyListener(SanKeyboardView.OnKeyListener listener) {
        this.onKeyListener = listener;
        SanKeyboardView sanKeyboardView2 = this.sanKeyboardView;
        if (sanKeyboardView2 != null) {
            sanKeyboardView2.setOnKeyListener(listener);
        }
    }

    public void onGlobalLayout() {
        this.isKeyboardReady = false;
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (getId() != -1) {
            try {
                initSanKeyboardInstance();
                setRootLayoutFocusableInTouchMode(true);
                setFocusable(true);
                setFocusableInTouchMode(true);
                FragmentActivity parentActivity = getFragmentActivity();
                initWindowKeyboardManager(parentActivity);
                attachToParentLifeCycle(parentActivity);
                if (this.rootLayoutIdForAutoScrolling != -1) {
                    initAutoScrollManager();
                }
                if (this.hasRequestForShownBeforeInit) {
                    requestFocus();
                    showSanKeyboard();
                    this.hasRequestForShownBeforeInit = false;
                } else {
                    clearFocus();
                }
                this.isKeyboardReady = true;
            } catch (IllegalStateException e) {
                if (e.getMessage() != null) {
                    if (e.getMessage().equals("Error creating keyboard!")) {
                        GlobileLog.e(BASE_SECURE_EDIT_TEXT_TAG, "Error initializing SanKeyboard instance. Maybe this SecureEditText doesn't exist anymore?");
                    } else {
                        GlobileLog.e(BASE_SECURE_EDIT_TEXT_TAG, e.getMessage());
                    }
                }
                onDestroyView();
            }
        } else {
            throw new IllegalArgumentException(getClass().getCanonicalName() + " doesn't have an ID assigned! ");
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        GlobileLog.i(BASE_SECURE_EDIT_TEXT_TAG, "Hardware keyboard detected! Force hidding native keyboard...");
        if (this.inputMethodManager == null) {
            this.inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        }
        InputMethodManager inputMethodManager2 = this.inputMethodManager;
        if (inputMethodManager2 != null) {
            inputMethodManager2.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        KeyboardWindowManager keyboardWindowManager2;
        if (!hasWindowFocus && (keyboardWindowManager2 = this.keyboardWindowManager) != null && !keyboardWindowManager2.isAutoFillShown()) {
            clearAutoScrollExtraRequests();
            clearFocus();
        }
        super.onWindowFocusChanged(hasWindowFocus);
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener listener) {
        this.focusListener = listener;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        GlobileLog.d(BASE_SECURE_EDIT_TEXT_TAG, "> INTERNAL OnFocusChanged... Focused: " + focused + "\nId: " + getMyId());
        handleFocusChangeListener(focused);
        if (!focused) {
            AutoScrollManager autoScrollManager2 = this.autoScrollManager;
            if (autoScrollManager2 == null || autoScrollManager2.getStatus() != AutoScrollManagerStatus.STARTING) {
                hideSanKeyboard();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* JADX WARNING: type inference failed for: r1v0, types: [com.santander.globile.mobisec.securekeyboard.BaseSecureEditText, android.view.View] */
                    public void run() {
                        BaseSecureEditText.this.retainFocus();
                        if (BaseSecureEditText.this.focusListener != null) {
                            BaseSecureEditText.this.focusListener.onFocusChange(BaseSecureEditText.this, true);
                        }
                    }
                });
            }
        } else if (this.isKeyboardReady) {
            showSanKeyboard();
        } else {
            this.hasRequestForShownBeforeInit = true;
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.santander.globile.mobisec.securekeyboard.BaseSecureEditText, android.view.View] */
    private void handleFocusChangeListener(boolean focused) {
        View.OnFocusChangeListener onFocusChangeListener = this.focusListener;
        if (onFocusChangeListener == null) {
            return;
        }
        if (this.rootLayoutIdForAutoScrolling != -1) {
            AutoScrollManager autoScrollManager2 = this.autoScrollManager;
            if (autoScrollManager2 != null && autoScrollManager2.getStatus() == AutoScrollManagerStatus.SETTED) {
                this.focusListener.onFocusChange(this, focused);
                return;
            }
            return;
        }
        onFocusChangeListener.onFocusChange(this, focused);
    }

    /* access modifiers changed from: package-private */
    public void retainFocus() {
        requestFocus();
        clearAutoScrollExtraRequests();
    }

    /* access modifiers changed from: package-private */
    public void clearAutoScrollExtraRequests() {
        AutoScrollManager autoScrollManager2 = this.autoScrollManager;
        if (autoScrollManager2 != null) {
            autoScrollManager2.clearExtraRequests();
        }
    }

    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        boolean result = super.onKeyPreIme(keyCode, event);
        if (this.hasPopupCharsDismissed) {
            this.hasPopupCharsDismissed = false;
            return true;
        }
        if (4 == event.getKeyCode()) {
            this.hasPopupCharsDismissed = this.sanKeyboardView.handleBack();
            notifyOnKey(4);
            if (this.hasPopupCharsDismissed) {
                return true;
            }
        }
        if (isKeyEventConsumed(keyCode, event) || result) {
            return true;
        }
        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return isKeyEventConsumed(keyCode, event) || super.onKeyUp(keyCode, event);
    }

    private boolean isKeyEventConsumed(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !isSanKeyboardShown()) {
            return false;
        }
        clearAutoScrollExtraRequests();
        clearFocus();
        return true;
    }

    private void notifyOnKey(int primaryCode) {
        SanKeyboardView.OnKeyListener onKeyListener2 = this.onKeyListener;
        if (onKeyListener2 != null) {
            onKeyListener2.onKey(primaryCode);
        }
    }

    public boolean isSanKeyboardShown() {
        SanKeyboardView sanKeyboardView2 = this.sanKeyboardView;
        return sanKeyboardView2 != null && sanKeyboardView2.isShown();
    }

    public boolean isLanguageSelectorShown() {
        SanKeyboardView sanKeyboardView2 = this.sanKeyboardView;
        return sanKeyboardView2 != null && sanKeyboardView2.isLanguageSelectorShown();
    }

    public void showSanSecureKeyboard() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                BaseSecureEditText.this.lambda$showSanSecureKeyboard$0$BaseSecureEditText();
            }
        });
    }

    public /* synthetic */ void lambda$showSanSecureKeyboard$0$BaseSecureEditText() {
        if (this.isKeyboardReady) {
            requestFocus();
        } else {
            this.hasRequestForShownBeforeInit = true;
        }
    }

    public void hideSanSecureKeyboard() {
        clearAutoScrollExtraRequests();
        clearFocus();
    }

    private void showSanKeyboard() {
        hideDefaultKeyboard();
        initSanKeyboardInstance();
        KeyboardWindowManager keyboardWindowManager2 = this.keyboardWindowManager;
        if (keyboardWindowManager2 != null) {
            keyboardWindowManager2.initFlagsForShowingKeyboard();
        }
        if (!this.sanKeyboardView.isShown() || this.sanKeyboardView.isAnimating()) {
            this.sanKeyboardView.slideIn();
        } else {
            this.sanKeyboardView.clearAnimation();
        }
        enableAutoScrollIfNecessary();
    }

    private void enableAutoScrollIfNecessary() {
        if (this.autoScrollManager == null && this.rootLayoutIdForAutoScrolling != -1) {
            initAutoScrollManager();
        }
        AutoScrollManager autoScrollManager2 = this.autoScrollManager;
        if (autoScrollManager2 == null) {
            return;
        }
        if (this.autoScrollingStrictMode) {
            autoScrollManager2.startAutoScrollingForField(this, this.sanKeyboardView);
        } else if (autoScrollManager2.getStatus() == AutoScrollManagerStatus.NOT_SETTED) {
            setRootLayoutFocusableInTouchMode(false);
            this.autoScrollManager.startAutoScrollingForField(this, this.sanKeyboardView);
            enableRootLayoutFocusableInTouchModeIfNecessary();
        } else {
            this.autoScrollManager.showExtraSpaceForScrolling(this, this.sanKeyboardView);
        }
    }

    private void hideSanKeyboard() {
        if (isSanKeyboardShown() && !isLanguageSelectorShown()) {
            disableAutoScroll();
            this.sanKeyboardView.handleBack();
            this.sanKeyboardView.slideOut();
            KeyboardWindowManager keyboardWindowManager2 = this.keyboardWindowManager;
            if (keyboardWindowManager2 != null) {
                keyboardWindowManager2.restoreOriginalFlags();
            }
        }
    }

    private void disableAutoScroll() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                BaseSecureEditText.this.lambda$disableAutoScroll$1$BaseSecureEditText();
            }
        });
    }

    public /* synthetic */ void lambda$disableAutoScroll$1$BaseSecureEditText() {
        AutoScrollManager autoScrollManager2 = this.autoScrollManager;
        if (autoScrollManager2 == null) {
            return;
        }
        if (this.autoScrollingStrictMode) {
            autoScrollManager2.stopAutoScrollingForField();
        } else {
            autoScrollManager2.hideExtraBottomSpaceForScrolling(this);
        }
    }

    private void hideDefaultKeyboard() {
        InputMethodManager inputMethodManager2 = this.inputMethodManager;
        if (inputMethodManager2 != null) {
            inputMethodManager2.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public void enableDisableCustomKey(int code, boolean enabled) {
        initSanKeyboardInstance();
        this.sanKeyboardView.getKeyboard().enableDisableCustomKey(code, enabled);
    }

    public void onDestroyView() {
        AutofillManager autofillManager2;
        hideSanSecureKeyboard();
        this.focusListener = null;
        this.androidContentRootView = null;
        AutoScrollManager autoScrollManager2 = this.autoScrollManager;
        if (autoScrollManager2 != null) {
            autoScrollManager2.clearExtraRequests();
            this.autoScrollManager.stopAutoScrollingForField();
            AutoScrollSynchronicer.getInstance().releaseAutoScrollManagerFor(this.ownerName, this.rootLayoutIdForAutoScrolling, this.rootLayoutPageIndexInViewPager);
            this.autoScrollManager = null;
        }
        KeyboardWindowManager keyboardWindowManager2 = this.keyboardWindowManager;
        if (keyboardWindowManager2 != null) {
            keyboardWindowManager2.restoreOriginalFlags();
            KeyboardWindowSynchronizer.getInstance().releaseWindowManagerFor(this.keyboardWindowManager);
            this.keyboardWindowManager = null;
        }
        SanKeyboardView sanKeyboardView2 = this.sanKeyboardView;
        if (sanKeyboardView2 != null) {
            sanKeyboardView2.onDestroyView();
            this.sanKeyboardView = null;
        }
        this.inputMethodManager = null;
        this.sanKeyboardCallback = null;
        this.parentViewPager = null;
        this.parentNestedScrollView = null;
        this.editorActionListener = null;
        this.onKeyListener = null;
        Lifecycle lifecycle = this.parentLifecycle;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
            this.parentLifecycle = null;
        }
        if (Build.VERSION.SDK_INT >= 26 && (autofillManager2 = this.autofillManager) != null) {
            autofillManager2.unregisterCallback(this.autofillCallback);
            this.autofillManager = null;
            this.autofillCallback = null;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseSecureEditText) || getId() != ((BaseSecureEditText) obj).getId()) {
            return false;
        }
        return true;
    }

    public String getMyId() {
        String myFullId = getResources().getResourceName(getId());
        String[] split = myFullId.split(":");
        return split.length == 2 ? split[1] : myFullId;
    }
}
