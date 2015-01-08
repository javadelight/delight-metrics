package de.mxro.metrics.tests

import de.mxro.metrics.Metrics
import de.oehme.xtend.junit.Hamcrest
import de.oehme.xtend.junit.JUnit
import org.junit.Test

@JUnit
@Hamcrest
class TestCounter {
	
	@Test
	def test() {
		
		var m = Metrics.createUnsafe
		
		m.record(Metrics.increment("de.mxro.counter"))
		m.record(Metrics.increment("de.mxro.counter"))
		
		m.record(Metrics.decrement("de.mxro.counter"))
		
		m.data.get("de.mxro.counter").toString().contains("1") => true
		
	}
	
}