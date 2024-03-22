package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 .*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002./B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u0006J1\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0006J&\u0010!\u001a\b\u0012\u0004\u0012\u0002H#0\"\"\u0004\b\u0001\u0010#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H#0%J\b\u0010&\u001a\u00020\u001aH\u0002J\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010(\u001a\u0004\u0018\u00010\u0002J\u001f\u0010)\u001a\u0004\u0018\u00010\u00022\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060%H\bJ,\u0010+\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002R(\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00060"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "E", "", "capacity", "", "singleConsumer", "", "(IZ)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_state", "Lkotlinx/atomicfu/AtomicLong;", "array", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "isEmpty", "()Z", "mask", "size", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)I", "allocateNextCopy", "state", "", "allocateOrGetNextCopy", "close", "fillPlaceholder", "index", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "markFrozen", "next", "removeFirstOrNull", "removeFirstOrNullIf", "predicate", "removeSlowPath", "oldHead", "newHead", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: LockFreeTaskQueue.kt */
public final class LockFreeTaskQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;
    private static final AtomicReferenceFieldUpdater _next$FU;
    public static final /* synthetic */ AtomicLongFieldUpdater _state$FU$internal;
    private volatile Object _next = null;
    public volatile /* synthetic */ long _state$internal = 0;
    /* access modifiers changed from: private */
    public final AtomicReferenceArray<Object> array;
    private final int capacity;
    /* access modifiers changed from: private */
    public final int mask;
    /* access modifiers changed from: private */
    public final boolean singleConsumer;

    public LockFreeTaskQueueCore(int capacity2, boolean singleConsumer2) {
        this.capacity = capacity2;
        this.singleConsumer = singleConsumer2;
        int i = capacity2 - 1;
        this.mask = i;
        this.array = new AtomicReferenceArray<>(capacity2);
        boolean z = false;
        if (i <= 1073741823) {
            if (!((i & capacity2) == 0 ? true : z)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final boolean isEmpty() {
        Companion companion = Companion;
        long $receiver$iv = this._state$internal;
        if (((int) ((HEAD_MASK & $receiver$iv) >> 0)) == ((int) ((TAIL_MASK & $receiver$iv) >> 30))) {
            return true;
        }
        return false;
    }

    public final int getSize() {
        Companion companion = Companion;
        long $receiver$iv = this._state$internal;
        return (((int) ((TAIL_MASK & $receiver$iv) >> 30)) - ((int) ((HEAD_MASK & $receiver$iv) >> 0))) & MAX_CAPACITY_MASK;
    }

    public final boolean close() {
        long cur$iv;
        long state;
        do {
            cur$iv = this._state$internal;
            state = cur$iv;
            if ((state & CLOSED_MASK) != 0) {
                return true;
            }
            if ((FROZEN_MASK & state) != 0) {
                return false;
            }
        } while (!_state$FU$internal.compareAndSet(this, cur$iv, state | CLOSED_MASK));
        return true;
    }

    public final int addLast(E element) {
        LockFreeTaskQueueCore fillPlaceholder;
        E e = element;
        Intrinsics.checkParameterIsNotNull(e, "element");
        while (true) {
            long state = this._state$internal;
            if ((3458764513820540928L & state) != 0) {
                return Companion.addFailReason(state);
            }
            Companion companion = Companion;
            long $receiver$iv = state;
            int head$iv = (int) (($receiver$iv & HEAD_MASK) >> 0);
            int tail$iv = (int) (($receiver$iv & TAIL_MASK) >> 30);
            int head = head$iv;
            int tail = tail$iv;
            int mask2 = this.mask;
            if (((tail + 2) & mask2) == (head & mask2)) {
                return 1;
            }
            if (this.singleConsumer || this.array.get(tail & mask2) == null) {
                int newTail = (tail + 1) & MAX_CAPACITY_MASK;
                int tail2 = tail;
                int mask3 = mask2;
                int i = head$iv;
                int i2 = tail$iv;
                if (_state$FU$internal.compareAndSet(this, state, Companion.updateTail(state, newTail))) {
                    this.array.set(tail2 & mask3, e);
                    LockFreeTaskQueueCore cur = this;
                    while ((cur._state$internal & FROZEN_MASK) != 0 && (fillPlaceholder = cur.next().fillPlaceholder(tail2, e)) != null) {
                        cur = fillPlaceholder;
                    }
                    return 0;
                }
            } else {
                int i3 = this.capacity;
                if (i3 < 1024 || (1073741823 & (tail - head)) > (i3 >> 1)) {
                    return 1;
                }
            }
        }
        return 1;
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int index, E element) {
        Object old = this.array.get(this.mask & index);
        if (!(old instanceof Placeholder) || ((Placeholder) old).index != index) {
            return null;
        }
        this.array.set(this.mask & index, element);
        return this;
    }

    public final Object removeFirstOrNull() {
        int $i$f$removeFirstOrNullIf;
        Object element$iv;
        int head$iv = 0;
        while (true) {
            long state$iv = this._state$internal;
            if ((FROZEN_MASK & state$iv) != 0) {
                return REMOVE_FROZEN;
            }
            long $receiver$iv$iv = state$iv;
            Companion companion = Companion;
            int head$iv$iv = (int) ((HEAD_MASK & $receiver$iv$iv) >> 0);
            int tail$iv$iv = (int) ((TAIL_MASK & $receiver$iv$iv) >> 30);
            int head$iv2 = head$iv$iv;
            if ((tail$iv$iv & this.mask) == (this.mask & head$iv2)) {
                return null;
            }
            Object element$iv2 = this.array.get(this.mask & head$iv2);
            if (element$iv2 != null) {
                if (!(element$iv2 instanceof Placeholder)) {
                    Object obj = element$iv2;
                    int newHead$iv = 1073741823 & (head$iv2 + 1);
                    int newHead$iv2 = newHead$iv;
                    element$iv = element$iv2;
                    $i$f$removeFirstOrNullIf = head$iv;
                    int head$iv3 = head$iv2;
                    int i = head$iv$iv;
                    int i2 = tail$iv$iv;
                    if (!_state$FU$internal.compareAndSet(this, state$iv, Companion.updateHead(state$iv, newHead$iv))) {
                        if (this.singleConsumer) {
                            LockFreeTaskQueueCore cur$iv = this;
                            while (true) {
                                LockFreeTaskQueueCore access$removeSlowPath = cur$iv.removeSlowPath(head$iv3, newHead$iv2);
                                if (access$removeSlowPath == null) {
                                    break;
                                }
                                cur$iv = access$removeSlowPath;
                            }
                        }
                    } else {
                        this.array.set(this.mask & head$iv3, (Object) null);
                        break;
                    }
                } else {
                    return null;
                }
            } else if (this.singleConsumer) {
                return null;
            } else {
                $i$f$removeFirstOrNullIf = head$iv;
            }
            head$iv = $i$f$removeFirstOrNullIf;
        }
        return element$iv;
    }

    public final Object removeFirstOrNullIf(Function1<? super E, Boolean> predicate) {
        LockFreeTaskQueueCore $receiver$iv;
        int $i$f$removeFirstOrNullIf;
        Function1<? super E, Boolean> function1 = predicate;
        int $i$f$removeFirstOrNullIf2 = 0;
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        LockFreeTaskQueueCore $receiver$iv2 = this;
        while (true) {
            long state = $receiver$iv2._state$internal;
            if ((FROZEN_MASK & state) != 0) {
                return REMOVE_FROZEN;
            }
            long $receiver$iv3 = state;
            Companion companion = Companion;
            int head$iv = (int) ((HEAD_MASK & $receiver$iv3) >> 0);
            int tail$iv = (int) ((TAIL_MASK & $receiver$iv3) >> 30);
            int head = head$iv;
            if ((tail$iv & this.mask) == (this.mask & head)) {
                return null;
            }
            Object element = this.array.get(this.mask & head);
            if (element == null) {
                if (this.singleConsumer) {
                    return null;
                }
                $i$f$removeFirstOrNullIf = $i$f$removeFirstOrNullIf2;
                $receiver$iv = $receiver$iv2;
            } else if ((element instanceof Placeholder) || !function1.invoke(element).booleanValue()) {
                return null;
            } else {
                int newHead = (head + 1) & MAX_CAPACITY_MASK;
                AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU$internal;
                long updateHead = Companion.updateHead(state, newHead);
                int newHead2 = newHead;
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
                Object element2 = element;
                $i$f$removeFirstOrNullIf = $i$f$removeFirstOrNullIf2;
                $receiver$iv = $receiver$iv2;
                int head2 = head;
                int $i$f$removeFirstOrNullIf3 = newHead2;
                int i = head$iv;
                int i2 = tail$iv;
                if (atomicLongFieldUpdater2.compareAndSet(this, state, updateHead)) {
                    this.array.set(this.mask & head2, (Object) null);
                    return element2;
                } else if (this.singleConsumer) {
                    LockFreeTaskQueueCore cur = this;
                    while (true) {
                        LockFreeTaskQueueCore access$removeSlowPath = cur.removeSlowPath(head2, $i$f$removeFirstOrNullIf3);
                        if (access$removeSlowPath == null) {
                            return element2;
                        }
                        cur = access$removeSlowPath;
                    }
                }
            }
            function1 = predicate;
            $i$f$removeFirstOrNullIf2 = $i$f$removeFirstOrNullIf;
            $receiver$iv2 = $receiver$iv;
        }
    }

    /* access modifiers changed from: private */
    public final LockFreeTaskQueueCore<E> removeSlowPath(int oldHead, int newHead) {
        LockFreeTaskQueueCore $receiver$iv = this;
        while (true) {
            long state = $receiver$iv._state$internal;
            long $receiver$iv2 = state;
            Companion companion = Companion;
            boolean z = false;
            int head$iv = (int) ((HEAD_MASK & $receiver$iv2) >> 0);
            int tail$iv = (int) ((TAIL_MASK & $receiver$iv2) >> 30);
            int head = head$iv;
            int i = tail$iv;
            if (head == oldHead) {
                z = true;
            }
            if (!z) {
                throw new IllegalStateException("This queue can have only one consumer".toString());
            } else if ((state & FROZEN_MASK) != 0) {
                return next();
            } else {
                LockFreeTaskQueueCore $receiver$iv3 = $receiver$iv;
                int head2 = head;
                int i2 = head$iv;
                int i3 = tail$iv;
                if (_state$FU$internal.compareAndSet(this, state, Companion.updateHead(state, newHead))) {
                    this.array.set(head2 & this.mask, (Object) null);
                    return null;
                }
                $receiver$iv = $receiver$iv3;
            }
        }
    }

    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    private final long markFrozen() {
        long cur$iv;
        long upd$iv;
        do {
            cur$iv = this._state$internal;
            long state = cur$iv;
            if ((state & FROZEN_MASK) != 0) {
                return state;
            }
            upd$iv = state | FROZEN_MASK;
        } while (!_state$FU$internal.compareAndSet(this, cur$iv, upd$iv));
        return upd$iv;
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long state) {
        while (true) {
            LockFreeTaskQueueCore next = (LockFreeTaskQueueCore) this._next;
            if (next != null) {
                return next;
            }
            _next$FU.compareAndSet(this, (Object) null, allocateNextCopy(state));
        }
    }

    private final LockFreeTaskQueueCore<E> allocateNextCopy(long state) {
        LockFreeTaskQueueCore next = new LockFreeTaskQueueCore(this.capacity * 2, this.singleConsumer);
        Companion this_$iv = Companion;
        long $receiver$iv = state;
        int tail = (int) ((TAIL_MASK & $receiver$iv) >> 30);
        int index = (int) ((HEAD_MASK & $receiver$iv) >> 0);
        while (true) {
            int i = this.mask;
            if ((index & i) != (tail & i)) {
                AtomicReferenceArray<Object> atomicReferenceArray = next.array;
                int i2 = next.mask & index;
                Object obj = this.array.get(i & index);
                if (obj == null) {
                    obj = new Placeholder(index);
                }
                atomicReferenceArray.set(i2, obj);
                index++;
            } else {
                Companion companion = this_$iv;
                long j = $receiver$iv;
                next._state$internal = Companion.wo(state, FROZEN_MASK);
                return next;
            }
        }
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        ArrayList res = new ArrayList(this.array.length());
        Companion companion = Companion;
        long $receiver$iv = this._state$internal;
        int tail = (int) ((TAIL_MASK & $receiver$iv) >> 30);
        int index = (int) ((HEAD_MASK & $receiver$iv) >> 0);
        while (true) {
            int i = this.mask;
            if ((index & i) == (tail & i)) {
                return res;
            }
            Object element = this.array.get(i & index);
            if (element != null && !(element instanceof Placeholder)) {
                res.add(transform.invoke(element));
            }
            index++;
        }
    }

    public final boolean isClosed() {
        return (this._state$internal & CLOSED_MASK) != 0;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: LockFreeTaskQueue.kt */
    public static final class Placeholder {
        public final int index;

        public Placeholder(int index2) {
            this.index = index2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: LockFreeTaskQueue.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final long wo(long $receiver, long other) {
            return (~other) & $receiver;
        }

        public final long updateHead(long $receiver, int newHead) {
            return wo($receiver, LockFreeTaskQueueCore.HEAD_MASK) | (((long) newHead) << 0);
        }

        public final long updateTail(long $receiver, int newTail) {
            return wo($receiver, LockFreeTaskQueueCore.TAIL_MASK) | (((long) newTail) << 30);
        }

        public final <T> T withState(long $receiver, Function2<? super Integer, ? super Integer, ? extends T> block) {
            Intrinsics.checkParameterIsNotNull(block, "block");
            return block.invoke(Integer.valueOf((int) ((LockFreeTaskQueueCore.HEAD_MASK & $receiver) >> 0)), Integer.valueOf((int) ((LockFreeTaskQueueCore.TAIL_MASK & $receiver) >> 30)));
        }

        public final int addFailReason(long $receiver) {
            return (LockFreeTaskQueueCore.CLOSED_MASK & $receiver) != 0 ? 2 : 1;
        }
    }

    static {
        Class<LockFreeTaskQueueCore> cls = LockFreeTaskQueueCore.class;
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        _state$FU$internal = AtomicLongFieldUpdater.newUpdater(cls, "_state$internal");
    }
}
