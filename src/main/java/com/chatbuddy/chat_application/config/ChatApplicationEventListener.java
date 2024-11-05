package com.chatbuddy.chat_application.config;

import java.util.Objects;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.chatbuddy.chat_application.service.Message;
import com.chatbuddy.chat_application.service.MsgType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class ChatApplicationEventListener {
    
    private final SimpMessageSendingOperations messageOperations; // Line 22

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        
        if (Objects.nonNull(username)) {
            log.info("User disconnected: {}", username);
            
            messageOperations.convertAndSend("/topic/chat", Message.builder() // Line 30
                .type(MsgType.LEAVE) // Line 32
                .sender(username)
                .build());
        }
    }
}
