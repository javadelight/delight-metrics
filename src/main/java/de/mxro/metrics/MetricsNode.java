package de.mxro.metrics;

import de.mxro.metrics.helpers.MetricOperation;
import de.mxro.metrics.helpers.MetricsData;

public interface MetricsNode {

    public void record(MetricOperation op);

    public MetricsData data();

}
