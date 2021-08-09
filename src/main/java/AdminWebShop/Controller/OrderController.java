package AdminWebShop.Controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import AdminWebShop.Models.Customer;
import AdminWebShop.Models.Order;
import AdminWebShop.Repository.CustomerRepository;
import AdminWebShop.Repository.OrderRepository;

@Controller
@RequestMapping("/Order")
public class OrderController {
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private CustomerRepository custrepository;
	
	@GetMapping("")
	public String listAll(ModelMap modelMap,@RequestParam(defaultValue = "",name = "searchString") String searchString) {
		List<Order> list;
//		if(searchString.equals("")) {
//			
			list = (List<Order>) repository.findAll();
//		}else {
//			list = productServices.findByNameLike(searchString);
//		}
		
		modelMap.addAttribute("searchString",searchString);
		modelMap.addAttribute("listOrder", list);
		return "Order/index";
	}
	@GetMapping("/Create")
	public String getCreatePage(ModelMap modelMap) {
		Order order = new Order();
		
		modelMap.addAttribute("customers",custrepository.findAll());
		modelMap.addAttribute("order", order);
		return "Order/Create";
	}
	@PostMapping("/Create")
	public String create(Order order,@RequestParam int custid)  {
		
		order.setStatus(1);
		order.setCustomer(custrepository.findById(custid).get());
		order.setOrderdate(Date.valueOf(java.time.LocalDate.now()));
		repository.save(order);
		return "redirect:/Order";
	}
	@GetMapping("/Edit/{id}")
	public String edit(ModelMap modelMap,@PathVariable(name="id") Integer id) {
		
		try {
			Optional<Order> order = repository.findById(id);
			if(order.isEmpty()) {
				return "404error";
			}
			modelMap.addAttribute("order", order);
		}catch (Exception e) {
			// TODO: handle exception
			return "404error";
		}
		return "Order/Edit";
	}
	@PostMapping("/Edit")
	public String edit(ModelMap modelMap,Order order) throws IOException {
		
		
		order.setStatus(1);
		repository.save(order);
		
		return "redirect:/Order";
	}
	
}
