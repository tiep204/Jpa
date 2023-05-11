package ra.model.serviceImp;

import org.springframework.stereotype.Service;
import ra.model.entity.Product;
import ra.model.repository.ProductRepository;
import ra.model.sercive.ProductService;

import java.util.List;

@Service

public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveOfUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProductt(id);
    }

    @Override
    public List<Product> searchProductByName(String productName) {
        return productRepository.searchProductByName(productName);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findByProductId(id);
    }

    @Override
    public Product findByProductName(String name) {
        return productRepository.findByProductName(name);
    }

    @Override
    public void addProduct( String productName, float price, boolean status) {
       productRepository.addProduct(productName,price,status);


    }

    @Override
    public void updateProduct(int productId, String productName, float price, boolean status) {
        productRepository.updateProduct(productId,productName,price,status);
    }

/*    @Override
    public Slice<Product> findByProductName(Pageable pageable) {
        return productRepository.findByProductName(pageable);
    }*/
}
