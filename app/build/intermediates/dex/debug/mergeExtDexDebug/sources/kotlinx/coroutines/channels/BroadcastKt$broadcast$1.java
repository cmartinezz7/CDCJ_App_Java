package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$1", f = "Broadcast.kt", i = {2}, l = {29, 29, 30}, m = "invokeSuspend", n = {"e"}, s = {"L$1"})
/* compiled from: Broadcast.kt */
final class BroadcastKt$broadcast$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_broadcast;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BroadcastKt$broadcast$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.$this_broadcast = receiveChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        BroadcastKt$broadcast$1 broadcastKt$broadcast$1 = new BroadcastKt$broadcast$1(this.$this_broadcast, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        broadcastKt$broadcast$1.p$ = (ProducerScope) obj;
        return broadcastKt$broadcast$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((BroadcastKt$broadcast$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 10 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0067
            if (r1 == r4) goto L_0x004e
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            r1 = 0
            java.lang.Object r5 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r1 = r10.L$1
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r11 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x0027
            r7 = r6
            r6 = r5
            r5 = r0
            r0 = r11
            r11 = r10
            goto L_0x00ae
        L_0x0027:
            r0 = r11
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x002d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0035:
            java.lang.Object r1 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            boolean r6 = r11 instanceof kotlin.Result.Failure
            if (r6 != 0) goto L_0x0048
            r7 = r11
            r6 = r5
            r11 = r10
            r5 = r1
            r1 = r0
            r0 = r7
            goto L_0x0099
        L_0x0048:
            r0 = r11
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x004e:
            java.lang.Object r1 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            boolean r6 = r11 instanceof kotlin.Result.Failure
            if (r6 != 0) goto L_0x0061
            r7 = r11
            r6 = r5
            r11 = r10
            r5 = r1
            r1 = r0
            r0 = r7
            goto L_0x0084
        L_0x0061:
            r0 = r11
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0067:
            boolean r1 = r11 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x00b5
            kotlinx.coroutines.channels.ProducerScope r1 = r10.p$
            kotlinx.coroutines.channels.ReceiveChannel r5 = r10.$this_broadcast
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r6 = r1
            r1 = r0
            r0 = r11
            r11 = r10
        L_0x0077:
            r11.L$0 = r6
            r11.L$1 = r5
            r11.label = r4
            java.lang.Object r7 = r5.hasNext(r11)
            if (r7 != r1) goto L_0x0084
            return r1
        L_0x0084:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x00b2
            r11.L$0 = r6
            r11.L$1 = r5
            r11.label = r3
            java.lang.Object r7 = r5.next(r11)
            if (r7 != r1) goto L_0x0099
            return r1
        L_0x0099:
            r11.L$0 = r6
            r11.L$1 = r7
            r11.L$2 = r5
            r11.label = r2
            java.lang.Object r8 = r6.send(r7, r11)
            if (r8 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            r9 = r5
            r5 = r1
            r1 = r7
            r7 = r6
            r6 = r9
        L_0x00ae:
            r1 = r5
            r5 = r6
            r6 = r7
            goto L_0x0077
        L_0x00b2:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00b5:
            r0 = r11
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastKt$broadcast$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
