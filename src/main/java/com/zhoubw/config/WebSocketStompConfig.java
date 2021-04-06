package com.zhoubw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //启用STOMP消息
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册STOMP端点，即WebSocket客户端需要连接到WebSocket握手端点
        //这是一个端点，客户端在订阅或发布消息到目的地路径前，要连接该端点
        registry.addEndpoint("/point")
                //跨域设置
                .setAllowedOriginPatterns("*")
                //allowedOriginPatterns
                //启用SockJS功能
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //设置消息代理，所有目的地前缀为"/topic","/queue"的消息都会发送到STOMP代理中
        registry.enableSimpleBroker("/topic","/user");
//        registry.setUserDestinationPrefix("/user");
        //设置应用程序的目的地前缀为"/app",当有以应用程序为目的地的消息将会直接路由到带有@MessageMapping注解的控制器方法
        registry.setApplicationDestinationPrefixes("/app");
    }
}
