package com.adepto.staffshift.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.adepto.staffshift.entity.EmployeeDaysUnavailable;

@Mapper
public interface EmployeeDaysUnavailableDao {

	@Select("select employee_id as employeeID, days_unavailable as daysUnavailable from employee_days_unavailable")
	List<EmployeeDaysUnavailable> getAll();
	
	@Select("select employee_id as employeeID from employee_days_unavailable where days_unavailable = #{unavailableDay}")
	List<Integer> getEmployeeIDByUnavailableDay( @Param("unavailableDay") String unavailableDay );
	
}
