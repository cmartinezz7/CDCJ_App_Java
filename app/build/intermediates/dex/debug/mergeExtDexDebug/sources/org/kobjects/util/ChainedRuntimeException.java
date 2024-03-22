package org.kobjects.util;

public class ChainedRuntimeException extends RuntimeException {
    Exception chain;

    public static ChainedRuntimeException create(Exception e, String s) {
        try {
            return ((ChainedRuntimeException) Class.forName("org.kobjects.util.ChainedRuntimeExceptionSE").newInstance())._create(e, s);
        } catch (Exception e2) {
            return new ChainedRuntimeException(e, s);
        }
    }

    ChainedRuntimeException() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChainedRuntimeException(Exception e, String s) {
        super((s == null ? "rethrown" : s) + ": " + e.toString());
        this.chain = e;
    }

    /* access modifiers changed from: package-private */
    public ChainedRuntimeException _create(Exception e, String s) {
        throw new RuntimeException("ERR!");
    }

    public Exception getChained() {
        return this.chain;
    }

    public void printStackTrace() {
        super.printStackTrace();
        Exception exc = this.chain;
        if (exc != null) {
            exc.printStackTrace();
        }
    }
}
