
/**
 * Class of JWork
 *
 * @author Haidar Hanif
 * @version 27-03-2021
 */
public class JWork
{

    public static void main (String[] args)
    {
        Location location1 = new Location("Jawa Barat", "Bekasi", "Kota Patriot");
        Recruiter recruiter1 = new Recruiter(1806148694, "FM", "fm@ui.ac.id", "808080", location1);
        Job job1 = new Job(777, "UI Engineer", recruiter1, 6000000, JobCategory.UI);
        Jobseeker js1 = new Jobseeker(707070, "Pencari", "pencari@ui.ac.id", "pass", "20-03-2021");
        Invoice inv1 = new Invoice(666, job1.getId(), "27-03-2021", job1.getFee(), js1, PaymentType.EwalletPayment, InvoiceStatus.OnGoing);
        
        //System.out.println(InvoiceStatus.Ongoing.toString());
        //System.out.println(InvoiceStatus.Finished.toString());
        //System.out.println(InvoiceStatus.Cancelled.toString());
        
        inv1.printData();
    }
}
