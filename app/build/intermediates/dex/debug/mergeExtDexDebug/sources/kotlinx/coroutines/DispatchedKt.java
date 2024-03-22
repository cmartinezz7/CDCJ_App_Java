package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0006\u001a\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\b\u001a\"\u0010\n\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a;\u0010\u000f\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\b\u001a.\u0010\u0015\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0000\u001a%\u0010\u0019\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0006\u0010\u001a\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\u001b\u001a \u0010\u001c\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a%\u0010\u001f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0006\u0010\u001a\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\u001b\u001a \u0010 \u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a\u0010\u0010!\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\fH\u0002\u001a\u0019\u0010\"\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\b\u001a\u0012\u0010#\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006$"}, d2 = {"UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED$annotations", "()V", "runUnconfinedEventLoop", "", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "dispatch", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "", "executeUnconfined", "", "Lkotlinx/coroutines/DispatchedContinuation;", "contState", "", "doYield", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeCancellable", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeCancellableWithException", "exception", "", "resumeDirect", "resumeDirectWithException", "resumeUnconfined", "resumeWithStackTrace", "yieldUndispatched", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: Dispatched.kt */
public final class DispatchedKt {
    /* access modifiers changed from: private */
    public static final Symbol UNDEFINED = new Symbol("UNDEFINED");

    private static /* synthetic */ void UNDEFINED$annotations() {
    }

    static /* synthetic */ boolean executeUnconfined$default(DispatchedContinuation $receiver, Object contState, int mode, boolean doYield, Function0 block, int i, Object obj) {
        if ((i & 4) != 0) {
            doYield = false;
        }
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (doYield && eventLoop.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop.isUnconfinedLoopActive()) {
            $receiver._state = contState;
            $receiver.resumeMode = mode;
            eventLoop.dispatchUnconfined($receiver);
            return true;
        }
        eventLoop.incrementUseCount(true);
        try {
            block.invoke();
            do {
            } while (eventLoop.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
            eventLoop.decrementUseCount(true);
            InlineMarker.finallyEnd(1);
            return false;
        } catch (Throwable e$iv) {
            InlineMarker.finallyStart(1);
            eventLoop.decrementUseCount(true);
            InlineMarker.finallyEnd(1);
            throw e$iv;
        }
    }

    private static final boolean executeUnconfined(DispatchedContinuation<?> $receiver, Object contState, int mode, boolean doYield, Function0<Unit> block) {
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (doYield && eventLoop.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop.isUnconfinedLoopActive()) {
            $receiver._state = contState;
            $receiver.resumeMode = mode;
            eventLoop.dispatchUnconfined($receiver);
            return true;
        }
        eventLoop.incrementUseCount(true);
        try {
            block.invoke();
            do {
            } while (eventLoop.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
            eventLoop.decrementUseCount(true);
            InlineMarker.finallyEnd(1);
            return false;
        } catch (Throwable e$iv) {
            InlineMarker.finallyStart(1);
            eventLoop.decrementUseCount(true);
            InlineMarker.finallyEnd(1);
            throw e$iv;
        }
    }

    private static final void resumeUnconfined(DispatchedTask<?> $receiver) {
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop.isUnconfinedLoopActive()) {
            eventLoop.dispatchUnconfined($receiver);
            return;
        }
        eventLoop.incrementUseCount(true);
        try {
            resume($receiver, $receiver.getDelegate(), 3);
            do {
            } while (eventLoop.processUnconfinedEvent());
            eventLoop.decrementUseCount(true);
        } catch (Throwable e$iv) {
            eventLoop.decrementUseCount(true);
            throw e$iv;
        }
    }

    /* access modifiers changed from: private */
    public static final void runUnconfinedEventLoop(EventLoop eventLoop, Function0<Unit> block) {
        eventLoop.incrementUseCount(true);
        try {
            block.invoke();
            do {
            } while (eventLoop.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
            eventLoop.decrementUseCount(true);
            InlineMarker.finallyEnd(1);
        } catch (Throwable e) {
            InlineMarker.finallyStart(1);
            eventLoop.decrementUseCount(true);
            InlineMarker.finallyEnd(1);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c7 A[Catch:{ all -> 0x00ba, all -> 0x00dd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void resumeCancellable(kotlin.coroutines.Continuation<? super T> r21, T r22) {
        /*
            r1 = r21
            r2 = r22
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            boolean r0 = r1 instanceof kotlinx.coroutines.DispatchedContinuation
            if (r0 == 0) goto L_0x00f2
            r3 = r1
            kotlinx.coroutines.DispatchedContinuation r3 = (kotlinx.coroutines.DispatchedContinuation) r3
            r4 = 0
            kotlinx.coroutines.CoroutineDispatcher r0 = r3.dispatcher
            kotlin.coroutines.CoroutineContext r5 = r3.getContext()
            boolean r0 = r0.isDispatchNeeded(r5)
            r5 = 1
            if (r0 == 0) goto L_0x0031
            r3._state = r2
            r3.resumeMode = r5
            kotlinx.coroutines.CoroutineDispatcher r0 = r3.dispatcher
            kotlin.coroutines.CoroutineContext r5 = r3.getContext()
            r6 = r3
            java.lang.Runnable r6 = (java.lang.Runnable) r6
            r0.dispatch(r5, r6)
            goto L_0x00da
        L_0x0031:
            r6 = 1
            r7 = r3
            r8 = 0
            r9 = 0
            kotlinx.coroutines.ThreadLocalEventLoop r0 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r10 = r0.getEventLoop$kotlinx_coroutines_core()
            boolean r0 = r10.isUnconfinedLoopActive()
            if (r0 == 0) goto L_0x0050
            r7._state = r2
            r7.resumeMode = r6
            r0 = r7
            kotlinx.coroutines.DispatchedTask r0 = (kotlinx.coroutines.DispatchedTask) r0
            r10.dispatchUnconfined(r0)
            r20 = r3
            goto L_0x00d9
        L_0x0050:
            r11 = 0
            r10.incrementUseCount(r5)
            r12 = 0
            r0 = r3
            r13 = 0
            kotlin.coroutines.CoroutineContext r14 = r0.getContext()     // Catch:{ all -> 0x00df }
            kotlinx.coroutines.Job$Key r15 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x00df }
            kotlin.coroutines.CoroutineContext$Key r15 = (kotlin.coroutines.CoroutineContext.Key) r15     // Catch:{ all -> 0x00df }
            kotlin.coroutines.CoroutineContext$Element r14 = r14.get(r15)     // Catch:{ all -> 0x00df }
            kotlinx.coroutines.Job r14 = (kotlinx.coroutines.Job) r14     // Catch:{ all -> 0x00df }
            if (r14 == 0) goto L_0x0087
            boolean r15 = r14.isActive()     // Catch:{ all -> 0x0083 }
            if (r15 != 0) goto L_0x0087
            java.util.concurrent.CancellationException r15 = r14.getCancellationException()     // Catch:{ all -> 0x0083 }
            java.lang.Throwable r15 = (java.lang.Throwable) r15     // Catch:{ all -> 0x0083 }
            kotlin.Result$Companion r16 = kotlin.Result.Companion     // Catch:{ all -> 0x0083 }
            java.lang.Object r15 = kotlin.ResultKt.createFailure(r15)     // Catch:{ all -> 0x0083 }
            java.lang.Object r15 = kotlin.Result.m5constructorimpl(r15)     // Catch:{ all -> 0x0083 }
            r0.resumeWith(r15)     // Catch:{ all -> 0x0083 }
            r15 = r5
            goto L_0x0088
        L_0x0083:
            r0 = move-exception
            r20 = r3
            goto L_0x00e2
        L_0x0087:
            r15 = 0
        L_0x0088:
            if (r15 != 0) goto L_0x00c7
            r0 = r22
            r13 = r3
            r14 = r0
            r15 = 0
            kotlin.coroutines.CoroutineContext r0 = r13.getContext()     // Catch:{ all -> 0x00df }
            java.lang.Object r5 = r13.countOrElement     // Catch:{ all -> 0x00df }
            r17 = r0
            r18 = 0
            r2 = r17
            java.lang.Object r0 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r2, r5)     // Catch:{ all -> 0x00df }
            r17 = r0
            r0 = 0
            r19 = r0
            kotlin.coroutines.Continuation<T> r0 = r13.continuation     // Catch:{ all -> 0x00be }
            kotlin.Result$Companion r20 = kotlin.Result.Companion     // Catch:{ all -> 0x00be }
            r20 = r3
            java.lang.Object r3 = kotlin.Result.m5constructorimpl(r14)     // Catch:{ all -> 0x00ba }
            r0.resumeWith(r3)     // Catch:{ all -> 0x00ba }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ba }
            r3 = r17
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r2, r3)     // Catch:{ all -> 0x00dd }
            goto L_0x00c9
        L_0x00ba:
            r0 = move-exception
            r3 = r17
            goto L_0x00c3
        L_0x00be:
            r0 = move-exception
            r20 = r3
            r3 = r17
        L_0x00c3:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r2, r3)     // Catch:{ all -> 0x00dd }
            throw r0     // Catch:{ all -> 0x00dd }
        L_0x00c7:
            r20 = r3
        L_0x00c9:
        L_0x00cb:
            boolean r0 = r10.processUnconfinedEvent()     // Catch:{ all -> 0x00dd }
            if (r0 != 0) goto L_0x00dc
            r2 = 1
            r10.decrementUseCount(r2)
        L_0x00d9:
        L_0x00da:
            goto L_0x00fb
        L_0x00dc:
            goto L_0x00cb
        L_0x00dd:
            r0 = move-exception
            goto L_0x00e2
        L_0x00df:
            r0 = move-exception
            r20 = r3
        L_0x00e2:
            kotlinx.coroutines.DispatchException r2 = new kotlinx.coroutines.DispatchException     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "Unexpected exception in unconfined event loop"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x00ec }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x00ec }
            throw r2     // Catch:{ all -> 0x00ec }
        L_0x00ec:
            r0 = move-exception
            r2 = 1
            r10.decrementUseCount(r2)
            throw r0
        L_0x00f2:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.Result.m5constructorimpl(r22)
            r1.resumeWith(r0)
        L_0x00fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DispatchedKt.resumeCancellable(kotlin.coroutines.Continuation, java.lang.Object):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f5 A[Catch:{ all -> 0x00e4, all -> 0x010d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void resumeCancellableWithException(kotlin.coroutines.Continuation<? super T> r25, java.lang.Throwable r26) {
        /*
            r1 = r25
            r2 = r26
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "exception"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            boolean r0 = r1 instanceof kotlinx.coroutines.DispatchedContinuation
            if (r0 == 0) goto L_0x0124
            r3 = r1
            kotlinx.coroutines.DispatchedContinuation r3 = (kotlinx.coroutines.DispatchedContinuation) r3
            r4 = 0
            kotlin.coroutines.Continuation<T> r0 = r3.continuation
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()
            kotlinx.coroutines.CompletedExceptionally r0 = new kotlinx.coroutines.CompletedExceptionally
            r0.<init>(r2)
            r6 = r0
            kotlinx.coroutines.CoroutineDispatcher r0 = r3.dispatcher
            boolean r0 = r0.isDispatchNeeded(r5)
            r7 = 1
            if (r0 == 0) goto L_0x003f
            kotlinx.coroutines.CompletedExceptionally r0 = new kotlinx.coroutines.CompletedExceptionally
            r0.<init>(r2)
            r3._state = r0
            r3.resumeMode = r7
            kotlinx.coroutines.CoroutineDispatcher r0 = r3.dispatcher
            r7 = r3
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            r0.dispatch(r5, r7)
            goto L_0x010a
        L_0x003f:
            r8 = 1
            r9 = r3
            r10 = 0
            r11 = 0
            kotlinx.coroutines.ThreadLocalEventLoop r0 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r12 = r0.getEventLoop$kotlinx_coroutines_core()
            boolean r0 = r12.isUnconfinedLoopActive()
            if (r0 == 0) goto L_0x0060
            r9._state = r6
            r9.resumeMode = r8
            r0 = r9
            kotlinx.coroutines.DispatchedTask r0 = (kotlinx.coroutines.DispatchedTask) r0
            r12.dispatchUnconfined(r0)
            r16 = r3
            r19 = r4
            goto L_0x0109
        L_0x0060:
            r13 = 0
            r12.incrementUseCount(r7)
            r14 = 0
            r0 = r3
            r15 = 0
            kotlin.coroutines.CoroutineContext r7 = r0.getContext()     // Catch:{ all -> 0x010f }
            kotlinx.coroutines.Job$Key r16 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x010f }
            r1 = r16
            kotlin.coroutines.CoroutineContext$Key r1 = (kotlin.coroutines.CoroutineContext.Key) r1     // Catch:{ all -> 0x010f }
            kotlin.coroutines.CoroutineContext$Element r1 = r7.get(r1)     // Catch:{ all -> 0x010f }
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1     // Catch:{ all -> 0x010f }
            if (r1 == 0) goto L_0x009c
            boolean r7 = r1.isActive()     // Catch:{ all -> 0x0095 }
            if (r7 != 0) goto L_0x009c
            java.util.concurrent.CancellationException r7 = r1.getCancellationException()     // Catch:{ all -> 0x0095 }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x0095 }
            kotlin.Result$Companion r16 = kotlin.Result.Companion     // Catch:{ all -> 0x0095 }
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)     // Catch:{ all -> 0x0095 }
            java.lang.Object r7 = kotlin.Result.m5constructorimpl(r7)     // Catch:{ all -> 0x0095 }
            r0.resumeWith(r7)     // Catch:{ all -> 0x0095 }
            r7 = 1
            goto L_0x009d
        L_0x0095:
            r0 = move-exception
            r16 = r3
            r19 = r4
            goto L_0x0114
        L_0x009c:
            r7 = 0
        L_0x009d:
            if (r7 != 0) goto L_0x00f5
            r1 = r26
            r7 = r3
            r15 = 0
            kotlin.coroutines.CoroutineContext r0 = r7.getContext()     // Catch:{ all -> 0x010f }
            r16 = r3
            java.lang.Object r3 = r7.countOrElement     // Catch:{ all -> 0x00f1 }
            r17 = r0
            r18 = 0
            r19 = r4
            r4 = r17
            java.lang.Object r0 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r4, r3)     // Catch:{ all -> 0x010d }
            r17 = r0
            r0 = 0
            r20 = r0
            kotlin.coroutines.Continuation<T> r0 = r7.continuation     // Catch:{ all -> 0x00e8 }
            r21 = r1
            r22 = 0
            kotlin.Result$Companion r23 = kotlin.Result.Companion     // Catch:{ all -> 0x00e8 }
            r23 = r1
            r1 = r21
            java.lang.Throwable r21 = kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(r1, r0)     // Catch:{ all -> 0x00e4 }
            java.lang.Object r21 = kotlin.ResultKt.createFailure(r21)     // Catch:{ all -> 0x00e4 }
            r24 = r1
            java.lang.Object r1 = kotlin.Result.m5constructorimpl(r21)     // Catch:{ all -> 0x00e4 }
            r0.resumeWith(r1)     // Catch:{ all -> 0x00e4 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e4 }
            r1 = r17
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r4, r1)     // Catch:{ all -> 0x010d }
            goto L_0x00f9
        L_0x00e4:
            r0 = move-exception
            r1 = r17
            goto L_0x00ed
        L_0x00e8:
            r0 = move-exception
            r23 = r1
            r1 = r17
        L_0x00ed:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r4, r1)     // Catch:{ all -> 0x010d }
            throw r0     // Catch:{ all -> 0x010d }
        L_0x00f1:
            r0 = move-exception
            r19 = r4
            goto L_0x0114
        L_0x00f5:
            r16 = r3
            r19 = r4
        L_0x00f9:
        L_0x00fb:
            boolean r0 = r12.processUnconfinedEvent()     // Catch:{ all -> 0x010d }
            if (r0 != 0) goto L_0x010c
            r1 = 1
            r12.decrementUseCount(r1)
        L_0x0109:
        L_0x010a:
            goto L_0x0139
        L_0x010c:
            goto L_0x00fb
        L_0x010d:
            r0 = move-exception
            goto L_0x0114
        L_0x010f:
            r0 = move-exception
            r16 = r3
            r19 = r4
        L_0x0114:
            kotlinx.coroutines.DispatchException r1 = new kotlinx.coroutines.DispatchException     // Catch:{ all -> 0x011e }
            java.lang.String r3 = "Unexpected exception in unconfined event loop"
            r1.<init>(r3, r0)     // Catch:{ all -> 0x011e }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x011e }
            throw r1     // Catch:{ all -> 0x011e }
        L_0x011e:
            r0 = move-exception
            r1 = 1
            r12.decrementUseCount(r1)
            throw r0
        L_0x0124:
            r0 = r25
            r1 = 0
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Throwable r3 = kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(r2, r0)
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)
            java.lang.Object r3 = kotlin.Result.m5constructorimpl(r3)
            r0.resumeWith(r3)
        L_0x0139:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DispatchedKt.resumeCancellableWithException(kotlin.coroutines.Continuation, java.lang.Throwable):void");
    }

    public static final <T> void resumeDirect(Continuation<? super T> $receiver, T value) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        if ($receiver instanceof DispatchedContinuation) {
            Continuation<T> continuation = ((DispatchedContinuation) $receiver).continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m5constructorimpl(value));
            return;
        }
        Result.Companion companion2 = Result.Companion;
        $receiver.resumeWith(Result.m5constructorimpl(value));
    }

    public static final <T> void resumeDirectWithException(Continuation<? super T> $receiver, Throwable exception) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if ($receiver instanceof DispatchedContinuation) {
            Continuation $receiver$iv = ((DispatchedContinuation) $receiver).continuation;
            Result.Companion companion = Result.Companion;
            $receiver$iv.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, $receiver$iv))));
            return;
        }
        Continuation $receiver$iv2 = $receiver;
        Result.Companion companion2 = Result.Companion;
        $receiver$iv2.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, $receiver$iv2))));
    }

    public static final boolean yieldUndispatched(DispatchedContinuation<? super Unit> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Object contState$iv = Unit.INSTANCE;
        DispatchedContinuation<? super Unit> dispatchedContinuation = $receiver;
        EventLoop eventLoop$iv = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$iv.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$iv.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = contState$iv;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$iv.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        eventLoop$iv.incrementUseCount(true);
        try {
            $receiver.run();
            do {
            } while (eventLoop$iv.processUnconfinedEvent());
            eventLoop$iv.decrementUseCount(true);
            return false;
        } catch (Throwable e$iv$iv) {
            eventLoop$iv.decrementUseCount(true);
            throw e$iv$iv;
        }
    }

    public static /* synthetic */ void dispatch$default(DispatchedTask dispatchedTask, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        dispatch(dispatchedTask, i);
    }

    public static final <T> void dispatch(DispatchedTask<? super T> $receiver, int mode) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Continuation<? super T> delegate = $receiver.getDelegate();
        if (!ResumeModeKt.isDispatchedMode(mode) || !(delegate instanceof DispatchedContinuation) || ResumeModeKt.isCancellableMode(mode) != ResumeModeKt.isCancellableMode($receiver.resumeMode)) {
            resume($receiver, delegate, mode);
            return;
        }
        CoroutineDispatcher dispatcher = ((DispatchedContinuation) delegate).dispatcher;
        CoroutineContext context = delegate.getContext();
        if (dispatcher.isDispatchNeeded(context)) {
            dispatcher.dispatch(context, $receiver);
        } else {
            resumeUnconfined($receiver);
        }
    }

    public static final <T> void resume(DispatchedTask<? super T> $receiver, Continuation<? super T> delegate, int useMode) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        Object state = $receiver.takeState();
        Throwable exception = $receiver.getExceptionalResult(state);
        if (exception != null) {
            ResumeModeKt.resumeWithExceptionMode(delegate, exception, useMode);
        } else {
            ResumeModeKt.resumeMode(delegate, $receiver.getSuccessfulResult(state), useMode);
        }
    }

    public static final void resumeWithStackTrace(Continuation<?> $receiver, Throwable exception) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Result.Companion companion = Result.Companion;
        $receiver.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, $receiver))));
    }
}
