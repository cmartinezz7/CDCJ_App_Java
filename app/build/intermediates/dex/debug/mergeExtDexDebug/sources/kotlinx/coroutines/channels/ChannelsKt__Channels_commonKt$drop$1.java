package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1", f = "Channels.common.kt", i = {0, 1, 2, 3, 4, 4}, l = {592, 592, 597, 597, 598}, m = "invokeSuspend", n = {"remaining", "remaining", "remaining", "remaining", "remaining", "e"}, s = {"I$0", "I$0", "I$0", "I$0", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$drop$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_drop;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$drop$1(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        super(2, continuation);
        this.$this_drop = receiveChannel;
        this.$n = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1 = new ChannelsKt__Channels_commonKt$drop$1(this.$this_drop, this.$n, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        channelsKt__Channels_commonKt$drop$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$drop$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$drop$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 12 */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0129 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            if (r1 == 0) goto L_0x00b0
            if (r1 == r7) goto L_0x0094
            if (r1 == r5) goto L_0x0077
            if (r1 == r4) goto L_0x005b
            if (r1 == r3) goto L_0x003e
            if (r1 != r2) goto L_0x0036
            r1 = 0
            r5 = r6
            java.lang.Object r6 = r12.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r1 = r12.L$1
            int r5 = r12.I$0
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r13 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x0030
            r9 = r7
            r7 = r5
            r5 = r13
            r13 = r12
            goto L_0x015a
        L_0x0030:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0036:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003e:
            r1 = r6
            java.lang.Object r5 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            int r1 = r12.I$0
            java.lang.Object r6 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r13 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x0055
            r7 = r13
            r9 = r6
            r13 = r12
            r6 = r5
            r5 = r1
            r1 = r7
            goto L_0x0144
        L_0x0055:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x005b:
            r1 = r6
            java.lang.Object r5 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            int r1 = r12.I$0
            java.lang.Object r6 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r13 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x0071
            r7 = r13
            r9 = r6
            r13 = r12
            r6 = r1
            r1 = r7
            goto L_0x012a
        L_0x0071:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0077:
            r1 = r6
            java.lang.Object r6 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            int r1 = r12.I$0
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            boolean r9 = r13 instanceof kotlin.Result.Failure
            if (r9 != 0) goto L_0x008e
            r10 = r6
            r9 = r8
            r6 = r0
            r8 = r1
            r0 = r12
            r1 = r13
            goto L_0x00fc
        L_0x008e:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0094:
            r1 = r6
            java.lang.Object r6 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            int r1 = r12.I$0
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            boolean r9 = r13 instanceof kotlin.Result.Failure
            if (r9 != 0) goto L_0x00aa
            r10 = r13
            r9 = r8
            r13 = r12
            r8 = r1
            r1 = r0
            r0 = r10
            goto L_0x00df
        L_0x00aa:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x00b0:
            boolean r1 = r13 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x0189
            kotlinx.coroutines.channels.ProducerScope r1 = r12.p$
            int r8 = r12.$n
            if (r8 < 0) goto L_0x00bb
            r6 = r7
        L_0x00bb:
            if (r6 == 0) goto L_0x0161
            int r6 = r12.$n
            if (r6 <= 0) goto L_0x010e
            kotlinx.coroutines.channels.ReceiveChannel r8 = r12.$this_drop
            kotlinx.coroutines.channels.ChannelIterator r8 = r8.iterator()
            r9 = r8
            r8 = r6
            r6 = r1
            r1 = r0
            r0 = r13
            r13 = r12
        L_0x00cd:
            r13.L$0 = r6
            r13.I$0 = r8
            r13.L$1 = r9
            r13.label = r7
            java.lang.Object r10 = r9.hasNext(r13)
            if (r10 != r1) goto L_0x00dc
            return r1
        L_0x00dc:
            r11 = r9
            r9 = r6
            r6 = r11
        L_0x00df:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x010c
            r13.L$0 = r9
            r13.I$0 = r8
            r13.L$1 = r6
            r13.label = r5
            java.lang.Object r10 = r6.next(r13)
            if (r10 != r1) goto L_0x00f6
            return r1
        L_0x00f6:
            r11 = r0
            r0 = r13
            r13 = r10
            r10 = r6
            r6 = r1
            r1 = r11
        L_0x00fc:
            int r8 = r8 + -1
            if (r8 != 0) goto L_0x0106
            r13 = r0
            r0 = r1
            r1 = r6
            r6 = r8
            goto L_0x0112
        L_0x0106:
            r13 = r0
            r0 = r1
            r1 = r6
            r6 = r9
            r9 = r10
            goto L_0x00cd
        L_0x010c:
            r6 = r8
            goto L_0x0112
        L_0x010e:
            r9 = r1
            r1 = r0
            r0 = r13
            r13 = r12
        L_0x0112:
            kotlinx.coroutines.channels.ReceiveChannel r5 = r13.$this_drop
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r11 = r1
            r1 = r0
            r0 = r11
        L_0x011b:
            r13.L$0 = r9
            r13.I$0 = r6
            r13.L$1 = r5
            r13.label = r4
            java.lang.Object r7 = r5.hasNext(r13)
            if (r7 != r0) goto L_0x012a
            return r0
        L_0x012a:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x015e
            r13.L$0 = r9
            r13.I$0 = r6
            r13.L$1 = r5
            r13.label = r3
            java.lang.Object r7 = r5.next(r13)
            if (r7 != r0) goto L_0x0141
            return r0
        L_0x0141:
            r11 = r6
            r6 = r5
            r5 = r11
        L_0x0144:
            r13.L$0 = r9
            r13.I$0 = r5
            r13.L$1 = r7
            r13.L$2 = r6
            r13.label = r2
            java.lang.Object r8 = r9.send(r7, r13)
            if (r8 != r0) goto L_0x0156
            return r0
        L_0x0156:
            r11 = r5
            r5 = r1
            r1 = r7
            r7 = r11
        L_0x015a:
            r1 = r5
            r5 = r6
            r6 = r7
            goto L_0x011b
        L_0x015e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0161:
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Requested element count "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r12.$n
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " is less than zero."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0189:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
