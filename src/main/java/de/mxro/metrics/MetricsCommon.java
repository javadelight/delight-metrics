package de.mxro.metrics;

import de.mxro.async.properties.PropertiesCommon;
import de.mxro.async.properties.PropertyNode;
import de.mxro.async.properties.PropertyOperation;
import de.mxro.factories.Configuration;
import de.mxro.factories.Dependencies;
import de.mxro.factories.Factory;
import de.mxro.metrics.helpers.MetricsConfiguration;
import de.mxro.metrics.internal.MetricsFactory;
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
public class MetricsCommon extends PropertiesCommon {

    /**
     * <p>
     * Creates a metric node, which is not thread safe. Only use in
     * single-threaded applications or environments (such as GWT/JavaScript).
     * 
     * @return
     */
    public static PropertyNode createUnsafe() {
        return PropertiesCommon.createUnsafe(PropertiesCommon.compositeFactory(new MetricsFactory(),
                PropertiesCommon.defaultFactory()));
    }

    public static Factory<?, ?, ?> createUnsafeFactory() {
        return new Factory<PropertyNode, Configuration, Dependencies>() {

            @Override
            public boolean canInstantiate(final Configuration conf) {

                return conf instanceof MetricsConfiguration;
            }

            @Override
            public PropertyNode create(final Configuration conf, final Dependencies dependencies) {
                return MetricsCommon.createUnsafe();
            }
        };
    }

    public static PropertyOperation happened(final String id) {
        return new MarkEvent().setId(id);
    }

    public static PropertyOperation increment(final String id) {
        return new CounterEvent(1).setId(id);
    }

    public static PropertyOperation decrement(final String id) {
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
    public static PropertyOperation value(final String id, final long value) {
        return new HistrogramEvent(value).setId(id);
    }

}
