package de.mxro.metrics;

import de.mxro.metrics.internal.MetricsNodeUnsafe;

public class Metrics {

    public static MetricsNode create() {
        return new MetricsNodeUnsafe();
    }

}
