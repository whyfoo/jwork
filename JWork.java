import java.util.GregorianCalendar;

/**
 * Class of JWork
 *
 * @author Haidar Hanif
 * @version 8-04-2021
 */
public class JWork
{

    public static void main (String[] args)
    {
        Jobseeker pertama = new Jobseeker(707070, "Haidarh", ".haidarh@ui.ac.id", "pass", new GregorianCalendar(2021,8,4));
        Jobseeker kedua = new Jobseeker(707070, "Haidarh", "haidarh@ui.ac.id", "Password1", new GregorianCalendar(2021,8,4));
        Jobseeker ketiga = new Jobseeker(707070, "Haidarh", "terserah", "terserah");
        
        System.out.println(pertama.toString());
        System.out.println(kedua.toString());
        System.out.println(ketiga.toString());
        
        pertama.setEmail("uoi1@ui.com");
        pertama.setPassword("Passbenar1");
        kedua.setEmail("uoi2@ui.com");
        kedua.setPassword("Passbenar2");
        
        System.out.println(pertama.toString());
        System.out.println(kedua.toString());
    }
}
