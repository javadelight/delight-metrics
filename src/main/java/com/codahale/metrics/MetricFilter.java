package com.codahale.metrics;

/**
 * A filter used to determine whether or not a metric should be reported, among other things.
 */
public abstract class MetricFilter {
    /**
     * Matches all metrics, regardless of type or name.
     */
    public static MetricFilter ALL = new MetricFilter() {
		
		
		
		@Override
		public boolean matches(String name, Metric metric) {
			
			return true;
		}
		
		
	}; 
    		

    public static MetricFilter startsWith(final String prefix) {
        return new MetricFilter() {
    		
    		
    		
    		@Override
    		public boolean matches(String name, Metric metric) {
    			
    			return name.startsWith(prefix);
    		}
    		
    		
    	}; 
        		
        		
    }

    static MetricFilter endsWith(final String suffix) {
        return new MetricFilter() {
    		
    		
    		
    		@Override
    		public boolean matches(String name, Metric metric) {
    			
    			return name.endsWith(suffix);
    		}
    		
    		
    	};  
        		
        	
    }

    static MetricFilter contains(final String substring) {
        return new MetricFilter() {
    		
    		
    		
    		@Override
    		public boolean matches(String name, Metric metric) {
    			
    			return name.contains(substring);
    		}
    		
    		
    	}; 
        		
        		
    }

    /**
     * Returns {@code true} if the metric matches the filter; {@code false} otherwise.
     *
     * @param name   the metric's name
     * @param metric the metric
     * @return {@code true} if the metric matches the filter
     */
    abstract boolean matches(String name, Metric metric);
}