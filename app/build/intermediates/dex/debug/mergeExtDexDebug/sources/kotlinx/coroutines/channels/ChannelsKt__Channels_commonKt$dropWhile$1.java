package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$dropWhile$1", f = "Channels.common.kt", i = {2, 3, 6}, l = {615, 615, 616, 617, 621, 621, 622}, m = "invokeSuspend", n = {"e", "e", "e"}, s = {"L$1", "L$1", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$dropWhile$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ ReceiveChannel $this_dropWhile;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$dropWhile$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$dropWhile$1 channelsKt__Channels_commonKt$dropWhile$1 = new ChannelsKt__Channels_commonKt$dropWhile$1(this.$this_dropWhile, this.$predicate, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        channelsKt__Channels_commonKt$dropWhile$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$dropWhile$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$dropWhile$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 8 */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d3, code lost:
        r9.L$0 = r3;
        r9.L$1 = r2;
        r9.label = 1;
        r4 = r2.hasNext(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00de, code lost:
        if (r4 != r1) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e0, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e7, code lost:
        if (((java.lang.Boolean) r4).booleanValue() == false) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e9, code lost:
        r9.L$0 = r3;
        r9.L$1 = r2;
        r9.label = 2;
        r4 = r2.next(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f4, code lost:
        if (r4 != r1) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f6, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f7, code lost:
        r7 = r3;
        r3 = r2;
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fa, code lost:
        r5 = r9.$predicate;
        r9.L$0 = r2;
        r9.L$1 = r4;
        r9.L$2 = r3;
        r9.label = 3;
        r5 = r5.invoke(r4, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010a, code lost:
        if (r5 != r1) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010d, code lost:
        r7 = r0;
        r0 = r9;
        r9 = r5;
        r5 = r2;
        r2 = r1;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0119, code lost:
        if (((java.lang.Boolean) r9).booleanValue() != false) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011b, code lost:
        r0.L$0 = r5;
        r0.L$1 = r4;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0126, code lost:
        if (r5.send(r4, r0) != r2) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0128, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0129, code lost:
        r9 = r1;
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012b, code lost:
        r1 = r2;
        r3 = r5;
        r7 = r0;
        r0 = r9;
        r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0131, code lost:
        r9 = r0;
        r0 = r1;
        r1 = r2;
        r2 = r3;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0137, code lost:
        r2 = r9.$this_dropWhile.iterator();
        r7 = r1;
        r1 = r0;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0140, code lost:
        r9.L$0 = r3;
        r9.L$1 = r2;
        r9.label = 5;
        r4 = r2.hasNext(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x014b, code lost:
        if (r4 != r0) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0154, code lost:
        if (((java.lang.Boolean) r4).booleanValue() == false) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0156, code lost:
        r9.L$0 = r3;
        r9.L$1 = r2;
        r9.label = 6;
        r4 = r2.next(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0161, code lost:
        if (r4 != r0) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0163, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0164, code lost:
        r9.L$0 = r3;
        r9.L$1 = r4;
        r9.L$2 = r2;
        r9.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0172, code lost:
        if (r3.send(r4, r9) != r0) goto L_0x0175;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0174, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0175, code lost:
        r7 = r2;
        r2 = r1;
        r1 = r4;
        r4 = r3;
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x017a, code lost:
        r1 = r2;
        r2 = r3;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0180, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x00c3;
                case 1: goto L_0x00aa;
                case 2: goto L_0x0092;
                case 3: goto L_0x0075;
                case 4: goto L_0x005f;
                case 5: goto L_0x0046;
                case 6: goto L_0x002d;
                case 7: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0012:
            r1 = r2
            java.lang.Object r2 = r8.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r1 = r8.L$1
            java.lang.Object r3 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r3 = (kotlinx.coroutines.channels.ProducerScope) r3
            boolean r4 = r9 instanceof kotlin.Result.Failure
            if (r4 != 0) goto L_0x0027
            r4 = r3
            r3 = r2
            r2 = r9
            r9 = r8
            goto L_0x017a
        L_0x0027:
            r0 = r9
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x002d:
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r2 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            boolean r3 = r9 instanceof kotlin.Result.Failure
            if (r3 != 0) goto L_0x0040
            r4 = r9
            r3 = r2
            r9 = r8
            r2 = r1
            r1 = r4
            goto L_0x0164
        L_0x0040:
            r0 = r9
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0046:
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r2 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            boolean r3 = r9 instanceof kotlin.Result.Failure
            if (r3 != 0) goto L_0x0059
            r4 = r9
            r3 = r2
            r9 = r8
            r2 = r1
            r1 = r4
            goto L_0x014e
        L_0x0059:
            r0 = r9
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x005f:
            r1 = r2
            java.lang.Object r1 = r8.L$1
            java.lang.Object r2 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            boolean r3 = r9 instanceof kotlin.Result.Failure
            if (r3 != 0) goto L_0x006f
            r5 = r2
            r2 = r0
            r0 = r8
            goto L_0x012b
        L_0x006f:
            r0 = r9
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0075:
            r1 = r2
            java.lang.Object r2 = r8.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r1 = r8.L$1
            java.lang.Object r3 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r3 = (kotlinx.coroutines.channels.ProducerScope) r3
            boolean r4 = r9 instanceof kotlin.Result.Failure
            if (r4 != 0) goto L_0x008c
            r4 = r1
            r5 = r3
            r1 = r9
            r3 = r2
            r2 = r0
            r0 = r8
            goto L_0x0113
        L_0x008c:
            r0 = r9
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0092:
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r2 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            boolean r3 = r9 instanceof kotlin.Result.Failure
            if (r3 != 0) goto L_0x00a4
            r4 = r9
            r3 = r1
            r9 = r8
            r1 = r0
            r0 = r4
            goto L_0x00fa
        L_0x00a4:
            r0 = r9
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x00aa:
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r2 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            boolean r3 = r9 instanceof kotlin.Result.Failure
            if (r3 != 0) goto L_0x00bd
            r4 = r9
            r3 = r2
            r9 = r8
            r2 = r1
            r1 = r0
            r0 = r4
            goto L_0x00e1
        L_0x00bd:
            r0 = r9
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x00c3:
            boolean r1 = r9 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x0181
            kotlinx.coroutines.channels.ProducerScope r1 = r8.p$
            kotlinx.coroutines.channels.ReceiveChannel r2 = r8.$this_dropWhile
            kotlinx.coroutines.channels.ChannelIterator r2 = r2.iterator()
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
        L_0x00d3:
            r9.L$0 = r3
            r9.L$1 = r2
            r4 = 1
            r9.label = r4
            java.lang.Object r4 = r2.hasNext(r9)
            if (r4 != r1) goto L_0x00e1
            return r1
        L_0x00e1:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0137
            r9.L$0 = r3
            r9.L$1 = r2
            r4 = 2
            r9.label = r4
            java.lang.Object r4 = r2.next(r9)
            if (r4 != r1) goto L_0x00f7
            return r1
        L_0x00f7:
            r7 = r3
            r3 = r2
            r2 = r7
        L_0x00fa:
            kotlin.jvm.functions.Function2 r5 = r9.$predicate
            r9.L$0 = r2
            r9.L$1 = r4
            r9.L$2 = r3
            r6 = 3
            r9.label = r6
            java.lang.Object r5 = r5.invoke(r4, r9)
            if (r5 != r1) goto L_0x010d
            return r1
        L_0x010d:
            r7 = r0
            r0 = r9
            r9 = r5
            r5 = r2
            r2 = r1
            r1 = r7
        L_0x0113:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0131
            r0.L$0 = r5
            r0.L$1 = r4
            r9 = 4
            r0.label = r9
            java.lang.Object r9 = r5.send(r4, r0)
            if (r9 != r2) goto L_0x0129
            return r2
        L_0x0129:
            r9 = r1
            r1 = r4
        L_0x012b:
            r1 = r2
            r3 = r5
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x0137
        L_0x0131:
            r9 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r5
            goto L_0x00d3
        L_0x0137:
            kotlinx.coroutines.channels.ReceiveChannel r2 = r9.$this_dropWhile
            kotlinx.coroutines.channels.ChannelIterator r2 = r2.iterator()
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x0140:
            r9.L$0 = r3
            r9.L$1 = r2
            r4 = 5
            r9.label = r4
            java.lang.Object r4 = r2.hasNext(r9)
            if (r4 != r0) goto L_0x014e
            return r0
        L_0x014e:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x017e
            r9.L$0 = r3
            r9.L$1 = r2
            r4 = 6
            r9.label = r4
            java.lang.Object r4 = r2.next(r9)
            if (r4 != r0) goto L_0x0164
            return r0
        L_0x0164:
            r9.L$0 = r3
            r9.L$1 = r4
            r9.L$2 = r2
            r5 = 7
            r9.label = r5
            java.lang.Object r5 = r3.send(r4, r9)
            if (r5 != r0) goto L_0x0175
            return r0
        L_0x0175:
            r7 = r2
            r2 = r1
            r1 = r4
            r4 = r3
            r3 = r7
        L_0x017a:
            r1 = r2
            r2 = r3
            r3 = r4
            goto L_0x0140
        L_0x017e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0181:
            r0 = r9
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$dropWhile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
