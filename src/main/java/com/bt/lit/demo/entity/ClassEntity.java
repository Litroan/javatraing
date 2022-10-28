package com.bt.lit.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "classlist")
public class ClassEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "classid")
		private Integer classId;
		
		@Column(name = "classnum")
		private String className;

		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name = "classnum")
		private List<StudentEntity> students;
		
}
