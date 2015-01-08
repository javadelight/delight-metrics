package de.mxro.metrics;

import de.mxro.async.Promise;
import de.mxro.async.callbacks.ValueCallback;
import de.mxro.metrics.helpers.RecordOperation;

public interface MetricsNode {

    public void record(RecordOperation op);

    public Promise<Object> retrieve(String id);

    public void retrieve(String id, ValueCallback<Object> cb);

}
