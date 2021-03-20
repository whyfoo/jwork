
/**
 * Class of JWork
 *
 * @author Haidar Hanif
 * @version 20-03-2021
 */
public class JWork
{

    public static void main (String[] args)
    {
        Location location1 = new Location("Jawa Barat", "Bekasi", "Kota Patriot");
        Recruiter recruiter1 = new Recruiter(1806148694, "Hanif", "hanif@ui.ac.id", "808080", location1);
        Job job1 = new Job(777, "Fullstack", recruiter1, 6000000, "IT");
        Jobseeker js1 = new Jobseeker(707070, "Pencari", "pencari@ui.ac.id", "pass", "20-03-2021");
        Invoice inv1 = new Invoice(666, 222, "20-03-2021", 6500000, js1);
        
        System.out.println("Nama Recruiter: " + recruiter1.getName());
        recruiter1.setName("FM");
        System.out.println("Nama Recruiter: " + recruiter1.getName());
        js1.printData();
    }
}
