package haidarhanif.jwork.controller;

import haidarhanif.jwork.*;
import haidarhanif.jwork.exception.BonusNotFoundException;
import haidarhanif.jwork.exception.RecruiterNotFoundException;
import haidarhanif.jwork.remote.DatabaseBonusPostgre;
import haidarhanif.jwork.remote.DatabaseRecruiterPostgre;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/recruiter")
@RestController
public class RecruiterController {
    @RequestMapping("")
    public ArrayList<Recruiter> getAllRecruiter()
    {
        return DatabaseRecruiterPostgre.getAllRecruiter();
    }

    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id)
    {
        return DatabaseRecruiterPostgre.getRecruiterById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value="name") String name,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="phoneNumber") String phoneNumber,
                                  @RequestParam(value="province") String province,
                                  @RequestParam(value="city") String city,
                                  @RequestParam(value="description") String description)
    {
        Location loc = new Location(province, city, description);
        Recruiter rec = new Recruiter(DatabaseRecruiterPostgre.getLastId()+1, name, email, phoneNumber, loc);
        DatabaseRecruiterPostgre.addRecruiter(rec);
        return rec;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public boolean removeRecruiter(@RequestParam(value="id") int id)
    {
        try {
            DatabaseRecruiterPostgre.removeRecruiter(id);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
