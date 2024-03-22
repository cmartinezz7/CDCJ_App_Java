package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/ChildJob;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {0, 1, 1, 1, 1, 1}, l = {848, 850}, m = "invokeSuspend", n = {"state", "state", "list", "this_$iv", "cur$iv", "it"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: JobSupport.kt */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super ChildJob>, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    private SequenceScope p$;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JobSupport$children$1(JobSupport jobSupport, Continuation continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        SequenceScope sequenceScope = (SequenceScope) obj;
        jobSupport$children$1.p$ = (SequenceScope) obj;
        return jobSupport$children$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((JobSupport$children$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 14 */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: kotlinx.coroutines.internal.LockFreeLinkedListNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlinx.coroutines.NodeList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: kotlinx.coroutines.NodeList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0058
            r4 = 0
            if (r1 == r3) goto L_0x004a
            if (r1 != r2) goto L_0x0042
            r1 = r4
            r5 = 0
            r6 = r5
            r7 = r4
            r8 = r5
            r9 = r4
            r10 = r4
            java.lang.Object r11 = r14.L$5
            r9 = r11
            kotlinx.coroutines.ChildHandleNode r9 = (kotlinx.coroutines.ChildHandleNode) r9
            java.lang.Object r11 = r14.L$4
            r10 = r11
            kotlinx.coroutines.internal.LockFreeLinkedListNode r10 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r10
            java.lang.Object r11 = r14.L$3
            r7 = r11
            kotlinx.coroutines.NodeList r7 = (kotlinx.coroutines.NodeList) r7
            java.lang.Object r11 = r14.L$2
            r1 = r11
            kotlinx.coroutines.NodeList r1 = (kotlinx.coroutines.NodeList) r1
            java.lang.Object r4 = r14.L$1
            java.lang.Object r11 = r14.L$0
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            boolean r12 = r15 instanceof kotlin.Result.Failure
            if (r12 != 0) goto L_0x003c
            r12 = r6
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r15
            r15 = r14
            goto L_0x00c1
        L_0x003c:
            r0 = r15
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004a:
            r0 = r4
            java.lang.Object r0 = r14.L$0
            boolean r1 = r15 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x0052
            goto L_0x007a
        L_0x0052:
            r1 = r15
            kotlin.Result$Failure r1 = (kotlin.Result.Failure) r1
            java.lang.Throwable r1 = r1.exception
            throw r1
        L_0x0058:
            boolean r1 = r15 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x00d8
            kotlin.sequences.SequenceScope r1 = r14.p$
            kotlinx.coroutines.JobSupport r4 = r14.this$0
            java.lang.Object r4 = r4.getState$kotlinx_coroutines_core()
            boolean r5 = r4 instanceof kotlinx.coroutines.ChildHandleNode
            if (r5 == 0) goto L_0x007b
            r2 = r4
            kotlinx.coroutines.ChildHandleNode r2 = (kotlinx.coroutines.ChildHandleNode) r2
            kotlinx.coroutines.ChildJob r2 = r2.childJob
            r14.L$0 = r4
            r14.label = r3
            java.lang.Object r1 = r1.yield(r2, r14)
            if (r1 != r0) goto L_0x0079
            return r0
        L_0x0079:
            r0 = r4
        L_0x007a:
            goto L_0x00d2
        L_0x007b:
            boolean r5 = r4 instanceof kotlinx.coroutines.Incomplete
            if (r5 == 0) goto L_0x00d2
            r5 = r4
            kotlinx.coroutines.Incomplete r5 = (kotlinx.coroutines.Incomplete) r5
            kotlinx.coroutines.NodeList r5 = r5.getList()
            if (r5 == 0) goto L_0x00d2
            r6 = 0
            r7 = r5
            r8 = 0
            java.lang.Object r9 = r7.getNext()
            if (r9 == 0) goto L_0x00ca
            kotlinx.coroutines.internal.LockFreeLinkedListNode r9 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r9
            r11 = r1
            r10 = r9
            r1 = r0
            r0 = r15
            r15 = r14
        L_0x0098:
            r9 = r7
            kotlinx.coroutines.internal.LockFreeLinkedListHead r9 = (kotlinx.coroutines.internal.LockFreeLinkedListHead) r9
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r9)
            r9 = r9 ^ r3
            if (r9 == 0) goto L_0x00c7
            boolean r9 = r10 instanceof kotlinx.coroutines.ChildHandleNode
            if (r9 == 0) goto L_0x00c2
            r9 = r10
            kotlinx.coroutines.ChildHandleNode r9 = (kotlinx.coroutines.ChildHandleNode) r9
            r12 = 0
            kotlinx.coroutines.ChildJob r13 = r9.childJob
            r15.L$0 = r11
            r15.L$1 = r4
            r15.L$2 = r5
            r15.L$3 = r7
            r15.L$4 = r10
            r15.L$5 = r9
            r15.label = r2
            java.lang.Object r13 = r11.yield(r13, r15)
            if (r13 != r1) goto L_0x00c1
            return r1
        L_0x00c1:
        L_0x00c2:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r10 = r10.getNextNode()
            goto L_0x0098
        L_0x00c7:
            goto L_0x00d4
        L_0x00ca:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            r0.<init>(r1)
            throw r0
        L_0x00d2:
            r0 = r15
            r15 = r14
        L_0x00d4:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00d8:
            r0 = r15
            kotlin.Result$Failure r0 = (kotlin.Result.Failure) r0
            java.lang.Throwable r0 = r0.exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
