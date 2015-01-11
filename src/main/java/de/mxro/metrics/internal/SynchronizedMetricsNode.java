package de.mxro.metrics.internal;

import de.mxro.async.Async;
import de.mxro.async.Operation;
import de.mxro.async.callbacks.ValueCallback;
import de.mxro.concurrency.schedule.AccessThread;
import de.mxro.concurrency.schedule.Step;
import de.mxro.fn.Success;
import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.helpers.RecordOperation;
import de.mxro.promise.helper.Promise;
import de.mxro.promise.helper.PromiseFactory;

public class SynchronizedMetricsNode implements MetricsNode {

    private final MetricsNode decorated;

    private final AccessThread accessThread;

    private final PromiseFactory promiseFactory;

    @Override
    public void record(final RecordOperation op) {
        accessThread.offer(new Step() {

            @Override
            public void process() {
                decorated.record(op);
            }
        });
        this.accessThread.startIfRequired();
    }

    public SynchronizedMetricsNode(final MetricsNode decorated, final AccessThread accessThread,
            final PromiseFactory promiseFactory) {
        super();
        this.decorated = decorated;
        this.accessThread = accessThread;
        this.promiseFactory = promiseFactory;
    }

    @Override
    public <T> Promise<T> retrieve(final String id, final Class<T> type) {

        return promiseFactory.promise(new Operation<T>() {

            @Override
            public void apply(final ValueCallback<T> cb) {
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
        this.accessThread.startIfRequired();
    }

    @Override
    public Promise<Object> retrieve(final String id) {
        return retrieve(id, Object.class);
    }

    @Override
    public void retrieve(final String id, final ValueCallback<Object> cb) {
        retrieve(id, Object.class, cb);
    }

    @Override
    public Promise<Success> stop() {

        return promiseFactory.promise(new Operation<Success>() {

            @Override
            public void apply(final ValueCallback<Success> callback) {
                stop(callback);
            }
        });
    }

    @Override
    public void stop(final ValueCallback<Success> cb) {
        this.accessThread.shutdown(Async.wrap(cb));
    }

    @Override
    public void print() {
        this.accessThread.offer(new Step() {

            @Override
            public void process() {
                decorated.print();
            }
        });
        this.accessThread.startIfRequired();
    }

    @Override
    public Promise<String> render() {

        return promiseFactory.promise(new Operation<String>() {

            @Override
            public void apply(final ValueCallback<String> callback) {
                render(callback);
            }
        });
    }

    @Override
    public void render(final ValueCallback<String> cb) {
        this.accessThread.offer(new Step() {

            @Override
            public void process() {
                decorated.render(cb);
            }
        });
        this.accessThread.startIfRequired();
    }

}
