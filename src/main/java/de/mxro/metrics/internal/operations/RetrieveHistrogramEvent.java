package de.mxro.metrics.internal.operations;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.Snapshot;

import delight.async.properties.PropertyData;
import delight.async.properties.operations.PropertyOperationWithId;

public class RetrieveHistrogramEvent extends PropertyOperationWithId<Snapshot> {


    @Override
    public Snapshot perform(final PropertyData data) {

        return data.get(id, Histogram.class).getSnapshot();

        

        

    }

    public RetrieveHistrogramEvent() {
        super();
       
    }

}
