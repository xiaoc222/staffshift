package com.adepto.staffshift.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.adepto.staffshift.entity.Shift;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiftDaoTest {

	@Autowired
	private ShiftDao shiftDao;

	private static Logger logger = LoggerFactory.getLogger(ShiftDaoTest.class);

	@Test
	public void testGetAll() {
		List<Shift> shifts = shiftDao.getAll();
		logger.info(shifts.toString());
	}

	@Test
	public void testGetEmptyShift() {
		Shift shift = shiftDao.getEmptyShift();
		if (shift != null) {
			logger.info(shift.toString());
		}
	}

	@Test
	public void testGetAllEmptyShift() {
		List<Shift> shifts = shiftDao.getAllEmptyShift();
		logger.info(shifts.toString());
	}

	@Test
	public void testGetAllAllocationShift() {
		List<Shift> shifts = shiftDao.getAllAllocationShift();
		logger.info(shifts.toString());
	}

	@Test
	public void testGetUnavailableEmployeeIDByDay() {
		List<Integer> shifts = shiftDao.getUnavailableEmployeeIDByDay("SAT");
		logger.info(shifts.toString());
	}

	@Test
	public void updateEmployeeIDByShiftID() {
		shiftDao.updateEmployeeIDByShiftID(188, 222);
	}

}
