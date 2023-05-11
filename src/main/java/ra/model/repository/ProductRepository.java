package ra.model.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.entity.Product;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByProductId(int id);

    Product findByProductName(String name);


    @Modifying
    @Query(value = "insert INTO  Product(product_name,price,status) value(:productName,:price,:status)", nativeQuery = true)
    @Transactional
    void addProduct( @Param("productName") String productName, @Param("price") float price, @Param("status") boolean status);

    @Modifying
    @Query(value = "update Product p set p.productName= :productName," +
            "p.price= :price,p.status = :status WHERE p.productId = :productId")
    @Transactional
    void updateProduct(@Param("productId") int productId,@Param("productName") String productName,
                       @Param("price") float price,@Param("status") boolean status);

    @Modifying
    @Query(value = "delete from Product p where p.productId = :productId")
    @Transactional
    void deleteProductt(@Param("productId") int productId);

    @Query("select p FROM  Product p where p.productName like %:productName%")
    List<Product> searchProductByName (@Param("productName") String productName);


}
