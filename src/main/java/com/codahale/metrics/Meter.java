package com.codahale.metrics;

import java.util.concurrent.TimeUnit;

/**
 * A meter metric which measures mean throughput and one-, five-, and
 * fifteen-minute exponentially-weighted moving average throughputs.
 *
 * @see EWMA
 */
public class Meter implements Metered {
    private static final long TICK_INTERVAL = TimeUnit.MILLISECONDS.toNanos(5);// TimeUnit.SECONDS.toNanos(5);

    private final EWMA m1Rate = EWMA.oneMinuteEWMA();
    private final EWMA m5Rate = EWMA.fiveMinuteEWMA();
    private final EWMA m15Rate = EWMA.fifteenMinuteEWMA();

    private final LongAdder count = new LongAdder();
    private final long startTime;
    private long lastTick;
    private final Clock clock;

    /**
     * Creates a new {@link Meter}.
     */
    public Meter() {
        this(Clock.defaultClock());
    }

    /**
     * Creates a new {@link Meter}.
     *
     * @param clock
     *            the clock to use for the meter ticks
     */
    public Meter(final Clock clock) {
        this.clock = clock;
        this.startTime = this.clock.getTick();
        this.lastTick = startTime;
    }

    /**
     * Mark the occurrence of an event.
     */
    public void mark() {
        mark(1);
    }

    /**
     * Mark the occurrence of a given number of events.
     *
     * @param n
     *            the number of events
     */
    public void mark(final long n) {
        tickIfNecessary();
        count.add(n);
        m1Rate.update(n);
        m5Rate.update(n);
        m15Rate.update(n);
    }

    private void tickIfNecessary() {
        final long oldTick = lastTick;
        final long newTick = clock.getTick();
        final long age = newTick - oldTick;
        System.out.println("age " + TICK_INTERVAL + " " + age);
        if (age > TICK_INTERVAL) {
            final long newIntervalStartTick = newTick - age % TICK_INTERVAL;
            if (lastTick == oldTick) {
                System.out.println("tick it " + newTick);
                lastTick = newIntervalStartTick;
                final long requiredTicks = age / TICK_INTERVAL;
                for (long i = 0; i < requiredTicks; i++) {
                    m1Rate.tick();
                    m5Rate.tick();
                    m15Rate.tick();
                }
            }

        }
    }

    @Override
    public long getCount() {
        return count.sum();
    }

    @Override
    public double getFifteenMinuteRate() {
        tickIfNecessary();
        return m15Rate.getRate(TimeUnit.SECONDS);
    }

    @Override
    public double getFiveMinuteRate() {
        tickIfNecessary();
        return m5Rate.getRate(TimeUnit.SECONDS);
    }

    @Override
    public double getMeanRate() {
        if (getCount() == 0) {
            return 0.0;
        } else {
            final double elapsed = (clock.getTick() - startTime);
            return getCount() / elapsed * TimeUnit.SECONDS.toNanos(1);
        }
    }

    @Override
    public double getOneMinuteRate() {
        tickIfNecessary();
        return m1Rate.getRate(TimeUnit.SECONDS);
    }

    @Override
    public String toString() {
        final JSON o = new JSON();
        o.add("count", count);
        o.add("m1Rate", m1Rate);
        o.add("m5Rate", m5Rate);
        o.add("m15Rate", m15Rate);
        return o.render();
    }

}
