package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\b\u0010\t\u001a\u00020\u0002H\u0007\u001a@\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0013*\u00020\u0002H\b\u001a\u0015\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\"\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "plus", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: CoroutineScope.kt */
public final class CoroutineScopeKt {
    public static /* synthetic */ void isActive$annotations(CoroutineScope coroutineScope) {
    }

    public static final CoroutineScope plus(CoroutineScope $receiver, CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new ContextScope($receiver.getCoroutineContext().plus(context));
    }

    public static final CoroutineScope MainScope() {
        return new ContextScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    }

    public static final boolean isActive(CoroutineScope $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Job job = (Job) $receiver.getCoroutineContext().get(Job.Key);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static final <R> Object coroutineScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> block, Continuation<? super R> continuation) {
        Continuation uCont = continuation;
        ScopeCoroutine coroutine = new ScopeCoroutine(uCont.getContext(), uCont);
        Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(coroutine, coroutine, block);
        if (startUndispatchedOrReturn == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return startUndispatchedOrReturn;
    }

    public static final CoroutineScope CoroutineScope(CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new ContextScope(context.get(Job.Key) != null ? context : context.plus(JobKt__JobKt.Job$default((Job) null, 1, (Object) null)));
    }

    public static final void cancel(CoroutineScope $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Job job = (Job) $receiver.getCoroutineContext().get(Job.Key);
        if (job != null) {
            job.cancel();
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + $receiver).toString());
    }
}
