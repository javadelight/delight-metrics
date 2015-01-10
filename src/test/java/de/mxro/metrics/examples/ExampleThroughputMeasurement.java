package de.mxro.metrics.examples;

import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.jre.Metrics;

public class ExampleThroughputMeasurement {
    public static void main(final String[] args) throws InterruptedException {

        final MetricsNode m = Metrics.create();

        m.record(Metrics.happened("process"));
        m.record(Metrics.happened("process"));
        m.record(Metrics.happened("process"));
        m.record(Metrics.happened("process"));
        m.record(Metrics.happened("process"));

        // m.record(Metrics.happened("process"));
        // m.record(Metrics.happened("process"));
        // m.record(Metrics.happened("process"));
        // m.record(Metrics.happened("process"));
        // m.record(Metrics.happened("process"));

        Thread.sleep(10000);

        m.print();

        m.stop().get();

    }
}
