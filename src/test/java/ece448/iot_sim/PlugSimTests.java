package ece448.iot_sim;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlugSimTests {

	@Test
	public void testInit() {
		PlugSim plug = new PlugSim("a");

		assertFalse(plug.isOn());
	}

	@Test
	public void testSwitchOn() {
		PlugSim plug = new PlugSim("a");

		plug.switchOn();

		assertTrue(plug.isOn());
	}
	@Test
	public void testSwitchOff() {
		PlugSim plug = new PlugSim("a");

		plug.switchOff();

		assertTrue(!plug.isOn());
	}
	@Test
	public void testToggle() {
		PlugSim plug = new PlugSim("a");

		plug.toggle();

		assertTrue(plug.isOn());
	}
	@Test
	public void testGetPower() {
		PlugSim plug = new PlugSim("a");
		System.out.println(plug.getName());	
		plug.measurePower();
		plug.updatePower(0);
		assertTrue(plug.getPower() ==0);
	}
	@Test
	public void test1(){
		PlugSim plug = new PlugSim("a");
		plug.toggle();
		plug.toggle();
		assertTrue(!plug.isOn());
	}
	@Test
	public void test2(){
		PlugSim plug = new PlugSim("a.1");
		plug.toggle();
		plug.measurePower();
		System.out.println(plug.getPower());
		assertTrue(plug.getPower()==1.0);
	}
	@Test
	public void test3(){
		PlugSim plug = new PlugSim("a");
		plug.toggle();
		plug.updatePower(1.0);
		plug.measurePower();
		System.out.println(plug.getPower());
		assertTrue(plug.getPower()<100);
	}

	@Test
	public void test4(){
		PlugSim plug = new PlugSim("a");
		plug.toggle();
		plug.updatePower(120);
		plug.measurePower();
		System.out.println(plug.getPower());
		assertTrue(plug.getPower()>100);
	}
	@Test
	public void test5(){
		PlugSim plug = new PlugSim("a");
		plug.toggle();
		plug.updatePower(450);
		plug.measurePower();
		System.out.println(plug.getPower());
		assertTrue(plug.getPower()>300);
	}
}
