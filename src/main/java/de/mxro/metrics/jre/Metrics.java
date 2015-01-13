package de.mxro.metrics.jre;

import de.mxro.async.properties.PropertyNode;
import de.mxro.concurrency.jre.ConcurrencyJre;
import de.mxro.concurrency.schedule.AccessThread;
import de.mxro.concurrency.schedule.BetterAccessThreadImplementation;
import de.mxro.factories.Configuration;
import de.mxro.factories.Dependencies;
import de.mxro.factories.Factory;
import de.mxro.metrics.MetricsCommon;
import de.mxro.metrics.helpers.MetricsConfiguration;
import de.mxro.metrics.internal.SynchronizedMetricsNode;
import de.mxro.promise.jre.Promises;

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
        final AccessThread accessThread = new BetterAccessThreadImplementation(ConcurrencyJre.create());

        return new SynchronizedMetricsNode(createUnsafe(), accessThread, Promises.factory());

    }

    public static Factory<?, ?, ?> createFactory() {
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

}
