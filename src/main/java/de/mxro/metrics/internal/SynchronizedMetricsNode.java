package de.mxro.metrics.internal;

import de.mxro.concurrency.schedule.AccessThread;
import de.mxro.concurrency.schedule.Step;
import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.helpers.MetricOperation;

public class SynchronizedMetricsNode implements MetricsNode {

    private final UnsafeMetricsNode decorated;

    private final AccessThread accessThread;

    @Override
    public void record(final MetricOperation op) {
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
    public <T> T get(final String id, final Class<T> type) {

        return decorated.get(id, type);
    }

    @Override
    public Object get(final String id) {
        return decorated.get(id);
    }

}
