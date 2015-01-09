package de.mxro.metrics.internal;

import de.mxro.async.Async;
import de.mxro.async.callbacks.ValueCallback;
import de.mxro.async.promise.Deferred;
import de.mxro.async.promise.Promise;
import de.mxro.fn.Success;
import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.helpers.MetricsData;
import de.mxro.metrics.helpers.RecordOperation;

/**
 * A non-thread safe implementation of {@link MetricsNode}.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class UnsafeMetricsNode implements MetricsNode {

    private final MetricsData data;

    @Override
    public void record(final RecordOperation op) {
        op.perform(data);
    }

    public UnsafeMetricsNode() {
        super();
        this.data = new MetricsDataImpl();
    }

    @Override
    public Promise<Object> retrieve(final String id) {
        return retrieve(id, Object.class);
    }

    @Override
    public void retrieve(final String id, final ValueCallback<Object> cb) {
        retrieve(id, Object.class);
    }

    @Override
    public <T> Promise<T> retrieve(final String id, final Class<T> type) {
        return Async.promise(new Deferred<T>() {

            @Override
            public void get(final ValueCallback<T> callback) {
                retrieve(id, type, callback);
            }
        });
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> void retrieve(final String id, final Class<T> type, final ValueCallback<T> cb) {
        if (type.equals(Object.class)) {
            cb.onSuccess((T) data.get(id));
            return;
        }

        cb.onSuccess(data.get(id, type));
    }

    @Override
    public Promise<Success> stop() {

        return Async.promise(new Deferred<Success>() {

            @Override
            public void get(final ValueCallback<Success> callback) {
                stop(callback);
            }
        });
    }

    @Override
    public void stop(final ValueCallback<Success> cb) {
        cb.onSuccess(Success.INSTANCE);
    }

    @Override
    public void print() {

    }

}
