package haidarhanif.jwork.controller;

import haidarhanif.jwork.*;
import haidarhanif.jwork.exception.EmailAlreadyExistsException;
import haidarhanif.jwork.exception.JobSeekerNotFoundException;
import haidarhanif.jwork.remote.DatabaseJobseekerPostgre;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    @RequestMapping("")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        Jobseeker jobseeker = null;
        try {
            jobseeker = DatabaseJobSeeker.getJobseekerById(id);
        } catch (JobSeekerNotFoundException e) {
            e.getMessage();
            return null;
        }
        return jobseeker;
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeJobseeker(@PathVariable int id) {
            DatabaseJobseekerPostgre.removeJobseeker(id);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value="name") String name,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password)
    {
        Jobseeker jobseeker = new Jobseeker(DatabaseJobseekerPostgre.getLastId()+1, name, email, password);
        if (jobseeker.getEmail().length() == 0) {
            return null;
        }
        try {
            DatabaseJobseekerPostgre.addJobseeker(jobseeker);
        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return jobseeker;
    }

    @RequestMapping("/login")
    public Jobseeker loginJobseeker(@RequestParam(value = "email") String email,
                                    @RequestParam(value="password") String password)
    {
//        return DatabaseJobSeeker.jobseekerLogin(email, password);
        return DatabaseJobseekerPostgre.jobseekerLogin(email,password);
    }
}