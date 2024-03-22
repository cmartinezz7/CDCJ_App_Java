package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013J$\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H\b¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0011J\u000f\u0010\u001a\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0002\u0010\u001bJ\r\u0010\u001c\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bH\u0002¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010#J$\u0010$\u001a\u0004\u0018\u00018\u00002\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0&H\b¢\u0006\u0002\u0010'J\r\u0010(\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001bJ\u0011\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u000eH\u0010J\u0011\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u000eH\u0010J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000eH\u0002R\u001a\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0018\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0006¨\u0006."}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "T", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "a", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "", "()Z", "size", "", "size$annotations", "addImpl", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "addLastIf", "cond", "Lkotlin/Function0;", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function0;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "predicate", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "siftDownFrom", "i", "siftUpFrom", "swap", "j", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: ThreadSafeHeap.kt */
public final class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private T[] a;
    public volatile int size;

    public static /* synthetic */ void size$annotations() {
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final synchronized void clear() {
        Arrays.fill(this.a, 0, this.size, (Object) null);
        this.size = 0;
    }

    public final synchronized T peek() {
        return firstImpl();
    }

    public final synchronized T removeFirstOrNull() {
        T t;
        if (this.size > 0) {
            t = removeAtImpl(0);
        } else {
            t = null;
        }
        return t;
    }

    public final T removeFirstIf(Function1<? super T, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        synchronized (this) {
            try {
                ThreadSafeHeapNode first = firstImpl();
                T t = null;
                if (first != null) {
                    if (predicate.invoke(first).booleanValue()) {
                        t = removeAtImpl(0);
                    }
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    return t;
                }
                InlineMarker.finallyStart(2);
                InlineMarker.finallyEnd(2);
                return null;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }

    public final synchronized void addLast(T node) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        addImpl(node);
    }

    public final boolean addLastIf(T node, Function0<Boolean> cond) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(node, "node");
        Intrinsics.checkParameterIsNotNull(cond, "cond");
        synchronized (this) {
            try {
                if (cond.invoke().booleanValue()) {
                    addImpl(node);
                    z = true;
                } else {
                    z = false;
                }
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return z;
    }

    public final synchronized boolean remove(T node) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(node, "node");
        z = true;
        boolean z2 = false;
        if (node.getHeap() == null) {
            z = false;
        } else {
            int index = node.getIndex();
            if (index >= 0) {
                z2 = true;
            }
            if (z2) {
                removeAtImpl(index);
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        return z;
    }

    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final T removeAtImpl(int index) {
        boolean z = false;
        if (this.size > 0) {
            ThreadSafeHeapNode[] a2 = this.a;
            if (a2 == null) {
                Intrinsics.throwNpe();
            }
            this.size--;
            if (index < this.size) {
                swap(index, this.size);
                int j = (index - 1) / 2;
                if (index > 0) {
                    ThreadSafeHeapNode threadSafeHeapNode = a2[index];
                    if (threadSafeHeapNode == null) {
                        Intrinsics.throwNpe();
                    }
                    Comparable comparable = (Comparable) threadSafeHeapNode;
                    ThreadSafeHeapNode threadSafeHeapNode2 = a2[j];
                    if (threadSafeHeapNode2 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (comparable.compareTo(threadSafeHeapNode2) < 0) {
                        swap(index, j);
                        siftUpFrom(j);
                    }
                }
                siftDownFrom(index);
            }
            ThreadSafeHeapNode result = a2[this.size];
            if (result == null) {
                Intrinsics.throwNpe();
            }
            if (result.getHeap() == this) {
                z = true;
            }
            if (z) {
                result.setHeap((ThreadSafeHeap<?>) null);
                result.setIndex(-1);
                a2[this.size] = null;
                return result;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void addImpl(T node) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        if (node.getHeap() == null) {
            node.setHeap(this);
            ThreadSafeHeapNode[] a2 = realloc();
            int i = this.size;
            this.size = i + 1;
            a2[i] = node;
            node.setIndex(i);
            siftUpFrom(i);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void siftUpFrom(int i) {
        while (i > 0) {
            ThreadSafeHeapNode[] a2 = this.a;
            if (a2 == null) {
                Intrinsics.throwNpe();
            }
            int j = (i - 1) / 2;
            ThreadSafeHeapNode threadSafeHeapNode = a2[j];
            if (threadSafeHeapNode == null) {
                Intrinsics.throwNpe();
            }
            Comparable comparable = (Comparable) threadSafeHeapNode;
            ThreadSafeHeapNode threadSafeHeapNode2 = a2[i];
            if (threadSafeHeapNode2 == null) {
                Intrinsics.throwNpe();
            }
            if (comparable.compareTo(threadSafeHeapNode2) > 0) {
                swap(i, j);
                i = j;
            } else {
                return;
            }
        }
    }

    private final void siftDownFrom(int i) {
        while (true) {
            int j = (i * 2) + 1;
            if (j < this.size) {
                ThreadSafeHeapNode[] a2 = this.a;
                if (a2 == null) {
                    Intrinsics.throwNpe();
                }
                if (j + 1 < this.size) {
                    ThreadSafeHeapNode threadSafeHeapNode = a2[j + 1];
                    if (threadSafeHeapNode == null) {
                        Intrinsics.throwNpe();
                    }
                    Comparable comparable = (Comparable) threadSafeHeapNode;
                    ThreadSafeHeapNode threadSafeHeapNode2 = a2[j];
                    if (threadSafeHeapNode2 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (comparable.compareTo(threadSafeHeapNode2) < 0) {
                        j++;
                    }
                }
                ThreadSafeHeapNode threadSafeHeapNode3 = a2[i];
                if (threadSafeHeapNode3 == null) {
                    Intrinsics.throwNpe();
                }
                Comparable comparable2 = (Comparable) threadSafeHeapNode3;
                ThreadSafeHeapNode threadSafeHeapNode4 = a2[j];
                if (threadSafeHeapNode4 == null) {
                    Intrinsics.throwNpe();
                }
                if (comparable2.compareTo(threadSafeHeapNode4) > 0) {
                    swap(i, j);
                    i = j;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final T[] realloc() {
        ThreadSafeHeapNode[] a2 = this.a;
        if (a2 == null) {
            ThreadSafeHeapNode[] it = new ThreadSafeHeapNode[4];
            this.a = it;
            return it;
        } else if (this.size < a2.length) {
            return a2;
        } else {
            T[] it2 = Arrays.copyOf(a2, this.size * 2);
            Intrinsics.checkExpressionValueIsNotNull(it2, "java.util.Arrays.copyOf(this, newSize)");
            this.a = it2;
            return (ThreadSafeHeapNode[]) it2;
        }
    }

    private final void swap(int i, int j) {
        ThreadSafeHeapNode[] a2 = this.a;
        if (a2 == null) {
            Intrinsics.throwNpe();
        }
        ThreadSafeHeapNode ni = a2[j];
        if (ni == null) {
            Intrinsics.throwNpe();
        }
        ThreadSafeHeapNode nj = a2[i];
        if (nj == null) {
            Intrinsics.throwNpe();
        }
        a2[i] = ni;
        a2[j] = nj;
        ni.setIndex(i);
        nj.setIndex(j);
    }
}
