package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0010H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0018\u0010\t\u001a\u00020\u0003*\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\r\u001a\u00020\u0003*\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"DEBUG", "", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACKTRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "classSimpleName", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: Debug.kt */
public final class DebugKt {
    public static final boolean DEBUG;
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    public static final boolean RECOVER_STACKTRACES = SystemPropsKt.systemProp(STACKTRACE_RECOVERY_PROPERTY_NAME, true);
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r0.equals(DEBUG_PROPERTY_VALUE_AUTO) != false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r0.equals(DEBUG_PROPERTY_VALUE_OFF) != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r0.equals(DEBUG_PROPERTY_VALUE_ON) != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        if (r0.equals("") != false) goto L_0x0046;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.systemProp(r0)
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x000c
        L_0x000b:
            goto L_0x0029
        L_0x000c:
            int r4 = r0.hashCode()
            if (r4 == 0) goto L_0x003e
            r5 = 3551(0xddf, float:4.976E-42)
            if (r4 == r5) goto L_0x0035
            r5 = 109935(0x1ad6f, float:1.54052E-40)
            if (r4 == r5) goto L_0x002c
            r5 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r4 != r5) goto L_0x0053
            java.lang.String r4 = "auto"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0053
            goto L_0x000b
        L_0x0029:
            java.lang.Class<kotlinx.coroutines.CoroutineId> r4 = kotlinx.coroutines.CoroutineId.class
            goto L_0x0047
        L_0x002c:
            java.lang.String r4 = "off"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0053
            goto L_0x0047
        L_0x0035:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0053
            goto L_0x0046
        L_0x003e:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0053
        L_0x0046:
            r3 = r2
        L_0x0047:
            DEBUG = r3
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.SystemPropsKt.systemProp(r0, r2)
            RECOVER_STACKTRACES = r0
            return
        L_0x0053:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DebugKt.<clinit>():void");
    }

    public static final String getHexAddress(Object $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        String hexString = Integer.toHexString(System.identityHashCode($receiver));
        Intrinsics.checkExpressionValueIsNotNull(hexString, "Integer.toHexString(System.identityHashCode(this))");
        return hexString;
    }

    public static final String toDebugString(Continuation<?> $receiver) {
        String str;
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        if ($receiver instanceof DispatchedContinuation) {
            return $receiver.toString();
        }
        try {
            Result.Companion companion = Result.Companion;
            str = Result.m5constructorimpl($receiver + '@' + getHexAddress($receiver));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            str = Result.m5constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r2 = Result.m8exceptionOrNullimpl(str);
        if (r2 != null) {
            Throwable th2 = r2;
            str = $receiver.getClass().getName() + '@' + getHexAddress($receiver);
        }
        return (String) str;
    }

    public static final String getClassSimpleName(Object $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        String simpleName = $receiver.getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName");
        return simpleName;
    }
}
