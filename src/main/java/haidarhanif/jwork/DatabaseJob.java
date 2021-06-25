package haidarhanif.jwork;
import haidarhanif.jwork.enumerated.JobCategory;
import haidarhanif.jwork.exception.JobNotFoundException;

import java.util.ArrayList;

/**
 * Class of DatabaseJob
 *
 * @author Haidar Hanif
 * @version 6-05-2021
 */
public class DatabaseJob
{
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<Job>();
    private static int lastId = 0;

    /**
     * getter untuk mengambil jobDatabase
     * @return    JOB_DATABASE
     */
    public static ArrayList<Job> getJobDatabase()
    {
        return JOB_DATABASE;
    }

    /**
     * getter untuk mengambil lastId
     * @return    lastId
     */
    public static int getLastId()
    {
        return lastId;
    }
    /**
     * getter mengambil job dari id
     * @param id Job ID
     * @return    Job
     */
    public static Job getJobById(int id) throws JobNotFoundException
    {
        Job valueJob = null;
        for(Job jobo: JOB_DATABASE)
        {
            if(jobo.getId() == id)
            {
                valueJob = jobo;
            }
        }

        if (valueJob == null) {
            throw new JobNotFoundException(id);
        } else {
            return valueJob;
        }
    }

    /**
     * getter mengambil job dari recruiter
     * @param recruiterId Recruiter ID
     * @return   job by recruiter
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId)
    {
        ArrayList<Job> valueJob = new ArrayList<Job>();
        for(Job jobo: JOB_DATABASE)
        {
            if(jobo.getRecruiter().getId() == recruiterId)
            {
                valueJob.add(jobo);
            }
        }
        return valueJob;
    }

    /**
     * getter mengambil job dari kategori
     * @param category Job Category
     * @return    job by category
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category)
    {
        ArrayList<Job> valueJob = new ArrayList<Job>();
        for(Job jobo: JOB_DATABASE)
        {
            if(jobo.getCategory() == category)
            {
                valueJob.add(jobo);
            }
        }
        return valueJob;
    }

    /**
     * setter menambah job
     * @param job Job
     * @return    false
     */
    public static boolean addJob(Job job)
    {
        lastId = job.getId();
        return JOB_DATABASE.add(job);
    }

    /**
     * setter menghapus job
     * @param id Job ID
     * @return    false
     */
    public static boolean removeJob(int id) throws JobNotFoundException
    {
        if (JOB_DATABASE.removeIf(job -> job.getId() == id)) {
            return true;
        } else {
            throw new JobNotFoundException(id);
        }
    }
}
