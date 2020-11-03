package pl.jkanclerz.voucherstore.productcatalog;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class JdbcProductStorage implements ProductsStorage {
    public JdbcProductStorage(JdbcTemplate jdbcTemplate) {

    }

    @Override
    public List<Product> allPublished() {
        return null;
    }

    @Override
    public Optional<Product> getById(String productId) {
        return Optional.empty();
    }

    @Override
    public void save(Product newProduct) {

    }
}
