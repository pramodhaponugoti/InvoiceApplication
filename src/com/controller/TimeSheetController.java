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
		String sql = "";
		if(userService.getLoginRole().equals("Developer")){
            sql = " Select   ProjectNo , ProjectName  From TimeSheet where upper(PersonName) like  '%"+userService.getLoginName().toUpperCase()+"%' Group By ProjectNo , ProjectName";
           }else{
               sql = " Select   ProjectNo , ProjectName  From TimeSheet  Group By ProjectNo , ProjectName";
           }
		modelMap.addAttribute("projectDataList",timeSheetService.getProjectNameId(sql));
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
	timeSheetCommand.setPersonId(timeSheet.getPersonId());
	timeSheetCommand.setProjectData(timeSheet.getProjectNo()+"-"+timeSheet.getPersonName());
	
	String sql = "";
	if(userService.getLoginRole().equals("Developer")){
        sql = " Select   ProjectNo , ProjectName  From TimeSheet where upper(PersonName) like  '%"+userService.getLoginName().toUpperCase()+"%' Group By ProjectNo , ProjectName";
       }else{
           sql = " Select   ProjectNo , ProjectName  From TimeSheet  Group By ProjectNo , ProjectName";
       }
		modelMap.addAttribute("projectDataList",timeSheetService.getProjectNameId(sql));
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
		timeSheet.setPersonId(timeSheetCommand.getPersonId());
		String[] data = timeSheetCommand.getProjectData().split("-");		
		timeSheet.setProjectNo(data[0]);
		timeSheet.setProjectName(data[1]);
		
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
	timeSheet.setLoginDate(loginDate);
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
	timeSheet.setLoginDate(loginDate);
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
		dateList.add("06/26/2016");
		dateList.add("06/27/2016");
		dateList.add("06/28/2016");
		dateList.add("06/29/2016");
		dateList.add("06/30/2016");
		dateList.add("07/01/2016");
		dateList.add("07/02/2016");
		dateList.add("07/03/2016");
		dateList.add("07/04/2016");
		dateList.add("07/05/2016");
		dateList.add("07/06/2016");
		dateList.add("07/07/2016");
		dateList.add("07/08/2016");
		dateList.add("07/09/2016");
		dateList.add("07/10/2016");
		dateList.add("07/11/2016");
		dateList.add("07/12/2016");
		dateList.add("07/13/2016");
		dateList.add("07/14/2016");
		dateList.add("07/15/2016");
		dateList.add("07/16/2016");
		dateList.add("07/17/2016");
		dateList.add("07/18/2016");
		dateList.add("07/19/2016");
		dateList.add("07/20/2016");
		dateList.add("07/21/2016");
		dateList.add("07/22/2016");
		dateList.add("07/23/2016");
		dateList.add("07/24/2016");
		dateList.add("07/25/2016");
		dateList.add("07/26/2016");
		dateList.add("07/27/2016");
		dateList.add("07/28/2016");
		dateList.add("07/29/2016");
		dateList.add("07/30/2016");
		dateList.add("07/31/2016");
		dateList.add("08/01/2016");
		dateList.add("08/02/2016");
		dateList.add("08/03/2016");
		dateList.add("08/04/2016");
		dateList.add("08/05/2016");
		dateList.add("08/06/2016");
		dateList.add("08/07/2016");
		dateList.add("08/08/2016");
		dateList.add("08/09/2016");
		dateList.add("08/10/2016");
		dateList.add("08/11/2016");
		dateList.add("08/12/2016");
		dateList.add("08/13/2016");
		dateList.add("08/14/2016");
		dateList.add("08/15/2016");
		dateList.add("08/16/2016");
		dateList.add("08/17/2016");
		dateList.add("08/18/2016");
		dateList.add("08/19/2016");
		dateList.add("08/20/2016");
		dateList.add("08/21/2016");
		dateList.add("08/22/2016");
		dateList.add("08/23/2016");

		return dateList;
	}
}
