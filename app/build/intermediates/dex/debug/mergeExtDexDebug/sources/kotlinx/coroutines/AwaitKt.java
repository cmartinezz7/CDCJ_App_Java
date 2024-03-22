package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004\"\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\fH@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\fH@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: Await.kt */
public final class AwaitKt {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object awaitAll(kotlinx.coroutines.Deferred<? extends T>[] r4, kotlin.coroutines.Continuation<? super java.util.List<? extends T>> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.AwaitKt$awaitAll$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            kotlinx.coroutines.AwaitKt$awaitAll$1 r0 = (kotlinx.coroutines.AwaitKt$awaitAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.AwaitKt$awaitAll$1 r0 = new kotlinx.coroutines.AwaitKt$awaitAll$1
            r0.<init>(r5)
        L_0x0019:
            r5 = r0
            java.lang.Object r0 = r5.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r5.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r1 = r5.L$0
            r4 = r1
            kotlinx.coroutines.Deferred[] r4 = (kotlinx.coroutines.Deferred[]) r4
            boolean r1 = r0 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x0031
            goto L_0x005f
        L_0x0031:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0036:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x003e:
            boolean r2 = r0 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x0062
            int r0 = r4.length
            if (r0 != 0) goto L_0x0047
            r0 = r3
            goto L_0x0048
        L_0x0047:
            r0 = 0
        L_0x0048:
            if (r0 == 0) goto L_0x004f
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0061
        L_0x004f:
            kotlinx.coroutines.AwaitAll r0 = new kotlinx.coroutines.AwaitAll
            r0.<init>(r4)
            r5.L$0 = r4
            r5.label = r3
            java.lang.Object r0 = r0.await(r5)
            if (r0 != r1) goto L_0x005f
            return r1
        L_0x005f:
            java.util.List r0 = (java.util.List) r0
        L_0x0061:
            return r0
        L_0x0062:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.awaitAll(kotlinx.coroutines.Deferred[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object awaitAll(java.util.Collection<? extends kotlinx.coroutines.Deferred<? extends T>> r6, kotlin.coroutines.Continuation<? super java.util.List<? extends T>> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.AwaitKt$awaitAll$2
            if (r0 == 0) goto L_0x0014
            r0 = r7
            kotlinx.coroutines.AwaitKt$awaitAll$2 r0 = (kotlinx.coroutines.AwaitKt$awaitAll$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.AwaitKt$awaitAll$2 r0 = new kotlinx.coroutines.AwaitKt$awaitAll$2
            r0.<init>(r7)
        L_0x0019:
            r7 = r0
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r1 = r7.L$0
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r1 = r0 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x0031
            goto L_0x006d
        L_0x0031:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0036:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003e:
            boolean r2 = r0 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x0080
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x004d
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x006f
        L_0x004d:
            r0 = r6
            r2 = 0
            r4 = r2
            if (r0 == 0) goto L_0x0078
            r5 = r0
            kotlinx.coroutines.Deferred[] r2 = new kotlinx.coroutines.Deferred[r2]
            java.lang.Object[] r2 = r5.toArray(r2)
            if (r2 == 0) goto L_0x0070
            kotlinx.coroutines.Deferred[] r2 = (kotlinx.coroutines.Deferred[]) r2
            kotlinx.coroutines.AwaitAll r0 = new kotlinx.coroutines.AwaitAll
            r0.<init>(r2)
            r7.L$0 = r6
            r7.label = r3
            java.lang.Object r0 = r0.await(r7)
            if (r0 != r1) goto L_0x006d
            return r1
        L_0x006d:
            java.util.List r0 = (java.util.List) r0
        L_0x006f:
            return r0
        L_0x0070:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T>"
            r1.<init>(r2)
            throw r1
        L_0x0078:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type java.util.Collection<T>"
            r1.<init>(r2)
            throw r1
        L_0x0080:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.awaitAll(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: kotlinx.coroutines.Job[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: kotlinx.coroutines.Job[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object joinAll(kotlinx.coroutines.Job[] r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            boolean r0 = r13 instanceof kotlinx.coroutines.AwaitKt$joinAll$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            kotlinx.coroutines.AwaitKt$joinAll$1 r0 = (kotlinx.coroutines.AwaitKt$joinAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.AwaitKt$joinAll$1 r0 = new kotlinx.coroutines.AwaitKt$joinAll$1
            r0.<init>(r13)
        L_0x0019:
            r13 = r0
            java.lang.Object r0 = r13.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r13.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x005a
            if (r2 != r3) goto L_0x0052
            r2 = 0
            r5 = r2
            r6 = r2
            r7 = r4
            java.lang.Object r8 = r13.L$4
            r2 = r8
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r8 = r13.L$3
            r6 = r8
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            int r8 = r13.I$1
            int r9 = r13.I$0
            java.lang.Object r10 = r13.L$2
            kotlinx.coroutines.Job[] r10 = (kotlinx.coroutines.Job[]) r10
            java.lang.Object r11 = r13.L$1
            r5 = r11
            kotlinx.coroutines.Job[] r5 = (kotlinx.coroutines.Job[]) r5
            java.lang.Object r11 = r13.L$0
            r12 = r11
            kotlinx.coroutines.Job[] r12 = (kotlinx.coroutines.Job[]) r12
            boolean r11 = r0 instanceof kotlin.Result.Failure
            if (r11 != 0) goto L_0x004d
            goto L_0x0084
        L_0x004d:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0052:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x005a:
            boolean r2 = r0 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x008d
            r0 = r12
            r2 = r4
            int r5 = r0.length
            r10 = r0
            r9 = r5
            r5 = r10
        L_0x0064:
            if (r4 >= r9) goto L_0x008a
            r6 = r10[r4]
            r0 = r6
            r7 = 0
            r13.L$0 = r12
            r13.L$1 = r5
            r13.L$2 = r10
            r13.I$0 = r9
            r13.I$1 = r4
            r13.L$3 = r6
            r13.L$4 = r0
            r13.label = r3
            java.lang.Object r8 = r0.join(r13)
            if (r8 != r1) goto L_0x0081
            return r1
        L_0x0081:
            r8 = r4
            r4 = r2
            r2 = r0
        L_0x0084:
            int r0 = r8 + 1
            r2 = r4
            r4 = r0
            goto L_0x0064
        L_0x008a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x008d:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.joinAll(kotlinx.coroutines.Job[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.util.Collection<? extends kotlinx.coroutines.Job>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object joinAll(java.util.Collection<? extends kotlinx.coroutines.Job> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.AwaitKt$joinAll$3
            if (r0 == 0) goto L_0x0014
            r0 = r11
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = (kotlinx.coroutines.AwaitKt$joinAll$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = new kotlinx.coroutines.AwaitKt$joinAll$3
            r0.<init>(r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0053
            if (r2 != r3) goto L_0x004b
            r2 = 0
            r5 = r2
            r6 = r4
            r7 = r2
            java.lang.Object r8 = r11.L$4
            r2 = r8
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r7 = r11.L$3
            java.lang.Object r8 = r11.L$2
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r11.L$1
            r5 = r9
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.Object r9 = r11.L$0
            r10 = r9
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r9 = r0 instanceof kotlin.Result.Failure
            if (r9 != 0) goto L_0x0046
        L_0x0045:
            goto L_0x0083
        L_0x0046:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x004b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0053:
            boolean r2 = r0 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x0087
            r0 = r10
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = r4
            java.util.Iterator r4 = r0.iterator()
            r5 = r0
            r8 = r4
            r4 = r2
        L_0x0062:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0084
            java.lang.Object r7 = r8.next()
            r2 = r7
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            r6 = 0
            r11.L$0 = r10
            r11.L$1 = r5
            r11.L$2 = r8
            r11.L$3 = r7
            r11.L$4 = r2
            r11.label = r3
            java.lang.Object r0 = r2.join(r11)
            if (r0 != r1) goto L_0x0045
            return r1
        L_0x0083:
            goto L_0x0062
        L_0x0084:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0087:
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.joinAll(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
