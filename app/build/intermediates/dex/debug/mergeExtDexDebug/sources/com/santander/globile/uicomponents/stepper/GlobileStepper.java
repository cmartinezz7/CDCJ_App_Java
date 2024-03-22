package com.santander.globile.uicomponents.stepper;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.santander.globile.uicomponents.R;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0007J\u0014\u0010\u0016\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/santander/globile/uicomponents/stepper/GlobileStepper;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mNumberOfSteps", "mProgressBar", "Landroid/widget/ProgressBar;", "mSeparatedLinesLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mStepsList", "Ljava/util/ArrayList;", "Lcom/santander/globile/uicomponents/stepper/GlobileStepper$ViewAndOnGoing;", "Lkotlin/collections/ArrayList;", "createCustomLayout", "", "setCurrentStep", "currentStep", "setStepBackground", "Landroid/view/View;", "stepColor", "Lcom/santander/globile/uicomponents/stepper/GlobileStepper$StepColor;", "StepColor", "ViewAndOnGoing", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileStepper.kt */
public final class GlobileStepper extends LinearLayout {
    private HashMap _$_findViewCache;
    private int mNumberOfSteps;
    private ProgressBar mProgressBar;
    private ConstraintLayout mSeparatedLinesLayout;
    private ArrayList<ViewAndOnGoing> mStepsList;

    public GlobileStepper(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileStepper(Context context, AttributeSet attributeSet) {
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
    public GlobileStepper(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mStepsList = new ArrayList<>();
        this.mNumberOfSteps = 5;
        LayoutInflater.from(context).inflate(R.layout.globile_stepper, this, true);
        this.mSeparatedLinesLayout = findViewById(R.id.separated_lines_stepper);
        this.mStepsList.add(new ViewAndOnGoing(findViewById(R.id.step_0), 1));
        this.mStepsList.add(new ViewAndOnGoing(findViewById(R.id.step_1), 2));
        this.mStepsList.add(new ViewAndOnGoing(findViewById(R.id.step_2), 3));
        this.mStepsList.add(new ViewAndOnGoing(findViewById(R.id.step_3), 4));
        this.mStepsList.add(new ViewAndOnGoing(findViewById(R.id.step_4), 5));
        this.mProgressBar = (ProgressBar) findViewById(R.id.continuous_stepper);
        createCustomLayout(attrs);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileStepper(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void createCustomLayout(AttributeSet attrs) {
        View view;
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.GlobileStepper, 0, 0);
        int numberOfSteps = attributes.getInt(R.styleable.GlobileStepper_numberOfSteps, 0);
        this.mNumberOfSteps = numberOfSteps;
        ConstraintLayout constraintLayout = this.mSeparatedLinesLayout;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (numberOfSteps > 5) {
            ProgressBar progressBar2 = this.mProgressBar;
            if (progressBar2 != null) {
                progressBar2.setVisibility(0);
            }
        } else {
            ConstraintLayout constraintLayout2 = this.mSeparatedLinesLayout;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(0);
            }
            for (ViewAndOnGoing it : this.mStepsList) {
                if (numberOfSteps < it.getOnGoing() && (view = it.getView()) != null) {
                    view.setVisibility(8);
                }
            }
        }
        setCurrentStep(1);
        attributes.recycle();
    }

    public final void setCurrentStep(int currentStep) {
        StepColor stepColor;
        int i = this.mNumberOfSteps;
        if (i > 5) {
            ProgressBar progressBar = this.mProgressBar;
            if (progressBar != null) {
                progressBar.setProgress((int) ((((float) currentStep) / ((float) i)) * ((float) 100)));
            }
        } else {
            for (ViewAndOnGoing it : this.mStepsList) {
                if (currentStep == it.getOnGoing()) {
                    stepColor = StepColor.ONGOING;
                } else if (currentStep < it.getOnGoing()) {
                    stepColor = StepColor.NEXT;
                } else {
                    stepColor = StepColor.COMPLETED;
                }
                View view = it.getView();
                if (view != null) {
                    setStepBackground(view, stepColor);
                }
            }
        }
        Toast toast = Toast.makeText(getContext(), "Step " + currentStep + ", " + (this.mNumberOfSteps - currentStep) + " remaining", 0);
        Intrinsics.checkExpressionValueIsNotNull(toast, "toast");
        View view2 = toast.getView();
        Intrinsics.checkExpressionValueIsNotNull(view2, "toast.view");
        view2.setVisibility(8);
        toast.show();
    }

    private final void setStepBackground(View $this$setStepBackground, StepColor stepColor) {
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = $this$setStepBackground.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            $this$setStepBackground.setBackgroundColor(context.getResources().getColor(stepColor.getColor(), (Resources.Theme) null));
            return;
        }
        Context context2 = $this$setStepBackground.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        $this$setStepBackground.setBackgroundColor(context2.getResources().getColor(stepColor.getColor()));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/santander/globile/uicomponents/stepper/GlobileStepper$ViewAndOnGoing;", "", "view", "Landroid/view/View;", "onGoing", "", "(Landroid/view/View;I)V", "getOnGoing", "()I", "getView", "()Landroid/view/View;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileStepper.kt */
    private static final class ViewAndOnGoing {
        private final int onGoing;
        private final View view;

        public ViewAndOnGoing(View view2, int onGoing2) {
            this.view = view2;
            this.onGoing = onGoing2;
        }

        public final int getOnGoing() {
            return this.onGoing;
        }

        public final View getView() {
            return this.view;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/santander/globile/uicomponents/stepper/GlobileStepper$StepColor;", "", "color", "", "(Ljava/lang/String;II)V", "getColor", "()I", "COMPLETED", "ONGOING", "NEXT", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileStepper.kt */
    private enum StepColor {
        COMPLETED(R.color.completed_step),
        ONGOING(R.color.ongoing_step),
        NEXT(R.color.next_step);
        
        private final int color;

        private StepColor(int color2) {
            this.color = color2;
        }

        public final int getColor() {
            return this.color;
        }
    }
}
