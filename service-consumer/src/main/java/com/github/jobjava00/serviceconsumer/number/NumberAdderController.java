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
	@Value("${number.service.url}")
	private String numberServiceUrl;

	@RequestMapping("/add")
	public Long add(){
		long sum = 0;
		var responseEntity = new RestTemplate().getForEntity(numberServiceUrl, Integer[].class);
		var numbers = responseEntity.getBody();

		for(int number : numbers){
			sum += number;
		}
		log.warn("Returning "+ sum);
		return sum;
	}
}
