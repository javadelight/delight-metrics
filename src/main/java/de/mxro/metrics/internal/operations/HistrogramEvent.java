package de.mxro.metrics.internal.operations;

import com.codahale.metrics.Histogram;

import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.operations.PropertyOperationWithId;

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
