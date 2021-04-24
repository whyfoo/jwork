import java.util.ArrayList;
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
//        Location location1 = new Location("Jawa Barat", "Depok", "Kukusan");
//        Recruiter recruiter1 = new Recruiter(1806148694, "FM", "fm@ui.ac.id", "808080", location1);
//        Job job1 = new Job(777, "UI Engineer", recruiter1, 600, JobCategory.UI);
//        Jobseeker js1 = new Jobseeker(707070, "pencarikerja", "pencari@ui.ac.id", "pass");
//        Invoice eDompet = new EwalletPayment(1, job1, js1, InvoiceStatus.Cancelled);
//        Invoice bank = new BankPayment(2, job1, js1, InvoiceStatus.Cancelled);
//
//        eDompet.setTotalFee();
//        bank.setTotalFee();
//
//        System.out.println(eDompet.toString());
//        System.out.println(bank.toString());

        Location location1 = new Location("Jawa Barat", "Depok", "Kukusan");

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Perekrut", "perekrut@ui.ac.id", "123456", location1));

        DatabaseJobSeeker.addJobseeker(new Jobseeker(DatabaseJobSeeker.getLastId()+1, "HaidarH", "haidar.hanif@ui.ac.id", "Passsss1"));
        DatabaseJobSeeker.addJobseeker(new Jobseeker(DatabaseJobSeeker.getLastId()+1, "HaidarH", "haidar.hanif@ui.ac.id", "Passsss1"));

        DatabaseJobSeeker.addJobseeker(new Jobseeker(DatabaseJobSeeker.getLastId()+1, "FM", "fm@ui.ac.id", "Passsss2"));

        for(Jobseeker jobseeker: DatabaseJobSeeker.getJobseekerDatabase()){
            System.out.println(jobseeker.toString());
        }

        DatabaseJob.addJob(new Job( DatabaseJob.getLastId()+1, "UI Engineer", DatabaseRecruiter.getRecruiterById(1), 60, JobCategory.UI));
        DatabaseJob.addJob(new Job( DatabaseJob.getLastId()+1, "UI Analyst", DatabaseRecruiter.getRecruiterById(1), 60, JobCategory.UI));
        DatabaseJob.addJob(new Job( DatabaseJob.getLastId()+1, "Backend Engineer", DatabaseRecruiter.getRecruiterById(1), 60, JobCategory.BackEnd));

        for(Job jobo: DatabaseJob.getJobByCategory(JobCategory.UI)){
            System.out.println(jobo.toString());
        }

        //1
        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "REFCODE", 10, 15, false));
        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "REFCODE", 5, 15, true));

        //2
        for (Bonus bonus: DatabaseBonus.getBonusDatabase()){
            System.out.println(bonus.toString());
        }

        //3
        DatabaseJob.addJob(new Job( DatabaseJob.getLastId()+1, "UX Engineer", DatabaseRecruiter.getRecruiterById(1), 20, JobCategory.UX));
        DatabaseJob.addJob(new Job( DatabaseJob.getLastId()+1, "UX Analyst", DatabaseRecruiter.getRecruiterById(1), 10, JobCategory.UX));

        //4
        DatabaseInvoice.addInvoice(new BankPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobSeeker.getJobseekerById(1)));

        //5
        ArrayList<Invoice> invoice = DatabaseInvoice.getInvoiceByJobseeker(1);
        invoice.get(invoice.size()-1).setTotalFee();

        //6
        DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobSeeker.getJobseekerById(1)));

        //7
        invoice = DatabaseInvoice.getInvoiceByJobseeker(1);
        invoice.get(invoice.size()-1).setTotalFee();

        //8
        for (Invoice inv: DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(inv.toString());
        }

        //9
        invoice = DatabaseInvoice.getInvoiceByJobseeker(1);
        invoice.get(invoice.size()-1).setInvoiceStatus(InvoiceStatus.Finished);

        //10
        DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobSeeker.getJobseekerById(2), DatabaseBonus.getBonusById(1)));

        //11
        DatabaseBonus.activateBonus(1);

        //12
        DatabaseInvoice.getInvoiceDatabase().forEach(inv -> {
            inv.setTotalFee();
        });

        //13
        for (Invoice inv: DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(inv.toString());
        }
    }
}
