import java.text.SimpleDateFormat;

/**
 * subclass EwalletPayment
 *
 * @author Haidar Hanif
 * @version 10-04-2021
 */
public class EwalletPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    /**
     * Constructor for objects of class EwallletPayment
     */
    public EwalletPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, jobseeker, invoiceStatus);
    }
    
        /**
     * Constructor for objects of class EwallletPayment
     */
    public EwalletPayment(int id, Job job, Jobseeker jobseeker, Bonus bonus, InvoiceStatus invoiceStatus)
    {
        super(id, job, jobseeker, invoiceStatus);
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
            totalFee = getJob().getFee() + bonus.getExtraFee();
        }
        else {
            totalFee = getJob().getFee();
        }
    }
    
            /**
     * metode untuk mencetak data
     */
    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String text = "===================== INVOICE =====================" +
                "\nID: " + getId() +
                "\nJob: " + getJob().getName() +
                "\nDate: " + dateFormat.format(getDate().getTime()) +
                "\nJob Seeker: " + getJobseeker().getName();
                
        if (bonus!=null && bonus.getActive() && totalFee >= bonus.getMinTotalFee()) {
            text += "\nReferral Code: " + bonus.getReferralCode();
        }
        
        text += "\nFee: " + totalFee +
                "\nStatus: " + getInvoiceStatus().toString() +
                "\nPayment Type: " + PAYMENT_TYPE.toString();
        
        return text;
    }
}
