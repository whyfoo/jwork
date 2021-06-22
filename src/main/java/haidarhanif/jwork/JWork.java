package haidarhanif.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;

@SpringBootApplication
public class JWork {

    public static void main(String[] args) {
        Location bekasiCity = new Location("Jawa Barat", "Bekasi", "Kota Patriot");
        Location jakartaCity = new Location("DKI Jakarta", "Jakarta", "Ibukota");
        Location depokCity = new Location("Jawa Barat", "Depok", "Kota Petir");

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Haidar", "haidar@ui.ac.id", "081314151617", bekasiCity));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "FM", "fm@ui.ac.id", "081498765432", depokCity));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Net", "net@ui.ac.id", "088710248212", jakartaCity));

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Junior Web Developer", DatabaseRecruiter.getRecruiterById(1), 10, JobCategory.WebDeveloper));
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Senior Web Developer", DatabaseRecruiter.getRecruiterById(2), 20, JobCategory.WebDeveloper));
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "UI Engineer", DatabaseRecruiter.getRecruiterById(3), 20, JobCategory.UI));
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "UX Engineer", DatabaseRecruiter.getRecruiterById(3), 20, JobCategory.UX));
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "UX Engineer", DatabaseRecruiter.getRecruiterById(3), 20, JobCategory.UX));
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
        }


        try {
            DatabaseJobSeeker.addJobseeker(new Jobseeker(1, "ADMIN", "a@a.com", "Password1"));
        } catch (EmailAlreadyExistsException e) {
            e.getMessage();
        }

        try {
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "REFCODE", 5, 20, true));
        } catch (ReferralCodeAlreadyExistsException e) {
            e.getMessage();
        }

        SpringApplication.run(JWork.class, args);
    }

}