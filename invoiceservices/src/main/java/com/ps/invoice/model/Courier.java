package com.ps.invoice.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Courier {
	private int courierId;
	private String customerName;
	private String customerAddress;
	private String  bookingDate;
	private String  deliveryFrom;
	private String  deliveryTo;
	private BigDecimal  itemWeight;
	

}
