package haidarhanif.jwork;

import haidarhanif.jwork.enumerated.JobCategory;

/**
 * Class of Job
 *
 * @author Haidar Hanif
 * @version 25-03-2021
 */
public class Job
{
    private int id;
    private String name;
    private Recruiter recruiter;
    private int fee;
    private JobCategory category;
    
     /**
     * Constructor untuk Job
     */
    public Job(int id, String name, Recruiter recruiter, int fee, JobCategory category)
    {
        this.id = id;
        this.name = name;
        this.recruiter = recruiter;
        this.fee = fee;
        this.category = category;
    }
    
        /**
     * getter untuk mengambil id
     *
     * @return    id dari job
     */
    public int getId()
    {
        return id;
    }
    
            /**
     * getter untuk mengambil name
     *
     * @return    nama dari job
     */
    public String getName()
    {
        return name;
    }
    
            /**
     * getter untuk mengambil fee
     *
     * @return    id dari job
     */
    public int getFee()
    {
        return fee;
    }
    
                /**
     * getter untuk mengambil category
     *
     * @return    category dari job
     */
    public JobCategory getCategory()
    {
        return category;
    }
    
                /**
     * getter untuk mengambil data recruiter
     *
     * @return    data Recruiter dari job
     */
    public Recruiter getRecruiter()
    {
        return recruiter;
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
     * setter untuk mengatur nilai name
     *
     * @param  name  parameter untuk mengganti name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
                /**
     * setter untuk mengatur nilai recruiter
     *
     * @param  recruiter  parameter untuk mengganti data recruiter
     */
    public void setRecruiter(Recruiter recruiter)
    {
        this.recruiter = recruiter;
    }
    
                    /**
     * setter untuk mengatur nilai fee
     *
     * @param  fee  parameter untuk mengganti data fee
     */
    public void setFee(int fee)
    {
        this.fee = fee;
    }
    
                        /**
     * setter untuk mengatur nilai category
     *
     * @param  category  parameter untuk mengganti data category
     */
    public void setCategory(JobCategory category)
    {
        this.category = category;
    }
    
            /**
     * metode untuk mencetak data
     */
    public String toString(){
        return  "===================== Job =====================" +
                "\nId = " + id +
                "\nNama = " + name +
                "\nRecruiter = " + recruiter.getName() +
                "\nCity = " + getRecruiter().getLocation().getCity() +
                "\nFee = " + fee +
                "\nCategory = " + category.toString();
    }
}
