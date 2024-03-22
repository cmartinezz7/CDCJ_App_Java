package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1", f = "Channels.common.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {1900, 1900, 1199, 1199}, m = "invokeSuspend", n = {"$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "e$iv", "it", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "e$iv", "it"}, s = {"L$1", "L$3", "L$4", "L$5", "L$1", "L$3", "L$4", "L$5", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$map$1 extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_map;
    final /* synthetic */ Function2 $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$map$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_map = receiveChannel;
        this.$transform = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$map$1 channelsKt__Channels_commonKt$map$1 = new ChannelsKt__Channels_commonKt$map$1(this.$this_map, this.$transform, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        channelsKt__Channels_commonKt$map$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$map$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$map$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 21 */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0194 A[Catch:{ all -> 0x021f }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r3 == 0) goto L_0x0143
            r9 = 0
            if (r3 == r7) goto L_0x00ff
            if (r3 == r6) goto L_0x00c0
            if (r3 == r5) goto L_0x0065
            if (r3 != r4) goto L_0x005d
            r3 = r8
            r10 = r9
            r11 = r8
            r12 = r8
            r13 = r8
            r14 = r8
            r15 = r9
            r16 = r9
            java.lang.Object r12 = r1.L$8
            java.lang.Object r11 = r1.L$7
            java.lang.Object r4 = r1.L$6
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r1.L$5
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r14 = r1.L$4
            r13 = r14
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            java.lang.Object r14 = r1.L$3
            r3 = r14
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            java.lang.Object r14 = r1.L$2
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1 r14 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1) r14
            java.lang.Object r6 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r8 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            boolean r7 = r2 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x013e }
            if (r7 != 0) goto L_0x0057
            r7 = r6
            r6 = r15
            r15 = r12
            r12 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r14
            r14 = r11
            r11 = 4
            goto L_0x020b
        L_0x0057:
            r0 = r2
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0     // Catch:{ all -> 0x013e }
            java.lang.Throwable r0 = r0.exception     // Catch:{ all -> 0x013e }
            throw r0     // Catch:{ all -> 0x013e }
        L_0x005d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r3)
            throw r0
        L_0x0065:
            r3 = r8
            r4 = r9
            r5 = r8
            r6 = r8
            r7 = r8
            r10 = r8
            r11 = r9
            r16 = r9
            java.lang.Object r12 = r1.L$9
            kotlinx.coroutines.channels.ProducerScope r12 = (kotlinx.coroutines.channels.ProducerScope) r12
            java.lang.Object r6 = r1.L$8
            java.lang.Object r5 = r1.L$7
            java.lang.Object r13 = r1.L$6
            kotlinx.coroutines.channels.ChannelIterator r13 = (kotlinx.coroutines.channels.ChannelIterator) r13
            java.lang.Object r14 = r1.L$5
            r10 = r14
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r14 = r1.L$4
            r7 = r14
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r14 = r1.L$3
            r3 = r14
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            java.lang.Object r14 = r1.L$2
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1 r14 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1) r14
            java.lang.Object r15 = r1.L$1
            r8 = r15
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r15 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r15 = (kotlinx.coroutines.channels.ProducerScope) r15
            r19 = r0
            boolean r0 = r2 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x00b9 }
            if (r0 != 0) goto L_0x00b3
            r18 = r4
            r4 = r13
            r17 = r16
            r0 = r19
            r13 = r7
            r16 = r11
            r7 = r14
            r11 = 3
            r14 = r5
            r5 = r3
            r3 = r2
            r20 = r15
            r15 = r6
            r6 = r8
            r8 = r20
            goto L_0x01e1
        L_0x00b3:
            r0 = r2
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0     // Catch:{ all -> 0x00b9 }
            java.lang.Throwable r0 = r0.exception     // Catch:{ all -> 0x00b9 }
            throw r0     // Catch:{ all -> 0x00b9 }
        L_0x00b9:
            r0 = move-exception
            r5 = r3
            r13 = r7
            r6 = r8
            r3 = r2
            goto L_0x0228
        L_0x00c0:
            r19 = r0
            r0 = r8
            r3 = r8
            r4 = r8
            r5 = r9
            r6 = r8
            r16 = r9
            java.lang.Object r7 = r1.L$6
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r1.L$5
            r4 = r8
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r8 = r1.L$4
            r13 = r8
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            java.lang.Object r3 = r1.L$3
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            java.lang.Object r0 = r1.L$2
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1) r0
            java.lang.Object r8 = r1.L$1
            r6 = r8
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r8 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            boolean r10 = r2 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x013e }
            if (r10 != 0) goto L_0x00f9
            r10 = r0
            r14 = r2
            r12 = r9
            r0 = r19
            r11 = 1
            r9 = r7
            r7 = r5
            r2 = 2
            r5 = r3
            r3 = r14
            goto L_0x01b4
        L_0x00f9:
            r0 = r2
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0     // Catch:{ all -> 0x013e }
            java.lang.Throwable r0 = r0.exception     // Catch:{ all -> 0x013e }
        L_0x00fe:
            throw r0     // Catch:{ all -> 0x013e }
        L_0x00ff:
            r19 = r0
            r0 = r8
            r3 = r8
            r4 = r8
            r5 = r9
            r6 = r8
            r16 = r9
            java.lang.Object r7 = r1.L$6
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r1.L$5
            r4 = r8
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r8 = r1.L$4
            r13 = r8
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            java.lang.Object r3 = r1.L$3
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            java.lang.Object r0 = r1.L$2
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1) r0
            java.lang.Object r8 = r1.L$1
            r6 = r8
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r8 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            boolean r10 = r2 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x013e }
            if (r10 != 0) goto L_0x0138
            r10 = r8
            r12 = r9
            r11 = 1
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r19
            r5 = r3
            r3 = r2
            goto L_0x018c
        L_0x0138:
            r0 = r2
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0     // Catch:{ all -> 0x013e }
            java.lang.Throwable r0 = r0.exception     // Catch:{ all -> 0x013e }
            goto L_0x00fe
        L_0x013e:
            r0 = move-exception
            r5 = r3
            r3 = r2
            goto L_0x0228
        L_0x0143:
            r19 = r0
            boolean r0 = r2 instanceof kotlin.Result.Failure
            if (r0 != 0) goto L_0x0232
            kotlinx.coroutines.channels.ProducerScope r0 = r1.p$
            kotlinx.coroutines.channels.ReceiveChannel r6 = r1.$this_map
            r9 = 0
            r3 = r6
            r16 = 0
            r13 = r8
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            r4 = r3
            r5 = 0
            kotlinx.coroutines.channels.ChannelIterator r7 = r4.iterator()     // Catch:{ all -> 0x013e }
            r8 = r7
            r10 = r9
            r9 = r0
            r7 = r6
            r0 = r19
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
        L_0x0166:
            r2.L$0 = r9     // Catch:{ all -> 0x0223 }
            r2.L$1 = r7     // Catch:{ all -> 0x0223 }
            r2.L$2 = r1     // Catch:{ all -> 0x0223 }
            r2.L$3 = r4     // Catch:{ all -> 0x0223 }
            r2.L$4 = r13     // Catch:{ all -> 0x0223 }
            r2.L$5 = r5     // Catch:{ all -> 0x0223 }
            r2.L$6 = r8     // Catch:{ all -> 0x0223 }
            r11 = 1
            r2.label = r11     // Catch:{ all -> 0x0223 }
            java.lang.Object r12 = r8.hasNext(r1)     // Catch:{ all -> 0x0223 }
            if (r12 != r0) goto L_0x017e
            return r0
        L_0x017e:
            r20 = r4
            r4 = r0
            r0 = r1
            r1 = r2
            r2 = r12
            r12 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r20
        L_0x018c:
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x021f }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x021f }
            if (r2 == 0) goto L_0x0215
            r1.L$0 = r10     // Catch:{ all -> 0x021f }
            r1.L$1 = r8     // Catch:{ all -> 0x021f }
            r1.L$2 = r0     // Catch:{ all -> 0x021f }
            r1.L$3 = r5     // Catch:{ all -> 0x021f }
            r1.L$4 = r13     // Catch:{ all -> 0x021f }
            r1.L$5 = r6     // Catch:{ all -> 0x021f }
            r1.L$6 = r9     // Catch:{ all -> 0x021f }
            r2 = 2
            r1.label = r2     // Catch:{ all -> 0x021f }
            java.lang.Object r14 = r9.next(r0)     // Catch:{ all -> 0x021f }
            if (r14 != r4) goto L_0x01ac
            return r4
        L_0x01ac:
            r20 = r10
            r10 = r0
            r0 = r4
            r4 = r6
            r6 = r8
            r8 = r20
        L_0x01b4:
            r15 = r14
            r18 = 0
            kotlin.jvm.functions.Function2 r2 = r1.$transform     // Catch:{ all -> 0x0212 }
            r1.L$0 = r8     // Catch:{ all -> 0x0212 }
            r1.L$1 = r6     // Catch:{ all -> 0x0212 }
            r1.L$2 = r10     // Catch:{ all -> 0x0212 }
            r1.L$3 = r5     // Catch:{ all -> 0x0212 }
            r1.L$4 = r13     // Catch:{ all -> 0x0212 }
            r1.L$5 = r4     // Catch:{ all -> 0x0212 }
            r1.L$6 = r9     // Catch:{ all -> 0x0212 }
            r1.L$7 = r14     // Catch:{ all -> 0x0212 }
            r1.L$8 = r15     // Catch:{ all -> 0x0212 }
            r1.L$9 = r8     // Catch:{ all -> 0x0212 }
            r11 = 3
            r1.label = r11     // Catch:{ all -> 0x0212 }
            java.lang.Object r2 = r2.invoke(r15, r1)     // Catch:{ all -> 0x0212 }
            if (r2 != r0) goto L_0x01d8
            return r0
        L_0x01d8:
            r17 = r16
            r16 = r7
            r7 = r10
            r10 = r4
            r4 = r9
            r9 = r12
            r12 = r8
        L_0x01e1:
            r1.L$0 = r8     // Catch:{ all -> 0x020e }
            r1.L$1 = r6     // Catch:{ all -> 0x020e }
            r1.L$2 = r7     // Catch:{ all -> 0x020e }
            r1.L$3 = r5     // Catch:{ all -> 0x020e }
            r1.L$4 = r13     // Catch:{ all -> 0x020e }
            r1.L$5 = r10     // Catch:{ all -> 0x020e }
            r1.L$6 = r4     // Catch:{ all -> 0x020e }
            r1.L$7 = r14     // Catch:{ all -> 0x020e }
            r1.L$8 = r15     // Catch:{ all -> 0x020e }
            r11 = 4
            r1.label = r11     // Catch:{ all -> 0x020e }
            java.lang.Object r2 = r12.send(r2, r1)     // Catch:{ all -> 0x020e }
            if (r2 != r0) goto L_0x01fd
            return r0
        L_0x01fd:
            r2 = r1
            r1 = r7
            r12 = r9
            r7 = r6
            r9 = r8
            r6 = r16
            r16 = r17
            r8 = r4
            r4 = r5
            r5 = r10
            r10 = r18
        L_0x020b:
            r10 = r12
            goto L_0x0166
        L_0x020e:
            r0 = move-exception
            r16 = r17
            goto L_0x0228
        L_0x0212:
            r0 = move-exception
            r9 = r12
            goto L_0x0228
        L_0x0215:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x021f }
            r5.cancel(r13)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x021f:
            r0 = move-exception
            r6 = r8
            r9 = r12
            goto L_0x0228
        L_0x0223:
            r0 = move-exception
            r1 = r2
            r5 = r4
            r6 = r7
            r9 = r10
        L_0x0228:
            r2 = r0
            throw r0     // Catch:{ all -> 0x022b }
        L_0x022b:
            r0 = move-exception
            r4 = r0
            r5.cancel(r2)
            throw r4
        L_0x0232:
            r0 = r2
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
