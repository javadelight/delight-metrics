package de.mxro.metrics;

import de.mxro.metrics.internal.MetricsDataImpl;

public class Metrics {

    public static MetricsNode createUnsafe() {
        return new MetricsDataImpl();
    }

    public MetricOperation meter(final String id) {

    }

}
