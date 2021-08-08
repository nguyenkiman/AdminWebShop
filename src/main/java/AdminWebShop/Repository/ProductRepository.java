package AdminWebShop.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Category;
import AdminWebShop.Models.Product;

@Transactional
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
//	List<Product> findByNameLike(String name);
}
