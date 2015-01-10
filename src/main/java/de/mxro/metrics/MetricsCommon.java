package de.mxro.metrics;

import de.mxro.factories.Configuration;
import de.mxro.factories.Dependencies;
import de.mxro.factories.Factory;
import de.mxro.metrics.helpers.MetricsConfiguration;
import de.mxro.metrics.helpers.RecordOperation;
import de.mxro.metrics.internal.UnsafeMetricsNode;
import de.mxro.metrics.internal.operations.CounterEvent;
import de.mxro.metrics.internal.operations.HistrogramEvent;
import de.mxro.metrics.internal.operations.MarkEvent;

/**
 * <p>
 * List of operations which are compatible with Java JRE and GWT environments.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class MetricsCommon {

    /**
     * <p>
     * Creates a metric node, which is not thread safe. Only use in
     * single-threaded applications or environments (such as GWT/JavaScript).
     * 
     * @return
     */
    public static MetricsNode createUnsafe() {
        return new UnsafeMetricsNode();
    }

    public static Factory<?, ?, ?> createUnsafeFactory() {
        return new Factory<MetricsNode, Configuration, Dependencies>() {

            @Override
            public boolean canInstantiate(final Configuration conf) {

                return conf instanceof MetricsConfiguration;
            }

            @Override
            public MetricsNode create(final Configuration conf, final Dependencies dependencies) {
                return MetricsCommon.createUnsafe();
            }
        };
    }

    public static RecordOperation happened(final String id) {
        return new MarkEvent().setId(id);
    }

    public static RecordOperation increment(final String id) {
        return new CounterEvent(1).setId(id);
    }

    public static RecordOperation decrement(final String id) {
        return new CounterEvent(-1).setId(id);
    }

    /**
     * Record a value and alter retrieve various statistics for the value, such
     * as the mean etc.
     * 
     * @param id
     * @param value
     * @return
     */
    public static RecordOperation value(final String id, final long value) {
        return new HistrogramEvent(value).setId(id);
    }

}
