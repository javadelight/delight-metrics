package de.mxro.metrics.internal.operations;

import delight.async.properties.PropertyData;
import delight.async.properties.operations.PropertyOperationWithId;

import com.codahale.metrics.Histogram;

public class HistrogramEvent extends PropertyOperationWithId<Long> {

    private final long value;

    @Override
    public Long perform(final PropertyData data) {

        final Histogram hist = data.get(id, Histogram.class);

        hist.update(value);

        return value;

    }

    public HistrogramEvent(final long value) {
        super();
        this.value = value;
    }

}
