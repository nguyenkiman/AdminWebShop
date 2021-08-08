package AdminWebShop.Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import AdminWebShop.Models.Category;
import AdminWebShop.Models.Customer;
import AdminWebShop.Models.Product;
import AdminWebShop.Repository.CustomerRepository;

@Controller
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("")
	public String listAll(ModelMap modelMap,@RequestParam(defaultValue = "",name = "searchString") String searchString) {
		List<Customer> list;
//		if(searchString.equals("")) {
//			
			list = (List<Customer>) repository.findAll();
//		}else {
//			list = productServices.findByNameLike(searchString);
//		}
		
		modelMap.addAttribute("searchString",searchString);
		modelMap.addAttribute("listCustomer", list);
		return "Customer/index";
	}
	@GetMapping("/Create")
	public String getCreatePage(ModelMap modelMap) {
		Customer customer = new Customer();
		modelMap.addAttribute("customer", customer);
		return "Customer/Create";
	}
	@PostMapping("/Create")
	public String create(Customer customer) throws IOException {
		
		customer.setStatus(true);
		repository.save(customer);
		return "redirect:/Customer";
	}
	@GetMapping("/Edit/{id}")
	public String edit(ModelMap modelMap,@PathVariable(name="id") Integer id) {
		
		try {
			Optional<Customer> customer = repository.findById(id);
			if(customer.isEmpty()) {
				return "404error";
			}
			modelMap.addAttribute("customer", customer);
		}catch (Exception e) {
			// TODO: handle exception
			return "404error";
		}
		return "Customer/Edit";
	}
	@PostMapping("/Edit")
	public String edit(ModelMap modelMap,Customer customer) throws IOException {
		
		
		customer.setStatus(true);
		repository.save(customer);
		
		return "redirect:/Customer";
	}
	@GetMapping("Enable/{id}")
	public String Enable(@PathVariable(name="id") Integer id) {
		
		Optional<Customer> customer = repository.findById(id);
		customer.get().setStatus(true);
		repository.save(customer.get());
		return "redirect:/Customer";
	}
	@GetMapping("Disable/{id}")
	public String Disable(@PathVariable(name="id") Integer id) {
		Optional<Customer> customer = repository.findById(id);
		customer.get().setStatus(false);
		repository.save(customer.get());
		return "redirect:/Customer";
	}
}
