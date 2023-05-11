package ra.model.sercive;

import org.springframework.data.repository.query.Param;
import ra.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product saveOfUpdate(Product product);


    Product findById(int id);

    Product findByProductName(String name);

    /*
        Slice<Product> findByProductName(Pageable pageable);
    */
    void addProduct(@Param("productName") String productName, @Param("price") float price, @Param("status") boolean status);

    void updateProduct(@Param("productId") int productId, @Param("productName") String productName, @Param("price") float price, @Param("status") boolean status);

    void deleteProduct(@Param("productId") int productId);

    List<Product> searchProductByName (@Param("productName") String productName);


}
