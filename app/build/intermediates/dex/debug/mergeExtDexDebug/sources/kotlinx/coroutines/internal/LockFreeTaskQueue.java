package kotlinx.coroutines.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00180\u001aJ\r\u0010\u001b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u001aH\b¢\u0006\u0002\u0010\u001fR$\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\bj\b\u0012\u0004\u0012\u00028\u0000`\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "E", "", "singleConsumer", "", "(Z)V", "_cur", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "isEmpty", "()Z", "size", "", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)Z", "close", "", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "removeFirstOrNull", "()Ljava/lang/Object;", "removeFirstOrNullIf", "predicate", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: LockFreeTaskQueue.kt */
public class LockFreeTaskQueue<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater _cur$FU$internal = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur$internal");
    public volatile /* synthetic */ Object _cur$internal;

    public LockFreeTaskQueue(boolean singleConsumer) {
        this._cur$internal = new LockFreeTaskQueueCore(8, singleConsumer);
    }

    public final boolean isEmpty() {
        return ((LockFreeTaskQueueCore) this._cur$internal).isEmpty();
    }

    public final int getSize() {
        return ((LockFreeTaskQueueCore) this._cur$internal).getSize();
    }

    public final void close() {
        while (true) {
            LockFreeTaskQueueCore cur = (LockFreeTaskQueueCore) this._cur$internal;
            if (!cur.close()) {
                _cur$FU$internal.compareAndSet(this, cur, cur.next());
            } else {
                return;
            }
        }
    }

    public final boolean addLast(E element) {
        Intrinsics.checkParameterIsNotNull(element, "element");
        while (true) {
            LockFreeTaskQueueCore cur = (LockFreeTaskQueueCore) this._cur$internal;
            int addLast = cur.addLast(element);
            if (addLast == 0) {
                return true;
            }
            if (addLast == 1) {
                _cur$FU$internal.compareAndSet(this, cur, cur.next());
            } else if (addLast == 2) {
                return false;
            }
        }
    }

    public final E removeFirstOrNull() {
        Object obj;
        int $i$f$removeFirstOrNullIf;
        LockFreeTaskQueue $receiver$iv$iv;
        int $i$f$loop;
        Object element$iv$iv;
        int newHead$iv$iv = 0;
        LockFreeTaskQueue $receiver$iv$iv2 = this;
        int $i$f$loop2 = 0;
        while (true) {
            LockFreeTaskQueueCore cur$iv = (LockFreeTaskQueueCore) $receiver$iv$iv2._cur$internal;
            LockFreeTaskQueueCore this_$iv$iv = cur$iv;
            LockFreeTaskQueueCore $receiver$iv$iv$iv = this_$iv$iv;
            while (true) {
                long state$iv$iv = $receiver$iv$iv$iv._state$internal;
                if ((LockFreeTaskQueueCore.FROZEN_MASK & state$iv$iv) != 0) {
                    obj = LockFreeTaskQueueCore.REMOVE_FROZEN;
                    $i$f$removeFirstOrNullIf = newHead$iv$iv;
                    $receiver$iv$iv = $receiver$iv$iv2;
                    $i$f$loop = $i$f$loop2;
                    break;
                }
                long $receiver$iv$iv$iv2 = state$iv$iv;
                LockFreeTaskQueueCore.Companion companion = LockFreeTaskQueueCore.Companion;
                int head$iv$iv$iv = (int) (($receiver$iv$iv$iv2 & LockFreeTaskQueueCore.HEAD_MASK) >> 0);
                $i$f$removeFirstOrNullIf = newHead$iv$iv;
                $receiver$iv$iv = $receiver$iv$iv2;
                int tail$iv$iv$iv = (int) (($receiver$iv$iv$iv2 & LockFreeTaskQueueCore.TAIL_MASK) >> 30);
                int head$iv$iv = head$iv$iv$iv;
                if ((tail$iv$iv$iv & this_$iv$iv.mask) == (this_$iv$iv.mask & head$iv$iv)) {
                    $i$f$loop = $i$f$loop2;
                    obj = null;
                    break;
                }
                Object element$iv$iv2 = this_$iv$iv.array.get(this_$iv$iv.mask & head$iv$iv);
                if (element$iv$iv2 != null) {
                    if (!(element$iv$iv2 instanceof LockFreeTaskQueueCore.Placeholder)) {
                        Object obj2 = element$iv$iv2;
                        int newHead$iv$iv2 = (head$iv$iv + 1) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                        AtomicLongFieldUpdater atomicLongFieldUpdater = LockFreeTaskQueueCore._state$FU$internal;
                        int i = tail$iv$iv$iv;
                        long state$iv$iv2 = LockFreeTaskQueueCore.Companion.updateHead(state$iv$iv, newHead$iv$iv2);
                        int newHead$iv$iv3 = newHead$iv$iv2;
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
                        $i$f$loop = $i$f$loop2;
                        int i2 = head$iv$iv$iv;
                        element$iv$iv = element$iv$iv2;
                        long j = state$iv$iv;
                        if (!atomicLongFieldUpdater2.compareAndSet(this_$iv$iv, state$iv$iv, state$iv$iv2)) {
                            if (this_$iv$iv.singleConsumer) {
                                LockFreeTaskQueueCore cur$iv$iv = this_$iv$iv;
                                while (true) {
                                    LockFreeTaskQueueCore access$removeSlowPath = cur$iv$iv.removeSlowPath(head$iv$iv, newHead$iv$iv3);
                                    if (access$removeSlowPath == null) {
                                        break;
                                    }
                                    cur$iv$iv = access$removeSlowPath;
                                }
                            }
                        } else {
                            this_$iv$iv.array.set(this_$iv$iv.mask & head$iv$iv, (Object) null);
                            break;
                        }
                    } else {
                        $i$f$loop = $i$f$loop2;
                        obj = null;
                        break;
                    }
                } else if (this_$iv$iv.singleConsumer) {
                    $i$f$loop = $i$f$loop2;
                    obj = null;
                    break;
                } else {
                    $i$f$loop = $i$f$loop2;
                }
                newHead$iv$iv = $i$f$removeFirstOrNullIf;
                $receiver$iv$iv2 = $receiver$iv$iv;
                $i$f$loop2 = $i$f$loop;
            }
            obj = element$iv$iv;
            Object result$iv = obj;
            if (result$iv != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return result$iv;
            }
            _cur$FU$internal.compareAndSet(this, cur$iv, cur$iv.next());
            newHead$iv$iv = $i$f$removeFirstOrNullIf;
            $receiver$iv$iv2 = $receiver$iv$iv;
            $i$f$loop2 = $i$f$loop;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d8, code lost:
        r7 = r25;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final E removeFirstOrNullIf(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r32) {
        /*
            r31 = this;
            r0 = r32
            r1 = 0
            java.lang.String r2 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r2)
            r2 = r31
            r3 = 0
        L_0x000b:
            java.lang.Object r4 = r2._cur$internal
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r4 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r4
            r11 = 0
            r6 = r4
            r12 = 0
            r13 = r6
            r14 = 0
        L_0x0015:
            long r9 = r13._state$internal
            r15 = 0
            r7 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r7 = r7 & r9
            r16 = 0
            int r5 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r5 == 0) goto L_0x002a
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.REMOVE_FROZEN
            r23 = r1
            r24 = r2
            goto L_0x00da
        L_0x002a:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r5 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion
            r16 = r9
            r18 = r5
            r19 = 0
            r20 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r20 = r16 & r20
            r5 = 0
            long r7 = r20 >> r5
            int r7 = (int) r7
            r20 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r20 = r16 & r20
            r5 = 30
            r23 = r1
            r24 = r2
            long r1 = r20 >> r5
            int r1 = (int) r1
            r2 = r7
            r20 = r1
            r21 = 0
            int r5 = r6.mask
            r5 = r20 & r5
            int r8 = r6.mask
            r8 = r8 & r2
            if (r5 != r8) goto L_0x0060
            r7 = 0
            goto L_0x00da
        L_0x0060:
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r6.array
            int r8 = r6.mask
            r8 = r8 & r2
            java.lang.Object r8 = r5.get(r8)
            if (r8 != 0) goto L_0x0079
            boolean r5 = r6.singleConsumer
            if (r5 == 0) goto L_0x0078
            r7 = 0
            goto L_0x00da
        L_0x0078:
            goto L_0x00c5
        L_0x0079:
            boolean r5 = r8 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore.Placeholder
            if (r5 == 0) goto L_0x007f
            r7 = 0
            goto L_0x00da
        L_0x007f:
            java.lang.Object r5 = r0.invoke(r8)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x008e
            r7 = 0
            goto L_0x00da
        L_0x008e:
            int r5 = r2 + 1
            r25 = 1073741823(0x3fffffff, float:1.9999999)
            r5 = r5 & r25
            java.util.concurrent.atomic.AtomicLongFieldUpdater r25 = kotlinx.coroutines.internal.LockFreeTaskQueueCore._state$FU$internal
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r0 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion
            long r26 = r0.updateHead(r9, r5)
            r0 = r5
            r5 = r25
            r28 = r1
            r22 = r7
            r25 = r8
            r1 = 0
            r7 = r9
            r29 = r9
            r9 = r26
            boolean r5 = r5.compareAndSet(r6, r7, r9)
            if (r5 == 0) goto L_0x00bf
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r6.array
            int r7 = r6.mask
            r7 = r7 & r2
            r5.set(r7, r1)
            goto L_0x00d8
        L_0x00bf:
            boolean r1 = r6.singleConsumer
            if (r1 != 0) goto L_0x00cd
        L_0x00c5:
            r0 = r32
            r1 = r23
            r2 = r24
            goto L_0x0015
        L_0x00cd:
            r1 = r6
        L_0x00ce:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r5 = r1.removeSlowPath(r2, r0)
            if (r5 == 0) goto L_0x00d8
            r1 = r5
            goto L_0x00ce
        L_0x00d8:
            r7 = r25
        L_0x00da:
            r0 = r7
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.REMOVE_FROZEN
            if (r0 == r1) goto L_0x00e0
            return r0
        L_0x00e0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = _cur$FU$internal
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r2 = r4.next()
            r5 = r31
            r1.compareAndSet(r5, r4, r2)
            r0 = r32
            r1 = r23
            r2 = r24
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueue.removeFirstOrNullIf(kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return ((LockFreeTaskQueueCore) this._cur$internal).map(transform);
    }

    public final boolean isClosed() {
        return ((LockFreeTaskQueueCore) this._cur$internal).isClosed();
    }
}
