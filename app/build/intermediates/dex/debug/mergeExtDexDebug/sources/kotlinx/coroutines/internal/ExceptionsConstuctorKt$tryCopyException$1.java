package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "E", "", "e", "invoke", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;"}, k = 3, mv = {1, 1, 13})
/* compiled from: ExceptionsConstuctor.kt */
final class ExceptionsConstuctorKt$tryCopyException$1 extends Lambda implements Function1<Throwable, E> {
    final /* synthetic */ Constructor $constructor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExceptionsConstuctorKt$tryCopyException$1(Constructor constructor) {
        super(1);
        this.$constructor = constructor;
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    public final E invoke(Throwable e) {
        E e2;
        Intrinsics.checkParameterIsNotNull(e, "e");
        try {
            Result.Companion companion = Result.Companion;
            Object newInstance = this.$constructor.newInstance(new Object[]{e.getMessage(), e});
            if (newInstance != null) {
                e2 = Result.m5constructorimpl((Throwable) newInstance);
                if (Result.m11isFailureimpl(e2)) {
                    e2 = null;
                }
                return (Throwable) e2;
            }
            throw new TypeCastException("null cannot be cast to non-null type E");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            e2 = Result.m5constructorimpl(ResultKt.createFailure(th));
        }
    }
}
