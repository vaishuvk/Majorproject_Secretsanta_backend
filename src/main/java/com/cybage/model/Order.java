package com.cybage.model;

import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="orders", uniqueConstraints = {
@UniqueConstraint(columnNames = "oid"),
@UniqueConstraint(columnNames = "giftname")})
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long oid;
	private Long uid;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	private User users;
	private String giftname;
	private String description;
	@Enumerated(EnumType.STRING)
	private Category category;
	private double price;
	private String image;
	private int quantity;
	private int discountoffer;
	private double offerprice;
	/*@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "orders")
	List<Products> products;*/
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long oid, Long uid, User users, String giftname, String description, Category category, double price,
			String image, int quantity, int discountoffer, double offerprice/*, List<Products> products*/) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.users = users;
		this.giftname = giftname;
		this.description = description;
		this.category = category;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.discountoffer = discountoffer;
		this.offerprice = offerprice;
		/*this.products = products;*/
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
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

	public int getDiscountoffer() {
		return discountoffer;
	}

	public void setDiscountoffer(int discountoffer) {
		this.discountoffer = discountoffer;
	}

	public double getOfferprice() {
		return offerprice;
	}

	public void setOfferprice(double offerprice) {
		this.offerprice = offerprice;
	}

/*	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}*/

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", users=" + users + ", giftname=" + giftname + ", description="
				+ description + ", category=" + category + ", price=" + price + ", image=" + image + ", quantity="
				+ quantity + ", discountoffer=" + discountoffer + ", offerprice=" + offerprice + /*", products="
				+ products +*/ "]";
	}
	
	
}
