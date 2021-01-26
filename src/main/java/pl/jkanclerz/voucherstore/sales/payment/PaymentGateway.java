package pl.jkanclerz.voucherstore.sales.payment;

import pl.jkanclerz.payment.payu.exceptions.PayUException;
import pl.jkanclerz.voucherstore.sales.ordering.Reservation;

public interface PaymentGateway {
    PaymentDetails registerFor(Reservation reservation) throws PayUException;

    boolean isTrusted(PaymentUpdateStatusRequest updateStatusRequest);
}
