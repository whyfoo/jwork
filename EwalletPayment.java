
/**
 * subclass EwalletPayment
 *
 * @author Haidar Hanif
 * @version 1-04-2020
 */
public class EwalletPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    /**
     * Constructor for objects of class EwallletPayment
     */
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
    }
    
        /**
     * Constructor for objects of class EwallletPayment
     */
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, Bonus bonus, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
        this.bonus = bonus;
    }

                /**
     * getter untuk mengambil tipe pembayaran paymentType
     *
     * @return    PaymentType (Ewallet)
     */
    @Override
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
                    /**
     * getter untuk mengambil data bonus
     *
     * @return    bonus nilai bonus
     */
    public Bonus getBonus()
    {
        return bonus;
    }
    
                /**
     * setter untuk mengatur nilai bonus
     *
     * @param  bonus  parameter untuk mengganti bonus
     */
    public void setBonus(Bonus bonus)
    {
        this.bonus = bonus;
    }
    
                    /**
     * setter untuk mengatur nilai total fee
     *
     */
    @Override
    public void setTotalFee()
    {
        if (bonus!=null && bonus.getActive() && getJob().getFee() > bonus.getMinTotalFee()) {
            super.totalFee = super.getJob().getFee() + bonus.getExtraFee();
        }
        else {
            super.totalFee = super.getJob().getFee();
        }
    }
    
            /**
     * metode untuk mencetak data
     */
    @Override
    public void printData(){           
        System.out.println("===================== INVOICE =====================");
        System.out.println("ID: " + getId());
        System.out.println("Job: " + getJob().getName());
        System.out.println("Date: " + getDate());
        System.out.println("Job Seeker: " + getJobseeker().getName());
        
        if (bonus!=null && bonus.getActive() && totalFee >= bonus.getMinTotalFee()) {
            System.out.println("Referral Code: " + bonus.getReferralCode());
        }
        
        System.out.println("Fee: " + super.totalFee);
        System.out.println("Status: " + getInvoiceStatus().toString());
        System.out.println("Payment Type: " + PAYMENT_TYPE);
    }
}
