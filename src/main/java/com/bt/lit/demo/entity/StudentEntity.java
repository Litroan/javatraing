package com.bt.lit.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "studentinfo")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentid")
	private Integer studentId;
	
	@Column(name = "name")
	private String studentName;
	
	@Column(name = "classnum")
	private Integer classnum;

//	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, fetch = FetchType.LAZY)
//	@JoinColumn(name = "studentid",insertable = false, updatable = false)
//	private ClassEntity classRoom;
}
