package AdminWebShop.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import AdminWebShop.Models.Product;

@Service
public interface ProductServices {


	public List<Product> findAll();
	
	public List<Product> findAllActive();
	
	public Product findById(int id);
	
	public void insert(Product product);
	
	public void update(Product product);
	
	public void deleteById(int id);
}
