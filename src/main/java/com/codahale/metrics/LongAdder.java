package com.codahale.metrics;

public interface LongAdder {

    /**
     * Adds the given value.
     *
     * @param x
     *            the value to add
     */
    public void add(long x);

    /**
     * Equivalent to {@code add(1)}.
     */
    public void increment();

    /**
     * Equivalent to {@code add(-1)}.
     */
    public void decrement();

    /**
     * Returns the current sum. The returned value is <em>NOT</em> an atomic
     * snapshot; invocation in the absence of concurrent updates returns an
     * accurate result, but concurrent updates that occur while the sum is being
     * calculated might not be incorporated.
     *
     * @return the sum
     */
    public long sum();

    /**
     * Resets variables maintaining the sum to zero. This method may be a useful
     * alternative to creating a new adder, but is only effective if there are
     * no concurrent updates. Because this method is intrinsically racy, it
     * should only be used when it is known that no threads are concurrently
     * updating.
     */
    public void reset();

    /**
     * Equivalent in effect to {@link #sum} followed by {@link #reset}. This
     * method may apply for example during quiescent points between
     * multithreaded computations. If there are updates concurrent with this
     * method, the returned value is <em>not</em> guaranteed to be the final
     * value occurring before the reset.
     *
     * @return the sum
     */
    public long sumThenReset();

    /**
     * Returns the String representation of the {@link #sum}.
     *
     * @return the String representation of the {@link #sum}
     */
    @Override
    public String toString();

    /**
     * Equivalent to {@link #sum}.
     *
     * @return the sum
     */
    public long longValue();

    /**
     * Returns the {@link #sum} as an {@code int} after a narrowing primitive
     * conversion.
     */
    public int intValue();

    /**
     * Returns the {@link #sum} as a {@code float} after a widening primitive
     * conversion.
     */
    public float floatValue();

    /**
     * Returns the {@link #sum} as a {@code double} after a widening primitive
     * conversion.
     */
    public double doubleValue();

}