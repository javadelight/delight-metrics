package de.mxro.metrics.examples;

import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.jre.Metrics;

public class ExampleStatistics {

    public static void main(final String[] args) {

        final MetricsNode m = Metrics.create();

        m.record(Metrics.increment("counter"));
        m.record(Metrics.increment("counter"));
        m.record(Metrics.decrement("counter"));

        m.print();

        m.stop().get();

    }

}
