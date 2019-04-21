package com.rollingstone.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ACCOUNT_RECEIVABLE")
public class AccountRceivable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "TRANSACTION_NUMBER", nullable = false)
	private String transactionNumber;
	
	@Column(name = "ACCOUNT_ID", nullable = false)
	private long accountId;
	
	@Column(name = "USER_ID", nullable = false)
	private long user_id;
	
	@Column(name = "SALES_ORDER_ID", nullable = false)
	private long salesOrderId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TRANSACTION_DATE", nullable = false, unique = false, length = 10)
	private Date transactionDate;
	
	@Column(name = "TRANSACTION_AMOUNT", nullable = false)
	private double transactionAmount;
	
	@Column(name = "SALES_REP_ID", nullable = false)
	private long salesRepId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public long getSalesRepId() {
		return salesRepId;
	}

	public void setSalesRepId(long salesRepId) {
		this.salesRepId = salesRepId;
	}

	public AccountRceivable(long id, String transactionNumber, long accountId, long user_id, long salesOrderId,
			Date transactionDate, double transactionAmount, long salesRepId) {
		super();
		this.id = id;
		this.transactionNumber = transactionNumber;
		this.accountId = accountId;
		this.user_id = user_id;
		this.salesOrderId = salesOrderId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.salesRepId = salesRepId;
	}

	public AccountRceivable(
			String transactionNumber, 
			long accountId, 
			long user_id, 
			long salesOrderId,
			Date transactionDate, 
			double transactionAmount, 
			long salesRepId) {
		super();
		this.transactionNumber = transactionNumber;
		this.accountId = accountId;
		this.user_id = user_id;
		this.salesOrderId = salesOrderId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.salesRepId = salesRepId;
	}
	public AccountRceivable() {
		super();
	}

	@Override
	public String toString() {
		return "AccountRceiVable [id=" + id + ", transactionNumber=" + transactionNumber + ", accountId=" + accountId
				+ ", user_id=" + user_id + ", salesOrderId=" + salesOrderId + ", transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + ", salesRepId=" + salesRepId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (salesOrderId ^ (salesOrderId >>> 32));
		result = prime * result + (int) (salesRepId ^ (salesRepId >>> 32));
		long temp;
		temp = Double.doubleToLongBits(transactionAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((transactionNumber == null) ? 0 : transactionNumber.hashCode());
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
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
		AccountRceivable other = (AccountRceivable) obj;
		if (accountId != other.accountId)
			return false;
		if (id != other.id)
			return false;
		if (salesOrderId != other.salesOrderId)
			return false;
		if (salesRepId != other.salesRepId)
			return false;
		if (Double.doubleToLongBits(transactionAmount) != Double.doubleToLongBits(other.transactionAmount))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionNumber == null) {
			if (other.transactionNumber != null)
				return false;
		} else if (!transactionNumber.equals(other.transactionNumber))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	
	
	
}
