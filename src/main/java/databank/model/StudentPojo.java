
package databank.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.faces.view.ViewScoped;

/**
 *
 * Description:  Model for the Student object 
 */
@ViewScoped
public class StudentPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	private String program;
	private LocalDateTime created;

	public StudentPojo() {
		super();
	}

	public int getId() {
		return id;
	}

	/**
	 * @param id new value for id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the value for firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName new value for firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the value for lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName new value for lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program=program;
	}
	
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getCreated() {
		return created;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		return prime * result + Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj instanceof StudentPojo otherStudentPojo) {
			return Objects.equals(this.getId(), otherStudentPojo.getId());
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id = ").append(getId()).append(", ");
		if (getFirstName() != null) {
			builder.append( "firstName = ").append(getFirstName()).append(", ");
		}
		if (getLastName() != null) {
			builder.append("lastName = ").append(getLastName()).append(", ");
		}
		if (getEmail() != null) {
			builder.append("email = ").append(getEmail()).append(", ");
		}
		if (getPhoneNumber() != null) {
			builder.append("phoneNumber = ").append(getPhoneNumber()).append(", ");
		}
		if (getProgram() != null) {
			builder.append("program = ").append(getProgram()).append(", ");
		}
		builder.append("]");
		return builder.toString();
	}

}
