package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: TickerChannels.kt */
public final class TickerChannelsKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TickerMode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
            iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
        }
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }

    public static final ReceiveChannel<Unit> ticker(long delayMillis, long initialDelayMillis, CoroutineContext context, TickerMode mode) {
        long j = delayMillis;
        long j2 = initialDelayMillis;
        CoroutineContext coroutineContext = context;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        boolean z = true;
        if (j >= 0) {
            if (j2 < 0) {
                z = false;
            }
            if (z) {
                return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new TickerChannelsKt$ticker$3(mode, delayMillis, initialDelayMillis, (Continuation) null));
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0120 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ java.lang.Object fixedPeriodTicker(long r27, long r29, kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r31, kotlin.coroutines.Continuation<? super kotlin.Unit> r32) {
        /*
            r0 = r29
            r2 = r32
            boolean r3 = r2 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 r3 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 r3 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1
            r3.<init>(r2)
        L_0x001d:
            r2 = r3
            java.lang.Object r3 = r2.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r2.label
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            r10 = 0
            if (r5 == 0) goto L_0x00df
            if (r5 == r9) goto L_0x00c4
            if (r5 == r8) goto L_0x00a0
            if (r5 == r7) goto L_0x0069
            if (r5 != r6) goto L_0x0061
            r12 = r10
            r5 = r31
            r14 = r10
            r16 = r10
            r18 = r10
            long r14 = r2.J$5
            long r6 = r2.J$4
            long r8 = r2.J$3
            long r12 = r2.J$2
            java.lang.Object r10 = r2.L$0
            r5 = r10
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            long r0 = r2.J$1
            long r10 = r2.J$0
            r29 = r0
            boolean r0 = r3 instanceof kotlin.Result.Failure
            if (r0 != 0) goto L_0x005c
            r23 = r14
            r0 = 4
            r15 = r29
            goto L_0x01b0
        L_0x005c:
            kotlin.Result$Failure r3 = (kotlin.Result.Failure) r3
            java.lang.Throwable r0 = r3.exception
            throw r0
        L_0x0061:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r3)
            throw r2
        L_0x0069:
            r5 = 0
            r7 = r5
            r9 = r31
            r10 = r5
            r12 = r5
            r14 = r5
            r21 = r5
            long r5 = r2.J$6
            long r10 = r2.J$5
            long r12 = r2.J$4
            long r14 = r2.J$3
            long r7 = r2.J$2
            r21 = r5
            java.lang.Object r5 = r2.L$0
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            long r0 = r2.J$1
            r29 = r0
            long r0 = r2.J$0
            boolean r6 = r3 instanceof kotlin.Result.Failure
            if (r6 != 0) goto L_0x009b
            r8 = r7
            r19 = r14
            r14 = r4
            r7 = r5
            r15 = r12
            r5 = r21
            r12 = 3
            r4 = r2
            r2 = r29
            goto L_0x017a
        L_0x009b:
            kotlin.Result$Failure r3 = (kotlin.Result.Failure) r3
            java.lang.Throwable r3 = r3.exception
            throw r3
        L_0x00a0:
            r5 = 0
            r7 = r5
            r9 = r31
            r10 = r5
            long r5 = r2.J$3
            long r7 = r2.J$2
            java.lang.Object r10 = r2.L$0
            r9 = r10
            kotlinx.coroutines.channels.SendChannel r9 = (kotlinx.coroutines.channels.SendChannel) r9
            long r0 = r2.J$1
            long r10 = r2.J$0
            boolean r12 = r3 instanceof kotlin.Result.Failure
            if (r12 != 0) goto L_0x00bf
            r12 = 2
            r25 = r5
            r5 = r9
            r6 = r7
            r8 = r25
            goto L_0x0121
        L_0x00bf:
            kotlin.Result$Failure r3 = (kotlin.Result.Failure) r3
            java.lang.Throwable r3 = r3.exception
            throw r3
        L_0x00c4:
            r5 = 0
            r7 = r5
            r5 = r31
            long r6 = r2.J$2
            java.lang.Object r8 = r2.L$0
            r5 = r8
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            long r0 = r2.J$1
            long r8 = r2.J$0
            boolean r10 = r3 instanceof kotlin.Result.Failure
            if (r10 != 0) goto L_0x00da
            r10 = r8
            goto L_0x0105
        L_0x00da:
            kotlin.Result$Failure r3 = (kotlin.Result.Failure) r3
            java.lang.Throwable r3 = r3.exception
            throw r3
        L_0x00df:
            boolean r5 = r3 instanceof kotlin.Result.Failure
            if (r5 != 0) goto L_0x01b4
            r5 = r31
            kotlinx.coroutines.TimeSource r3 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            long r6 = r3.nanoTime()
            long r10 = kotlinx.coroutines.EventLoopKt.delayToNanos(r29)
            long r6 = r6 + r10
            r10 = r27
            r2.J$0 = r10
            r2.J$1 = r0
            r2.L$0 = r5
            r2.J$2 = r6
            r2.label = r9
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r0, r2)
            if (r3 != r4) goto L_0x0105
            return r4
        L_0x0105:
            long r8 = kotlinx.coroutines.EventLoopKt.delayToNanos(r10)
        L_0x0109:
            long r6 = r6 + r8
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r2.J$0 = r10
            r2.J$1 = r0
            r2.L$0 = r5
            r2.J$2 = r6
            r2.J$3 = r8
            r12 = 2
            r2.label = r12
            java.lang.Object r3 = r5.send(r3, r2)
            if (r3 != r4) goto L_0x0121
            return r4
        L_0x0121:
            kotlinx.coroutines.TimeSource r3 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            long r13 = r3.nanoTime()
            r15 = r4
            long r3 = r6 - r13
            r27 = r13
            r12 = 0
            long r3 = kotlin.ranges.RangesKt.coerceAtLeast((long) r3, (long) r12)
            int r14 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x0184
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x0184
            long r16 = r27 - r6
            long r16 = r16 % r8
            long r12 = r8 - r16
            long r6 = r27 + r12
            r29 = r15
            long r14 = kotlinx.coroutines.EventLoopKt.delayNanosToMillis(r12)
            r2.J$0 = r10
            r2.J$1 = r0
            r2.L$0 = r5
            r2.J$2 = r6
            r2.J$3 = r8
            r30 = r8
            r8 = r27
            r2.J$4 = r8
            r2.J$5 = r3
            r2.J$6 = r12
            r27 = r12
            r12 = 3
            r2.label = r12
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r14, r2)
            r14 = r29
            if (r13 != r14) goto L_0x016c
            return r14
        L_0x016c:
            r19 = r30
            r15 = r8
            r8 = r6
            r7 = r5
            r5 = r27
            r25 = r3
            r4 = r2
            r2 = r0
            r0 = r10
            r10 = r25
        L_0x017a:
            r10 = r0
            r15 = r2
            r2 = r4
            r5 = r7
            r6 = r8
            r4 = r14
            r8 = r19
            r0 = 4
            goto L_0x01b1
        L_0x0184:
            r30 = r8
            r14 = r15
            r12 = 3
            r8 = r27
            long r12 = kotlinx.coroutines.EventLoopKt.delayNanosToMillis(r3)
            r2.J$0 = r10
            r2.J$1 = r0
            r2.L$0 = r5
            r2.J$2 = r6
            r15 = r0
            r0 = r30
            r2.J$3 = r0
            r2.J$4 = r8
            r2.J$5 = r3
            r0 = 4
            r2.label = r0
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r12, r2)
            if (r1 != r14) goto L_0x01a9
            return r14
        L_0x01a9:
            r23 = r3
            r12 = r6
            r6 = r8
            r4 = r14
            r8 = r30
        L_0x01b0:
            r6 = r12
        L_0x01b1:
            r0 = r15
            goto L_0x0109
        L_0x01b4:
            r10 = r27
            kotlin.Result$Failure r3 = (kotlin.Result.Failure) r3
            java.lang.Throwable r0 = r3.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.fixedPeriodTicker(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit>} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1 A[RETURN] */
    static final /* synthetic */ java.lang.Object fixedDelayTicker(long r6, long r8, kotlinx.coroutines.channels.SendChannel r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            r0.<init>(r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x006e
            if (r2 == r5) goto L_0x005b
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r2 = r11.L$0
            r10 = r2
            kotlinx.coroutines.channels.SendChannel r10 = (kotlinx.coroutines.channels.SendChannel) r10
            long r8 = r11.J$1
            long r6 = r11.J$0
            boolean r2 = r0 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x003b
            goto L_0x0081
        L_0x003b:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0040:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0048:
            java.lang.Object r2 = r11.L$0
            r10 = r2
            kotlinx.coroutines.channels.SendChannel r10 = (kotlinx.coroutines.channels.SendChannel) r10
            long r8 = r11.J$1
            long r6 = r11.J$0
            boolean r2 = r0 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x0056
            goto L_0x0093
        L_0x0056:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x005b:
            java.lang.Object r2 = r11.L$0
            r10 = r2
            kotlinx.coroutines.channels.SendChannel r10 = (kotlinx.coroutines.channels.SendChannel) r10
            long r8 = r11.J$1
            long r6 = r11.J$0
            boolean r2 = r0 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x0069
            goto L_0x0081
        L_0x0069:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x006e:
            boolean r2 = r0 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x00a2
            r11.J$0 = r6
            r11.J$1 = r8
            r11.L$0 = r10
            r11.label = r5
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r8, r11)
            if (r0 != r1) goto L_0x0081
            return r1
        L_0x0081:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r11.J$0 = r6
            r11.J$1 = r8
            r11.L$0 = r10
            r11.label = r4
            java.lang.Object r0 = r10.send(r0, r11)
            if (r0 != r1) goto L_0x0093
            return r1
        L_0x0093:
            r11.J$0 = r6
            r11.J$1 = r8
            r11.L$0 = r10
            r11.label = r3
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r6, r11)
            if (r0 != r1) goto L_0x0081
            return r1
        L_0x00a2:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r10 = r0.exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.fixedDelayTicker(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
