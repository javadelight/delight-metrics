package de.mxro.metrics.examples;

import de.mxro.async.properties.PropertyNode;
import de.mxro.metrics.jre.Metrics;

public class ExampleCounter {

    public static void main(final String[] args) {

        final PropertyNode m = Metrics.create();

        m.record(Metrics.increment("counter"));
        m.record(Metrics.increment("counter"));
        m.record(Metrics.decrement("counter"));

        m.print();

        m.stop().get();

    }

}
