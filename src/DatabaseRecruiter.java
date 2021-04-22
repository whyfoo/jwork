import java.util.ArrayList;

/**
 * Write a description of class DataRecruiter here.
 *
 * @author Haidar Hanif
 * @version 25-03-2021
 */
public class DatabaseRecruiter
{
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * getter untuk mengambil recruiterDatabase
     * @return    null
     */
    public static ArrayList<Recruiter> getRecruiterDatabase()
    {
        return RECRUITER_DATABASE;
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
     * getter untuk mengambil recruiter dari ID
     * @param id Recruiter ID
     * @return    null
     */
    public static Recruiter getRecruiterById(int id)
    {
        Recruiter valueRecruiter = null;
        for(Recruiter rec: RECRUITER_DATABASE)
        {
            if(rec.getId() == id)
            {
                valueRecruiter = rec;
            }
        }
        return valueRecruiter;
    }

    /**
     * metode untuk menambah recruiterDatabase
     * @param recruiter Recruiter
     * @return    false
     */
    public static boolean addRecruiter(Recruiter recruiter)
    {
        lastId = recruiter.getId();
        return RECRUITER_DATABASE.add(recruiter);
    }

    /**
     * metode untuk remove recruiterDatabase
     * @param id Recruiter ID
     * @return    false
     */
    public static boolean removeRecruiter(int id)
    {
        return RECRUITER_DATABASE.removeIf(rec -> rec.getId() == id);
//        for(Recruiter rec: RECRUITER_DATABASE) {
//            if (rec.getId() == id) {
//                RECRUITER_DATABASE.remove(rec);
//                return true;
//            }
//        }
//        return false;
    }
}