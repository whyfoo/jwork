package haidarhanif.jwork;
import haidarhanif.jwork.enumerated.PaymentType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * subclass BankPayment dari invoice
 *
 * @author Haidar Hanif
 * @version 21-04-2021
 */
public class BankPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;
    
    /**
     * Constructor for objects of class EwallletPayment
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    
        /**
     * Constructor for objects of class EwallletPayment
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, int adminFee)
    {
        super(id, jobs, jobseeker);
        this.adminFee = adminFee;
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
     * getter untuk mengambil data adminFee
     *
     * @return    adminFee nilai adminFee
     */
    public int getAdminFee()
    {
        return adminFee;
    }
    
                /**
     * setter untuk mengatur nilai adminFee
     *
     * @param  adminFee  parameter untuk mengganti adminFee
     */
    public void setAdminFee(int adminFee)
    {
        this.adminFee = adminFee;
    }
    
                    /**
     * setter untuk mengatur nilai total fee
     *
     */
    @Override
    public void setTotalFee()
    {
        if (adminFee != 0) {
            for(Job job: getJobs())
            {
                totalFee += job.getFee();
            }
            totalFee-= adminFee;
        }
        else {
            for(Job job: getJobs())
            {
                totalFee += job.getFee();
            }
        }
    }
    
            /**
     * metode untuk mencetak data
     */
    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String value = "===================== INVOICE =====================" +
        "\nID: " + getId() +
        "\nJob: ";
        for(Job job: getJobs())
        {
            value += job.getName() + ", ";
        }

        value +=
        "\nDate: " + dateFormat.format(getDate().getTime()) +
        "\nJob Seeker: " + getJobseeker().getName() +
        "\nAdmin Fee: " + adminFee +       
        "\nFee: " + totalFee +
        "\nStatus: " + getInvoiceStatus().toString() +
        "\nPayment Type: " + PAYMENT_TYPE.toString();

        return value;
    }
}
