package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "E", "R", "V", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {1900, 1900, 1888, 1889, 1890}, m = "invokeSuspend", n = {"otherIterator", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "otherIterator", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "otherIterator", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "e$iv", "element1", "otherIterator", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "e$iv", "element1", "otherIterator", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "e$iv", "element1", "element2"}, s = {"L$1", "L$2", "L$4", "L$5", "L$6", "L$1", "L$2", "L$4", "L$5", "L$6", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$zip$2 extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $other;
    final /* synthetic */ ReceiveChannel $this_zip;
    final /* synthetic */ Function2 $transform;
    Object L$0;
    Object L$1;
    Object L$10;
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
    ChannelsKt__Channels_commonKt$zip$2(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_zip = receiveChannel;
        this.$other = receiveChannel2;
        this.$transform = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$2 = new ChannelsKt__Channels_commonKt$zip$2(this.$this_zip, this.$other, this.$transform, continuation);
        ProducerScope producerScope = (ProducerScope) obj;
        channelsKt__Channels_commonKt$zip$2.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$zip$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$zip$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 25 */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: kotlinx.coroutines.channels.ChannelIterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v29, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: kotlinx.coroutines.channels.ChannelIterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v27, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v32, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v12, resolved type: kotlinx.coroutines.channels.ChannelIterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v65, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x020f A[Catch:{ all -> 0x0317 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r3 == 0) goto L_0x01b9
            r10 = 0
            if (r3 == r8) goto L_0x0172
            if (r3 == r7) goto L_0x012a
            if (r3 == r6) goto L_0x00d5
            if (r3 == r5) goto L_0x0081
            if (r3 != r4) goto L_0x0079
            r3 = r10
            r11 = r9
            r12 = r10
            r13 = r9
            r14 = r9
            r15 = r10
            r16 = r9
            r17 = r9
            r18 = r9
            r19 = r9
            java.lang.Object r9 = r1.L$10
            java.lang.Object r13 = r1.L$9
            java.lang.Object r14 = r1.L$8
            java.lang.Object r4 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r1.L$5
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r7 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r1.L$3
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2 r8 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2) r8
            r21 = r0
            java.lang.Object r0 = r1.L$2
            r11 = r0
            kotlinx.coroutines.channels.ReceiveChannel r11 = (kotlinx.coroutines.channels.ReceiveChannel) r11
            java.lang.Object r0 = r1.L$1
            r18 = r0
            kotlinx.coroutines.channels.ChannelIterator r18 = (kotlinx.coroutines.channels.ChannelIterator) r18
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r0 = (kotlinx.coroutines.channels.ProducerScope) r0
            r22 = r0
            boolean r0 = r2 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0070
            r16 = r12
            r20 = r15
            r0 = 5
            r12 = r4
            r15 = r14
            r4 = r21
            r14 = r13
            r21 = r18
            r13 = r11
            r11 = r10
            r10 = r5
            r5 = r3
            r3 = r22
            goto L_0x02e0
        L_0x0070:
            r0 = r2
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0     // Catch:{ all -> 0x0076 }
            java.lang.Throwable r0 = r0.exception     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r0 = move-exception
            goto L_0x0325
        L_0x0079:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r3)
            throw r0
        L_0x0081:
            r21 = r0
            r3 = r10
            r0 = r9
            r4 = r10
            r5 = r9
            r6 = r9
            r15 = r10
            r7 = r9
            r8 = r10
            r10 = r9
            r11 = r9
            java.lang.Object r5 = r1.L$9
            java.lang.Object r6 = r1.L$8
            java.lang.Object r12 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r12 = (kotlinx.coroutines.channels.ChannelIterator) r12
            java.lang.Object r13 = r1.L$6
            r10 = r13
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r13 = r1.L$5
            r7 = r13
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r13 = r1.L$4
            r9 = r13
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r13 = r1.L$3
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2 r13 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2) r13
            java.lang.Object r14 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r0 = r1.L$1
            r18 = r0
            kotlinx.coroutines.channels.ChannelIterator r18 = (kotlinx.coroutines.channels.ChannelIterator) r18
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r0 = (kotlinx.coroutines.channels.ProducerScope) r0
            boolean r11 = r2 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x0124 }
            if (r11 != 0) goto L_0x00cf
            r25 = r2
            r16 = r4
            r11 = r14
            r4 = r21
            r14 = r6
            r6 = r7
            r7 = r9
            r2 = r18
            r9 = r8
            r8 = r13
            r13 = r5
            r5 = r3
            r3 = r0
            r0 = r25
            goto L_0x02a8
        L_0x00cf:
            r0 = r2
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0     // Catch:{ all -> 0x0124 }
            java.lang.Throwable r0 = r0.exception     // Catch:{ all -> 0x0124 }
        L_0x00d4:
            throw r0     // Catch:{ all -> 0x0124 }
        L_0x00d5:
            r21 = r0
            r3 = r10
            r0 = r9
            r4 = r10
            r5 = r9
            r6 = r9
            r15 = r10
            r7 = r9
            r8 = r10
            r10 = r9
            r11 = r9
            java.lang.Object r5 = r1.L$9
            java.lang.Object r6 = r1.L$8
            java.lang.Object r12 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r12 = (kotlinx.coroutines.channels.ChannelIterator) r12
            java.lang.Object r13 = r1.L$6
            r10 = r13
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r13 = r1.L$5
            r7 = r13
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r13 = r1.L$4
            r9 = r13
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r13 = r1.L$3
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2 r13 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2) r13
            java.lang.Object r14 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r0 = r1.L$1
            r18 = r0
            kotlinx.coroutines.channels.ChannelIterator r18 = (kotlinx.coroutines.channels.ChannelIterator) r18
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r0 = (kotlinx.coroutines.channels.ProducerScope) r0
            boolean r11 = r2 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x0124 }
            if (r11 != 0) goto L_0x011e
            r25 = r2
            r16 = r4
            r11 = r14
            r4 = r21
            r14 = r5
            r2 = r18
            r5 = r3
            r3 = r0
            r0 = r25
            goto L_0x026b
        L_0x011e:
            r0 = r2
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0     // Catch:{ all -> 0x0124 }
            java.lang.Throwable r0 = r0.exception     // Catch:{ all -> 0x0124 }
            goto L_0x00d4
        L_0x0124:
            r0 = move-exception
            r6 = r7
            r7 = r9
            r11 = r14
            goto L_0x0325
        L_0x012a:
            r21 = r0
            r3 = r10
            r0 = r9
            r15 = r10
            r4 = r9
            r5 = r10
            r6 = r9
            r7 = r9
            r8 = r9
            java.lang.Object r9 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r1.L$6
            r6 = r10
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r10 = r1.L$5
            r4 = r10
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.Object r10 = r1.L$4
            r8 = r10
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r10 = r1.L$3
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2 r10 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2) r10
            java.lang.Object r11 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r11 = (kotlinx.coroutines.channels.ReceiveChannel) r11
            java.lang.Object r0 = r1.L$1
            r18 = r0
            kotlinx.coroutines.channels.ChannelIterator r18 = (kotlinx.coroutines.channels.ChannelIterator) r18
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r0 = (kotlinx.coroutines.channels.ProducerScope) r0
            boolean r7 = r2 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x01b4 }
            if (r7 != 0) goto L_0x016c
            r7 = r8
            r12 = r9
            r13 = r10
            r9 = r18
            r14 = 2
            r8 = r5
            r10 = r6
            r5 = r3
            r6 = r4
            r4 = r21
            r3 = r2
            goto L_0x0239
        L_0x016c:
            r0 = r2
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0     // Catch:{ all -> 0x01b4 }
            java.lang.Throwable r0 = r0.exception     // Catch:{ all -> 0x01b4 }
        L_0x0171:
            throw r0     // Catch:{ all -> 0x01b4 }
        L_0x0172:
            r21 = r0
            r3 = r10
            r0 = r9
            r15 = r10
            r4 = r9
            r5 = r10
            r6 = r9
            r7 = r9
            r8 = r9
            java.lang.Object r9 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r1.L$6
            r6 = r10
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r10 = r1.L$5
            r4 = r10
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.Object r10 = r1.L$4
            r8 = r10
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r10 = r1.L$3
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2 r10 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2) r10
            java.lang.Object r11 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r11 = (kotlinx.coroutines.channels.ReceiveChannel) r11
            java.lang.Object r0 = r1.L$1
            r18 = r0
            kotlinx.coroutines.channels.ChannelIterator r18 = (kotlinx.coroutines.channels.ChannelIterator) r18
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r0 = (kotlinx.coroutines.channels.ProducerScope) r0
            boolean r7 = r2 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x01b4 }
            if (r7 != 0) goto L_0x01ae
            r14 = r2
            r7 = r4
            r12 = r18
            r4 = r21
            r13 = 1
            goto L_0x0207
        L_0x01ae:
            r0 = r2
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0     // Catch:{ all -> 0x01b4 }
            java.lang.Throwable r0 = r0.exception     // Catch:{ all -> 0x01b4 }
            goto L_0x0171
        L_0x01b4:
            r0 = move-exception
            r6 = r4
            r7 = r8
            goto L_0x0325
        L_0x01b9:
            r21 = r0
            boolean r0 = r2 instanceof kotlin.Result.Failure
            if (r0 != 0) goto L_0x032f
            kotlinx.coroutines.channels.ProducerScope r0 = r1.p$
            kotlinx.coroutines.channels.ReceiveChannel r3 = r1.$other
            kotlinx.coroutines.channels.ChannelIterator r18 = r3.iterator()
            kotlinx.coroutines.channels.ReceiveChannel r11 = r1.$this_zip
            r3 = 0
            r7 = r11
            r15 = 0
            r6 = r9
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r4 = r7
            r5 = 0
            kotlinx.coroutines.channels.ChannelIterator r8 = r4.iterator()     // Catch:{ all -> 0x0076 }
            r9 = r7
            r10 = r8
            r12 = r18
            r8 = r4
            r7 = r6
            r4 = r21
            r6 = r5
            r5 = r3
            r3 = r2
            r2 = r1
        L_0x01e2:
            r2.L$0 = r0     // Catch:{ all -> 0x031d }
            r2.L$1 = r12     // Catch:{ all -> 0x031d }
            r2.L$2 = r11     // Catch:{ all -> 0x031d }
            r2.L$3 = r1     // Catch:{ all -> 0x031d }
            r2.L$4 = r9     // Catch:{ all -> 0x031d }
            r2.L$5 = r7     // Catch:{ all -> 0x031d }
            r2.L$6 = r8     // Catch:{ all -> 0x031d }
            r2.L$7 = r10     // Catch:{ all -> 0x031d }
            r13 = 1
            r2.label = r13     // Catch:{ all -> 0x031d }
            java.lang.Object r14 = r10.hasNext(r1)     // Catch:{ all -> 0x031d }
            if (r14 != r4) goto L_0x01fc
            return r4
        L_0x01fc:
            r23 = r10
            r10 = r1
            r1 = r2
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r8
            r8 = r9
            r9 = r23
        L_0x0207:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x0317 }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x0317 }
            if (r14 == 0) goto L_0x030d
            r1.L$0 = r0     // Catch:{ all -> 0x0317 }
            r1.L$1 = r12     // Catch:{ all -> 0x0317 }
            r1.L$2 = r11     // Catch:{ all -> 0x0317 }
            r1.L$3 = r10     // Catch:{ all -> 0x0317 }
            r1.L$4 = r8     // Catch:{ all -> 0x0317 }
            r1.L$5 = r7     // Catch:{ all -> 0x0317 }
            r1.L$6 = r6     // Catch:{ all -> 0x0317 }
            r1.L$7 = r9     // Catch:{ all -> 0x0317 }
            r14 = 2
            r1.label = r14     // Catch:{ all -> 0x0317 }
            java.lang.Object r13 = r9.next(r10)     // Catch:{ all -> 0x0317 }
            if (r13 != r4) goto L_0x0229
            return r4
        L_0x0229:
            r23 = r3
            r3 = r2
            r2 = r13
            r13 = r10
            r10 = r6
            r6 = r7
            r7 = r8
            r8 = r5
            r5 = r23
            r24 = r12
            r12 = r9
            r9 = r24
        L_0x0239:
            r25 = r2
            r16 = 0
            r1.L$0 = r0     // Catch:{ all -> 0x0307 }
            r1.L$1 = r9     // Catch:{ all -> 0x0307 }
            r1.L$2 = r11     // Catch:{ all -> 0x0307 }
            r1.L$3 = r13     // Catch:{ all -> 0x0307 }
            r1.L$4 = r7     // Catch:{ all -> 0x0307 }
            r1.L$5 = r6     // Catch:{ all -> 0x0307 }
            r1.L$6 = r10     // Catch:{ all -> 0x0307 }
            r1.L$7 = r12     // Catch:{ all -> 0x0307 }
            r1.L$8 = r2     // Catch:{ all -> 0x0307 }
            r14 = r25
            r1.L$9 = r14     // Catch:{ all -> 0x0307 }
            r21 = r0
            r0 = 3
            r1.label = r0     // Catch:{ all -> 0x0307 }
            java.lang.Object r0 = r9.hasNext(r1)     // Catch:{ all -> 0x0307 }
            if (r0 != r4) goto L_0x0260
            return r4
        L_0x0260:
            r25 = r3
            r3 = r21
            r23 = r6
            r6 = r2
            r2 = r9
            r9 = r7
            r7 = r23
        L_0x026b:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x02fe }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x02fe }
            if (r0 != 0) goto L_0x0281
            r21 = r2
            r20 = r15
            r0 = 5
            r2 = r1
            r15 = r6
            r1 = r13
            r6 = r5
            r5 = r4
            r4 = r25
            goto L_0x02e9
        L_0x0281:
            r1.L$0 = r3     // Catch:{ all -> 0x02fe }
            r1.L$1 = r2     // Catch:{ all -> 0x02fe }
            r1.L$2 = r11     // Catch:{ all -> 0x02fe }
            r1.L$3 = r13     // Catch:{ all -> 0x02fe }
            r1.L$4 = r9     // Catch:{ all -> 0x02fe }
            r1.L$5 = r7     // Catch:{ all -> 0x02fe }
            r1.L$6 = r10     // Catch:{ all -> 0x02fe }
            r1.L$7 = r12     // Catch:{ all -> 0x02fe }
            r1.L$8 = r6     // Catch:{ all -> 0x02fe }
            r1.L$9 = r14     // Catch:{ all -> 0x02fe }
            r0 = 4
            r1.label = r0     // Catch:{ all -> 0x02fe }
            java.lang.Object r0 = r2.next(r1)     // Catch:{ all -> 0x02fe }
            if (r0 != r4) goto L_0x029f
            return r4
        L_0x029f:
            r23 = r14
            r14 = r6
            r6 = r7
            r7 = r9
            r9 = r8
            r8 = r13
            r13 = r23
        L_0x02a8:
            r26 = r5
            kotlin.jvm.functions.Function2 r5 = r1.$transform     // Catch:{ all -> 0x02f6 }
            java.lang.Object r5 = r5.invoke(r13, r0)     // Catch:{ all -> 0x02f6 }
            r1.L$0 = r3     // Catch:{ all -> 0x02f6 }
            r1.L$1 = r2     // Catch:{ all -> 0x02f6 }
            r1.L$2 = r11     // Catch:{ all -> 0x02f6 }
            r1.L$3 = r8     // Catch:{ all -> 0x02f6 }
            r1.L$4 = r7     // Catch:{ all -> 0x02f6 }
            r1.L$5 = r6     // Catch:{ all -> 0x02f6 }
            r1.L$6 = r10     // Catch:{ all -> 0x02f6 }
            r1.L$7 = r12     // Catch:{ all -> 0x02f6 }
            r1.L$8 = r14     // Catch:{ all -> 0x02f6 }
            r1.L$9 = r13     // Catch:{ all -> 0x02f6 }
            r1.L$10 = r0     // Catch:{ all -> 0x02f6 }
            r21 = r0
            r0 = 5
            r1.label = r0     // Catch:{ all -> 0x02f6 }
            java.lang.Object r5 = r3.send(r5, r1)     // Catch:{ all -> 0x02f6 }
            if (r5 != r4) goto L_0x02d2
            return r4
        L_0x02d2:
            r5 = r26
            r20 = r15
            r15 = r14
            r14 = r13
            r13 = r11
            r11 = r9
            r9 = r21
            r21 = r2
            r2 = r25
        L_0x02e0:
            r9 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r2
            r2 = r1
            r1 = r8
            r8 = r11
            r11 = r13
        L_0x02e9:
            r0 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r8
            r8 = r10
            r10 = r12
            r15 = r20
            r12 = r21
            goto L_0x01e2
        L_0x02f6:
            r0 = move-exception
            r3 = r26
            r18 = r2
            r2 = r25
            goto L_0x0325
        L_0x02fe:
            r0 = move-exception
            r18 = r2
            r3 = r5
            r6 = r7
            r7 = r9
            r2 = r25
            goto L_0x0325
        L_0x0307:
            r0 = move-exception
            r2 = r3
            r3 = r5
            r18 = r9
            goto L_0x0325
        L_0x030d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0317 }
            r8.cancel(r7)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0317:
            r0 = move-exception
            r6 = r7
            r7 = r8
            r18 = r12
            goto L_0x0325
        L_0x031d:
            r0 = move-exception
            r1 = r2
            r2 = r3
            r3 = r5
            r6 = r7
            r7 = r9
            r18 = r12
        L_0x0325:
            r4 = r0
            throw r0     // Catch:{ all -> 0x0328 }
        L_0x0328:
            r0 = move-exception
            r5 = r0
            r7.cancel(r4)
            throw r5
        L_0x032f:
            r0 = r2
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
