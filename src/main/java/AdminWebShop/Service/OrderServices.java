package AdminWebShop.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import AdminWebShop.Models.Order;

@Service
public interface OrderServices {
	public List<Order> findAll();

	public Order findById(int id);

	public void insert(Order order);
	
	public void update(Order order);

	public void deleteById(int id);
}
