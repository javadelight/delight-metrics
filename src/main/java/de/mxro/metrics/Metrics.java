package de.mxro.metrics;

import de.mxro.metrics.internal.MetricsCollectionImpl;

public class Metrics {

    public static MetricsCollection create() {
        return new MetricsCollectionImpl();
    }

}
