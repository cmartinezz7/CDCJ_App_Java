package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.Constructor;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0011\u0010\b\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002\u001a\u0016\u0010\u000e\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002\u001a\u001d\u0010\u000f\u001a\u00020\u0003*\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\b\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0010*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Main$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"}, k = 2, mv = {1, 1, 13})
/* compiled from: HandlerDispatcher.kt */
public final class HandlerDispatcherKt {
    private static final long MAX_DELAY = 4611686018427387903L;
    public static final HandlerDispatcher Main;
    private static volatile Choreographer choreographer;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void Main$annotations() {
    }

    public static final HandlerDispatcher from(Handler handler) {
        return from$default(handler, (String) null, 1, (Object) null);
    }

    public static /* synthetic */ HandlerDispatcher from$default(Handler handler, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return from(handler, str);
    }

    public static final HandlerDispatcher from(Handler $receiver, String name) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        return new HandlerContext($receiver, name);
    }

    public static final Handler asHandler(Looper $receiver, boolean async) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        if (!async || Build.VERSION.SDK_INT < 16) {
            return new Handler($receiver);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke((Object) null, new Object[]{$receiver});
            if (invoke != null) {
                return (Handler) invoke;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.os.Handler");
        }
        Class<Handler> cls = Handler.class;
        try {
            Constructor constructor = cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE});
            Intrinsics.checkExpressionValueIsNotNull(constructor, "Handler::class.java.getD…:class.javaPrimitiveType)");
            Handler newInstance = constructor.newInstance(new Object[]{$receiver, null, true});
            Intrinsics.checkExpressionValueIsNotNull(newInstance, "constructor.newInstance(this, null, true)");
            return newInstance;
        } catch (NoSuchMethodException e) {
            return new Handler($receiver);
        }
    }

    static {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
            obj = Result.m5constructorimpl(new HandlerContext(asHandler(mainLooper, true), "Main"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m5constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m11isFailureimpl(obj)) {
            obj = null;
        }
        Main = (HandlerDispatcher) obj;
    }

    public static final Object awaitFrame(Continuation<? super Long> uCont$iv) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 != null) {
            CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
            postFrameCallback(choreographer2, cancellable$iv);
            Object result = cancellable$iv.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(uCont$iv);
            }
            return result;
        }
        CancellableContinuationImpl cancellable$iv2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        Dispatchers.getMain().dispatch(EmptyCoroutineContext.INSTANCE, new HandlerDispatcherKt$$special$$inlined$Runnable$1(cancellable$iv2));
        Object result2 = cancellable$iv2.getResult();
        if (result2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(uCont$iv);
        }
        return result2;
    }

    /* access modifiers changed from: private */
    public static final void updateChoreographerAndPostFrameCallback(CancellableContinuation<? super Long> cont) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            if (choreographer2 == null) {
                Intrinsics.throwNpe();
            }
            choreographer = choreographer2;
        }
        postFrameCallback(choreographer2, cont);
    }

    /* access modifiers changed from: private */
    public static final void postFrameCallback(Choreographer choreographer2, CancellableContinuation<? super Long> cont) {
        choreographer2.postFrameCallback(new HandlerDispatcherKt$postFrameCallback$1(cont));
    }
}
