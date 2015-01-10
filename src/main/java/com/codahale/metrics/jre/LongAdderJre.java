/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 *
 * http://gee.cs.oswego.edu/cgi-bin/viewcvs.cgi/jsr166/src/jsr166e/LongAdder.java?revision=1.14&view=markup
 */

package com.codahale.metrics.jre;

import java.io.Serializable;

import com.codahale.metrics.LongAdder;

// CHECKSTYLE:OFF
/**
 * One or more variables that together maintain an initially zero {@code long}
 * sum. When updates (method {@link #add}) are contended across threads, the set
 * of variables may grow dynamically to reduce contention. Method {@link #sum}
 * (or, equivalently, {@link #longValue}) returns the current total combined
 * across the variables maintaining the sum.
 * <p/>
 * <p>
 * This class is usually preferable to AtomicLong when multiple threads update a
 * common sum that is used for purposes such as collecting statistics, not for
 * fine-grained synchronization control. Under low update contention, the two
 * classes have similar characteristics. But under high contention, expected
 * throughput of this class is significantly higher, at the expense of higher
 * space consumption.
 * <p/>
 * <p>
 * This class extends {@link Number}, but does <em>not</em> define methods such
 * as {@code equals}, {@code hashCode} and {@code compareTo} because instances
 * are expected to be mutated, and so are not useful as collection keys.
 * <p/>
 * <p>
 * <em>jsr166e note: This class is targeted to be placed in java.util.concurrent.atomic.</em>
 *
 * @author Doug Lea
 * @since 1.8
 */
@SuppressWarnings("all")
public class LongAdderJre extends Striped64 implements Serializable, LongAdder {
    private static final long serialVersionUID = 7249069246863182397L;

    /**
     * Version of plus for use in retryUpdate
     */
    @Override
    final long fn(final long v, final long x) {
        return v + x;
    }

    /**
     * Creates a new adder with initial sum of zero.
     */
    public LongAdderJre() {
    }

    /**
     * Adds the given value.
     *
     * @param x
     *            the value to add
     */
    @Override
    public void add(final long x) {
        Cell[] as;
        long b, v;
        HashCode hc;
        Cell a;
        int n;
        if ((as = cells) != null || !casBase(b = base, b + x)) {
            boolean uncontended = true;
            final int h = (hc = threadHashCode.get()).code;
            if (as == null || (n = as.length) < 1 || (a = as[(n - 1) & h]) == null
                    || !(uncontended = a.cas(v = a.value, v + x))) {
                retryUpdate(x, hc, uncontended);
            }
        }
    }

    /**
     * Equivalent to {@code add(1)}.
     */
    @Override
    public void increment() {
        add(1L);
    }

    /**
     * Equivalent to {@code add(-1)}.
     */
    @Override
    public void decrement() {
        add(-1L);
    }

    /**
     * Returns the current sum. The returned value is <em>NOT</em> an atomic
     * snapshot; invocation in the absence of concurrent updates returns an
     * accurate result, but concurrent updates that occur while the sum is being
     * calculated might not be incorporated.
     *
     * @return the sum
     */
    @Override
    public long sum() {
        long sum = base;
        final Cell[] as = cells;
        if (as != null) {
            final int n = as.length;
            for (int i = 0; i < n; ++i) {
                final Cell a = as[i];
                if (a != null) {
                    sum += a.value;
                }
            }
        }
        return sum;
    }

    /**
     * Resets variables maintaining the sum to zero. This method may be a useful
     * alternative to creating a new adder, but is only effective if there are
     * no concurrent updates. Because this method is intrinsically racy, it
     * should only be used when it is known that no threads are concurrently
     * updating.
     */
    @Override
    public void reset() {
        internalReset(0L);
    }

    /**
     * Equivalent in effect to {@link #sum} followed by {@link #reset}. This
     * method may apply for example during quiescent points between
     * multithreaded computations. If there are updates concurrent with this
     * method, the returned value is <em>not</em> guaranteed to be the final
     * value occurring before the reset.
     *
     * @return the sum
     */
    @Override
    public long sumThenReset() {
        long sum = base;
        final Cell[] as = cells;
        base = 0L;
        if (as != null) {
            final int n = as.length;
            for (int i = 0; i < n; ++i) {
                final Cell a = as[i];
                if (a != null) {
                    sum += a.value;
                    a.value = 0L;
                }
            }
        }
        return sum;
    }

    /**
     * Returns the String representation of the {@link #sum}.
     *
     * @return the String representation of the {@link #sum}
     */
    @Override
    public String toString() {
        return Long.toString(sum());
    }

    /**
     * Equivalent to {@link #sum}.
     *
     * @return the sum
     */
    @Override
    public long longValue() {
        return sum();
    }

    /**
     * Returns the {@link #sum} as an {@code int} after a narrowing primitive
     * conversion.
     */
    @Override
    public int intValue() {
        return (int) sum();
    }

    /**
     * Returns the {@link #sum} as a {@code float} after a widening primitive
     * conversion.
     */
    @Override
    public float floatValue() {
        return sum();
    }

    /**
     * Returns the {@link #sum} as a {@code double} after a widening primitive
     * conversion.
     */
    @Override
    public double doubleValue() {
        return sum();
    }

}
// CHECKSTYLE:ON