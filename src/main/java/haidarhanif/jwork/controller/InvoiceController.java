package haidarhanif.jwork.controller;

import haidarhanif.jwork.*;
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
            e.getMessage();
            return null;
        }
        return invoice;
    }

    @RequestMapping("/Jobseeker/{JobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int JobseekerId)
    {
        return DatabaseInvoice.getInvoiceByJobseeker(JobseekerId);
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value="name") InvoiceStatus status)
    {
        Invoice invoice = null;
        try {
            DatabaseInvoice.getInvoiceById(id).setInvoiceStatus(status);
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
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
            e.getMessage();
            return false;
        }
    }

    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value = "adminFee") int adminFee)
    {
        BankPayment bank = null;
        try {
            bank = new BankPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobById(jobIdList), DatabaseJobSeeker.getJobseekerById(jobseekerId), adminFee);
        } catch (JobSeekerNotFoundException e) {
            e.getMessage();
            return null;
        }
        
        try {
            DatabaseInvoice.addInvoice(bank);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        
        bank.setTotalFee();
    }

    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value = "adminFee") int adminFee)
    {
        EwalletPayment eWallet = null;
        try {
            eWallet = new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobById(jobIdList), DatabaseJobSeeker.getJobseekerById(jobseekerId), adminFee);
        } catch (JobSeekerNotFoundException e) {
            e.getMessage();
            return null;
        }

        try {
            DatabaseInvoice.addInvoice(eWallet);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
            return null;
        }

        eWallet.setTotalFee();
    }

}
