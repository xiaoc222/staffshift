package com.adepto.staffshift.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adepto.staffshift.controller.GreetingController;
import com.adepto.staffshift.dao.EmployeeDaysUnavailableDao;
import com.adepto.staffshift.dao.EmployeeMaxhoursDao;
import com.adepto.staffshift.dao.EmployeeValidRolesDao;
import com.adepto.staffshift.dao.ShiftDao;
import com.adepto.staffshift.entity.Shift;

@Service
public class StaffShiftAllocationService {

	@Autowired
	EmployeeDaysUnavailableDao employeeDaysUnavailableDao;

	@Autowired
	EmployeeMaxhoursDao employeeMaxhoursDao;

	@Autowired
	EmployeeValidRolesDao employeeValidRolesDao;

	@Autowired
	ShiftDao shiftDao;

	private static Logger logger = LoggerFactory.getLogger(StaffShiftAllocationService.class);

	/**
	 * update all shifts one by one
	 */
	public void updateAllShift() {

		logger.info("update all shift");

		// get all shift need to be update
		List<Shift> shifts = shiftDao.getAllEmptyShift();
		int times = shifts.size();

		// update all shift
		for (int i = 0; i < times; i++) {
			// update one shift
			updateOneShift();
		}

	}

	/**
	 * get all allocated shifts
	 * 
	 * @return
	 */
	public List<Shift> getAllAllocationShift() {
		return shiftDao.getAllAllocationShift();
	}

	/**
	 * update only one shift one time
	 */
	@Transactional
	public void updateOneShift() {

		// get empty shift
		Shift shift = shiftDao.getEmptyShift();
		if (shift == null) {
			return;
		}

		int shiftID = shift.getShiftID();
		String day = shift.getDay();
		String requiredRole = shift.getRequiredRole();
		int hours = shift.getHours();
		// all unavailable employee at this day
		List<Integer> daysUnavailableEmployeeIDs = employeeDaysUnavailableDao.getEmployeeIDByUnavailableDay(day);
		// all role matched employee
		List<Integer> requiredRoleEmployeeIDs = employeeValidRolesDao.getEmployeeIDByValidRoles(requiredRole);
		// all hours matched employee
		List<Integer> hoursEmployeeIDs = employeeMaxhoursDao.getEmployeeIDByMaxHours(hours);
		// employee already in shift
		List<Integer> shiftUnavailableEmployeeIDs = shiftDao.getUnavailableEmployeeIDByDay(day);

		List<Integer> finalEmployeeIDs = new ArrayList<>();

		// do log
		logger.info(shift.toString());
		logger.info(daysUnavailableEmployeeIDs.toString());
		logger.info(requiredRoleEmployeeIDs.toString());
		logger.info(hoursEmployeeIDs.toString());
		logger.info(shiftUnavailableEmployeeIDs.toString());

		finalEmployeeIDs.addAll(requiredRoleEmployeeIDs);
		// match role and hours
		finalEmployeeIDs.retainAll(hoursEmployeeIDs);
		// match unavailable day
		finalEmployeeIDs.removeAll(daysUnavailableEmployeeIDs);
		// match shift
		finalEmployeeIDs.removeAll(shiftUnavailableEmployeeIDs);

		logger.info(finalEmployeeIDs.toString());

		if (finalEmployeeIDs.size() == 0) {
			logger.info("finalEmployeeIDs is empty");
			return;
		}

		// get first employeeID
		int employeeID = finalEmployeeIDs.get(0);

		// update max hours
		employeeMaxhoursDao.updateMaxHoursByEmployeeID(employeeID, hours);

		// update shift
		shiftDao.updateEmployeeIDByShiftID(shiftID, employeeID);

	}

}
