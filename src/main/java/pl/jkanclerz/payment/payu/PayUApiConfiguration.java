package pl.jkanclerz.payment.payu;

import lombok.Getter;

@Getter
public class PayUApiConfiguration {
    private final String posId;
    private final String secondKey;
    private final String clientId;
    private final String clientSecret;
    private final String baseUrl;

    public PayUApiConfiguration(String posId, String secondKey, String clientId, String clientSecret, String baseUrl) {
        this.posId = posId;
        this.secondKey = secondKey;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.baseUrl = baseUrl;
    }

    public static PayUApiConfiguration sandbox() {
        return new PayUApiConfiguration(
                "300746",
                "b6ca15b0d1020e8094d9b5f8d163db54",
                "300746",
                "2ee86a66e5d97e3fadc400c9f19b065d",
                "https://secure.snd.payu.com");
    }

    public static PayUApiConfiguration production(String posId, String secondKey, String clientId, String clientSecret) {
        return new PayUApiConfiguration(
                posId,
                secondKey,
                clientId,
                clientSecret,
                "https://secure.payu.com");
    }
}
