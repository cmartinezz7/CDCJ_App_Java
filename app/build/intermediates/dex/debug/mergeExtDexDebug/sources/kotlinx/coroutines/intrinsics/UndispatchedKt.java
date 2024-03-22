package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopesKt;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\b\u001a>\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aR\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a>\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aR\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001aY\u0010\u000f\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aY\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a?\u0010\u0014\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00062\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/AbstractCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: Undispatched.kt */
public final class UndispatchedKt {
    public static final <T> void startCoroutineUnintercepted(Function1<? super Continuation<? super T>, ? extends Object> $receiver, Continuation<? super T> completion) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        Continuation actualCompletion = DebugProbesKt.probeCoroutineCreated(completion);
        try {
            Object value$iv = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity($receiver, 1)).invoke(actualCompletion);
            if (value$iv != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Result.Companion companion = Result.Companion;
                actualCompletion.resumeWith(Result.m5constructorimpl(value$iv));
            }
        } catch (Throwable e$iv) {
            Result.Companion companion2 = Result.Companion;
            actualCompletion.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(e$iv)));
        }
    }

    public static final <R, T> void startCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> $receiver, R receiver, Continuation<? super T> completion) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        Continuation actualCompletion = DebugProbesKt.probeCoroutineCreated(completion);
        try {
            Object value$iv = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity($receiver, 2)).invoke(receiver, actualCompletion);
            if (value$iv != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Result.Companion companion = Result.Companion;
                actualCompletion.resumeWith(Result.m5constructorimpl(value$iv));
            }
        } catch (Throwable e$iv) {
            Result.Companion companion2 = Result.Companion;
            actualCompletion.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(e$iv)));
        }
    }

    public static final <T> void startCoroutineUndispatched(Function1<? super Continuation<? super T>, ? extends Object> $receiver, Continuation<? super T> completion) {
        CoroutineContext context$iv;
        Object oldValue$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        Continuation actualCompletion = probeCoroutineCreated;
        try {
            context$iv = completion.getContext();
            oldValue$iv = ThreadContextKt.updateThreadContext(context$iv, (Object) null);
            Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity($receiver, 1)).invoke(actualCompletion);
            ThreadContextKt.restoreThreadContext(context$iv, oldValue$iv);
            Object value$iv = invoke;
            if (value$iv != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Result.Companion companion = Result.Companion;
                probeCoroutineCreated.resumeWith(Result.m5constructorimpl(value$iv));
            }
        } catch (Throwable e$iv) {
            Result.Companion companion2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(e$iv)));
        }
    }

    public static final <R, T> void startCoroutineUndispatched(Function2<? super R, ? super Continuation<? super T>, ? extends Object> $receiver, R receiver, Continuation<? super T> completion) {
        CoroutineContext context$iv;
        Object oldValue$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        Continuation actualCompletion = probeCoroutineCreated;
        try {
            context$iv = completion.getContext();
            oldValue$iv = ThreadContextKt.updateThreadContext(context$iv, (Object) null);
            Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity($receiver, 2)).invoke(receiver, actualCompletion);
            ThreadContextKt.restoreThreadContext(context$iv, oldValue$iv);
            Object value$iv = invoke;
            if (value$iv != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Result.Companion companion = Result.Companion;
                probeCoroutineCreated.resumeWith(Result.m5constructorimpl(value$iv));
            }
        } catch (Throwable e$iv) {
            Result.Companion companion2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(e$iv)));
        }
    }

    private static final <T> void startDirect(Continuation<? super T> completion, Function1<? super Continuation<? super T>, ? extends Object> block) {
        Continuation actualCompletion = DebugProbesKt.probeCoroutineCreated(completion);
        try {
            Object value = block.invoke(actualCompletion);
            if (value != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Result.Companion companion = Result.Companion;
                actualCompletion.resumeWith(Result.m5constructorimpl(value));
            }
        } catch (Throwable e) {
            Result.Companion companion2 = Result.Companion;
            actualCompletion.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(e)));
        }
    }

    public static final <T, R> Object startUndispatchedOrReturn(AbstractCoroutine<? super T> $receiver, R receiver, Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        Object obj;
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(block, "block");
        $receiver.initParentJob$kotlinx_coroutines_core();
        AbstractCoroutine $receiver$iv = $receiver;
        try {
            obj = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, 2)).invoke(receiver, $receiver);
        } catch (Throwable e$iv) {
            obj = new CompletedExceptionally(e$iv);
        }
        Object result$iv = obj;
        if (result$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (!$receiver$iv.makeCompletingOnce$kotlinx_coroutines_core(result$iv, 4)) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object state$iv = $receiver$iv.getState$kotlinx_coroutines_core();
        if (!(state$iv instanceof CompletedExceptionally)) {
            return JobSupportKt.unboxState(state$iv);
        }
        Throwable th = ((CompletedExceptionally) state$iv).cause;
        throw ScopesKt.tryRecover($receiver$iv, ((CompletedExceptionally) state$iv).cause);
    }

    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(AbstractCoroutine<? super T> $receiver, R receiver, Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        Object obj;
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(block, "block");
        $receiver.initParentJob$kotlinx_coroutines_core();
        AbstractCoroutine $receiver$iv = $receiver;
        try {
            obj = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, 2)).invoke(receiver, $receiver);
        } catch (Throwable e$iv) {
            obj = new CompletedExceptionally(e$iv);
        }
        Object result$iv = obj;
        if (result$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (!$receiver$iv.makeCompletingOnce$kotlinx_coroutines_core(result$iv, 4)) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object state$iv = $receiver$iv.getState$kotlinx_coroutines_core();
        if (!(state$iv instanceof CompletedExceptionally)) {
            return JobSupportKt.unboxState(state$iv);
        }
        Throwable e = ((CompletedExceptionally) state$iv).cause;
        if (!(e instanceof TimeoutCancellationException) || ((TimeoutCancellationException) e).coroutine != $receiver) {
            throw ScopesKt.tryRecover($receiver$iv, ((CompletedExceptionally) state$iv).cause);
        } else if (!(result$iv instanceof CompletedExceptionally)) {
            return result$iv;
        } else {
            throw ScopesKt.tryRecover($receiver$iv, ((CompletedExceptionally) result$iv).cause);
        }
    }

    private static final <T> Object undispatchedResult(AbstractCoroutine<? super T> $receiver, Function1<? super Throwable, Boolean> shouldThrow, Function0<? extends Object> startBlock) {
        Object result;
        try {
            result = startBlock.invoke();
        } catch (Throwable e) {
            result = new CompletedExceptionally(e);
        }
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (!$receiver.makeCompletingOnce$kotlinx_coroutines_core(result, 4)) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object state = $receiver.getState$kotlinx_coroutines_core();
        if (!(state instanceof CompletedExceptionally)) {
            return JobSupportKt.unboxState(state);
        }
        if (shouldThrow.invoke(((CompletedExceptionally) state).cause).booleanValue()) {
            throw ScopesKt.tryRecover($receiver, ((CompletedExceptionally) state).cause);
        } else if (!(result instanceof CompletedExceptionally)) {
            return result;
        } else {
            throw ScopesKt.tryRecover($receiver, ((CompletedExceptionally) result).cause);
        }
    }
}
