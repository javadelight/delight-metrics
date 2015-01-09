package de.mxro.metrics.tests

import de.oehme.xtend.junit.Hamcrest
import de.oehme.xtend.junit.JUnit
import org.junit.Test
import de.mxro.metrics.MetricsCommon

@JUnit
@Hamcrest
class TestCounter {
	
	@Test
	def test() {
		
		var m = MetricsCommon.createUnsafe
		
		m.record(MetricsCommon.increment("de.mxro.counter"))
		m.record(MetricsCommon.increment("de.mxro.counter"))
		
		m.record(MetricsCommon.decrement("de.mxro.counter"))
		
		m.retrieve("de.mxro.counter").get.toString().contains("1") => true
		
	}
	
}