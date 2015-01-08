package de.mxro.metrics.internal;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;

public class MetricsFactory {

    @SuppressWarnings("unchecked")
    public <T> T create(final Class<T> type) {

        if (type.equals(Meter.class)) {
            return (T) new Meter();
        }

        if (type.equals(Counter.class)) {
            return (T) new Counter();
        }

        throw new RuntimeException("Cannot create metric of type [" + type.getClass() + "]");

    }

}
