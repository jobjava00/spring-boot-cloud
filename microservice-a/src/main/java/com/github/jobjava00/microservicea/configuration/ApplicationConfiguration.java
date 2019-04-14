package com.github.jobjava00.microservicea.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jobjava00
 */
@Component
@ConfigurationProperties("application")
public class ApplicationConfiguration {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
