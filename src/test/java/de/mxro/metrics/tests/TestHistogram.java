package de.mxro.metrics.tests;

import de.mxro.async.properties.PropertyNode;
import de.mxro.async.properties.PropertyOperation;
import de.mxro.metrics.MetricsCommon;
import de.mxro.promise.Promise;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestHistogram {
  @Test
  public void test() {
    PropertyNode m = MetricsCommon.createUnsafe();
    PropertyOperation<Long> _value = MetricsCommon.value("de.mxro.hist", 1);
    m.<Long>record(_value);
    PropertyOperation<Long> _value_1 = MetricsCommon.value("de.mxro.hist", 2);
    m.<Long>record(_value_1);
    PropertyOperation<Long> _value_2 = MetricsCommon.value("de.mxro.hist", 3);
    m.<Long>record(_value_2);
    Promise<Object> _retrieve = m.retrieve("de.mxro.hist");
    Object _get = _retrieve.get();
    String _string = _get.toString();
    boolean _contains = _string.contains("2.0");
    Assert.assertTrue(_contains);
  }
}
