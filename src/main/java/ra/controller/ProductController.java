package ra.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Product;
import ra.model.sercive.ProductService;

import java.util.List;


@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable int id){
       return productService.findById(id);

    }
    @GetMapping("/name")
    public Product findById(@RequestParam String name){
        return productService.findByProductName(name);

    }
    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }
    @PostMapping
    public void createProduct(@RequestBody Product product){
         productService.addProduct(product.getProductName(), product.getPrice(), product.getStatus());
    }
    @PutMapping("/")
    public void update(@RequestBody Product product){
        productService.updateProduct(product.getProductId(), product.getProductName(), product.getPrice(), product.getStatus());
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
    @GetMapping("/search")
    public List<Product> searchByName(@RequestParam String name){
      return   productService.searchProductByName(name);
    }

}
