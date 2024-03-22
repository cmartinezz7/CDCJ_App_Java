package com.santander.globile.uicomponents.tabs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.tabs.data.GlobileTab;
import com.santander.globile.uicomponents.tabs.data.GlobileTabsAdapterData;
import com.santander.globile.uicomponents.text.SantanderTextView;
import com.santander.globile.uicomponents.utils.ImageViewExtensionKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0014J\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/santander/globile/uicomponents/tabs/GlobileTabs;", "Lcom/google/android/material/tabs/TabLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "addCustomView", "", "globileTabsAdapterData", "Lcom/santander/globile/uicomponents/tabs/data/GlobileTabsAdapterData;", "onAttachedToWindow", "setupWithViewPager", "autoRefresh", "", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileTabs.kt */
public final class GlobileTabs extends TabLayout {
    private HashMap _$_findViewCache;
    private ViewPager viewPager;

    public GlobileTabs(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileTabs(Context context, AttributeSet attributeSet) {
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
    public GlobileTabs(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener(this) {
            final /* synthetic */ GlobileTabs this$0;

            {
                this.this$0 = $outer;
            }

            public void onTabSelected(TabLayout.Tab tab) {
                ImageView imageView;
                Intrinsics.checkParameterIsNotNull(tab, "tab");
                View customView = tab.getCustomView();
                SantanderTextView textView = customView != null ? (SantanderTextView) customView.findViewById(R.id.globileCustomTabText) : null;
                View customView2 = tab.getCustomView();
                ImageView image = customView2 != null ? (ImageView) customView2.findViewById(R.id.tabIcon) : null;
                if (textView != null) {
                    textView.setTypeface((Typeface) null, 1);
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    if (textView != null) {
                        textView.setTextColor(this.this$0.getResources().getColor(R.color.grey, (Resources.Theme) null));
                    }
                } else if (textView != null) {
                    textView.setTextColor(this.this$0.getResources().getColor(R.color.grey));
                }
                if (image != null && (imageView = (ImageView) image.findViewById(R.id.tabIcon)) != null) {
                    ImageViewExtensionKt.tintDrawable(imageView, R.color.santander_red);
                }
            }

            public void onTabUnselected(TabLayout.Tab tab) {
                ImageView imageView;
                Intrinsics.checkParameterIsNotNull(tab, "tab");
                View customView = tab.getCustomView();
                SantanderTextView textView = customView != null ? (SantanderTextView) customView.findViewById(R.id.globileCustomTabText) : null;
                View customView2 = tab.getCustomView();
                ImageView image = customView2 != null ? (ImageView) customView2.findViewById(R.id.tabIcon) : null;
                if (textView != null) {
                    textView.setTypeface((Typeface) null, 0);
                }
                if (!(image == null || (imageView = (ImageView) image.findViewById(R.id.tabIcon)) == null)) {
                    ImageViewExtensionKt.tintDrawable(imageView, R.color.medium_grey);
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    if (textView != null) {
                        textView.setTextColor(this.this$0.getResources().getColor(R.color.medium_grey, (Resources.Theme) null));
                    }
                } else if (textView != null) {
                    textView.setTextColor(this.this$0.getResources().getColor(R.color.medium_grey));
                }
            }

            public void onTabReselected(TabLayout.Tab tab) {
                Intrinsics.checkParameterIsNotNull(tab, "tab");
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileTabs(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        if (this.viewPager == null && (getParent() instanceof ViewPager)) {
            ViewPager parent = getParent();
            if (parent != null) {
                this.viewPager = parent;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
            }
        }
        super.onAttachedToWindow();
    }

    /* Debug info: failed to restart local var, previous not found, register: 3 */
    public void setupWithViewPager(ViewPager viewPager2, boolean autoRefresh) {
        PagerAdapter pagerAdapter;
        this.viewPager = viewPager2;
        if (viewPager2 != null) {
            try {
                pagerAdapter = viewPager2.getAdapter();
            } catch (Exception e) {
                Log.e("ClassCastException", "Adapter in ViewPager must be GlobileBaseFragmentTabsAdapter");
                return;
            }
        } else {
            pagerAdapter = null;
        }
        if (pagerAdapter != null) {
            super.setupWithViewPager(viewPager2, autoRefresh);
            addCustomView(((GlobileBaseFragmentTabsAdapter) pagerAdapter).getGlobileTabsAdapterData());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.santander.globile.uicomponents.tabs.GlobileBaseFragmentTabsAdapter");
    }

    private final void addCustomView(GlobileTabsAdapterData globileTabsAdapterData) {
        Integer iconId;
        int index = 0;
        for (Object item$iv : globileTabsAdapterData.getTabs()) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GlobileTab tab = (GlobileTab) item$iv;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.globile_custom_tab, (ViewGroup) null);
            if (inflate != null) {
                View view = (ConstraintLayout) inflate;
                if (tab.getIconId() == null || ((iconId = tab.getIconId()) != null && iconId.intValue() == 0)) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.tabIcon);
                    Intrinsics.checkExpressionValueIsNotNull(imageView, "customTab.tabIcon");
                    imageView.setVisibility(8);
                    SantanderTextView santanderTextView = (SantanderTextView) view.findViewById(R.id.globileCustomTabText);
                    Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "customTab.globileCustomTabText");
                    santanderTextView.setMaxLines(2);
                    ((SantanderTextView) view.findViewById(R.id.globileCustomTabText)).setLines(2);
                } else {
                    ((ImageView) view.findViewById(R.id.tabIcon)).setImageResource(tab.getIconId().intValue());
                    SantanderTextView santanderTextView2 = (SantanderTextView) view.findViewById(R.id.globileCustomTabText);
                    Intrinsics.checkExpressionValueIsNotNull(santanderTextView2, "customTab.globileCustomTabText");
                    santanderTextView2.setMaxLines(1);
                    ((SantanderTextView) view.findViewById(R.id.globileCustomTabText)).setLines(1);
                }
                if (index == 0) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.tabIcon);
                    Intrinsics.checkExpressionValueIsNotNull(imageView2, "customTab.tabIcon");
                    ImageViewExtensionKt.tintDrawable(imageView2, R.color.santander_red);
                    SantanderTextView santanderTextView3 = (SantanderTextView) view.findViewById(R.id.globileCustomTabText);
                    if (santanderTextView3 != null) {
                        santanderTextView3.setTypeface((Typeface) null, 1);
                    }
                    if (Build.VERSION.SDK_INT >= 23) {
                        SantanderTextView santanderTextView4 = (SantanderTextView) view.findViewById(R.id.globileCustomTabText);
                        if (santanderTextView4 != null) {
                            santanderTextView4.setTextColor(getResources().getColor(R.color.grey, (Resources.Theme) null));
                        }
                    } else {
                        SantanderTextView santanderTextView5 = (SantanderTextView) view.findViewById(R.id.globileCustomTabText);
                        if (santanderTextView5 != null) {
                            santanderTextView5.setTextColor(getResources().getColor(R.color.grey));
                        }
                    }
                } else {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.tabIcon);
                    Intrinsics.checkExpressionValueIsNotNull(imageView3, "customTab.tabIcon");
                    ImageViewExtensionKt.tintDrawable(imageView3, R.color.medium_grey);
                    SantanderTextView santanderTextView6 = (SantanderTextView) view.findViewById(R.id.globileCustomTabText);
                    if (santanderTextView6 != null) {
                        santanderTextView6.setTypeface((Typeface) null, 0);
                    }
                }
                SantanderTextView santanderTextView7 = (SantanderTextView) view.findViewById(R.id.globileCustomTabText);
                Intrinsics.checkExpressionValueIsNotNull(santanderTextView7, "customTab.globileCustomTabText");
                santanderTextView7.setText(tab.getTitle());
                if (index == globileTabsAdapterData.getTabs().size() - 1) {
                    View findViewById = view.findViewById(R.id.tablayout_divider);
                    Intrinsics.checkExpressionValueIsNotNull(findViewById, "customTab.tablayout_divider");
                    findViewById.setVisibility(8);
                }
                TabLayout.Tab tabAt = getTabAt(index);
                if (tabAt != null) {
                    tabAt.setCustomView(view);
                }
                index = index$iv;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            }
        }
    }
}
