package AdminWebShop.Models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "proname",length = 100)
	private String proname;
	
	@Column(name = "urlimage",length = 255)
	private String urlimage;
	
	@Column(name = "unitprice")
	private double unitprice;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
	@Column(name = "status",nullable = false)
	private boolean status;

	
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	private Collection<OrderDetails> orderDetails;
	
	
	public Collection<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrders(Collection<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return proname;
	}

	public void setName(String name) {
		this.proname = name;
	}

	public String getUrlimage() {
		return urlimage;
	}

	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
