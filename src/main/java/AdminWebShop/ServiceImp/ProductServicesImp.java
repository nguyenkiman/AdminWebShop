package AdminWebShop.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AdminWebShop.Constraint.ProductContraints;
import AdminWebShop.Models.Product;
import AdminWebShop.Repository.ProductRepository;
import AdminWebShop.Service.ProductServices;

@Service
public class ProductServicesImp implements ProductServices{

	
	@Autowired
	private ProductRepository repository;
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Product> findAllActive() {
		// TODO Auto-generated method stub
		return repository.findAllActive();
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		product.setStatus(ProductContraints.ACTIVE_PRODUCT);
		repository.save(product);
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		repository.save(product);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	

}
