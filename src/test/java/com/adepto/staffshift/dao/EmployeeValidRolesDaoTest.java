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
public class EmployeeValidRolesDaoTest {

	@Autowired
	EmployeeValidRolesDao employeeValidRolesDao;
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeValidRolesDaoTest.class);
	
	@Test
	public void testGetAll() {
		employeeValidRolesDao.getAll();
	}
	
	@Test
	public void testGetEmployeeIDByValidRoles(){
		employeeValidRolesDao.getEmployeeIDByValidRoles("Cook");
	}
	
}
