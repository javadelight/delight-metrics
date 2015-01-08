package de.mxro.metrics;

import de.mxro.metrics.helpers.RecordOperation;

public interface MetricsNode {

    public void record(RecordOperation op);

    public <T> T get(String id, Class<T> type);

    public Object get(String id);

}
