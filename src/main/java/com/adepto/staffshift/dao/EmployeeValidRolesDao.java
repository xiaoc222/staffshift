package com.adepto.staffshift.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.adepto.staffshift.entity.EmployeeValidRoles;

@Mapper
public interface EmployeeValidRolesDao {

	@Select("select employee_id as employeeID, valid_roles as role from employee_valid_roles ")
	List<EmployeeValidRoles> getAll();
	
	@Select("select employee_id as employeeID from employee_valid_roles where valid_roles = #{validRoles}")
	List<Integer> getEmployeeIDByValidRoles(@Param("validRoles") String validRoles);
	
}
