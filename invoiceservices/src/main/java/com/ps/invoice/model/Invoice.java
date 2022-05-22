package com.ps.invoice.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection="invoice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
	@Id
	private int invoiceId;
	private BigDecimal deliveryCharge;
	private BigDecimal totalAmount;
	@Transient
	private int courierId;
	private String customerName;
	private String customerAddress;
	private String  bookingDate;
	private String  deliveryFrom;
	private String  deliveryTo;
	
	   @Transient
	    public static final String SEQUENCE_NAME = "user_sequence";

}
