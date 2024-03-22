package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a_\u0010\u0006\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\t*\u0002H\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\n2'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aH\u0010\u0011\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0012\u001a\u00020\u00032'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aJ\u0010\u0014\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0012\u001a\u00020\u00032'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: Timeout.kt */
public final class TimeoutKt {
    public static final <T> Object withTimeout(long timeMillis, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> uCont) {
        if (timeMillis > 0) {
            Object access$setupTimeout = setupTimeout(new TimeoutCoroutine(timeMillis, uCont), block);
            if (access$setupTimeout == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(uCont);
            }
            return access$setupTimeout;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0094 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object withTimeoutOrNull(long r8, kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super T> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0049
            if (r2 != r3) goto L_0x0041
            r1 = r4
            java.lang.Object r2 = r11.L$1
            r1 = r2
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r2 = r11.L$0
            r10 = r2
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            long r8 = r11.J$0
            boolean r2 = r0 instanceof kotlin.Result.Failure     // Catch:{ TimeoutCancellationException -> 0x003f }
            if (r2 != 0) goto L_0x003a
            goto L_0x0087
        L_0x003a:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0     // Catch:{ TimeoutCancellationException -> 0x003f }
            java.lang.Throwable r0 = r0.exception     // Catch:{ TimeoutCancellationException -> 0x003f }
            throw r0     // Catch:{ TimeoutCancellationException -> 0x003f }
        L_0x003f:
            r0 = move-exception
            goto L_0x008c
        L_0x0041:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0049:
            boolean r2 = r0 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x0099
            r5 = 0
            int r0 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x0054
            return r4
        L_0x0054:
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r2 = r4
            kotlinx.coroutines.TimeoutCoroutine r2 = (kotlinx.coroutines.TimeoutCoroutine) r2
            r0.element = r2
            r11.J$0 = r8     // Catch:{ TimeoutCancellationException -> 0x0088 }
            r11.L$0 = r10     // Catch:{ TimeoutCancellationException -> 0x0088 }
            r11.L$1 = r0     // Catch:{ TimeoutCancellationException -> 0x0088 }
            r11.label = r3     // Catch:{ TimeoutCancellationException -> 0x0088 }
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ TimeoutCancellationException -> 0x0088 }
            r3 = 0
            kotlinx.coroutines.TimeoutCoroutine r5 = new kotlinx.coroutines.TimeoutCoroutine     // Catch:{ TimeoutCancellationException -> 0x0088 }
            r5.<init>(r8, r2)     // Catch:{ TimeoutCancellationException -> 0x0088 }
            r0.element = r5     // Catch:{ TimeoutCancellationException -> 0x0088 }
            java.lang.Object r6 = setupTimeout(r5, r10)     // Catch:{ TimeoutCancellationException -> 0x0088 }
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ TimeoutCancellationException -> 0x0088 }
            if (r6 != r2) goto L_0x0082
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ TimeoutCancellationException -> 0x0088 }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r2)     // Catch:{ TimeoutCancellationException -> 0x0088 }
        L_0x0082:
            if (r6 != r1) goto L_0x0085
            return r1
        L_0x0085:
            r1 = r0
            r0 = r6
        L_0x0087:
            return r0
        L_0x0088:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x008c:
            kotlinx.coroutines.Job r2 = r0.coroutine
            T r3 = r1.element
            kotlinx.coroutines.TimeoutCoroutine r3 = (kotlinx.coroutines.TimeoutCoroutine) r3
            if (r2 != r3) goto L_0x0095
            return r4
        L_0x0095:
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        L_0x0099:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> coroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        JobKt.disposeOnCompletion(coroutine, DelayKt.getDelay(coroutine.uCont.getContext()).invokeOnTimeout(coroutine.time, coroutine));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(coroutine, coroutine, block);
    }

    public static final TimeoutCancellationException TimeoutCancellationException(long time, Job coroutine) {
        Intrinsics.checkParameterIsNotNull(coroutine, "coroutine");
        return new TimeoutCancellationException("Timed out waiting for " + time + " ms", coroutine);
    }
}
