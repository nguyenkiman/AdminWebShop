package AdminWebShop.Service;

import org.springframework.stereotype.Service;

import AdminWebShop.Models.OrderDetails;

@Service
public interface OrderDetailsServices {
	public void save(OrderDetails orderDetails);
	
	public void deleteById(int id);
}
