package de.mxro.metrics.tests

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
	
	@Test
	def test_multi_threaded() {
		val m = Metrics.create
		
		val t1 = new Thread [
			for (i:1..400) {
				m.record(Metrics.increment("counter"))
				Thread.sleep(1)
			}
		]
		
		val t2 = new Thread [
			for (i:1..400) {
				m.record(Metrics.decrement("counter"))
				Thread.sleep(1)
			}
			
		]
	
		t1.start
		t2.start
		
		t1.join
		t2.join
		
		val res = m.retrieve("counter").get.toString()
		
		res.contains("0") => true
		
		m.stop.get
		
	}
	
	
}