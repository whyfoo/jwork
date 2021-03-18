
/**
 * Class of JWork
 *
 * @author Haidar Hanif
 * @version 18-03-2021
 */
public class JWork
{

    public void main (String[] args)
    {
        Location location1 = new Location("Jawa Barat", "Bekasi", "Kota Patriot");
        Recruiter recruiter1 = new Recruiter(272727, "Hanif", "hanif@ui.ac.id", "808080", location1);
        Job job1 = new Job(777, "Fullstack", recruiter1, 6000000, "IT");
        Jobseeker js1 = new Jobseeker(707070, "Haidar", "haidar@ui.ac.id", "pass", "18-03-2021");
        Invoice inv1 = new Invoice(666, 222, "19-03-2021", 6500000, js1);
        
        //location1.printData();
        //recruiter1.printData();
        //js1.printData();
    }
}
