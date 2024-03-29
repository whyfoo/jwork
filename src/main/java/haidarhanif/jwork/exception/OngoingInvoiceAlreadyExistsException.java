package haidarhanif.jwork.exception;

import haidarhanif.jwork.Invoice;

public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException (Invoice invoice_input) {
        super("Ongoing Invoice ");
        invoice_error = invoice_input;
    }

    public String getMessage() {
        return super.getMessage() + invoice_error.getId() + " already exists.";
    }
}