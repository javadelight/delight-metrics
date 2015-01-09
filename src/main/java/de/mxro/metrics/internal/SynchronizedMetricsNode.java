package de.mxro.metrics.internal;

import de.mxro.async.Promise;
import de.mxro.async.callbacks.ValueCallback;
import de.mxro.concurrency.schedule.AccessThread;
import de.mxro.concurrency.schedule.Step;
import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.helpers.RecordOperation;

public class SynchronizedMetricsNode implements MetricsNode {

    private final UnsafeMetricsNode decorated;

    private final AccessThread accessThread;

    @Override
    public void record(final RecordOperation op) {
        accessThread.offer(new Step() {

            @Override
            public void process() {
                decorated.record(op);
            }
        });
    }

    public SynchronizedMetricsNode(final UnsafeMetricsNode decorated, final AccessThread accessThread) {
        super();
        this.decorated = decorated;
        this.accessThread = accessThread;
    }

    @Override
    public <T> Promise<T> retrieve(final String id, final Class<T> type) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> void retrieve(final String id, final Class<T> type, final ValueCallback<T> cb) {
        this.accessThread.offer(new Step() {

            @Override
            public void process() {

            }
        });
    }

    @Override
    public Promise<Object> retrieve(final String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void retrieve(final String id, final ValueCallback<Object> cb) {

    }

}
