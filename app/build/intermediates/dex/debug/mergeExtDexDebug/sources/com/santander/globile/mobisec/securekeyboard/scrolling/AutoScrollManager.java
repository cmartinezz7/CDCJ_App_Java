package com.santander.globile.mobisec.securekeyboard.scrolling;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.santander.globile.mobisec.logger.GlobileLog;
import com.santander.globile.mobisec.securekeyboard.BaseSecureEditText;
import com.santander.globile.mobisec.securekeyboard.SanKeyboardView;
import com.santander.globile.mobisec.securekeyboard.window.KeyboardWindowSoftInputMode;

public class AutoScrollManager {
    private static final String AUTOSCROLL_TAG = "AUTOSCROLL";
    private ScrollView autoScrollView;
    private Context context;
    private AutoScrollManagerStatus currentManagerStatus;
    private RootLayoutType currentRootLayoutType;
    private View extraBottomSpace;
    private boolean isResetedBeforeStopped = false;
    private boolean isRootLayoutResized = false;
    private BaseSecureEditText lastSecureEditTextRequest;
    private LockableScrollView lockableScrollView;
    private NestedScrollView nestedAutoScrollView;
    private ViewGroup.LayoutParams originalRootLayoutParams;
    private Point originalScrollPosition;
    private final int rootLayoutIdForAutoScrolling;
    private int viewIndexInParent;

    AutoScrollManager(Context context2, int rootLayoutIdForAutoScrolling2) {
        this.context = context2.getApplicationContext();
        this.rootLayoutIdForAutoScrolling = rootLayoutIdForAutoScrolling2;
        setStatus(AutoScrollManagerStatus.NOT_SETTED);
    }

    public synchronized AutoScrollManagerStatus getStatus() {
        return this.currentManagerStatus;
    }

    private synchronized void setStatus(AutoScrollManagerStatus currentStatus) {
        this.currentManagerStatus = currentStatus;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startAutoScrollingForField(com.santander.globile.mobisec.securekeyboard.BaseSecureEditText r9, com.santander.globile.mobisec.securekeyboard.SanKeyboardView r10) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "> StartAutoScrollingForField: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r9.getMyId()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "AUTOSCROLL"
            com.santander.globile.mobisec.logger.GlobileLog.d(r1, r0)
            int r0 = r8.rootLayoutIdForAutoScrolling
            r2 = -1
            if (r0 == r2) goto L_0x011d
            com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManagerStatus r0 = r8.getStatus()
            com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManagerStatus r3 = com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManagerStatus.NOT_SETTED
            if (r0 != r3) goto L_0x0100
            com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManagerStatus r0 = com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManagerStatus.STARTING
            r8.setStatus(r0)
            android.view.ViewParent r0 = r9.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
        L_0x0034:
            r3 = 16908290(0x1020002, float:2.3877235E-38)
            if (r0 == 0) goto L_0x004f
            int r4 = r0.getId()
            int r5 = r8.rootLayoutIdForAutoScrolling
            if (r4 == r5) goto L_0x004f
            int r4 = r0.getId()
            if (r4 == r3) goto L_0x004f
            android.view.ViewParent r3 = r0.getParent()
            r0 = r3
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x0034
        L_0x004f:
            if (r0 == 0) goto L_0x00fa
            int r4 = r0.getId()
            if (r4 != r3) goto L_0x0059
            goto L_0x00fa
        L_0x0059:
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            r8.backupOriginalRootLayoutParams(r3)
            r8.lastSecureEditTextRequest = r9
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r3 = r8.getCoordinatorLayoutBehaviour(r0)
            android.view.ViewGroup$LayoutParams r4 = r0.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r4 = (android.view.ViewGroup.MarginLayoutParams) r4
            android.widget.LinearLayout r4 = r8.getLinearLayoutScrollContainer(r4)
            android.view.ViewParent r5 = r0.getParent()
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            boolean r6 = r5 instanceof android.widget.ScrollView
            r7 = 0
            if (r6 == 0) goto L_0x0087
            r8.viewIndexInParent = r7
            com.santander.globile.mobisec.securekeyboard.scrolling.RootLayoutType r2 = com.santander.globile.mobisec.securekeyboard.scrolling.RootLayoutType.SCROLL_VIEW
            r8.currentRootLayoutType = r2
            android.view.ViewGroup r0 = r8.reuseScrollView(r5)
            goto L_0x00b1
        L_0x0087:
            boolean r6 = r5 instanceof androidx.core.widget.NestedScrollView
            if (r6 == 0) goto L_0x0096
            r8.viewIndexInParent = r7
            com.santander.globile.mobisec.securekeyboard.scrolling.RootLayoutType r2 = com.santander.globile.mobisec.securekeyboard.scrolling.RootLayoutType.NESTED_SCROLL_VIEW
            r8.currentRootLayoutType = r2
            android.view.ViewGroup r0 = r8.reuseNestedScrollView(r5)
            goto L_0x00b1
        L_0x0096:
            com.santander.globile.mobisec.securekeyboard.scrolling.RootLayoutType r6 = com.santander.globile.mobisec.securekeyboard.scrolling.RootLayoutType.VIEW_GROUP
            r8.currentRootLayoutType = r6
            int r6 = r8.getViewIndex(r5, r0)
            r8.viewIndexInParent = r6
            if (r6 != r2) goto L_0x00a8
            com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManagerStatus r1 = com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManagerStatus.NOT_SETTED
            r8.setStatus(r1)
            return
        L_0x00a8:
            r5.removeViewAt(r6)
            com.santander.globile.mobisec.securekeyboard.scrolling.LockableScrollView r2 = r8.createLockableScrollView()
            r8.lockableScrollView = r2
        L_0x00b1:
            r8.calculateExtraBottomSpace(r10)
            r4.addView(r0)
            android.view.View r2 = r8.extraBottomSpace
            r4.addView(r2)
            int[] r2 = com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManager.AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$scrolling$RootLayoutType
            com.santander.globile.mobisec.securekeyboard.scrolling.RootLayoutType r6 = r8.currentRootLayoutType
            int r6 = r6.ordinal()
            r2 = r2[r6]
            r6 = 1
            if (r2 == r6) goto L_0x00d8
            r6 = 2
            if (r2 == r6) goto L_0x00d4
            r6 = 3
            if (r2 == r6) goto L_0x00d0
            goto L_0x00dc
        L_0x00d0:
            r8.wrapWithLockableScrollView(r5, r4, r3)
            goto L_0x00dc
        L_0x00d4:
            r8.wrapWithNestedScrollView(r5, r4)
            goto L_0x00dc
        L_0x00d8:
            r8.wrapWithScrollView(r4)
        L_0x00dc:
            r9.requestFocus()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "> StartAutoScrollingForField COMPLETED!\nId: "
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r6 = r9.getMyId()
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r2 = r2.toString()
            com.santander.globile.mobisec.logger.GlobileLog.d(r1, r2)
            goto L_0x011d
        L_0x00fa:
            com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManagerStatus r1 = com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManagerStatus.NOT_SETTED
            r8.setStatus(r1)
            return
        L_0x0100:
            r8.showExtraSpaceForScrolling(r9, r10)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "> StartAutoScrollingForField (already deployed) COMPLETED!\nId: "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = r9.getMyId()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.santander.globile.mobisec.logger.GlobileLog.d(r1, r0)
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManager.startAutoScrollingForField(com.santander.globile.mobisec.securekeyboard.BaseSecureEditText, com.santander.globile.mobisec.securekeyboard.SanKeyboardView):void");
    }

    /* renamed from: com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$santander$globile$mobisec$securekeyboard$scrolling$RootLayoutType;

        static {
            int[] iArr = new int[RootLayoutType.values().length];
            $SwitchMap$com$santander$globile$mobisec$securekeyboard$scrolling$RootLayoutType = iArr;
            try {
                iArr[RootLayoutType.SCROLL_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$scrolling$RootLayoutType[RootLayoutType.NESTED_SCROLL_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$santander$globile$mobisec$securekeyboard$scrolling$RootLayoutType[RootLayoutType.VIEW_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void stopAutoScrollingForField() {
        GlobileLog.d(AUTOSCROLL_TAG, "> StopAutoScrolingForField...");
        if (this.isResetedBeforeStopped) {
            this.isResetedBeforeStopped = false;
            return;
        }
        if (this.rootLayoutIdForAutoScrolling != -1 && getStatus() == AutoScrollManagerStatus.SETTED) {
            setStatus(AutoScrollManagerStatus.STOPPING);
            undoResizeRootLayout();
            int i = AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$scrolling$RootLayoutType[this.currentRootLayoutType.ordinal()];
            if (i == 1) {
                restoreOriginalScrollView();
            } else if (i == 2) {
                restoreOriginalNestedScrollView();
            } else if (i == 3) {
                restoreOriginalLayout();
            }
        }
        setStatus(AutoScrollManagerStatus.NOT_SETTED);
        GlobileLog.d(AUTOSCROLL_TAG, "> StopAutoScrolingForField COMPLETED!");
    }

    public void showExtraSpaceForScrolling(BaseSecureEditText secureEditText, SanKeyboardView sanKeyboardView) {
        View view;
        GlobileLog.d(AUTOSCROLL_TAG, "> ShowExtraSpaceForScrolling... \nId: " + secureEditText.getMyId());
        if (getStatus() == AutoScrollManagerStatus.SETTED && (view = this.extraBottomSpace) != null && view.getVisibility() == 0) {
            this.isResetedBeforeStopped = true;
        }
        setStatus(AutoScrollManagerStatus.STARTING);
        if (hasKeyboardLayoutChanged(secureEditText)) {
            calculateExtraBottomSpace(sanKeyboardView);
        }
        this.extraBottomSpace.setVisibility(0);
        resizeRootLayoutIfRequired(secureEditText);
        LockableScrollView lockableScrollView2 = this.lockableScrollView;
        if (lockableScrollView2 != null) {
            lockableScrollView2.setEnableScrolling(true);
        }
        scrollToField(secureEditText);
        setStatus(AutoScrollManagerStatus.SETTED);
        GlobileLog.d(AUTOSCROLL_TAG, "> ShowExtraSpaceForScrolling COMPLETED!\nId: " + secureEditText.getMyId());
    }

    public void hideExtraBottomSpaceForScrolling(BaseSecureEditText editText) {
        GlobileLog.d(AUTOSCROLL_TAG, "> HideExtraBottomSpaceForScrolling...");
        if (getStatus() != AutoScrollManagerStatus.SETTED) {
            return;
        }
        if (this.isResetedBeforeStopped) {
            this.isResetedBeforeStopped = false;
            this.extraBottomSpace.setVisibility(0);
            LockableScrollView lockableScrollView2 = this.lockableScrollView;
            if (lockableScrollView2 != null) {
                lockableScrollView2.setEnableScrolling(true);
            }
            GlobileLog.d(AUTOSCROLL_TAG, "> HideExtraBottomSpaceForScrolling... RESETED BEFORE STOPPED");
            return;
        }
        undoResizeRootLayout();
        this.extraBottomSpace.setVisibility(8);
        restoreScrollPosition(editText);
        LockableScrollView lockableScrollView3 = this.lockableScrollView;
        if (lockableScrollView3 != null) {
            lockableScrollView3.setEnableScrolling(false);
        }
        GlobileLog.d(AUTOSCROLL_TAG, "> HideExtraBottomSpaceForScrolling... COMPLETED!");
    }

    private void wrapWithNestedScrollView(ViewGroup parentView, LinearLayout llScrollContainer) {
        this.nestedAutoScrollView.addView(llScrollContainer);
        if (this.currentRootLayoutType != RootLayoutType.NESTED_SCROLL_VIEW) {
            parentView.addView(this.nestedAutoScrollView, this.viewIndexInParent);
        }
    }

    private void wrapWithScrollView(LinearLayout llScrollContainer) {
        this.autoScrollView.addView(llScrollContainer);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.santander.globile.mobisec.securekeyboard.scrolling.LockableScrollView, android.view.View] */
    private void wrapWithLockableScrollView(ViewGroup parentView, LinearLayout llScrollContainer, CoordinatorLayout.Behavior behavior) {
        this.lockableScrollView.addView(llScrollContainer);
        if (behavior != null) {
            this.lockableScrollView.getLayoutParams().setBehavior(behavior);
        }
        parentView.addView(this.lockableScrollView, this.viewIndexInParent);
    }

    private void scrollToField(BaseSecureEditText editTextField) {
        backupOriginalScrollPosition(editTextField);
        new Handler(Looper.getMainLooper()).post(new Runnable(editTextField) {
            public final /* synthetic */ BaseSecureEditText f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                AutoScrollManager.this.lambda$scrollToField$0$AutoScrollManager(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$scrollToField$0$AutoScrollManager(BaseSecureEditText editTextField) {
        LockableScrollView lockableScrollView2;
        if (editTextField.getParentNestedScrollView() != null) {
            editTextField.getParentNestedScrollView().smoothScrollTo(0, getEditTextScrollPosition(editTextField));
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$scrolling$RootLayoutType[this.currentRootLayoutType.ordinal()];
        if (i == 1) {
            ScrollView scrollView = this.autoScrollView;
            if (scrollView != null) {
                scrollView.smoothScrollTo(0, getEditTextScrollPosition(editTextField));
            }
        } else if (i == 2) {
            NestedScrollView nestedScrollView = this.nestedAutoScrollView;
            if (nestedScrollView != null) {
                nestedScrollView.smoothScrollTo(0, getEditTextScrollPosition(editTextField));
            }
        } else if (i == 3 && (lockableScrollView2 = this.lockableScrollView) != null) {
            lockableScrollView2.smoothScrollTo(0, getEditTextScrollPosition(editTextField));
        }
    }

    private void restoreOriginalNestedScrollView() {
        LinearLayout llScrollContainer = (LinearLayout) this.nestedAutoScrollView.getChildAt(0);
        ViewGroup originalRootLayout = (ViewGroup) llScrollContainer.getChildAt(0);
        llScrollContainer.removeAllViews();
        this.nestedAutoScrollView.removeViewAt(0);
        this.nestedAutoScrollView.addView(originalRootLayout, 0);
        restoreOriginalRootLayoutParams(originalRootLayout);
    }

    private void restoreOriginalScrollView() {
        LinearLayout llScrollContainer = (LinearLayout) this.autoScrollView.getChildAt(0);
        ViewGroup originalRootLayout = (ViewGroup) llScrollContainer.getChildAt(0);
        llScrollContainer.removeAllViews();
        this.autoScrollView.removeViewAt(0);
        this.autoScrollView.addView(originalRootLayout, 0);
        restoreOriginalRootLayoutParams(originalRootLayout);
    }

    private void restoreOriginalLayout() {
        ViewGroup parentView = (ViewGroup) this.lockableScrollView.getParent();
        LinearLayout llScrollContainer = (LinearLayout) this.lockableScrollView.getChildAt(0);
        ViewGroup originalRootLayout = (ViewGroup) llScrollContainer.getChildAt(0);
        llScrollContainer.removeAllViews();
        this.lockableScrollView.removeViewAt(0);
        parentView.removeViewAt(0);
        parentView.addView(originalRootLayout, this.viewIndexInParent);
        restoreOriginalRootLayoutParams(originalRootLayout);
    }

    private ViewGroup reuseScrollView(ViewGroup parentView) {
        ScrollView scrollView = (ScrollView) parentView;
        this.autoScrollView = scrollView;
        this.nestedAutoScrollView = null;
        this.lockableScrollView = null;
        ViewGroup rootLayout = (ViewGroup) scrollView.getChildAt(0);
        this.autoScrollView.removeViewAt(0);
        return rootLayout;
    }

    private ViewGroup reuseNestedScrollView(ViewGroup parentView) {
        NestedScrollView nestedScrollView = (NestedScrollView) parentView;
        this.nestedAutoScrollView = nestedScrollView;
        this.autoScrollView = null;
        this.lockableScrollView = null;
        ViewGroup rootLayout = (ViewGroup) nestedScrollView.getChildAt(0);
        this.nestedAutoScrollView.removeViewAt(0);
        return rootLayout;
    }

    private int getViewIndex(ViewGroup viewGroup, View searchedView) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i).equals(searchedView)) {
                return i;
            }
        }
        return -1;
    }

    private LockableScrollView createLockableScrollView() {
        LockableScrollView lsv = new LockableScrollView(this.context);
        this.autoScrollView = null;
        this.nestedAutoScrollView = null;
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(-1, -1);
        lsv.setFillViewport(true);
        lsv.setLayoutParams(lp);
        lsv.setSmoothScrollingEnabled(true);
        lsv.setFocusable(false);
        lsv.setFocusableInTouchMode(false);
        return lsv;
    }

    private LinearLayout getLinearLayoutScrollContainer(ViewGroup.MarginLayoutParams rootLayoutParams) {
        LinearLayout llScrollContainer = new LinearLayout(this.context);
        llScrollContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        llScrollContainer.setOrientation(1);
        llScrollContainer.setFocusable(false);
        llScrollContainer.setFocusableInTouchMode(false);
        if (Build.VERSION.SDK_INT < 24) {
            llScrollContainer.setPadding(rootLayoutParams.leftMargin, rootLayoutParams.topMargin, rootLayoutParams.rightMargin, rootLayoutParams.bottomMargin);
        }
        return llScrollContainer;
    }

    private void calculateExtraBottomSpace(SanKeyboardView sanKeyboardView) {
        if (this.extraBottomSpace == null) {
            View view = new View(this.context);
            this.extraBottomSpace = view;
            view.setFocusable(false);
            this.extraBottomSpace.setFocusableInTouchMode(false);
            this.extraBottomSpace.setVisibility(8);
        }
        sanKeyboardView.measure(1073741824, 1073741824);
        this.extraBottomSpace.setLayoutParams(new LinearLayout.LayoutParams(-1, sanKeyboardView.getMeasuredHeight()));
    }

    /* JADX WARNING: type inference failed for: r2v8, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getEditTextScrollPosition(com.santander.globile.mobisec.securekeyboard.BaseSecureEditText r6) {
        /*
            r5 = this;
            android.view.ViewParent r0 = r6.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r6.getTop()
        L_0x000a:
            if (r0 == 0) goto L_0x0021
            int r2 = r0.getId()
            int r3 = r5.rootLayoutIdForAutoScrolling
            if (r2 == r3) goto L_0x0021
            int r2 = r0.getTop()
            int r1 = r1 + r2
            android.view.ViewParent r2 = r0.getParent()
            r0 = r2
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x000a
        L_0x0021:
            if (r0 == 0) goto L_0x003b
            if (r1 <= 0) goto L_0x003b
            float r2 = (float) r1
            int r3 = r6.getMeasuredHeight()
            float r3 = (float) r3
            android.content.Context r4 = r5.context
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            float r4 = r4.density
            float r3 = r3 * r4
            float r2 = r2 - r3
            int r2 = (int) r2
            return r2
        L_0x003b:
            int r2 = r6.getTop()
            if (r2 == 0) goto L_0x0046
            int r2 = r6.getTop()
            goto L_0x004a
        L_0x0046:
            int r2 = r6.getBottom()
        L_0x004a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManager.getEditTextScrollPosition(com.santander.globile.mobisec.securekeyboard.BaseSecureEditText):int");
    }

    private boolean hasKeyboardLayoutChanged(BaseSecureEditText secureEditText) {
        BaseSecureEditText baseSecureEditText = this.lastSecureEditTextRequest;
        boolean result = (baseSecureEditText != null && baseSecureEditText.getKeyboardType() == secureEditText.getKeyboardType() && this.lastSecureEditTextRequest.getTopRowButtons() == secureEditText.getTopRowButtons()) ? false : true;
        if (result) {
            this.lastSecureEditTextRequest = secureEditText;
        }
        return result;
    }

    public void clearExtraRequests() {
        this.isResetedBeforeStopped = false;
    }

    private CoordinatorLayout.Behavior getCoordinatorLayoutBehaviour(View rootLayout) {
        try {
            return rootLayout.getLayoutParams().getBehavior();
        } catch (Exception e) {
            return null;
        }
    }

    private void backupOriginalScrollPosition(BaseSecureEditText editText) {
        if (this.originalScrollPosition == null) {
            if (editText.getParentNestedScrollView() != null) {
                NestedScrollView embeddedScrollView = editText.getParentNestedScrollView();
                this.originalScrollPosition = new Point(embeddedScrollView.getScrollX(), embeddedScrollView.getScrollY());
                return;
            }
            int i = AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$scrolling$RootLayoutType[this.currentRootLayoutType.ordinal()];
            if (i == 1) {
                this.originalScrollPosition = new Point(this.autoScrollView.getScrollX(), this.autoScrollView.getScrollY());
            } else if (i == 2) {
                this.originalScrollPosition = new Point(this.nestedAutoScrollView.getScrollX(), this.nestedAutoScrollView.getScrollY());
            } else if (i == 3) {
                this.originalScrollPosition = new Point(this.lockableScrollView.getScrollX(), this.lockableScrollView.getScrollY());
            }
        }
    }

    private void restoreScrollPosition(BaseSecureEditText editText) {
        new Handler(Looper.getMainLooper()).post(new Runnable(editText) {
            public final /* synthetic */ BaseSecureEditText f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                AutoScrollManager.this.lambda$restoreScrollPosition$1$AutoScrollManager(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$restoreScrollPosition$1$AutoScrollManager(BaseSecureEditText editText) {
        LockableScrollView lockableScrollView2;
        if (this.originalScrollPosition != null) {
            if (editText.getParentNestedScrollView() != null) {
                editText.getParentNestedScrollView().smoothScrollTo(this.originalScrollPosition.x, this.originalScrollPosition.y);
            } else {
                int i = AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$scrolling$RootLayoutType[this.currentRootLayoutType.ordinal()];
                if (i == 1) {
                    ScrollView scrollView = this.autoScrollView;
                    if (scrollView != null) {
                        scrollView.smoothScrollTo(this.originalScrollPosition.x, this.originalScrollPosition.y);
                    }
                } else if (i == 2) {
                    NestedScrollView nestedScrollView = this.nestedAutoScrollView;
                    if (nestedScrollView != null) {
                        nestedScrollView.smoothScrollTo(this.originalScrollPosition.x, this.originalScrollPosition.y);
                    }
                } else if (i == 3 && (lockableScrollView2 = this.lockableScrollView) != null) {
                    lockableScrollView2.smoothScrollTo(this.originalScrollPosition.x, this.originalScrollPosition.y);
                }
            }
            this.originalScrollPosition = null;
        }
    }

    private void resizeRootLayoutIfRequired(BaseSecureEditText secureEditText) {
        ViewGroup rootLayout;
        if (secureEditText.getKeyboardWindowSoftInputMode().equals(KeyboardWindowSoftInputMode.ADJUST_RESIZE) && !this.isRootLayoutResized && (rootLayout = getCurrentRootLayoutEmbedded()) != null) {
            GlobileLog.d(AUTOSCROLL_TAG, "> resizeRootLayout... ");
            LinearLayout.LayoutParams resizeLayoutParams = new LinearLayout.LayoutParams(rootLayout.getLayoutParams());
            resizeLayoutParams.weight = 1.0f;
            resizeLayoutParams.height = 0;
            rootLayout.setLayoutParams(resizeLayoutParams);
            this.isRootLayoutResized = true;
            GlobileLog.d(AUTOSCROLL_TAG, "> resizeRootLayout... COMPLETED!");
        }
    }

    private void undoResizeRootLayout() {
        ViewGroup rootLayout;
        if (this.isRootLayoutResized && (rootLayout = getCurrentRootLayoutEmbedded()) != null) {
            GlobileLog.d(AUTOSCROLL_TAG, "> UndoResizeRootLayout... ");
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) rootLayout.getLayoutParams();
            lp.height = this.originalRootLayoutParams.height;
            ViewGroup.LayoutParams layoutParams = this.originalRootLayoutParams;
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                lp.weight = ((LinearLayout.LayoutParams) layoutParams).weight;
            } else {
                lp.weight = 0.0f;
            }
            rootLayout.setLayoutParams(lp);
            this.isRootLayoutResized = false;
            GlobileLog.d(AUTOSCROLL_TAG, "> UndoResizeRootLayout... COMPLETED!");
        }
    }

    private void backupOriginalRootLayoutParams(ViewGroup.LayoutParams lp) {
        if (this.originalRootLayoutParams == null) {
            this.originalRootLayoutParams = lp;
        }
    }

    private void restoreOriginalRootLayoutParams(ViewGroup rootLayout) {
        ViewGroup.LayoutParams layoutParams = this.originalRootLayoutParams;
        if (layoutParams != null) {
            rootLayout.setLayoutParams(layoutParams);
            this.originalRootLayoutParams = null;
        }
    }

    /* JADX WARNING: type inference failed for: r1v6, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v8, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v10, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.ViewGroup getCurrentRootLayoutEmbedded() {
        /*
            r4 = this;
            r0 = 0
            int[] r1 = com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManager.AnonymousClass1.$SwitchMap$com$santander$globile$mobisec$securekeyboard$scrolling$RootLayoutType
            com.santander.globile.mobisec.securekeyboard.scrolling.RootLayoutType r2 = r4.currentRootLayoutType
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            r3 = 0
            if (r1 == r2) goto L_0x002a
            r2 = 2
            if (r1 == r2) goto L_0x0020
            r2 = 3
            if (r1 == r2) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            com.santander.globile.mobisec.securekeyboard.scrolling.LockableScrollView r1 = r4.lockableScrollView
            android.view.View r1 = r1.getChildAt(r3)
            r0 = r1
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            goto L_0x0034
        L_0x0020:
            androidx.core.widget.NestedScrollView r1 = r4.nestedAutoScrollView
            android.view.View r1 = r1.getChildAt(r3)
            r0 = r1
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            goto L_0x0034
        L_0x002a:
            android.widget.ScrollView r1 = r4.autoScrollView
            android.view.View r1 = r1.getChildAt(r3)
            r0 = r1
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
        L_0x0034:
            if (r0 == 0) goto L_0x003d
            android.view.View r1 = r0.getChildAt(r3)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            return r1
        L_0x003d:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.santander.globile.mobisec.securekeyboard.scrolling.AutoScrollManager.getCurrentRootLayoutEmbedded():android.view.ViewGroup");
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        this.context = null;
        this.autoScrollView = null;
        this.nestedAutoScrollView = null;
        this.lockableScrollView = null;
        this.extraBottomSpace = null;
        this.lastSecureEditTextRequest = null;
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [com.santander.globile.mobisec.securekeyboard.scrolling.LockableScrollView, android.view.ViewGroup] */
    /* access modifiers changed from: package-private */
    public void resetIfNecessary() {
        if (scrollerIsNotCorrectlySetted(this.autoScrollView) && scrollerIsNotCorrectlySetted(this.nestedAutoScrollView) && scrollerIsNotCorrectlySetted(this.lockableScrollView) && getStatus() == AutoScrollManagerStatus.SETTED) {
            this.autoScrollView = null;
            this.nestedAutoScrollView = null;
            this.lockableScrollView = null;
            setStatus(AutoScrollManagerStatus.NOT_SETTED);
            this.isResetedBeforeStopped = false;
            this.originalScrollPosition = null;
            this.lastSecureEditTextRequest = null;
            this.extraBottomSpace = null;
            GlobileLog.d(AUTOSCROLL_TAG, "> AutoScroll TOTALLY RESETED!");
        }
    }

    private boolean scrollerIsNotCorrectlySetted(ViewGroup scroller) {
        return scroller == null || !scroller.getRootView().getClass().getName().equals("com.android.internal.policy.DecorView");
    }
}
