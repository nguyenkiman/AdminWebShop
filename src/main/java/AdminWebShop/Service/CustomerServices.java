package AdminWebShop.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import AdminWebShop.Models.Customer;


@Service
public interface CustomerServices {

	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	public void insert(Customer customer);
	
	public void update(Customer customer);
	
	public void deleteById(int id);
}
