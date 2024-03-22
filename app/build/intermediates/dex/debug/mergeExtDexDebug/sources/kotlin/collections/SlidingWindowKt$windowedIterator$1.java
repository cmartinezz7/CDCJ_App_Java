package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SlidingWindow.kt */
final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.$size = i;
        this.$step = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.L$0 = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SlidingWindowKt$windowedIterator$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x016b A[SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r18
            int r2 = r1.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0075
            if (r2 == r7) goto L_0x005d
            if (r2 == r6) goto L_0x0054
            if (r2 == r5) goto L_0x003f
            if (r2 == r4) goto L_0x002b
            if (r2 != r3) goto L_0x0023
            r0 = r18
            r1 = r19
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x01bd
        L_0x0023:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002b:
            r1 = r18
            r2 = r19
            java.lang.Object r5 = r1.L$1
            kotlin.collections.RingBuffer r5 = (kotlin.collections.RingBuffer) r5
            java.lang.Object r6 = r1.L$0
            kotlin.sequences.SequenceScope r6 = (kotlin.sequences.SequenceScope) r6
            kotlin.ResultKt.throwOnFailure(r2)
            r15 = r1
            r1 = r0
            r0 = r15
            goto L_0x019d
        L_0x003f:
            r1 = r18
            r2 = r19
            java.lang.Object r6 = r1.L$2
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r9 = r1.L$1
            kotlin.collections.RingBuffer r9 = (kotlin.collections.RingBuffer) r9
            java.lang.Object r10 = r1.L$0
            kotlin.sequences.SequenceScope r10 = (kotlin.sequences.SequenceScope) r10
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0164
        L_0x0054:
            r0 = r18
            r1 = r19
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0115
        L_0x005d:
            r1 = r18
            r2 = r19
            int r3 = r1.I$0
            java.lang.Object r4 = r1.L$2
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r1.L$1
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r9 = r1.L$0
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.ResultKt.throwOnFailure(r2)
            r10 = 0
            goto L_0x00d7
        L_0x0075:
            kotlin.ResultKt.throwOnFailure(r19)
            r1 = r18
            r2 = r19
            java.lang.Object r9 = r1.L$0
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            int r10 = r1.$size
            r11 = 1024(0x400, float:1.435E-42)
            int r10 = kotlin.ranges.RangesKt.coerceAtMost((int) r10, (int) r11)
            int r11 = r1.$step
            int r12 = r1.$size
            int r11 = r11 - r12
            if (r11 < 0) goto L_0x0118
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r10)
            r4 = 0
            java.util.Iterator r5 = r1.$iterator
            r15 = r1
            r1 = r0
            r0 = r15
            r16 = r9
            r9 = r3
            r3 = r11
            r11 = r10
            r10 = r16
            r17 = r5
            r5 = r4
            r4 = r17
        L_0x00a6:
            boolean r12 = r4.hasNext()
            if (r12 == 0) goto L_0x00ef
            java.lang.Object r12 = r4.next()
            if (r5 <= 0) goto L_0x00b5
            int r5 = r5 + -1
            goto L_0x00ed
        L_0x00b5:
            r9.add(r12)
            int r13 = r9.size()
            int r14 = r0.$size
            if (r13 != r14) goto L_0x00ed
            r0.L$0 = r10
            r0.L$1 = r9
            r0.L$2 = r4
            r0.I$0 = r3
            r0.label = r7
            java.lang.Object r5 = r10.yield(r9, r0)
            if (r5 != r1) goto L_0x00d1
            return r1
        L_0x00d1:
            r5 = r9
            r9 = r10
            r10 = r11
            r15 = r1
            r1 = r0
            r0 = r15
        L_0x00d7:
            boolean r11 = r1.$reuseBuffer
            if (r11 == 0) goto L_0x00df
            r5.clear()
            goto L_0x00e6
        L_0x00df:
            java.util.ArrayList r5 = new java.util.ArrayList
            int r11 = r1.$size
            r5.<init>(r11)
        L_0x00e6:
            r11 = r10
            r10 = r9
            r9 = r5
            r5 = r3
            r15 = r1
            r1 = r0
            r0 = r15
        L_0x00ed:
            goto L_0x00a6
        L_0x00ef:
            r3 = r9
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r7
            if (r3 == 0) goto L_0x01c0
            boolean r3 = r0.$partialWindows
            if (r3 != 0) goto L_0x0105
            int r3 = r9.size()
            int r4 = r0.$size
            if (r3 != r4) goto L_0x01c0
        L_0x0105:
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r6
            java.lang.Object r3 = r10.yield(r9, r0)
            if (r3 != r1) goto L_0x0114
            return r1
        L_0x0114:
            r1 = r2
        L_0x0115:
            r2 = r1
            goto L_0x01c0
        L_0x0118:
            kotlin.collections.RingBuffer r6 = new kotlin.collections.RingBuffer
            r6.<init>(r10)
            java.util.Iterator r10 = r1.$iterator
            r15 = r9
            r9 = r6
            r6 = r10
            r10 = r15
        L_0x0123:
            boolean r11 = r6.hasNext()
            if (r11 == 0) goto L_0x016b
            java.lang.Object r11 = r6.next()
            r9.add(r11)
            boolean r12 = r9.isFull()
            if (r12 == 0) goto L_0x0169
            int r12 = r9.size()
            int r13 = r1.$size
            if (r12 >= r13) goto L_0x0143
            kotlin.collections.RingBuffer r9 = r9.expanded(r13)
            goto L_0x0169
        L_0x0143:
            boolean r12 = r1.$reuseBuffer
            if (r12 == 0) goto L_0x014b
            r12 = r9
            java.util.List r12 = (java.util.List) r12
            goto L_0x0155
        L_0x014b:
            java.util.ArrayList r12 = new java.util.ArrayList
            r13 = r9
            java.util.Collection r13 = (java.util.Collection) r13
            r12.<init>(r13)
            java.util.List r12 = (java.util.List) r12
        L_0x0155:
            r1.L$0 = r10
            r1.L$1 = r9
            r1.L$2 = r6
            r1.label = r5
            java.lang.Object r11 = r10.yield(r12, r1)
            if (r11 != r0) goto L_0x0164
            return r0
        L_0x0164:
            int r11 = r1.$step
            r9.removeFirst(r11)
        L_0x0169:
            goto L_0x0123
        L_0x016b:
            boolean r5 = r1.$partialWindows
            if (r5 == 0) goto L_0x01bf
            r5 = r9
            r6 = r10
            r15 = r1
            r1 = r0
            r0 = r15
        L_0x0174:
            int r9 = r5.size()
            int r10 = r0.$step
            if (r9 <= r10) goto L_0x01a3
            boolean r9 = r0.$reuseBuffer
            if (r9 == 0) goto L_0x0184
            r9 = r5
            java.util.List r9 = (java.util.List) r9
            goto L_0x018e
        L_0x0184:
            java.util.ArrayList r9 = new java.util.ArrayList
            r10 = r5
            java.util.Collection r10 = (java.util.Collection) r10
            r9.<init>(r10)
            java.util.List r9 = (java.util.List) r9
        L_0x018e:
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r9 = r6.yield(r9, r0)
            if (r9 != r1) goto L_0x019d
            return r1
        L_0x019d:
            int r9 = r0.$step
            r5.removeFirst(r9)
            goto L_0x0174
        L_0x01a3:
            r4 = r5
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r7
            if (r4 == 0) goto L_0x01c0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r3 = r6.yield(r5, r0)
            if (r3 != r1) goto L_0x01bc
            return r1
        L_0x01bc:
            r1 = r2
        L_0x01bd:
            r2 = r1
            goto L_0x01c0
        L_0x01bf:
            r0 = r1
        L_0x01c0:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
