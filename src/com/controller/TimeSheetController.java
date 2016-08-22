package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.command.TimeSheetCommand;
import com.dao.bean.TimeSheet;
import com.service.TimeSheetService;
import com.service.UserService;

@Controller
public class TimeSheetController {	
		
	
	@Autowired
	private UserService userService = null;
	
	@Autowired
	private TimeSheetService timeSheetService = null;
	
	
	@RequestMapping(value="/addTimeSheetForm",method=RequestMethod.GET)
	public String addTimeSheetForm(ModelMap modelMap) throws Exception{
		TimeSheetCommand timeSheetCommand = new TimeSheetCommand();
		timeSheetCommand.setPersonName(userService.getLoginName());
		modelMap.addAttribute("timeSheetCommand",timeSheetCommand);
		modelMap.addAttribute("dateList",getDates());
		modelMap.addAttribute("role", userService.getLoginRole());
		return "timesheet";
	}
	
	@RequestMapping(value="/editTimeSheetForm",method=RequestMethod.GET)
	public String editTimeSheetForm(ModelMap modelMap,
			@RequestParam("personName") String personName ,@RequestParam("loginDate") String loginDate  ) throws Exception{
	
	TimeSheet timeSheet =	timeSheetService.getTimeSheet(personName, loginDate);
	TimeSheetCommand timeSheetCommand = new TimeSheetCommand();
	timeSheetCommand.setPersonName(timeSheet.getPersonName());
	timeSheetCommand.setLoginDate(timeSheet.getLoginDate());
	timeSheetCommand.setNumberOfHours(timeSheet.getNumberOfHours());
	timeSheetCommand.setStatus(timeSheet.getStatus());
	
		modelMap.addAttribute("timeSheetCommand",timeSheetCommand);
		modelMap.addAttribute("dateList",getDates());
		modelMap.addAttribute("role", userService.getLoginRole());
		
		return "edittimesheet";
	}
		
	
	@RequestMapping(value="/timeSheetList",method=RequestMethod.GET)
	public String getTimeSheetList(ModelMap modelMap) throws Exception{	
		modelMap.addAttribute("role", userService.getLoginRole());
		if(userService.getLoginRole().equalsIgnoreCase("Developer")){
		modelMap.addAttribute("timeSheetDataList",timeSheetService.getTimeSheets(userService.getLoginName().substring(1,4)));
		return "timesheetlist";
		}
		else{
			modelMap.addAttribute("timeSheetDataList",timeSheetService.getTimeSheets());
			return "mgrtimesheetlist";
		}
		
	}
	
	@RequestMapping(value="/saveOrUpdateTimeSheet",method=RequestMethod.POST)
	public String saveOrUpdateTimeSheet(ModelMap modelMap,@ModelAttribute TimeSheetCommand timeSheetCommand) throws Exception{
		
		TimeSheet timeSheet = new TimeSheet();
		timeSheet.setPersonName(timeSheetCommand.getPersonName());
		timeSheet.setLoginDate(timeSheetCommand.getLoginDate());
		timeSheet.setNumberOfHours(timeSheetCommand.getNumberOfHours());
		timeSheet.setStatus(timeSheetCommand.getStatus());
		
		if(timeSheetService.isTimeSheetExist(timeSheet)){
			timeSheetService.updateTimeSheet(timeSheet);
		}else{
			timeSheetService.saveTimeSheet(timeSheet);
		}
		
		modelMap.addAttribute("role", userService.getLoginRole());
			
		if(userService.getLoginRole().equalsIgnoreCase("Developer")){
			modelMap.addAttribute("timeSheetDataList",timeSheetService.getTimeSheets(userService.getLoginName().substring(1,4)));
			return "timesheetlist";
			}
			else{
				modelMap.addAttribute("timeSheetDataList",timeSheetService.getTimeSheets());
				return "mgrtimesheetlist";
			}
	
	}
	

	@RequestMapping(value="/approveTimeSheet",method=RequestMethod.GET)
	public String approveTimeSheet(ModelMap modelMap,
			@RequestParam("personName") String personName ,@RequestParam("loginDate") String loginDate  ) throws Exception{
	
	TimeSheet timeSheet =	timeSheetService.getTimeSheet(personName, loginDate);
	timeSheet.setStatus("Approved");	
	timeSheetService.updateTimeSheetStatus(timeSheet);
	
	modelMap.addAttribute("role", userService.getLoginRole());
	modelMap.addAttribute("resultMsg","TimeSheet is Approved Successfully..!");
	
	if(userService.getLoginRole().equalsIgnoreCase("Developer")){
		modelMap.addAttribute("timeSheetDataList",timeSheetService.getTimeSheets(userService.getLoginName().substring(1,4)));
		return "timesheetlist";
		}
		else{
			modelMap.addAttribute("timeSheetDataList",timeSheetService.getTimeSheets());
			return "mgrtimesheetlist";
		}
	}
	
	@RequestMapping(value="/disApproveTimeSheet",method=RequestMethod.GET)
	public String disApproveTimeSheet(ModelMap modelMap,
			@RequestParam("personName") String personName ,@RequestParam("loginDate") String loginDate  ) throws Exception{
	
	TimeSheet timeSheet =	timeSheetService.getTimeSheet(personName, loginDate);
	timeSheet.setStatus("DisApproved");	
	timeSheetService.updateTimeSheetStatus(timeSheet);
	
	modelMap.addAttribute("role", userService.getLoginRole());
	modelMap.addAttribute("resultMsg","TimeSheet is DisApproved Successfully..!");
	
	if(userService.getLoginRole().equalsIgnoreCase("Developer")){
		modelMap.addAttribute("timeSheetDataList",timeSheetService.getTimeSheets(userService.getLoginName().substring(1,4)));
		return "timesheetlist";
		}
		else{
			modelMap.addAttribute("timeSheetDataList",timeSheetService.getTimeSheets());
			return "mgrtimesheetlist";
		}
	}
		
	public List<String> getDates(){
		List<String> dateList = new ArrayList<String>();
		dateList.add("22/08/2016");
		dateList.add("21/08/2016");
		dateList.add("20/08/2016");
		dateList.add("19/08/2016");
		dateList.add("18/08/2016");
		dateList.add("17/08/2016");
		dateList.add("16/08/2016");
		dateList.add("15/08/2016");
		dateList.add("14/08/2016");
		dateList.add("13/08/2016");
		dateList.add("12/08/2016");
		dateList.add("11/08/2016");
		dateList.add("10/08/2016");
		dateList.add("09/08/2016");
		dateList.add("08/08/2016");
		dateList.add("07/08/2016");
		dateList.add("06/08/2016");
		dateList.add("05/08/2016");
		dateList.add("04/08/2016");
		dateList.add("03/08/2016");
		dateList.add("02/08/2016");
		dateList.add("01/08/2016");
		return dateList;
	}
}
