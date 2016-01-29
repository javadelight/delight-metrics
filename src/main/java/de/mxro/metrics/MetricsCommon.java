package de.mxro.metrics;

import delight.async.properties.PropertiesCommon;
import delight.async.properties.PropertyNode;
import delight.async.properties.PropertyOperation;
import delight.factories.Configuration;
import delight.factories.Dependencies;
import delight.factories.Factory;

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
        return PropertiesCommon.createUnsafe(
                PropertiesCommon.compositeFactory(new MetricsFactory(), PropertiesCommon.defaultFactory()));
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

    public static PropertyOperation<Long> happened(final String id) {
        return new MarkEvent().setId(id);
    }

    public static PropertyOperation<Long> increment(final String id) {
        return new CounterEvent(1).setId(id);
    }

    public static PropertyOperation<Long> increment(final String id, final long by) {
        return new CounterEvent(by).setId(id);
    }

    public static PropertyOperation<Long> decrement(final String id) {
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
    public static PropertyOperation<Long> value(final String id, final long value) {
        return new HistrogramEvent(value).setId(id);
    }

    private static PropertyNode instance;

    public static PropertyNode get() {
        return instance;
    }

    public static void inject(final PropertyNode propertyNode) {
        instance = propertyNode;
    }

}
