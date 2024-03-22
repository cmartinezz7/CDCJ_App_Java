package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.RealCall;
import okhttp3.internal.Util;

public final class Dispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    @Nullable
    private ExecutorService executorService;
    @Nullable
    private Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<RealCall.AsyncCall> readyAsyncCalls = new ArrayDeque();
    private final Deque<RealCall.AsyncCall> runningAsyncCalls = new ArrayDeque();
    private final Deque<RealCall> runningSyncCalls = new ArrayDeque();

    public Dispatcher(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    public Dispatcher() {
    }

    public synchronized ExecutorService executorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.executorService;
    }

    public void setMaxRequests(int maxRequests2) {
        if (maxRequests2 >= 1) {
            synchronized (this) {
                this.maxRequests = maxRequests2;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + maxRequests2);
    }

    public synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public void setMaxRequestsPerHost(int maxRequestsPerHost2) {
        if (maxRequestsPerHost2 >= 1) {
            synchronized (this) {
                this.maxRequestsPerHost = maxRequestsPerHost2;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + maxRequestsPerHost2);
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public synchronized void setIdleCallback(@Nullable Runnable idleCallback2) {
        this.idleCallback = idleCallback2;
    }

    /* access modifiers changed from: package-private */
    public void enqueue(RealCall.AsyncCall call) {
        RealCall.AsyncCall existingCall;
        synchronized (this) {
            this.readyAsyncCalls.add(call);
            if (!call.get().forWebSocket && (existingCall = findExistingCallWithHost(call.host())) != null) {
                call.reuseCallsPerHostFrom(existingCall);
            }
        }
        promoteAndExecute();
    }

    @Nullable
    private RealCall.AsyncCall findExistingCallWithHost(String host) {
        for (RealCall.AsyncCall existingCall : this.runningAsyncCalls) {
            if (existingCall.host().equals(host)) {
                return existingCall;
            }
        }
        for (RealCall.AsyncCall existingCall2 : this.readyAsyncCalls) {
            if (existingCall2.host().equals(host)) {
                return existingCall2;
            }
        }
        return null;
    }

    public synchronized void cancelAll() {
        for (RealCall.AsyncCall call : this.readyAsyncCalls) {
            call.get().cancel();
        }
        for (RealCall.AsyncCall call2 : this.runningAsyncCalls) {
            call2.get().cancel();
        }
        for (RealCall call3 : this.runningSyncCalls) {
            call3.cancel();
        }
    }

    private boolean promoteAndExecute() {
        boolean isRunning;
        if (!Thread.holdsLock(this)) {
            List<RealCall.AsyncCall> executableCalls = new ArrayList<>();
            synchronized (this) {
                Iterator<RealCall.AsyncCall> i = this.readyAsyncCalls.iterator();
                while (true) {
                    if (!i.hasNext()) {
                        break;
                    }
                    RealCall.AsyncCall asyncCall = i.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    } else if (asyncCall.callsPerHost().get() < this.maxRequestsPerHost) {
                        i.remove();
                        asyncCall.callsPerHost().incrementAndGet();
                        executableCalls.add(asyncCall);
                        this.runningAsyncCalls.add(asyncCall);
                    }
                }
                isRunning = runningCallsCount() > 0;
            }
            int size = executableCalls.size();
            for (int i2 = 0; i2 < size; i2++) {
                executableCalls.get(i2).executeOn(executorService());
            }
            return isRunning;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public synchronized void executed(RealCall call) {
        this.runningSyncCalls.add(call);
    }

    /* access modifiers changed from: package-private */
    public void finished(RealCall.AsyncCall call) {
        call.callsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, call);
    }

    /* access modifiers changed from: package-private */
    public void finished(RealCall call) {
        finished(this.runningSyncCalls, call);
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    private <T> void finished(Deque<T> calls, T call) {
        Runnable idleCallback2;
        synchronized (this) {
            if (calls.remove(call)) {
                idleCallback2 = this.idleCallback;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!promoteAndExecute() && idleCallback2 != null) {
            idleCallback2.run();
        }
    }

    public synchronized List<Call> queuedCalls() {
        List<Call> result;
        result = new ArrayList<>();
        for (RealCall.AsyncCall asyncCall : this.readyAsyncCalls) {
            result.add(asyncCall.get());
        }
        return Collections.unmodifiableList(result);
    }

    public synchronized List<Call> runningCalls() {
        List<Call> result;
        result = new ArrayList<>();
        result.addAll(this.runningSyncCalls);
        for (RealCall.AsyncCall asyncCall : this.runningAsyncCalls) {
            result.add(asyncCall.get());
        }
        return Collections.unmodifiableList(result);
    }

    public synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }
}
