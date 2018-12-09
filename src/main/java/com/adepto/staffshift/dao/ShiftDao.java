package com.adepto.staffshift.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.adepto.staffshift.entity.Shift;

@Mapper
public interface ShiftDao {

	@Select("select shift_id as shiftID, day as day, required_role as requiredRole, hours as hours, employee_id as employeeID from shift ")
	List<Shift> getAll();
	
	@Select("select shift_id as shiftID, day as day, required_role as requiredRole, hours as hours, employee_id as employeeID from shift where employee_id=0 limit 1")
	Shift getEmptyShift();
	
	@Select("select shift_id as shiftID, day as day, required_role as requiredRole, hours as hours, employee_id as employeeID from shift where employee_id=0 ")
	List<Shift> getAllEmptyShift();
	
	@Select("select shift_id as shiftID, day as day, required_role as requiredRole, hours as hours, employee_id as employeeID from shift where employee_id <> 0 order by day ")
	List<Shift> getAllAllocationShift();
	
	@Select("select employee_id as employeeID from shift where employee_id <> 0 and day = #{day} ")
	List<Integer> getUnavailableEmployeeIDByDay(@Param("day") String day);
	
	@Update("update shift set employee_id=#{employeeID} where shift_id=#{shiftID} ")
	void updateEmployeeIDByShiftID(@Param("shiftID") int shiftID, @Param("employeeID") int employeeID);
	
}
