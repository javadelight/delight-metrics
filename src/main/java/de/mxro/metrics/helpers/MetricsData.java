package de.mxro.metrics.helpers;

public interface MetricsData {

    public <T> T get(String id, Class<T> type);

    public Object get(String id);

    public String toString(final String id);

}