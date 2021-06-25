package haidarhanif.jwork.remote;

import haidarhanif.jwork.Job;
import haidarhanif.jwork.enumerated.JobCategory;
import haidarhanif.jwork.exception.JobNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseJobPostgre {
    
    public static ArrayList<Job> getAllJob(){
        ArrayList<Job> jobList = new ArrayList<>();
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = "SELECT * FROM job;";
            ResultSet queryRes = stat.executeQuery(query);
            while(queryRes.next()) {
                int id = queryRes.getInt("job_id");
                String name = queryRes.getString("name");
                int fee = queryRes.getInt("fee");
                String category = queryRes.getString("category");
                int recruiter_id = queryRes.getInt("recruiter_id");

                jobList.add(new Job(id, name, DatabaseRecruiterPostgre.getRecruiterById(recruiter_id), fee, JobCategory.valueOf(category)));
            }

            System.out.println("Job loaded successfully");
            queryRes.close();
            stat.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return jobList;
    }

    public static int getLastId(){
        int lastId = 0;
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = "SELECT MAX(job_id) as lastId FROM job;";
            ResultSet queryRes = stat.executeQuery(query);
            while(queryRes.next()) {
                lastId = queryRes.getInt("lastId");
            }
            queryRes.close();
            stat.close();
            c.close();
            return lastId;
        } catch (Exception e) {
            System.out.println(e);
        }
        return lastId;
    }

    public static Job getJobById(int id) throws JobNotFoundException{
        Job job = null;
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = String.format("SELECT * FROM job WHERE job_id = %d;", id);
            ResultSet queryRes = stat.executeQuery(query);
            queryRes.next();

            int job_id = queryRes.getInt("job_id");
            String name = queryRes.getString("name");
            int fee = queryRes.getInt("fee");
            String category = queryRes.getString("category");
            int recruiter_id = queryRes.getInt("recruiter_id");

            job = new Job(job_id, name, DatabaseRecruiterPostgre.getRecruiterById(recruiter_id), fee, JobCategory.valueOf(category));

            System.out.println("Recruiter with id "+ id +" loaded successfully");

            queryRes.close();
            stat.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return job;
    }


    public static ArrayList<Job> getJobByRecruiter(int recruiterId) {
        ArrayList<Job> allJob = new ArrayList<Job>();
        Job job;
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            c.setAutoCommit(false);
            Statement stat = c.createStatement();
            String query = String.format("SELECT * FROM job WHERE recruiter_id = %d;", recruiterId);
            ResultSet queryRes = stat.executeQuery(query);
            while(queryRes.next()) {
                job = new Job(
                        queryRes.getInt("job_id"),
                        queryRes.getString("name"),
                        DatabaseRecruiterPostgre.getRecruiterById(queryRes.getInt("recruiter_id")),
                        queryRes.getInt("fee"),
                        JobCategory.valueOf(queryRes.getString("category"))
                );
                allJob.add(job);
            }

            queryRes.close();
            c.commit();
            stat.close();
            c.close();
            return allJob;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * getJobByCategory akan mengembalikan job dengan
     * category yang sesuai
     *
     * @param category
     * @return ArrayList job
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category) {
        ArrayList<Job> allJob = new ArrayList<Job>();
        Job jobObj;
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            c.setAutoCommit(false);
            Statement stat = c.createStatement();
            String query = String.format("SELECT * FROM job WHERE category = '%s';", category.name());
            ResultSet queryRes = stat.executeQuery(query);
            while(queryRes.next()) {
                jobObj = new Job(
                        queryRes.getInt("job_id"),
                        queryRes.getString("name"),
                        DatabaseRecruiterPostgre.getRecruiterById(queryRes.getInt("recruiter_id")),
                        queryRes.getInt("fee"),
                        JobCategory.valueOf(queryRes.getString("category"))
                );
                allJob.add(jobObj);
            }
            queryRes.close();
            c.commit();
            stat.close();
            c.close();
            return allJob;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void addJob(Job job) {
        try {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stat = c.createStatement();

            String sql = String.format("INSERT INTO job VALUES (%d,'%s',%d,'%s',%d);",
                    job.getId(), job.getName(), job.getFee(), job.getCategory().name(), job.getRecruiter().getId());
            stat.executeUpdate(sql);

            stat.close();
            c.close();

            System.out.println("Job inserted successfully");
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }

    public static void removeJob(int id) throws JobNotFoundException {
        Connection c = null;
        Statement stat = null;
        try {
            c = DatabaseConnectionPostgre.connection();
            stat = c.createStatement();

            String sql = String.format("DELETE from job where job_id = %d;", id);
            int res = stat.executeUpdate(sql);
            stat.close();
            c.close();

            if (res == 0) {
                throw new JobNotFoundException(id);
            }

            System.out.println(String.format("removed id %d successfully", id));
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }

}
