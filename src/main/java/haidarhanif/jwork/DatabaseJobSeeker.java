package haidarhanif.jwork;
import java.util.ArrayList;

/**
 * Class of DatabaseJobSeeker
 *
 * @author Haidar Hanif
 * @version 6-05-2021
 */
public class DatabaseJobSeeker
{
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE  = new ArrayList<>();
    private static int lastId = 0;

    /**
     * getter untuk mengambil jobseekerDatabase
     * @return    null
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase()
    {
        return JOBSEEKER_DATABASE;
    }

    /**
     * getter untuk mengambil getLastId
     * @return    lastId
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * getter untuk mengambil Jobseeker dari ID
     * @param id Jobseeker ID
     * @return    null
     */
    public static Jobseeker getJobseekerById(int id) throws JobSeekerNotFoundException
    {
        Jobseeker valueJobseeker = null;
        for(Jobseeker js: JOBSEEKER_DATABASE)
        {
            if(js.getId() == id)
            {
                valueJobseeker = js;
            }
        }

        if (valueJobseeker == null) {
            throw new JobSeekerNotFoundException(id);
        } else {
            return valueJobseeker;
        }
    }
    /**
     * metode untuk menambah JobseekerDatabase
     * @param jobseeker Jobseeker
     * @return    false
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException
    {
        for(Jobseeker js: JOBSEEKER_DATABASE)
        {
            if(js.getEmail().equals(jobseeker.getEmail()))
            {
                throw new EmailAlreadyExistsException(jobseeker);
            }
        }

        lastId = jobseeker.getId();
        return JOBSEEKER_DATABASE.add(jobseeker);
    }

    /**
     * metode untuk remove JobseekerDatabase
     * @param id Jobseeker ID
     * @return    false
     */
    public static boolean removeJobseeker(int id) throws JobSeekerNotFoundException
    {
        if (JOBSEEKER_DATABASE.removeIf(js -> js.getId() == id)) {
            return true;
        } else {
            throw new JobSeekerNotFoundException(id);
        }
    }

    public static Jobseeker getJobseekerLogin(String email, String password)
    {
        for(Jobseeker js: JOBSEEKER_DATABASE)
        {
            if(js.getEmail().equals(email) && js.getPassword().equals(password))
            {
                return js;
            }
        }
        return null;
    }
}
