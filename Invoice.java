/**
 * Class of Invoice
 *
 * @author Haidar Hanif
 * @version 1-04-2020
 */
public abstract class Invoice
{
    // instance variables - replace the example below with your own
    private int id;
    private Job job;
    private String date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor untuk Invoice
     */
    public Invoice(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        this.id = id;
        this.job = job;
        this.date = date;
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
    }
        
    /**
     * getter untuk mengambil id
     *
     * @return    id dari invoice
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * getter untuk mengambil idJob
     *
     * @return    idJob pada invoice
     */
    public Job getJob()
    {
        return job;
    }
    
        /**
     * getter untuk mengambil tanggal
     *
     * @return    tanggal dari invoice (date)
     */
    public String getDate()
    {
        return date;
    }
    
        /**
     * getter untuk mengambil total fee
     *
     * @return    total fee pada invoice
     */
    public int getTotalFee()
    {
        return totalFee;
    }
    
            /**
     * getter untuk mengambil data Jobseeker
     *
     * @return    Jobseeker pada invoice
     */
    public Jobseeker getJobseeker()
    {
        return jobseeker;
    }
    
            /**
     * abstract getPaymentType untuk mengambil data tipe payment
     *
     */
    public abstract PaymentType getPaymentType();
    
            /**
     * getter untuk mengambil data status invoice
     *
     * @return    Status pada invoice
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }
    
        /**
     * setter untuk mengatur nilai id
     *
     * @param  id  parameter untuk mengganti id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
            /**
     * setter untuk mengatur nilai job
     *
     * @param  job  parameter untuk mengganti job
     */
    public void setJob(Job job)
    {
        this.job = job;
    }
    
            /**
     * setter untuk mengatur tanggal
     *
     * @param  date  parameter untuk mengganti tanggal
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    
            /**
     * setter untuk mengatur total fee
     *
     * @param  totalFee  parameter untuk mengganti total fee
     */
    public abstract void setTotalFee();
    
            /**
     * setter untuk mengatur data jobseeker
     *
     * @param  jobseeker  parameter untuk mengganti jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker)
    {
        this.jobseeker = jobseeker;
    }
    
            /**
     * setter untuk mengatur data paymentType
     *
     * @param  paymentType  parameter untuk mengganti paymentType
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }
    
        /**
     * metode untuk mencetak data
     */
    public abstract void printData();
        //System.out.println("===================== INVOICE =====================");
        //System.out.println("ID: " + id);
        //System.out.println("ID Job: " + idJob);
        //System.out.println("Date: " + date);
        //System.out.println("Seeker: " + jobseeker.getName());
        //System.out.println("Fee: " + totalFee);
        //System.out.println("Status: " + status.toString());
}
