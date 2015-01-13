package de.mxro.metrics.examples;

import de.mxro.async.properties.PropertyNode;
import de.mxro.metrics.jre.Metrics;

public class ExampleThroughputMeasurement {
    public static void main(final String[] args) throws InterruptedException {

        final PropertyNode m = Metrics.create();

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

        Thread.sleep(1000);

        m.print();

        m.stop().get();

    }
}
