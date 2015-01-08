package de.mxro.metrics.internal;

public interface MetricsData {

    public <T> T assertType(String id, Class<T> type);

}