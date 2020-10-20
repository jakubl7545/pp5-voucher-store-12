package pl.jkanclerz.voucherstore.productcatalog;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest {

    public static final String MY_PRODUCT_DESC = "my fancy product";
    public static final String MY_PRODUCT_PICTURE = "http://my_image.pl/image.jpeg";

    @Test
    public void itAllowCreateProduct() {
        //A
        ProductCatalogFacade  productCatalog  = thereIsProductCatalog();
        //A
        String productId = productCatalog.createProduct();
        //A
        Assert.assertTrue((productCatalog.getById(productId)).getId().equals(productId));
        Assert.assertTrue(productCatalog.isExistsById(productId));
    }

    @Test
    public void itAllowSetProductDescription() {
        ProductCatalogFacade  productCatalog  = thereIsProductCatalog();
        String productId = productCatalog.createProduct();

        productCatalog.updateDetails(productId, MY_PRODUCT_DESC, MY_PRODUCT_PICTURE);
        Product loadedProduct = productCatalog.getById(productId);

        Assert.assertEquals(MY_PRODUCT_DESC, loadedProduct.getDescription());
        Assert.assertEquals(MY_PRODUCT_PICTURE, loadedProduct.getPicture());
    }

    @Test
    public void itAllowApplyPrice() {
        ProductCatalogFacade  productCatalog  = thereIsProductCatalog();
        String productId = productCatalog.createProduct();

        productCatalog.applyPrice(productId, BigDecimal.valueOf(20.20));
        Product loadedProduct = productCatalog.getById(productId);

        Assert.assertTrue(BigDecimal.valueOf(20.20).equals(loadedProduct.getPrice()));
    }

    @Test
    public void itAllowsLoadAllProducts() {
        ProductCatalogFacade  productCatalog  = thereIsProductCatalog();
        String draftProductId = productCatalog.createProduct();
        String productId = productCatalog.createProduct();

        productCatalog.applyPrice(productId, BigDecimal.valueOf(20.20));
        productCatalog.updateDetails(productId, MY_PRODUCT_DESC, MY_PRODUCT_PICTURE);

        List<Product> all = productCatalog.getAvailableProducts();
        Assert.assertEquals(1, all.size());
    }

    private static ProductCatalogFacade thereIsProductCatalog() {
        return new ProductCatalogConfiguration().productCatalogFacade();
    }
}
