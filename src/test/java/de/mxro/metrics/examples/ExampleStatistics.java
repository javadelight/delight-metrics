package de.mxro.metrics.examples;

import de.mxro.async.properties.PropertyNode;
import de.mxro.metrics.jre.Metrics;

public class ExampleStatistics {

    public static void main(final String[] args) {

        final PropertyNode m = Metrics.create();

        m.record(Metrics.value("requestSize", 300));
        m.record(Metrics.value("requestSize", 100));
        m.record(Metrics.value("requestSize", 200));

        m.print();

        m.stop().get();

    }

}
