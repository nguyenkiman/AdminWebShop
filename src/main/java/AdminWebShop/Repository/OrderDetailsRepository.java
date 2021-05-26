package AdminWebShop.Repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import AdminWebShop.Models.OrderDetails;

@Transactional
@Repository
public interface OrderDetailsRepository {
	
	public void save(OrderDetails orderDetails);
	
	public void deleteById(int id);
}
