import java.util.GregorianCalendar;

/**
 * Class of JWork
 *
 * @author Haidar Hanif
 * @version 8-04-2021
 */
public class JWork
{

    public static void main (String[] args)
    {
        Location location1 = new Location("Jawa Barat", "Depok", "Kukusan");
        Recruiter recruiter1 = new Recruiter(1806148694, "FM", "fm@ui.ac.id", "808080", location1);
        Job job1 = new Job(777, "UI Engineer", recruiter1, 6000000, JobCategory.UI);
        Jobseeker js1 = new Jobseeker(707070, "pencarikerja", "pencari@ui.ac.id", "pass");
        Invoice eDompet = new EwalletPayment(1, job1, js1, InvoiceStatus.Cancelled);
        Invoice bank = new BankPayment(2, job1, js1, InvoiceStatus.Cancelled);
        
        System.out.println(eDompet.toString());
        System.out.println(bank.toString());
    }
}
