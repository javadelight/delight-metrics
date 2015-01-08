package de.mxro.metrics.internal.operations;

import de.mxro.metrics.helpers.MetricOperation;
import de.mxro.metrics.helpers.MetricsData;

public abstract class OperationWithId implements MetricOperation {

    protected String id;

    @Override
    public abstract void perform(MetricsData data);

    public OperationWithId setId(final String id) {
        this.id = id;
        return this;
    }

}
