package de.mxro.metrics.internal.operations;

import com.codahale.metrics.Meter;

import de.mxro.metrics.helpers.PropertyData;

public class MarkEvent extends OperationWithId {

    @Override
    public void perform(final PropertyData data) {
        final Meter meter = data.get(id, Meter.class);

        meter.mark();
    }

}
