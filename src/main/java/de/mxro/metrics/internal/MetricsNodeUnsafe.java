package de.mxro.metrics.internal;

import java.util.Map;

import de.mxro.metrics.MetricsNode;

/**
 * A non-thread safe implementation of {@link MetricsNode}
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class MetricsNodeUnsafe implements MetricsNode {

    Map<String, Object> metrics;

    @Override
    public void meter(final String id) {

    }

    public MetricsNodeUnsafe() {
        super();

    }

}
