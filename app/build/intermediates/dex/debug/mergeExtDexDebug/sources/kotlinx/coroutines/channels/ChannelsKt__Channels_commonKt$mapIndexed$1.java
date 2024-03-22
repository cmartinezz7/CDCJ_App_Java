package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$mapIndexed$1", f = "Channels.common.kt", i = {0, 1, 2, 2, 3, 3}, l = {1220, 1220, 1221, 1221}, m = "invokeSuspend", n = {"index", "index", "index", "e", "index", "e"}, s = {"I$0", "I$0", "I$0", "L$1", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$mapIndexed$1 extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_mapIndexed;
    final /* synthetic */ Function3 $transform;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$mapIndexed$1(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_mapIndexed = receiveChannel;
        this.$transform = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$mapIndexed$1 channelsKt__Channels_commonKt$mapIndexed$1 = new ChannelsKt__Channels_commonKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        channelsKt__Channels_commonKt$mapIndexed$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$mapIndexed$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$mapIndexed$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 12 */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x009a
            r6 = 0
            if (r1 == r5) goto L_0x007d
            if (r1 == r4) goto L_0x0060
            r7 = 0
            if (r1 == r3) goto L_0x003d
            if (r1 != r2) goto L_0x0035
            r1 = r7
            java.lang.Object r7 = r12.L$2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r1 = r12.L$1
            int r6 = r12.I$0
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            boolean r9 = r13 instanceof kotlin.Result.Failure
            if (r9 != 0) goto L_0x002f
            r11 = r8
            r8 = r7
            r7 = r6
            r6 = r0
            r0 = r13
            r13 = r12
            goto L_0x0103
        L_0x002f:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0035:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003d:
            r1 = r7
            java.lang.Object r7 = r12.L$3
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            java.lang.Object r8 = r12.L$2
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r1 = r12.L$1
            int r6 = r12.I$0
            java.lang.Object r9 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            boolean r10 = r13 instanceof kotlin.Result.Failure
            if (r10 != 0) goto L_0x005a
            r10 = r13
            r11 = r9
            r13 = r12
            r9 = r1
            r1 = r0
            r0 = r10
            goto L_0x00ef
        L_0x005a:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0060:
            r1 = r6
            java.lang.Object r6 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            int r1 = r12.I$0
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r13 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x0077
            r9 = r13
            r8 = r7
            r13 = r12
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r9
            goto L_0x00d1
        L_0x0077:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x007d:
            r1 = r6
            java.lang.Object r6 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            int r1 = r12.I$0
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r13 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x0094
            r9 = r13
            r8 = r7
            r13 = r12
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r9
            goto L_0x00ba
        L_0x0094:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x009a:
            boolean r1 = r13 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x010b
            kotlinx.coroutines.channels.ProducerScope r1 = r12.p$
            r6 = 0
            kotlinx.coroutines.channels.ReceiveChannel r7 = r12.$this_mapIndexed
            kotlinx.coroutines.channels.ChannelIterator r7 = r7.iterator()
            r8 = r1
            r1 = r0
            r0 = r13
            r13 = r12
        L_0x00ab:
            r13.L$0 = r8
            r13.I$0 = r6
            r13.L$1 = r7
            r13.label = r5
            java.lang.Object r9 = r7.hasNext(r13)
            if (r9 != r1) goto L_0x00ba
            return r1
        L_0x00ba:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0108
            r13.L$0 = r8
            r13.I$0 = r6
            r13.L$1 = r7
            r13.label = r4
            java.lang.Object r9 = r7.next(r13)
            if (r9 != r1) goto L_0x00d1
            return r1
        L_0x00d1:
            kotlin.jvm.functions.Function3 r10 = r13.$transform
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            int r6 = r6 + r5
            r13.L$0 = r8
            r13.I$0 = r6
            r13.L$1 = r9
            r13.L$2 = r7
            r13.L$3 = r8
            r13.label = r3
            java.lang.Object r10 = r10.invoke(r11, r9, r13)
            if (r10 != r1) goto L_0x00ec
            return r1
        L_0x00ec:
            r11 = r8
            r8 = r7
            r7 = r11
        L_0x00ef:
            r13.L$0 = r11
            r13.I$0 = r6
            r13.L$1 = r9
            r13.L$2 = r8
            r13.label = r2
            java.lang.Object r7 = r7.send(r10, r13)
            if (r7 != r1) goto L_0x0100
            return r1
        L_0x0100:
            r7 = r6
            r6 = r1
            r1 = r9
        L_0x0103:
            r1 = r6
            r6 = r7
            r7 = r8
            r8 = r11
            goto L_0x00ab
        L_0x0108:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x010b:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$mapIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
