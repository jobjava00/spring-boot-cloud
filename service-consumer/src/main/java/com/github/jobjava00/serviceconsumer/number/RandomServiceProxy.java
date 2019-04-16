package com.github.jobjava00.serviceconsumer.number;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author jobjava00
 */
@FeignClient(name = "microservice-a")
@RibbonClient(name = "microservice-a")
public interface RandomServiceProxy {
	@GetMapping(value = "/random")
	List<Integer> getRandomNumbers();
}
