package com.bt.lit.demo.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.lit.demo.admin.api.BasicOut;
import com.bt.lit.demo.model.ClassService;
import com.bt.lit.demo.model.StudentRepository;
import com.bt.lit.demo.vo.ClassBriefVO;
import com.bt.lit.demo.vo.ClassQueryVO;
import com.bt.lit.demo.vo.ClassVO;
import com.bt.lit.demo.vo.StudentVO;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.val;

@RestController

//TODO Requestmapping value、method、consumes、produces、params、headers
//value: 可以指定為普通的具體值、變數或是含某些正規表示的值 (Q1 設計變數API)
//method: 指定請求的method型別   ( 型別: GET, POST, HEAD, OPTIONS, PUT, PATCH, DELETE, TRACE )
//consumes: 指定處理請求的提交內容型別（Content-Type）
//produces: 指定返回的內容型別，僅當request請求頭中的型別中包含該指定型別才返回
//params: 指定request中必須包含某些引數才讓該方法處理
//headers: 指定request中必須包含某些指定的header值才能讓該方法處理請求
@RequestMapping(value = "/class", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

public class ClassController {
	
	//TODO Autowired 解釋
	/*
	 * 用來依賴注入 (DI) 物件
	 * 典型的用法就是掛在類別成員變數上
	 * 預設會依注入對象的類別型態來選擇容器中相符的物件來注入
	 */
	@Autowired
	ClassService classService;
	
	@Autowired
	StudentRepository StudentRepository;

	//Search ClassList
	@PostMapping(value = "/list")
	public List<ClassBriefVO> getroomlist(){
		List<ClassBriefVO> result = classService.getclassroom();
		return result;
	}
	
	//TODO CamelCase "駝峰式命名 _方便閱讀、"
	/*
	 * upper camel case,Pascal Case 大駝峰 第一個單字的首字母  "大寫"  ，其餘單字首字母大寫
	 * lower camel case 小駝峰 第一個單字的首字母  "小寫"  ，其餘單字首字母大寫
	 * Snake Case單字與單字間使用下劃線分隔
	 * kebab Case(spinal-case,Train-Case,Lisp-case)單字與單字間使用連接符號，有多種稱呼
	 */
	//Search StudentList by ClassList
	@PostMapping(value = "/studentlist")
	public ClassVO getStudentList(@RequestBody ClassQueryVO queryVO){
		return classService.getStudentList(queryVO);
	}
	
	//Create new Class && Students
	@PostMapping(value = "/add")
	public BasicOut<ClassVO> getStudent(@RequestBody ClassVO inputVO) {
		ClassVO createVO = new ClassVO();
		BeanUtils.copyProperties(inputVO, createVO);
		return classService.addStudent(createVO);
	}
	
	//Revise StudentName
	@PostMapping(value = "/revise")
	public BasicOut<StudentVO> reviseName(@RequestBody StudentVO inputVO) throws ParseException{
		StudentVO reviseVO = new StudentVO();
		BeanUtils.copyProperties(inputVO, reviseVO);
		return classService.reviseStudentName(reviseVO);
	}
	
	//Delet Student
	@PostMapping(value = "/del")
	public BasicOut<Void> deletName(@RequestBody StudentVO inputVo){
		val result = classService.deletStudent(inputVo);
		return result;
	}
	
	
}
