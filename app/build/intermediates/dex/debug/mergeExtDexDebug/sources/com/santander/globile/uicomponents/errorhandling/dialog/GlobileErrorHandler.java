package com.santander.globile.uicomponents.errorhandling.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.buttons.endingbutton.GlobileEndingButton;
import com.santander.globile.uicomponents.errorhandling.common.ConstantsKt;
import com.santander.globile.uicomponents.text.SantanderTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004+,-.B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0004H\u0002J,\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010*\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler;", "Landroidx/fragment/app/DialogFragment;", "()V", "_onButtonNegative", "Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler$OnClickListener;", "_onButtonPositive", "_onCancelListener", "Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler$OnCancelListener;", "_onDismissListener", "Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler$OnDismissListener;", "buttonsDisplayed", "", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "readMessageToAccessibility", "message", "", "setOnCancelListener", "onCancelListener", "setOnDismissListener", "onDismissListener", "setOnNegativeButtonListener", "onButtonLeftListener", "setOnPositiveButtonListener", "onButtonRightListener", "showButton", "view", "Landroid/widget/Button;", "text", "listener", "code", "Builder", "OnCancelListener", "OnClickListener", "OnDismissListener", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileErrorHandler.kt */
public final class GlobileErrorHandler extends DialogFragment {
    private HashMap _$_findViewCache;
    private OnClickListener _onButtonNegative;
    private OnClickListener _onButtonPositive;
    private OnCancelListener _onCancelListener;
    /* access modifiers changed from: private */
    public OnDismissListener _onDismissListener;
    private int buttonsDisplayed;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler$OnCancelListener;", "", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileErrorHandler.kt */
    public interface OnCancelListener {
        void onCancel(DialogInterface dialogInterface);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler$OnClickListener;", "", "onButtonClick", "", "code", "", "dialog", "Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileErrorHandler.kt */
    public interface OnClickListener {
        void onButtonClick(int i, GlobileErrorHandler globileErrorHandler);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler$OnDismissListener;", "", "onDismiss", "", "dialog", "Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileErrorHandler.kt */
    public interface OnDismissListener {
        void onDismiss(GlobileErrorHandler globileErrorHandler);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        GlobileErrorHandler.super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Window window2;
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        View view = inflater.inflate(R.layout.dialog_fragment_error_handling, container, false);
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            if (dialog == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(dialog, "dialog!!");
            if (dialog.getWindow() != null) {
                Dialog dialog2 = getDialog();
                if (!(dialog2 == null || (window2 = dialog2.getWindow()) == null)) {
                    window2.requestFeature(1);
                }
                Dialog dialog3 = getDialog();
                if (!(dialog3 == null || (window = dialog3.getWindow()) == null)) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
            }
        }
        String string = getString(R.string.dialog_opened_content_description);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(\n            R…ened_content_description)");
        readMessageToAccessibility(string);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        GlobileErrorHandler.super.onActivityCreated(savedInstanceState);
        initView();
        ((ImageButton) _$_findCachedViewById(R.id.close)).setOnClickListener(new GlobileErrorHandler$onActivityCreated$1(this));
    }

    /* access modifiers changed from: private */
    public final void readMessageToAccessibility(String message) {
        Toast toast = Toast.makeText(getContext(), message, 0);
        Intrinsics.checkExpressionValueIsNotNull(toast, "toast");
        View view = toast.getView();
        Intrinsics.checkExpressionValueIsNotNull(view, "toast.view");
        view.setVisibility(8);
        toast.show();
    }

    private final void initView() {
        String it;
        String it2;
        String it3;
        String it4;
        String it5;
        Bundle arguments = getArguments();
        int i = 0;
        if (arguments == null || (it5 = arguments.getString(ConstantsKt.TITLE_TEXT)) == null) {
            SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.title);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView, ConstantsKt.TITLE_TEXT);
            santanderTextView.setVisibility(8);
        } else {
            SantanderTextView santanderTextView2 = (SantanderTextView) _$_findCachedViewById(R.id.title);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView2, ConstantsKt.TITLE_TEXT);
            santanderTextView2.setText(it5);
            SantanderTextView santanderTextView3 = (SantanderTextView) _$_findCachedViewById(R.id.title);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView3, ConstantsKt.TITLE_TEXT);
            santanderTextView3.setVisibility(0);
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (it4 = arguments2.getString(ConstantsKt.SUBTITLE_TEXT)) == null) {
            SantanderTextView santanderTextView4 = (SantanderTextView) _$_findCachedViewById(R.id.subTitle);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView4, "subTitle");
            santanderTextView4.setVisibility(8);
        } else {
            SantanderTextView santanderTextView5 = (SantanderTextView) _$_findCachedViewById(R.id.subTitle);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView5, "subTitle");
            santanderTextView5.setText(it4);
            SantanderTextView santanderTextView6 = (SantanderTextView) _$_findCachedViewById(R.id.subTitle);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView6, "subTitle");
            santanderTextView6.setVisibility(0);
        }
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (it3 = arguments3.getString(ConstantsKt.MESSAGE_TEXT)) == null) {
            SantanderTextView santanderTextView7 = (SantanderTextView) _$_findCachedViewById(R.id.message);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView7, ConstantsKt.MESSAGE_TEXT);
            santanderTextView7.setVisibility(8);
        } else {
            SantanderTextView santanderTextView8 = (SantanderTextView) _$_findCachedViewById(R.id.message);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView8, ConstantsKt.MESSAGE_TEXT);
            santanderTextView8.setText(it3);
            SantanderTextView santanderTextView9 = (SantanderTextView) _$_findCachedViewById(R.id.message);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView9, ConstantsKt.MESSAGE_TEXT);
            santanderTextView9.setVisibility(0);
        }
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (it2 = arguments4.getString(ConstantsKt.POSITIVE_BUTTON_MESSAGE_TEXT)) == null) {
            GlobileEndingButton globileEndingButton = (GlobileEndingButton) _$_findCachedViewById(R.id.positiveButton);
            Intrinsics.checkExpressionValueIsNotNull(globileEndingButton, "positiveButton");
            globileEndingButton.setVisibility(8);
        } else {
            GlobileEndingButton globileEndingButton2 = (GlobileEndingButton) _$_findCachedViewById(R.id.positiveButton);
            Intrinsics.checkExpressionValueIsNotNull(globileEndingButton2, "positiveButton");
            showButton((Button) globileEndingButton2, it2, this._onButtonPositive, 1);
        }
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (it = arguments5.getString(ConstantsKt.NEGATIVE_BUTTON_MESSAGE_TEXT)) == null) {
            GlobileEndingButton globileEndingButton3 = (GlobileEndingButton) _$_findCachedViewById(R.id.negativeButton);
            Intrinsics.checkExpressionValueIsNotNull(globileEndingButton3, "negativeButton");
            globileEndingButton3.setVisibility(8);
        } else {
            GlobileEndingButton globileEndingButton4 = (GlobileEndingButton) _$_findCachedViewById(R.id.negativeButton);
            Intrinsics.checkExpressionValueIsNotNull(globileEndingButton4, "negativeButton");
            showButton((Button) globileEndingButton4, it, this._onButtonNegative, 2);
        }
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            boolean it6 = arguments6.getBoolean(ConstantsKt.ALLOW_ONCANCEL);
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.setCanceledOnTouchOutside(it6);
            }
        }
        View _$_findCachedViewById = _$_findCachedViewById(R.id.spacer_bottom);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "spacer_bottom");
        if (this.buttonsDisplayed == 0) {
            i = 8;
        }
        _$_findCachedViewById.setVisibility(i);
    }

    private final void showButton(Button view, String text, OnClickListener listener, int code) {
        CharSequence charSequence = text;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            view.setText(text);
            view.setOnClickListener(new GlobileErrorHandler$showButton$1(this, listener, code, text));
            view.setVisibility(0);
            this.buttonsDisplayed++;
            return;
        }
        view.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this._onDismissListener = onDismissListener;
    }

    /* access modifiers changed from: private */
    public final void setOnCancelListener(OnCancelListener onCancelListener) {
        this._onCancelListener = onCancelListener;
    }

    /* access modifiers changed from: private */
    public final void setOnPositiveButtonListener(OnClickListener onButtonRightListener) {
        this._onButtonPositive = onButtonRightListener;
    }

    /* access modifiers changed from: private */
    public final void setOnNegativeButtonListener(OnClickListener onButtonLeftListener) {
        this._onButtonNegative = onButtonLeftListener;
    }

    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkParameterIsNotNull(dialog, ConstantsKt.DIALOG_TAG);
        OnCancelListener onCancelListener = this._onCancelListener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialog);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rJ\u001a\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler$Builder;", "", "()V", "allowOnCancel", "", "messageText", "", "negativeButtonText", "onCancelListener", "Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler$OnCancelListener;", "onDismissListener", "Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler$OnDismissListener;", "onNegativeButtonListener", "Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler$OnClickListener;", "onPositiveButtonListener", "positiveButtonText", "subTitleText", "titleText", "addNegativeButton", "text", "onButtonListener", "addPositiveButton", "build", "Lcom/santander/globile/uicomponents/errorhandling/dialog/GlobileErrorHandler;", "message", "subTitle", "title", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileErrorHandler.kt */
    public static final class Builder {
        private boolean allowOnCancel = true;
        private String messageText;
        private String negativeButtonText;
        private OnCancelListener onCancelListener;
        private OnDismissListener onDismissListener;
        private OnClickListener onNegativeButtonListener;
        private OnClickListener onPositiveButtonListener;
        private String positiveButtonText;
        private String subTitleText;
        private String titleText;

        public final Builder title(String titleText2) {
            Intrinsics.checkParameterIsNotNull(titleText2, "titleText");
            this.titleText = titleText2;
            return this;
        }

        public final Builder subTitle(String subTitle) {
            Intrinsics.checkParameterIsNotNull(subTitle, "subTitle");
            this.subTitleText = subTitle;
            return this;
        }

        public final Builder message(String message) {
            Intrinsics.checkParameterIsNotNull(message, ConstantsKt.MESSAGE_TEXT);
            this.messageText = message;
            return this;
        }

        public static /* synthetic */ Builder addPositiveButton$default(Builder builder, String str, OnClickListener onClickListener, int i, Object obj) {
            if ((i & 2) != 0) {
                onClickListener = null;
            }
            return builder.addPositiveButton(str, onClickListener);
        }

        public final Builder addPositiveButton(String text, OnClickListener onButtonListener) {
            Intrinsics.checkParameterIsNotNull(text, "text");
            this.positiveButtonText = text;
            this.onPositiveButtonListener = onButtonListener;
            return this;
        }

        public static /* synthetic */ Builder addNegativeButton$default(Builder builder, String str, OnClickListener onClickListener, int i, Object obj) {
            if ((i & 2) != 0) {
                onClickListener = null;
            }
            return builder.addNegativeButton(str, onClickListener);
        }

        public final Builder addNegativeButton(String text, OnClickListener onButtonListener) {
            Intrinsics.checkParameterIsNotNull(text, "text");
            this.negativeButtonText = text;
            this.onNegativeButtonListener = onButtonListener;
            return this;
        }

        public final Builder onDismissListener(OnDismissListener onDismissListener2) {
            Intrinsics.checkParameterIsNotNull(onDismissListener2, "onDismissListener");
            this.onDismissListener = onDismissListener2;
            return this;
        }

        public final Builder onCancelListener(OnCancelListener onCancelListener2) {
            Intrinsics.checkParameterIsNotNull(onCancelListener2, "onCancelListener");
            this.onCancelListener = onCancelListener2;
            return this;
        }

        public final Builder allowOnCancel(boolean allowOnCancel2) {
            this.allowOnCancel = allowOnCancel2;
            return this;
        }

        public final GlobileErrorHandler build() {
            GlobileErrorHandler globileErrorHandler = new GlobileErrorHandler();
            GlobileErrorHandler $this$apply = globileErrorHandler;
            OnDismissListener it = this.onDismissListener;
            if (it != null) {
                $this$apply.setOnDismissListener(it);
            }
            OnCancelListener it2 = this.onCancelListener;
            if (it2 != null) {
                $this$apply.setOnCancelListener(it2);
            }
            OnClickListener it3 = this.onPositiveButtonListener;
            if (it3 != null) {
                $this$apply.setOnPositiveButtonListener(it3);
            }
            OnClickListener it4 = this.onNegativeButtonListener;
            if (it4 != null) {
                $this$apply.setOnNegativeButtonListener(it4);
            }
            Bundle bundle = new Bundle();
            Bundle $this$apply2 = bundle;
            String it5 = this.titleText;
            if (it5 != null) {
                $this$apply2.putString(ConstantsKt.TITLE_TEXT, it5);
            }
            String it6 = this.subTitleText;
            if (it6 != null) {
                $this$apply2.putString(ConstantsKt.SUBTITLE_TEXT, it6);
            }
            String it7 = this.messageText;
            if (it7 != null) {
                $this$apply2.putString(ConstantsKt.MESSAGE_TEXT, it7);
            }
            String it8 = this.positiveButtonText;
            if (it8 != null) {
                $this$apply2.putString(ConstantsKt.POSITIVE_BUTTON_MESSAGE_TEXT, it8);
            }
            String it9 = this.negativeButtonText;
            if (it9 != null) {
                $this$apply2.putString(ConstantsKt.NEGATIVE_BUTTON_MESSAGE_TEXT, it9);
            }
            $this$apply2.putBoolean(ConstantsKt.ALLOW_ONCANCEL, this.allowOnCancel);
            $this$apply.setArguments(bundle);
            return globileErrorHandler;
        }
    }
}
