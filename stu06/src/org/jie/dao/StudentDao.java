package org.jie.dao;

import java.util.List;

import org.jie.model.Student;
import org.jie.pagination.Pagination;
import org.jie.pagination.SearchResult;

public interface StudentDao {

	SearchResult<Student> queryStudentByNameAndGenderWithPagination(Pagination page, String name, int gender);

	boolean saveStudent(Student stu);

	boolean deleteStudentById(int stuId);

	Student queryStudentById(int stuId);

	boolean updateStudentById(Student stu);
	
	List<Student> queryStudentByName(String name);
	

}
