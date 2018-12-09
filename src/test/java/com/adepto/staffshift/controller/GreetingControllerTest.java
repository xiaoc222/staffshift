package com.adepto.staffshift.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingControllerTest {

	@Autowired
	GreetingController greetingController;
	
	private static Logger logger = LoggerFactory.getLogger(GreetingControllerTest.class);
	
	@Test
	public void testGetShift() {
		String str = greetingController.getShift();
		logger.info(str);
	} 
	
}
