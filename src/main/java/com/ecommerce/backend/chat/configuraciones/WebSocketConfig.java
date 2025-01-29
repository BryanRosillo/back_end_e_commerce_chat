package com.ecommerce.backend.chat.configuraciones;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry configuracion) {
		configuracion.addEndpoint("/chat-websocket")
		.setAllowedOriginPatterns("*")
		.withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry configuracion) {
		configuracion.enableSimpleBroker("/topic");
		configuracion.setApplicationDestinationPrefixes("/app");
	}
}
