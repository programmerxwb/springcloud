package com.wenbin;

import com.wenbin.config.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ApplicationContext ioc;

	@Test
	void contextLoads() {
		/*System.out.println(ioc.containsBean("student1"));
		Student student = (Student)ioc.getBean("student");
		System.out.println(student.getName());*/

		Logger logger = LoggerFactory.getLogger((getClass()));
		logger.trace("这是trace日志");
		logger.warn("warn");
		logger.debug("debug");
		logger.info("info");
		logger.error("error");
	}

}
