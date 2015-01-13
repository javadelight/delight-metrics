package de.mxro.metrics.internal.operations;

import com.codahale.metrics.Counter;

import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.operations.PropertyOperationWithId;

public class CounterEvent extends PropertyOperationWithId {

    private final long increment;

    @Override
    public void perform(final PropertyData data) {
        final Counter counter = data.get(id, Counter.class);

        counter.inc(increment);
    }

    public CounterEvent(final long increment) {
        super();
        this.increment = increment;
    }

}
