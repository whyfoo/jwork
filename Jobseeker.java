
/**
 * Jobseeker adalah kelas yang berisi data jobseeker
 *
 * @author Haidar Hanif
 * @version 18-03-2021
 */
public class Jobseeker
{
    // variable instance
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;
    
    /**
     * Constructor untuk Jobseeker
     */
    public Jobseeker(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    /**
     * getter untuk mengambil id
     *
     * @return    id milik jobseeker
     */
    public int getId()
    {
        return id;
    }
    
        /**
     * getter untuk mengambil nama
     *
     * @return    nama milik jobseeker
     */
    public String getName()
    {
        return name;
    }
    
            /**
     * getter untuk mengambil email
     *
     * @return    email milik jobseeker
     */
    public String getEmail()
    {
        return email;
    }
    
            /**
     * getter untuk mengambil password
     *
     * @return    password milik jobseeker
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * getter untuk mengambil join date
     *
     * @return    join date dari jobseeker
     */
    public String getJoinDate()
    {
        return joinDate;
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
     * @param  name  parameter untuk mengganti nama
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
        /**
     * setter untuk mengatur nilai email
     *
     * @param  email  parameter untuk mengganti email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
        /**
     * setter untuk mengatur nilai password
     *
     * @param  password  parameter untuk mengganti password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
        /**
     * setter untuk mengatur nilai joinDate
     *
     * @param  joinDate parameter untuk mengganti join date
     */
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
     * metode untuk mencetak data
     */
    public void printData(){
        System.out.println(name);
    }
}
