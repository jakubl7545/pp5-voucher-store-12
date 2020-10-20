package pl.jkanclerz.voucherstore.productcatalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ProductCatalogConfiguration {

    public ProductCatalogFacade productCatalogFacade() {
        return new ProductCatalogFacade();
    }

    @Bean
    public ProductCatalogFacade fixturesAwareProductCatalogFacade() {
        ProductCatalogFacade catalogFacade = new ProductCatalogFacade();

        String pId1 = catalogFacade.createProduct();
        catalogFacade.applyPrice(pId1, BigDecimal.TEN);
        catalogFacade.updateDetails(pId1, "My Fancy Product 1","My Fancy Product Url");

        String pId2 = catalogFacade.createProduct();
        catalogFacade.applyPrice(pId2, BigDecimal.TEN);
        catalogFacade.updateDetails(pId2, "My Fancy Product 2","My Fancy Product Url");

        String pId3 = catalogFacade.createProduct();
        catalogFacade.applyPrice(pId3, BigDecimal.TEN);
        catalogFacade.updateDetails(pId3, "My Fancy Product 3","My Fancy Product Url");
        return catalogFacade;
    }
}
