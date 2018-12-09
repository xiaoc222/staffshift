package com.adepto.staffshift.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adepto.staffshift.entity.Shift;
import com.adepto.staffshift.service.StaffShiftAllocationService;
import com.google.gson.Gson;


@RestController
public class GreetingController {

	@Autowired
	StaffShiftAllocationService staffShiftAllocationService;

	private static Gson gson = new Gson();

	private static Logger logger = LoggerFactory.getLogger(GreetingController.class);
	
	/**
	 * redirect to show.html
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView method() {
		logger.info("wlecome");
	    return new ModelAndView("redirect:" + "show.html");
	}
	
	/**
	 * return shift data in json
	 * @return
	 */
	@RequestMapping("/getShift")
	public String getShift() {
		
		// update all shift
		staffShiftAllocationService.updateAllShift();

		// get all shift
		List<Shift> shifts = staffShiftAllocationService.getAllAllocationShift();
		String resultJson =  gson.toJson(shifts);
		logger.info(resultJson);

		return resultJson;
	}

}