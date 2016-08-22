package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.command.ProjectCommand;
import com.dao.bean.Project;
import com.service.ProjectService;

@Controller
public class ProjectController {	
	
	
	@Autowired	
	private ProjectService projectService = null;
	
	
	@RequestMapping(value="/addProjectForm",method=RequestMethod.GET)
	public String addProjectForm(ModelMap modelMap) throws Exception{
		modelMap.addAttribute("projectCommand",new ProjectCommand());
		return "project";
	}
		
	
	@RequestMapping(value="/projectList",method=RequestMethod.GET)
	public String getProjectList(ModelMap modelMap) throws Exception{	
		modelMap.addAttribute("projectDataList",projectService.getAllProjects());		
		return "projectlist";
	}
	
	@RequestMapping(value="/addProject",method=RequestMethod.POST)
	public String addProject(ModelMap modelMap,@ModelAttribute ProjectCommand projectCommand , BindingResult results) throws Exception{
		
		modelMap.addAttribute("projectCommand",projectCommand);
		if(projectService.isProjectExist(projectCommand.getProjectNumber())){
			results.rejectValue("projectNumber", "projectnumber.exist", "Project Number is allready exists");
			return "project";
		}
		Project  project = new Project();
		
		project.setProjectNumber(projectCommand.getProjectNumber());
		project.setClientNumber(projectCommand.getClientNumber());
		project.setProjectName(projectCommand.getProjectName());
		project.setStartDate(projectCommand.getStartDate());
		project.setEndDate(projectCommand.getEndDate());
		project.setStatus(projectCommand.getStatus());
		project.setProjectManager(project.getProjectManager());
		project.setClientContact(projectCommand.getClientContact());
		project.setBudget(projectCommand.getBudget());
		project.setIsActive(projectCommand.getIsActive());
		
		projectService.addProject(project);
		modelMap.addAttribute("resultMsg","Project Registration is successfull...!" );
		modelMap.addAttribute("projectDataList",projectService.getAllProjects());
		return "projectlist";
	}
	
	@RequestMapping(value = "/editProject", method = RequestMethod.GET)
	public String editProject(ModelMap modelMap,	@RequestParam("projectNumber") String projectNumber) throws Exception {

		Project project = projectService.getProjectByNumber(projectNumber);
		

		ProjectCommand projectCommand = new ProjectCommand();

		projectCommand.setProjectNumber(project.getProjectNumber());
		projectCommand.setClientNumber(project.getClientNumber());
		projectCommand.setProjectName(project.getProjectName());
		projectCommand.setStartDate(project.getStartDate());
		projectCommand.setEndDate(project.getEndDate());
		projectCommand.setStatus(project.getStatus());
		projectCommand.setProjectManager(project.getProjectManager());
		projectCommand.setClientContact(project.getClientContact());
		projectCommand.setBudget(project.getBudget());
		projectCommand.setIsActive(project.getIsActive());

		modelMap.addAttribute("projectCommand", projectCommand);
		
		if (project.getIsActive())
			return "editproject";
		else
			return "readeditproject";
			
	}
	
	
	@RequestMapping(value="/updateProject",method=RequestMethod.POST)
	public String updateProject(ModelMap modelMap,@ModelAttribute ProjectCommand projectCommand , BindingResult results) throws Exception{
		
		modelMap.addAttribute("projectCommand",projectCommand);
		
		Project project = new Project();
		
		project.setProjectNumber(projectCommand.getProjectNumber());
		project.setClientNumber(projectCommand.getClientNumber());
		project.setProjectName(projectCommand.getProjectName());
		project.setStartDate(projectCommand.getStartDate());
		project.setEndDate(projectCommand.getEndDate());
		project.setStatus(projectCommand.getStatus());
		project.setProjectManager(project.getProjectManager());
		project.setClientContact(projectCommand.getClientContact());
		project.setBudget(projectCommand.getBudget());
		project.setIsActive(projectCommand.getIsActive());
		
		projectService.updateProject(project);
		modelMap.addAttribute("resultMsg","Project Updation is successfull...!" );
		modelMap.addAttribute("projectDataList",projectService.getAllProjects());
		return "projectlist";
	}
	
	@RequestMapping(value="/inactiveProject",method=RequestMethod.GET)
	public String inActiveProject(ModelMap modelMap, @RequestParam("projectNumber") String projectNumber) throws Exception{
		
		projectService.updateProjectStatus(projectNumber);
		modelMap.addAttribute("resultMsg","Project is inactivated...!" );
		modelMap.addAttribute("projectDataList",projectService.getAllProjects());
		return "projectlist";
	}

}
