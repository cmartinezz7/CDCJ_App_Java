package kotlinx.coroutines.internal;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00052\u0006\u0010\t\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"0\u0010\u0002\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00060\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionConstructors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: ExceptionsConstuctor.kt */
public final class ExceptionsConstuctorKt {
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionConstructors = new WeakHashMap<>();

    /* JADX INFO: finally extract failed */
    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static final <E extends java.lang.Throwable> E tryCopyException(E r12) {
        /*
            java.lang.String r0 = "exception"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            r1 = 0
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r2 = exceptionConstructors     // Catch:{ all -> 0x0108 }
            java.lang.Class r3 = r12.getClass()     // Catch:{ all -> 0x0108 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0108 }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ all -> 0x0108 }
            r0.unlock()
            r0 = r2
            if (r0 == 0) goto L_0x0028
            java.lang.Object r1 = r0.invoke(r12)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            return r1
        L_0x0028:
            r1 = 0
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Class r3 = r12.getClass()
            java.lang.reflect.Constructor[] r3 = r3.getConstructors()
            java.lang.String r4 = "exception.javaClass.constructors"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            r4 = 0
            r5 = r4
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1 r6 = new kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1
            r6.<init>()
            java.util.Comparator r6 = (java.util.Comparator) r6
            java.util.List r3 = kotlin.collections.ArraysKt.sortedWith((T[]) r3, r6)
            java.util.Iterator r5 = r3.iterator()
        L_0x004b:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00af
            java.lang.Object r6 = r5.next()
            java.lang.reflect.Constructor r6 = (java.lang.reflect.Constructor) r6
            java.lang.String r7 = "constructor"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            java.lang.Class[] r7 = r6.getParameterTypes()
            int r8 = r7.length
            r9 = 2
            r10 = 1
            if (r8 != r9) goto L_0x0082
            r8 = r7[r4]
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x0082
            r8 = r7[r10]
            java.lang.Class<java.lang.Throwable> r9 = java.lang.Throwable.class
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x0082
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$1 r5 = new kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$1
            r5.<init>(r6)
            r2 = r5
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            goto L_0x00af
        L_0x0082:
            int r8 = r7.length
            if (r8 != r10) goto L_0x0098
            r8 = r7[r4]
            java.lang.Class<java.lang.Throwable> r9 = java.lang.Throwable.class
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x0098
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$2 r5 = new kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$2
            r5.<init>(r6)
            r2 = r5
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            goto L_0x00af
        L_0x0098:
            java.lang.String r8 = "parameters"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
            int r8 = r7.length
            if (r8 != 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r10 = r4
        L_0x00a2:
            if (r10 == 0) goto L_0x00ad
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$3 r5 = new kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$3
            r5.<init>(r6)
            r2 = r5
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            goto L_0x00af
        L_0x00ad:
            goto L_0x004b
        L_0x00af:
            java.util.concurrent.locks.ReentrantReadWriteLock r5 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r6 = r5.readLock()
            int r7 = r5.getWriteHoldCount()
            if (r7 != 0) goto L_0x00c0
            int r7 = r5.getReadHoldCount()
            goto L_0x00c1
        L_0x00c0:
            r7 = r4
        L_0x00c1:
            r8 = r4
        L_0x00c2:
            if (r8 >= r7) goto L_0x00ca
            r6.unlock()
            int r8 = r8 + 1
            goto L_0x00c2
        L_0x00ca:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r5 = r5.writeLock()
            r5.lock()
            r8 = 0
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r9 = exceptionConstructors     // Catch:{ all -> 0x00fb }
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ all -> 0x00fb }
            java.lang.Class r10 = r12.getClass()     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x00de
            r11 = r2
            goto L_0x00e2
        L_0x00de:
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1 r11 = kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1.INSTANCE     // Catch:{ all -> 0x00fb }
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11     // Catch:{ all -> 0x00fb }
        L_0x00e2:
            r9.put(r10, r11)     // Catch:{ all -> 0x00fb }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00fb }
        L_0x00e7:
            if (r4 >= r7) goto L_0x00ef
            r6.lock()
            int r4 = r4 + 1
            goto L_0x00e7
        L_0x00ef:
            r5.unlock()
            if (r2 == 0) goto L_0x00fa
            java.lang.Object r1 = r2.invoke(r12)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x00fa:
            return r1
        L_0x00fb:
            r1 = move-exception
        L_0x00fc:
            if (r4 >= r7) goto L_0x0104
            r6.lock()
            int r4 = r4 + 1
            goto L_0x00fc
        L_0x0104:
            r5.unlock()
            throw r1
        L_0x0108:
            r1 = move-exception
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ExceptionsConstuctorKt.tryCopyException(java.lang.Throwable):java.lang.Throwable");
    }
}
