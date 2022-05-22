
  package com.ps.invoice.services;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;

import com.ps.invoice.model.Courier;
import com.ps.invoice.model.Invoice; import
  com.ps.invoice.repository.IInvoiceRepository;
  
  @Service public class InvoiceService {
  
  @Autowired IInvoiceRepository iInvoiceRepository;
  
  public Invoice getInvoiceById(int invoiceId) {
  
	  return iInvoiceRepository.getInvoiceById(invoiceId);
  }
  
  }
 