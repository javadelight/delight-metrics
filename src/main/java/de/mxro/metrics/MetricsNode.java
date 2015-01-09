package de.mxro.metrics;

import de.mxro.async.callbacks.ValueCallback;
import de.mxro.async.promise.Promise;
import de.mxro.fn.Success;
import de.mxro.metrics.helpers.RecordOperation;

public interface MetricsNode {

    public void record(RecordOperation op);

    public <T> Promise<T> retrieve(String id, Class<T> type);

    public <T> void retrieve(String id, Class<T> type, ValueCallback<T> cb);

    public Promise<Object> retrieve(String id);

    public void retrieve(String id, ValueCallback<Object> cb);

    public Promise<Success> stop();

    public void stop(ValueCallback<Success> cb);

}
