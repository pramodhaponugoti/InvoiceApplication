package com.controller;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.bean.Client;
import com.dao.bean.Company;
import com.dao.bean.Employee;
import com.dao.bean.Project;
import com.dao.bean.ProjectPerson;
import com.service.ClientService;
import com.service.CompanyService;
import com.service.EmployeeService;
import com.service.ProjectPersonService;
import com.service.ProjectService;
import com.service.UserService;

@Controller
public class MainPageController {	
		
	@Autowired
	private UserService userService = null;	
	
	@Autowired	
	private ClientService clientService = null;
	
	@Autowired
	private CompanyService companyService = null;
	
	@Autowired
	private EmployeeService employeeService = null;
	
	@Autowired
	private ProjectService projectService = null;
	
	@Autowired
	private ProjectPersonService projectPersonService = null;
		
	@RequestMapping(value="/importClientData",method=RequestMethod.GET)
	public String getClientBrowsePage(ModelMap modelMap) throws Exception{		
		modelMap.addAttribute("pageInfo", "Please Select Client Data File");
		modelMap.addAttribute("processData", "client");
		return "browse";
	}
	
	@RequestMapping(value="/importCompanyData",method=RequestMethod.GET)
	public String getCompanyBrowsePage(ModelMap modelMap) throws Exception{		
		modelMap.addAttribute("pageInfo", "Please Select Company Data File");
		modelMap.addAttribute("processData", "company");	
		return "browse";
	}
	
	@RequestMapping(value="/importEmployeeData",method=RequestMethod.GET)
	public String getEmployeeBrowsePage(ModelMap modelMap) throws Exception{		
		modelMap.addAttribute("pageInfo", "Please Select Employee Data File");
		modelMap.addAttribute("processData", "employee");
		return "browse";
	}
	
	@RequestMapping(value="/importProjectData",method=RequestMethod.GET)
	public String getProjectBrowsePage(ModelMap modelMap) throws Exception{		
		modelMap.addAttribute("pageInfo", "Please Select Project Data File");
		modelMap.addAttribute("processData", "project");
		return "browse";
	}
	
	@RequestMapping(value="/importProjectPersonData",method=RequestMethod.GET)
	public String getProjectPersonBrowsePage(ModelMap modelMap) throws Exception{		
		modelMap.addAttribute("pageInfo", "Please Select Project Person Data File");
		modelMap.addAttribute("processData", "projectPerson");
		return "browse";
	}
	

	
		
	@RequestMapping(value="/uploadData",method=RequestMethod.POST)
	public String uploadData(ModelMap modelMap,HttpServletRequest request) throws Exception{	
		
		if(request.getParameter("hiddenFileName").equalsIgnoreCase("client")){
			saveClientData("D:/InvoiceDataFiles/"+request.getParameter("filePath"));
			modelMap.addAttribute("result","Client Data Imported Successfully");
			modelMap.addAttribute("clientDataList",clientService.getAllClients());
			return "clientdata";
		}else if(request.getParameter("hiddenFileName").equalsIgnoreCase("company")){
			saveCompanyData("D:/InvoiceDataFiles/"+request.getParameter("filePath"));
			modelMap.addAttribute("result","Company Data Imported Successfully");
			modelMap.addAttribute("companyDataList",companyService.getAllCompanies());
			return "companydata";
		}else if(request.getParameter("hiddenFileName").equalsIgnoreCase("employee")){
			saveEmployeeData("D:/InvoiceDataFiles/"+request.getParameter("filePath"));
			modelMap.addAttribute("result","Employee Data Imported Successfully");
			modelMap.addAttribute("employeeDataList",employeeService.getAllEmps());
			return "employeedata";
		}else if(request.getParameter("hiddenFileName").equalsIgnoreCase("project")){
			saveProjectData("D:/InvoiceDataFiles/"+request.getParameter("filePath"));
			modelMap.addAttribute("result","Project Data Imported Successfully");
			modelMap.addAttribute("projectDataList",projectService.getAllProjects());
			return "projectdata";
		}else {
			saveProjectPersonData("D:/InvoiceDataFiles/"+request.getParameter("filePath"));
			modelMap.addAttribute("result","Project Person Data Imported Successfully");
			modelMap.addAttribute("projectPersonDataList",projectPersonService.getAllProjectPersons());
			return "projectpersondata";
		}	
		
	}
	
	public void saveClientData(String filePath) throws Exception {

		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		List<Client> clientsList = new ArrayList<Client>();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() != 0) {
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				Client clientBean = new Client();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						clientBean.setClientNumber(getCellValue(nextCell)
								.toString().replace(".0", ""));
						break;
					case 1:
						clientBean.setName((String) getCellValue(nextCell));
						break;

					case 2:
						clientBean
								.setAddressLine1((String) getCellValue(nextCell));
						break;
					case 3:
						clientBean
								.setAddressLine2((String) getCellValue(nextCell));
						break;
					case 4:
						clientBean.setCity((String) getCellValue(nextCell));
						break;
					case 5:
						clientBean.setState((String) getCellValue(nextCell));
						break;
					case 6:
						clientBean.setZip(getCellValue(nextCell).toString()
								.replace(".0", ""));
						break;
					case 7:
						clientBean.setEmail((String) getCellValue(nextCell));
						break;
					case 8:
						clientBean.setContact((String) getCellValue(nextCell));
						break;
					case 9:
						clientBean
								.setInvoiceFreq((String) getCellValue(nextCell));
						break;
					case 10:
						clientBean
								.setBillingTerms((String) getCellValue(nextCell));
						break;
					case 11:
						clientBean
								.setInvoiceGrouping((String) getCellValue(nextCell));
						break;

					}

				}
				clientsList.add(clientBean);
			}

		}
		workbook.close();
		fis.close();

		for (Client client : clientsList) {
			clientService.addClient(client);
		}

	}
	
	
	public void saveCompanyData(String filePath) throws Exception {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		List<Company> companyList = new ArrayList<Company>();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() != 0) {
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				Company company = new Company();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						company.setName((String) getCellValue(nextCell));
						break;
					case 1:
						company.setAddressLine1((String) getCellValue(nextCell));
						break;
					case 2:
						company.setAddressLine2((String) getCellValue(nextCell));
						break;
					case 3:
						company.setCity((String) getCellValue(nextCell));
						break;
					case 4:
						company.setState((String) getCellValue(nextCell));
						break;
					case 5:
						company.setZip(getCellValue(nextCell).toString()
								.replace(".0", ""));
						break;
					}

				}
				companyList.add(company);
			}

		}
		workbook.close();
		fis.close();
		for(Company company : companyList){
			companyService.addCompany(company);
		}
	}
	
	public void saveEmployeeData(String filePath) throws Exception {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		List<Employee> employeesList = new ArrayList<Employee>();	

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() != 0) {
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				Employee employee = new Employee();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						employee.setName((String) getCellValue(nextCell));
						break;
					case 1:
						employee.setTitle((String) getCellValue(nextCell));
						break;
					case 2:
						employee.setBillRate(getCellValue(nextCell).toString()
								.replace(".0", ""));
						break;
					case 3:
						employee.setRole((String) getCellValue(nextCell)
								.toString());
						break;

					}

				}
				employeesList.add(employee);
			}

		}
		workbook.close();
		fis.close();
		
		for(Employee employee : employeesList){
			employeeService.addEmployee(employee);
		}
		
	}
	
	public void saveProjectData(String filePath) throws Exception {

		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		List<Project> projectList = new ArrayList<Project>();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() != 0) {
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				Project projectBean = new Project();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						projectBean.setClientNumber(getCellValue(nextCell)
								.toString().replace(".0", ""));
						break;
					case 1:
						projectBean.setProjectNumber(getCellValue(nextCell)
								.toString().replace(".0", ""));
						break;
					case 2:
						projectBean.setProjectName(getCellValue(nextCell)
								.toString());
						break;
					case 3:
						projectBean
								.setStartDate((String) getCellValue(nextCell));
						break;
					case 4:
						projectBean.setEndDate((String) getCellValue(nextCell));
						break;
					case 5:
						projectBean.setStatus((String) getCellValue(nextCell));
						break;
					case 6:
						projectBean
								.setProjectManager((String) getCellValue(nextCell));
						break;
					case 7:
						projectBean
								.setClientContact((String) getCellValue(nextCell));
						break;
					case 8:
						projectBean
								.setBudget(getCellValue(nextCell).toString());
						break;

					}

				}
				projectList.add(projectBean);
				
    }
 
    
                }    
    workbook.close();
    fis.close();
    for(Project project : projectList){
		projectService.addProject(project);
	}    
		
	}
	
	public void saveProjectPersonData(String filePath) throws Exception {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		List<ProjectPerson> projectPersonBeansList = new ArrayList<ProjectPerson>();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() != 0) {
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				ProjectPerson projectPersonBean = new ProjectPerson();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						projectPersonBean.setProjectNumber(getCellValue(
								nextCell).toString().replace(".0", ""));
						break;
					case 1:
						projectPersonBean.setPersonName(getCellValue(nextCell)
								.toString());
						break;

					}

				}
				projectPersonBeansList.add(projectPersonBean);
			}

		}
		workbook.close();
		fis.close();
		for(ProjectPerson projectPerson :projectPersonBeansList){
			projectPersonService.addProjectPerson(projectPerson);
		}
		
	}
	
	
	private Object getCellValue(Cell cell) {
	    switch (cell.getCellType()) {
	    case Cell.CELL_TYPE_STRING:
	        return cell.getStringCellValue();
	 
	    case Cell.CELL_TYPE_BOOLEAN:
	        return cell.getBooleanCellValue();
	        
	    case Cell.CELL_TYPE_NUMERIC:  
	        DataFormatter df = new DataFormatter();	
	        String stringCellValue = df.formatCellValue(cell);
	        return stringCellValue;
	    }
	 
	    return null;
	}
}
