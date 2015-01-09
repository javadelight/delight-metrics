# lightweight-java-metrics

A very lightweight way to report metrics for Java applications based on the [Dropwizard Metrics Project](https://dropwizard.github.io/metrics/3.1.0/).

## Counters

Counters allow to keep track of a specific value) for instance the currently logged in users) which is frequently incremented or decremented.

```java
MetricsNode m = Metrics.create();

m.increment("counter");
m.increment("counter");
m.decrement("counter");

m.print();

```

## Reporting

This project follows a very lightweight approach to reporting. All it does for you is turn metrics into easily human-readable strings. What you do with these is up to.

## Compatibility

This project is compatible with the following environments:

- Java 1.6+
- GWT 2.5.0+
- Android
