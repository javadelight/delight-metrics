package de.mxro.metrics.helpers;

public interface PropertyData {

    public <T> T get(String id, Class<T> type);

    public Object get(String id);

}