package de.mxro.metrics.tests

import de.mxro.metrics.MetricsCommon
import org.junit.Assert
import org.junit.Test

class TestHistogram {
	
	@Test
	def test() {
		
		var m = MetricsCommon.createUnsafe
		
		m.record(MetricsCommon.value("de.mxro.hist", 1))
		m.record(MetricsCommon.value("de.mxro.hist", 2))
		
		m.record(MetricsCommon.value("de.mxro.hist", 3))

		Assert.assertTrue(m.retrieve("de.mxro.hist").get.toString.contains("2.0"))
		
	}
	
}