package de.mxro.metrics.internal;

import de.mxro.async.Async;
import de.mxro.async.Deferred;
import de.mxro.async.Promise;
import de.mxro.async.callbacks.ValueCallback;
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

        return Async.promise(new Deferred<Object>() {

            @Override
            public void get(final ValueCallback<Object> callback) {
                retrieve(id, callback);
            }
        });
    }

    @Override
    public void retrieve(final String id, final ValueCallback<Object> cb) {
        cb.onSuccess(data.get(id));
    }

}
