package de.mxro.metrics.internal.operations;

import com.codahale.metrics.Counter;

import de.mxro.metrics.helpers.MetricsData;

public class CounterEvent extends OperationWithId {

    @Override
    public void perform(final MetricsData data) {
        final Counter counter = data.get(id, Counter.class);
    }

}
