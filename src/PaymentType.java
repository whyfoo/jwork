/**
 * Enumeration class JobCategory
 *
 * @author Haidar Hanif
 * @version 25-03-2021
 */
public enum PaymentType
{
    BankPayment("Bank Payment"),
    EwalletPayment("E-Wallet payment");
    
    private String payment;

    PaymentType(String payment) {
        this.payment = payment;
    }

    public String toString() {
        return payment;
    }
}