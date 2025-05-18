package Internal;

import external.RazorPayAPI;
import external.RazorPayStatus;

public class RazorPayAdaptor implements PaymentProvider {

    private RazorPayAPI razorPayAPI = new RazorPayAPI();

    @Override
    public String createPayment(Long id, String name, String email, Double amount) {
        razorPayAPI.makePayment(id, amount);
        return name;
    }

    @Override
    public PaymentStatus verifyStatus(Long Id) {
        RazorPayStatus status = razorPayAPI.getStatus(Id);
        return to(status);
    }

    private PaymentStatus to(RazorPayStatus status) {
        switch (status) {
            case SUCCESS:
                return PaymentStatus.DONE;
            case FAILURE:
                return PaymentStatus.FAILED;

        }
        throw new IllegalArgumentException("Invalid status " + status);
    }

}
