import java.util.ArrayList;

/**
 * Class of DatabaseJobSeeker
 *
 * @author Haidar Hanif
 * @version 22-04-2021
 */
public class DatabaseJobSeeker
{
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE;
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
    public static Jobseeker getJobseekerById(int id)
    {
        Jobseeker valueJobseeker = null;
        for(Jobseeker js: JOBSEEKER_DATABASE)
        {
            if(js.getId() == id)
            {
                valueJobseeker = js;
            }
        }
        return valueJobseeker;
    }
    /**
     * metode untuk menambah JobseekerDatabase
     * @param jobseeker Jobseeker
     * @return    false
     */
    public static boolean addJobseeker(Jobseeker jobseeker)
    {
        for(Jobseeker js: JOBSEEKER_DATABASE)
        {
            if(js.getEmail() == jobseeker.getEmail())
            {
                return false;
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
    public static boolean removeJobseeker(int id)
    {
        return JOBSEEKER_DATABASE.removeIf(js -> js.getId() == id);
    }
}
