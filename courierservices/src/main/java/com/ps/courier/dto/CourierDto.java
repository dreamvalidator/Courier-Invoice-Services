package com.ps.courier.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class CourierDto {
	
	private int courierId;
	private String customerName;
	private String customerAddress;
	private String  bookingDate;
	private String  deliveryFrom;
	private String  deliveryTo;
	private BigDecimal  itemWeight;
	
	
}
