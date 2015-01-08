package de.mxro.metrics.helpers;

public interface MetricsData {

    public <T> T assertEntry(String id, Class<T> type);

}