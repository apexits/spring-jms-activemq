package com.javasampleapproach.jms.controller;

import com.javasampleapproach.jms.client.JmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.jms.ConnectionFactory;

@Controller
@EnableJms
public class MessageController {
    @Autowired
    JmsClient jsmClient;

    @GetMapping("/sendmessage")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Test Message") String name, Model model) {
        model.addAttribute("name", name);
        jsmClient.send(name);
        return "done";
    }


    @RequestMapping("done")
    @ResponseBody
    public String done(){
        return "done";
    }
}
