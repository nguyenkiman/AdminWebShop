package AdminWebShop.Controller;

import java.util.Iterator;
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

import AdminWebShop.Models.Category;
import AdminWebShop.Models.Order;
import AdminWebShop.Models.Product;
import AdminWebShop.Repository.CategoryRepository;
import AdminWebShop.Service.CategoryServices;

@Controller
@Transactional 
@RequestMapping("/Category")
public class CategoryController {
	
	@Autowired
	private CategoryServices services;
	
	
	@GetMapping("")
	public String listAll(ModelMap modelMap) {
		List<Category> list = services.findAll();
		modelMap.addAttribute("listCategories", list);
		return "Category/index";
	}
	@GetMapping("/Edit/{id}")
	public String edit(ModelMap modelMap,@PathVariable(name="id") Integer id) {
		
		try {
			Category category = services.findById(id);
			modelMap.addAttribute("category", category);
		}catch (Exception e) {
			// TODO: handle exception
			return "404error";
		}
		return "Category/edit";
	}
	@PostMapping("/Edit")
	public String edit(ModelMap modelMap,Category category) {
		System.out.println(category.getId());
		System.out.println(category.getName());
		services.update(category);
		modelMap.addAttribute("category", category);
		return "redirect:/Category";
	}
}
