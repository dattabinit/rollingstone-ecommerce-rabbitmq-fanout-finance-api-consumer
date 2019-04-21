package com.rollingstone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROLLINGSTONE_EMPLOYEE_CONTACTS")
public class EmployeeContacts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "CONTACT_NUMBER", nullable = false)
	private String contactNumber;
	
	@Column(name = "CONTACT_TYPE", nullable = false)
	private String contactType;
	
	@Column(name = "CONTACT", nullable = false)
	private String contact;
	
	@Column(name = "CONTACT_DESCRIPTION", nullable = false)
	private String contactDescription;
	
	@Column(name = "IS_PRIMARY", nullable = false)
	private boolean isPrimary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContactDescription() {
		return contactDescription;
	}

	public void setContactDescription(String contactDescription) {
		this.contactDescription = contactDescription;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeContacts(long id, String contactNumber, String contactType, String contact,
			String contactDescription, boolean isPrimary, Employee employee) {
		super();
		this.id = id;
		this.contactNumber = contactNumber;
		this.contactType = contactType;
		this.contact = contact;
		this.contactDescription = contactDescription;
		this.isPrimary = isPrimary;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeContacts [id=" + id + ", contactNumber=" + contactNumber + ", contactType=" + contactType
				+ ", contact=" + contact + ", contactDescription=" + contactDescription + ", isPrimary=" + isPrimary
				+ ", employee=" + employee + "]";
	}

	public EmployeeContacts() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((contactDescription == null) ? 0 : contactDescription.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((contactType == null) ? 0 : contactType.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isPrimary ? 1231 : 1237);
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
		EmployeeContacts other = (EmployeeContacts) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (contactDescription == null) {
			if (other.contactDescription != null)
				return false;
		} else if (!contactDescription.equals(other.contactDescription))
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (contactType == null) {
			if (other.contactType != null)
				return false;
		} else if (!contactType.equals(other.contactType))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		if (isPrimary != other.isPrimary)
			return false;
		return true;
	}
	
	
}
