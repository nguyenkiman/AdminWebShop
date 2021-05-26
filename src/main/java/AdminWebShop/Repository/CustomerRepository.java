package AdminWebShop.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Customer;

@Transactional
@Repository
public interface CustomerRepository {

	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	public void save(Customer customer);
	
	public void deleteById(int id);
}
