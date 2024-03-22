package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"tryRecover", "", "Lkotlinx/coroutines/AbstractCoroutine;", "exception", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: Scopes.kt */
public final class ScopesKt {
    public static final Throwable tryRecover(AbstractCoroutine<?> $receiver, Throwable exception) {
        Continuation cont;
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        ScopeCoroutine scopeCoroutine = (ScopeCoroutine) (!($receiver instanceof ScopeCoroutine) ? null : $receiver);
        if (scopeCoroutine == null || (cont = scopeCoroutine.uCont) == null) {
            return exception;
        }
        return StackTraceRecoveryKt.recoverStackTrace(exception, cont);
    }
}
