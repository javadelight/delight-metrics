[![Build Status](https://travis-ci.org/javadelight/delight-metrics.svg)](https://travis-ci.org/javadelight/delight-metrics)

# Lightweight Java Metrics

This library provides a simple
 way to report metrics for Java applications based on the [Dropwizard Metrics Project](https://dropwizard.github.io/metrics/3.1.0/)
 and the [Async Properties](https://github.com/javadelight/delight-async-properties) library.

**Why** Other metric frameworks are often complex and feature-rich. 
This framework is composed of a small set of core classes; thus, it is easy to understand and plug into various environments.

## Usage

### Keeping a count

For instance: How many users are logged into the system concurrently?

```java
PropertyNode m = Metrics.create();

m.record(Metrics.increment("users"));
m.record(Metrics.increment("users"));
m.record(Metrics.decrement("users"));

m.print();

m.stop().get();
```

Should result in the output:

```
{
    'users': '1'
}
```

### Measure Operations per Second

For instance: How many times per second is a service called?

```java
final PropertyNode m = Metrics.create();

m.record(Metrics.happened("serviceCalled"));
m.record(Metrics.happened("serviceCalled"));
m.record(Metrics.happened("serviceCalled"));

Thread.sleep(10000);

m.print();

m.stop().get();
```

Should result in the output:

```
{
    'serviceCalled': {
        'Total Events': '3',
        'Events per Second (last Minute)': '0.552026648777594',
        'Events per Second (last 5 Minutes)': '0.5900828722929705',
        'Events per Second (last 15 Minutes)': '0.5966759088029381'
    }
}
```

### Calculate Statistics

For instance: How large are received requests in average?

```Java
final PropertyNode m = Metrics.create();

m.record(Metrics.value("requestSize", 300));
m.record(Metrics.value("requestSize", 100));
m.record(Metrics.value("requestSize", 200));

m.print();

m.stop().get();
```

Should result in.

```
{
    'requestSize': {
        'Mean': '200.0',
        'Standard Deviation': '100.0',
        'Max': '300',
        'Min': '100',
        '75% of Values Smaller Than': '300.0',
        '95% of Values Smaller Than': '300.0',
        '98% of Values Smaller Than': '300.0'
    }
}
```

### Reporting

Metrics are turned into easily human-readable strings. What you do with these is up to.

#### Retrieve Single Metric as String

```java
PropertyNode m = ...

String metric = m.retrieve("metricId").get().toString()
```


#### Retrieve All Metrics as String

```java
PropertyNode m = ...

String metrics = m.render().get();

```



## Compatibility

This project is compatible with the following environments:

- Java 1.6+
- GWT 2.5.0+
- Android (any)
- OSGi (any)

## Performance and Multi-Threading

A significant part of the internal implementation in the library is based on the [Dropwizard Metrics Project](https://dropwizard.github.io/metrics/3.1.0/). 
Thus, some of the performance characteristics are inherited from this project.

However, this project uses a different approach to multi-threading. While in the Dropwizard Metrics Project every metric and operation is synchronized 
independently, the Lightweight Java Metrics project synchronizes all operations in one place (see [SynchronizedMetricsNode.java](http://modules.appjangle.com/lightweight-java-metrics/latest/xref/de/mxro/metrics/internal/SynchronizedMetricsNode.html)).

Thus, more operations can be performed within the scope of one thread. This might lead to better performance as compared to the Dropwizard Metrics Project in some case and to worse performance in others. 

## Further Resources

- [JavaDocs](http://modules.appjangle.com/delight-metrics/latest/apidocs/)
- [Project Reports](http://modules.appjangle.com/delight-metrics/latest/project-reports.html)
- [Rendered README](http://documentup.com/mxro/delight-metrics)



