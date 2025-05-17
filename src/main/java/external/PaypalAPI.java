package external;

public class PaypalAPI {

    public void pay(Long id, String name, String email, Double amount) {
        System.out.println("PaypalAPI.pay");
    }

    public PaypalStatus checkStatus(Long id){
        return PaypalStatus.OK;
    }
}
