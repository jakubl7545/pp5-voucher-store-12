package pl.jkanclerz.voucherstore.sales.payment;

import pl.jkanclerz.payment.payu.exceptions.PayUException;

public class PaymentException extends IllegalStateException {
    public PaymentException(PayUException e) {
        super(e);
    }
}
