package pl.jkanclerz.voucherstore.sales;

import pl.jkanclerz.voucherstore.sales.ordering.Reservation;

public interface PaymentGateway {
    PaymentDetails registerFor(Reservation reservation);
}
