package com.google.android.material.transition;

import kotlin.KotlinVersion;

class FadeModeEvaluators {
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float progress, float fadeStartFraction, float fadeEndFraction, float threshold) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp((int) KotlinVersion.MAX_COMPONENT_VALUE, 0, fadeStartFraction, fadeEndFraction, progress), TransitionUtils.lerp(0, (int) KotlinVersion.MAX_COMPONENT_VALUE, fadeStartFraction, fadeEndFraction, progress));
        }
    };
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float progress, float fadeStartFraction, float fadeEndFraction, float threshold) {
            return FadeModeResult.endOnTop(KotlinVersion.MAX_COMPONENT_VALUE, TransitionUtils.lerp(0, (int) KotlinVersion.MAX_COMPONENT_VALUE, fadeStartFraction, fadeEndFraction, progress));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float progress, float fadeStartFraction, float fadeEndFraction, float threshold) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp((int) KotlinVersion.MAX_COMPONENT_VALUE, 0, fadeStartFraction, fadeEndFraction, progress), KotlinVersion.MAX_COMPONENT_VALUE);
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float progress, float fadeStartFraction, float fadeEndFraction, float threshold) {
            float fadeFractionThreshold = ((fadeEndFraction - fadeStartFraction) * threshold) + fadeStartFraction;
            return FadeModeResult.startOnTop(TransitionUtils.lerp((int) KotlinVersion.MAX_COMPONENT_VALUE, 0, fadeStartFraction, fadeFractionThreshold, progress), TransitionUtils.lerp(0, (int) KotlinVersion.MAX_COMPONENT_VALUE, fadeFractionThreshold, fadeEndFraction, progress));
        }
    };

    static FadeModeEvaluator get(int fadeMode, boolean entering) {
        if (fadeMode == 0) {
            return entering ? IN : OUT;
        }
        if (fadeMode == 1) {
            return entering ? OUT : IN;
        }
        if (fadeMode == 2) {
            return CROSS;
        }
        if (fadeMode == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + fadeMode);
    }

    private FadeModeEvaluators() {
    }
}
