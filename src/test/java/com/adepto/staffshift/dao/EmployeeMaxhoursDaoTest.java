package com.adepto.staffshift.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMaxhoursDaoTest {

	@Autowired
	EmployeeMaxhoursDao employeeMaxhoursDao;

	private static Logger logger = LoggerFactory.getLogger(EmployeeMaxhoursDaoTest.class);
	
	@Test
	public void testGetAll() {
		employeeMaxhoursDao.getAll();
	}

	@Test
	public void testGetEmployeeIDByMaxHours() {
		employeeMaxhoursDao.getEmployeeIDByMaxHours(5);
	}

	@Test
	public void testUpdateMaxHoursByEmployeeID() {
		employeeMaxhoursDao.updateMaxHoursByEmployeeID(5, 6);
	}

}
