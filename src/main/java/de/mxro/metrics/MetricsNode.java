package de.mxro.metrics;

import de.mxro.metrics.helpers.MetricOperation;

public interface MetricsNode {

    public void record(MetricOperation op);

    public String toString(String id);

    public <T> T get(String id, Class<T> type);

}
