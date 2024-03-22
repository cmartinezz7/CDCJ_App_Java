package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$withIndex$1", f = "Channels.common.kt", i = {0, 1, 2, 2}, l = {1424, 1424, 1425}, m = "invokeSuspend", n = {"index", "index", "index", "e"}, s = {"I$0", "I$0", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$withIndex$1 extends SuspendLambda implements Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_withIndex;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$withIndex$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.$this_withIndex = receiveChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$withIndex$1 channelsKt__Channels_commonKt$withIndex$1 = new ChannelsKt__Channels_commonKt$withIndex$1(this.$this_withIndex, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        channelsKt__Channels_commonKt$withIndex$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$withIndex$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$withIndex$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 12 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0070
            r5 = 0
            if (r1 == r4) goto L_0x0054
            if (r1 == r3) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            r1 = 0
            java.lang.Object r6 = r12.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r1 = r12.L$1
            int r5 = r12.I$0
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r13 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x0029
            r10 = r5
            r5 = r0
            r0 = r13
            r13 = r12
            goto L_0x00c6
        L_0x0029:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0037:
            r1 = r5
            java.lang.Object r5 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            int r1 = r12.I$0
            java.lang.Object r6 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r13 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x004e
            r8 = r13
            r7 = r6
            r13 = r12
            r6 = r1
            r1 = r0
            r0 = r8
            goto L_0x00aa
        L_0x004e:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0054:
            r1 = r5
            java.lang.Object r5 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            int r1 = r12.I$0
            java.lang.Object r6 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r13 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x006a
            r8 = r13
            r7 = r6
            r13 = r12
            r6 = r1
            r1 = r0
            r0 = r8
            goto L_0x0093
        L_0x006a:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0070:
            boolean r1 = r13 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x00cd
            kotlinx.coroutines.channels.ProducerScope r1 = r12.p$
            r5 = 0
            kotlinx.coroutines.channels.ReceiveChannel r6 = r12.$this_withIndex
            kotlinx.coroutines.channels.ChannelIterator r6 = r6.iterator()
            r7 = r1
            r1 = r0
            r0 = r13
            r13 = r12
            r11 = r6
            r6 = r5
            r5 = r11
        L_0x0084:
            r13.L$0 = r7
            r13.I$0 = r6
            r13.L$1 = r5
            r13.label = r4
            java.lang.Object r8 = r5.hasNext(r13)
            if (r8 != r1) goto L_0x0093
            return r1
        L_0x0093:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00ca
            r13.L$0 = r7
            r13.I$0 = r6
            r13.L$1 = r5
            r13.label = r3
            java.lang.Object r8 = r5.next(r13)
            if (r8 != r1) goto L_0x00aa
            return r1
        L_0x00aa:
            kotlin.collections.IndexedValue r9 = new kotlin.collections.IndexedValue
            int r10 = r6 + 1
            r9.<init>(r6, r8)
            r13.L$0 = r7
            r13.I$0 = r10
            r13.L$1 = r8
            r13.L$2 = r5
            r13.label = r2
            java.lang.Object r6 = r7.send(r9, r13)
            if (r6 != r1) goto L_0x00c3
            return r1
        L_0x00c3:
            r6 = r5
            r5 = r1
            r1 = r8
        L_0x00c6:
            r1 = r5
            r5 = r6
            r6 = r10
            goto L_0x0084
        L_0x00ca:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00cd:
            r0 = r13
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$withIndex$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
