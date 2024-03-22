package kotlinx.coroutines.internal;

import com.santander.globile.uicomponents.errorhandling.common.ConstantsKt;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a9\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0010\u0010\t\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000b0\nH\u0002¢\u0006\u0002\u0010\f\u001a\u001e\u0010\r\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000b0\n2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0002\u001a1\u0010\u0011\u001a\u00020\u00122\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000b0\u00142\u0010\u0010\b\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000b0\nH\u0002¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006HHø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a+\u0010\u001a\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u0002H\u00052\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0002¢\u0006\u0002\u0010\u001b\u001a\u001f\u0010\u001c\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u0002H\u0005H\u0000¢\u0006\u0002\u0010\u001d\u001a+\u0010\u001c\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u0002H\u00052\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0000¢\u0006\u0002\u0010\u001f\u001a\u001f\u0010 \u001a\u00020!\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u0002H\u0005H\u0002¢\u0006\u0002\u0010\"\u001a\u0018\u0010#\u001a\u00060\u0001j\u0002`\u000b2\n\u0010$\u001a\u00060\u0001j\u0002`\u000bH\u0007\u001a\u001f\u0010%\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u0002H\u0005H\u0000¢\u0006\u0002\u0010\u001d\u001a1\u0010&\u001a\u0018\u0012\u0004\u0012\u0002H\u0005\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u000b0\u00140'\"\b\b\u0000\u0010\u0005*\u00020\u0006*\u0002H\u0005H\u0002¢\u0006\u0002\u0010(\u001a\u001c\u0010)\u001a\u00020!*\u00060\u0001j\u0002`\u000b2\n\u0010*\u001a\u00060\u0001j\u0002`\u000bH\u0002\u001a#\u0010+\u001a\u00020,*\f\u0012\b\u0012\u00060\u0001j\u0002`\u000b0\u00142\u0006\u0010-\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010.\u001a\u0010\u0010/\u001a\u00020!*\u00060\u0001j\u0002`\u000bH\u0000\u001a\u001b\u00100\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u0006*\u0002H\u0005H\u0002¢\u0006\u0002\u0010\u001d*\f\b\u0000\u00101\"\u00020\u000f2\u00020\u000f*\f\b\u0000\u00102\"\u00020\u00012\u00020\u0001\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"artificialFrame", "Ljava/lang/StackTraceElement;", "message", "", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "recoveryDisabled", "", "(Ljava/lang/Throwable;)Z", "sanitize", "element", "unwrap", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: StackTraceRecovery.kt */
public final class StackTraceRecoveryKt {
    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    public static final <E extends Throwable> E recoverStackTrace(E exception) {
        Throwable copy;
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (!recoveryDisabled(exception) && (copy = ExceptionsConstuctorKt.tryCopyException(exception)) != null) {
            return sanitizeStackTrace(copy);
        }
        return exception;
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E $receiver) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = $receiver.getStackTrace();
        int size = stackTrace.length;
        Intrinsics.checkExpressionValueIsNotNull(stackTrace, "stackTrace");
        int lastIntrinsic = frameIndex(stackTrace, "kotlinx.coroutines.internal.StackTraceRecoveryKt");
        int startIndex = lastIntrinsic + 1;
        int endIndex = frameIndex(stackTrace, "kotlin.coroutines.jvm.internal.BaseContinuationImpl");
        StackTraceElement[] trace = new StackTraceElement[((size - lastIntrinsic) - (endIndex == -1 ? 0 : size - endIndex))];
        int length = trace.length;
        for (int i$iv = 0; i$iv < length; i$iv++) {
            int it = i$iv;
            if (it == 0) {
                stackTraceElement = artificialFrame("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(startIndex + it) - 1];
            }
            trace[i$iv] = stackTraceElement;
        }
        $receiver.setStackTrace(trace);
        return $receiver;
    }

    public static final <E extends Throwable> E recoverStackTrace(E exception, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        if (recoveryDisabled(exception) || !(continuation instanceof CoroutineStackFrame)) {
            return exception;
        }
        return recoverFromStackFrame(exception, (CoroutineStackFrame) continuation);
    }

    /* access modifiers changed from: private */
    public static final <E extends Throwable> E recoverFromStackFrame(E exception, CoroutineStackFrame continuation) {
        Pair causeAndStacktrace = causeAndStacktrace(exception);
        Throwable cause = (Throwable) causeAndStacktrace.component1();
        StackTraceElement[] recoveredStacktrace = (StackTraceElement[]) causeAndStacktrace.component2();
        Throwable newException = ExceptionsConstuctorKt.tryCopyException(cause);
        if (newException == null) {
            return exception;
        }
        ArrayDeque stacktrace = createStackTrace(continuation);
        if (stacktrace.isEmpty()) {
            return exception;
        }
        if (cause != exception) {
            mergeRecoveredTraces(recoveredStacktrace, stacktrace);
        }
        return createFinalException(cause, newException, stacktrace);
    }

    private static final <E extends Throwable> E createFinalException(E cause, E result, ArrayDeque<StackTraceElement> resultStackTrace) {
        resultStackTrace.addFirst(artificialFrame("Coroutine boundary"));
        StackTraceElement[] causeTrace = cause.getStackTrace();
        Intrinsics.checkExpressionValueIsNotNull(causeTrace, "causeTrace");
        int size = frameIndex(causeTrace, "kotlin.coroutines.jvm.internal.BaseContinuationImpl");
        int index = 0;
        if (size == -1) {
            Collection $receiver$iv = resultStackTrace;
            if ($receiver$iv != null) {
                Object[] array = $receiver$iv.toArray(new StackTraceElement[0]);
                if (array != null) {
                    result.setStackTrace((StackTraceElement[]) array);
                    return result;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        StackTraceElement[] mergedStackTrace = new StackTraceElement[(resultStackTrace.size() + size)];
        for (int i = 0; i < size; i++) {
            mergedStackTrace[i] = causeTrace[i];
        }
        for (StackTraceElement element : resultStackTrace) {
            mergedStackTrace[size + index] = element;
            index++;
        }
        result.setStackTrace(mergedStackTrace);
        return result;
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause == null || !Intrinsics.areEqual((Object) cause.getClass(), (Object) e.getClass())) {
            return TuplesKt.to(e, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e.getStackTrace();
        Intrinsics.checkExpressionValueIsNotNull(stackTrace, "currentTrace");
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            Intrinsics.checkExpressionValueIsNotNull(stackTraceElement, "it");
            if (isArtificial(stackTraceElement)) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            return TuplesKt.to(cause, stackTrace);
        }
        return TuplesKt.to(e, new StackTraceElement[0]);
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] recoveredStacktrace, ArrayDeque<StackTraceElement> result) {
        StackTraceElement[] stackTraceElementArr = recoveredStacktrace;
        int index$iv = 0;
        int length = stackTraceElementArr.length;
        while (true) {
            if (index$iv >= length) {
                index$iv = -1;
                break;
            } else if (isArtificial(stackTraceElementArr[index$iv])) {
                break;
            } else {
                index$iv++;
            }
        }
        int startIndex = index$iv + 1;
        int lastFrameIndex = recoveredStacktrace.length - 1;
        if (lastFrameIndex >= startIndex) {
            int i = lastFrameIndex;
            while (true) {
                StackTraceElement element = recoveredStacktrace[i];
                StackTraceElement last = result.getLast();
                Intrinsics.checkExpressionValueIsNotNull(last, "result.last");
                if (elementWiseEquals(element, last)) {
                    result.removeLast();
                }
                result.addFirst(recoveredStacktrace[i]);
                if (i != startIndex) {
                    i--;
                } else {
                    return;
                }
            }
        }
    }

    public static final Object recoverAndThrow(Throwable exception, Continuation<?> it) {
        if (recoveryDisabled(exception)) {
            throw exception;
        } else if (!(it instanceof CoroutineStackFrame)) {
            throw exception;
        } else {
            throw recoverFromStackFrame(exception, (CoroutineStackFrame) it);
        }
    }

    private static final Object recoverAndThrow$$forInline(Throwable exception, Continuation it) {
        if (!recoveryDisabled(exception)) {
            InlineMarker.mark(0);
            if (!(it instanceof CoroutineStackFrame)) {
                throw exception;
            }
            throw recoverFromStackFrame(exception, (CoroutineStackFrame) it);
        }
        throw exception;
    }

    public static final <E extends Throwable> E unwrap(E exception) {
        Throwable cause;
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (!recoveryDisabled(exception) && (cause = exception.getCause()) != null) {
            boolean z = true;
            if (!(!Intrinsics.areEqual((Object) cause.getClass(), (Object) exception.getClass()))) {
                StackTraceElement[] stackTrace = exception.getStackTrace();
                Intrinsics.checkExpressionValueIsNotNull(stackTrace, "exception.stackTrace");
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    StackTraceElement it = stackTrace[i];
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    if (isArtificial(it)) {
                        break;
                    }
                    i++;
                }
                if (!z) {
                    return exception;
                }
                E cause2 = exception.getCause();
                if (!(cause2 instanceof Throwable)) {
                    cause2 = null;
                }
                return cause2 != null ? cause2 : exception;
            }
        }
        return exception;
    }

    /* access modifiers changed from: private */
    public static final <E extends Throwable> boolean recoveryDisabled(E exception) {
        return !DebugKt.RECOVER_STACKTRACES || !DebugKt.DEBUG || (exception instanceof CancellationException) || (exception instanceof NonRecoverableThrowable);
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame continuation) {
        CoroutineStackFrame callerFrame;
        ArrayDeque stack = new ArrayDeque();
        StackTraceElement it = continuation.getStackTraceElement();
        if (it != null) {
            stack.add(sanitize(it));
        }
        CoroutineStackFrame last = continuation;
        while (true) {
            CoroutineStackFrame coroutineStackFrame = !(last instanceof CoroutineStackFrame) ? null : last;
            if (coroutineStackFrame == null || (callerFrame = coroutineStackFrame.getCallerFrame()) == null) {
                return stack;
            }
            last = callerFrame;
            StackTraceElement it2 = last.getStackTraceElement();
            if (it2 != null) {
                stack.add(sanitize(it2));
            }
        }
        return stack;
    }

    public static final StackTraceElement sanitize(StackTraceElement element) {
        Intrinsics.checkParameterIsNotNull(element, "element");
        String className = element.getClassName();
        Intrinsics.checkExpressionValueIsNotNull(className, "element.className");
        if (!StringsKt.contains$default((CharSequence) className, '/', false, 2, (Object) null)) {
            return element;
        }
        String className2 = element.getClassName();
        Intrinsics.checkExpressionValueIsNotNull(className2, "element.className");
        return new StackTraceElement(StringsKt.replace$default(className2, '/', '.', false, 4, (Object) null), element.getMethodName(), element.getFileName(), element.getLineNumber());
    }

    public static final StackTraceElement artificialFrame(String message) {
        Intrinsics.checkParameterIsNotNull(message, ConstantsKt.MESSAGE_TEXT);
        return new StackTraceElement("\b\b\b(" + message, "\b", "\b", -1);
    }

    public static final boolean isArtificial(StackTraceElement $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        String className = $receiver.getClassName();
        Intrinsics.checkExpressionValueIsNotNull(className, "className");
        return StringsKt.startsWith$default(className, "\b\b\b", false, 2, (Object) null);
    }

    private static final int frameIndex(StackTraceElement[] $receiver, String methodName) {
        StackTraceElement[] stackTraceElementArr = $receiver;
        int length = stackTraceElementArr.length;
        for (int index$iv = 0; index$iv < length; index$iv++) {
            if (Intrinsics.areEqual((Object) methodName, (Object) stackTraceElementArr[index$iv].getClassName())) {
                return index$iv;
            }
        }
        return -1;
    }

    private static final boolean elementWiseEquals(StackTraceElement $receiver, StackTraceElement e) {
        return $receiver.getLineNumber() == e.getLineNumber() && Intrinsics.areEqual((Object) $receiver.getMethodName(), (Object) e.getMethodName()) && Intrinsics.areEqual((Object) $receiver.getFileName(), (Object) e.getFileName()) && Intrinsics.areEqual((Object) $receiver.getClassName(), (Object) e.getClassName());
    }
}
