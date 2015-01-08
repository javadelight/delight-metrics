package de.mxro.metrics;

import de.mxro.metrics.helpers.MetricOperation;
import de.mxro.metrics.internal.UnsafeMetricsNode;
import de.mxro.metrics.internal.operations.MarkEvent;

public class Metrics {

    public static MetricsNode createUnsafe() {
        return new UnsafeMetricsNode();
    }

    public static MetricOperation event(final String id) {
        return new MarkEvent().setId(id);
    }

}
