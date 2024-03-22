package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001d\u0010\u000f\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH&R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate", "()Lkotlin/coroutines/Continuation;", "getExceptionalResult", "", "state", "", "getSuccessfulResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "run", "", "takeState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: Dispatched.kt */
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public abstract Continuation<T> getDelegate();

    public abstract Object takeState();

    public DispatchedTask(int resumeMode2) {
        this.resumeMode = resumeMode2;
    }

    public <T> T getSuccessfulResult(Object state) {
        return state;
    }

    public final Throwable getExceptionalResult(Object state) {
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(state instanceof CompletedExceptionally) ? null : state);
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    /* Debug info: failed to restart local var, previous not found, register: 14 */
    public final void run() {
        CoroutineContext context;
        Object oldValue$iv;
        TaskContext taskContext = this.taskContext;
        try {
            Continuation delegate = getDelegate();
            if (delegate != null) {
                DispatchedContinuation delegate2 = (DispatchedContinuation) delegate;
                Continuation continuation = delegate2.continuation;
                context = continuation.getContext();
                Job job = ResumeModeKt.isCancellableMode(this.resumeMode) ? (Job) context.get(Job.Key) : null;
                Object state = takeState();
                oldValue$iv = ThreadContextKt.updateThreadContext(context, delegate2.countOrElement);
                if (job != null) {
                    if (!job.isActive()) {
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(job.getCancellationException())));
                        Unit unit = Unit.INSTANCE;
                        ThreadContextKt.restoreThreadContext(context, oldValue$iv);
                        taskContext.afterTask();
                        return;
                    }
                }
                Throwable exception = getExceptionalResult(state);
                if (exception != null) {
                    Continuation $receiver$iv = continuation;
                    Result.Companion companion2 = Result.Companion;
                    $receiver$iv.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, $receiver$iv))));
                } else {
                    Object successfulResult = getSuccessfulResult(state);
                    Result.Companion companion3 = Result.Companion;
                    continuation.resumeWith(Result.m5constructorimpl(successfulResult));
                }
                Unit unit2 = Unit.INSTANCE;
                ThreadContextKt.restoreThreadContext(context, oldValue$iv);
                taskContext.afterTask();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
        } catch (Throwable e) {
            try {
                throw new DispatchException("Unexpected exception running " + this, e);
            } catch (Throwable e2) {
                taskContext.afterTask();
                throw e2;
            }
        }
    }
}
