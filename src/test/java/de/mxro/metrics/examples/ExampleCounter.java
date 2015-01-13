package de.mxro.metrics.examples;

import de.mxro.async.properties.PropertyNode;
import de.mxro.metrics.jre.Metrics;

public class ExampleCounter {

    public static void main(final String[] args) {

        final PropertyNode m = Metrics.create();

        m.perform(Metrics.increment("counter"));
        m.perform(Metrics.increment("counter"));
        m.perform(Metrics.decrement("counter"));

        m.print();

        m.stop().get();

    }

}
