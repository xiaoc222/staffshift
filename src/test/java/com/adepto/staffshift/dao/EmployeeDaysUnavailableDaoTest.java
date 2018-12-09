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
public class EmployeeDaysUnavailableDaoTest {

	@Autowired
	EmployeeDaysUnavailableDao employeeDaysUnavailableDao;
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeDaysUnavailableDaoTest.class);
	
	@Test
	public void testGetAll() {
		employeeDaysUnavailableDao.getAll();
	}
	
	@Test
	public void testGetEmployeeIDByUnavailableDay( ) {
		employeeDaysUnavailableDao.getEmployeeIDByUnavailableDay("SUN");
	}
	
}
