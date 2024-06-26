package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"toState", "", "T", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: CompletedExceptionally.kt */
public final class CompletedExceptionallyKt {
    public static final <T> Object toState(Object $receiver) {
        if (Result.m12isSuccessimpl($receiver)) {
            ResultKt.throwOnFailure($receiver);
            return $receiver;
        }
        Throwable r1 = Result.m8exceptionOrNullimpl($receiver);
        if (r1 == null) {
            Intrinsics.throwNpe();
        }
        return new CompletedExceptionally(r1);
    }
}
