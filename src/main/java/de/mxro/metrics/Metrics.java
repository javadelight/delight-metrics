package de.mxro.metrics;

import de.mxro.metrics.helpers.RecordOperation;
import de.mxro.metrics.internal.UnsafeMetricsNode;
import de.mxro.metrics.internal.operations.CounterEvent;
import de.mxro.metrics.internal.operations.HistrogramEvent;
import de.mxro.metrics.internal.operations.MarkEvent;

public class Metrics {

    public static MetricsNode create() {
        return new UnsafeMetricsNode();
    }

    public static MetricsNode createUnsafe() {
        return new UnsafeMetricsNode();
    }

    public static RecordOperation happened(final String id) {
        return new MarkEvent().setId(id);
    }

    public static RecordOperation increment(final String id) {
        return new CounterEvent(1).setId(id);
    }

    public static RecordOperation decrement(final String id) {
        return new CounterEvent(-1).setId(id);
    }

    public static RecordOperation value(final String id, final long value) {
        return new HistrogramEvent(value).setId(id);
    }

}
