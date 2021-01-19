package pl.jkanclerz.voucherstore.sales;

import pl.jkanclerz.voucherstore.sales.ordering.Reservation;

public class PayUPaymentGateway implements PaymentGateway {
    @Override
    public PaymentDetails registerFor(Reservation reservation) {
        return null;
    }
}
