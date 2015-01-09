package de.mxro.metrics.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.codahale.metrics.JSON;
import com.codahale.metrics.JSONSerialization;

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
            final Object newEntry = new MetricsFactory().create(type);
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
    public String toString() {
        final JSON o = new JSON();

        for (final Entry<String, Object> e : metrics.entrySet()) {
            Object value;
            if (e.getValue() instanceof JSONSerialization) {
                value = ((JSONSerialization) e.getValue()).getJSON();
            } else {
                value = e.getValue();
            }

        }
    }

}
