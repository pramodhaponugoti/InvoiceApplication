package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.command.ClientCommand;
import com.dao.bean.Client;
import com.service.ClientService;

@Controller
public class ClientController {	
	
	
	@Autowired
	private ClientService clientService = null;
	
	
	@RequestMapping(value="/addClientForm",method=RequestMethod.GET)
	public String addClientForm(ModelMap modelMap) throws Exception{
		modelMap.addAttribute("clientCommand",new ClientCommand());
		return "client";
	}
		
	
	@RequestMapping(value="/clientList",method=RequestMethod.GET)
	public String getClientList(ModelMap modelMap) throws Exception{	
		modelMap.addAttribute("clientDataList",clientService.getAllClients());		
		return "clientlist";
	}
	
	@RequestMapping(value="/addClient",method=RequestMethod.POST)
	public String addClient(ModelMap modelMap,@ModelAttribute ClientCommand clientCommand , BindingResult results) throws Exception{
		
		modelMap.addAttribute("clientCommand",clientCommand);
		if(clientService.isClientExist(clientCommand.getClientNumber())){
			results.rejectValue("clientNumber", "clientNumber.exist", "Client Number is allready exists");
			return "client";
		}
		Client client = new Client();
		
		client.setClientNumber(clientCommand.getClientNumber());
		client.setName(clientCommand.getName());
		client.setAddressLine1(clientCommand.getAddressLine1());
		client.setAddressLine2(clientCommand.getAddressLine2());
		client.setCity(clientCommand.getCity());
		client.setState(clientCommand.getState());
		client.setZip(clientCommand.getZip());
		client.setEmail(clientCommand.getEmail());
		client.setContact(clientCommand.getContact());
		client.setInvoiceFreq(clientCommand.getInvoiceFreq());
		client.setBillingTerms(clientCommand.getBillingTerms());
		client.setInvoiceGrouping(clientCommand.getInvoiceGrouping());
		client.setIsActive(clientCommand.getIsActive());
		
		clientService.addClient(client);
		modelMap.addAttribute("resultMsg","Client Registration is successfull...!" );
		modelMap.addAttribute("clientDataList",clientService.getAllClients());
		return "clientlist";
	}
	
	@RequestMapping(value = "/editClient", method = RequestMethod.GET)
	public String editClient(ModelMap modelMap,	@RequestParam("clientNumber") String clientNumber) throws Exception {

		Client client = clientService.getClientByNumber(clientNumber);
		

		ClientCommand clientCommand = new ClientCommand();

		clientCommand.setClientNumber(client.getClientNumber());
		clientCommand.setName(client.getName());
		clientCommand.setAddressLine1(client.getAddressLine1());
		clientCommand.setAddressLine2(client.getAddressLine2());
		clientCommand.setCity(client.getCity());
		clientCommand.setState(client.getState());
		clientCommand.setZip(client.getZip());
		clientCommand.setEmail(client.getEmail());
		clientCommand.setContact(client.getContact());
		clientCommand.setInvoiceFreq(client.getInvoiceFreq());
		clientCommand.setBillingTerms(client.getBillingTerms());
		clientCommand.setInvoiceGrouping(client.getInvoiceGrouping());
		clientCommand.setIsActive(client.getIsActive());

		modelMap.addAttribute("clientCommand", clientCommand);

		if(client.getIsActive())
			return "editclient";
		else
			return "readeditclient";
			
	}
	
	
	@RequestMapping(value="/updateClient",method=RequestMethod.POST)
	public String updateClient(ModelMap modelMap,@ModelAttribute ClientCommand clientCommand , BindingResult results) throws Exception{
		
		modelMap.addAttribute("clientCommand",clientCommand);
		
		Client client = new Client();
		
		client.setClientNumber(clientCommand.getClientNumber());
		client.setName(clientCommand.getName());
		client.setAddressLine1(clientCommand.getAddressLine1());
		client.setAddressLine2(clientCommand.getAddressLine2());
		client.setCity(clientCommand.getCity());
		client.setState(clientCommand.getState());
		client.setZip(clientCommand.getZip());
		client.setEmail(clientCommand.getEmail());
		client.setContact(clientCommand.getContact());
		client.setInvoiceFreq(clientCommand.getInvoiceFreq());
		client.setBillingTerms(clientCommand.getBillingTerms());
		client.setInvoiceGrouping(clientCommand.getInvoiceGrouping());
		client.setIsActive(clientCommand.getIsActive());
		
		clientService.updateClient(client);
		modelMap.addAttribute("resultMsg","Client Updation is successfull...!" );
		modelMap.addAttribute("clientDataList",clientService.getAllClients());
		return "clientlist";
	}
	
	@RequestMapping(value="/inactiveClient",method=RequestMethod.GET)
	public String inActiveClient(ModelMap modelMap, @RequestParam("clientNumber") String clientNumber) throws Exception{
		
		clientService.updateClientStatus(clientNumber);
		modelMap.addAttribute("resultMsg","Client is inactivated...!" );
		modelMap.addAttribute("clientDataList",clientService.getAllClients());
		return "clientlist";
	}

}
