package haidarhanif.jwork.controller;

import haidarhanif.jwork.*;
import haidarhanif.jwork.enumerated.InvoiceStatus;
import haidarhanif.jwork.exception.InvoiceNotFoundException;
import haidarhanif.jwork.exception.JobNotFoundException;
import haidarhanif.jwork.exception.JobSeekerNotFoundException;
import haidarhanif.jwork.exception.OngoingInvoiceAlreadyExistsException;
import haidarhanif.jwork.remote.DatabaseBonusPostgre;
import haidarhanif.jwork.remote.DatabaseJobPostgre;
import haidarhanif.jwork.remote.DatabaseJobseekerPostgre;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id)
    {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return invoice;
    }

    @RequestMapping("/jobseeker/{jobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int jobseekerId)
    {
        return DatabaseInvoice.getInvoiceByJobseeker(jobseekerId);
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value="status") InvoiceStatus status)
    {
        Invoice invoice = null;
        try {
            DatabaseInvoice.getInvoiceById(id).setInvoiceStatus(status);
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return invoice;
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id)
    {
        try{
            return DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value = "adminFee", defaultValue = "0") int adminFee)
    {
        BankPayment bank = null;
        ArrayList<Job> jobAL =  new ArrayList<Job>();
        for(int id : jobIdList)
        {
            try {
                Job job = DatabaseJobPostgre.getJobById(id);
                jobAL.add(job);
            } catch (JobNotFoundException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

        try{
            bank = new BankPayment(DatabaseInvoice.getLastId()+1, jobAL, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId), adminFee);
        } catch (JobSeekerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        try {
            DatabaseInvoice.addInvoice(bank);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        bank.setTotalFee();
        return bank;
    }

    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value = "referralCode", defaultValue = "") String referralCode)
    {
        EwalletPayment eWallet = null;
        ArrayList<Job> jobAL =  new ArrayList<Job>();
        for(int id : jobIdList)
        {
            try {
                Job job = DatabaseJobPostgre.getJobById(id);
                jobAL.add(job);
            } catch (JobNotFoundException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

        try {
            eWallet = new EwalletPayment(DatabaseInvoice.getLastId()+1, jobAL, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId), DatabaseBonusPostgre.getBonusByReferralCode(referralCode));
        } catch (JobSeekerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }

        eWallet.setTotalFee();

        try {
            DatabaseInvoice.addInvoice(eWallet);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return eWallet;
    }

}
