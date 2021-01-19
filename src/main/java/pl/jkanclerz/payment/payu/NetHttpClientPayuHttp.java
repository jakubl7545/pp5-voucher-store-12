package pl.jkanclerz.payment.payu;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

public class NetHttpClientPayuHttp {
    private final HttpClient http;

    public NetHttpClientPayuHttp() {
        this.http = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(20))
            .build();
    }


    public HttpResponse<String> post(String url, String body, Map<String, String> headers) throws PayUException {
        var httpRequestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(body));
        headers.forEach(httpRequestBuilder::header);

        try {
            HttpResponse<String> r = http.send(httpRequestBuilder.build(), HttpResponse.BodyHandlers.ofString());
            return r;
        } catch (Exception e) {
           throw new PayUException(e);
        }
    }
}
