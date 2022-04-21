package ece448.iot_sim;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqttCommands {
    private final Map<String, PlugSim> plugs = new ConcurrentHashMap<>();
    private final String topicPrefix;

    public MqttCommands(List<PlugSim> plugs, String topicPrefix) {
        for (PlugSim plug : plugs)
            this.plugs.put(plug.getName(), plug);
        this.topicPrefix = topicPrefix;
    }

    public String getTopic() {
        return topicPrefix + "/action/#";
    }
    public void handleMessage (String topic, MqttMessage msg){        
        
        try{

            String[] elements = topic.split("/");
            String plugName = elements[elements.length-2]; 
            String action = elements[elements.length-1];

            PlugSim plug = plugs.get(plugName);
            if(plug==null){
                return;
            }

            if(action.equals("on")){
                plug.switchOn();
            }
            else if(action.equals("off")){
                plug.switchOff();
            }
            else if(action.equals("toggle")){
                plug.toggle();
            }
            else{
                // logger.info("WRONG action");
            }            
        }
        catch(Exception e){
            logger.error("Exception:",e);
        }          
    }
    

    private static final Logger logger = LoggerFactory.getLogger(MqttCommands.class);

}
