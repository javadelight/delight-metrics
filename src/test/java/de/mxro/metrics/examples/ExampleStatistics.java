package de.mxro.metrics.examples;

import de.mxro.metrics.PropertyNode;
import de.mxro.metrics.jre.Metrics;

public class ExampleStatistics {

    public static void main(final String[] args) {

        final PropertyNode m = Metrics.create();

        m.perform(Metrics.value("requestSize", 300));
        m.perform(Metrics.value("requestSize", 100));
        m.perform(Metrics.value("requestSize", 200));

        m.print();

        m.stop().get();

    }

}
