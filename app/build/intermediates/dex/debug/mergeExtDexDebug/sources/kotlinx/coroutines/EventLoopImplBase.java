package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0003123B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH\u0002J\u001a\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0019j\u0002`\u001aJ\u0012\u0010\u001f\u001a\u00020\u00172\n\u0010 \u001a\u00060\u0019j\u0002`\u001aJ\u0014\u0010!\u001a\u00020\u000b2\n\u0010 \u001a\u00060\u0019j\u0002`\u001aH\u0002J\b\u0010\"\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0004J\u0015\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0007H\u0000¢\u0006\u0002\b'J\u0010\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001e\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u000f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170-H\u0016J\u0010\u0010.\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\u0017H\u0014J\b\u00100\u001a\u00020\u0017H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8TX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u00064"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/Delay;", "()V", "_delayed", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "_queue", "", "isCompleted", "", "isEmpty", "()Z", "nextTime", "", "getNextTime", "()J", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "closeQueue", "", "dequeue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "enqueue", "task", "enqueueImpl", "processNextEvent", "rescheduleAllDelayed", "resetAll", "schedule", "delayedTask", "schedule$kotlinx_coroutines_core", "scheduleImpl", "", "scheduleResumeAfterDelay", "timeMillis", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldUnpark", "shutdown", "unpark", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: EventLoop.kt */
public abstract class EventLoopImplBase extends EventLoop implements Delay {
    private static final AtomicReferenceFieldUpdater _delayed$FU;
    private static final AtomicReferenceFieldUpdater _queue$FU;
    private volatile Object _delayed = null;
    private volatile Object _queue = null;
    /* access modifiers changed from: private */
    public volatile boolean isCompleted;

    static {
        Class<EventLoopImplBase> cls = EventLoopImplBase.class;
        _queue$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_queue");
        _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_delayed");
    }

    /* access modifiers changed from: protected */
    public abstract Thread getThread();

    public Object delay(long time, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, time, continuation);
    }

    public DisposableHandle invokeOnTimeout(long timeMillis, Runnable block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        return Delay.DefaultImpls.invokeOnTimeout(this, timeMillis, block);
    }

    /* access modifiers changed from: protected */
    public boolean isEmpty() {
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        ThreadSafeHeap delayed = (ThreadSafeHeap) this._delayed;
        if (delayed != null && !delayed.isEmpty()) {
            return false;
        }
        Object queue = this._queue;
        if (queue == null) {
            return true;
        }
        if (queue instanceof LockFreeTaskQueueCore) {
            return ((LockFreeTaskQueueCore) queue).isEmpty();
        }
        if (queue == EventLoopKt.CLOSED_EMPTY) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public long getNextTime() {
        DelayedTask nextDelayedTask;
        if (super.getNextTime() == 0) {
            return 0;
        }
        Object queue = this._queue;
        if (queue != null) {
            if (queue instanceof LockFreeTaskQueueCore) {
                if (!((LockFreeTaskQueueCore) queue).isEmpty()) {
                    return 0;
                }
            } else if (queue == EventLoopKt.CLOSED_EMPTY) {
                return LongCompanionObject.MAX_VALUE;
            } else {
                return 0;
            }
        }
        ThreadSafeHeap delayed = (ThreadSafeHeap) this._delayed;
        if (delayed == null || (nextDelayedTask = (DelayedTask) delayed.peek()) == null) {
            return LongCompanionObject.MAX_VALUE;
        }
        return RangesKt.coerceAtLeast(nextDelayedTask.nanoTime - TimeSourceKt.getTimeSource().nanoTime(), 0);
    }

    private final void unpark() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            TimeSourceKt.getTimeSource().unpark(thread);
        }
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        this.isCompleted = true;
        closeQueue();
        do {
        } while (processNextEvent() <= 0);
        rescheduleAllDelayed();
    }

    public void scheduleResumeAfterDelay(long timeMillis, CancellableContinuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        schedule$kotlinx_coroutines_core(new DelayedResumeTask(this, timeMillis, continuation));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long processNextEvent() {
        /*
            r14 = this;
            boolean r0 = r14.processUnconfinedEvent()
            if (r0 == 0) goto L_0x000b
            long r0 = r14.getNextTime()
            return r0
        L_0x000b:
            java.lang.Object r0 = r14._delayed
            kotlinx.coroutines.internal.ThreadSafeHeap r0 = (kotlinx.coroutines.internal.ThreadSafeHeap) r0
            if (r0 == 0) goto L_0x0059
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0059
            kotlinx.coroutines.TimeSource r1 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            long r1 = r1.nanoTime()
        L_0x001f:
            r3 = r0
            r4 = 0
            r5 = r3
            r6 = 0
            monitor-enter(r5)
            r7 = 0
            kotlinx.coroutines.internal.ThreadSafeHeapNode r8 = r3.firstImpl()     // Catch:{ all -> 0x0056 }
            r9 = 0
            if (r8 == 0) goto L_0x004f
            r10 = r8
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r10 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r10     // Catch:{ all -> 0x0056 }
            r11 = 0
            boolean r12 = r10.timeToExecute(r1)     // Catch:{ all -> 0x0056 }
            r13 = 0
            if (r12 == 0) goto L_0x0040
            r12 = r10
            java.lang.Runnable r12 = (java.lang.Runnable) r12     // Catch:{ all -> 0x0056 }
            boolean r12 = r14.enqueueImpl(r12)     // Catch:{ all -> 0x0056 }
            goto L_0x0041
        L_0x0040:
            r12 = r13
        L_0x0041:
            if (r12 == 0) goto L_0x0049
            kotlinx.coroutines.internal.ThreadSafeHeapNode r9 = r3.removeAtImpl(r13)     // Catch:{ all -> 0x0056 }
            goto L_0x004a
        L_0x0049:
        L_0x004a:
            monitor-exit(r5)
            goto L_0x0050
        L_0x004f:
            monitor-exit(r5)
        L_0x0050:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r9 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r9
            if (r9 == 0) goto L_0x0055
            goto L_0x001f
        L_0x0055:
            goto L_0x0059
        L_0x0056:
            r7 = move-exception
            monitor-exit(r5)
            throw r7
        L_0x0059:
            java.lang.Runnable r1 = r14.dequeue()
            if (r1 == 0) goto L_0x0062
            r1.run()
        L_0x0062:
            long r1 = r14.getNextTime()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.processNextEvent():long");
    }

    public final void dispatch(CoroutineContext context, Runnable block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        enqueue(block);
    }

    public final void enqueue(Runnable task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        if (enqueueImpl(task)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(task);
        }
    }

    private final boolean enqueueImpl(Runnable task) {
        while (true) {
            Object queue = this._queue;
            if (this.isCompleted) {
                return false;
            }
            if (queue == null) {
                if (_queue$FU.compareAndSet(this, (Object) null, task)) {
                    return true;
                }
            } else if (queue instanceof LockFreeTaskQueueCore) {
                if (queue != null) {
                    int addLast = ((LockFreeTaskQueueCore) queue).addLast(task);
                    if (addLast == 0) {
                        return true;
                    }
                    if (addLast == 1) {
                        _queue$FU.compareAndSet(this, queue, ((LockFreeTaskQueueCore) queue).next());
                    } else if (addLast == 2) {
                        return false;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else if (queue == EventLoopKt.CLOSED_EMPTY) {
                return false;
            } else {
                LockFreeTaskQueueCore newQueue = new LockFreeTaskQueueCore(8, true);
                if (queue != null) {
                    newQueue.addLast((Runnable) queue);
                    newQueue.addLast(task);
                    if (_queue$FU.compareAndSet(this, queue, newQueue)) {
                        return true;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    private final Runnable dequeue() {
        while (true) {
            Object queue = this._queue;
            if (queue == null) {
                return null;
            }
            if (queue instanceof LockFreeTaskQueueCore) {
                if (queue != null) {
                    Object result = ((LockFreeTaskQueueCore) queue).removeFirstOrNull();
                    if (result != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                        return (Runnable) result;
                    }
                    _queue$FU.compareAndSet(this, queue, ((LockFreeTaskQueueCore) queue).next());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else if (queue == EventLoopKt.CLOSED_EMPTY) {
                return null;
            } else {
                if (_queue$FU.compareAndSet(this, queue, (Object) null)) {
                    if (queue != null) {
                        return (Runnable) queue;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    private final void closeQueue() {
        if (this.isCompleted) {
            while (true) {
                Object queue = this._queue;
                if (queue == null) {
                    if (_queue$FU.compareAndSet(this, (Object) null, EventLoopKt.CLOSED_EMPTY)) {
                        return;
                    }
                } else if (queue instanceof LockFreeTaskQueueCore) {
                    ((LockFreeTaskQueueCore) queue).close();
                    return;
                } else if (queue != EventLoopKt.CLOSED_EMPTY) {
                    LockFreeTaskQueueCore newQueue = new LockFreeTaskQueueCore(8, true);
                    if (queue != null) {
                        newQueue.addLast((Runnable) queue);
                        if (_queue$FU.compareAndSet(this, queue, newQueue)) {
                            return;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError("Assertion failed");
        }
    }

    public final void schedule$kotlinx_coroutines_core(DelayedTask delayedTask) {
        Intrinsics.checkParameterIsNotNull(delayedTask, "delayedTask");
        int scheduleImpl = scheduleImpl(delayedTask);
        if (scheduleImpl != 0) {
            if (scheduleImpl == 1) {
                DefaultExecutor.INSTANCE.schedule$kotlinx_coroutines_core(delayedTask);
            } else if (scheduleImpl != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (shouldUnpark(delayedTask)) {
            unpark();
        }
    }

    private final boolean shouldUnpark(DelayedTask task) {
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        return (threadSafeHeap != null ? (DelayedTask) threadSafeHeap.peek() : null) == task;
    }

    private final int scheduleImpl(DelayedTask delayedTask) {
        if (this.isCompleted) {
            return 1;
        }
        ThreadSafeHeap delayed = (ThreadSafeHeap) this._delayed;
        if (delayed == null) {
            EventLoopImplBase $receiver = this;
            _delayed$FU.compareAndSet($receiver, (Object) null, new ThreadSafeHeap());
            Object obj = $receiver._delayed;
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            delayed = (ThreadSafeHeap) obj;
        }
        return delayedTask.schedule(delayed, this);
    }

    /* access modifiers changed from: protected */
    public final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    private final void rescheduleAllDelayed() {
        DelayedTask delayedTask;
        while (true) {
            ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
            if (threadSafeHeap != null && (delayedTask = (DelayedTask) threadSafeHeap.removeFirstOrNull()) != null) {
                delayedTask.rescheduleOnShutdown();
            } else {
                return;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0000H\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u001c\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00000\f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007J\b\u0010%\u001a\u00020&H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "timeMillis", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "nanoTime", "compareTo", "other", "dispose", "", "rescheduleOnShutdown", "schedule", "delayed", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "now", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: EventLoop.kt */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private Object _heap;
        private int index = -1;
        public final long nanoTime;

        public DelayedTask(long timeMillis) {
            this.nanoTime = TimeSourceKt.getTimeSource().nanoTime() + EventLoopKt.delayToNanos(timeMillis);
        }

        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (!(obj instanceof ThreadSafeHeap)) {
                obj = null;
            }
            return (ThreadSafeHeap) obj;
        }

        public void setHeap(ThreadSafeHeap<?> value) {
            if (this._heap != EventLoopKt.DISPOSED_TASK) {
                this._heap = value;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public int compareTo(DelayedTask other) {
            Intrinsics.checkParameterIsNotNull(other, "other");
            long dTime = this.nanoTime - other.nanoTime;
            if (dTime > 0) {
                return 1;
            }
            if (dTime < 0) {
                return -1;
            }
            return 0;
        }

        public final boolean timeToExecute(long now) {
            return now - this.nanoTime >= 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
            if (r5 == 0) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0037, code lost:
            r6 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
            return r6;
         */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0032=Splitter:B:22:0x0032, B:29:0x003d=Splitter:B:29:0x003d} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized int schedule(kotlinx.coroutines.internal.ThreadSafeHeap<kotlinx.coroutines.EventLoopImplBase.DelayedTask> r10, kotlinx.coroutines.EventLoopImplBase r11) {
            /*
                r9 = this;
                monitor-enter(r9)
                java.lang.String r0 = "delayed"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)     // Catch:{ all -> 0x003f }
                java.lang.String r0 = "eventLoop"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)     // Catch:{ all -> 0x003f }
                java.lang.Object r0 = r9._heap     // Catch:{ all -> 0x003f }
                kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.EventLoopKt.DISPOSED_TASK     // Catch:{ all -> 0x003f }
                if (r0 != r1) goto L_0x0016
                r0 = 2
                monitor-exit(r9)
                return r0
            L_0x0016:
                r0 = r9
                kotlinx.coroutines.internal.ThreadSafeHeapNode r0 = (kotlinx.coroutines.internal.ThreadSafeHeapNode) r0     // Catch:{ all -> 0x003f }
                r1 = r10
                r2 = 0
                r3 = r1
                r4 = 0
                monitor-enter(r3)     // Catch:{ all -> 0x003f }
                r5 = 0
                r6 = 0
                boolean r7 = r11.isCompleted     // Catch:{ all -> 0x003c }
                r6 = 1
                r7 = r7 ^ r6
                r8 = 0
                if (r7 == 0) goto L_0x0030
                r1.addImpl(r0)     // Catch:{ all -> 0x002e }
                r5 = r6
                goto L_0x0031
            L_0x002e:
                r5 = move-exception
                goto L_0x003d
            L_0x0030:
                r5 = r8
            L_0x0031:
                monitor-exit(r3)     // Catch:{ all -> 0x003f }
                if (r5 == 0) goto L_0x0039
                r6 = r8
                goto L_0x003a
            L_0x0039:
            L_0x003a:
                monitor-exit(r9)
                return r6
            L_0x003c:
                r5 = move-exception
            L_0x003d:
                monitor-exit(r3)     // Catch:{ all -> 0x003f }
                throw r5     // Catch:{ all -> 0x003f }
            L_0x003f:
                r10 = move-exception
                monitor-exit(r9)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.DelayedTask.schedule(kotlinx.coroutines.internal.ThreadSafeHeap, kotlinx.coroutines.EventLoopImplBase):int");
        }

        public final void rescheduleOnShutdown() {
            DefaultExecutor.INSTANCE.schedule$kotlinx_coroutines_core(this);
        }

        public final synchronized void dispose() {
            Object heap = this._heap;
            if (heap != EventLoopKt.DISPOSED_TASK) {
                ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) (!(heap instanceof ThreadSafeHeap) ? null : heap);
                if (threadSafeHeap != null) {
                    threadSafeHeap.remove(this);
                }
                this._heap = EventLoopKt.DISPOSED_TASK;
            }
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeMillis", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: EventLoop.kt */
    private final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation<Unit> cont;
        final /* synthetic */ EventLoopImplBase this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DelayedResumeTask(EventLoopImplBase $outer, long timeMillis, CancellableContinuation<? super Unit> cont2) {
            super(timeMillis);
            Intrinsics.checkParameterIsNotNull(cont2, "cont");
            this.this$0 = $outer;
            this.cont = cont2;
            CancellableContinuationKt.disposeOnCancellation(cont2, this);
        }

        public void run() {
            this.cont.resumeUndispatched(this.this$0, Unit.INSTANCE);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "time", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: EventLoop.kt */
    public static final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DelayedRunnableTask(long time, Runnable block2) {
            super(time);
            Intrinsics.checkParameterIsNotNull(block2, "block");
            this.block = block2;
        }

        public void run() {
            this.block.run();
        }

        public String toString() {
            return super.toString() + this.block.toString();
        }
    }
}
