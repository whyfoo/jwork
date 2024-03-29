package haidarhanif.jwork;
import haidarhanif.jwork.exception.BonusNotFoundException;
import haidarhanif.jwork.exception.ReferralCodeAlreadyExistsException;

import java.util.ArrayList;

/**
 * Kelas Database untuk Bonus
 *
 * @author Haidar Hanif
 * @version 6-05-2021
 */
public class DatabaseBonus
{
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
    private static int lastId = 0;

    /**
     * getter mengambil database bonus
     * @return    null
     */
    public static ArrayList<Bonus> getBonusDatabase()
    {
        return BONUS_DATABASE;
    }

    /**
     * getter mengambil last id
     * @return    lastId
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * getter mengambil bonus dari id
     * @param id Bonus ID
     * @return    null
     */
    public static Bonus getBonusById(int id) throws BonusNotFoundException
    {
        Bonus valueBonus = null;
        for(Bonus bon: BONUS_DATABASE)
        {
            if(bon.getId() == id)
            {
                valueBonus = bon;
            }
        }

        if (valueBonus == null) {
            throw new BonusNotFoundException(id);
        } else {
            return valueBonus;
        }
    }

    /**
     * getter mengambil bonus dari referral code
     * @param referralCode Referral Code
     * @return    null
     */
    public static Bonus getBonusByReferralCode(String referralCode)
    {
        Bonus valueBonus = null;
        for(Bonus bon: BONUS_DATABASE)
        {
            if(bon.getReferralCode().equals(referralCode))
            {
                valueBonus = bon;
            }
        }
        return valueBonus;
    }

    /**
     * setter menambah bonus
     * @param bonus Bonus
     * @return    berhasil/tidak
     */
    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException
    {
        for(Bonus js: BONUS_DATABASE)
        {
            if(js.getReferralCode().equals(bonus.getReferralCode()))
            {
                throw new ReferralCodeAlreadyExistsException(bonus);
            }
        }

        lastId = bonus.getId();
        return BONUS_DATABASE.add(bonus);
    }

    /**
     * setter activate bonus
     * @param id Bonus ID
     * @return    berhasil/tidak
     */
    public static boolean activateBonus(int id)
    {
        for(Bonus bon: BONUS_DATABASE) {
            if (bon.getId() == id) {
                bon.setActive(true);
                return true;
            }
        }
        return false;
    }

    /**
     * setter bonus nonaktif
     * @param id Bonus ID
     * @return    berhasil/tidak
     */
    public static boolean deactivateBonus(int id)
    {
        for(Bonus bon: BONUS_DATABASE) {
            if (bon.getId() == id) {
                bon.setActive(false);
                return true;
            }
        }
        return false;
    }

    /**
     * setter mengapus bonus
     * @param id Bonus ID
     * @return    false
     */
    public static boolean removeBonus(int id) throws BonusNotFoundException
    {
        if (BONUS_DATABASE.removeIf(bonus -> bonus.getId() == id)) {
            return true;
        } else {
            throw new BonusNotFoundException(id);
        }
    }
}