package de.mxro.metrics.internal.operations;

import com.codahale.metrics.Meter;

import de.mxro.metrics.MetricsData;

public class MarkMeter extends OperationWithId {

    @Override
    public void perform(final MetricsData data) {
        final Meter meter = data.assertEntry(id, Meter.class);

        meter.mark();
    }

    public MarkMeter(final String id) {
        super(id);
    }

}
