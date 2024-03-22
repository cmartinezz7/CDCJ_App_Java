package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$filterIndexed$1", f = "Channels.common.kt", i = {0, 1, 2, 2, 3, 3}, l = {660, 660, 661, 661}, m = "invokeSuspend", n = {"index", "index", "index", "e", "index", "e"}, s = {"I$0", "I$0", "I$0", "L$1", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$filterIndexed$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3 $predicate;
    final /* synthetic */ ReceiveChannel $this_filterIndexed;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$filterIndexed$1(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$filterIndexed$1 channelsKt__Channels_commonKt$filterIndexed$1 = new ChannelsKt__Channels_commonKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        channelsKt__Channels_commonKt$filterIndexed$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$filterIndexed$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$filterIndexed$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 13 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0094
            r6 = 0
            if (r1 == r5) goto L_0x0078
            if (r1 == r4) goto L_0x005b
            r7 = 0
            if (r1 == r3) goto L_0x003c
            if (r1 != r2) goto L_0x0034
            r1 = r7
            java.lang.Object r7 = r13.L$2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r1 = r13.L$1
            int r6 = r13.I$0
            java.lang.Object r8 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            boolean r9 = r14 instanceof kotlin.Result.Failure
            if (r9 != 0) goto L_0x002e
            r10 = r7
            r7 = r6
            r6 = r0
            r0 = r14
            r14 = r13
            goto L_0x010b
        L_0x002e:
            r0 = r14
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003c:
            r1 = r7
            java.lang.Object r7 = r13.L$2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r1 = r13.L$1
            int r6 = r13.I$0
            java.lang.Object r8 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            boolean r9 = r14 instanceof kotlin.Result.Failure
            if (r9 != 0) goto L_0x0055
            r9 = r1
            r10 = r7
            r1 = r14
            r7 = r6
            r6 = r0
            r0 = r13
            goto L_0x00ef
        L_0x0055:
            r0 = r14
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x005b:
            r1 = r6
            java.lang.Object r6 = r13.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            int r1 = r13.I$0
            java.lang.Object r7 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r14 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x0072
            r9 = r14
            r8 = r7
            r14 = r13
            r7 = r1
            r1 = r0
            r0 = r9
            goto L_0x00d0
        L_0x0072:
            r0 = r14
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0078:
            r1 = r6
            java.lang.Object r6 = r13.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            int r1 = r13.I$0
            java.lang.Object r7 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r14 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x008e
            r9 = r14
            r8 = r7
            r14 = r13
            r7 = r1
            r1 = r0
            r0 = r9
            goto L_0x00b9
        L_0x008e:
            r0 = r14
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0094:
            boolean r1 = r14 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x0118
            kotlinx.coroutines.channels.ProducerScope r1 = r13.p$
            r6 = 0
            kotlinx.coroutines.channels.ReceiveChannel r7 = r13.$this_filterIndexed
            kotlinx.coroutines.channels.ChannelIterator r7 = r7.iterator()
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r14
            r14 = r13
        L_0x00a7:
            r14.L$0 = r6
            r14.I$0 = r7
            r14.L$1 = r8
            r14.label = r5
            java.lang.Object r9 = r8.hasNext(r14)
            if (r9 != r1) goto L_0x00b6
            return r1
        L_0x00b6:
            r12 = r8
            r8 = r6
            r6 = r12
        L_0x00b9:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0115
            r14.L$0 = r8
            r14.I$0 = r7
            r14.L$1 = r6
            r14.label = r4
            java.lang.Object r9 = r6.next(r14)
            if (r9 != r1) goto L_0x00d0
            return r1
        L_0x00d0:
            kotlin.jvm.functions.Function3 r10 = r14.$predicate
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            int r7 = r7 + r5
            r14.L$0 = r8
            r14.I$0 = r7
            r14.L$1 = r9
            r14.L$2 = r6
            r14.label = r3
            java.lang.Object r10 = r10.invoke(r11, r9, r14)
            if (r10 != r1) goto L_0x00e9
            return r1
        L_0x00e9:
            r12 = r0
            r0 = r14
            r14 = r10
            r10 = r6
            r6 = r1
            r1 = r12
        L_0x00ef:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x010f
            r0.L$0 = r8
            r0.I$0 = r7
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r2
            java.lang.Object r14 = r8.send(r9, r0)
            if (r14 != r6) goto L_0x0108
            return r6
        L_0x0108:
            r14 = r0
            r0 = r1
            r1 = r9
        L_0x010b:
            r1 = r6
            r6 = r8
            r8 = r10
            goto L_0x00a7
        L_0x010f:
            r14 = r0
            r0 = r1
            r1 = r6
            r6 = r8
            r8 = r10
            goto L_0x00a7
        L_0x0115:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0118:
            r0 = r14
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$filterIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
