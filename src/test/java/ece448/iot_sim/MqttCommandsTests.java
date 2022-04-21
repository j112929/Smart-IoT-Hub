package ece448.iot_sim;


import java.util.ArrayList;

import ece448.iot_sim.PlugSim.Observer;



import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;

public class MqttCommandsTests {
    @Test
    public void test1() {
        String topicPrefix="test/";
        MqttMessage msg= new MqttMessage();
        PlugSim plug = new PlugSim("a");
        ArrayList<PlugSim> plugs = new ArrayList<>();
        plugs.add(plug);
        Observer aaa= new Observer(){
        
            @Override
            public void update(String name, String key, String value) {
                // TODO Auto-generated method stub
                
            }
        };
        plug.addObserver(aaa);
        MqttCommands test= new MqttCommands(plugs, topicPrefix);
        String topic="test/iot_jzl/"+plug.getName()+"/on";
        System.out.println(topic);
        test.handleMessage(topic, msg);
    }
    @Test
    public void test2() {
        String topicPrefix="test/";
        MqttMessage msg= new MqttMessage();
        PlugSim plug = new PlugSim("a");
        ArrayList<PlugSim> plugs = new ArrayList<>();
        plugs.add(plug);
        MqttCommands test= new MqttCommands(plugs, topicPrefix);
        String topic="test/iot_jzl/"+plug.getName()+"/off";
        System.out.println(topic);
        test.handleMessage(topic, msg);
    }
    @Test
    public void test3() {
        String topicPrefix="test/";
        MqttMessage msg= new MqttMessage();
        PlugSim plug = new PlugSim("a");
        ArrayList<PlugSim> plugs = new ArrayList<>();
        plugs.add(plug);
        MqttCommands test= new MqttCommands(plugs, topicPrefix);
        String topic="test/iot_jzl/"+plug.getName()+"/toggle";
        System.out.println(topic);
        test.handleMessage(topic, msg);
        test.handleMessage(topic, msg);
    }
    @Test
    public void test4() {
        String topicPrefix="test/";
        MqttMessage msg= new MqttMessage();
        PlugSim plug = new PlugSim("a");
        ArrayList<PlugSim> plugs = new ArrayList<>();
        plugs.add(plug);
        MqttCommands test= new MqttCommands(plugs, topicPrefix);
        String topic="test/iot_jzl/"+plug.getName()+"/ppp";
        test.getTopic();
        System.out.println(topic);
        test.handleMessage(topic, msg);
    }
    @Test
    public void test5() {
        String topicPrefix="test/";
        MqttMessage msg= new MqttMessage();
        PlugSim plug = new PlugSim("a");
        ArrayList<PlugSim> plugs = new ArrayList<>();
        plugs.add(plug);
        MqttCommands test= new MqttCommands(plugs, topicPrefix);
        String topic="";
        System.out.println(topic);
        test.handleMessage(topic, msg);   
    }
    @Test     
    public void test6() {
        String topicPrefix="test/";
        MqttMessage msg= new MqttMessage();
        PlugSim plug = new PlugSim("a");
        ArrayList<PlugSim> plugs = new ArrayList<>();
        plugs.add(plug);
        MqttCommands test= new MqttCommands(plugs, topicPrefix);
        String topic="test/iot_jzl/"+plug.getName()+"/play";
        System.out.println(topic);
        test.handleMessage(topic, msg);  
    }
    @Test
    public void test7() {
        String topicPrefix="test/";
        MqttMessage msg= new MqttMessage();
        PlugSim plug = new PlugSim("a");
        
        ArrayList<PlugSim> plugs = new ArrayList<>();
        plugs.add(plug);
        MqttCommands test= new MqttCommands(plugs, topicPrefix);
        String topic="test/iot_jzl/"+plug.getName()+"/on";
        System.out.println(topic);
        test.handleMessage(topic, msg);
        Observer aaa= new Observer(){
        
            @Override
            public void update(String name, String key, String value) {
                // TODO Auto-generated method stub
                
            }
        };
        plug.addObserver(aaa);
        Observer ccc= new Observer(){
        
            @Override
            public void update(String name, String key, String value) {
                // TODO Auto-generated method stub
                
            }
        };
        plug.addObserver(ccc);
        plug.updatePower(0.1d);
        topic="test/iot_jzl/"+plug.getName()+"/off";
        test.handleMessage(topic, msg);
        Observer bbb= new Observer(){
        
            @Override
            public void update(String name, String key, String value) {
                // TODO Auto-generated method stub
                
            }
        };
        plug.addObserver(bbb);
    }
    @Test
    public void test8() {
        String topicPrefix="test/";
        MqttMessage msg= new MqttMessage();
        PlugSim plug = new PlugSim("a");
        ArrayList<PlugSim> plugs = new ArrayList<>();
        plugs.add(plug);
        MqttCommands test= new MqttCommands(plugs, topicPrefix);
        String topic="test/iot_jzl/"+plug.getName()+"/on";
        System.out.println(topic);
        test.handleMessage(topic, msg);
        topic="test/iot_jzl/"+plug.getName()+"/toggle";
        test.handleMessage(topic, msg);
    }
    @Test
    public void test9() {
        String topicPrefix="test/";
        MqttMessage msg= new MqttMessage();
        PlugSim plug = new PlugSim("a");
        PlugSim plug1 = new PlugSim("b");
        ArrayList<PlugSim> plugs = new ArrayList<>();
        plugs.add(plug);
        plugs.add(plug1);
        MqttCommands test= new MqttCommands(plugs, topicPrefix);
        String topic="test/iot_jzl/"+"c"+"/on";
        System.out.println(topic);
        test.handleMessage(topic, msg);
    }
    @Test
    public void test10() {
        String topicPrefix="test/";
        MqttMessage msg= new MqttMessage();
        PlugSim plug = new PlugSim("a");
        PlugSim plug1 = new PlugSim("b");
        ArrayList<PlugSim> plugs = new ArrayList<>();
        plugs.add(plug);
        plugs.add(plug1);
        MqttCommands test= new MqttCommands(plugs, topicPrefix);
        String topic="test/iot_jzl/"+plug.getName()+"/on";
        System.out.println(topic);
        test.handleMessage(topic, msg);
        topic="test/iot_jzl/"+plug.getName()+"/toggle";
        test.handleMessage(topic, msg);
    }
}