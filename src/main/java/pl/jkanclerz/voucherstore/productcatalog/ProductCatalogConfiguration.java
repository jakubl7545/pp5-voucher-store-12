package pl.jkanclerz.voucherstore.productcatalog;

public class ProductCatalogConfiguration {
    public ProductCatalogFacade productCatalogFacade() {
        return new ProductCatalogFacade();
    }
}
