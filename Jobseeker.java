import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.*;
import java.text.SimpleDateFormat;

/**
 * Jobseeker adalah kelas yang berisi data jobseeker
 *
 * @author Haidar Hanif
 * @version 10-04-2021
 */
public class Jobseeker
{
    // variable instance
    private int id;
    private String name;
    private String email;
    private String password;
    private Calendar joinDate;
    
    /**
     * Constructor untuk Jobseeker
     */
    public Jobseeker(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
    }
    
    public Jobseeker(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    
    public Jobseeker(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        joinDate = Calendar.getInstance();  //mengambil tanggal sekarang
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
    public Calendar getJoinDate()
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
        String emailRegex = "^[\\w&*_~]+(\\.?[\\w&*_~]+)*@[^-][\\w\\-\\.]+$";
        if (Pattern.matches(emailRegex, email)){
            this.email = email;
        }
        else {
            this.email = "";
        }
    }
    
        /**
     * setter untuk mengatur nilai password
     *
     * @param  password  parameter untuk mengganti password
     */
    public void setPassword(String password)
    {
        String passRegex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}";
        if (Pattern.matches(passRegex, password)){
            this.password = password;
        }
        else {
            this.password = "";
        }
    }
    
        /**
     * setter untuk mengatur nilai joinDate
     *
     * @param  joinDate parameter untuk mengganti join date (tipe calendar)
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }
    
            /**
     * setter untuk mengatur nilai joinDate
     *
     * @param  joinDate parameter untuk mengganti join date (masukan d-m-y)
     */
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        joinDate.set(year, month-1, dayOfMonth);
    }
    
    /**
     * metode untuk mencetak data
     */
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        return  "===================== Jobseeker =====================" +
                "\nID = " + id +
                "\nNama = " + name +
                "\nEmail = " + email +
                "\nPassword = " + password +
                "\nJoin Date = " + dateFormat.format(joinDate.getTime());
    }
}
