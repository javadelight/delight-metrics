package de.mxro.metrics;

import de.mxro.metrics.internal.operations.MarkMeter;

public class Metrics {

    public static MetricsNode createUnsafe() {
        return null;
    }

    public MetricOperation meter(final String id) {
        return new MarkMeter().setId(id);
    }

}
