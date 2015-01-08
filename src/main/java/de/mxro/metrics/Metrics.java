package de.mxro.metrics;

import de.mxro.metrics.helpers.MetricOperation;
import de.mxro.metrics.internal.UnsafeMetricsNode;
import de.mxro.metrics.internal.operations.CounterEvent;
import de.mxro.metrics.internal.operations.HistrogramEvent;
import de.mxro.metrics.internal.operations.MarkEvent;

public class Metrics {

    public static MetricsNode createUnsafe() {
        return new UnsafeMetricsNode();
    }

    public static MetricOperation happened(final String id) {
        return new MarkEvent().setId(id);
    }

    public static MetricOperation increment(final String id) {
        return new CounterEvent(1).setId(id);
    }

    public static MetricOperation decrement(final String id) {
        return new CounterEvent(-1).setId(id);
    }

    public static MetricOperation value(final String id, final long value) {
        return new HistrogramEvent(value).setId(id);
    }

}
