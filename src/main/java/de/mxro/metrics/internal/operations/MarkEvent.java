package de.mxro.metrics.internal.operations;

import delight.async.properties.PropertyData;
import delight.async.properties.operations.PropertyOperationWithId;

import com.codahale.metrics.Meter;

public class MarkEvent extends PropertyOperationWithId<Long> {

    @Override
    public Long perform(final PropertyData data) {
        final Meter meter = data.get(id, Meter.class);

        meter.mark();

        return meter.getCount();
    }

}
