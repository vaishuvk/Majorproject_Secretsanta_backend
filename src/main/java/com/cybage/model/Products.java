package com.cybage.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="products", uniqueConstraints = {
@UniqueConstraint(columnNames = "pid"),
@UniqueConstraint(columnNames = "giftname")})
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long pid;
	/*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
	private Order orders;*/
	private String giftname;
	private String description;
	@Enumerated(EnumType.STRING)
	private Category category;
	private double price;
	private String image;
	private int quantity;
	@Enumerated(EnumType.STRING)
	private GiftFor giftfor;
	@Enumerated(EnumType.STRING)
	private Occasions occasions;
/*	@Enumerated(EnumType.ORDINAL)*/
	private int offer;
	private double offerprice;
	private boolean visibility = true ;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(Long pid,/* Order orders,*/ String giftname, String description, Category category, double price,
			String image, int quantity, GiftFor giftfor, Occasions occasions, int offer, double offerprice,
			boolean visibility) {
		super();
		this.pid = pid;
		/*this.orders = orders;*/
		this.giftname = giftname;
		this.description = description;
		this.category = category;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.giftfor = giftfor;
		this.occasions = occasions;
		this.offer = offer;
		this.offerprice = offerprice;
		this.visibility = visibility;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
/*
	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}
*/
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
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

	public GiftFor getGiftfor() {
		return giftfor;
	}

	public void setGiftfor(GiftFor giftfor) {
		this.giftfor = giftfor;
	}

	public Occasions getOccasions() {
		return occasions;
	}

	public void setOccasions(Occasions occasions) {
		this.occasions = occasions;
	}

	public int getoffer() {
		return offer;
	}

	public void setoffer(int offer) {
		this.offer = offer;
	}

	public double getOfferprice() {
		return offerprice;
	}

	public void setOfferprice(double offerprice) {
		this.offerprice = offerprice;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	@Override
	public String toString() {
		return "Products [pid=" + pid + /*", orders=" + orders +*/ ", giftname=" + giftname + ", description=" + description
				+ ", category=" + category + ", price=" + price + ", image=" + image + ", quantity=" + quantity
				+ ", giftfor=" + giftfor + ", occasions=" + occasions + ", offer=" + offer
				+ ", offerprice=" + offerprice + ", visibility=" + visibility + "]";
	}
	
}
	