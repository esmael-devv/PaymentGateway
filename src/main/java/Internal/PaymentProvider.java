package Internal;

public interface PaymentProvider {

    String createPayment(Long id, String name, String email, Double amount);

     PaymentStatus verifyStatus(Long Id);
}
