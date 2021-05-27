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
import org.springframework.web.bind.annotation.RequestParam;

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
	public String listAll(ModelMap modelMap,@RequestParam(defaultValue = "",name = "searchstring") String searchstring) {
		List<Category> list;
//		if(searchstring.equals("")) {
//			list = services.findByNameLike(searchstring);
//		}else {
			list = services.findAll();
//		}
		Category category = new Category();
		modelMap.addAttribute("searchstring",searchstring);
		modelMap.addAttribute("listCategories", list);
		modelMap.addAttribute("category", category);
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
		
		services.update(category);
		modelMap.addAttribute("category", category);
		return "redirect:/Category";
	}
	@GetMapping("Delete/{id}")
	public String delete(@PathVariable(name="id") Integer id) {
		services.deleteById(id);
		return "redirect:/Category";
	}
	@PostMapping("/Create")
	public String create(Category category) {
		services.insert(category);
		return "redirect:/Category";
	}
}
