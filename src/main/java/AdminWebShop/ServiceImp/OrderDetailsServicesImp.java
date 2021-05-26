package AdminWebShop.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AdminWebShop.Models.OrderDetails;
import AdminWebShop.Repository.OrderDetailsRepository;
import AdminWebShop.Service.OrderDetailsServices;

@Service
public class OrderDetailsServicesImp implements OrderDetailsServices{

	@Autowired
	private OrderDetailsRepository repository;
	
	@Override
	public void save(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		repository.save(orderDetails);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
