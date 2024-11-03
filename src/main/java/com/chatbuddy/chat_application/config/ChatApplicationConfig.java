package com.chatbuddy.chat_application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Configuration
@EnableWebSocketMessageBroker

public class ChatApplicationConfig implements WebSocketMessageBrokerConfigurer {
	

}
