package de.mxro.metrics.internal.operations;

import de.mxro.metrics.helpers.PropertyOperation;
import de.mxro.metrics.helpers.PropertyData;

public abstract class OperationWithId implements PropertyOperation {

    protected String id;

    @Override
    public abstract void perform(PropertyData data);

    public OperationWithId setId(final String id) {
        this.id = id;
        return this;
    }

}
