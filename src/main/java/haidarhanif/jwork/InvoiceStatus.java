package haidarhanif.jwork;
/**
 * Enumeration class JobCategory
 *
 * @author Haidar Hanif
 * @version 27-03-2021
 */
public enum InvoiceStatus
{
    OnGoing("OnGoing"),
    Finished("Finished"),
    Cancelled("Cancelled");
    
    private String status;

    InvoiceStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }
}