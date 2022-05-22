package com.ps.courier.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document(collection="courier")
@Data
@Setter
@Getter
@NoArgsConstructor
public class Courier {
	//for testing purpose constructor
	public Courier(int i, String string, String string2, String string3, String string4, String string5, double d) {
		// TODO Auto-generated constructor stub
	}
	@Id
	private int courierId;
	private String customerName;
	private String customerAddress;
	private String  bookingDate;
	private String  deliveryFrom;
	private String  deliveryTo;
	private BigDecimal  itemWeight;
	@org.springframework.data.annotation.Transient
	public static final String SEQUENCE_NAME = "user_sequence";

	
	
}

