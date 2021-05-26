package AdminWebShop.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AdminWebShop.Constraint.OrderConstraint;
import AdminWebShop.Models.Order;
import AdminWebShop.Repository.OrderRepository;
import AdminWebShop.Service.OrderServices;

@Service
public class OrderServicesImp implements OrderServices{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order findById(int id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id);
	}

	@Override
	public void insert(Order order) {
		// TODO Auto-generated method stub
		order.setStatus(OrderConstraint.ORDERED_ORDER);
		orderRepository.save(order);
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		orderRepository.save(order);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(id);
	}

}
