package de.mxro.metrics.internal;

import java.util.HashMap;
import java.util.Map;

import com.codahale.metrics.Meter;

import de.mxro.metrics.helpers.MetricsData;

/**
 * 
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class MetricsDataImpl implements MetricsData {

    Map<String, Object> metrics;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(final String id, final Class<T> type) {
        final Object object = metrics.get(id);

        if (object == null) {
            Object newEntry;
            if (type.equals(Meter.class)) {
                newEntry = new Meter();
            } else {
                throw new RuntimeException("Cannot create metric of type [" + type.getClass() + "]");
            }

            metrics.put(id, newEntry);
            return (T) newEntry;
        }

        if (!(object.getClass().equals(type))) {
            throw new RuntimeException("Id " + id + " is assigned the incompatible metrics type [" + object.getClass()
                    + "]. Expected: " + type);
        }

        return (T) object;
    }

    public MetricsDataImpl() {
        super();
        this.metrics = new HashMap<String, Object>();
    }

    @Override
    public Object get(final String id) {
        return metrics.get(id);
    }

    @Override
    public String toString(final String id) {
        final Object object = this.get(id);
        if (object == null) {
            throw new RuntimeException("No entry defined for id [" + id + "]");
        }
        return object.toString();
    }

}
