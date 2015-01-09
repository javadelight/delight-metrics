package de.mxro.metrics.tests

import com.codahale.metrics.Meter
import de.mxro.metrics.MetricsCommon
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

		m.record(MetricsCommon.happened("de.mxro.test.meter1"))
		m.record(MetricsCommon.happened("de.mxro.test.meter1"))
		m.record(MetricsCommon.happened("de.mxro.test.meter1"))

		m.retrieve("de.mxro.test.meter1").get.toString.contains("3") => true
		
		m.stop.get
	}

	@Test
	def void test_rates() {
		val m = Metrics.create

		for (i : 0 ..< 20) {

			m.record(MetricsCommon.happened("de.mxro.test.meter1"))

			Thread.sleep(110)

			m.record(MetricsCommon.happened("de.mxro.test.meter1"))

			Thread.sleep(110)
			m.record(MetricsCommon.happened("de.mxro.test.meter1"))

			Thread.sleep(110)

		}

		(m.retrieve("de.mxro.test.meter1", Meter).get.fiveMinuteRate > 5.0) => true
		(m.retrieve("de.mxro.test.meter1", Meter).get.fiveMinuteRate < 20.0) => true
		
		m.stop.get
	}

}
