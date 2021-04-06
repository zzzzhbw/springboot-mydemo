package com.zhoubw.controller;

import com.zhoubw.message.RequestMessage;
import com.zhoubw.message.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class MessageController {

    @Autowired
    public SimpMessagingTemplate template;
    /**
     * 处理发往 /app/greeting目的地的消息
     *
     * @param greeting
     * @return
     */
    @MessageMapping("/greeting")
//    @SendTo("/queue/greeting")
    public ResponseMessage handle(RequestMessage greeting) {
        //Spring的某一个消息转换器会将STOMP消息的负载转换为 RequestMessage对象
        log.info(greeting.getName());
        return new ResponseMessage("welcome，" + greeting.getName());
    }

    @SubscribeMapping("/subscribe")
    public ResponseMessage subscribe() {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setResponseMessage("欢迎订阅");
        return responseMessage;
    }

    //广播
    @RequestMapping("/message")
    public String message(){
        return "message";
    }

    //点对点
    @RequestMapping("/message2")
    public String message2(){
        return "message2";
    }

    @MessageMapping("/queue")
   @SendTo("/userqueue")
    public ResponseMessage queuw(RequestMessage rm) {
//        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
//        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info(rm.getName());
            /*广播使用convertAndSendToUser方法，第一个参数为用户id，此时js中的订阅地址为
            "/user/" + 用户Id + "/message",其中"/user"是固定的*/
            template.convertAndSendToUser(rm.getToname(),"/message",rm.getName());
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setResponseMessage(rm.getName());
        return responseMessage;

        }
}