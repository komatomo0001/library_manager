package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

	@Entity
	@Table(name = "LOGS")
	public class Log {

	
	@Id
    @SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "LOG_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "LIBRARY_ID")
    private String libraryId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "RENT_DATE")
    private String rentDate;
    
    @Column(name = "RETURN_DATE")
    private String returnDate;
    
    @Column(name = "RETURN_DUE_DATE")
    private String returnDueDate;
}
