package haidarhanif.jwork.controller;

import haidarhanif.jwork.*;
import haidarhanif.jwork.enumerated.JobCategory;
import haidarhanif.jwork.exception.JobNotFoundException;
import haidarhanif.jwork.remote.DatabaseJobPostgre;
import haidarhanif.jwork.remote.DatabaseRecruiterPostgre;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/job")
@RestController
public class JobController {

    @RequestMapping("")
    public ArrayList<Job> getAllJob()
    {
        return DatabaseJobPostgre.getAllJob();
    }

    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id)
    {
        Job job = null;
        try {
            job = DatabaseJobPostgre.getJobById(id);
        } catch (JobNotFoundException e){
            e.getMessage();
        }
        return job;
    }

    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId)
    {
        return DatabaseJobPostgre.getJobByRecruiter(recruiterId);
    }

    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category)
    {
        return DatabaseJobPostgre.getJobByCategory(category);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value="name") String name,
                      @RequestParam(value="recruiterId") int recruiterId,
                      @RequestParam(value="fee") int fee,
                      @RequestParam(value="category") JobCategory category)
    {
        Recruiter recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);
        Job job = new Job(DatabaseJobPostgre.getLastId()+1, name, recruiter, fee, category);

        DatabaseJobPostgre.addJob(job);
        return job;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public boolean removeJob(@RequestParam(value="id") int id)
    {
        try {
            DatabaseJobPostgre.removeJob(id);
        } catch (JobNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
