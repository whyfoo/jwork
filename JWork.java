import java.util.GregorianCalendar;

/**
 * Class of JWork
 *
 * @author Haidar Hanif
 * @version 3-04-2021
 */
public class JWork
{

    public static void main (String[] args)
    {
        Jobseeker pertama = new Jobseeker(707070, "Haidarh", ".haidarh@ui.ac.id", "pass", new GregorianCalendar(2021,8,4));
        Jobseeker kedua = new Jobseeker(707070, "Haidarh", "haidarh@ui.ac.id", "Password1", new GregorianCalendar(2021,8,4));
        Jobseeker ketiga = new Jobseeker(707070, "Haidarh", "terserah", "terserah");
        
        System.out.println(pertama.toString());
        System.out.println(kedua.toString());
        System.out.println(ketiga.toString());
        
        pertama.setEmail("uoi@ui.com");
        pertama.setPassword("Passbenar1");
        kedua.setEmail("uoi@ui.com");
        kedua.setPassword("Passbenar2");
        
        System.out.println(pertama.toString());
        System.out.println(kedua.toString());
        System.out.println(ketiga.toString());
        
        //Location location1 = new Location("Jawa Barat", "Bekasi", "Kota Patriot");
        //Recruiter recruiter1 = new Recruiter(1806148694, "FM", "fm@ui.ac.id", "808080", location1);
        //Jobseeker js1 = new Jobseeker(707070, "Haidarh", "haidarh@ui.ac.id", "pass", "20-03-2021");
        //Bonus bonus1 = new Bonus(1, "BONUS1", 10, 60, true);
        //Bonus bonus2 = new Bonus(1, "BONUS2", 10, 40, true);
        //Job job1 = new Job(777, "UI Engineer", recruiter1, 50, JobCategory.UI);
        
        //Invoice pertama = new EwalletPayment(1, job1, "1-04-2021", js1, InvoiceStatus.OnGoing);
        //Invoice kedua = new EwalletPayment(2, job1, "1-04-2021", js1, bonus1, InvoiceStatus.OnGoing);
        //Invoice ketiga = new EwalletPayment(3, job1, "1-04-2021", js1, bonus2, InvoiceStatus.OnGoing);
        
        //Invoice pertama = new BankPayment(1, job1, "3-04-2021", js1, InvoiceStatus.Finished);
        //Invoice kedua = new BankPayment(2, job1, "3-04-2021", js1, InvoiceStatus.Finished, 15);
        
        //pertama.setTotalFee();
        //kedua.setTotalFee();
        
        //pertama.printData();
        //kedua.printData();
    }
}
