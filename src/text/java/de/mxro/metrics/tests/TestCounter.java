package de.mxro.metrics.tests;

import de.mxro.async.Promise;
import de.mxro.fn.Success;
import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.helpers.RecordOperation;
import de.mxro.metrics.jre.Metrics;
import de.oehme.xtend.junit.Hamcrest;
import de.oehme.xtend.junit.JUnit;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.ArrayComparisonFailure;
import org.junit.rules.ErrorCollector;

@JUnit
@Hamcrest
@SuppressWarnings("all")
public class TestCounter {
  @Test
  public void test() {
    MetricsNode m = Metrics.create();
    RecordOperation _increment = Metrics.increment("de.mxro.counter");
    m.record(_increment);
    RecordOperation _increment_1 = Metrics.increment("de.mxro.counter");
    m.record(_increment_1);
    RecordOperation _decrement = Metrics.decrement("de.mxro.counter");
    m.record(_decrement);
    Promise<Object> _retrieve = m.retrieve("de.mxro.counter");
    Object _get = _retrieve.get();
    String _string = _get.toString();
    boolean _contains = _string.contains("1");
    TestCounter.<Boolean, Boolean>operator_doubleArrow(Boolean.valueOf(_contains), Boolean.valueOf(true));
    Promise<Success> _stop = m.stop();
    _stop.get();
  }
  
  private static void assertArrayEquals(final Object[] expecteds, final Object[] actuals) {
    Assert.assertArrayEquals(expecteds, actuals);
  }
  
  private static void assertArrayEquals(final byte[] expecteds, final byte[] actuals) {
    Assert.assertArrayEquals(expecteds, actuals);
  }
  
  private static void assertArrayEquals(final char[] expecteds, final char[] actuals) {
    Assert.assertArrayEquals(expecteds, actuals);
  }
  
  private static void assertArrayEquals(final short[] expecteds, final short[] actuals) {
    Assert.assertArrayEquals(expecteds, actuals);
  }
  
  private static void assertArrayEquals(final int[] expecteds, final int[] actuals) {
    Assert.assertArrayEquals(expecteds, actuals);
  }
  
  private static void assertArrayEquals(final long[] expecteds, final long[] actuals) {
    Assert.assertArrayEquals(expecteds, actuals);
  }
  
  private static void assertArrayEquals(final String message, final Object[] expecteds, final Object[] actuals) throws ArrayComparisonFailure {
    Assert.assertArrayEquals(message, expecteds, actuals);
  }
  
  private static void assertArrayEquals(final String message, final byte[] expecteds, final byte[] actuals) throws ArrayComparisonFailure {
    Assert.assertArrayEquals(message, expecteds, actuals);
  }
  
  private static void assertArrayEquals(final String message, final char[] expecteds, final char[] actuals) throws ArrayComparisonFailure {
    Assert.assertArrayEquals(message, expecteds, actuals);
  }
  
  private static void assertArrayEquals(final String message, final short[] expecteds, final short[] actuals) throws ArrayComparisonFailure {
    Assert.assertArrayEquals(message, expecteds, actuals);
  }
  
  private static void assertArrayEquals(final String message, final int[] expecteds, final int[] actuals) throws ArrayComparisonFailure {
    Assert.assertArrayEquals(message, expecteds, actuals);
  }
  
  private static void assertArrayEquals(final String message, final long[] expecteds, final long[] actuals) throws ArrayComparisonFailure {
    Assert.assertArrayEquals(message, expecteds, actuals);
  }
  
  private static void assertArrayEquals(final double[] expecteds, final double[] actuals, final double delta) {
    Assert.assertArrayEquals(expecteds, actuals, delta);
  }
  
  private static void assertArrayEquals(final float[] expecteds, final float[] actuals, final float delta) {
    Assert.assertArrayEquals(expecteds, actuals, delta);
  }
  
  private static void assertArrayEquals(final String message, final double[] expecteds, final double[] actuals, final double delta) throws ArrayComparisonFailure {
    Assert.assertArrayEquals(message, expecteds, actuals, delta);
  }
  
  private static void assertArrayEquals(final String message, final float[] expecteds, final float[] actuals, final float delta) throws ArrayComparisonFailure {
    Assert.assertArrayEquals(message, expecteds, actuals, delta);
  }
  
  private static void assertEquals(final Object expected, final Object actual) {
    Assert.assertEquals(expected, actual);
  }
  
  private static void assertEquals(final long expected, final long actual) {
    Assert.assertEquals(expected, actual);
  }
  
  private static void assertEquals(final String arg0, final Object arg1, final Object arg2) {
    Assert.assertEquals(arg0, arg1, arg2);
  }
  
  private static void assertEquals(final String message, final long expected, final long actual) {
    Assert.assertEquals(message, expected, actual);
  }
  
  private static void assertEquals(final double expected, final double actual, final double delta) {
    Assert.assertEquals(expected, actual, delta);
  }
  
  private static void assertEquals(final String message, final double expected, final double actual, final double delta) {
    Assert.assertEquals(message, expected, actual, delta);
  }
  
  private static void assertFalse(final boolean condition) {
    Assert.assertFalse(condition);
  }
  
  private static void assertFalse(final String message, final boolean condition) {
    Assert.assertFalse(message, condition);
  }
  
  private static void assertNotNull(final Object object) {
    Assert.assertNotNull(object);
  }
  
  private static void assertNotNull(final String message, final Object object) {
    Assert.assertNotNull(message, object);
  }
  
  private static void assertNotSame(final Object unexpected, final Object actual) {
    Assert.assertNotSame(unexpected, actual);
  }
  
  private static void assertNotSame(final String message, final Object unexpected, final Object actual) {
    Assert.assertNotSame(message, unexpected, actual);
  }
  
  private static void assertNull(final Object object) {
    Assert.assertNull(object);
  }
  
  private static void assertNull(final String message, final Object object) {
    Assert.assertNull(message, object);
  }
  
  private static void assertSame(final Object expected, final Object actual) {
    Assert.assertSame(expected, actual);
  }
  
  private static void assertSame(final String message, final Object expected, final Object actual) {
    Assert.assertSame(message, expected, actual);
  }
  
  private static <T extends Object> void assertThat(final T actual, final Matcher<T> matcher) {
    Assert.<T>assertThat(actual, matcher);
  }
  
  private static <T extends Object> void assertThat(final String arg0, final T arg1, final Matcher<T> arg2) {
    Assert.<T>assertThat(arg0, arg1, arg2);
  }
  
  private static void assertTrue(final boolean condition) {
    Assert.assertTrue(condition);
  }
  
  private static void assertTrue(final String message, final boolean condition) {
    Assert.assertTrue(message, condition);
  }
  
  private static void fail() {
    Assert.fail();
  }
  
  private static void fail(final String message) {
    Assert.fail(message);
  }
  
  private static <T extends Object, U extends T> void operator_doubleArrow(final T actual, final U expected) {
    Assert.assertEquals(expected, actual);
  }
  
  private static <T extends Exception> void isThrownBy(final Class<T> expected, final Procedure0 block) {
    try {
    	block.apply();
    	Assert.fail("Expected a " + expected.getName());
    } catch (Exception e) {
    	Class<?> actual = e.getClass();
    	Assert.assertTrue(
    		"Expected a " + expected.getName() + " but got " + actual.getName(), 
    		expected.isAssignableFrom(actual)
    	);
    }
  }
  
  @Rule
  @Extension
  public final ErrorCollector _errorCollector = new ErrorCollector();
  
  private <T extends Object> void operator_doubleArrow(final T object, final Matcher<? super T> matcher) {
    Assert.assertThat(object, matcher);
  }
  
  private static <T extends Object> Matcher<T> allOf(final Matcher<? extends T>... matchers) {
    return CoreMatchers.<T>allOf(matchers);
  }
  
  private static <T extends Object> Matcher<T> allOf(final Iterable<Matcher<? extends T>> matchers) {
    return CoreMatchers.<T>allOf(matchers);
  }
  
  private static <T extends Object> Matcher<T> any(final Class<T> type) {
    return CoreMatchers.<T>any(type);
  }
  
  private static <T extends Object> Matcher<T> anyOf(final Matcher<? extends T>... matchers) {
    return CoreMatchers.<T>anyOf(matchers);
  }
  
  private static <T extends Object> Matcher<T> anyOf(final Iterable<Matcher<? extends T>> matchers) {
    return CoreMatchers.<T>anyOf(matchers);
  }
  
  private static <T extends Object> Matcher<T> anything() {
    return CoreMatchers.<T>anything();
  }
  
  private static <T extends Object> Matcher<T> anything(final String description) {
    return CoreMatchers.<T>anything(description);
  }
  
  private static <T extends Object> Matcher<T> describedAs(final String description, final Matcher<T> matcher, final Object... values) {
    return CoreMatchers.<T>describedAs(description, matcher, values);
  }
  
  private static <T extends Object> Matcher<T> equalTo(final T operand) {
    return CoreMatchers.<T>equalTo(operand);
  }
  
  private static Matcher<Object> instanceOf(final Class<?> type) {
    return CoreMatchers.instanceOf(type);
  }
  
  private static <T extends Object> Matcher<T> is(final Matcher<T> matcher) {
    return CoreMatchers.<T>is(matcher);
  }
  
  private static <T extends Object> Matcher<T> is(final T value) {
    return CoreMatchers.<T>is(value);
  }
  
  private static Matcher<Object> is(final Class<?> type) {
    return CoreMatchers.is(type);
  }
  
  private static <T extends Object> Matcher<T> not(final Matcher<T> matcher) {
    return CoreMatchers.<T>not(matcher);
  }
  
  private static <T extends Object> Matcher<T> not(final T value) {
    return CoreMatchers.<T>not(value);
  }
  
  private static <T extends Object> Matcher<T> notNullValue() {
    return CoreMatchers.<T>notNullValue();
  }
  
  private static <T extends Object> Matcher<T> notNullValue(final Class<T> type) {
    return CoreMatchers.<T>notNullValue(type);
  }
  
  private static <T extends Object> Matcher<T> nullValue() {
    return CoreMatchers.<T>nullValue();
  }
  
  private static <T extends Object> Matcher<T> nullValue(final Class<T> type) {
    return CoreMatchers.<T>nullValue(type);
  }
  
  private static <T extends Object> Matcher<T> sameInstance(final T object) {
    return CoreMatchers.<T>sameInstance(object);
  }
}
