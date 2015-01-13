package de.mxro.metrics.internal.operations;

import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.PropertyOperation;

public abstract class OperationWithId implements PropertyOperation {

    protected String id;

    @Override
    public abstract void perform(PropertyData data);

    public OperationWithId setId(final String id) {
        this.id = id;
        return this;
    }

}
