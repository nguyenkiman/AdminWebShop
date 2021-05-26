package AdminWebShop.Models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "custname",length = 100,nullable = false)
	private String custname;
	
	@Column(name = "account",length = 100,nullable = false)
	private String account;
	
	@Column(name = "passwords",length = 100,nullable = false)
	private String passwords;
	
	@Column(name = "address",length = 100,nullable = false)
	private String address;
	
	@Column(name = "tellno",length = 11,nullable = false)
	private String tellno;
	
	@Column(name = "email",length = 100,nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
	private Collection<Order> orders;
	
	@Column(name = "status",nullable = false)
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return custname;
	}

	public void setName(String name) {
		this.custname = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTellno() {
		return tellno;
	}

	public void setTellno(String tellno) {
		this.tellno = tellno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Order> getOrder() {
		return orders;
	}

	public void setOrder(Collection<Order> orders) {
		this.orders = orders;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
