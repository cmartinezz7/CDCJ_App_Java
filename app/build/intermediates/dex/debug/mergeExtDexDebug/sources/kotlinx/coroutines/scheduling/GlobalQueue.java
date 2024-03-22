package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeTaskQueue;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/scheduling/GlobalQueue;", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Lkotlinx/coroutines/scheduling/Task;", "()V", "removeFirstWithModeOrNull", "mode", "Lkotlinx/coroutines/scheduling/TaskMode;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: Tasks.kt */
public class GlobalQueue extends LockFreeTaskQueue<Task> {
    public GlobalQueue() {
        super(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e2, code lost:
        r8 = r28;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.scheduling.Task removeFirstWithModeOrNull(kotlinx.coroutines.scheduling.TaskMode r33) {
        /*
            r32 = this;
            r0 = r33
            java.lang.String r1 = "mode"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
            r1 = r32
            r2 = 0
            r3 = r1
            r4 = 0
        L_0x000c:
            java.lang.Object r5 = r3._cur$internal
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r5 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r5
            r12 = 0
            r7 = r5
            r13 = 0
            r14 = r7
            r15 = 0
        L_0x0016:
            long r10 = r14._state$internal
            r16 = 0
            r8 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r8 = r8 & r10
            r17 = 0
            int r6 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r6 == 0) goto L_0x002c
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.REMOVE_FROZEN
            r26 = r2
            r27 = r3
            goto L_0x00e4
        L_0x002c:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r6 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion
            r17 = r10
            r19 = r6
            r20 = 0
            r21 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r21 = r17 & r21
            r6 = 0
            long r8 = r21 >> r6
            int r8 = (int) r8
            r21 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r21 = r17 & r21
            r9 = 30
            r24 = r7
            long r6 = r21 >> r9
            int r9 = (int) r6
            r6 = r8
            r21 = r9
            r22 = 0
            r7 = r24
            int r24 = r7.mask
            r26 = r2
            r2 = r21 & r24
            int r24 = r7.mask
            r27 = r3
            r3 = r6 & r24
            if (r2 != r3) goto L_0x0067
            r8 = 0
            goto L_0x00e4
        L_0x0067:
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r7.array
            int r3 = r7.mask
            r3 = r3 & r6
            java.lang.Object r2 = r2.get(r3)
            if (r2 != 0) goto L_0x0080
            boolean r3 = r7.singleConsumer
            if (r3 == 0) goto L_0x007f
            r8 = 0
            goto L_0x00e4
        L_0x007f:
            goto L_0x00cf
        L_0x0080:
            boolean r3 = r2 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore.Placeholder
            if (r3 == 0) goto L_0x0087
            r8 = 0
            goto L_0x00e4
        L_0x0087:
            r3 = r2
            kotlinx.coroutines.scheduling.Task r3 = (kotlinx.coroutines.scheduling.Task) r3
            r24 = 0
            r28 = r2
            kotlinx.coroutines.scheduling.TaskMode r2 = r3.getMode()
            if (r2 != r0) goto L_0x0097
            r2 = 1
            goto L_0x0098
        L_0x0097:
            r2 = 0
        L_0x0098:
            if (r2 != 0) goto L_0x009c
            r8 = 0
            goto L_0x00e4
        L_0x009c:
            int r2 = r6 + 1
            r3 = 1073741823(0x3fffffff, float:1.9999999)
            r2 = r2 & r3
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = kotlinx.coroutines.internal.LockFreeTaskQueueCore._state$FU$internal
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r0 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion
            long r24 = r0.updateHead(r10, r2)
            r0 = r6
            r6 = r3
            r29 = r8
            r23 = r9
            r3 = 0
            r8 = r10
            r30 = r10
            r10 = r24
            boolean r6 = r6.compareAndSet(r7, r8, r10)
            if (r6 == 0) goto L_0x00c9
            java.util.concurrent.atomic.AtomicReferenceArray r6 = r7.array
            int r8 = r7.mask
            r8 = r8 & r0
            r6.set(r8, r3)
            goto L_0x00e2
        L_0x00c9:
            boolean r3 = r7.singleConsumer
            if (r3 != 0) goto L_0x00d7
        L_0x00cf:
            r0 = r33
            r2 = r26
            r3 = r27
            goto L_0x0016
        L_0x00d7:
            r3 = r7
        L_0x00d8:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r6 = r3.removeSlowPath(r0, r2)
            if (r6 == 0) goto L_0x00e2
            r3 = r6
            goto L_0x00d8
        L_0x00e2:
            r8 = r28
        L_0x00e4:
            r0 = r8
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.REMOVE_FROZEN
            if (r0 == r2) goto L_0x00ec
            kotlinx.coroutines.scheduling.Task r0 = (kotlinx.coroutines.scheduling.Task) r0
            return r0
        L_0x00ec:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = kotlinx.coroutines.internal.LockFreeTaskQueue._cur$FU$internal
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r3 = r5.next()
            r2.compareAndSet(r1, r5, r3)
            r0 = r33
            r2 = r26
            r3 = r27
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.GlobalQueue.removeFirstWithModeOrNull(kotlinx.coroutines.scheduling.TaskMode):kotlinx.coroutines.scheduling.Task");
    }
}
