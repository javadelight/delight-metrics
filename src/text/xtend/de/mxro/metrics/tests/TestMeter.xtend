package de.mxro.metrics.tests

import de.mxro.metrics.Metrics
import de.oehme.xtend.junit.Hamcrest
import de.oehme.xtend.junit.JUnit
import org.junit.Test

@JUnit
@Hamcrest
class TestMeter {
	
	@Test
	def void test() {
		val m = Metrics.createUnsafe
		
		m.record(Metrics.meter("de.mxro.test.meter1"))
		m.record(Metrics.meter("de.mxro.test.meter1"))
		m.record(Metrics.meter("de.mxro.test.meter1"))

		println(m.toString("de.mxro.test.meter1"))
	}
	
}