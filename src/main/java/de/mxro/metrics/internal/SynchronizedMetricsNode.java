package de.mxro.metrics.internal;

import de.mxro.async.Async;
import de.mxro.async.Deferred;
import de.mxro.async.Promise;
import de.mxro.async.callbacks.ValueCallback;
import de.mxro.concurrency.schedule.AccessThread;
import de.mxro.concurrency.schedule.Step;
import de.mxro.fn.Success;
import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.helpers.RecordOperation;

public class SynchronizedMetricsNode implements MetricsNode {

    private final MetricsNode decorated;

    private final AccessThread accessThread;

    @Override
    public void record(final RecordOperation op) {
        accessThread.offer(new Step() {

            @Override
            public void process() {
                decorated.record(op);
            }
        });
    }

    public SynchronizedMetricsNode(final MetricsNode decorated, final AccessThread accessThread) {
        super();
        this.decorated = decorated;
        this.accessThread = accessThread;
    }

    @Override
    public <T> Promise<T> retrieve(final String id, final Class<T> type) {

        return Async.promise(new Deferred<T>() {

            @Override
            public void get(final ValueCallback<T> cb) {
                retrieve(id, type, cb);
            }
        });
    }

    @Override
    public <T> void retrieve(final String id, final Class<T> type, final ValueCallback<T> cb) {
        this.accessThread.offer(new Step() {

            @Override
            public void process() {
                decorated.retrieve(id, type, cb);
            }
        });
    }

    @Override
    public Promise<Object> retrieve(final String id) {
        return retrieve(id, Object.class);
    }

    @Override
    public void retrieve(final String id, final ValueCallback<Object> cb) {
        this.accessThread.offer(new Step() {

            @Override
            public void process() {
                decorated.retrieve(id, cb);
            }
        });
    }

    @Override
    public Promise<Success> shutdown() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void shutdown(final ValueCallback<Success> cb) {
        this.accessThread.shutdown(Async.wrap(cb));
    }

}
