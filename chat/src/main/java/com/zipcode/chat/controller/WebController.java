package com.zipcode.chat.controller;

import com.zipcode.chat.model.Hello;
import com.zipcode.chat.model.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Controller
public class WebController {


    @MessageMapping("/hello")
    @SendTo("/topic/hi")
    public Hello greeting(User user) throws Exception {
        //return new Hello("Hi, " + user.getName() + "!");

        return new Hello(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
               + "            "  + user.getName() );


//        return new Hello( "User      " + user.getName()+  "            " +
//                new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

}
