package haidarhanif.jwork.exception;

import haidarhanif.jwork.Bonus;

public class ReferralCodeAlreadyExistsException extends Exception {
    private Bonus referral_error;

    public ReferralCodeAlreadyExistsException (Bonus referral_input) {
        super("Referral Code: ");
        referral_error = referral_input;
    }

    public String getMessage() {
        return super.getMessage() + referral_error.getReferralCode() + " already exists.";
    }
}
