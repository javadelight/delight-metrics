package de.mxro.metrics.internal.operations;

import com.codahale.metrics.Counter;

import de.mxro.metrics.helpers.MetricsData;

public class CounterEvent extends OperationWithId {

    private final long increment;

    @Override
    public void perform(final MetricsData data) {
        final Counter counter = data.get(id, Counter.class);

        counter.inc(increment);
    }

    public CounterEvent(final long increment) {
        super();
        this.increment = increment;
    }

}
