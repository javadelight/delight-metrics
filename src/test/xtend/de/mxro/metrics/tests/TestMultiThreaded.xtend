package de.mxro.metrics.tests

import com.codahale.metrics.Meter
import de.mxro.metrics.jre.Metrics
import de.oehme.xtend.junit.Hamcrest
import de.oehme.xtend.junit.JUnit
import java.util.Random
import org.junit.Test

@JUnit
@Hamcrest
class TestMultiThreaded {

	@Test
	def void test() {

		val m = Metrics.create

		val thread1 = new Thread() {

			override run() {
				for (i : 1 .. 100) {
					m.perform(Metrics.happened("de.mxro.test.meter1"))
					m.perform(Metrics.happened("de.mxro.test.meter1"))
					m.perform(Metrics.happened("de.mxro.test.meter1"))
					Thread.sleep(new Random().nextInt(3))
					
					m.retrieve("de.mxro.test.meter1").get([v | ])
				}
			}
		}

		val thread2 = new Thread() {

			override run() {
				for (i : 1 .. 100) {
					m.perform(Metrics.happened("de.mxro.test.meter1"))
					m.perform(Metrics.happened("de.mxro.test.meter1"))
					m.perform(Metrics.happened("de.mxro.test.meter1"))
					Thread.sleep(new Random().nextInt(3))
					m.retrieve("de.mxro.test.meter1").get([v | ])
				}
			}
		}
		
		thread1.start
		thread2.start
		
		thread1.join
		thread2.join
		
		val count = m.retrieve("de.mxro.test.meter1", Meter).get.count

		val test = count == 600
		test => true

	}



}
