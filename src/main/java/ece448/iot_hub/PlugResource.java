package ece448.iot_hub;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlugResource {
    private PlugModel plugModel;

    public PlugResource(PlugModel plugModel) {
        this.plugModel = plugModel;
    }

    @GetMapping("/api/plugs")
    public List<Object> getPlugs() {

        List<Object> ret = new ArrayList<>();

        for (String plug : plugModel.getPlugs()) {

            ret.add(plugModel.getPlug(plug));

        }

        logger.info("Plugs: {}", ret);

        return ret;

    }

    @GetMapping("/api/plugs/{plug:.+}")
    public Object getPlug(

            @PathVariable("plug") String plug,

            @RequestParam(value = "action", required = false) String action) {

        if (action != null) {

            plugModel.publishAction(plug, action);

        }

        // modify code below to control plugs by publishing messages to MQTT broker

        return plugModel.getPlug(plug); // not null

    }

    @PostMapping("/api/plugs/{plug:.+}")

    public void createPlug(

            @PathVariable("plug") String plug,

            @RequestBody List<String> members) {

        plugModel.setPlugs(plug, members);

        logger.info("Plug {}: created {},{}", plug, members);

    }

    private static final Logger logger = LoggerFactory.getLogger(PlugResource.class);

}