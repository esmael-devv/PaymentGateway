package Internal;

import external.PaypalAPI;
import external.PaypalStatus;

public class PaypalAdapter implements PaymentProvider{

    private PaypalAPI paypal = new PaypalAPI();
    @Override
    public void createPayment(Long id, String name, String email, Double amount) {
        paypal.pay(id, name, email, amount);
    }

    @Override
    public PaymentStatus verifyStatus(Long Id) {
        PaypalStatus status = paypal.checkStatus(Id);
        return to(status);

    }

    public PaymentStatus to(PaypalStatus status) {
        switch (status) {
            case OK: return PaymentStatus.DONE;
            case ERROR: return PaymentStatus.FAILED;
        }
        throw new IllegalArgumentException("Invalid status " +status );
    }

}
