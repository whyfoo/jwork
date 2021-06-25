package haidarhanif.jwork.remote;

import haidarhanif.jwork.Bonus;
import haidarhanif.jwork.exception.BonusNotFoundException;
import haidarhanif.jwork.exception.ReferralCodeAlreadyExistsException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseBonusPostgre {

    public static ArrayList<Bonus> getAllBonus(){
        ArrayList<Bonus> bonusList = new ArrayList<>();
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = "SELECT * FROM bonus;";
            ResultSet queryRes = stat.executeQuery(query);
            while(queryRes.next()) {
                int id = queryRes.getInt("bonus_id");
                String referral_code = queryRes.getString("referral_code");
                int extra_fee = queryRes.getInt("extra_fee");
                int min_total_fee = queryRes.getInt("min_total_fee");
                boolean active = queryRes.getBoolean("active");

                bonusList.add(new Bonus(id, referral_code, extra_fee, min_total_fee, active));
            }
            queryRes.close();
            stat.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return bonusList;
    }

    public static int getLastId(){
        int lastId = 0;
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = "SELECT MAX(bonus_id) as lastId FROM bonus;";
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

    public static Bonus getBonusById(int id){
        Bonus bonus = null;
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = String.format("SELECT * FROM bonus WHERE bonus_id = %d;", id);
            ResultSet queryRes = stat.executeQuery(query);
            queryRes.next();

            int bonus_id = queryRes.getInt("bonus_id");
            String referral_code = queryRes.getString("referral_code");
            int extra_fee = queryRes.getInt("extra_fee");
            int min_total_fee = queryRes.getInt("min_total_fee");
            boolean active = queryRes.getBoolean("active");

            bonus = new Bonus(bonus_id, referral_code, extra_fee, min_total_fee, active);

            queryRes.close();
            stat.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return bonus;
    }

    public static Bonus getBonusByReferralCode(String refCode){
        Bonus bonus = null;
        Connection c = DatabaseConnectionPostgre.connection();

        try {
            Statement stat = c.createStatement();
            String query = String.format("SELECT * FROM bonus WHERE referral_code = '%s';", refCode);
            ResultSet queryRes = stat.executeQuery(query);
            queryRes.next();

            int bonus_id = queryRes.getInt("bonus_id");
            String referral_code = queryRes.getString("referral_code");
            int extra_fee = queryRes.getInt("extra_fee");
            int min_total_fee = queryRes.getInt("min_total_fee");
            boolean active = queryRes.getBoolean("active");

            bonus = new Bonus(bonus_id, referral_code, extra_fee, min_total_fee, active);

            queryRes.close();
            stat.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return bonus;
    }

    public static void addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException {
        try {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stat = c.createStatement();

            String sql = String.format("INSERT INTO bonus VALUES (%d, '%s', %d, %d, %b);",
                    getLastId()+1, bonus.getReferralCode(), bonus.getExtraFee(), bonus.getMinTotalFee(), bonus.getActive());
            stat.executeUpdate(sql);

            stat.close();
            c.close();

            System.out.println("Bonus inserted successfully");
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            throw new ReferralCodeAlreadyExistsException(bonus);
        }
    }

    public static void removeBonus(int id) throws BonusNotFoundException {
        Connection c = null;
        Statement stat = null;
        try {
            c = DatabaseConnectionPostgre.connection();
            stat = c.createStatement();

            String sql = String.format("DELETE from bonus where bonus_id = %d;", id);
            int res = stat.executeUpdate(sql);
            stat.close();
            c.close();

            if (res == 0) {
                throw new BonusNotFoundException(id);
            }

            System.out.println("Operation done successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }

    public static void updateActiveStatus(int id) throws BonusNotFoundException{
        Connection c = null;
        Statement stat = null;
        try {
            c = DatabaseConnectionPostgre.connection();
            stat = c.createStatement();

            String sql = String.format("UPDATE bonus SET active = NOT active where bonus_id = %d", id);
            int res = stat.executeUpdate(sql);

            if (res == 0) {
                throw new BonusNotFoundException(id);
            }

            stat.close();
            c.close();
            System.out.println("Operation done successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }

}
