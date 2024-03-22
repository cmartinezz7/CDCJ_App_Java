package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.TimeSourceKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0003EFGB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\r\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0007H\bJ\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0004H\u0002J!\u0010&\u001a\u00020'2\n\u0010(\u001a\u00060)j\u0002`*2\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J\u0011\u0010\u0014\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0007H\bJ\t\u0010.\u001a\u00020$H\bJ\t\u0010/\u001a\u00020\u0004H\bJ&\u00100\u001a\u00020$2\n\u0010(\u001a\u00060)j\u0002`*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u00101\u001a\u00020\u0019J\u0014\u00102\u001a\u00020$2\n\u00103\u001a\u00060)j\u0002`*H\u0016J\t\u00104\u001a\u00020$H\bJ\t\u00105\u001a\u00020\u0004H\bJ\u0014\u00106\u001a\u00020\u00042\n\u00107\u001a\u00060 R\u00020\u0000H\u0002J\u000e\u00108\u001a\b\u0018\u00010 R\u00020\u0000H\u0002J\u0014\u00109\u001a\u00020$2\n\u00107\u001a\u00060 R\u00020\u0000H\u0002J$\u0010:\u001a\u00020$2\n\u00107\u001a\u00060 R\u00020\u00002\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0002J\b\u0010=\u001a\u00020$H\u0002J\u0010\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020'H\u0002J\u000e\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u0007J\u0018\u0010B\u001a\u00020\u00042\u0006\u0010?\u001a\u00020'2\u0006\u00101\u001a\u00020\u0019H\u0002J\b\u0010C\u001a\u00020\tH\u0016J\b\u0010D\u001a\u00020\u0019H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\r\u001a\u00020\u00048Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0014\u001a\u00020\u00048Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0018\u00010 R\u00020\u00000\u001fX\u0004¢\u0006\u0004\n\u0002\u0010!¨\u0006H"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "_isTerminated", "Lkotlinx/atomicfu/AtomicInt;", "blockingWorkers", "getBlockingWorkers", "()I", "controlState", "Lkotlinx/atomicfu/AtomicLong;", "cpuPermits", "Ljava/util/concurrent/Semaphore;", "createdWorkers", "getCreatedWorkers", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "isTerminated", "", "()Z", "parkedWorkersStack", "random", "Ljava/util/Random;", "workers", "", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "[Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "state", "close", "", "createNewWorker", "createTask", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "createTask$kotlinx_coroutines_core", "decrementBlockingWorkers", "decrementCreatedWorkers", "dispatch", "fair", "execute", "command", "incrementBlockingWorkers", "incrementCreatedWorkers", "parkedWorkersStackNextIndex", "worker", "parkedWorkersStackPop", "parkedWorkersStackPush", "parkedWorkersStackTopUpdate", "oldIndex", "newIndex", "requestCpuWorker", "runSafely", "task", "shutdown", "timeout", "submitToLocalQueue", "toString", "tryUnpark", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: CoroutineScheduler.kt */
public final class CoroutineScheduler implements Executor, Closeable {
    private static final int ADDED = -1;
    private static final int ADDED_REQUIRES_HELP = 0;
    private static final int ALLOWED = 0;
    private static final long BLOCKING_MASK = 4398044413952L;
    private static final int BLOCKING_SHIFT = 21;
    private static final long CREATED_MASK = 2097151;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int FORBIDDEN = -1;
    /* access modifiers changed from: private */
    public static final int MAX_PARK_TIME_NS;
    /* access modifiers changed from: private */
    public static final int MAX_SPINS;
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    /* access modifiers changed from: private */
    public static final int MAX_YIELDS;
    /* access modifiers changed from: private */
    public static final int MIN_PARK_TIME_NS;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    private static final int NOT_ADDED = 1;
    /* access modifiers changed from: private */
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    private static final long PARKED_INDEX_MASK = 2097151;
    private static final long PARKED_VERSION_INC = 2097152;
    private static final long PARKED_VERSION_MASK = -2097152;
    private static final int TERMINATED = 1;
    private static final AtomicIntegerFieldUpdater _isTerminated$FU;
    static final AtomicLongFieldUpdater controlState$FU;
    private static final AtomicLongFieldUpdater parkedWorkersStack$FU;
    private volatile int _isTerminated;
    volatile long controlState;
    /* access modifiers changed from: private */
    public final int corePoolSize;
    /* access modifiers changed from: private */
    public final Semaphore cpuPermits;
    /* access modifiers changed from: private */
    public final GlobalQueue globalQueue;
    /* access modifiers changed from: private */
    public final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;
    private volatile long parkedWorkersStack;
    /* access modifiers changed from: private */
    public final Random random;
    /* access modifiers changed from: private */
    public final String schedulerName;
    /* access modifiers changed from: private */
    public final Worker[] workers;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.RETIRING.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "RETIRING", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: CoroutineScheduler.kt */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        RETIRING,
        TERMINATED
    }

    public CoroutineScheduler(int corePoolSize2, int maxPoolSize2, long idleWorkerKeepAliveNs2, String schedulerName2) {
        Intrinsics.checkParameterIsNotNull(schedulerName2, "schedulerName");
        this.corePoolSize = corePoolSize2;
        this.maxPoolSize = maxPoolSize2;
        this.idleWorkerKeepAliveNs = idleWorkerKeepAliveNs2;
        this.schedulerName = schedulerName2;
        boolean z = true;
        if (corePoolSize2 >= 1) {
            if (maxPoolSize2 >= corePoolSize2) {
                if (maxPoolSize2 <= 2097150) {
                    if (idleWorkerKeepAliveNs2 <= 0 ? false : z) {
                        this.globalQueue = new GlobalQueue();
                        this.cpuPermits = new Semaphore(corePoolSize2, false);
                        this.parkedWorkersStack = 0;
                        this.workers = new Worker[(maxPoolSize2 + 1)];
                        this.controlState = 0;
                        this.random = new Random();
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + idleWorkerKeepAliveNs2 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + maxPoolSize2 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + maxPoolSize2 + " should be greater than or equals to core pool size " + corePoolSize2).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + corePoolSize2 + " should be at least 1").toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? TasksKt.IDLE_WORKER_KEEP_ALIVE_NS : j, (i3 & 8) != 0 ? TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }

    /* access modifiers changed from: private */
    public final void parkedWorkersStackTopUpdate(Worker worker, int oldIndex, int newIndex) {
        int i;
        while (true) {
            long top = this.parkedWorkersStack;
            int index = (int) (2097151 & top);
            long updVersion = (PARKED_VERSION_INC + top) & PARKED_VERSION_MASK;
            if (index != oldIndex) {
                i = index;
            } else if (newIndex == 0) {
                i = parkedWorkersStackNextIndex(worker);
            } else {
                i = newIndex;
            }
            int updIndex = i;
            if (updIndex >= 0) {
                if (parkedWorkersStack$FU.compareAndSet(this, top, updVersion | ((long) updIndex))) {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void parkedWorkersStackPush(Worker worker) {
        long top;
        long updVersion;
        int updIndex;
        if (worker.getNextParkedWorker() == NOT_IN_STACK) {
            do {
                top = this.parkedWorkersStack;
                int index = (int) (2097151 & top);
                updVersion = (PARKED_VERSION_INC + top) & PARKED_VERSION_MASK;
                updIndex = worker.getIndexInArray();
                if (updIndex != 0) {
                    worker.setNextParkedWorker(this.workers[index]);
                } else {
                    throw new AssertionError("Assertion failed");
                }
            } while (!parkedWorkersStack$FU.compareAndSet(this, top, updVersion | ((long) updIndex)));
        }
    }

    private final Worker parkedWorkersStackPop() {
        while (true) {
            long top = this.parkedWorkersStack;
            Worker worker = this.workers[(int) (2097151 & top)];
            if (worker == null) {
                return null;
            }
            Worker worker2 = worker;
            long updVersion = (PARKED_VERSION_INC + top) & PARKED_VERSION_MASK;
            int updIndex = parkedWorkersStackNextIndex(worker2);
            if (updIndex >= 0) {
                int i = updIndex;
                if (parkedWorkersStack$FU.compareAndSet(this, top, updVersion | ((long) updIndex))) {
                    worker2.setNextParkedWorker(NOT_IN_STACK);
                    return worker2;
                }
            }
        }
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object next = worker.getNextParkedWorker();
        while (next != NOT_IN_STACK) {
            if (next == null) {
                return 0;
            }
            Worker nextWorker = (Worker) next;
            int updIndex = nextWorker.getIndexInArray();
            if (updIndex != 0) {
                return updIndex;
            }
            next = nextWorker.getNextParkedWorker();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final int getCreatedWorkers() {
        return (int) (this.controlState & 2097151);
    }

    private final int getBlockingWorkers() {
        return (int) ((this.controlState & BLOCKING_MASK) >> 21);
    }

    /* access modifiers changed from: private */
    public final int createdWorkers(long state) {
        return (int) (2097151 & state);
    }

    private final int blockingWorkers(long state) {
        return (int) ((BLOCKING_MASK & state) >> 21);
    }

    private final int incrementCreatedWorkers() {
        return (int) (2097151 & controlState$FU.incrementAndGet(this));
    }

    /* access modifiers changed from: private */
    public final int decrementCreatedWorkers() {
        return (int) (2097151 & controlState$FU.getAndDecrement(this));
    }

    /* access modifiers changed from: private */
    public final void incrementBlockingWorkers() {
        controlState$FU.addAndGet(this, PARKED_VERSION_INC);
    }

    /* access modifiers changed from: private */
    public final void decrementBlockingWorkers() {
        controlState$FU.addAndGet(this, PARKED_VERSION_MASK);
    }

    /* access modifiers changed from: private */
    public final boolean isTerminated() {
        return this._isTerminated != 0;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u000e\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0002R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "ADDED", "", "ADDED_REQUIRES_HELP", "ALLOWED", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "CREATED_MASK", "FORBIDDEN", "MAX_PARK_TIME_NS", "MAX_PARK_TIME_NS$annotations", "MAX_SPINS", "MAX_SUPPORTED_POOL_SIZE", "MAX_YIELDS", "MIN_PARK_TIME_NS", "MIN_PARK_TIME_NS$annotations", "MIN_SUPPORTED_POOL_SIZE", "NOT_ADDED", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: CoroutineScheduler.kt */
    public static final class Companion {
        @JvmStatic
        private static /* synthetic */ void MAX_PARK_TIME_NS$annotations() {
        }

        @JvmStatic
        private static /* synthetic */ void MIN_PARK_TIME_NS$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    static {
        Class<CoroutineScheduler> cls = CoroutineScheduler.class;
        int systemProp$default = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.spins", 1000, 1, 0, 8, (Object) null);
        MAX_SPINS = systemProp$default;
        MAX_YIELDS = systemProp$default + SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.yields", 0, 0, 0, 8, (Object) null);
        int nanos = (int) TimeUnit.SECONDS.toNanos(1);
        MAX_PARK_TIME_NS = nanos;
        MIN_PARK_TIME_NS = (int) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(TasksKt.WORK_STEALING_TIME_RESOLUTION_NS / ((long) 4), 10), (long) nanos);
        parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack");
        controlState$FU = AtomicLongFieldUpdater.newUpdater(cls, "controlState");
        _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated");
    }

    public void execute(Runnable command) {
        Intrinsics.checkParameterIsNotNull(command, "command");
        dispatch$default(this, command, (TaskContext) null, false, 6, (Object) null);
    }

    public void close() {
        shutdown(10000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
        if (r4 != null) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void shutdown(long r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = _isTerminated$FU
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r12, r1, r2)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r3 = r0 instanceof kotlinx.coroutines.scheduling.CoroutineScheduler.Worker
            if (r3 != 0) goto L_0x0014
            r0 = 0
        L_0x0014:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r0 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r0
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r3 = r12.workers
            r4 = 0
            monitor-enter(r3)
            r5 = 0
            r6 = r12
            r7 = 0
            long r8 = r6.controlState     // Catch:{ all -> 0x00c4 }
            r10 = 2097151(0x1fffff, double:1.0361303E-317)
            long r8 = r8 & r10
            int r6 = (int) r8
            monitor-exit(r3)
            r3 = r6
            if (r2 > r3) goto L_0x0082
            r4 = r2
        L_0x002b:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r5 = r12.workers
            r5 = r5[r4]
            if (r5 != 0) goto L_0x0034
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0034:
            if (r5 == r0) goto L_0x007d
        L_0x0036:
            boolean r6 = r5.isAlive()
            if (r6 == 0) goto L_0x0046
            r6 = r5
            java.lang.Thread r6 = (java.lang.Thread) r6
            java.util.concurrent.locks.LockSupport.unpark(r6)
            r5.join(r13)
            goto L_0x0036
        L_0x0046:
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r6 = r5.getState()
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            if (r6 != r7) goto L_0x0050
            r7 = r2
            goto L_0x0051
        L_0x0050:
            r7 = r1
        L_0x0051:
            if (r7 == 0) goto L_0x005d
            kotlinx.coroutines.scheduling.WorkQueue r7 = r5.getLocalQueue()
            kotlinx.coroutines.scheduling.GlobalQueue r8 = r12.globalQueue
            r7.offloadAllWork$kotlinx_coroutines_core(r8)
            goto L_0x007d
        L_0x005d:
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "Expected TERMINATED state, but found "
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r1 = r2.toString()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        L_0x007d:
            if (r4 == r3) goto L_0x0082
            int r4 = r4 + 1
            goto L_0x002b
        L_0x0082:
            kotlinx.coroutines.scheduling.GlobalQueue r4 = r12.globalQueue
            r4.close()
        L_0x0087:
            if (r0 == 0) goto L_0x0091
            kotlinx.coroutines.scheduling.Task r4 = r0.findTask$kotlinx_coroutines_core()
            if (r4 == 0) goto L_0x0091
            goto L_0x0099
        L_0x0091:
            kotlinx.coroutines.scheduling.GlobalQueue r4 = r12.globalQueue
            java.lang.Object r4 = r4.removeFirstOrNull()
            kotlinx.coroutines.scheduling.Task r4 = (kotlinx.coroutines.scheduling.Task) r4
        L_0x0099:
            if (r4 == 0) goto L_0x009f
            r12.runSafely(r4)
            goto L_0x0087
        L_0x009f:
            if (r0 == 0) goto L_0x00a6
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r4 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.tryReleaseCpu$kotlinx_coroutines_core(r4)
        L_0x00a6:
            java.util.concurrent.Semaphore r4 = r12.cpuPermits
            int r4 = r4.availablePermits()
            int r5 = r12.corePoolSize
            if (r4 != r5) goto L_0x00b1
            r1 = r2
        L_0x00b1:
            if (r1 == 0) goto L_0x00ba
            r1 = 0
            r12.parkedWorkersStack = r1
            r12.controlState = r1
            return
        L_0x00ba:
            java.lang.String r1 = "Assertion failed"
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>(r1)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        L_0x00c4:
            r1 = move-exception
            monitor-exit(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.shutdown(long):void");
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            taskContext = NonBlockingContext.INSTANCE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z);
    }

    public final void dispatch(Runnable block, TaskContext taskContext, boolean fair) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        Intrinsics.checkParameterIsNotNull(taskContext, "taskContext");
        TimeSourceKt.getTimeSource().trackTask();
        Task task = createTask$kotlinx_coroutines_core(block, taskContext);
        int submitToLocalQueue = submitToLocalQueue(task, fair);
        if (submitToLocalQueue == -1) {
            return;
        }
        if (submitToLocalQueue != 1) {
            requestCpuWorker();
        } else if (this.globalQueue.addLast(task)) {
            requestCpuWorker();
        } else {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
    }

    public final Task createTask$kotlinx_coroutines_core(Runnable block, TaskContext taskContext) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        Intrinsics.checkParameterIsNotNull(taskContext, "taskContext");
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (!(block instanceof Task)) {
            return new TaskImpl(block, nanoTime, taskContext);
        }
        ((Task) block).submissionTime = nanoTime;
        ((Task) block).taskContext = taskContext;
        return (Task) block;
    }

    /* access modifiers changed from: private */
    public final void requestCpuWorker() {
        if (this.cpuPermits.availablePermits() == 0) {
            tryUnpark();
        } else if (!tryUnpark()) {
            long state = this.controlState;
            if (((int) (2097151 & state)) - ((int) ((BLOCKING_MASK & state) >> 21)) < this.corePoolSize) {
                int newCpuWorkers = createNewWorker();
                if (newCpuWorkers == 1 && this.corePoolSize > 1) {
                    createNewWorker();
                }
                if (newCpuWorkers > 0) {
                    return;
                }
            }
            tryUnpark();
        }
    }

    private final boolean tryUnpark() {
        while (true) {
            Worker worker = parkedWorkersStackPop();
            if (worker == null) {
                return false;
            }
            worker.idleResetBeforeUnpark();
            boolean wasParking = worker.isParking();
            LockSupport.unpark(worker);
            if (wasParking && worker.tryForbidTermination()) {
                return true;
            }
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 20 */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009d, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int createNewWorker() {
        /*
            r20 = this;
            r1 = r20
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r2 = r1.workers
            r3 = 0
            monitor-enter(r2)
            r0 = 0
            boolean r4 = r20.isTerminated()     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x0010
            r0 = -1
            monitor-exit(r2)
            return r0
        L_0x0010:
            long r4 = r1.controlState     // Catch:{ all -> 0x009f }
            r6 = r20
            r7 = 0
            r8 = 2097151(0x1fffff, double:1.0361303E-317)
            long r10 = r4 & r8
            int r6 = (int) r10     // Catch:{ all -> 0x009f }
            r7 = r20
            r10 = 0
            r11 = 4398044413952(0x3ffffe00000, double:2.1729226538177E-311)
            long r11 = r11 & r4
            r13 = 21
            long r11 = r11 >> r13
            int r7 = (int) r11     // Catch:{ all -> 0x009f }
            int r10 = r6 - r7
            int r11 = r1.corePoolSize     // Catch:{ all -> 0x009f }
            r12 = 0
            if (r10 < r11) goto L_0x0033
            monitor-exit(r2)
            return r12
        L_0x0033:
            int r11 = r1.maxPoolSize     // Catch:{ all -> 0x009f }
            if (r6 >= r11) goto L_0x009c
            java.util.concurrent.Semaphore r11 = r1.cpuPermits     // Catch:{ all -> 0x009f }
            int r11 = r11.availablePermits()     // Catch:{ all -> 0x009f }
            if (r11 != 0) goto L_0x0040
            goto L_0x009c
        L_0x0040:
            r11 = r20
            r13 = 0
            long r14 = r11.controlState     // Catch:{ all -> 0x009f }
            long r14 = r14 & r8
            int r11 = (int) r14     // Catch:{ all -> 0x009f }
            r13 = 1
            int r11 = r11 + r13
            if (r11 <= 0) goto L_0x0053
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r14 = r1.workers     // Catch:{ all -> 0x009f }
            r14 = r14[r11]     // Catch:{ all -> 0x009f }
            if (r14 != 0) goto L_0x0053
            r14 = r13
            goto L_0x0054
        L_0x0053:
            r14 = r12
        L_0x0054:
            if (r14 == 0) goto L_0x008e
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r14 = new kotlinx.coroutines.scheduling.CoroutineScheduler$Worker     // Catch:{ all -> 0x009f }
            r14.<init>(r1, r11)     // Catch:{ all -> 0x009f }
            r15 = r14
            r16 = 0
            r15.start()     // Catch:{ all -> 0x009f }
            r15 = r20
            r16 = 0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r12 = controlState$FU     // Catch:{ all -> 0x009f }
            long r17 = r12.incrementAndGet(r15)     // Catch:{ all -> 0x009f }
            r12 = r15
            r19 = 0
            long r8 = r17 & r8
            int r8 = (int) r8     // Catch:{ all -> 0x009f }
            if (r11 != r8) goto L_0x0076
            r12 = r13
            goto L_0x0077
        L_0x0076:
            r12 = 0
        L_0x0077:
            if (r12 == 0) goto L_0x0080
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r8 = r1.workers     // Catch:{ all -> 0x009f }
            r8[r11] = r14     // Catch:{ all -> 0x009f }
            int r10 = r10 + r13
            monitor-exit(r2)
            return r10
        L_0x0080:
            java.lang.String r8 = "Failed requirement."
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x009f }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x009f }
            r9.<init>(r8)     // Catch:{ all -> 0x009f }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x009f }
            throw r9     // Catch:{ all -> 0x009f }
        L_0x008e:
            java.lang.String r8 = "Failed requirement."
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x009f }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x009f }
            r9.<init>(r8)     // Catch:{ all -> 0x009f }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x009f }
            throw r9     // Catch:{ all -> 0x009f }
        L_0x009c:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x009f:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.createNewWorker():int");
    }

    private final int submitToLocalQueue(Task task, boolean fair) {
        boolean noOffloadingHappened;
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof Worker)) {
            currentThread = null;
        }
        Worker worker = (Worker) currentThread;
        if (worker == null || worker.getScheduler() != this || worker.getState() == WorkerState.TERMINATED) {
            return 1;
        }
        int result = -1;
        if (task.getMode() == TaskMode.NON_BLOCKING) {
            if (worker.isBlocking()) {
                result = 0;
            } else if (!worker.tryAcquireCpuPermit()) {
                return 1;
            }
        }
        if (fair) {
            noOffloadingHappened = worker.getLocalQueue().addLast(task, this.globalQueue);
        } else {
            noOffloadingHappened = worker.getLocalQueue().add(task, this.globalQueue);
        }
        if (!noOffloadingHappened || worker.getLocalQueue().getBufferSize$kotlinx_coroutines_core() > TasksKt.QUEUE_SIZE_OFFLOAD_THRESHOLD) {
            return 0;
        }
        return result;
    }

    public String toString() {
        int parkedWorkers = 0;
        int blockingWorkers = 0;
        int cpuWorkers = 0;
        int retired = 0;
        int terminated = 0;
        ArrayList queueSizes = new ArrayList();
        for (Worker worker : this.workers) {
            if (worker != null) {
                int queueSize = worker.getLocalQueue().size$kotlinx_coroutines_core();
                int i = WhenMappings.$EnumSwitchMapping$0[worker.getState().ordinal()];
                if (i == 1) {
                    parkedWorkers++;
                } else if (i == 2) {
                    blockingWorkers++;
                    queueSizes.add(String.valueOf(queueSize) + "b");
                } else if (i == 3) {
                    cpuWorkers++;
                    queueSizes.add(String.valueOf(queueSize) + "c");
                } else if (i == 4) {
                    retired++;
                    if (queueSize > 0) {
                        queueSizes.add(String.valueOf(queueSize) + "r");
                    }
                } else if (i == 5) {
                    terminated++;
                }
            }
        }
        long state = this.controlState;
        return this.schedulerName + '@' + DebugKt.getHexAddress(this) + '[' + "Pool Size {" + "core = " + this.corePoolSize + ", " + "max = " + this.maxPoolSize + "}, " + "Worker States {" + "CPU = " + cpuWorkers + ", " + "blocking = " + blockingWorkers + ", " + "parked = " + parkedWorkers + ", " + "retired = " + retired + ", " + "terminated = " + terminated + "}, " + "running workers queues = " + queueSizes + ", " + "global queue size = " + this.globalQueue.getSize() + ", " + "Control State Workers {" + "created = " + ((int) (2097151 & state)) + ", " + "blocking = " + ((int) ((BLOCKING_MASK & state) >> 21)) + '}' + "]";
    }

    /* access modifiers changed from: private */
    public final void runSafely(Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            TimeSourceKt.getTimeSource().unTrackTask();
            throw th;
        }
        TimeSourceKt.getTimeSource().unTrackTask();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00100\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00101\u001a\u00020\u0010H\u0002J\b\u00102\u001a\u00020\fH\u0002J\b\u00103\u001a\u00020-H\u0002J\b\u00104\u001a\u00020-H\u0002J\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0010H\u0002J\u000f\u00107\u001a\u0004\u0018\u000108H\u0000¢\u0006\u0002\b9J\n\u0010:\u001a\u0004\u0018\u000108H\u0002J\u0010\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020/H\u0002J\u0006\u0010=\u001a\u00020-J\u0015\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0003H\u0000¢\u0006\u0002\b@J\b\u0010A\u001a\u00020-H\u0016J\u0006\u0010B\u001a\u00020\fJ\u0006\u0010C\u001a\u00020\fJ\u0015\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020$H\u0000¢\u0006\u0002\bFJ\n\u0010G\u001a\u0004\u0018\u000108H\u0002J\b\u0010H\u001a\u00020-H\u0002R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "isBlocking", "", "()Z", "isParking", "lastExhaustionTime", "", "lastStealIndex", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "getLocalQueue", "()Lkotlinx/coroutines/scheduling/WorkQueue;", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "parkTimeNs", "rngState", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "spins", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "getState", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "setState", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)V", "terminationDeadline", "terminationState", "Lkotlinx/atomicfu/AtomicInt;", "afterTask", "", "taskMode", "Lkotlinx/coroutines/scheduling/TaskMode;", "beforeTask", "taskSubmissionTime", "blockingQuiescence", "blockingWorkerIdle", "cpuWorkerIdle", "doPark", "nanos", "findTask", "Lkotlinx/coroutines/scheduling/Task;", "findTask$kotlinx_coroutines_core", "findTaskWithCpuPermit", "idleReset", "mode", "idleResetBeforeUnpark", "nextInt", "upperBound", "nextInt$kotlinx_coroutines_core", "run", "tryAcquireCpuPermit", "tryForbidTermination", "tryReleaseCpu", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "trySteal", "tryTerminateWorker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: CoroutineScheduler.kt */
    public final class Worker extends Thread {
        private static final AtomicIntegerFieldUpdater terminationState$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "terminationState");
        private volatile int indexInArray;
        private long lastExhaustionTime;
        private int lastStealIndex;
        private final WorkQueue localQueue;
        private volatile Object nextParkedWorker;
        private int parkTimeNs;
        private int rngState;
        private volatile int spins;
        private volatile WorkerState state;
        private long terminationDeadline;
        private volatile int terminationState;

        private Worker() {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.state = WorkerState.RETIRING;
            this.terminationState = 0;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.parkTimeNs = CoroutineScheduler.MIN_PARK_TIME_NS;
            this.rngState = CoroutineScheduler.this.random.nextInt();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final void setIndexInArray(int index) {
            setName(CoroutineScheduler.this.schedulerName + "-worker-" + (index == 0 ? "TERMINATED" : String.valueOf(index)));
            this.indexInArray = index;
        }

        public Worker(CoroutineScheduler $outer, int index) {
            this();
            setIndexInArray(index);
        }

        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final WorkQueue getLocalQueue() {
            return this.localQueue;
        }

        public final WorkerState getState() {
            return this.state;
        }

        public final void setState(WorkerState workerState) {
            Intrinsics.checkParameterIsNotNull(workerState, "<set-?>");
            this.state = workerState;
        }

        public final boolean isParking() {
            return this.state == WorkerState.PARKING;
        }

        public final boolean isBlocking() {
            return this.state == WorkerState.BLOCKING;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryForbidTermination() {
            int state2 = this.terminationState;
            if (state2 == -1) {
                return false;
            }
            if (state2 == 0) {
                return terminationState$FU.compareAndSet(this, 0, -1);
            }
            if (state2 == 1) {
                return false;
            }
            throw new IllegalStateException(("Invalid terminationState = " + state2).toString());
        }

        public final boolean tryAcquireCpuPermit() {
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            if (!CoroutineScheduler.this.cpuPermits.tryAcquire()) {
                return false;
            }
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final boolean tryReleaseCpu$kotlinx_coroutines_core(WorkerState newState) {
            Intrinsics.checkParameterIsNotNull(newState, "newState");
            WorkerState previousState = this.state;
            boolean hadCpu = previousState == WorkerState.CPU_ACQUIRED;
            if (hadCpu) {
                CoroutineScheduler.this.cpuPermits.release();
            }
            if (previousState != newState) {
                this.state = newState;
            }
            return hadCpu;
        }

        public void run() {
            boolean wasIdle = false;
            while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                Task task = findTask$kotlinx_coroutines_core();
                if (task == null) {
                    if (this.state == WorkerState.CPU_ACQUIRED) {
                        cpuWorkerIdle();
                    } else {
                        blockingWorkerIdle();
                    }
                    wasIdle = true;
                } else {
                    TaskMode taskMode = task.getMode();
                    if (wasIdle) {
                        idleReset(taskMode);
                        wasIdle = false;
                    }
                    beforeTask(taskMode, task.submissionTime);
                    CoroutineScheduler.this.runSafely(task);
                    afterTask(taskMode);
                }
            }
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.TERMINATED);
        }

        private final void beforeTask(TaskMode taskMode, long taskSubmissionTime) {
            if (taskMode != TaskMode.NON_BLOCKING) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, CoroutineScheduler.PARKED_VERSION_INC);
                if (tryReleaseCpu$kotlinx_coroutines_core(WorkerState.BLOCKING)) {
                    CoroutineScheduler.this.requestCpuWorker();
                }
            } else if (CoroutineScheduler.this.cpuPermits.availablePermits() != 0) {
                long now = TasksKt.schedulerTimeSource.nanoTime();
                if (now - taskSubmissionTime >= TasksKt.WORK_STEALING_TIME_RESOLUTION_NS && now - this.lastExhaustionTime >= TasksKt.WORK_STEALING_TIME_RESOLUTION_NS * ((long) 5)) {
                    this.lastExhaustionTime = now;
                    CoroutineScheduler.this.requestCpuWorker();
                }
            }
        }

        private final void afterTask(TaskMode taskMode) {
            if (taskMode != TaskMode.NON_BLOCKING) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, CoroutineScheduler.PARKED_VERSION_MASK);
                WorkerState currentState = this.state;
                if (currentState != WorkerState.TERMINATED) {
                    if (currentState == WorkerState.BLOCKING) {
                        this.state = WorkerState.RETIRING;
                        return;
                    }
                    throw new AssertionError("Expected BLOCKING state, but has " + currentState);
                }
            }
        }

        public final int nextInt$kotlinx_coroutines_core(int upperBound) {
            int i = this.rngState;
            int i2 = i ^ (i << 13);
            this.rngState = i2;
            int i3 = i2 ^ (i2 >> 17);
            this.rngState = i3;
            int i4 = i3 ^ (i3 << 5);
            this.rngState = i4;
            int mask = upperBound - 1;
            if ((mask & upperBound) == 0) {
                return i4 & mask;
            }
            return (i4 & Integer.MAX_VALUE) % upperBound;
        }

        private final void cpuWorkerIdle() {
            int spins2 = this.spins;
            if (spins2 <= CoroutineScheduler.MAX_YIELDS) {
                this.spins = spins2 + 1;
                if (spins2 >= CoroutineScheduler.MAX_SPINS) {
                    Thread.yield();
                    return;
                }
                return;
            }
            if (this.parkTimeNs < CoroutineScheduler.MAX_PARK_TIME_NS) {
                this.parkTimeNs = RangesKt.coerceAtMost((this.parkTimeNs * 3) >>> 1, CoroutineScheduler.MAX_PARK_TIME_NS);
            }
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
            doPark((long) this.parkTimeNs);
        }

        private final void blockingWorkerIdle() {
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
            if (blockingQuiescence()) {
                this.terminationState = 0;
                if (this.terminationDeadline == 0) {
                    this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
                }
                if (doPark(CoroutineScheduler.this.idleWorkerKeepAliveNs) && System.nanoTime() - this.terminationDeadline >= 0) {
                    this.terminationDeadline = 0;
                    tryTerminateWorker();
                }
            }
        }

        private final boolean doPark(long nanos) {
            CoroutineScheduler.this.parkedWorkersStackPush(this);
            if (!blockingQuiescence()) {
                return false;
            }
            LockSupport.parkNanos(nanos);
            return true;
        }

        private final void tryTerminateWorker() {
            synchronized (CoroutineScheduler.this.workers) {
                if (!CoroutineScheduler.this.isTerminated()) {
                    if (CoroutineScheduler.this.getCreatedWorkers() > CoroutineScheduler.this.corePoolSize) {
                        if (blockingQuiescence()) {
                            if (terminationState$FU.compareAndSet(this, 0, 1)) {
                                int oldIndex = this.indexInArray;
                                setIndexInArray(0);
                                CoroutineScheduler.this.parkedWorkersStackTopUpdate(this, oldIndex, 0);
                                CoroutineScheduler this_$iv = CoroutineScheduler.this;
                                CoroutineScheduler coroutineScheduler = this_$iv;
                                int lastIndex = (int) (2097151 & CoroutineScheduler.controlState$FU.getAndDecrement(this_$iv));
                                if (lastIndex != oldIndex) {
                                    Worker lastWorker = CoroutineScheduler.this.workers[lastIndex];
                                    if (lastWorker == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    CoroutineScheduler.this.workers[oldIndex] = lastWorker;
                                    lastWorker.setIndexInArray(oldIndex);
                                    CoroutineScheduler.this.parkedWorkersStackTopUpdate(lastWorker, lastIndex, oldIndex);
                                }
                                CoroutineScheduler.this.workers[lastIndex] = null;
                                Unit unit = Unit.INSTANCE;
                                this.state = WorkerState.TERMINATED;
                            }
                        }
                    }
                }
            }
        }

        private final boolean blockingQuiescence() {
            Task it = CoroutineScheduler.this.globalQueue.removeFirstWithModeOrNull(TaskMode.PROBABLY_BLOCKING);
            if (it == null) {
                return true;
            }
            this.localQueue.add(it, CoroutineScheduler.this.globalQueue);
            return false;
        }

        private final void idleReset(TaskMode mode) {
            this.terminationDeadline = 0;
            this.lastStealIndex = 0;
            if (this.state == WorkerState.PARKING) {
                if (mode == TaskMode.PROBABLY_BLOCKING) {
                    this.state = WorkerState.BLOCKING;
                    this.parkTimeNs = CoroutineScheduler.MIN_PARK_TIME_NS;
                } else {
                    throw new AssertionError("Assertion failed");
                }
            }
            this.spins = 0;
        }

        public final void idleResetBeforeUnpark() {
            this.parkTimeNs = CoroutineScheduler.MIN_PARK_TIME_NS;
            this.spins = 0;
        }

        public final Task findTask$kotlinx_coroutines_core() {
            if (tryAcquireCpuPermit()) {
                return findTaskWithCpuPermit();
            }
            Task poll = this.localQueue.poll();
            return poll != null ? poll : CoroutineScheduler.this.globalQueue.removeFirstWithModeOrNull(TaskMode.PROBABLY_BLOCKING);
        }

        private final Task findTaskWithCpuPermit() {
            Task it;
            Task it2;
            boolean globalFirst = nextInt$kotlinx_coroutines_core(CoroutineScheduler.this.corePoolSize * 2) == 0;
            if (globalFirst && (it2 = CoroutineScheduler.this.globalQueue.removeFirstWithModeOrNull(TaskMode.NON_BLOCKING)) != null) {
                return it2;
            }
            Task it3 = this.localQueue.poll();
            if (it3 != null) {
                return it3;
            }
            if (globalFirst || (it = (Task) CoroutineScheduler.this.globalQueue.removeFirstOrNull()) == null) {
                return trySteal();
            }
            return it;
        }

        private final Task trySteal() {
            int created = CoroutineScheduler.this.getCreatedWorkers();
            if (created < 2) {
                return null;
            }
            int stealIndex = this.lastStealIndex;
            if (stealIndex == 0) {
                stealIndex = nextInt$kotlinx_coroutines_core(created);
            }
            int stealIndex2 = stealIndex + 1;
            if (stealIndex2 > created) {
                stealIndex2 = 1;
            }
            this.lastStealIndex = stealIndex2;
            Worker worker = CoroutineScheduler.this.workers[stealIndex2];
            if (worker == null || worker == this || !this.localQueue.trySteal(worker.localQueue, CoroutineScheduler.this.globalQueue)) {
                return null;
            }
            return this.localQueue.poll();
        }
    }
}
