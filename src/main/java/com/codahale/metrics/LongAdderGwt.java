package com.codahale.metrics;

public class LongAdderGwt implements LongAdder {

    private long value = 0;

    @Override
    public void add(final long x) {
        value += x;
    }

    @Override
    public void increment() {
        value += 1;
    }

    @Override
    public void decrement() {
        value -= 1;
    }

    @Override
    public long sum() {
        return value;
    }

    @Override
    public void reset() {
        value = 0;
    }

    @Override
    public long sumThenReset() {
        final long saveVal = value;
        value = 0;
        return saveVal;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public int intValue() {
        return (int) value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

}
