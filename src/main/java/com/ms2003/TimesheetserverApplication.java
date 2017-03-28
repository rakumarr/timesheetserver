package com.ms2003;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class TimesheetserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetserverApplication.class, args);
	}
}
