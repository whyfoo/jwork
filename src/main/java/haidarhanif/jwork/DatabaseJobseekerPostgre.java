package haidarhanif.jwork;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DatabaseJobseekerPostgre {

    public static void insertJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException{
        try {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stat = c.createStatement();
            String sql = String.format("INSERT INTO jobseeker (jobseeker_id, name, email, password, join_date)"
                    + "VALUES (%d, '%s', '%s', '%s', '%s');", getLastJobseekerId()+1, jobseeker.getName(), jobseeker.getEmail(), jobseeker.getPassword(), jobseeker.getJoinDate().getTime());
            stat.executeUpdate(sql);

            stat.close();
            c.close();

            System.out.println("Jobseeker inserted successfully");
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new EmailAlreadyExistsException(jobseeker);
        }
    }

    public static int getLastJobseekerId(){
        int lastId = 0;
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = "SELECT MAX(jobseeker_id) as LastId FROM jobseeker;";
            ResultSet queryRes = stat.executeQuery(query);
            while(queryRes.next()) {
                lastId = queryRes.getInt("LastId");
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

    public static ArrayList<Jobseeker> getJobseeker(){
        ArrayList<Jobseeker> jobseekerList = new ArrayList<>();
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = "SELECT * FROM jobseeker;";
            ResultSet queryRes = stat.executeQuery(query);
            while(queryRes.next()) {
                int id = queryRes.getInt("jobseeker_id");
                String name = queryRes.getString("name");
                String email = queryRes.getString("email");
                String password = queryRes.getString("password");
                Date join_date= queryRes.getDate("join_date");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(join_date);

                jobseekerList.add(new Jobseeker(id, name, email, password, calendar));
            }
            queryRes.close();
            stat.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return jobseekerList;
    }

    public static void removeJobseeker(int id){
        Connection c = null;
        Statement stat = null;
        try {
            c = DatabaseConnectionPostgre.connection();

            stat = c.createStatement();
            String sql = String.format("DELETE from jobseeker where jobseeker_id = %d;", id);
            stat.executeUpdate(sql);

            stat.close();
            c.close();
            System.out.println("Operation done successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }

    public static Jobseeker jobseekerLogin(String email, String password){
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = String.format("SELECT * FROM jobseeker WHERE email = '%s' AND password = '%s';", email, password);

            ResultSet queryRes = stat.executeQuery(query);
            queryRes.next();

            int id = queryRes.getInt("jobseeker_id");
            String name = queryRes.getString("name");
            String queryEmail = queryRes.getString("email");
            String queryPassword = queryRes.getString("password");
            Date join_date = queryRes.getDate("join_date");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(join_date);

            queryRes.close();
            stat.close();
            c.close();

            return new Jobseeker(id, name, email, password, calendar);

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
