package de.mxro.metrics.internal;

import de.mxro.concurrency.schedule.AccessThread;
import de.mxro.concurrency.schedule.Step;
import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.helpers.MetricOperation;
import de.mxro.metrics.helpers.MetricsData;

public class SynchronizedMetricsNode implements MetricsNode {

    private final UnsafeMetricsNode decorated;

    private final AccessThread accessThread;

    @Override
    public void record(final MetricOperation op) {
        accessThread.offer(new Step() {

            @Override
            public void process() {
                op.perform(decorated.data());
            }
        });
    }

    @Override
    public MetricsData data() {
        // TODO Auto-generated method stub
        return null;
    }

    public SynchronizedMetricsNode(final UnsafeMetricsNode decorated, final AccessThread accessThread) {
        super();
        this.decorated = decorated;
        this.accessThread = accessThread;
    }

}
