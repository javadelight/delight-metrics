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
		
		m.record(Metrics.value("de.mxro.hist", 1))
		m.record(Metrics.value("de.mxro.hist", 2))
		
		m.record(Metrics.value("de.mxro.hist", 3))
		
		println(m.data.toString("de.mxro.hist"))
		
		//.toString().contains("1") => true
		
	}
	
}