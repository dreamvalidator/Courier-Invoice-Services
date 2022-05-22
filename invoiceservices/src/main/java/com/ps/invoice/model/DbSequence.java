package com.ps.invoice.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "db_sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbSequence {

	@Id
    private String  id;
    private int seq;
}
