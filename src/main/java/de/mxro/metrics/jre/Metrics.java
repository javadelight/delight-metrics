package de.mxro.metrics.jre;

import de.mxro.async.jre.AsyncJre;
import de.mxro.concurrency.jre.ConcurrencyJre;
import de.mxro.concurrency.schedule.AccessThread;
import de.mxro.concurrency.schedule.BetterAccessThreadImplementation;
import de.mxro.metrics.MetricsCommon;
import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.internal.SynchronizedMetricsNode;

/**
 * <p>
 * Convenient class to create new {@link MetricsNode}s and various metric
 * operations.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class Metrics extends MetricsCommon {

    public static MetricsNode create() {
        final AccessThread accessThread = new BetterAccessThreadImplementation(ConcurrencyJre.create());

        return new SynchronizedMetricsNode(createUnsafe(), accessThread, AsyncJre.promiseFactory());

    }

}
