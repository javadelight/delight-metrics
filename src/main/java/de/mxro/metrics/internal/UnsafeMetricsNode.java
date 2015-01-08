package de.mxro.metrics.internal;

import de.mxro.metrics.MetricOperation;
import de.mxro.metrics.MetricsData;
import de.mxro.metrics.MetricsNode;

/**
 * A non-thread safe implementation of {@link MetricsNode}.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class UnsafeMetricsNode implements MetricsNode {

    private final MetricsData data;

    @Override
    public void record(final MetricOperation op) {

    }

    public UnsafeMetricsNode() {
        super();
        this.data = new MetricsDataImpl();
    }

}
