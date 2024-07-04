
package databank.jsf;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.SessionMap;
import javax.inject.Inject;
import javax.inject.Named;

import databank.dao.ListDataDao;
import databank.dao.StudentDao;
import databank.model.StudentPojo;

/**
 * Description:  Responsible for collection of Student Pojo's in XHTML (list) <h:dataTable> </br>
 * Delegates all C-R-U-D behavior to DAO
 */
/**
 * This class handles UI events when the user click the buttons in the UI and also when the user loads the views transfers information to the views.
 * 
 *
 */
@Named
@SessionScoped
public class StudentController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	@SessionMap
	private Map<String, Object> sessionMap;

	@Inject
	private StudentDao studentDao;

	@Inject
	private ListDataDao listDataDao;

	private List<StudentPojo> students;

	//Necessary methods to make controller work

	public void loadStudents() {
		setStudents(studentDao.readAllStudents());
	}

	public List<StudentPojo> getStudents() {
		return students;
	}

	public void setStudents(List<StudentPojo> students) {
		this.students = students;
	}

	public List<String> getPrograms() {
		return this.listDataDao.readAllPrograms();
	}
	
	public String navigateToAddForm() {
		sessionMap.put("newStudent", new StudentPojo());
		return "add-student.xhtml?faces-redirect=true";
	}
	/**
	 * This is the method invoked when the user presses the button on the add student page.
	 * @param student student
	 * @return redirection to the list student page.
	 */

	public String submitStudent(StudentPojo student) {
		// Update the student object with current date.  You can use LocalDateTime::now().
		student.setCreated(LocalDateTime.now());
		//Use DAO to insert the student to the database
		studentDao.createStudent(student);
		//Navigate the user back to list-students.xhtml
		return "list-students.xhtml?faces-redirect=true";
		
	}
	/**
	 * This the method when the user presses the edit button on the list student page. 
	 * @param studentId Id of the student that should be updated
	 * @return redirection to edit student page.
	 */

	public String navigateToUpdateForm(int studentId) {
		//Use DAO to find the student object from the database first
		StudentPojo student=studentDao.readStudentById(studentId);
		
		//Use session map to keep track of of the object being edited
		sessionMap.put("existingStudent",student);
		
		
		// Navigate the user to the edit/update form
		
		return "edit-student.xhtml?faces-redirect=true";
	}
	/**
	 * This is the method invoked when the user presses the button on the edit student page.
	 * @param student student
	 * @return redirection to the list student page.
	 */
	public String submitUpdatedStudent(StudentPojo student) {
		//Use DAO to update the student in the database
		studentDao.updateStudent(student);
		//Navigate the user back to list-students.xhtml
		return "list-students.xhtml?faces-redirect=true";
	
	}
	/**
	 * This method is invoked when the user presses the delete button on the list student page.
	 * @param studentId the Id of the student that is being deleted.
	 * @return redirect to the list student page.
	 */

	public String deleteStudent(int studentId) {
		//Delete the student from the database
		
		studentDao.deleteStudentById(studentId);
		//Navigate the user back to list-students.xhtml
		return "list-students.xhtml?faces-redirect=true";
		
		
	}

}
