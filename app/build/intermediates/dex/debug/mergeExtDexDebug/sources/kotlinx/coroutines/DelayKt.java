package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: Delay.kt */
public final class DelayKt {
    public static final Object delay(long timeMillis, Continuation<? super Unit> uCont$iv) {
        if (timeMillis <= 0) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        CancellableContinuation cont = cancellable$iv;
        getDelay(cont.getContext()).scheduleResumeAfterDelay(timeMillis, cont);
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(uCont$iv);
        }
        return result;
    }

    public static final Delay getDelay(CoroutineContext $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        CoroutineContext.Element element = $receiver.get(ContinuationInterceptor.Key);
        if (!(element instanceof Delay)) {
            element = null;
        }
        Delay delay = (Delay) element;
        return delay != null ? delay : DefaultExecutorKt.getDefaultDelay();
    }
}
