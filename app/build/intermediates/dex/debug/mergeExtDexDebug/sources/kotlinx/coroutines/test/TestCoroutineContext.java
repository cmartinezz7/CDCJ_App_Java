package kotlinx.coroutines.test;

import com.santander.globile.uicomponents.errorhandling.common.ConstantsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001<B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0019J$\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0 J$\u0010\"\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0 J*\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\u0018\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020!0 J$\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0 J\u0006\u0010%\u001a\u00020\u001bJ\u0014\u0010&\u001a\u00020\u001b2\n\u0010'\u001a\u00060(j\u0002`)H\u0002J5\u0010*\u001a\u0002H+\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001a\u0002H+2\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002H+0.H\u0016¢\u0006\u0002\u00100J(\u00101\u001a\u0004\u0018\u0001H2\"\b\b\u0000\u00102*\u00020/2\f\u00103\u001a\b\u0012\u0004\u0012\u0002H204H\u0002¢\u0006\u0002\u00105J\u0014\u00106\u001a\u00020\u00012\n\u00103\u001a\u0006\u0012\u0002\b\u000304H\u0016J\u0010\u00107\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u001c\u00108\u001a\u00020\u00122\n\u0010'\u001a\u00060(j\u0002`)2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u00109\u001a\u00020\u0006H\u0002J\b\u0010:\u001a\u00020\u0003H\u0016J\u0006\u0010;\u001a\u00020\u001bJ\u0010\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lkotlinx/coroutines/test/TestCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "name", "", "(Ljava/lang/String;)V", "counter", "", "ctxDispatcher", "Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "ctxHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptions", "", "", "getExceptions", "()Ljava/util/List;", "queue", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/test/TimedRunnable;", "time", "uncaughtExceptions", "", "advanceTimeBy", "delayTime", "unit", "Ljava/util/concurrent/TimeUnit;", "advanceTimeTo", "", "targetTime", "assertAllUnhandledExceptions", "message", "predicate", "Lkotlin/Function1;", "", "assertAnyUnhandledException", "assertExceptions", "assertUnhandledException", "cancelAllActions", "enqueue", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "now", "postDelayed", "processNextEvent", "toString", "triggerActions", "Dispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: TestCoroutineContext.kt */
public final class TestCoroutineContext implements CoroutineContext {
    private long counter;
    private final Dispatcher ctxDispatcher;
    private final CoroutineExceptionHandler ctxHandler;
    private final String name;
    /* access modifiers changed from: private */
    public final ThreadSafeHeap<TimedRunnable> queue;
    private long time;
    /* access modifiers changed from: private */
    public final List<Throwable> uncaughtExceptions;

    public TestCoroutineContext() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public TestCoroutineContext(String name2) {
        this.name = name2;
        this.uncaughtExceptions = new ArrayList();
        this.ctxDispatcher = new Dispatcher();
        this.ctxHandler = new TestCoroutineContext$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
        this.queue = new ThreadSafeHeap<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TestCoroutineContext(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public CoroutineContext plus(CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return CoroutineContext.DefaultImpls.plus(this, context);
    }

    public final List<Throwable> getExceptions() {
        return this.uncaughtExceptions;
    }

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        return operation.invoke(operation.invoke(initial, this.ctxDispatcher), this.ctxHandler);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (key == ContinuationInterceptor.Key) {
            E e = this.ctxDispatcher;
            if (e != null) {
                return (CoroutineContext.Element) e;
            }
            throw new TypeCastException("null cannot be cast to non-null type E");
        } else if (key != CoroutineExceptionHandler.Key) {
            return null;
        } else {
            E e2 = this.ctxHandler;
            if (e2 != null) {
                return (CoroutineContext.Element) e2;
            }
            throw new TypeCastException("null cannot be cast to non-null type E");
        }
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (key == ContinuationInterceptor.Key) {
            return this.ctxHandler;
        }
        if (key == CoroutineExceptionHandler.Key) {
            return this.ctxDispatcher;
        }
        return this;
    }

    public static /* synthetic */ long now$default(TestCoroutineContext testCoroutineContext, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.now(timeUnit);
    }

    public final long now(TimeUnit unit) {
        Intrinsics.checkParameterIsNotNull(unit, "unit");
        return unit.convert(this.time, TimeUnit.NANOSECONDS);
    }

    public static /* synthetic */ long advanceTimeBy$default(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.advanceTimeBy(j, timeUnit);
    }

    public final long advanceTimeBy(long delayTime, TimeUnit unit) {
        Intrinsics.checkParameterIsNotNull(unit, "unit");
        long oldTime = this.time;
        advanceTimeTo(unit.toNanos(delayTime) + oldTime, TimeUnit.NANOSECONDS);
        return unit.convert(this.time - oldTime, TimeUnit.NANOSECONDS);
    }

    public static /* synthetic */ void advanceTimeTo$default(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        testCoroutineContext.advanceTimeTo(j, timeUnit);
    }

    public final void advanceTimeTo(long targetTime, TimeUnit unit) {
        Intrinsics.checkParameterIsNotNull(unit, "unit");
        long nanoTime = unit.toNanos(targetTime);
        triggerActions(nanoTime);
        if (nanoTime > this.time) {
            this.time = nanoTime;
        }
    }

    public final void triggerActions() {
        triggerActions(this.time);
    }

    public final void cancelAllActions() {
        if (!this.queue.isEmpty()) {
            this.queue.clear();
        }
    }

    public static /* synthetic */ void assertUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertUnhandledException(str, function1);
    }

    public final void assertUnhandledException(String message, Function1<? super Throwable, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(message, ConstantsKt.MESSAGE_TEXT);
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        if (this.uncaughtExceptions.size() != 1 || !predicate.invoke(this.uncaughtExceptions.get(0)).booleanValue()) {
            throw new AssertionError(message);
        }
        this.uncaughtExceptions.clear();
    }

    public static /* synthetic */ void assertAllUnhandledExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAllUnhandledExceptions(str, function1);
    }

    public final void assertAllUnhandledExceptions(String message, Function1<? super Throwable, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(message, ConstantsKt.MESSAGE_TEXT);
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Iterable $receiver$iv = this.uncaughtExceptions;
        boolean z = false;
        if (!($receiver$iv instanceof Collection) || !((Collection) $receiver$iv).isEmpty()) {
            Iterator it = $receiver$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!predicate.invoke(it.next()).booleanValue()) {
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
        } else {
            z = true;
        }
        if (z) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(message);
    }

    public static /* synthetic */ void assertAnyUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAnyUnhandledException(str, function1);
    }

    public final void assertAnyUnhandledException(String message, Function1<? super Throwable, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(message, ConstantsKt.MESSAGE_TEXT);
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Iterable $receiver$iv = this.uncaughtExceptions;
        boolean z = false;
        if (!($receiver$iv instanceof Collection) || !((Collection) $receiver$iv).isEmpty()) {
            Iterator it = $receiver$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (predicate.invoke(it.next()).booleanValue()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(message);
    }

    public static /* synthetic */ void assertExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertExceptions(str, function1);
    }

    public final void assertExceptions(String message, Function1<? super List<? extends Throwable>, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(message, ConstantsKt.MESSAGE_TEXT);
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        if (predicate.invoke(this.uncaughtExceptions).booleanValue()) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(message);
    }

    /* access modifiers changed from: private */
    public final void enqueue(Runnable block) {
        ThreadSafeHeap<TimedRunnable> threadSafeHeap = this.queue;
        long j = this.counter;
        this.counter = 1 + j;
        threadSafeHeap.addLast(new TimedRunnable(block, j, 0, 4, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public final TimedRunnable postDelayed(Runnable block, long delayTime) {
        long j = this.counter;
        this.counter = 1 + j;
        Runnable runnable = block;
        TimedRunnable it = new TimedRunnable(runnable, j, TimeUnit.MILLISECONDS.toNanos(delayTime) + this.time);
        this.queue.addLast(it);
        return it;
    }

    /* access modifiers changed from: private */
    public final long processNextEvent() {
        TimedRunnable current = this.queue.peek();
        if (current != null) {
            triggerActions(current.time);
        }
        if (this.queue.isEmpty()) {
            return LongCompanionObject.MAX_VALUE;
        }
        return 0;
    }

    private final void triggerActions(long targetTime) {
        TimedRunnable timedRunnable;
        while (true) {
            ThreadSafeHeap this_$iv = this.queue;
            synchronized (this_$iv) {
                ThreadSafeHeapNode first$iv = this_$iv.firstImpl();
                timedRunnable = null;
                if (first$iv != null) {
                    if (((TimedRunnable) first$iv).time <= targetTime) {
                        timedRunnable = this_$iv.removeAtImpl(0);
                    }
                }
            }
            TimedRunnable timedRunnable2 = timedRunnable;
            if (timedRunnable2 != null) {
                TimedRunnable current = timedRunnable2;
                if (current.time != 0) {
                    this.time = current.time;
                }
                current.run();
            } else {
                return;
            }
        }
    }

    public String toString() {
        String str = this.name;
        return str != null ? str : "TestCoroutineContext@" + DebugKt.getHexAddress(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/Delay;", "(Lkotlinx/coroutines/test/TestCoroutineContext;)V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "processNextEvent", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldBeProcessedFromContext", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: TestCoroutineContext.kt */
    private final class Dispatcher extends EventLoop implements Delay {
        public Dispatcher() {
            EventLoop.incrementUseCount$default(this, false, 1, (Object) null);
        }

        public Object delay(long time, Continuation<? super Unit> continuation) {
            return Delay.DefaultImpls.delay(this, time, continuation);
        }

        public void dispatch(CoroutineContext context, Runnable block) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(block, "block");
            TestCoroutineContext.this.enqueue(block);
        }

        public boolean shouldBeProcessedFromContext() {
            return true;
        }

        public void scheduleResumeAfterDelay(long timeMillis, CancellableContinuation<? super Unit> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "continuation");
            TimedRunnable unused = TestCoroutineContext.this.postDelayed(new TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1(this, continuation), timeMillis);
        }

        public DisposableHandle invokeOnTimeout(long timeMillis, Runnable block) {
            Intrinsics.checkParameterIsNotNull(block, "block");
            return new TestCoroutineContext$Dispatcher$invokeOnTimeout$1(this, TestCoroutineContext.this.postDelayed(block, timeMillis));
        }

        public long processNextEvent() {
            return TestCoroutineContext.this.processNextEvent();
        }

        public String toString() {
            return "Dispatcher(" + TestCoroutineContext.this + ')';
        }
    }
}
