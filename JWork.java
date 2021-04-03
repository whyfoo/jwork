
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
        Location location1 = new Location("Jawa Barat", "Bekasi", "Kota Patriot");
        Recruiter recruiter1 = new Recruiter(1806148694, "FM", "fm@ui.ac.id", "808080", location1);
        Jobseeker js1 = new Jobseeker(707070, "Pencari", "pencari@ui.ac.id", "pass", "20-03-2021");
        Bonus bonus1 = new Bonus(1, "GRATISX", 10, 60, true);
        Bonus bonus2 = new Bonus(1, "GRATISX", 10, 40, true);
        Job job1 = new Job(777, "UI Engineer", recruiter1, 50, JobCategory.UI);
        
        Invoice pertama = new EwalletPayment(1, job1, "1-04-2021", js1, InvoiceStatus.OnGoing);
        Invoice kedua = new EwalletPayment(2, job1, "1-04-2021", js1, bonus1, InvoiceStatus.OnGoing);
        Invoice ketiga = new EwalletPayment(3, job1, "1-04-2021", js1, bonus2, InvoiceStatus.OnGoing);
        
        pertama.setTotalFee();
        kedua.setTotalFee();
        ketiga.setTotalFee();
        
        pertama.printData();
        kedua.printData();
        ketiga.printData();
    }
}
