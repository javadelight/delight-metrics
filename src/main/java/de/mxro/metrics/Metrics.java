package de.mxro.metrics;

import de.mxro.metrics.internal.MetricsNodeImpl;

public class Metrics {

    public static MetricsNode create() {
        return new MetricsNodeImpl();
    }

}
