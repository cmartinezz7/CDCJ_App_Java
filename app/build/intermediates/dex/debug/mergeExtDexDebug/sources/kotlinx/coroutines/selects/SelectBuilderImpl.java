package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedExceptionallyKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DispatchedKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectBuilder;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0003DEFB\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J'\u0010\u001f\u001a\u00020\u001c2\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0!H\bJ\n\u0010#\u001a\u0004\u0018\u00010\nH\u0001J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0001J\b\u0010'\u001a\u00020\u001cH\u0002J6\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u001c\u0010\"\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0+H\u0016ø\u0001\u0000¢\u0006\u0002\u0010,J\u0012\u0010-\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020&H\u0016J\u001e\u00103\u001a\u00020\u001c2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0016ø\u0001\u0000¢\u0006\u0002\u00106J\u0012\u00107\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u00010\nH\u0016J3\u00109\u001a\u00020\u001c*\u00020:2\u001c\u0010\"\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0+H\u0002ø\u0001\u0000¢\u0006\u0002\u0010;JE\u00109\u001a\u00020\u001c\"\u0004\b\u0001\u0010<*\b\u0012\u0004\u0012\u0002H<0=2\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H<\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0>H\u0002ø\u0001\u0000¢\u0006\u0002\u0010?JY\u00109\u001a\u00020\u001c\"\u0004\b\u0001\u0010@\"\u0004\b\u0002\u0010<*\u000e\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002H<0A2\u0006\u0010B\u001a\u0002H@2\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H<\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0>H\u0002ø\u0001\u0000¢\u0006\u0002\u0010CR\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006G"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/coroutines/Continuation;", "uCont", "(Lkotlin/coroutines/Continuation;)V", "_result", "Lkotlinx/atomicfu/AtomicRef;", "", "_state", "completion", "getCompletion", "()Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "isSelected", "", "()Z", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "state", "getState", "()Ljava/lang/Object;", "disposeOnSelect", "", "handle", "doAfterSelect", "doResume", "value", "Lkotlin/Function0;", "block", "getResult", "handleBuilderException", "e", "", "initCancellability", "onTimeout", "timeMillis", "", "Lkotlin/Function1;", "(JLkotlin/jvm/functions/Function1;)V", "performAtomicIfNotSelected", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "performAtomicTrySelect", "resumeSelectCancellableWithException", "exception", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "trySelect", "idempotent", "invoke", "Lkotlinx/coroutines/selects/SelectClause0;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "AtomicSelectOp", "DisposeNode", "SelectOnCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: Select.kt */
public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, SelectInstance<R>, Continuation<R> {
    static final AtomicReferenceFieldUpdater _result$FU;
    static final AtomicReferenceFieldUpdater _state$FU;
    volatile Object _result = SelectKt.UNDECIDED;
    volatile Object _state = this;
    private volatile DisposableHandle parentHandle;
    private final Continuation<R> uCont;

    static {
        Class<SelectBuilderImpl> cls = SelectBuilderImpl.class;
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_state");
        _result$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_result");
    }

    public SelectBuilderImpl(Continuation<? super R> uCont2) {
        Intrinsics.checkParameterIsNotNull(uCont2, "uCont");
        this.uCont = uCont2;
    }

    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> $receiver, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(block, "block");
        SelectBuilder.DefaultImpls.invoke(this, $receiver, block);
    }

    public CoroutineContext getContext() {
        return this.uCont.getContext();
    }

    public Continuation<R> getCompletion() {
        return this;
    }

    private final void doResume(Function0<? extends Object> value, Function0<Unit> block) {
        if (isSelected()) {
            while (true) {
                Object result = this._result;
                if (result == SelectKt.UNDECIDED) {
                    if (_result$FU.compareAndSet(this, SelectKt.UNDECIDED, value.invoke())) {
                        return;
                    }
                } else if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                } else if (_result$FU.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.RESUMED)) {
                    block.invoke();
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be selected first".toString());
        }
    }

    public void resumeWith(Object result) {
        if (isSelected()) {
            while (true) {
                Object result$iv = this._result;
                if (result$iv == SelectKt.UNDECIDED) {
                    if (_result$FU.compareAndSet(this, SelectKt.UNDECIDED, CompletedExceptionallyKt.toState(result))) {
                        return;
                    }
                } else if (result$iv != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                } else if (_result$FU.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.RESUMED)) {
                    this.uCont.resumeWith(result);
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be selected first".toString());
        }
    }

    public void resumeSelectCancellableWithException(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (isSelected()) {
            while (true) {
                Object result$iv = this._result;
                if (result$iv == SelectKt.UNDECIDED) {
                    if (_result$FU.compareAndSet(this, SelectKt.UNDECIDED, new CompletedExceptionally(exception))) {
                        return;
                    }
                } else if (result$iv != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                } else if (_result$FU.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.RESUMED)) {
                    DispatchedKt.resumeCancellableWithException(IntrinsicsKt.intercepted(this.uCont), exception);
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be selected first".toString());
        }
    }

    public final Object getResult() {
        if (!isSelected()) {
            initCancellability();
        }
        Object result = this._result;
        if (result == SelectKt.UNDECIDED) {
            if (_result$FU.compareAndSet(this, SelectKt.UNDECIDED, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            result = this._result;
        }
        if (result == SelectKt.RESUMED) {
            throw new IllegalStateException("Already resumed");
        } else if (!(result instanceof CompletedExceptionally)) {
            return result;
        } else {
            throw ((CompletedExceptionally) result).cause;
        }
    }

    private final void initCancellability() {
        Job parent = (Job) getContext().get(Job.Key);
        if (parent != null) {
            DisposableHandle newRegistration = Job.DefaultImpls.invokeOnCompletion$default(parent, true, false, new SelectOnCancelling(this, parent), 2, (Object) null);
            this.parentHandle = newRegistration;
            if (isSelected()) {
                newRegistration.dispose();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "job", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/Job;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Select.kt */
    private final class SelectOnCancelling extends JobCancellingNode<Job> {
        final /* synthetic */ SelectBuilderImpl this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectOnCancelling(SelectBuilderImpl $outer, Job job) {
            super(job);
            Intrinsics.checkParameterIsNotNull(job, "job");
            this.this$0 = $outer;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.INSTANCE;
        }

        public void invoke(Throwable cause) {
            if (this.this$0.trySelect((Object) null)) {
                this.this$0.resumeSelectCancellableWithException(this.job.getCancellationException());
            }
        }

        public String toString() {
            return "SelectOnCancelling[" + this.this$0 + ']';
        }
    }

    /* access modifiers changed from: private */
    public final Object getState() {
        while (true) {
            Object state = this._state;
            if (!(state instanceof OpDescriptor)) {
                return state;
            }
            ((OpDescriptor) state).perform(this);
        }
    }

    public final void handleBuilderException(Throwable e) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        if (trySelect((Object) null)) {
            Result.Companion companion = Result.Companion;
            resumeWith(Result.m5constructorimpl(ResultKt.createFailure(e)));
            return;
        }
        CoroutineExceptionHandlerKt.handleCoroutineException$default(getContext(), e, (Job) null, 4, (Object) null);
    }

    public boolean isSelected() {
        return getState() != this;
    }

    public void disposeOnSelect(DisposableHandle handle) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(handle, "handle");
        DisposeNode node = new DisposeNode(handle);
        while (getState() == this) {
            LockFreeLinkedListNode.CondAddOp condAdd$iv = new SelectBuilderImpl$disposeOnSelect$$inlined$addLastIf$1(node, node, this);
            while (true) {
                Object prev = getPrev();
                if (prev != null) {
                    int tryCondAddNext = ((LockFreeLinkedListNode) prev).tryCondAddNext(node, this, condAdd$iv);
                    z = true;
                    if (tryCondAddNext != 1) {
                        if (tryCondAddNext == 2) {
                            z = false;
                            continue;
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
            }
            if (z) {
                return;
            }
        }
        handle.dispose();
    }

    /* access modifiers changed from: private */
    public final void doAfterSelect() {
        DisposableHandle disposableHandle = this.parentHandle;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        Object next = getNext();
        if (next != null) {
            for (LockFreeLinkedListNode cur$iv = (LockFreeLinkedListNode) next; !Intrinsics.areEqual((Object) cur$iv, (Object) this); cur$iv = cur$iv.getNextNode()) {
                if (cur$iv instanceof DisposeNode) {
                    ((DisposeNode) cur$iv).handle.dispose();
                }
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public boolean trySelect(Object idempotent) {
        if (!(idempotent instanceof OpDescriptor)) {
            do {
                Object state = getState();
                if (state != this) {
                    if (idempotent != null && state == idempotent) {
                        return true;
                    }
                    return false;
                }
            } while (!_state$FU.compareAndSet(this, this, idempotent));
            doAfterSelect();
            return true;
        }
        throw new IllegalStateException("cannot use OpDescriptor as idempotent marker".toString());
    }

    public Object performAtomicTrySelect(AtomicDesc desc) {
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        return new AtomicSelectOp(this, desc, true).perform((Object) null);
    }

    public Object performAtomicIfNotSelected(AtomicDesc desc) {
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        return new AtomicSelectOp(this, desc, false).perform((Object) null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "select", "", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/internal/AtomicDesc;Z)V", "complete", "", "affected", "failure", "completeSelect", "prepare", "prepareIfNotSelected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Select.kt */
    private final class AtomicSelectOp extends AtomicOp<Object> {
        public final AtomicDesc desc;
        public final boolean select;
        final /* synthetic */ SelectBuilderImpl this$0;

        public AtomicSelectOp(SelectBuilderImpl $outer, AtomicDesc desc2, boolean select2) {
            Intrinsics.checkParameterIsNotNull(desc2, "desc");
            this.this$0 = $outer;
            this.desc = desc2;
            this.select = select2;
        }

        public Object prepare(Object affected) {
            Object it;
            if (affected != null || (it = prepareIfNotSelected()) == null) {
                return this.desc.prepare(this);
            }
            return it;
        }

        public void complete(Object affected, Object failure) {
            completeSelect(failure);
            this.desc.complete(this, failure);
        }

        public final Object prepareIfNotSelected() {
            SelectBuilderImpl $receiver$iv = this.this$0;
            while (true) {
                Object state = $receiver$iv._state;
                if (state == this) {
                    return null;
                }
                if (state instanceof OpDescriptor) {
                    ((OpDescriptor) state).perform(this.this$0);
                } else {
                    SelectBuilderImpl selectBuilderImpl = this.this$0;
                    if (state != selectBuilderImpl) {
                        return SelectKt.getALREADY_SELECTED();
                    }
                    if (SelectBuilderImpl._state$FU.compareAndSet(selectBuilderImpl, this.this$0, this)) {
                        return null;
                    }
                }
            }
        }

        private final void completeSelect(Object failure) {
            boolean selectSuccess = this.select && failure == null;
            if (SelectBuilderImpl._state$FU.compareAndSet(this.this$0, this, selectSuccess ? null : this.this$0) && selectSuccess) {
                this.this$0.doAfterSelect();
            }
        }
    }

    public void invoke(SelectClause0 $receiver, Function1<? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(block, "block");
        $receiver.registerSelectClause0(this, block);
    }

    public <Q> void invoke(SelectClause1<? extends Q> $receiver, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(block, "block");
        $receiver.registerSelectClause1(this, block);
    }

    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> $receiver, P param, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        Intrinsics.checkParameterIsNotNull(block, "block");
        $receiver.registerSelectClause2(this, param, block);
    }

    public void onTimeout(long timeMillis, Function1<? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (timeMillis > 0) {
            disposeOnSelect(DelayKt.getDelay(getContext()).invokeOnTimeout(timeMillis, new SelectBuilderImpl$onTimeout$$inlined$Runnable$1(this, block)));
        } else if (trySelect((Object) null)) {
            UndispatchedKt.startCoroutineUnintercepted(block, getCompletion());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Select.kt */
    private static final class DisposeNode extends LockFreeLinkedListNode {
        public final DisposableHandle handle;

        public DisposeNode(DisposableHandle handle2) {
            Intrinsics.checkParameterIsNotNull(handle2, "handle");
            this.handle = handle2;
        }
    }
}
