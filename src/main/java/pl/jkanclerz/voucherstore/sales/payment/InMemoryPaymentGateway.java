package pl.jkanclerz.voucherstore.sales.payment;

import pl.jkanclerz.voucherstore.sales.ordering.Reservation;

public class InMemoryPaymentGateway implements PaymentGateway {
    @Override
    public PaymentDetails registerFor(Reservation reservation) {
        return null;
    }

    @Override
    public boolean isTrusted(PaymentUpdateStatusRequest updateStatusRequest) {
        return true;
    }
}
