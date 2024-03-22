package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "K", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$distinctBy$1", f = "Channels.common.kt", i = {0, 1, 2, 2, 3, 3, 3}, l = {1461, 1461, 1462, 1464}, m = "invokeSuspend", n = {"keys", "keys", "keys", "e", "keys", "e", "k"}, s = {"L$1", "L$1", "L$1", "L$2", "L$1", "L$2", "L$4"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$distinctBy$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $selector;
    final /* synthetic */ ReceiveChannel $this_distinctBy;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$distinctBy$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_distinctBy = receiveChannel;
        this.$selector = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$distinctBy$1 channelsKt__Channels_commonKt$distinctBy$1 = new ChannelsKt__Channels_commonKt$distinctBy$1(this.$this_distinctBy, this.$selector, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        channelsKt__Channels_commonKt$distinctBy$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$distinctBy$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$distinctBy$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 13 */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: java.util.HashSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: java.util.HashSet} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0114 A[RETURN] */
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
            if (r1 == 0) goto L_0x00a2
            r6 = 0
            if (r1 == r5) goto L_0x0083
            if (r1 == r4) goto L_0x0063
            if (r1 == r3) goto L_0x0040
            if (r1 != r2) goto L_0x0038
            r1 = r6
            r7 = r6
            java.lang.Object r1 = r13.L$4
            java.lang.Object r8 = r13.L$3
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r7 = r13.L$2
            java.lang.Object r9 = r13.L$1
            r6 = r9
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r9 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            boolean r10 = r14 instanceof kotlin.Result.Failure
            if (r10 != 0) goto L_0x0032
            r10 = r1
            r1 = r0
            r0 = r14
            r14 = r13
            goto L_0x0115
        L_0x0032:
            r0 = r14
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            r1 = r6
            java.lang.Object r7 = r13.L$3
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r1 = r13.L$2
            java.lang.Object r8 = r13.L$1
            r6 = r8
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r8 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            boolean r9 = r14 instanceof kotlin.Result.Failure
            if (r9 != 0) goto L_0x005d
            r10 = r14
            r9 = r8
            r14 = r13
            r8 = r7
            r7 = r1
            r1 = r0
            r0 = r10
            goto L_0x00fb
        L_0x005d:
            r0 = r14
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0063:
            r1 = r6
            java.lang.Object r6 = r13.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r13.L$1
            r1 = r7
            java.util.HashSet r1 = (java.util.HashSet) r1
            java.lang.Object r7 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r14 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x007d
            r9 = r14
            r8 = r7
            r14 = r13
            r7 = r1
            r1 = r0
            r0 = r9
            goto L_0x00e2
        L_0x007d:
            r0 = r14
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0083:
            r1 = r6
            java.lang.Object r6 = r13.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r13.L$1
            r1 = r7
            java.util.HashSet r1 = (java.util.HashSet) r1
            java.lang.Object r7 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            boolean r8 = r14 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L_0x009c
            r9 = r14
            r8 = r7
            r14 = r13
            r7 = r1
            r1 = r0
            r0 = r9
            goto L_0x00cb
        L_0x009c:
            r0 = r14
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x00a2:
            boolean r1 = r14 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x0124
            kotlinx.coroutines.channels.ProducerScope r1 = r13.p$
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            kotlinx.coroutines.channels.ReceiveChannel r7 = r13.$this_distinctBy
            kotlinx.coroutines.channels.ChannelIterator r7 = r7.iterator()
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r14
            r14 = r13
        L_0x00b9:
            r14.L$0 = r6
            r14.L$1 = r7
            r14.L$2 = r8
            r14.label = r5
            java.lang.Object r9 = r8.hasNext(r14)
            if (r9 != r1) goto L_0x00c8
            return r1
        L_0x00c8:
            r12 = r8
            r8 = r6
            r6 = r12
        L_0x00cb:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0121
            r14.L$0 = r8
            r14.L$1 = r7
            r14.L$2 = r6
            r14.label = r4
            java.lang.Object r9 = r6.next(r14)
            if (r9 != r1) goto L_0x00e2
            return r1
        L_0x00e2:
            kotlin.jvm.functions.Function2 r10 = r14.$selector
            r14.L$0 = r8
            r14.L$1 = r7
            r14.L$2 = r9
            r14.L$3 = r6
            r14.label = r3
            java.lang.Object r10 = r10.invoke(r9, r14)
            if (r10 != r1) goto L_0x00f6
            return r1
        L_0x00f6:
            r12 = r8
            r8 = r6
            r6 = r7
            r7 = r9
            r9 = r12
        L_0x00fb:
            boolean r11 = r6.contains(r10)
            if (r11 != 0) goto L_0x011e
            r14.L$0 = r9
            r14.L$1 = r6
            r14.L$2 = r7
            r14.L$3 = r8
            r14.L$4 = r10
            r14.label = r2
            java.lang.Object r11 = r9.send(r7, r14)
            if (r11 != r1) goto L_0x0115
            return r1
        L_0x0115:
            r11 = r6
            java.util.Collection r11 = (java.util.Collection) r11
            r11.add(r10)
            r7 = r6
            r6 = r9
            goto L_0x0120
        L_0x011e:
            r7 = r6
            r6 = r9
        L_0x0120:
            goto L_0x00b9
        L_0x0121:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0124:
            r0 = r14
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$distinctBy$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
