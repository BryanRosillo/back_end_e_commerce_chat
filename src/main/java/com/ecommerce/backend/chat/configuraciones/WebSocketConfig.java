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
		.setAllowedOriginPatterns("http://localhost:5173", "http://127.0.0.1:5173", "http://localhost:8080", "http://127.0.0.1:8080", "https://frontend-ecommerce-ejhtfceeerhvbva5.canadacentral-01.azurewebsites.net")
		.withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry configuracion) {
		configuracion.enableSimpleBroker("/topic");
		configuracion.setApplicationDestinationPrefixes("/app");
	}
}
