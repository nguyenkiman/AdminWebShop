package AdminWebShop.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Product;

@Transactional
@Repository
public interface ProductRepository {

	public List<Product> findAll();
	
	public List<Product> findAllActive();
	
	public Product findById(int id);
	
	public void save(Product product);
	
	public void deleteById(int id);
}
