package de.mxro.metrics.tests;

import de.mxro.metrics.MetricsCommon;
import delight.async.properties.PropertyNode;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestHistogram {
  @Test
  public void test() {
    PropertyNode m = MetricsCommon.createUnsafe();
    m.<Long>record(MetricsCommon.value("de.mxro.hist", 1));
    m.<Long>record(MetricsCommon.value("de.mxro.hist", 2));
    m.<Long>record(MetricsCommon.value("de.mxro.hist", 3));
    Assert.assertTrue(m.retrieve("de.mxro.hist").get().toString().contains("2.0"));
  }
}
