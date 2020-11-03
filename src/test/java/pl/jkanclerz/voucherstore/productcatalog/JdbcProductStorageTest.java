package pl.jkanclerz.voucherstore.productcatalog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcProductStorageTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        jdbcTemplate.execute("DROP TABLE product_catalog__products IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE `product_catalog__products` (" +
                "`id` varchar(255) NOT NULL," +
                "`description` varchar(255)," +
                "`picture` varchar(150)," +
                "`price` DECIMAL(12,2)," +
                "PRIMARY KEY (id)" +
        ");");
    }

    @Test
    public void itAllowStoreProduct() {
        ProductsStorage jdbcStorage = thereIsJdbcproductStorage();
        Product newProduct = new Product(UUID.randomUUID());

        jdbcStorage.save(newProduct);

        assertThat(jdbcStorage.getById(newProduct.getId())).isNotEmpty();
    }

    @Test
    public void itAllowLoadAllPublishedProducts() {

    }

    private ProductsStorage thereIsJdbcproductStorage() {
        return new JdbcProductStorage(jdbcTemplate);
    }
}
