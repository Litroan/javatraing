package com.bt.lit.demo.vo;

import java.util.List;

import lombok.Data;

@Data
public class ClassVO {
	private Integer classId;
	private String className;
	private List<StudentVO> students;
}
