package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0018J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J!\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u001dH\bJ\r\u0010\u001e\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u001fJ\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0016\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J \u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "()V", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Lkotlinx/coroutines/scheduling/Task;", "bufferSize", "", "getBufferSize$kotlinx_coroutines_core", "()I", "consumerIndex", "Lkotlinx/atomicfu/AtomicInt;", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicRef;", "producerIndex", "add", "", "task", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "addLast", "addToGlobalQueue", "", "offloadAllWork", "offloadAllWork$kotlinx_coroutines_core", "offloadWork", "poll", "pollExternal", "predicate", "Lkotlin/Function1;", "size", "size$kotlinx_coroutines_core", "tryAddLast", "trySteal", "victim", "tryStealLastScheduled", "time", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: WorkQueue.kt */
public final class WorkQueue {
    static final AtomicIntegerFieldUpdater consumerIndex$FU;
    private static final AtomicReferenceFieldUpdater lastScheduledTask$FU;
    static final AtomicIntegerFieldUpdater producerIndex$FU;
    /* access modifiers changed from: private */
    public final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray<>(128);
    volatile int consumerIndex = 0;
    private volatile Object lastScheduledTask = null;
    volatile int producerIndex = 0;

    static {
        Class<WorkQueue> cls = WorkQueue.class;
        lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
    }

    public final int getBufferSize$kotlinx_coroutines_core() {
        return this.producerIndex - this.consumerIndex;
    }

    public final Task poll() {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, (Object) null);
        if (task != null) {
            return task;
        }
        while (true) {
            int tailLocal$iv = this.consumerIndex;
            if (tailLocal$iv - this.producerIndex == 0) {
                return null;
            }
            int index$iv = tailLocal$iv & WorkQueueKt.MASK;
            Task element$iv = (Task) this.buffer.get(index$iv);
            if (element$iv != null) {
                Task task2 = element$iv;
                if (consumerIndex$FU.compareAndSet(this, tailLocal$iv, tailLocal$iv + 1)) {
                    return (Task) this.buffer.getAndSet(index$iv, (Object) null);
                }
            }
        }
    }

    public final boolean add(Task task, GlobalQueue globalQueue) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        Intrinsics.checkParameterIsNotNull(globalQueue, "globalQueue");
        Task previous = (Task) lastScheduledTask$FU.getAndSet(this, task);
        if (previous != null) {
            return addLast(previous, globalQueue);
        }
        return true;
    }

    public final boolean addLast(Task task, GlobalQueue globalQueue) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        Intrinsics.checkParameterIsNotNull(globalQueue, "globalQueue");
        boolean noOffloadingHappened = true;
        while (!tryAddLast(task)) {
            offloadWork(globalQueue);
            noOffloadingHappened = false;
        }
        return noOffloadingHappened;
    }

    public final boolean trySteal(WorkQueue victim, GlobalQueue globalQueue) {
        Task element$iv;
        WorkQueue workQueue = victim;
        GlobalQueue globalQueue2 = globalQueue;
        Intrinsics.checkParameterIsNotNull(workQueue, "victim");
        Intrinsics.checkParameterIsNotNull(globalQueue2, "globalQueue");
        long time = TasksKt.schedulerTimeSource.nanoTime();
        int bufferSize = victim.getBufferSize$kotlinx_coroutines_core();
        if (bufferSize == 0) {
            return tryStealLastScheduled(time, workQueue, globalQueue2);
        }
        boolean wasStolen = false;
        int coerceAtLeast = RangesKt.coerceAtLeast(bufferSize / 2, 1);
        int i = 0;
        while (i < coerceAtLeast) {
            int it = i;
            int i2 = false;
            WorkQueue this_$iv = victim;
            while (true) {
                int tailLocal$iv = this_$iv.consumerIndex;
                if (tailLocal$iv - this_$iv.producerIndex == 0) {
                    int i3 = it;
                    int i4 = i2;
                    element$iv = null;
                    break;
                }
                int index$iv = tailLocal$iv & WorkQueueKt.MASK;
                Task element$iv2 = (Task) this_$iv.buffer.get(index$iv);
                if (element$iv2 != null) {
                    int i5 = i2;
                    int it2 = it;
                    if (!(time - element$iv2.submissionTime >= TasksKt.WORK_STEALING_TIME_RESOLUTION_NS || victim.getBufferSize$kotlinx_coroutines_core() > TasksKt.QUEUE_SIZE_OFFLOAD_THRESHOLD)) {
                        element$iv = null;
                        break;
                    } else if (consumerIndex$FU.compareAndSet(this_$iv, tailLocal$iv, tailLocal$iv + 1)) {
                        element$iv = (Task) this_$iv.buffer.getAndSet(index$iv, (Object) null);
                        break;
                    } else {
                        WorkQueue workQueue2 = victim;
                        it = it2;
                        i2 = i5;
                    }
                } else {
                    int i6 = i2;
                    WorkQueue workQueue3 = victim;
                }
            }
            if (element$iv == null) {
                return wasStolen;
            }
            wasStolen = true;
            add(element$iv, globalQueue2);
            i++;
            WorkQueue workQueue4 = victim;
        }
        return wasStolen;
    }

    private final boolean tryStealLastScheduled(long time, WorkQueue victim, GlobalQueue globalQueue) {
        Task lastScheduled = (Task) victim.lastScheduledTask;
        if (lastScheduled == null || time - lastScheduled.submissionTime < TasksKt.WORK_STEALING_TIME_RESOLUTION_NS || !lastScheduledTask$FU.compareAndSet(victim, lastScheduled, (Object) null)) {
            return false;
        }
        add(lastScheduled, globalQueue);
        return true;
    }

    public final int size$kotlinx_coroutines_core() {
        return this.lastScheduledTask != null ? getBufferSize$kotlinx_coroutines_core() + 1 : getBufferSize$kotlinx_coroutines_core();
    }

    private final void offloadWork(GlobalQueue globalQueue) {
        Task task;
        int coerceAtLeast = RangesKt.coerceAtLeast(getBufferSize$kotlinx_coroutines_core() / 2, 1);
        int i = 0;
        while (i < coerceAtLeast) {
            int i2 = i;
            while (true) {
                int tailLocal$iv = this.consumerIndex;
                if (tailLocal$iv - this.producerIndex == 0) {
                    task = null;
                    break;
                }
                int index$iv = tailLocal$iv & WorkQueueKt.MASK;
                Task element$iv = (Task) this.buffer.get(index$iv);
                if (element$iv != null) {
                    Task task2 = element$iv;
                    if (consumerIndex$FU.compareAndSet(this, tailLocal$iv, tailLocal$iv + 1)) {
                        task = (Task) this.buffer.getAndSet(index$iv, (Object) null);
                        break;
                    }
                }
            }
            if (task != null) {
                addToGlobalQueue(globalQueue, task);
                i++;
            } else {
                return;
            }
        }
    }

    private final void addToGlobalQueue(GlobalQueue globalQueue, Task task) {
        if (!globalQueue.addLast(task)) {
            throw new IllegalStateException("GlobalQueue could not be closed yet".toString());
        }
    }

    public final void offloadAllWork$kotlinx_coroutines_core(GlobalQueue globalQueue) {
        Task task;
        Intrinsics.checkParameterIsNotNull(globalQueue, "globalQueue");
        Task it = (Task) lastScheduledTask$FU.getAndSet(this, (Object) null);
        if (it != null) {
            addToGlobalQueue(globalQueue, it);
        }
        while (true) {
            while (true) {
                int tailLocal$iv = this.consumerIndex;
                if (tailLocal$iv - this.producerIndex == 0) {
                    task = null;
                    break;
                }
                int index$iv = tailLocal$iv & WorkQueueKt.MASK;
                Task element$iv = (Task) this.buffer.get(index$iv);
                if (element$iv != null) {
                    Task task2 = element$iv;
                    if (consumerIndex$FU.compareAndSet(this, tailLocal$iv, tailLocal$iv + 1)) {
                        task = (Task) this.buffer.getAndSet(index$iv, (Object) null);
                        break;
                    }
                }
            }
            if (task != null) {
                addToGlobalQueue(globalQueue, task);
            } else {
                return;
            }
        }
    }

    static /* synthetic */ Task pollExternal$default(WorkQueue workQueue, Function1 predicate, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = WorkQueue$pollExternal$1.INSTANCE;
        }
        while (true) {
            int tailLocal = workQueue.consumerIndex;
            if (tailLocal - workQueue.producerIndex == 0) {
                return null;
            }
            int index = tailLocal & WorkQueueKt.MASK;
            Task element = (Task) workQueue.buffer.get(index);
            if (element != null) {
                if (!((Boolean) predicate.invoke(element)).booleanValue()) {
                    return null;
                }
                if (consumerIndex$FU.compareAndSet(workQueue, tailLocal, tailLocal + 1)) {
                    return (Task) workQueue.buffer.getAndSet(index, (Object) null);
                }
            }
        }
    }

    private final Task pollExternal(Function1<? super Task, Boolean> predicate) {
        while (true) {
            int tailLocal = this.consumerIndex;
            if (tailLocal - this.producerIndex == 0) {
                return null;
            }
            int index = tailLocal & WorkQueueKt.MASK;
            Task element = (Task) this.buffer.get(index);
            if (element != null) {
                if (!predicate.invoke(element).booleanValue()) {
                    return null;
                }
                if (consumerIndex$FU.compareAndSet(this, tailLocal, tailLocal + 1)) {
                    return (Task) this.buffer.getAndSet(index, (Object) null);
                }
            }
        }
    }

    private final boolean tryAddLast(Task task) {
        if (getBufferSize$kotlinx_coroutines_core() == 127) {
            return false;
        }
        int nextIndex = this.producerIndex & WorkQueueKt.MASK;
        if (this.buffer.get(nextIndex) != null) {
            return false;
        }
        this.buffer.lazySet(nextIndex, task);
        producerIndex$FU.incrementAndGet(this);
        return true;
    }
}
