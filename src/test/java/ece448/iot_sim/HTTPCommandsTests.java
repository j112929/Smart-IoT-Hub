package ece448.iot_sim;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class HTTPCommandsTests {
    @Test
	public void test0() {
        List<PlugSim> plugs = new ArrayList<>();
        PlugSim plug = new PlugSim("a");
        HTTPCommands commands = new HTTPCommands(plugs);
        String res =commands.report(plug);
		assertTrue(res.length()!=0);
    }
    @Test
	public void test1() {
        List<PlugSim> plugs = new ArrayList<>();
        PlugSim plug = new PlugSim("a");
        PlugSim plug1 = new PlugSim("b");
        plugs.add(plug);
        plugs.add(plug1);
        HTTPCommands commands = new HTTPCommands(plugs);
        String res =commands.listPlugs();
		assertTrue(res.length()!=0);
    }
    @Test
	public void test2() {
        List<PlugSim> plugs = new ArrayList<>();
        // PlugSim plug = new PlugSim("a");
        HTTPCommands commands = new HTTPCommands(plugs);
        Map<String, String> params = new HashMap<>();
        String res =commands.handleGet("/", params);
		assertTrue(res.length()!=0);
    }
    @Test
	public void test3() {
        List<PlugSim> plugs = new ArrayList<>();
        // PlugSim plug = new PlugSim("a");
        HTTPCommands commands = new HTTPCommands(plugs);
        Map<String, String> params = new HashMap<>();
        String res =commands.handleGet("a", params);
		assertTrue(res==null);
    }
    @Test
	public void test4() {
        List<PlugSim> plugs = new ArrayList<>();
        PlugSim plug = new PlugSim("a");
        plugs.add(plug);
        HTTPCommands commands = new HTTPCommands(plugs);
        Map<String, String> params = new HashMap<>();
        String res =commands.handleGet("/a", params);
		assertTrue(res!=null);
    }
    @Test
	public void test5() {
        List<PlugSim> plugs = new ArrayList<>();
        PlugSim plug = new PlugSim("a");
        plugs.add(plug);
        HTTPCommands commands = new HTTPCommands(plugs);
        Map<String, String> params = new HashMap<>();
        params.put("action", "on");
        String res =commands.handleGet("/a", params);
		assertTrue(res.indexOf("a is on") != -1);
    }
    @Test
	public void test6() {
        List<PlugSim> plugs = new ArrayList<>();
        PlugSim plug = new PlugSim("a");
        plugs.add(plug);
        HTTPCommands commands = new HTTPCommands(plugs);
        Map<String, String> params = new HashMap<>();
        params.put("action", "off");
        String res =commands.handleGet("/a", params);
		assertTrue(res.indexOf("a is off") != -1);
    }
    @Test
	public void test7() {
        List<PlugSim> plugs = new ArrayList<>();
        PlugSim plug = new PlugSim("a");
        plugs.add(plug);
        HTTPCommands commands = new HTTPCommands(plugs);
        Map<String, String> params = new HashMap<>();
        params.put("action", "toggle");
        String res =commands.handleGet("/a", params);
        System.out.println(res);
		assertTrue(res.indexOf("a is on") != -1);
    }
    @Test
	public void test8() {
        List<PlugSim> plugs = new ArrayList<>();
        PlugSim plug = new PlugSim("a");
        PlugSim plug1 = new PlugSim("b");
        plugs.add(plug);
        plugs.add(plug1);
        HTTPCommands commands = new HTTPCommands(plugs);
        Map<String, String> params = new HashMap<>();
        params.put("action", "");
        String res =commands.handleGet("/a", params);
        System.out.println(res);
		assertTrue(res.indexOf("<html><body></body></html>") != -1);
    }
    @Test
	public void test9() {
        List<PlugSim> plugs = new ArrayList<>();
        // PlugSim plug = new PlugSim("a");
        HTTPCommands commands = new HTTPCommands(plugs);
        // String res =commands.report(plug);
		assertTrue(commands!=null);
    }
}
