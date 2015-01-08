package de.mxro.metrics;

import de.mxro.metrics.helpers.MetricOperation;

public interface MetricsNode {

    public void record(MetricOperation op);

}
