package de.mxro.metrics.tests

import de.mxro.metrics.MetricsCommon
import de.mxro.metrics.jre.Metrics
import de.oehme.xtend.junit.Hamcrest
import de.oehme.xtend.junit.JUnit
import org.junit.Test

@JUnit
@Hamcrest
class TestCounter {
	
	@Test
	def test() {
		
		var m = Metrics.create
		
		m.record(Metrics.increment("de.mxro.counter"))
		m.record(Metrics.increment("de.mxro.counter"))
		
		m.record(Metrics.decrement("de.mxro.counter"))
		
		m.retrieve("de.mxro.counter").get.toString().contains("1") => true
		
		m.stop.get
		
	}
	
}