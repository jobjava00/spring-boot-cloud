package com.github.jobjava00.microservicea.message;

import com.github.jobjava00.microservicea.configuration.ApplicationConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jobjava00
 */
@RestController
public class MessageController {
	private final ApplicationConfiguration configuration;

	public MessageController(ApplicationConfiguration configuration) {
		this.configuration = configuration;
	}

	@RequestMapping("/message")
	public Map<String, String> welcome() {
		var map = new HashMap<String, String>();
		map.put("message", configuration.getMessage());
		return map;
	}
}
