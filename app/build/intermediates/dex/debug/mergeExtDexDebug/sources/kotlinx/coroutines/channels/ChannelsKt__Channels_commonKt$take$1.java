package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$take$1", f = "Channels.common.kt", i = {0, 1, 2, 2}, l = {848, 848, 849}, m = "invokeSuspend", n = {"remaining", "remaining", "remaining", "e"}, s = {"I$0", "I$0", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$take$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_take;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$take$1(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        super(2, continuation);
        this.$this_take = receiveChannel;
        this.$n = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$take$1 channelsKt__Channels_commonKt$take$1 = new ChannelsKt__Channels_commonKt$take$1(this.$this_take, this.$n, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        channelsKt__Channels_commonKt$take$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$take$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$take$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 11 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0074
            if (r1 == r5) goto L_0x0057
            if (r1 == r3) goto L_0x0039
            if (r1 != r2) goto L_0x0031
            r1 = 0
            java.lang.Object r6 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r1 = r11.L$1
            int r4 = r11.I$0
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r12 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x002b
            r8 = r7
            r7 = r6
            r6 = r4
            r4 = r0
            r0 = r12
            r12 = r11
            goto L_0x00d0
        L_0x002b:
            r0 = r12
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            r1 = r4
            java.lang.Object r4 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            int r1 = r11.I$0
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r12 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x0051
            r8 = r12
            r7 = r6
            r12 = r11
            r6 = r4
            r4 = r1
            r1 = r0
            r0 = r8
            goto L_0x00b8
        L_0x0051:
            r0 = r12
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0057:
            r1 = r4
            java.lang.Object r4 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            int r1 = r11.I$0
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r12 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x006e
            r8 = r12
            r7 = r6
            r12 = r11
            r6 = r4
            r4 = r1
            r1 = r0
            r0 = r8
            goto L_0x00a1
        L_0x006e:
            r0 = r12
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0074:
            boolean r1 = r12 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x0107
            kotlinx.coroutines.channels.ProducerScope r1 = r11.p$
            int r6 = r11.$n
            if (r6 != 0) goto L_0x0081
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0081:
            if (r6 < 0) goto L_0x0084
            r4 = r5
        L_0x0084:
            if (r4 == 0) goto L_0x00df
            int r4 = r11.$n
            kotlinx.coroutines.channels.ReceiveChannel r6 = r11.$this_take
            kotlinx.coroutines.channels.ChannelIterator r6 = r6.iterator()
            r7 = r1
            r1 = r0
            r0 = r12
            r12 = r11
        L_0x0092:
            r12.L$0 = r7
            r12.I$0 = r4
            r12.L$1 = r6
            r12.label = r5
            java.lang.Object r8 = r6.hasNext(r12)
            if (r8 != r1) goto L_0x00a1
            return r1
        L_0x00a1:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00dc
            r12.L$0 = r7
            r12.I$0 = r4
            r12.L$1 = r6
            r12.label = r3
            java.lang.Object r8 = r6.next(r12)
            if (r8 != r1) goto L_0x00b8
            return r1
        L_0x00b8:
            r12.L$0 = r7
            r12.I$0 = r4
            r12.L$1 = r8
            r12.L$2 = r6
            r12.label = r2
            java.lang.Object r9 = r7.send(r8, r12)
            if (r9 != r1) goto L_0x00ca
            return r1
        L_0x00ca:
            r10 = r4
            r4 = r1
            r1 = r8
            r8 = r7
            r7 = r6
            r6 = r10
        L_0x00d0:
            int r6 = r6 + -1
            if (r6 != 0) goto L_0x00d7
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        L_0x00d7:
            r1 = r4
            r4 = r6
            r6 = r7
            r7 = r8
            goto L_0x0092
        L_0x00dc:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00df:
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Requested element count "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r11.$n
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " is less than zero."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0107:
            r0 = r12
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$take$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
