package de.mxro.metrics;

import de.mxro.async.callbacks.ValueCallback;
import de.mxro.fn.Success;
import de.mxro.metrics.helpers.RecordOperation;
import de.mxro.promise.Promise;

/**
 * <p>
 * Stores a set of metrics by id.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public interface MetricsNode {

    /**
     * Records the specified operation for the affected metrics.
     * 
     * @param op
     */
    public void record(RecordOperation op);

    /**
     * Retrieves a metric with a specified type and id.
     * 
     * @param id
     * @param type
     * @return
     */
    public <T> Promise<T> retrieve(String id, Class<T> type);

    /**
     * Retrieves a metric with a specified type and id.
     * 
     * @param id
     * @param type
     * @param cb
     */
    public <T> void retrieve(String id, Class<T> type, ValueCallback<T> cb);

    /**
     * <p>
     * Retrieves a metric with the specified id.
     * 
     * @param id
     * @return
     */
    public Promise<Object> retrieve(String id);

    /**
     * Retrieves a metric with the specified id.
     * 
     * @param id
     * @param cb
     */
    public void retrieve(String id, ValueCallback<Object> cb);

    public Promise<Success> stop();

    public void stop(ValueCallback<Success> cb);

    /**
     * Prints all metrics to standard out.
     */
    public void print();

    /**
     * Returns a {@link String} representation of all metrics.
     */
    public Promise<String> render();

    /**
     * Returns a {@link String} representation of all metrics.
     */
    public void render(ValueCallback<String> cb);
}
