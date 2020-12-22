package pl.jkanclerz.voucherstore.sales;

import org.junit.Before;
import org.junit.Test;
import pl.jkanclerz.voucherstore.sales.offer.Offer;

public class OrderingTest extends SalesTestCase {

    @Before
    public void setUp() {
        productCatalog = thereIsProductCatalog();
        basketStorage = thereIsBasketStore();
        alwaysExistsInventory = thereIsInventory();
        currentCustomerContext = thereIsCurrentCustomerContext();

    }

    @Test
    public void itCreateOrderBasedOnCurrentOffer() {
        //Arrange
        SalesFacade sales = thereIsSalesModule();
        String productId1 = thereIsProductAvailable();
        String productId2 = thereIsProductAvailable();
        customerId = thereIsCustomerWhoIsDoingSomeShopping();

        //Act
        sales.addToBasket(productId1);
        sales.addToBasket(productId2);
        Offer seenOffer = sales.getCurrentOffer();
        String reservationId = sales.acceptOffer(seenOffer);

        thereIsPendingOrderWithId(reservationId);
    }

    private void thereIsPendingOrderWithId(String reservationId) {

    }
}
