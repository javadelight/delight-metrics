package de.mxro.metrics.jre;

import delight.async.properties.PropertiesCommon;
import delight.async.properties.PropertyNode;
import delight.async.properties.jre.Properties;
import delight.factories.Configuration;
import delight.factories.Dependencies;
import delight.factories.Factory;

import de.mxro.metrics.MetricsCommon;
import de.mxro.metrics.MetricsConfiguration;
import de.mxro.metrics.internal.MetricsFactory;

/**
 * <p>
 * Convenient class to create new {@link PropertyNode}s and various metric
 * operations.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class Metrics extends MetricsCommon {

    public static PropertyNode create() {
        return Properties
                .create(PropertiesCommon.compositeFactory(new MetricsFactory(), PropertiesCommon.defaultFactory()));
    }

    public static Factory<?, ?, ?> createMetricsFactory() {
        return new Factory<PropertyNode, Configuration, Dependencies>() {

            @Override
            public boolean canInstantiate(final Configuration conf) {

                return conf instanceof MetricsConfiguration;
            }

            @Override
            public PropertyNode create(final Configuration conf, final Dependencies dependencies) {
                return Metrics.create();
            }
        };
    }

    private static PropertyNode metrics;

    /**
     * <p>
     * Sets the default metrics instance which can be accessed via Metrics.get()
     * 
     * @param node
     */
    public static void inject(final PropertyNode node) {
        metrics = node;
        MetricsCommon.inject(node);
    }

    public static PropertyNode get() {
        return metrics;
    }

}
