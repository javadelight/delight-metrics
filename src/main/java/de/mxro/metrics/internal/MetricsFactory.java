package de.mxro.metrics.internal;

import com.codahale.metrics.Counter;
import com.codahale.metrics.ExponentiallyDecayingReservoir;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Metric;

import de.mxro.metrics.MetricsCommon;
import delight.async.properties.PropertyFactory;

public class MetricsFactory implements PropertyFactory {

	private final <T> Metric createMetric(final Class<T> type) {
		if (type.equals(Meter.class)) {
            return new Meter();
        }

        if (type.equals(Counter.class)) {
            return new Counter();
        }

        if (type.equals(Histogram.class)) {
            return new Histogram(new ExponentiallyDecayingReservoir());
        }
        
        return null;
	}
	
    @Override
    @SuppressWarnings("unchecked")
    public <T> T create(final String id, final Class<T> type) {
    	
    	final Metric metric = createMetric(type);
    	
    	if (metric == null) {
    		return null;
    	}
    	
    	if (MetricsCommon.getMetricRegistry().getNames().contains(id)) {
    		MetricsCommon.getMetricRegistry().remove(id);
    	}
    	
    	MetricsCommon.getMetricRegistry().register(id, metric);
    	
    	return (T) metric;

    }

}
