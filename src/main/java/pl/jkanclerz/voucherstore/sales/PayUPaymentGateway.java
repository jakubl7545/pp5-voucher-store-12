package pl.jkanclerz.voucherstore.sales;

import pl.jkanclerz.payment.payu.PayU;
import pl.jkanclerz.voucherstore.sales.ordering.Reservation;

public class PayUPaymentGateway implements PaymentGateway {
    private final PayU payU;

    public PayUPaymentGateway(PayU payU) {
        this.payU = payU;
    }

    @Override
    public PaymentDetails registerFor(Reservation reservation) {
        return null;
    }

    @Override
    public boolean isTrusted(PaymentUpdateStatusRequest updateStatusRequest) {
        return payU.isTrusted(updateStatusRequest.getBody(), updateStatusRequest.getSignature());
    }
}
