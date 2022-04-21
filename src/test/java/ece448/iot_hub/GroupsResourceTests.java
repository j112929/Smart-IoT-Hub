/* package ece448.iot_hub;

import java.util.*;

import org.junit.Test;

public class GroupsResourceTests {
    private static final String broker = "tcp://127.0.0.1";

	private static final String clientID = "iot_hub";

    private static final String topicPrefix = "iot_ece448";
    
    @Test
    public void test0(){
        try {
            PlugModel plugModel = new PlugModel(broker, clientID, topicPrefix);
            PlugResource ret = new PlugResource(plugModel);

			ret.createPlug("plug0", Arrays.asList("a", "b", "c"));
            plugModel.getPlug("plug0");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){
        try {
            PlugModel plugModel = new PlugModel(broker, clientID, topicPrefix);
            GroupsModel groupsModel = new GroupsModel(plugModel);
            List<String> members = new ArrayList<>();
            members.add("a");
            members.add("b");
            members.add("c");
            groupsModel.setGroup("g1", members);
            groupsModel.getGroups();
            groupsModel.getGroup("g1");
            groupsModel.publishAction("g1", "toggle", "a");
            groupsModel.publishAction("g1", "toggle", null);
            groupsModel.removeGroup("g1");
            // plugModel.getPlug("plug0");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        PlugModel plugModel = null;
        try {
            plugModel = new PlugModel(broker, clientID, topicPrefix);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GroupsModel groupsModel = new GroupsModel(plugModel);
        GroupsResource groupsResource = new GroupsResource(groupsModel, plugModel);
        List<String> members = new ArrayList<>();
            members.add("a");
            members.add("b");
            members.add("c");
        groupsResource.createGroup("g1", members);
        groupsResource.createGroup("g2", members);
        groupsResource.createGroup("g3", members);
        groupsResource.getGroups();
        groupsResource.getGroup("g1",null);
        Map<String,String> map = new HashMap<>();
        map.put("action", "toggle");
        map.put("plug", "a");
        groupsResource.controlGroup("g1", map);
        groupsResource.deleteGroup("g1");

    }
    @Test
    public void test3(){
        PlugModel plugModel = null;
        try {
            plugModel = new PlugModel(broker, clientID, topicPrefix);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GroupsModel groupsModel = new GroupsModel(plugModel);
        groupsModel.getGroup("");
    }
    @Test
    public void test4(){
        PlugModel plugModel = null;
        try {
            plugModel = new PlugModel(broker, clientID, topicPrefix);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GroupsModel groupsModel = new GroupsModel(plugModel);
        GroupsResource groupsResource = new GroupsResource(groupsModel, plugModel);
        List<String> members = new ArrayList<>();
            members.add("a");
            members.add("b");
            members.add("c");
        groupsResource.createGroup("g1", members);
        groupsResource.createGroup("g2", members);
        groupsResource.createGroup("g3", members);
        groupsResource.createGroup("g4", new ArrayList<>());
        groupsResource.getGroup("g4","");
        groupsResource.getGroup(null,"");
        groupsResource.getGroup("g1","toggle");
        Map<String,String> map = new HashMap<>();
        map.put("action", null);
        map.put("plug", "a");
        groupsResource.controlGroup("g1", map);
        groupsResource.controlGroup(null, map);
        // groupsResource.deleteGroup("g1");

    }

    @Test
    public void test5(){
        PlugModel plugModel = null;
        try {
            plugModel = new PlugModel(broker, clientID, topicPrefix);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GroupsModel groupsModel = new GroupsModel(plugModel);
        groupsModel.publishAction("g1", "", null);
        groupsModel.publishAction("", "", null);
    }
    @Test
    public void test6(){
        PlugModel plugModel = null;
        try {
            plugModel = new PlugModel(broker, clientID, topicPrefix);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GroupsModel groupsModel = new GroupsModel(plugModel);
        GroupsResource groupsResource = new GroupsResource(groupsModel, plugModel);
        List<String> members = new ArrayList<>();
            members.add("a");
            members.add("b");
            members.add("c");
        groupsResource.createGroup("g1", members);
        groupsResource.createGroup("g2", members);
        groupsResource.createGroup("g3", members);
        groupsResource.getGroups();
        groupsResource.getGroup("g2",null);
        Map<String,String> map = new HashMap<>();
        map.put("action", "on");
        map.put("plug", "a");
        groupsResource.controlGroup("g2", map);
        groupsResource.deleteGroup("g2");

    }
    @Test
    public void test7(){
        PlugModel plugModel = null;
        try {
            plugModel = new PlugModel(broker, clientID, topicPrefix);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GroupsModel groupsModel = new GroupsModel(plugModel);
        GroupsResource groupsResource = new GroupsResource(groupsModel, plugModel);
        List<String> members = new ArrayList<>();
            members.add("a");
            members.add("b");
            members.add("c");
        groupsResource.createGroup("g1", members);
        groupsResource.createGroup("g2", members);
        groupsResource.createGroup("g3", members);
        groupsResource.getGroups();
        groupsResource.getGroup("g3",null);
        Map<String,String> map = new HashMap<>();
        map.put("action", "off");
        map.put("plug", "a");
        groupsResource.controlGroup("g3", map);
        groupsResource.deleteGroup("g3");

    }
    @Test
    public void test8(){
        PlugModel plugModel = null;
        try {
            plugModel = new PlugModel(broker, clientID, topicPrefix);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GroupsModel groupsModel = new GroupsModel(plugModel);
        GroupsResource groupsResource = new GroupsResource(groupsModel, plugModel);
        List<String> members = new ArrayList<>();
            members.add("a");
            members.add("b");
            members.add("c");
        // groupsResource.createGroup("g1", members);
        // groupsResource.createGroup("g2", members);
        groupsResource.createGroup("g3", members);
        groupsResource.getGroups();
        groupsResource.getGroup("g3","on");
        Map<String,String> map = new HashMap<>();
        map.put("action", "off");
        map.put("plug", "a");
        groupsResource.controlGroup("g3", map);
        // groupsResource.deleteGroup("g3");

    }
    @Test
    public void test9(){
        PlugModel plugModel = null;
        try {
            plugModel = new PlugModel(broker, clientID, topicPrefix);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GroupsModel groupsModel = new GroupsModel(plugModel);
        GroupsResource groupsResource = new GroupsResource(groupsModel, plugModel);
        List<String> members = new ArrayList<>();
            members.add("a");
            members.add("b");
            members.add("c");
        // groupsResource.createGroup("g1", members);
        // groupsResource.createGroup("g2", members);
        groupsResource.createGroup("g3", members);
        groupsResource.getGroups();
        groupsResource.getGroup("g3","on");
        Map<String,String> map = new HashMap<>();
        map.put("action", "toggle");
        map.put("plug", "a");
        groupsResource.controlGroup("g3", map);
        // groupsResource.deleteGroup("g3");

    }

}
 */