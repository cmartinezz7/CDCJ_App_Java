package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 1, 13})
public final class BuildersKt {
    public static final <T> Deferred<T> async(CoroutineScope $receiver, CoroutineContext context, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        return BuildersKt__Builders_commonKt.async($receiver, context, start, block);
    }

    public static final Job launch(CoroutineScope $receiver, CoroutineContext context, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        return BuildersKt__Builders_commonKt.launch($receiver, context, start, block);
    }

    public static final <T> T runBlocking(CoroutineContext context, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) throws InterruptedException {
        return BuildersKt__BuildersKt.runBlocking(context, block);
    }

    public static final <T> Object withContext(CoroutineContext context, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> continuation) {
        return BuildersKt__Builders_commonKt.withContext(context, block, continuation);
    }
}
