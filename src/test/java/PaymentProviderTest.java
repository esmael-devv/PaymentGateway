


import Internal.PaymentProvider;
import Internal.PaymentStatus;
import Internal.RazorPayAdaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PaymentProviderTest {

    PaymentProvider paymentProvider = null;

    @BeforeEach
    public void setUp() {
        paymentProvider = new RazorPayAdaptor();
    }

    @Test
    public void testRazorPay() {
        assertTrue(paymentProvider instanceof RazorPayAdaptor, "If razor pay is used, then instance should be of RazorPay");
        String link = paymentProvider.createPayment(Long.valueOf(234095781),"smile", "smile@gmail",23.1);
        assertEquals("RazorPay", link);
    }

    @Test
    public void testPaymentStatus() {
        PaymentStatus status = paymentProvider.verifyStatus(Long.valueOf(234095781));
        assertEquals(PaymentStatus.DONE, status);
    }

}