package de.mxro.metrics.internal;

import com.codahale.metrics.Meter;

public class MetricsFactory {

    public <T> T create(final Class<T> type) {
        Object newEntry;
        if (type.equals(Meter.class)) {
            newEntry = new Meter();
        } else {
            throw new RuntimeException("Cannot create metric of type [" + type.getClass() + "]");
        }

        return (T) newEntry;
    }

}
