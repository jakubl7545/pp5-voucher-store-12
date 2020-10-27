package pl.jkanclerz.voucherstore.productcatalog;

import java.util.List;
import java.util.Optional;

public interface ProductsStorage {
    List<Product> allPublished();

    Optional<Product> getById(String productId);

    void save(Product newProduct);
}
