package haidarhanif.jwork.controller;

import haidarhanif.jwork.*;
import haidarhanif.jwork.exception.BonusNotFoundException;
import haidarhanif.jwork.exception.ReferralCodeAlreadyExistsException;
import haidarhanif.jwork.remote.DatabaseBonusPostgre;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/bonus")
@RestController
public class BonusController {
    @RequestMapping("")
    public ArrayList<Bonus> getAllBonus()
    {
        return DatabaseBonusPostgre.getAllBonus();
    }

    @RequestMapping("/refcode/{referralCode}")
    public Bonus GetBonusByReferralCode(@PathVariable String referralCode)
    {
        return DatabaseBonusPostgre.getBonusByReferralCode(referralCode);
    }

    @RequestMapping("/{id}")
    public Bonus GetBonusById(@PathVariable int id)
    {
        return DatabaseBonusPostgre.getBonusById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value="referralCode") String referralCode,
                          @RequestParam(value="extraFee") int extraFee,
                          @RequestParam(value="minTotalFee") int minTotalFee,
                          @RequestParam(value="active") boolean active)
    {
        Bonus bonus = new Bonus(DatabaseBonusPostgre.getLastId()+1, referralCode, extraFee, minTotalFee, active);
        try {
            DatabaseBonusPostgre.addBonus(bonus);
        } catch (ReferralCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return bonus;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public boolean removeBonus(@RequestParam(value="id") int id)
    {
        try {
            DatabaseBonusPostgre.removeBonus(id);
        } catch (BonusNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/updateactive", method = RequestMethod.POST)
    public boolean updateActiveStatus(@RequestParam(value="id") int id)
    {
        try {
            DatabaseBonusPostgre.updateActiveStatus(id);
        } catch (BonusNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


}
