package de.mxro.metrics.internal;

import delight.async.properties.PropertyFactory;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.UniformReservoir;

public class MetricsFactory implements PropertyFactory {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T create(final Class<T> type) {

        if (type.equals(Meter.class)) {
            return (T) new Meter();
        }

        if (type.equals(Counter.class)) {
            return (T) new Counter();
        }

        if (type.equals(Histogram.class)) {
            return (T) new Histogram(new UniformReservoir());
        }

        return null;

    }

}
