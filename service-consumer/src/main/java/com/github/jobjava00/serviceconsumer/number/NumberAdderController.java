package com.github.jobjava00.serviceconsumer.number;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jobjava00
 */
@RestController
@Slf4j
public class NumberAdderController {
	private final RandomServiceProxy randomServiceProxy;
	private final String numberServiceUrl;

	public NumberAdderController(RandomServiceProxy randomServiceProxy, @Value("${number.service.url}") String numberServiceUrl) {
		this.randomServiceProxy = randomServiceProxy;
		this.numberServiceUrl = numberServiceUrl;
	}

	@RequestMapping("/add")
	public Long add(){
		long sum = 0;
		var numbers = randomServiceProxy.getRandomNumbers();
		for(int number : numbers){
			sum += number;
		}
		log.warn("Returning "+ sum);
		return sum;
	}
}
