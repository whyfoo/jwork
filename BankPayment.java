
/**
 * subclass BankPayment dari invoice
 *
 * @author Haidar Hanif
 * @version 10-04-2021
 */
public class BankPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;
    
    /**
     * Constructor for objects of class EwallletPayment
     */
    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, jobseeker, invoiceStatus);
    }
    
        /**
     * Constructor for objects of class EwallletPayment
     */
    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus, int adminFee)
    {
        super(id, job, jobseeker, invoiceStatus);
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
            totalFee = getJob().getFee() - adminFee;
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
        return "===================== INVOICE =====================" +
        "\nID: " + getId() +
        "\nJob: " + getJob().getName() +
        "\nDate: " + getDate().getTime() +
        "\nJob Seeker: " + getJobseeker().getName() +
        "\nAdmin Fee: " + adminFee +       
        "\nFee: " + totalFee +
        "\nStatus: " + getInvoiceStatus().toString() +
        "\nPayment Type: " + PAYMENT_TYPE.toString();
    }
}
