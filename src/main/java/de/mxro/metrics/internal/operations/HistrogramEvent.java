package de.mxro.metrics.internal.operations;

import com.codahale.metrics.Histogram;

import de.mxro.async.properties.PropertyData;

public class HistrogramEvent extends OperationWithId {

    private final long value;

    @Override
    public void perform(final PropertyData data) {

        final Histogram hist = data.get(id, Histogram.class);

        hist.update(value);

    }

    public HistrogramEvent(final long value) {
        super();
        this.value = value;
    }

}
