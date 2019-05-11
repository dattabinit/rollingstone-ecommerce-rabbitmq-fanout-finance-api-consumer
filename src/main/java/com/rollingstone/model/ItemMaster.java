package com.rollingstone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLLINGSTONE_ITEM")
public class ItemMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ITEM_SKU_CODE", nullable = false)
	private String itemSKUCode;
	
	@Column(name = "ITEM_UPC_CODE", nullable = false)
	private String itemUPCCode;
	
	@Column(name = "ITEM_NAME", nullable = false)
	private String itemName;
	
	@Column(name = "ITEM_DESCRIPTION", nullable = false)
	private String description;
	
	@Column(name = "ITEM_SHORT_DESCRIPTION", nullable = false)
	private String itemShortDescription;
	
	@Column(name = "ITEM_DIMENTION", nullable = false)
	private String dimention;
	
	@Column(name = "ITEM_SIZE", nullable = false)
	private String itemSize;
	
	@Column(name = "ITEM_COLOR", nullable = false)
	private String itemColor;
	
	@Column(name = "ITEM_MANUFACTURER", nullable = false)
	private String manufacturer;
	
	@Column(name = "ITEM_PRODUCER", nullable = false)
	private String itemProducer;
	
	@Column(name = "ITEM_PRODUCT_OF", nullable = false)
	private String productOf;
	
	@Column(name = "ITEM_SHIPPED_BY", nullable = false)
	private String shippedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemSKUCode() {
		return itemSKUCode;
	}

	public void setItemSKUCode(String itemSKUCode) {
		this.itemSKUCode = itemSKUCode;
	}

	public String getItemUPCCode() {
		return itemUPCCode;
	}

	public void setItemUPCCode(String itemUPCCode) {
		this.itemUPCCode = itemUPCCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemShortDescription() {
		return itemShortDescription;
	}

	public void setItemShortDescription(String itemShortDescription) {
		this.itemShortDescription = itemShortDescription;
	}

	public String getDimention() {
		return dimention;
	}

	public void setDimention(String dimention) {
		this.dimention = dimention;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}

	public String getItemColor() {
		return itemColor;
	}

	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getItemProducer() {
		return itemProducer;
	}

	public void setItemProducer(String itemProducer) {
		this.itemProducer = itemProducer;
	}

	public String getProductOf() {
		return productOf;
	}

	public void setProductOf(String productOf) {
		this.productOf = productOf;
	}

	public String getShippedBy() {
		return shippedBy;
	}

	public void setShippedBy(String shippedBy) {
		this.shippedBy = shippedBy;
	}

	public ItemMaster(long id, String itemSKUCode, String itemUPCCode, String itemName, String description,
			String itemShortDescription, String dimention, String itemSize, String itemColor, String manufacturer,
			String itemProducer, String productOf, String shippedBy) {
		super();
		this.id = id;
		this.itemSKUCode = itemSKUCode;
		this.itemUPCCode = itemUPCCode;
		this.itemName = itemName;
		this.description = description;
		this.itemShortDescription = itemShortDescription;
		this.dimention = dimention;
		this.itemSize = itemSize;
		this.itemColor = itemColor;
		this.manufacturer = manufacturer;
		this.itemProducer = itemProducer;
		this.productOf = productOf;
		this.shippedBy = shippedBy;
	}
	
	public ItemMaster(int itemQuantity,String itemUPCCode,String itemName, String itemColor,String itemSize, String itemShippedBy) {
		this.itemUPCCode = itemUPCCode;
		this.itemName = itemName;
		this.itemSize = itemSize;
		this.itemColor = itemColor;
		this.shippedBy = itemShippedBy;
	}

	public ItemMaster() {
		super();
	}

	@Override
	public String toString() {
		return "ItemMaster [id=" + id + ", itemSKUCode=" + itemSKUCode + ", itemUPCCode=" + itemUPCCode + ", itemName="
				+ itemName + ", description=" + description + ", itemShortDescription=" + itemShortDescription
				+ ", dimention=" + dimention + ", itemSize=" + itemSize + ", itemColor=" + itemColor + ", manufacturer="
				+ manufacturer + ", itemProducer=" + itemProducer + ", productOf=" + productOf + ", shippedBy="
				+ shippedBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dimention == null) ? 0 : dimention.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((itemColor == null) ? 0 : itemColor.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemProducer == null) ? 0 : itemProducer.hashCode());
		result = prime * result + ((itemSKUCode == null) ? 0 : itemSKUCode.hashCode());
		result = prime * result + ((itemShortDescription == null) ? 0 : itemShortDescription.hashCode());
		result = prime * result + ((itemSize == null) ? 0 : itemSize.hashCode());
		result = prime * result + ((itemUPCCode == null) ? 0 : itemUPCCode.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((productOf == null) ? 0 : productOf.hashCode());
		result = prime * result + ((shippedBy == null) ? 0 : shippedBy.hashCode());
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
		ItemMaster other = (ItemMaster) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dimention == null) {
			if (other.dimention != null)
				return false;
		} else if (!dimention.equals(other.dimention))
			return false;
		if (id != other.id)
			return false;
		if (itemColor == null) {
			if (other.itemColor != null)
				return false;
		} else if (!itemColor.equals(other.itemColor))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemProducer == null) {
			if (other.itemProducer != null)
				return false;
		} else if (!itemProducer.equals(other.itemProducer))
			return false;
		if (itemSKUCode == null) {
			if (other.itemSKUCode != null)
				return false;
		} else if (!itemSKUCode.equals(other.itemSKUCode))
			return false;
		if (itemShortDescription == null) {
			if (other.itemShortDescription != null)
				return false;
		} else if (!itemShortDescription.equals(other.itemShortDescription))
			return false;
		if (itemSize == null) {
			if (other.itemSize != null)
				return false;
		} else if (!itemSize.equals(other.itemSize))
			return false;
		if (itemUPCCode == null) {
			if (other.itemUPCCode != null)
				return false;
		} else if (!itemUPCCode.equals(other.itemUPCCode))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (productOf == null) {
			if (other.productOf != null)
				return false;
		} else if (!productOf.equals(other.productOf))
			return false;
		if (shippedBy == null) {
			if (other.shippedBy != null)
				return false;
		} else if (!shippedBy.equals(other.shippedBy))
			return false;
		return true;
	}
	
	
}
