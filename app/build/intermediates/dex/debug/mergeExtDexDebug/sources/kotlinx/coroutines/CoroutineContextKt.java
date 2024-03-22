package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\r\u001a\u00020\u000eH\u0000\u001a\b\u0010\u000f\u001a\u00020\u0010H\u0000\u001a4\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0017H\b¢\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\n*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\nH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "resetCoroutineId", "", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: CoroutineContext.kt */
public final class CoroutineContextKt {
    public static final String COROUTINES_SCHEDULER_PROPERTY_NAME = "kotlinx.coroutines.scheduler";
    private static final AtomicLong COROUTINE_ID = new AtomicLong();
    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";
    private static final boolean useCoroutinesScheduler;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r0.equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r0.equals("") != false) goto L_0x003c;
     */
    static {
        /*
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r0.<init>()
            COROUTINE_ID = r0
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.systemProp(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0011
        L_0x0010:
            goto L_0x003c
        L_0x0011:
            int r2 = r0.hashCode()
            if (r2 == 0) goto L_0x0033
            r3 = 3551(0xddf, float:4.976E-42)
            if (r2 == r3) goto L_0x002a
            r3 = 109935(0x1ad6f, float:1.54052E-40)
            if (r2 != r3) goto L_0x0041
            java.lang.String r2 = "off"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0041
            r2 = 0
            goto L_0x003d
        L_0x002a:
            java.lang.String r2 = "on"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0041
            goto L_0x0010
        L_0x0033:
            java.lang.String r2 = ""
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0041
            goto L_0x0010
        L_0x003c:
            r2 = 1
        L_0x003d:
            useCoroutinesScheduler = r2
            return
        L_0x0041:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            r3 = 39
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r2 = r2.toString()
            r3.<init>(r2)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineContextKt.<clinit>():void");
    }

    public static final void resetCoroutineId() {
        COROUTINE_ID.set(0);
    }

    public static final boolean getUseCoroutinesScheduler() {
        return useCoroutinesScheduler;
    }

    public static final CoroutineDispatcher createDefaultDispatcher() {
        return useCoroutinesScheduler ? DefaultScheduler.INSTANCE : CommonPool.INSTANCE;
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope $receiver, CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(context, "context");
        CoroutineContext combined = $receiver.getCoroutineContext().plus(context);
        CoroutineContext debug = DebugKt.DEBUG ? combined.plus(new CoroutineId(COROUTINE_ID.incrementAndGet())) : combined;
        return (combined == Dispatchers.getDefault() || combined.get(ContinuationInterceptor.Key) != null) ? debug : debug.plus(Dispatchers.getDefault());
    }

    public static final <T> T withCoroutineContext(CoroutineContext context, Object countOrElement, Function0<? extends T> block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Object oldValue = ThreadContextKt.updateThreadContext(context, countOrElement);
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            ThreadContextKt.restoreThreadContext(context, oldValue);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final String getCoroutineName(CoroutineContext $receiver) {
        CoroutineId coroutineId;
        String coroutineName;
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        if (!DebugKt.DEBUG || (coroutineId = (CoroutineId) $receiver.get(CoroutineId.Key)) == null) {
            return null;
        }
        CoroutineName coroutineName2 = (CoroutineName) $receiver.get(CoroutineName.Key);
        if (coroutineName2 == null || (coroutineName = coroutineName2.getName()) == null) {
            coroutineName = "coroutine";
        }
        return coroutineName + '#' + coroutineId.getId();
    }
}
