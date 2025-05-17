package external;


//incompatible interfaces also called as SDKs
public class RazorPayAPI {
    public void makePayment(Long id, Double amount) {
        System.out.println("RazorPayAPI.pay");
    }

    public RazorPayStatus getStatus(Long id){
        return RazorPayStatus.SUCCESS;
    }
}
