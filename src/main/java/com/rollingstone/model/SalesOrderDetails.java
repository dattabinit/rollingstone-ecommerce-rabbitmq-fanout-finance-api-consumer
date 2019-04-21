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
@Table(name = "ROLLINGSTONE_SALES_ORDER_DETAILS")
public class SalesOrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ITEM_LINE_NO", nullable = false)
	private String itemLineNumber;
	
	@Column(name = "UNIT_PRICE", nullable = false)
	private float unitPrice;
	
	@Column(name = "ITEM_QUANTITY", nullable = false)
	private int itemQuantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SALES_ORDER_ID", nullable = false)
	private SalesOrder salesOrder;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID", nullable = false)
	private ItemMaster item;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemLineNumber() {
		return itemLineNumber;
	}

	public void setItemLineNumber(String itemLineNumber) {
		this.itemLineNumber = itemLineNumber;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	public ItemMaster getItem() {
		return item;
	}

	public void setItem(ItemMaster item) {
		this.item = item;
	}

	public SalesOrderDetails(long id, String itemLineNumber, float unitPrice, int itemQuantity, SalesOrder salesOrder,
			ItemMaster item) {
		super();
		this.id = id;
		this.itemLineNumber = itemLineNumber;
		this.unitPrice = unitPrice;
		this.itemQuantity = itemQuantity;
		this.salesOrder = salesOrder;
		this.item = item;
	}

	public SalesOrderDetails() {
		super();
	}

	@Override
	public String toString() {
		return "SalesOrderDetails [id=" + id + ", itemLineNumber=" + itemLineNumber + ", unitPrice=" + unitPrice
				+ ", itemQuantity=" + itemQuantity + ", salesOrder=" + salesOrder + ", item=" + item + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((itemLineNumber == null) ? 0 : itemLineNumber.hashCode());
		result = prime * result + itemQuantity;
		result = prime * result + ((salesOrder == null) ? 0 : salesOrder.hashCode());
		result = prime * result + Float.floatToIntBits(unitPrice);
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
		SalesOrderDetails other = (SalesOrderDetails) obj;
		if (id != other.id)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (itemLineNumber == null) {
			if (other.itemLineNumber != null)
				return false;
		} else if (!itemLineNumber.equals(other.itemLineNumber))
			return false;
		if (itemQuantity != other.itemQuantity)
			return false;
		if (salesOrder == null) {
			if (other.salesOrder != null)
				return false;
		} else if (!salesOrder.equals(other.salesOrder))
			return false;
		if (Float.floatToIntBits(unitPrice) != Float.floatToIntBits(other.unitPrice))
			return false;
		return true;
	}

	
}
