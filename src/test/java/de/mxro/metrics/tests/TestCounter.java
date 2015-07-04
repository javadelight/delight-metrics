package de.mxro.metrics.tests;

import de.mxro.async.properties.PropertyNode;
import de.mxro.async.properties.PropertyOperation;
import de.mxro.metrics.MetricsCommon;
import de.mxro.promise.Promise;
import de.oehme.xtend.junit.Hamcrest;
import de.oehme.xtend.junit.JUnit;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.hamcrest.Matcher;
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
    TestCounter.<Boolean, Boolean>operator_doubleArrow(Boolean.valueOf(_contains), Boolean.valueOf(true));
  }
  
  private static void assertArrayEquals(final Object[] expecteds, final Object[] actuals) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final byte[] expecteds, final byte[] actuals) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final char[] expecteds, final char[] actuals) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final short[] expecteds, final short[] actuals) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final int[] expecteds, final int[] actuals) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final long[] expecteds, final long[] actuals) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final String message, final Object[] expecteds, final Object[] actuals) throws ArrayComparisonFailure {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final String message, final byte[] expecteds, final byte[] actuals) throws ArrayComparisonFailure {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final String message, final char[] expecteds, final char[] actuals) throws ArrayComparisonFailure {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final String message, final short[] expecteds, final short[] actuals) throws ArrayComparisonFailure {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final String message, final int[] expecteds, final int[] actuals) throws ArrayComparisonFailure {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final String message, final long[] expecteds, final long[] actuals) throws ArrayComparisonFailure {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final double[] expecteds, final double[] actuals, final double delta) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final float[] expecteds, final float[] actuals, final float delta) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final String message, final double[] expecteds, final double[] actuals, final double delta) throws ArrayComparisonFailure {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertArrayEquals(final String message, final float[] expecteds, final float[] actuals, final float delta) throws ArrayComparisonFailure {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertEquals(final Object expected, final Object actual) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertEquals(final long expected, final long actual) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertEquals(final String arg0, final Object arg1, final Object arg2) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertEquals(final String message, final long expected, final long actual) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertEquals(final double expected, final double actual, final double delta) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertEquals(final String message, final double expected, final double actual, final double delta) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertFalse(final boolean condition) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertFalse(final String message, final boolean condition) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertNotNull(final Object object) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertNotNull(final String message, final Object object) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertNotSame(final Object unexpected, final Object actual) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertNotSame(final String message, final Object unexpected, final Object actual) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertNull(final Object object) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertNull(final String message, final Object object) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertSame(final Object expected, final Object actual) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertSame(final String message, final Object expected, final Object actual) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> void assertThat(final T actual, final Matcher<T> matcher) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> void assertThat(final String arg0, final T arg1, final Matcher<T> arg2) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertTrue(final boolean condition) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void assertTrue(final String message, final boolean condition) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void fail() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static void fail(final String message) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object, U extends T> void operator_doubleArrow(final T actual, final U expected) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Exception> void isThrownBy(final Class<T> expected, final Procedure0 block) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  @Rule
  @Extension
  public final ErrorCollector _errorCollector /* Skipped initializer because of errors */;
  
  private <T extends Object> void operator_doubleArrow(final T object, final Matcher<? super T> matcher) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> allOf(final Matcher<? extends T>... matchers) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> allOf(final Iterable<Matcher<? extends T>> matchers) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> any(final Class<T> type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> anyOf(final Matcher<? extends T>... matchers) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> anyOf(final Iterable<Matcher<? extends T>> matchers) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> anything() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> anything(final String description) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> describedAs(final String description, final Matcher<T> matcher, final Object... values) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> equalTo(final T operand) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static Matcher<Object> instanceOf(final Class<?> type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> is(final Matcher<T> matcher) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> is(final T value) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static Matcher<Object> is(final Class<?> type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> not(final Matcher<T> matcher) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> not(final T value) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> notNullValue() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> notNullValue(final Class<T> type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> nullValue() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> nullValue(final Class<T> type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
  
  private static <T extends Object> Matcher<T> sameInstance(final T object) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe type TestCounter is already defined in TestCounter.xtend.");
  }
}
