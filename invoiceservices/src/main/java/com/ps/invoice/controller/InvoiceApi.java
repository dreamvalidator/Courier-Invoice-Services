package com.ps.invoice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.invoice.model.Courier;
import com.ps.invoice.model.Invoice;
import com.ps.invoice.repository.IInvoiceRepository;
import com.ps.invoice.restclient.CourierClient;
import com.ps.invoice.services.InvoiceService;
import com.ps.invoice.services.SequenceGeneratorService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/invoiceApi")
public class InvoiceApi {
	@Autowired
	private IInvoiceRepository invoiceRepo;
	@Autowired
	private CourierClient cc;
	@Autowired
    private	SequenceGeneratorService sg;
	@Autowired
	InvoiceService invoiceServ;
	@PostMapping("/createInvoice")
	public Invoice bookCourier(@RequestBody Invoice invoice) {
		invoice.setInvoiceId(sg.getSequenceNumber(invoice.SEQUENCE_NAME));
		Courier courier = cc.getCourierInfo(invoice.getCourierId());
		invoice.setCustomerName(courier.getCustomerName());
		invoice.setCustomerAddress(courier.getCustomerAddress());
		invoice.setBookingDate(courier.getBookingDate());
		invoice.setDeliveryFrom(courier.getDeliveryFrom());
		invoice.setDeliveryTo(courier.getDeliveryTo());
		invoice.setTotalAmount(invoice.getTotalAmount().multiply(courier.getItemWeight().add(invoice.getDeliveryCharge())));
		
		
		 Invoice savedInvoice = invoiceRepo.insert(invoice);
		 return(savedInvoice);
	}
	@GetMapping("/getAll")
	public List<Invoice> getInvoiceInfo() {
			return invoiceRepo.findAll();
	}
	@GetMapping(path= "/getInvoice/{invoiceId}")
	public Invoice getInvoiceById(@PathVariable int invoiceId) {
	
		return invoiceServ.getInvoiceById(invoiceId);
	
	}
	/*
	 * @GetMapping("/invoiceInfowithCustomerDetails/{courierId}") public Invoice
	 * getInvoiceDetailsWithCustomer(@PathVariable int courierId)
	 * 
	 * }
	 */
	

}
