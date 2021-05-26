package AdminWebShop.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AdminWebShop.Constraint.CustomerContraints;
import AdminWebShop.Models.Customer;
import AdminWebShop.Repository.CustomerRepository;
import AdminWebShop.Service.CustomerServices;

@Service
public class CustomerServicesImp implements CustomerServices{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
	}

	@Override
	public void insert(Customer customer) {
		// TODO Auto-generated method stub
		customer.setStatus(CustomerContraints.ACTIVE_CUSTOMER);
		customerRepository.save(customer);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}

}
