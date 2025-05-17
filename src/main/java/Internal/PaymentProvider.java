package Internal;

public interface PaymentProvider {

    void createPayment(Long id, String name, String email, Double amount);

     PaymentStatus verifyStatus(Long Id);
}
