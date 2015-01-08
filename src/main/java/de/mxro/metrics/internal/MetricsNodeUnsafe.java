package de.mxro.metrics.internal;

import java.util.Map;

import com.codahale.metrics.Meter;

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
        final Object object = metrics.get(id);

        if (!(object instanceof Meter)) {
            throw new RuntimeException("Id " + id + " is assigned the incompatible metrics type [" + object.getClass()
                    + "]");
        }

    }

    public MetricsNodeUnsafe() {
        super();

    }

}
