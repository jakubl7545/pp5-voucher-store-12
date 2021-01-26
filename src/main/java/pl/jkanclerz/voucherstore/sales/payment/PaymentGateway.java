package pl.jkanclerz.voucherstore.sales.payment;

import pl.jkanclerz.voucherstore.sales.ordering.Reservation;

public interface PaymentGateway {
    PaymentDetails registerFor(Reservation reservation);

    boolean isTrusted(PaymentUpdateStatusRequest updateStatusRequest);
}
