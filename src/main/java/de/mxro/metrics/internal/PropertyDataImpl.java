package de.mxro.metrics.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.mxro.async.properties.PropertyData;
import de.mxro.json.HasJSON;
import de.mxro.json.JSON;
import de.mxro.json.internal.JSONImpl;

/**
 * 
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class PropertyDataImpl implements PropertyData, HasJSON {

    Map<String, Object> props;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(final String id, final Class<T> type) {
        final Object object = props.get(id);

        if (object == null) {
            final Object newEntry = new MetricsFactory().create(type);
            props.put(id, newEntry);
            return (T) newEntry;
        }

        if (!(object.getClass().equals(type))) {
            throw new RuntimeException("Id " + id + " is assigned the incompatible property type [" + object.getClass()
                    + "]. Expected: " + type);
        }

        return (T) object;
    }

    public PropertyDataImpl() {
        super();
        this.props = new HashMap<String, Object>();
    }

    @Override
    public Object get(final String id) {
        return props.get(id);
    }

    @Override
    public String toString() {
        return getJSON().render();
    }

    @Override
    public JSON getJSON() {
        final JSON o = new JSONImpl();

        for (final Entry<String, Object> e : props.entrySet()) {
            Object value;
            if (e.getValue() instanceof HasJSON) {
                value = ((HasJSON) e.getValue()).getJSON();
            } else {
                value = e.getValue();
            }
            o.add(e.getKey(), value);
        }
        return o;
    }

}
