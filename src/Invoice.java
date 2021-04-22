import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class of Invoice
 *
 * @author Haidar Hanif
 * @version 22-04-2021
 */
abstract class Invoice
{
    // instance variables - replace the example below with your own
    private int id;
    private ArrayList<Job> jobs;
    private Calendar date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor untuk Invoice
     */
    public Invoice(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        this.id = id;
        this.jobs = jobs;
        this.date = Calendar.getInstance();
        this.jobseeker = jobseeker;
        this.invoiceStatus = InvoiceStatus.OnGoing;
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
    public ArrayList<Job> getJobs()
    {
        return jobs;
    }
    
        /**
     * getter untuk mengambil tanggal
     *
     * @return    tanggal dari invoice (date)
     */
    public Calendar getDate()
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
     * @param  jobs  parameter untuk mengganti job
     */
    public void setJobs(ArrayList<Job> jobs)
    {
        this.jobs = jobs;
    }
    
            /**
     * setter untuk mengatur tanggal
     *
     * @param  date  parameter untuk mengganti tanggal
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }
    
                /**
     * setter untuk mengatur tanggal
     *
     * @param  year  parameter untuk mengganti tahun
     * @param  month  parameter untuk mengganti tahun
     * @param  dayOfMonth  parameter untuk mengganti tahun
     */
    public void setDate(int year, int month, int dayOfMonth)
    {
        date = new GregorianCalendar(year, month, dayOfMonth);
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
     * setter untuk mengatur data invoiceStatus
     *
     * @param  invoiceStatus  parameter untuk mengganti invoiceStatus
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }
    
        /**
     * metode untuk mencetak data
     */
    public abstract String toString();
        //System.out.println("===================== INVOICE =====================");
        //System.out.println("ID: " + id);
        //System.out.println("ID Job: " + idJob);
        //System.out.println("Date: " + date);
        //System.out.println("Seeker: " + jobseeker.getName());
        //System.out.println("Fee: " + totalFee);
        //System.out.println("Status: " + status.toString());
}
