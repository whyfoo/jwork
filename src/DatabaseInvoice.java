import java.util.ArrayList;

/**
 * Kelas Database untuk Invoice
 *
 * @author Haidar Hanif
 * @version 05-05-2021
 */
public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE  = new ArrayList<>();
    private static int lastId = 0;

    /**
     * getter mengambil database invoice
     * @return    null
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
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
     * getter mengambil invoice dari id
     * @param id Invoice ID
     * @return    null
     */
    public static Invoice getInvoiceById(int id)
    {
        Invoice valueInvoice = null;
        for(Invoice bon: INVOICE_DATABASE)
        {
            if(bon.getId() == id)
            {
                valueInvoice = bon;
            }
        }
        return valueInvoice;
    }

    /**
     * getter mengambil invoice dari jobseeker
     * @param jobSeekerId Recruiter ID
     * @return   invoice by jobseeker
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobSeekerId)
    {
        ArrayList<Invoice> valueInvoice = new ArrayList<>();
        for(Invoice inv: INVOICE_DATABASE)
        {
            if(inv.getJobseeker().getId() == jobSeekerId)
            {
                valueInvoice.add(inv);
            }
        }
        return valueInvoice;
    }

    /**
     * setter menambah invoice
     * @param invoice Invoice
     * @return    boolean berhasil/tidak
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException
    {
        for(Invoice inv: INVOICE_DATABASE)
        {
            if(inv.getJobseeker() == invoice.getJobseeker() && inv.getInvoiceStatus() == InvoiceStatus.OnGoing)
            {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }

        lastId = invoice.getId();
        return INVOICE_DATABASE.add(invoice);
    }

    /**
     * setter activate invoice
     * @param id invoice ID
     * @return    berhasil/tidak
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for(Invoice inv: INVOICE_DATABASE) {
            if (inv.getId() == id && inv.getInvoiceStatus() == InvoiceStatus.OnGoing) {
                inv.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * setter mengapus invoice
     * @param id invoice ID
     * @return    false
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        if (INVOICE_DATABASE.removeIf(inv -> inv.getId() == id)) {
            return true;
        } else {
            throw new InvoiceNotFoundException(id);
        }
    }
}
