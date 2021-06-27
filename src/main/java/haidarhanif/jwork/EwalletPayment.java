package haidarhanif.jwork;
import haidarhanif.jwork.enumerated.PaymentType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * subclass EwalletPayment
 *
 * @author Haidar Hanif
 * @version 21-04-2021
 */
public class EwalletPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    /**
     * Constructor for objects of class EwallletPayment
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    
        /**
     * Constructor for objects of class EwallletPayment
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus)
    {
        super(id, jobs, jobseeker);
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
        int sumFee = 0;
        for(Job job: getJobs())
        {
            sumFee += job.getFee();
        }
        if(bonus != null && bonus.getActive() && sumFee >= bonus.getMinTotalFee())
        {
            totalFee = sumFee + bonus.getExtraFee();
        }
        else
        {
            totalFee = sumFee;
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
                "\nJob: ";

        for(Job job: getJobs())
        {
            text += job.getName() + ", ";
        }

        text+= "\nDate: " + dateFormat.format(getDate().getTime()) +
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
