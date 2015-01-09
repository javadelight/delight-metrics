package de.mxro.metrics.examples;

import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.jre.Metrics;

public class ExampleThroughputMeasurement {
    public static void main(final String[] args) {

        final MetricsNode m = Metrics.create();

        m.record(Metrics.happened("process"));
        m.record(Metrics.happened("process"));
        m.record(Metrics.happened("process"));

        m.print();

        m.stop().get();

    }
}
