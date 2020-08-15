package com.projects.homebase;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;

@SpringBootApplication
public class HomebaseApplication {
	/**
	 * Reference: Logging from => https://www.tutorialspoint.com/spring_boot/spring_boot_logging.htm
	 */

	/**
	 * TODO: Add Robust Logging that includes the following:
	 * 	1. States which endpoint has been hit
	 * 	2. the payload that has been received
	 * 	3. start and end of each method triggered
	 * 	4. Replaces all System.out.printlns
	 *
	 *
	 * TODO: Refactor JSON for device so that paramter and valueTypes are one object:
	 * 	Currently parameters is String and value types are String []
	 * 	EX)      "valueTypes": [
	 *           	"power",
	 *           	"speed",
	 *           	"oscillate"
	 *           	],
	 *           "parameter": "code"
	 * 	Change to object with corresponding valuesTypes for given paramter
	 * 	EX)		"parameters": [
	 * 				{
	 * 				 name: code,
	 * 				 options: [
	 * 				 	"power",
	 * 				 	"speed",
	 * 				 	"oscillate"
	 * 				 ]
	 * 				}
	 *
	 *
	 * TODO: Refactor code to follow following design pattern:
	 * 	1. Controller exposes the endpoint, takes payload and calls service
	 * 	2. Service handles business logic and call all dependencies like models, or utils that are needed
	 * 	3. Service returns to controller what is needed
	 * 	4. Controller takes in response from services and passes it into responseService that formats corresponding response to give to client
	 *
	 *
	 * TODO: Real Exception Handling:
	 * 	1. Document all possible exception scenarios request by request
	 *
	 *
	 * @param args
	 */

	private static final Logger LOGGER = LoggerFactory.getLogger(HomebaseApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(HomebaseApplication.class, args);
		LOGGER.info("Running HomeApplication Main");
	}

}
