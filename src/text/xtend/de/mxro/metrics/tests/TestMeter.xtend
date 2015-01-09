package de.mxro.metrics.tests

import com.codahale.metrics.Meter
import de.mxro.metrics.Metrics
import de.oehme.xtend.junit.Hamcrest
import de.oehme.xtend.junit.JUnit
import org.junit.Test

@JUnit
@Hamcrest
class TestMeter {

	@Test
	def void test_count() {
		val m = Metrics.createUnsafe

		m.record(Metrics.happened("de.mxro.test.meter1"))
		m.record(Metrics.happened("de.mxro.test.meter1"))
		m.record(Metrics.happened("de.mxro.test.meter1"))

		m.retrieve("de.mxro.test.meter1").get.toString.contains("3") => true
	}

	@Test
	def void test_rates() {
		val m = Metrics.createUnsafe

		for (i : 0 ..< 20) {

			m.record(Metrics.happened("de.mxro.test.meter1"))

			Thread.sleep(110)

			m.record(Metrics.happened("de.mxro.test.meter1"))

			Thread.sleep(110)
			m.record(Metrics.happened("de.mxro.test.meter1"))

			Thread.sleep(110)

		}

		(m.retrieve("de.mxro.test.meter1", Meter).get.fiveMinuteRate > 5.0) => true
		(m.retrieve("de.mxro.test.meter1", Meter).get.fiveMinuteRate < 20.0) => true
	}

}
