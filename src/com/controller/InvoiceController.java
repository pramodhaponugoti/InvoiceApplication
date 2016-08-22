package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.controller.command.InvoiceCommand;
import com.dao.bean.Invoice;
import com.dao.bean.InvoiceEmployee;
import com.service.InvoiceService;

@Controller
public class InvoiceController {	
	
	
	@Autowired
	private InvoiceService invoiceService = null;
	
	
	@RequestMapping(value="/sendEmail",method=RequestMethod.POST)
	public String generateInvoice(ModelMap modelMap,@ModelAttribute InvoiceCommand invoiceCommand , BindingResult results) throws Exception{
		
		sendMail(invoiceCommand.getEmailId(), "D:\\"+invoiceCommand.getFilePath());
		modelMap.addAttribute("invoiceCommand",invoiceCommand);			
		modelMap.addAttribute("resultMsg",invoiceCommand.getFilePath()+" invoice is successfully sent to  "+invoiceCommand.getEmailId() );
		
		return "invoice";
	}	
	
	@RequestMapping(value="/generateInvoice",method=RequestMethod.GET)
	public String loadInvoicePage(ModelMap modelMap) throws Exception{
			
		List<String> clientsList = invoiceService.getClientIds();
        for(String clientId : clientsList){
            List<String> projectList = invoiceService.getProjectIds(clientId);
            for(String projectId : projectList){                
                generateInvoiceReport(clientId, projectId);
            }
            
        }
		modelMap.addAttribute("invoiceCommand",new InvoiceCommand());
		modelMap.addAttribute("resultMsg","Invoice Reports are generated successfully...!");
	  		
		return "invoice";
	}
	
	@RequestMapping(value="/testData",method=RequestMethod.GET)
	public String loadTestData(ModelMap modelMap) throws Exception{
			
		modelMap.addAttribute("testDataList",invoiceService.getTestData());	  		
		return "testdata";
	}
	
	
	
	public void sendMail(String emailId, String filePath) throws Exception {

		String host = "smtp.gmail.com";
		String from = "rishabjain0619@gmail.com";
		String to = emailId;
		String password = "dfmvjrxuhvoosdyv";

		// Get system properties
		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", from);
		properties.put("mail.password", password);
		properties.put("mail.debug", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};
		Session session = Session.getInstance(properties, auth);

		// Define message
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("InvoiceReport Mail Attachment");

		// Create the message part
		BodyPart messageBodyPart = new MimeBodyPart();

		// Fill the message
		messageBodyPart
				.setText("Please find the attched document for Invoice Report.");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// Part two is attachment
		messageBodyPart = new MimeBodyPart();
		String filename = filePath;
		DataSource source = new FileDataSource(filename);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);
		multipart.addBodyPart(messageBodyPart);

		// Put parts in message
		message.setContent(multipart);

		// Send the message
		Transport.send(message);
		System.out.println(" Done...Success>>>");

	}
	
	
		
	public void generateInvoiceReport(String clientId, String projectId) {
		try {

			Invoice invoiceBean = invoiceService.getClientDetails(clientId,
					projectId);
			List<InvoiceEmployee> emplList = invoiceService.getEmployeeDetails(
					clientId, projectId);
			List<Double> billRateList = invoiceService.getBillRateList();
			Double totalDueAmount = 0d;
			for (int i = 0; i < billRateList.size(); i++) {
				if (i == 2)
					totalDueAmount = totalDueAmount
							+ (billRateList.get(i) * 35);
				else
					totalDueAmount = totalDueAmount
							+ (billRateList.get(i) * 40);
			}

			@SuppressWarnings("resource")
			XWPFDocument document = new XWPFDocument();
			FileOutputStream out = new FileOutputStream(new File("D:\\"+
					invoiceBean.getClientNumber() + "_"
							+ invoiceBean.getProject() + ".docx"));

			XWPFParagraph mainParagraph = document.createParagraph();
			XWPFRun mainRun = mainParagraph.createRun();
			mainRun.setFontSize(16);
			mainRun.setText(" Eagle Consulting Invoice ");

			XWPFTable InvoiceTable = document.createTable();

			XWPFTableRow row1 = InvoiceTable.getRow(0);
			XWPFTableCell cell1 = row1.addNewTableCell();
			XWPFParagraph p1 = cell1.addParagraph();
			XWPFRun invoiceRun = p1.createRun();
			invoiceRun.setFontSize(14);
			String invoiceData = "To:"+invoiceBean.getClientName()+"\n      " + invoiceBean.getAddressLine1()
					+ "\n     " + invoiceBean.getCity() + " , "
					+ invoiceBean.getState() + " , " + invoiceBean.getZip()
					+ "\n\n     Client ID: " + invoiceBean.getClientNumber()
					+ "\n      Project: " + invoiceBean.getProject();

			if (invoiceData.contains("\n")) {
				String[] lines = invoiceData.split("\n");
				for (int i = 0; i < lines.length; i++) {
					invoiceRun.setText(lines[i]);
					invoiceRun.addBreak();
				}
			} else {
				invoiceRun.setText(invoiceData, 0);
			}

			XWPFTableCell cell2 = row1.addNewTableCell();
			XWPFParagraph p2 = cell2.addParagraph();
			XWPFRun run2 = p2.createRun();
			run2.setFontSize(14);
			String data2 = "      Invoice Number: "
					+ invoiceBean.getClientNumber() + "\n     Invoice Date: "
					+ invoiceBean.getInvoiceDate() + "\n    Payment Terms: "
					+ invoiceBean.getPaymentTerms() + "\n"
					+ "   Billing Frequency: " + invoiceBean.getBillingFreq()
					+ "\n   Total Amount Due: $" + totalDueAmount;

			if (data2.contains("\n")) {
				String[] lines = data2.split("\n");
				for (int i = 0; i < lines.length; i++) {
					run2.setText(lines[i]);
					run2.addBreak();

				}
			} else {
				run2.setText(data2, 0);
			}

			XWPFParagraph paragraph = document.createParagraph();
			XWPFRun run3 = paragraph.createRun();
			run3.setFontSize(14);
			run3.addBreak();
			run3.setText("Details ");
			run3.addBreak();

			XWPFTable employeetable = document.createTable();

			// create first row
			XWPFTableRow tableRowOne = employeetable.getRow(0);

			tableRowOne.getCell(0).setText(" Date");
			tableRowOne.addNewTableCell().setText("  Description");
			tableRowOne.addNewTableCell().setText("  Rate");
			tableRowOne.addNewTableCell().setText("  Hours");
			tableRowOne.addNewTableCell().setText("  Amount");

			for (int i = 0; i < emplList.size(); i++) {
				// create second row
				InvoiceEmployee emp = emplList.get(i);

				XWPFTableRow tableRow = employeetable.createRow();
				String[] startDate = emp.getStartDate().split("/");
				String[] endDate = emp.getEndDate().split("/");

				tableRow.getCell(0).setText(
						startDate[0] + "/" + startDate[1] + " - " + endDate[0]
								+ "/" + endDate[1]);
				tableRow.getCell(1).setText(emp.getEmpName());
				tableRow.getCell(2).setText(emp.getBillRate());
				if (i == 2) {
					tableRow.getCell(3).setText(35 + "");
					tableRow.getCell(4).setText(
							(Double.valueOf(emp.getBillRate()) * 35) + "");
				} else {
					tableRow.getCell(3).setText(40 + "");
					tableRow.getCell(4).setText(
							(Double.valueOf(emp.getBillRate()) * 40) + "");
				}

			}

			XWPFTableRow r3 = employeetable.createRow();
			r3.getCell(0).setText("");
			r3.getCell(1).setText("");
			r3.getCell(2).setText("");
			r3.getCell(3).setText("Total ");
			r3.getCell(4).setText(totalDueAmount + "");

			XWPFParagraph footer = document.createParagraph();
			XWPFRun footerRun = footer.createRun();
			footerRun.setFontSize(14);
			String footerData = "Remit Payment To:\n   Eagle Consulting\n  2501 E Memorial Road\n  Edmond, Ok 73013";
			footerRun.addBreak();

			if (footerData.contains("\n")) {
				String[] lines = footerData.split("\n");
				for (int i = 0; i < lines.length; i++) {
					footerRun.setText(lines[i]);
					footerRun.addBreak();
				}
			} else {
				footerRun.setText(invoiceData, 0);
			}

			document.write(out);
			out.close();

		} catch (Exception exp) {
			// JOptionPane.showMessageDialog(null, exp);
		}
	}

}
