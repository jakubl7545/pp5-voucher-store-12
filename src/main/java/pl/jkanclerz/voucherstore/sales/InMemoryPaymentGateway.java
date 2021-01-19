package pl.jkanclerz.voucherstore.sales;

import pl.jkanclerz.voucherstore.sales.ordering.Reservation;

public class InMemoryPaymentGateway implements PaymentGateway {
    @Override
    public PaymentDetails registerFor(Reservation reservation) {
        return null;
    }
}
