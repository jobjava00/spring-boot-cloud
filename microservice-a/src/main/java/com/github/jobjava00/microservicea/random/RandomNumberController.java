package com.github.jobjava00.microservicea.random;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jobjava00
 */
@RestController
@Slf4j
public class RandomNumberController {
	@RequestMapping("/random")
	public List<Integer> random() {
		var numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++) {
			numbers.add(generateRandomNumber());
		}
		log.warn("Returning " + numbers);
		return numbers;
	}

	private int generateRandomNumber() {
		return (int) (Math.random() * 1000);
	}
}
