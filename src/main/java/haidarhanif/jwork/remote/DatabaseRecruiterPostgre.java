package haidarhanif.jwork.remote;

import haidarhanif.jwork.Location;
import haidarhanif.jwork.Recruiter;
import haidarhanif.jwork.exception.RecruiterNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseRecruiterPostgre {

    public static ArrayList<Recruiter> getAllRecruiter(){
        ArrayList<Recruiter> recruiterList = new ArrayList<>();
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = "SELECT * FROM recruiter;";
            ResultSet queryRes = stat.executeQuery(query);
            while(queryRes.next()) {
                int id = queryRes.getInt("recruiter_id");
                String name = queryRes.getString("name");
                String email = queryRes.getString("email");
                String phone_number = queryRes.getString("phone_number");
                String province = queryRes.getString("province");
                String city = queryRes.getString("city");
                String description = queryRes.getString("description");

                recruiterList.add(new Recruiter(id, name, email, phone_number, new Location(province, city, description)));
            }

            System.out.println("Recruiter loaded successfully");
            queryRes.close();
            stat.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return recruiterList;
    }

    public static int getLastId(){
        int lastId = 0;
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = "SELECT MAX(recruiter_id) as lastId FROM recruiter;";
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

    public static Recruiter getRecruiterById(int id){
        Recruiter recruiter = null;
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = String.format("SELECT * FROM recruiter WHERE recruiter_id = %d;", id);
            ResultSet queryRes = stat.executeQuery(query);
            queryRes.next();

            int recruiter_id = queryRes.getInt("recruiter_id");
            String name = queryRes.getString("name");
            String email = queryRes.getString("email");
            String phone_number = queryRes.getString("phone_number");
            String province = queryRes.getString("province");
            String city = queryRes.getString("city");
            String description = queryRes.getString("description");

            recruiter = new Recruiter(recruiter_id, name, email, phone_number, new Location(province, city, description));

            System.out.println("Recruiter with id "+ id +" loaded successfully");

            queryRes.close();
            stat.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return recruiter;
    }

    public static void addRecruiter(Recruiter recruiter) {
        try {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stat = c.createStatement();

            String sql = String.format("INSERT INTO recruiter VALUES (%d,'%s','%s','%s','%s','%s','%s');",
                    recruiter.getId(), recruiter.getName(), recruiter.getEmail(), recruiter.getPhoneNumber(), recruiter.getLocation().getProvince(), recruiter.getLocation().getCity(), recruiter.getLocation().getDescription());
            stat.executeUpdate(sql);

            stat.close();
            c.close();

            System.out.println("Recruiter inserted successfully");
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }

    public static void removeRecruiter(int id) throws RecruiterNotFoundException {
        Connection c = null;
        Statement stat = null;
        try {
            c = DatabaseConnectionPostgre.connection();
            stat = c.createStatement();

            String sql = String.format("DELETE from recruiter where recruiter_id = %d;", id);
            int res = stat.executeUpdate(sql);
            stat.close();
            c.close();

            if (res == 0) {
                throw new RecruiterNotFoundException(id);
            }

            System.out.println(String.format("removed id %d successfully", id));
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
}
