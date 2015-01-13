package de.mxro.metrics.internal;

import de.mxro.async.Operation;
import de.mxro.async.callbacks.ValueCallback;
import de.mxro.fn.Success;
import de.mxro.metrics.PropertyNode;
import de.mxro.metrics.helpers.PropertyData;
import de.mxro.metrics.helpers.PropertyOperation;
import de.mxro.promise.Promise;
import de.mxro.promise.PromisesCommon;

/**
 * A non-thread safe implementation of {@link PropertyNode}.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class UnsafeMetricsNode implements PropertyNode {

    private final PropertyData data;

    @Override
    public void perform(final PropertyOperation op) {
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
        return PromisesCommon.createUnsafe(new Operation<T>() {

            @Override
            public void apply(final ValueCallback<T> callback) {
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

        return PromisesCommon.createUnsafe(new Operation<Success>() {

            @Override
            public void apply(final ValueCallback<Success> callback) {
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
        System.out.println(data.toString());
    }

    @Override
    public Promise<String> render() {

        return PromisesCommon.createUnsafe(new Operation<String>() {

            @Override
            public void apply(final ValueCallback<String> callback) {
                render(callback);
            }
        });
    }

    @Override
    public void render(final ValueCallback<String> cb) {

        cb.onSuccess(data.toString());
    }

}
