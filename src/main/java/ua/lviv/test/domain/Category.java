package ua.lviv.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer quantity;
	private Integer price;
	@Column(unique=true)
	private String categoryname;
	private boolean haveItems = true;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public void addItems(Integer items) {
		this.quantity += items;
	}
	public Category() {
	}
	public Category(Integer price, String categoryname) {
		super();
		this.price = price;
		this.quantity = 0;
		this.categoryname = categoryname;
	}
	public Category(String categoryname, Integer quantity) {
		super();
		this.quantity = quantity;
		this.categoryname = categoryname;
	}
	public Category(String categoryname, Integer price, Integer quantity) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.categoryname = categoryname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryname == null) ? 0 : categoryname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Category other = (Category) obj;
		if (categoryname != other.categoryname)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", quantity=" + quantity + ", categoryName=" + categoryname + ", price=" + price + "]";
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public boolean getHaveItems() {
		return haveItems;
	}
	public void setHaveItems(boolean haveItems) {
		this.haveItems = haveItems;
	}
}
