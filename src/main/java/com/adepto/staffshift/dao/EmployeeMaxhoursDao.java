package com.adepto.staffshift.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.adepto.staffshift.entity.EmployeeMaxhours;

@Mapper
public interface EmployeeMaxhoursDao {

	@Select("select employee_id as employeeID, max_hours as maxHours from employee_maxhours")
	List<EmployeeMaxhours> getAll();
	
	@Select("select employee_id as employeeID from employee_maxhours where max_hours >= #{maxHours} ")
	List<Integer> getEmployeeIDByMaxHours(@Param("maxHours") int maxHours);

	@Update("update employee_maxhours set max_hours=max_hours-#{maxHours} where employee_id=#{employeeID}")
	void updateMaxHoursByEmployeeID(@Param("employeeID") int employeeID, @Param("maxHours") int maxHours) ;
	
}
