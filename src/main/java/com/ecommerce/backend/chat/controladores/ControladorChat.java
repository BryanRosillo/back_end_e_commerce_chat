package com.ecommerce.backend.chat.controladores;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.ecommerce.backend.chat.entidades.Mensaje;

@Controller
public class ControladorChat {

	@MessageMapping("/enviarMensaje")
	@SendTo("/topic/mensajes")
	public Mensaje enviarMensaje(Mensaje mensaje) {
		return mensaje;
	}
}
