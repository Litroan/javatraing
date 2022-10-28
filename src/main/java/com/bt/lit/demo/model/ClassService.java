package com.bt.lit.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.lit.demo.admin.api.BasicOut;
import com.bt.lit.demo.admin.api.CommonApiCode;
import com.bt.lit.demo.entity.ClassEntity;
import com.bt.lit.demo.entity.StudentEntity;
import com.bt.lit.demo.vo.ClassBriefVO;
import com.bt.lit.demo.vo.ClassQueryVO;
import com.bt.lit.demo.vo.ClassVO;
import com.bt.lit.demo.vo.StudentVO;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClassService {

	@Autowired
	ClassRepository classRepository;

	@Autowired
	StudentRepository studentRepository;

	// Get All Classroom List
	public List<ClassBriefVO> getclassroom() {
		List<ClassBriefVO> result = new ArrayList<ClassBriefVO>();
		ClassBriefVO briefVO = new ClassBriefVO();
		Iterable<ClassEntity> roomlist = classRepository.findAll();
		for (ClassEntity item : roomlist) {
			briefVO = new ClassBriefVO();
			briefVO.setClassId(item.getClassId());
			briefVO.setClassName(item.getClassName());
			result.add(briefVO);
		}

		return result;

	}

	// Get Studentlist into classlist
	public ClassVO getStudentList(ClassQueryVO queryVO) {
		ClassVO result = new ClassVO();
		StudentVO studentVO = null;
		List<StudentVO> listVO = new ArrayList<StudentVO>();
		// Iterable<StudentEntity> studentlist = studentRepository.findAll();

		// TODO Optional
		/*
		 * Optional 是值的容器，只有兩種狀態，不是有值就是沒值。目的是做為 null 的替代方案。將你輸入的值產生為 Optional
		 * 物件，這時Optional 物件即為該值的容器，若要取回該值，必須使用 get() 方法
		 * 
		 */
		Optional<ClassEntity> classroom = classRepository.findById(queryVO.getClassId());

		if (queryVO.getClassId() == classroom.get().getClassId()) {
			result.setClassId(classroom.get().getClassId());
			result.setClassName(classroom.get().getClassName());
		}

		for (StudentEntity item : classroom.get().getStudents()) {

			if (queryVO.getClassId() == item.getClassnum()) {
				studentVO = new StudentVO();
				studentVO.setStudentId(item.getStudentId());
				studentVO.setStudentName(item.getStudentName());
				listVO.add(studentVO);
//				log.debug("{}", item);
			}
			result.setStudents(listVO);
		}
		return result;
	}

	/**
	 * 將 Entity 轉換成 VO
	 * 
	 * @param d
	 * @return
	 */
	private ClassVO convertEditCEVO(ClassEntity d) {
		val outputVO = new ClassVO();
		BeanUtils.copyProperties(d, outputVO);
		return outputVO;
	}
	
	/**
	 * 將 Entity 轉換成 VO
	 * 
	 * @param d
	 * @return
	 */
	private StudentVO convertEditSEVO(StudentEntity d) {
		val outputVO = new StudentVO();
		BeanUtils.copyProperties(d, outputVO);
		return outputVO;
	}
	
	
	/**
	 * 將 Entity 轉換成 VO
	 * 
	 * @param dbDataList
	 * @return
	 */
	private List<StudentVO> convertSls(List<StudentEntity> stList) {
		List<StudentVO> detail = new ArrayList<>();
		StudentVO target = new StudentVO();
		for (StudentEntity data : stList) {
			target = new StudentVO();
			BeanUtils.copyProperties(data, target);
			detail.add(target);
		}
		return detail;
	}

	// Create New Class && Student
	public BasicOut<ClassVO> addStudent(ClassVO createVO) {
		val result = new BasicOut<ClassVO>();
		result.setCode(CommonApiCode.SUCCESS);
		ClassEntity cE = new ClassEntity();
		StudentEntity sE = new StudentEntity();
		List<StudentEntity> studentsList = new ArrayList<StudentEntity>();
		cE.setClassName(createVO.getClassName());
		log.debug("classRoom info: {}", cE);
		
		for (StudentVO item : createVO.getStudents()) {
			sE = new StudentEntity();
			sE.setStudentName(item.getStudentName());
			studentsList.add(sE);
		}

		cE.setStudents(studentsList);
		cE = classRepository.saveAndFlush(cE);
		result.setData(convertEditCEVO(cE));
		result.getData().setStudents(convertSls(cE.getStudents()));
		return result;
	}
	
	// Revise StudentName
	public BasicOut<StudentVO> reviseStudentName(StudentVO stuentInfo){
		val result = new BasicOut<StudentVO>();
		result.setCode(CommonApiCode.SUCCESS);
		Optional<StudentEntity> stData = studentRepository.findById(stuentInfo.getStudentId());
		
		// 確認欄位內有值
		if(stData.isPresent()) {
			StudentEntity sE = stData.get();
			// 新增新資料到欄位
			sE.setStudentName(stuentInfo.getStudentName());
			// 存檔
			sE = studentRepository.saveAndFlush(sE);
			result.setData(convertEditSEVO(sE));
		}
		return result;
	}
	
	//Delet Student
	public BasicOut<Void> deletStudent(StudentVO studentinfo){
		val result = new BasicOut<Void>();
		val d = studentRepository.findById(studentinfo.getStudentId());
		if (d.isPresent()) {
			studentRepository.delete(d.get());
		}
		return result;
	}

}
