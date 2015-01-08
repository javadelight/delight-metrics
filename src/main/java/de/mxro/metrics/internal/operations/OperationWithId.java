package de.mxro.metrics.internal.operations;

import de.mxro.metrics.helpers.RecordOperation;
import de.mxro.metrics.helpers.MetricsData;

public abstract class OperationWithId implements RecordOperation {

    protected String id;

    @Override
    public abstract void perform(MetricsData data);

    public OperationWithId setId(final String id) {
        this.id = id;
        return this;
    }

}
