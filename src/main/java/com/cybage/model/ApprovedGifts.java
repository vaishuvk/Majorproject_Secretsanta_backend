package com.cybage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="approvedgifts", uniqueConstraints = {
@UniqueConstraint(columnNames = "aid"),
@UniqueConstraint(columnNames = "giftname")})
public class ApprovedGifts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long aid;
	private String giftname;
	private String description;
	private String category;
	private double price;
	private String image;
	private int quantity;
	private String giftfor;
	private String occasions;
	private boolean approved;
	
	public ApprovedGifts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApprovedGifts(Long aid, String giftname, String description, String category, double price, String image,
			int quantity, String giftfor, String occasions, boolean approved) {
		super();
		this.aid = aid;
		this.giftname = giftname;
		this.description = description;
		this.category = category;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.giftfor = giftfor;
		this.occasions = occasions;
		this.approved = approved;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getGiftname() {
		return giftname;
	}

	public void setGiftname(String giftname) {
		this.giftname = giftname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getGiftfor() {
		return giftfor;
	}

	public void setGiftfor(String giftfor) {
		this.giftfor = giftfor;
	}

	public String getOccasions() {
		return occasions;
	}

	public void setOccasions(String occasions) {
		this.occasions = occasions;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "ApprovedGifts [aid=" + aid + ", giftname=" + giftname + ", description=" + description + ", category="
				+ category + ", price=" + price + ", image=" + image + ", quantity=" + quantity + ", giftfor=" + giftfor
				+ ", occasions=" + occasions + ", approved=" + approved + "]";
	}


	
}
