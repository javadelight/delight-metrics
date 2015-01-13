package de.mxro.metrics.tests

import com.codahale.metrics.Meter
import de.mxro.metrics.jre.Metrics
import de.oehme.xtend.junit.Hamcrest
import de.oehme.xtend.junit.JUnit
import org.junit.Test

@JUnit
@Hamcrest
class TestMeter {

	@Test
	def void test_count() {
		val m = Metrics.create

		m.record(Metrics.happened("de.mxro.test.meter1"))
		m.record(Metrics.happened("de.mxro.test.meter1"))
		m.record(Metrics.happened("de.mxro.test.meter1"))

		m.retrieve("de.mxro.test.meter1").get.toString.contains("3") => true

		m.stop.get
	}

	@Test
	def void test_rates() {
		val m = Metrics.create

		// 8s
		for (i : 1 .. 8) {

			// 10 events per second
			for (j : 1 .. 10) {
				m.record(Metrics.happened("de.mxro.test.meter1"))

				Thread.sleep(100)
			}

		}

		//println(m.retrieve("de.mxro.test.meter1", Meter).get.fiveMinuteRate);

		(m.retrieve("de.mxro.test.meter1", Meter).get.fiveMinuteRate > 8.0) => true
		(m.retrieve("de.mxro.test.meter1", Meter).get.fiveMinuteRate < 12.0) => true

		m.stop.get
	}

}
