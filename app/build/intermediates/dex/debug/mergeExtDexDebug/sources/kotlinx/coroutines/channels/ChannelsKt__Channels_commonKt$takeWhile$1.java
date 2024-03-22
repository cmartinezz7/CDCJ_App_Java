package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$takeWhile$1", f = "Channels.common.kt", i = {2, 3}, l = {869, 869, 870, 871}, m = "invokeSuspend", n = {"e", "e"}, s = {"L$1", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$takeWhile$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ ReceiveChannel $this_takeWhile;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$takeWhile$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_takeWhile = receiveChannel;
        this.$predicate = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$takeWhile$1 channelsKt__Channels_commonKt$takeWhile$1 = new ChannelsKt__Channels_commonKt$takeWhile$1(this.$this_takeWhile, this.$predicate, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        channelsKt__Channels_commonKt$takeWhile$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$takeWhile$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$takeWhile$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 11 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
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
            java.lang.Object r6 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r1 = r11.L$1
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r12 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x002a
            r8 = r6
            r6 = r0
            r0 = r12
            r12 = r11
            goto L_0x00ea
        L_0x002a:
            r0 = r12
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
            java.lang.Object r6 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r1 = r11.L$1
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r12 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x004e
            r9 = r12
            r8 = r1
            r12 = r11
            r1 = r0
            r0 = r9
            goto L_0x00cc
        L_0x004e:
            r0 = r12
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0054:
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r12 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x0066
            r8 = r12
            r7 = r1
            r12 = r11
            r1 = r0
            r0 = r8
            goto L_0x00b7
        L_0x0066:
            r0 = r12
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x006c:
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r12 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x007e
            r8 = r12
            r7 = r1
            r12 = r11
            r1 = r0
            r0 = r8
            goto L_0x00a2
        L_0x007e:
            r0 = r12
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0084:
            boolean r1 = r12 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x00f1
            kotlinx.coroutines.channels.ProducerScope r1 = r11.p$
            kotlinx.coroutines.channels.ReceiveChannel r6 = r11.$this_takeWhile
            kotlinx.coroutines.channels.ChannelIterator r6 = r6.iterator()
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r12
            r12 = r11
        L_0x0095:
            r12.L$0 = r6
            r12.L$1 = r7
            r12.label = r5
            java.lang.Object r8 = r7.hasNext(r12)
            if (r8 != r1) goto L_0x00a2
            return r1
        L_0x00a2:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00ee
            r12.L$0 = r6
            r12.L$1 = r7
            r12.label = r4
            java.lang.Object r8 = r7.next(r12)
            if (r8 != r1) goto L_0x00b7
            return r1
        L_0x00b7:
            kotlin.jvm.functions.Function2 r9 = r12.$predicate
            r12.L$0 = r6
            r12.L$1 = r8
            r12.L$2 = r7
            r12.label = r3
            java.lang.Object r9 = r9.invoke(r8, r12)
            if (r9 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            r10 = r7
            r7 = r6
            r6 = r10
        L_0x00cc:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x00d7
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00d7:
            r12.L$0 = r7
            r12.L$1 = r8
            r12.L$2 = r6
            r12.label = r2
            java.lang.Object r9 = r7.send(r8, r12)
            if (r9 != r1) goto L_0x00e6
            return r1
        L_0x00e6:
            r10 = r6
            r6 = r1
            r1 = r8
            r8 = r10
        L_0x00ea:
            r1 = r6
            r6 = r7
            r7 = r8
            goto L_0x0095
        L_0x00ee:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00f1:
            r0 = r12
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$takeWhile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
