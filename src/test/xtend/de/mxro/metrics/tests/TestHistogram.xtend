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
		
		m.perform(MetricsCommon.value("de.mxro.hist", 1))
		m.perform(MetricsCommon.value("de.mxro.hist", 2))
		
		m.perform(MetricsCommon.value("de.mxro.hist", 3))

		m.retrieve("de.mxro.hist").get.toString.contains("2.0") => true
		
	}
	
}