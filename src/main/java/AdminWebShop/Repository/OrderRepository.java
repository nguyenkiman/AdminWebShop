package AdminWebShop.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Order;

@Transactional
@Repository
public interface OrderRepository {

	public List<Order> findAll();
	
	public Order findById(int id);
	
	public void save(Order order);
	
	public void deleteById(int id);
}
