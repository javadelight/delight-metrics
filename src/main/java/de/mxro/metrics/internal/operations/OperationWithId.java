package de.mxro.metrics.internal.operations;

import de.mxro.metrics.MetricOperation;
import de.mxro.metrics.MetricsData;

public abstract class OperationWithId implements MetricOperation {

    protected String id;

    @Override
    public abstract void perform(MetricsData data);

    public OperationWithId(final String id) {
        super();
        this.id = id;
    }

}
