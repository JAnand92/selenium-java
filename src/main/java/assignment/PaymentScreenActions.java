package assignment;

import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentScreenActions {

    public static final Consumer<PaymentScreenPage>
            freeCoupon = (p) -> p.applyPromoCode("FREEUDEMY");
    public static final Consumer<PaymentScreenPage>
            discountedCoupon = (p) -> p.applyPromoCode("PARTIALUDEMY");
    public static final Consumer<PaymentScreenPage>
            validCC = (p) -> p.enterCC("41111111111111111", "2023", "123");
    public static final Consumer<PaymentScreenPage>
            invalidCC = (p) -> p.enterCC("41111111111111112", "2023", "123");
    public static final Consumer<PaymentScreenPage>
            buy = (p) -> p.buyProduct();

    // Validation
    public static final Consumer<PaymentScreenPage>
            successfulPurchase = (p) -> Assert.assertEquals(p.getStatus(), "PASS");
    public static final Consumer<PaymentScreenPage>
            unSuccessfulPurchase = (p) -> Assert.assertEquals(p.getStatus(), "FAIL");

}
