package application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.models.Product;
import application.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest Products")
@CrossOrigin(origins="*")
public class ProductResources {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/product")
	@ApiOperation(value="List Of Products")
	public List<Product> listProduct(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	@ApiOperation(value="List Of Products By Id")
	public Product productById(@PathVariable(value="id") long id){
		return productRepository.findById(id);
	}
	
	@PostMapping("/product")
	@ApiOperation(value="Save Products")
	public Product saveProduct(@RequestBody Product productSaved) {
		return productRepository.save(productSaved);
	}
	
	@DeleteMapping("/product")
	@ApiOperation(value="Remove Products")
	public void deleteProduct(@RequestBody Product productDelete) {
		productRepository.delete(productDelete);
	}
	
	@PutMapping("/product")
	@ApiOperation(value="Update Products")
	public Product updateProduct(@RequestBody Product productUpdate) {
		return productRepository.save(productUpdate);
	}
	

}
