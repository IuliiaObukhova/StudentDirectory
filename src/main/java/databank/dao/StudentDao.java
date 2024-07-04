
package databank.dao;

import java.util.List;

import databank.model.StudentPojo;

/**
 * Description:  API for the database C-R-U-D operations
 */
public interface StudentDao {

	// C
	public StudentPojo createStudent(StudentPojo student);

	// R
	public StudentPojo readStudentById(int studentId);

	public List<StudentPojo> readAllStudents();

	// U
	public void updateStudent(StudentPojo student);

	// D
	public void deleteStudentById(int studentId);

}