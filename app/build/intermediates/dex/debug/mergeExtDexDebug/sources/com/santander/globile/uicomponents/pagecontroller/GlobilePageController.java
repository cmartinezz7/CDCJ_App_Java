package com.santander.globile.uicomponents.pagecontroller;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.santander.globile.uicomponents.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0013J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/santander/globile/uicomponents/pagecontroller/GlobilePageController;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowLeftImage", "Landroid/widget/ImageView;", "getArrowLeftImage", "()Landroid/widget/ImageView;", "setArrowLeftImage", "(Landroid/widget/ImageView;)V", "arrowRightImage", "getArrowRightImage", "setArrowRightImage", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "getMViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setMViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "arrange", "", "bind", "viewPager", "handleVisibility", "isFirstPage", "", "isLastPage", "readMessageToAccessibility", "message", "", "setArrowIndicatorRes", "leftArrowResId", "rightArrowResId", "setParams", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobilePageController.kt */
public final class GlobilePageController extends LinearLayout {
    private HashMap _$_findViewCache;
    private ImageView arrowLeftImage;
    private ImageView arrowRightImage;
    private ViewPager mViewPager;

    public GlobilePageController(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobilePageController(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobilePageController(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setOrientation(0);
        this.arrowLeftImage = new ImageButton(context);
        this.arrowRightImage = new ImageButton(context);
        this.arrowLeftImage.setContentDescription(getResources().getString(R.string.previous_button_description));
        this.arrowRightImage.setContentDescription(getResources().getString(R.string.next_button_description));
        if (Build.VERSION.SDK_INT >= 23) {
            this.arrowLeftImage.setBackgroundColor(getResources().getColor(R.color.transparent, (Resources.Theme) null));
            this.arrowRightImage.setBackgroundColor(getResources().getColor(R.color.transparent, (Resources.Theme) null));
        } else {
            this.arrowLeftImage.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.transparent, (Resources.Theme) null));
            this.arrowRightImage.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.transparent, (Resources.Theme) null));
        }
        setArrowIndicatorRes(R.drawable.ic_sys017, R.drawable.ic_sys016);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobilePageController(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final ImageView getArrowLeftImage() {
        return this.arrowLeftImage;
    }

    public final void setArrowLeftImage(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.arrowLeftImage = imageView;
    }

    public final ImageView getArrowRightImage() {
        return this.arrowRightImage;
    }

    public final void setArrowRightImage(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.arrowRightImage = imageView;
    }

    public final ViewPager getMViewPager() {
        return this.mViewPager;
    }

    public final void setMViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
    }

    private final void setParams() {
        setGravity(16);
    }

    private final void setArrowIndicatorRes(int leftArrowResId, int rightArrowResId) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.arrowLeftImage.setImageDrawable(getResources().getDrawable(leftArrowResId, (Resources.Theme) null));
            this.arrowRightImage.setImageDrawable(getResources().getDrawable(rightArrowResId, (Resources.Theme) null));
            return;
        }
        this.arrowLeftImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), leftArrowResId, (Resources.Theme) null));
        this.arrowRightImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), rightArrowResId, (Resources.Theme) null));
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

    public final void bind(ViewPager viewPager) {
        Intrinsics.checkParameterIsNotNull(viewPager, "viewPager");
        this.mViewPager = viewPager;
        this.arrowLeftImage.setOnClickListener(new GlobilePageController$bind$1(this));
        this.arrowRightImage.setOnClickListener(new GlobilePageController$bind$2(this));
        viewPager.addOnPageChangeListener(new GlobilePageController$bind$3(this));
        arrange();
    }

    private final void arrange() {
        setParams();
        View view = getChildAt(0);
        removeViewAt(0);
        Intrinsics.checkExpressionValueIsNotNull(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            addView(this.arrowLeftImage);
            addView(view);
            addView(this.arrowRightImage);
            handleVisibility();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    /* access modifiers changed from: private */
    public final void handleVisibility() {
        int i;
        ImageView imageView = this.arrowLeftImage;
        int i2 = 4;
        if (isFirstPage()) {
            i = 4;
        } else {
            i = 0;
        }
        imageView.setVisibility(i);
        ImageView imageView2 = this.arrowRightImage;
        if (!isLastPage()) {
            i2 = 0;
        }
        imageView2.setVisibility(i2);
    }

    /* access modifiers changed from: private */
    public final boolean isLastPage() {
        PagerAdapter adapter;
        ViewPager viewPager = this.mViewPager;
        Integer num = null;
        Integer valueOf = viewPager != null ? Integer.valueOf(viewPager.getCurrentItem()) : null;
        ViewPager viewPager2 = this.mViewPager;
        if (!(viewPager2 == null || (adapter = viewPager2.getAdapter()) == null)) {
            num = Integer.valueOf(adapter.getCount() - 1);
        }
        return Intrinsics.areEqual((Object) valueOf, (Object) num);
    }

    /* access modifiers changed from: private */
    public final boolean isFirstPage() {
        ViewPager viewPager = this.mViewPager;
        return viewPager != null && viewPager.getCurrentItem() == 0;
    }
}
