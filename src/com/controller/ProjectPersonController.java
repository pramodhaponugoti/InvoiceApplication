package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.command.ProjectPersonCommand;
import com.dao.bean.ProjectPerson;
import com.service.ProjectPersonService;
import com.service.UserService;

@Controller
public class ProjectPersonController {	
	
	
	@Autowired	
	private ProjectPersonService projectPersonService = null;
	
	@Autowired
	private UserService userService = null;
	
	@RequestMapping(value="/addProjectPersonForm",method=RequestMethod.GET)
	public String addProjectPersonForm(ModelMap modelMap) throws Exception{
		modelMap.addAttribute("projectPersonCommand",new ProjectPersonCommand());
		modelMap.addAttribute("role", userService.getLoginRole());
		return "projectperson";
	}	
		
	
	@RequestMapping(value="/projectPersonList",method=RequestMethod.GET)
	public String getProjectPersonList(ModelMap modelMap) throws Exception{	
		modelMap.addAttribute("projectPersonDataList",projectPersonService.getAllProjectPersons());		
		modelMap.addAttribute("role", userService.getLoginRole());
		return "projectpersonlist";
	}
	
	@RequestMapping(value="/addProjectPerson",method=RequestMethod.POST)
	public String addProjectPerson(ModelMap modelMap,@ModelAttribute ProjectPersonCommand projectPersonCommand , BindingResult results) throws Exception{
		
		modelMap.addAttribute("projectPersonCommand",projectPersonCommand);
		
		ProjectPerson  projectPerson = new ProjectPerson();
		
		projectPerson.setProjectNumber(projectPersonCommand.getProjectNumber());
		projectPerson.setPersonName(projectPersonCommand.getPersonName());
		modelMap.addAttribute("role", userService.getLoginRole());
		
		if(projectPersonService.isProjectPersonExist(projectPerson)){
			results.rejectValue("projectNumber", "projectnumber.exist", "Project Number and Person Name is allready exists");
			return "projectperson";
		}
		
		
		projectPersonService.addProjectPerson(projectPerson);
		modelMap.addAttribute("resultMsg","Project Person Registration is successfull...!" );
		modelMap.addAttribute("projectPersonDataList",projectPersonService.getAllProjectPersons());
		return "projectpersonlist";
	}
	
	@RequestMapping(value = "/editProjectPerson", method = RequestMethod.GET)
	public String editProjectPerson(ModelMap modelMap,	@RequestParam("projectNumber") String projectNumber,@RequestParam("personName") String personName) throws Exception {

		ProjectPerson projectPerson = new ProjectPerson();
		projectPerson.setProjectNumber(projectNumber);
		projectPerson.setPersonName(personName);
		
		ProjectPerson projectPerson2 = projectPersonService.getProjectPersonByNumber(projectPerson);
		
		ProjectPersonCommand projectPersonCommand = new ProjectPersonCommand();
		projectPersonCommand.setProjectNumber(projectNumber);
		projectPersonCommand.setPersonName(personName);
		
		modelMap.addAttribute("projectPersonCommand", projectPersonCommand);
		modelMap.addAttribute("role", userService.getLoginRole());
		if(projectPerson2.getIsActive())
			return "editprojectperson";
		
		else
			return "readeditprojectperson";
			
	}
	
	
	@RequestMapping(value="/updateProjectPerson",method=RequestMethod.POST)
	public String updateProjectPerson(ModelMap modelMap,@ModelAttribute ProjectPersonCommand projectPersonCommand , BindingResult results) throws Exception{
		
		modelMap.addAttribute("projectPersonCommand",projectPersonCommand);
		
		ProjectPerson projectPerson = new ProjectPerson();
		
		projectPerson.setProjectNumber(projectPersonCommand.getProjectNumber());
		projectPerson.setPersonName(projectPersonCommand.getPersonName());
		
		projectPersonService.updateProjectPerson(projectPerson);
		modelMap.addAttribute("role", userService.getLoginRole());
		
		modelMap.addAttribute("resultMsg","Project Person Updation is successfull...!" );
		modelMap.addAttribute("projectPersonDataList",projectPersonService.getAllProjectPersons());
		return "projectpersonlist";
	}
	
	@RequestMapping(value="/inactiveProjectPerson",method=RequestMethod.GET)
	public String inActiveProjectPerson(ModelMap modelMap, @RequestParam("projectNumber") String projectNumber,@RequestParam("personName") String personName) throws Exception{
		
		ProjectPerson projectPerson = new ProjectPerson();
		projectPerson.setProjectNumber(projectNumber);
		projectPerson.setPersonName(personName);
		
		projectPersonService.updateProjectPersonStatus(projectPerson);
		modelMap.addAttribute("role", userService.getLoginRole());
		
		modelMap.addAttribute("resultMsg","Project Person is inactivated...!" );
		modelMap.addAttribute("projectPersonDataList",projectPersonService.getAllProjectPersons());
		return "projectpersonlist";
	}

}
