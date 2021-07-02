package com.synechron.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	Logger logger = LoggerFactory.getLogger(HomeResource.class);

	@GetMapping("/")
	public String getHomePage()
	{
		return "<h1>Welcome User</h1>";
	}
}
