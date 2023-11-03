package study.paymentintegrationserver.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import study.paymentintegrationserver.domain.TossPayments;
import study.paymentintegrationserver.dto.order.OrderConfirmRequest;
import study.paymentintegrationserver.util.EncodeUtils;
import study.paymentintegrationserver.util.HttpUtils;

@Service
public class PaymentService {

    @Value("${spring.myapp.toss-payments.secret-key}")
    private String secretKey;
    @Value("${spring.myapp.toss-payments.api-url}")
    private String tossApiUrl;

    public TossPayments confirmPayment(@RequestBody OrderConfirmRequest orderConfirmRequest) {
        return HttpUtils.requestPostWithBasicAuthorization(
                tossApiUrl + "/confirm",
                EncodeUtils.encodeBase64(secretKey + ":"),
                orderConfirmRequest,
                TossPayments.class);
    }
}