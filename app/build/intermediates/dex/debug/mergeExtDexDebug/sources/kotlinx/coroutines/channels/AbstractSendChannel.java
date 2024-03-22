package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0006VWXYZ[B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0004J\b\u0010(\u001a\u00020)H\u0002J!\u0010*\u001a\u000e\u0012\u0002\b\u00030+j\u0006\u0012\u0002\b\u0003`,2\u0006\u0010-\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010.J!\u0010/\u001a\u000e\u0012\u0002\b\u00030+j\u0006\u0012\u0002\b\u0003`,2\u0006\u0010-\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010.J\u001b\u00100\u001a\b\u0012\u0004\u0012\u00028\u0000012\u0006\u0010-\u001a\u00028\u0000H\u0004¢\u0006\u0002\u00102J\u0012\u00103\u001a\u0004\u0018\u00010\u00162\u0006\u00104\u001a\u000205H\u0002J\u0014\u00106\u001a\u00020%2\n\u00107\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\"\u00108\u001a\u00020%2\u0018\u00109\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020%0:j\u0002`;H\u0016J\u0012\u0010<\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0013\u0010=\u001a\u00020\u000f2\u0006\u0010-\u001a\u00028\u0000¢\u0006\u0002\u0010>J\u0015\u0010?\u001a\u00020\u00162\u0006\u0010-\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010@J!\u0010A\u001a\u00020\u00162\u0006\u0010-\u001a\u00028\u00002\n\u0010B\u001a\u0006\u0012\u0002\b\u00030CH\u0014¢\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u00020%2\u0006\u00107\u001a\u00020'H\u0014JV\u0010F\u001a\u00020%\"\u0004\b\u0001\u0010G2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HG0C2\u0006\u0010-\u001a\u00028\u00002(\u0010H\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002HG0J\u0012\u0006\u0012\u0004\u0018\u00010\u00160IH\u0002ø\u0001\u0000¢\u0006\u0002\u0010KJ\u0019\u00104\u001a\u00020%2\u0006\u0010-\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u001b\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010N2\u0006\u0010-\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010OJ\u001b\u0010P\u001a\b\u0012\u0002\b\u0003\u0018\u00010N2\u0006\u0010-\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010OJ\u0019\u0010Q\u001a\u00020%2\u0006\u0010-\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u0010\u0010R\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010NH\u0014J\n\u0010S\u001a\u0004\u0018\u00010TH\u0004J\b\u0010U\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "()V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "closedForReceive", "Lkotlinx/coroutines/channels/Closed;", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForSend", "getClosedForSend", "isBufferAlwaysFull", "", "()Z", "isBufferFull", "isClosedForSend", "isFull", "onCloseHandler", "Lkotlinx/atomicfu/AtomicRef;", "", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queueDebugStateString", "getQueueDebugStateString", "close", "cause", "", "conflatePreviousSendBuffered", "", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "countQueueSize", "", "describeSendBuffered", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "element", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeSendConflated", "describeTryOffer", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "enqueueSend", "send", "Lkotlinx/coroutines/channels/SendElement;", "helpClose", "closed", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "invokeOnCloseHandler", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onClosedIdempotent", "registerSelectSend", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBuffered", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendConflated", "sendSuspend", "takeFirstReceiveOrPeekClosed", "takeFirstSendOrPeekClosed", "Lkotlinx/coroutines/channels/Send;", "toString", "SendBuffered", "SendBufferedDesc", "SendConflatedDesc", "SendSelect", "TryEnqueueSendDesc", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: AbstractChannel.kt */
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    private static final AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
    private volatile Object onCloseHandler = null;
    private final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();

    /* access modifiers changed from: protected */
    public abstract boolean isBufferAlwaysFull();

    /* access modifiers changed from: protected */
    public abstract boolean isBufferFull();

    /* access modifiers changed from: protected */
    public final LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    /* access modifiers changed from: protected */
    public Object offerInternal(E element) {
        ReceiveOrClosed receive;
        Object token;
        do {
            receive = takeFirstReceiveOrPeekClosed();
            if (receive == null) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            token = receive.tryResumeReceive(element, (Object) null);
        } while (token == null);
        receive.completeResumeReceive(token);
        return receive.getOfferResult();
    }

    /* access modifiers changed from: protected */
    public Object offerSelectInternal(E element, SelectInstance<?> select) {
        Intrinsics.checkParameterIsNotNull(select, "select");
        TryOfferDesc offerOp = describeTryOffer(element);
        Object failure = select.performAtomicTrySelect(offerOp);
        if (failure != null) {
            return failure;
        }
        ReceiveOrClosed receive = (ReceiveOrClosed) offerOp.getResult();
        Object obj = offerOp.resumeToken;
        if (obj == null) {
            Intrinsics.throwNpe();
        }
        receive.completeResumeReceive(obj);
        return receive.getOfferResult();
    }

    /* access modifiers changed from: protected */
    public final Closed<?> getClosedForSend() {
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (!(prevNode instanceof Closed)) {
            prevNode = null;
        }
        Closed it = (Closed) prevNode;
        if (it == null) {
            return null;
        }
        helpClose(it);
        return it;
    }

    /* access modifiers changed from: protected */
    public final Closed<?> getClosedForReceive() {
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (!(nextNode instanceof Closed)) {
            nextNode = null;
        }
        Closed it = (Closed) nextNode;
        if (it == null) {
            return null;
        }
        helpClose(it);
        return it;
    }

    /* access modifiers changed from: protected */
    public final Send takeFirstSendOrPeekClosed() {
        LockFreeLinkedListNode first$iv;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            Object next = lockFreeLinkedListHead.getNext();
            if (next != null) {
                first$iv = (LockFreeLinkedListNode) next;
                if (first$iv != lockFreeLinkedListHead) {
                    if (first$iv instanceof Send) {
                        if ((((Send) first$iv) instanceof Closed) || first$iv.remove()) {
                            break;
                        }
                        first$iv.helpDelete();
                    } else {
                        first$iv = null;
                        break;
                    }
                } else {
                    first$iv = null;
                    break;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
        return (Send) first$iv;
    }

    /* access modifiers changed from: protected */
    public final ReceiveOrClosed<?> sendBuffered(E element) {
        LockFreeLinkedListNode prev$iv;
        LockFreeLinkedListNode this_$iv = this.queue;
        LockFreeLinkedListNode node$iv = new SendBuffered(element);
        do {
            Object prev = this_$iv.getPrev();
            if (prev != null) {
                prev$iv = (LockFreeLinkedListNode) prev;
                LockFreeLinkedListNode prev2 = prev$iv;
                if (prev2 instanceof ReceiveOrClosed) {
                    return (ReceiveOrClosed) prev2;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!prev$iv.addNext(node$iv, this_$iv));
        return null;
    }

    /* access modifiers changed from: protected */
    public final ReceiveOrClosed<?> sendConflated(E element) {
        LockFreeLinkedListNode prev$iv;
        LockFreeLinkedListNode node = new SendBuffered(element);
        LockFreeLinkedListNode this_$iv = this.queue;
        do {
            Object prev = this_$iv.getPrev();
            if (prev != null) {
                prev$iv = (LockFreeLinkedListNode) prev;
                LockFreeLinkedListNode prev2 = prev$iv;
                if (prev2 instanceof ReceiveOrClosed) {
                    return (ReceiveOrClosed) prev2;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!prev$iv.addNext(node, this_$iv));
        conflatePreviousSendBuffered(node);
        return null;
    }

    /* access modifiers changed from: protected */
    public final void conflatePreviousSendBuffered(LockFreeLinkedListNode node) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        for (LockFreeLinkedListNode prev = node.getPrevNode(); prev instanceof SendBuffered; prev = prev.getPrevNode()) {
            if (!prev.remove()) {
                prev.helpRemove();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final LockFreeLinkedListNode.AddLastDesc<?> describeSendBuffered(E element) {
        return new SendBufferedDesc<>(this.queue, element);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0014¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/internal/AddLastDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: AbstractChannel.kt */
    private static class SendBufferedDesc<E> extends LockFreeLinkedListNode.AddLastDesc<SendBuffered<? extends E>> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendBufferedDesc(LockFreeLinkedListHead queue, E element) {
            super(queue, new SendBuffered(element));
            Intrinsics.checkParameterIsNotNull(queue, "queue");
        }

        /* access modifiers changed from: protected */
        public Object failure(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            if (affected instanceof ReceiveOrClosed) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final LockFreeLinkedListNode.AddLastDesc<?> describeSendConflated(E element) {
        return new SendConflatedDesc<>(this.queue, element);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendConflatedDesc;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "finishOnSuccess", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: AbstractChannel.kt */
    private static final class SendConflatedDesc<E> extends SendBufferedDesc<E> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendConflatedDesc(LockFreeLinkedListHead queue, E element) {
            super(queue, element);
            Intrinsics.checkParameterIsNotNull(queue, "queue");
        }

        /* access modifiers changed from: protected */
        public void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            super.finishOnSuccess(affected, next);
            SendBuffered sendBuffered = (SendBuffered) (!(affected instanceof SendBuffered) ? null : affected);
            if (sendBuffered != null) {
                sendBuffered.remove();
            }
        }
    }

    public final boolean isClosedForSend() {
        return getClosedForSend() != null;
    }

    public final boolean isFull() {
        return !(this.queue.getNextNode() instanceof ReceiveOrClosed) && isBufferFull();
    }

    public final Object send(E element, Continuation<? super Unit> continuation) {
        if (offer(element)) {
            return Unit.INSTANCE;
        }
        return sendSuspend(element, continuation);
    }

    public final boolean offer(E element) {
        Throwable it;
        Throwable it2;
        Object result = offerInternal(element);
        if (result == AbstractChannelKt.OFFER_SUCCESS) {
            return true;
        }
        if (result == AbstractChannelKt.OFFER_FAILED) {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend == null || (it = closedForSend.getSendException()) == null || (it2 = StackTraceRecoveryKt.recoverStackTrace(it)) == null) {
                return false;
            }
            throw it2;
        } else if (result instanceof Closed) {
            throw StackTraceRecoveryKt.recoverStackTrace(((Closed) result).getSendException());
        } else {
            throw new IllegalStateException(("offerInternal returned " + result).toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object sendSuspend(E element, Continuation<? super Unit> uCont$iv) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 0);
        CancellableContinuation cont = cancellable$iv;
        SendElement send = new SendElement(element, cont);
        while (true) {
            Object enqueueResult = enqueueSend(send);
            if (enqueueResult == null) {
                CancellableContinuationKt.removeOnCancellation(cont, send);
                break;
            } else if (enqueueResult instanceof Closed) {
                helpClose((Closed) enqueueResult);
                Throwable sendException = ((Closed) enqueueResult).getSendException();
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(sendException)));
                break;
            } else {
                Object offerResult = offerInternal(element);
                if (offerResult == AbstractChannelKt.OFFER_SUCCESS) {
                    Unit unit = Unit.INSTANCE;
                    Result.Companion companion2 = Result.Companion;
                    cont.resumeWith(Result.m5constructorimpl(unit));
                    break;
                } else if (offerResult != AbstractChannelKt.OFFER_FAILED) {
                    if (offerResult instanceof Closed) {
                        helpClose((Closed) offerResult);
                        Throwable sendException2 = ((Closed) offerResult).getSendException();
                        Result.Companion companion3 = Result.Companion;
                        cont.resumeWith(Result.m5constructorimpl(ResultKt.createFailure(sendException2)));
                    } else {
                        throw new IllegalStateException(("offerInternal returned " + offerResult).toString());
                    }
                }
            }
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(uCont$iv);
        }
        return result;
    }

    /* access modifiers changed from: private */
    public final Object enqueueSend(SendElement send) {
        boolean z;
        LockFreeLinkedListNode prev$iv;
        if (isBufferAlwaysFull()) {
            LockFreeLinkedListNode this_$iv = this.queue;
            do {
                Object prev = this_$iv.getPrev();
                if (prev != null) {
                    prev$iv = (LockFreeLinkedListNode) prev;
                    LockFreeLinkedListNode prev2 = prev$iv;
                    if (prev2 instanceof ReceiveOrClosed) {
                        return prev2;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
            } while (!prev$iv.addNext(send, this_$iv));
            return null;
        }
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        LockFreeLinkedListHead lockFreeLinkedListHead2 = lockFreeLinkedListHead;
        LockFreeLinkedListNode.CondAddOp condAdd$iv = new AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1(send, send, this);
        while (true) {
            Object prev3 = lockFreeLinkedListHead.getPrev();
            if (prev3 != null) {
                LockFreeLinkedListNode prev$iv2 = (LockFreeLinkedListNode) prev3;
                LockFreeLinkedListNode prev4 = prev$iv2;
                if (!(prev4 instanceof ReceiveOrClosed)) {
                    int tryCondAddNext = prev$iv2.tryCondAddNext(send, lockFreeLinkedListHead, condAdd$iv);
                    z = true;
                    if (tryCondAddNext != 1) {
                        if (tryCondAddNext == 2) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    return prev4;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
        if (!z) {
            return AbstractChannelKt.ENQUEUE_FAILED;
        }
        return null;
    }

    public boolean close(Throwable cause) {
        LockFreeLinkedListNode this_$iv;
        Closed closed = new Closed(cause);
        LockFreeLinkedListNode this_$iv2 = this.queue;
        while (true) {
            Object prev = this_$iv2.getPrev();
            if (prev != null) {
                LockFreeLinkedListNode prev$iv = (LockFreeLinkedListNode) prev;
                if (!(prev$iv instanceof Closed)) {
                    if (prev$iv.addNext(closed, this_$iv2)) {
                        this_$iv = 1;
                        break;
                    }
                } else {
                    this_$iv = null;
                    break;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
        if (this_$iv == null) {
            LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
            if (prevNode != null) {
                helpClose((Closed) prevNode);
                return false;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
        }
        helpClose(closed);
        invokeOnCloseHandler(cause);
        return true;
    }

    private final void invokeOnCloseHandler(Throwable cause) {
        Object handler = this.onCloseHandler;
        if (handler != null && handler != AbstractChannelKt.HANDLER_INVOKED && onCloseHandler$FU.compareAndSet(this, handler, AbstractChannelKt.HANDLER_INVOKED)) {
            ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(handler, 1)).invoke(cause);
        }
    }

    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkParameterIsNotNull(handler, "handler");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, (Object) null, handler)) {
            Object value = this.onCloseHandler;
            if (value == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + value);
        }
        Closed closedToken = getClosedForSend();
        if (closedToken != null && atomicReferenceFieldUpdater.compareAndSet(this, handler, AbstractChannelKt.HANDLER_INVOKED)) {
            handler.invoke(closedToken.closeCause);
        }
    }

    /* access modifiers changed from: private */
    public final void helpClose(Closed<?> closed) {
        while (true) {
            LockFreeLinkedListNode previous = closed.getPrevNode();
            if ((previous instanceof LockFreeLinkedListHead) || !(previous instanceof Receive)) {
                onClosedIdempotent(closed);
            } else if (!previous.remove()) {
                previous.helpRemove();
            } else {
                Receive receive = (Receive) previous;
                ((Receive) previous).resumeReceiveClosed(closed);
            }
        }
        onClosedIdempotent(closed);
    }

    /* access modifiers changed from: protected */
    public void onClosedIdempotent(LockFreeLinkedListNode closed) {
        Intrinsics.checkParameterIsNotNull(closed, "closed");
    }

    /* access modifiers changed from: protected */
    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        LockFreeLinkedListNode first$iv;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            Object next = lockFreeLinkedListHead.getNext();
            if (next != null) {
                first$iv = (LockFreeLinkedListNode) next;
                if (first$iv != lockFreeLinkedListHead) {
                    if (first$iv instanceof ReceiveOrClosed) {
                        if ((((ReceiveOrClosed) first$iv) instanceof Closed) || first$iv.remove()) {
                            break;
                        }
                        first$iv.helpDelete();
                    } else {
                        first$iv = null;
                        break;
                    }
                } else {
                    first$iv = null;
                    break;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
        return (ReceiveOrClosed) first$iv;
    }

    /* access modifiers changed from: protected */
    public final TryOfferDesc<E> describeTryOffer(E element) {
        return new TryOfferDesc<>(element, this.queue);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0014R\u0012\u0010\u0005\u001a\u00028\u00018\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "element", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "Ljava/lang/Object;", "resumeToken", "", "failure", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "validatePrepared", "", "node", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: AbstractChannel.kt */
    protected static final class TryOfferDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>> {
        public final E element;
        public Object resumeToken;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TryOfferDesc(E element2, LockFreeLinkedListHead queue) {
            super(queue);
            Intrinsics.checkParameterIsNotNull(queue, "queue");
            this.element = element2;
        }

        /* access modifiers changed from: protected */
        public Object failure(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            if (!(affected instanceof ReceiveOrClosed)) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            if (affected instanceof Closed) {
                return affected;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean validatePrepared(ReceiveOrClosed<? super E> node) {
            Intrinsics.checkParameterIsNotNull(node, "node");
            Object token = node.tryResumeReceive(this.element, this);
            if (token == null) {
                return false;
            }
            this.resumeToken = token;
            return true;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004BH\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012(\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\tø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0014J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryEnqueueSendDesc;", "R", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", "Lkotlinx/coroutines/internal/AddLastDesc;", "element", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/channels/AbstractSendChannel;Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "failure", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "finishOnSuccess", "", "onPrepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: AbstractChannel.kt */
    private final class TryEnqueueSendDesc<R> extends LockFreeLinkedListNode.AddLastDesc<SendSelect<E, R>> {
        final /* synthetic */ AbstractSendChannel this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TryEnqueueSendDesc(AbstractSendChannel $outer, E element, SelectInstance<? super R> select, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
            super($outer.getQueue(), new SendSelect(element, $outer, select, block));
            Intrinsics.checkParameterIsNotNull(select, "select");
            Intrinsics.checkParameterIsNotNull(block, "block");
            this.this$0 = $outer;
        }

        /* access modifiers changed from: protected */
        public Object failure(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            Closed closed = null;
            if (!(affected instanceof ReceiveOrClosed)) {
                return null;
            }
            if (affected instanceof Closed) {
                closed = affected;
            }
            Closed closed2 = closed;
            return closed2 != null ? closed2 : AbstractChannelKt.ENQUEUE_FAILED;
        }

        /* access modifiers changed from: protected */
        public Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            if (!this.this$0.isBufferFull()) {
                return AbstractChannelKt.ENQUEUE_FAILED;
            }
            return super.onPrepare(affected, next);
        }

        /* access modifiers changed from: protected */
        public void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            super.finishOnSuccess(affected, next);
            ((SendSelect) this.node).disposeOnSelect();
        }
    }

    public final SelectClause2<E, SendChannel<E>> getOnSend() {
        return new AbstractSendChannel$onSend$1(this);
    }

    /* access modifiers changed from: private */
    public final <R> void registerSelectSend(SelectInstance<? super R> select, E element, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
        while (!select.isSelected()) {
            if (isFull()) {
                Object enqueueResult = select.performAtomicIfNotSelected(new TryEnqueueSendDesc(this, element, select, block));
                if (enqueueResult != null && enqueueResult != SelectKt.getALREADY_SELECTED()) {
                    if (enqueueResult != AbstractChannelKt.ENQUEUE_FAILED) {
                        if (enqueueResult instanceof Closed) {
                            throw StackTraceRecoveryKt.recoverStackTrace(((Closed) enqueueResult).getSendException());
                        }
                        throw new IllegalStateException(("performAtomicIfNotSelected(TryEnqueueSendDesc) returned " + enqueueResult).toString());
                    }
                } else {
                    return;
                }
            } else {
                Object offerResult = offerSelectInternal(element, select);
                if (offerResult != SelectKt.getALREADY_SELECTED()) {
                    if (offerResult != AbstractChannelKt.OFFER_FAILED) {
                        if (offerResult == AbstractChannelKt.OFFER_SUCCESS) {
                            UndispatchedKt.startCoroutineUnintercepted(block, this, select.getCompletion());
                            return;
                        } else if (offerResult instanceof Closed) {
                            throw StackTraceRecoveryKt.recoverStackTrace(((Closed) offerResult).getSendException());
                        } else {
                            throw new IllegalStateException(("offerSelectInternal returned " + offerResult).toString());
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public String toString() {
        return DebugKt.getClassSimpleName(this) + '@' + DebugKt.getHexAddress(this) + '{' + getQueueDebugStateString() + '}' + getBufferDebugString();
    }

    private final String getQueueDebugStateString() {
        String result;
        LockFreeLinkedListNode head = this.queue.getNextNode();
        if (head == this.queue) {
            return "EmptyQueue";
        }
        if (head instanceof Closed) {
            result = head.toString();
        } else if (head instanceof Receive) {
            result = "ReceiveQueued";
        } else if (head instanceof Send) {
            result = "SendQueued";
        } else {
            result = "UNEXPECTED:" + head;
        }
        LockFreeLinkedListNode tail = this.queue.getPrevNode();
        if (tail == head) {
            return result;
        }
        String result2 = result + ",queueSize=" + countQueueSize();
        if (tail instanceof Closed) {
            return result2 + ",closedForSend=" + tail;
        }
        return result2;
    }

    private final int countQueueSize() {
        int size = 0;
        LockFreeLinkedListHead this_$iv = this.queue;
        Object next = this_$iv.getNext();
        if (next != null) {
            for (LockFreeLinkedListNode cur$iv = (LockFreeLinkedListNode) next; !Intrinsics.areEqual((Object) cur$iv, (Object) this_$iv); cur$iv = cur$iv.getNextNode()) {
                if (cur$iv instanceof LockFreeLinkedListNode) {
                    LockFreeLinkedListNode lockFreeLinkedListNode = cur$iv;
                    size++;
                }
            }
            return size;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* access modifiers changed from: protected */
    public String getBufferDebugString() {
        return "";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u00042\u00020\u0005BX\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\u0012(\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\rø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u0014\u0010\u0018\u001a\u00020\u00142\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016R7\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r8\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", "E", "R", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/DisposableHandle;", "pollResult", "", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/SendChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "token", "dispose", "disposeOnSelect", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "idempotent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: AbstractChannel.kt */
    private static final class SendSelect<E, R> extends LockFreeLinkedListNode implements Send, DisposableHandle {
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> block;
        public final SendChannel<E> channel;
        private final Object pollResult;
        public final SelectInstance<R> select;

        public SendSelect(Object pollResult2, SendChannel<? super E> channel2, SelectInstance<? super R> select2, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block2) {
            Intrinsics.checkParameterIsNotNull(channel2, "channel");
            Intrinsics.checkParameterIsNotNull(select2, "select");
            Intrinsics.checkParameterIsNotNull(block2, "block");
            this.pollResult = pollResult2;
            this.channel = channel2;
            this.select = select2;
            this.block = block2;
        }

        public Object getPollResult() {
            return this.pollResult;
        }

        public Object tryResumeSend(Object idempotent) {
            if (this.select.trySelect(idempotent)) {
                return AbstractChannelKt.SELECT_STARTED;
            }
            return null;
        }

        public void completeResumeSend(Object token) {
            Intrinsics.checkParameterIsNotNull(token, "token");
            if (token == AbstractChannelKt.SELECT_STARTED) {
                ContinuationKt.startCoroutine(this.block, this.channel, this.select.getCompletion());
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public final void disposeOnSelect() {
            this.select.disposeOnSelect(this);
        }

        public void dispose() {
            remove();
        }

        public void resumeSendClosed(Closed<?> closed) {
            Intrinsics.checkParameterIsNotNull(closed, "closed");
            if (this.select.trySelect((Object) null)) {
                this.select.resumeSelectCancellableWithException(closed.getSendException());
            }
        }

        public String toString() {
            return "SendSelect(" + getPollResult() + ")[" + this.channel + ", " + this.select + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0014\u0010\u000e\u001a\u00020\f2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016R\u0012\u0010\u0004\u001a\u00028\u00018\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "token", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "tryResumeSend", "idempotent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* compiled from: AbstractChannel.kt */
    private static final class SendBuffered<E> extends LockFreeLinkedListNode implements Send {
        public final E element;

        public SendBuffered(E element2) {
            this.element = element2;
        }

        public Object getPollResult() {
            return this.element;
        }

        public Object tryResumeSend(Object idempotent) {
            return AbstractChannelKt.SEND_RESUMED;
        }

        public void completeResumeSend(Object token) {
            Intrinsics.checkParameterIsNotNull(token, "token");
            if (!(token == AbstractChannelKt.SEND_RESUMED)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public void resumeSendClosed(Closed<?> closed) {
            Intrinsics.checkParameterIsNotNull(closed, "closed");
        }
    }
}
