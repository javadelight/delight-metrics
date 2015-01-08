package de.mxro.metrics;

public interface MetricsData {

    public <T> T assertEntry(String id, Class<T> type);

}