package AdminWebShop.Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
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
import AdminWebShop.Models.Product;
import AdminWebShop.Repository.ProductRepository;
import AdminWebShop.Service.CategoryServices;

@Controller
@Transactional 
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	private ProductRepository productServices;
	
	@Autowired
	private CategoryServices categoryServices;
	
	private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
	
	@GetMapping("")
	public String listAll(ModelMap modelMap,@RequestParam(defaultValue = "",name = "searchString") String searchString) {
		List<Product> list;
//		if(searchString.equals("")) {
//			
			list = (List<Product>) productServices.findAll();
//		}else {
//			list = productServices.findByNameLike(searchString);
//		}
		
		modelMap.addAttribute("searchString",searchString);
		modelMap.addAttribute("listProducts", list);
		return "Product/index";
	}
	@GetMapping("/Create")
	public String getCreatePage(ModelMap modelMap) {
		Product product = new Product();
		List<Category> categories;
		categories = categoryServices.findAll();
		modelMap.addAttribute("product", product);
		modelMap.addAttribute("categories", categories);
		return "Product/Create";
	}
	@PostMapping("/Create")
	public String create(Product product,@RequestParam int categoryid,@RequestParam MultipartFile image) throws IOException {
		
		Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(image.getBytes());
        }
		product.setCategory(categoryServices.findById(categoryid));
        product.setUrlimage(imagePath.resolve(image.getOriginalFilename()).toString());
		productServices.save(product);
		return "redirect:/Product";
	}
	@GetMapping("/Edit/{id}")
	public String edit(ModelMap modelMap,@PathVariable(name="id") Integer id) {
		
		try {
			Optional<Product> product = productServices.findById(id);
			if(product.isEmpty()) {
				return "404error";
			}
			modelMap.addAttribute("product", product);
			List<Category> categories = categoryServices.findAll();
			modelMap.addAttribute("product", product);
			modelMap.addAttribute("categories", categories);
		}catch (Exception e) {
			// TODO: handle exception
			return "404error";
		}
		return "Product/edit";
	}
	@PostMapping("/Edit")
	public String edit(ModelMap modelMap,Product product,@RequestParam int categoryid,@RequestParam MultipartFile image) throws IOException {
		
		Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(image.getBytes());
        }
		product.setCategory(categoryServices.findById(categoryid));
        product.setUrlimage(imagePath.resolve(image.getOriginalFilename()).toString());
        
        
		productServices.save(product);
		
		return "redirect:/Product";
	}
	@GetMapping("Enable/{id}")
	public String Enable(@PathVariable(name="id") Integer id) {
		
		Optional<Product> product = productServices.findById(id);
		product.get().setStatus(true);
		productServices.save(product.get());
		return "redirect:/Product";
	}
	@GetMapping("Disable/{id}")
	public String Disable(@PathVariable(name="id") Integer id) {
		Optional<Product> product = productServices.findById(id);
		product.get().setStatus(false);
		
		productServices.save(product.get());
		return "redirect:/Product";
	}
}
