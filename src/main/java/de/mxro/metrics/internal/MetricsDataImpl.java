package de.mxro.metrics.internal;

import java.util.Map;

import de.mxro.metrics.MetricsNode;

/**
 * A non-thread safe implementation of {@link MetricsNode}
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class MetricsDataImpl implements MetricsData {

    Map<String, Object> metrics;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T assertType(final String id, final Class<T> type) {
        final Object object = metrics.get(id);

        if (!(object.getClass().equals(type))) {
            throw new RuntimeException("Id " + id + " is assigned the incompatible metrics type [" + object.getClass()
                    + "]. Expected: " + type);
        }

        return (T) object;
    }

    public MetricsDataImpl() {
        super();

    }

}
