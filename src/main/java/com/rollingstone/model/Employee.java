package com.rollingstone.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ROLLINGSTONE_EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "EMPLOYEE_NUMBER", nullable = false)
	private String employeeNumber;
	
	@Column(name = "EMPLOYEE_NAME", nullable = false)
	private String employeeName;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	private String sex;
	
	@Column(name = "EMPLOYEE_TYPE", nullable = false)
	private String employeeType;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE", nullable = false, unique = false, length = 10)
	private Date startDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<Address> addresses = new HashSet<Address>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	@JsonIgnore
	private Set<EmployeeContacts> contacts = new HashSet<EmployeeContacts>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<EmployeeContacts> getContacts() {
		return contacts;
	}

	public void setContacts(Set<EmployeeContacts> contacts) {
		this.contacts = contacts;
	}

	public Employee(long id, String employeeNumber, String employeeName, String firstName, String lastName, String sex,
			String employeeType, Date startDate, Set<Address> addresses, Set<EmployeeContacts> contacts) {
		super();
		this.id = id;
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.employeeType = employeeType;
		this.startDate = startDate;
		this.addresses = addresses;
		this.contacts = contacts;
	}
	
	public Employee(long id, String employeeNumber, String employeeName, String firstName, String lastName) {
		super();
		this.id = id;
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.firstName = firstName;
		this.lastName = lastName;
        }

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeNumber=" + employeeNumber + ", employeeName=" + employeeName
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex + ", employeeType="
				+ employeeType + ", startDate=" + startDate + ", addresses=" + addresses + ", contacts=" + contacts
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((employeeNumber == null) ? 0 : employeeNumber.hashCode());
		result = prime * result + ((employeeType == null) ? 0 : employeeType.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeeNumber == null) {
			if (other.employeeNumber != null)
				return false;
		} else if (!employeeNumber.equals(other.employeeNumber))
			return false;
		if (employeeType == null) {
			if (other.employeeType != null)
				return false;
		} else if (!employeeType.equals(other.employeeType))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	
	
}
