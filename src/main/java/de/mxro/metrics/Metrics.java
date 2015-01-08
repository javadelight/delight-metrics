package de.mxro.metrics;

import de.mxro.metrics.internal.MetricsData;

public class Metrics {

    public static MetricsNode createUnsafe() {
        return new MetricsData();
    }

    public MetricOperation meter(final String id) {

    }

}
