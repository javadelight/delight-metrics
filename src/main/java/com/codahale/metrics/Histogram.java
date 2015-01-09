package com.codahale.metrics;

import de.mxro.json.HasJSON;
import de.mxro.json.JSON;
import de.mxro.json.internal.JSONImpl;

/**
 * A metric which calculates the distribution of a value.
 *
 * @see <a href="http://www.johndcook.com/standard_deviation.html">Accurately
 *      computing running variance</a>
 */
public class Histogram implements Metric, Sampling, Counting, HasJSON {
    private final Reservoir reservoir;
    private final LongAdder count;

    /**
     * Creates a new {@link Histogram} with the given reservoir.
     *
     * @param reservoir
     *            the reservoir to create a histogram from
     */
    public Histogram(final Reservoir reservoir) {
        this.reservoir = reservoir;
        this.count = new LongAdder();
    }

    /**
     * Adds a recorded value.
     *
     * @param value
     *            the length of the value
     */
    public void update(final int value) {
        update((long) value);
    }

    /**
     * Adds a recorded value.
     *
     * @param value
     *            the length of the value
     */
    public void update(final long value) {
        count.increment();
        reservoir.update(value);
    }

    /**
     * Returns the number of values recorded.
     *
     * @return the number of values recorded
     */
    @Override
    public long getCount() {
        return count.longValue();
    }

    @Override
    public Snapshot getSnapshot() {
        return reservoir.getSnapshot();
    }

    @Override
    public String toString() {

        return getJSON().render();
    }

    @Override
    public JSON getJSON() {
        final JSON o = new JSONImpl();
        final Snapshot snap = getSnapshot();
        o.add("Mean", snap.getMean());
        o.add("Standard Deviation", snap.getStdDev());
        o.add("Max", snap.getMax());
        o.add("Min", snap.getMin());
        o.add("75% of Values Smaller Than", snap.get75thPercentile());
        o.add("95% of Values Smaller Than", snap.get95thPercentile());
        o.add("98% of Values Smaller Than", snap.get98thPercentile());
        o.add("Measurements", getCount());
        return o;
    }

}