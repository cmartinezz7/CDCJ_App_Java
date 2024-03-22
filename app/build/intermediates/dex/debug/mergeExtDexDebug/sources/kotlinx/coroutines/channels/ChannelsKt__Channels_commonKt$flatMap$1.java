package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$flatMap$1", f = "Channels.common.kt", i = {2, 3}, l = {1105, 1105, 1106, 1106}, m = "invokeSuspend", n = {"e", "e"}, s = {"L$1", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$flatMap$1 extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_flatMap;
    final /* synthetic */ Function2 $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$flatMap$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_flatMap = receiveChannel;
        this.$transform = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$flatMap$1 channelsKt__Channels_commonKt$flatMap$1 = new ChannelsKt__Channels_commonKt$flatMap$1(this.$this_flatMap, this.$transform, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        channelsKt__Channels_commonKt$flatMap$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$flatMap$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$flatMap$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 12 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e0  */
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
            if (r1 == 0) goto L_0x0084
            if (r1 == r5) goto L_0x006c
            if (r1 == r4) goto L_0x0054
            r6 = 0
            if (r1 == r3) goto L_0x0038
            if (r1 != r2) goto L_0x0030
            r1 = r6
            java.lang.Object r6 = r12.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r1 = r12.L$1
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r13 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x002a
            r8 = r6
            r6 = r0
            r0 = r13
            r13 = r12
            goto L_0x00e4
        L_0x002a:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            r1 = r6
            java.lang.Object r6 = r12.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r1 = r12.L$1
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r13 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x004e
            r9 = r13
            r8 = r1
            r13 = r12
            r1 = r0
            r0 = r9
            goto L_0x00cc
        L_0x004e:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0054:
            java.lang.Object r1 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r13 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x0066
            r8 = r13
            r7 = r1
            r13 = r12
            r1 = r0
            r0 = r8
            goto L_0x00b7
        L_0x0066:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x006c:
            java.lang.Object r1 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r13 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x007e
            r8 = r13
            r7 = r1
            r13 = r12
            r1 = r0
            r0 = r8
            goto L_0x00a2
        L_0x007e:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0084:
            boolean r1 = r13 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x00eb
            kotlinx.coroutines.channels.ProducerScope r1 = r12.p$
            kotlinx.coroutines.channels.ReceiveChannel r6 = r12.$this_flatMap
            kotlinx.coroutines.channels.ChannelIterator r6 = r6.iterator()
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r13
            r13 = r12
        L_0x0095:
            r13.L$0 = r6
            r13.L$1 = r7
            r13.label = r5
            java.lang.Object r8 = r7.hasNext(r13)
            if (r8 != r1) goto L_0x00a2
            return r1
        L_0x00a2:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00e8
            r13.L$0 = r6
            r13.L$1 = r7
            r13.label = r4
            java.lang.Object r8 = r7.next(r13)
            if (r8 != r1) goto L_0x00b7
            return r1
        L_0x00b7:
            kotlin.jvm.functions.Function2 r9 = r13.$transform
            r13.L$0 = r6
            r13.L$1 = r8
            r13.L$2 = r7
            r13.label = r3
            java.lang.Object r9 = r9.invoke(r8, r13)
            if (r9 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            r11 = r7
            r7 = r6
            r6 = r11
        L_0x00cc:
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            r10 = r7
            kotlinx.coroutines.channels.SendChannel r10 = (kotlinx.coroutines.channels.SendChannel) r10
            r13.L$0 = r7
            r13.L$1 = r8
            r13.L$2 = r6
            r13.label = r2
            java.lang.Object r9 = kotlinx.coroutines.channels.ChannelsKt.toChannel(r9, r10, r13)
            if (r9 != r1) goto L_0x00e0
            return r1
        L_0x00e0:
            r11 = r6
            r6 = r1
            r1 = r8
            r8 = r11
        L_0x00e4:
            r1 = r6
            r6 = r7
            r7 = r8
            goto L_0x0095
        L_0x00e8:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00eb:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$flatMap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
