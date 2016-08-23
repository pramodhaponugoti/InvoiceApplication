package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.command.CompanyCommand;
import com.dao.bean.Company;
import com.service.CompanyService;

@Controller
public class CompanyController {	
			
	
	
	@Autowired
	private CompanyService companyService = null;	
	
			
	
	@RequestMapping(value="/addCompanyForm",method=RequestMethod.GET)
	public String addCompanyForm(ModelMap modelMap) throws Exception{	
		modelMap.addAttribute("companyCommand",new CompanyCommand());
		return "company";
	}
		
	
	@RequestMapping(value="/companyList",method=RequestMethod.GET)
	public String getCompanyList(ModelMap modelMap) throws Exception{	
		modelMap.addAttribute("companyDataList",companyService.getAllCompanies());
		return "companylist";
	}
	
	
	@RequestMapping(value="/addCompany",method=RequestMethod.POST)
	public String addCompany(ModelMap modelMap,@ModelAttribute CompanyCommand companyCommand , BindingResult results) throws Exception{	
		
		modelMap.addAttribute("companyCommand",companyCommand);
		
		if(companyService.isComapnyExist(companyCommand.getName())){
			results.rejectValue("name", "company.exists", "Company is allready exists");
			return "company";
		}
		
		Company company = new Company();
		
		
		company.setName(companyCommand.getName());
		company.setAddressLine1(companyCommand.getAddressLine1());
		company.setAddressLine2(companyCommand.getAddressLine2());
		company.setCity(companyCommand.getCity());
		company.setState(companyCommand.getState());
		company.setZip(companyCommand.getZip());
		company.setIsActive(companyCommand.getIsActive());
		
		companyService.addCompany(company);
		
		modelMap.addAttribute("resultMsg","Company Registration is successfull..!");
		modelMap.addAttribute("companyDataList",companyService.getAllCompanies());
		return "companylist";
	}
	
	@RequestMapping(value="/editCompany",method=RequestMethod.GET)
	public String editCompany(ModelMap modelMap,@RequestParam("name") String name) throws Exception{	
		
		Company company = companyService.getComapnyByName(name);
		
		
		CompanyCommand companyCommand = new CompanyCommand();
		
		
		companyCommand.setName(company.getName());
		companyCommand.setAddressLine1(company.getAddressLine1());
		companyCommand.setAddressLine2(company.getAddressLine2());
		companyCommand.setCity(company.getCity());
		companyCommand.setState(company.getState());
		companyCommand.setZip(company.getZip());
		companyCommand.setIsActive(company.getIsActive());
		
		modelMap.addAttribute("companyCommand",companyCommand);
		
		if (company.getIsActive())
			return "editcompany";
		else
			return "readeditcompany";
			
	}
	
	
	@RequestMapping(value="/updateCompany",method=RequestMethod.POST)
	public String updateCompany(ModelMap modelMap,@ModelAttribute CompanyCommand companyCommand , BindingResult results) throws Exception{	
		
		modelMap.addAttribute("companyCommand",companyCommand);
		
				
		Company company = new Company();
		
		
		company.setName(companyCommand.getName());
		company.setAddressLine1(companyCommand.getAddressLine1());
		company.setAddressLine2(companyCommand.getAddressLine2());
		company.setCity(companyCommand.getCity());
		company.setState(companyCommand.getState());
		company.setZip(companyCommand.getZip());
		company.setIsActive(companyCommand.getIsActive());
		
		companyService.updateCompany(company);
		
		modelMap.addAttribute("resultMsg","Company Updation is successfull..!");
		modelMap.addAttribute("companyDataList",companyService.getAllCompanies());
		return "companylist";
	}
	
	@RequestMapping(value="/inactiveCompany",method=RequestMethod.GET)
	public String inactiveCompany(ModelMap modelMap,@RequestParam("name") String name) throws Exception{	
		
		companyService.updateCompanyStatus(name);
		
		modelMap.addAttribute("resultMsg","Company  is inactivated..!");
		modelMap.addAttribute("companyDataList",companyService.getAllCompanies());
		return "companylist";
	}
	
	
}
