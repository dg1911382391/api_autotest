package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dg on 2019-04-26.
 */
@RestController
//@EnableAutoConfiguration
public class SampleController {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

//	public static void main(String[] args) throws Exception {
////		SpringApplication.run(SampleController.class, args);
////	}

}
