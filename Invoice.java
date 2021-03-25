/**
 * Class of Invoice
 *
 * @author Haidar Hanif
 * @version 25-03-2020
 */
public class Invoice
{
    // instance variables - replace the example below with your own
    private int id;
    private int idJob;
    private String date;
    private int totalFee;
    private Jobseeker jobseeker;

    /**
     * Constructor untuk Invoice
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker)
    {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
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
    public int getIdJob()
    {
        return idJob;
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
     * setter untuk mengatur nilai id
     *
     * @param  id  parameter untuk mengganti id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
            /**
     * setter untuk mengatur nilai idJob
     *
     * @param  idJob  parameter untuk mengganti idJob
     */
    public void setIdJob(int idJob)
    {
        this.idJob = idJob;
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
    public void setTotalFee(int totalFee)
    {
        this.totalFee = totalFee;
    }
    
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
     * metode untuk mencetak data
     */
    public void printData(){
        System.out.println(totalFee);
    }
}
