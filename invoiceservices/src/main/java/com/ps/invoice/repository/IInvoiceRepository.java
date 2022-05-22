package com.ps.invoice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ps.invoice.model.Courier;
import com.ps.invoice.model.Invoice;

public interface IInvoiceRepository extends  MongoRepository<Invoice, Integer> {
	 @Query("{'invoiceId':?0}")
	Invoice getInvoiceById(int invoiceId);
	
	
	  @Query("{'courierId':?0}")
	  Invoice getInvoiceDetailsByCourierId(int courierId);


	Invoice insert(Courier courierInfo);
	 
	 
	 
	 

	

}
