package de.mxro.metrics.internal.operations;

import delight.async.properties.PropertyData;
import delight.async.properties.operations.PropertyOperationWithId;

import com.codahale.metrics.Counter;

public class CounterEvent extends PropertyOperationWithId<Long> {

    private final long increment;

    @Override
    public Long perform(final PropertyData data) {
        final Counter counter = data.get(id, Counter.class);

        counter.inc(increment);

        return counter.getCount();
    }

    public CounterEvent(final long increment) {
        super();
        this.increment = increment;
    }

}
