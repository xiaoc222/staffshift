package com.adepto.staffshift.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffShiftAllocationServiceTest {

	@Autowired
	StaffShiftAllocationService staffShiftAllocationService;
	
	private static Logger logger = LoggerFactory.getLogger(StaffShiftAllocationServiceTest.class);
	
	@Test
	public void testUpdateAllShift() {
		staffShiftAllocationService.updateAllShift();
	}
	
	@Test
	public void testUpdateOneShift() {
		staffShiftAllocationService.updateOneShift();
	}
	
	@Test
	public void testGetAllAllocationShift() {
		staffShiftAllocationService.getAllAllocationShift();
	}
	
}
