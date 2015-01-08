package de.mxro.metrics.internal.operations;

import com.codahale.metrics.Histogram;

import de.mxro.metrics.helpers.MetricsData;

public class HistrogramEvent extends OperationWithId {

    private final int value;

    @Override
    public void perform(final MetricsData data) {

        final Histogram hist = data.get(id, Histogram.class);

        hist.update(value);

    }

    public HistrogramEvent(final int value) {
        super();
        this.value = value;
    }

}
