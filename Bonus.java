
/**
 * Write a description of class Bonus here.
 *
 * @author Haidar Hanif
 * @version 8-04-2020
 */
public class Bonus
{
    private int id;
    private String referralCode;
    private int extraFee;
    private int minTotalFee;
    private boolean active;
    
    /**
     * Constructor for objects of class Bonus
     */
    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active)
    {
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }

    /**
     * getter untuk mengambil id
     *
     * @return    nilai id (int)
     */
    public int getId()
    {
        return id;
    }
    
        /**
     * getter untuk mengambil referralCode
     *
     * @return    nilai referralCode(String)
     */
    public String getReferralCode()
    {
        return referralCode;
    }
    
        /**
     * getter untuk mengambil extraFee
     *
     * @return    extraFee(int)
     */
    public int getExtraFee()
    {
        return extraFee;
    }
    
            /**
     * getter untuk mengambil minTotalFee
     *
     * @return    minTotalFee(int)
     */
    public int getMinTotalFee()
    {
        return minTotalFee;
    }
    
            /**
     * getter untuk mengambil status active
     *
     * @return    status active (boolean)
     */
    public boolean getActive()
    {
        return active;
    }
    
                /**
     * setter untuk mengatur id
     *
     * @param  id  parameter untuk mengganti id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
                    /**
     * setter untuk mengatur referralCode
     *
     * @param  referralCode  parameter untuk mengganti referralCode
     */
    public void setReferralCode(String referralCode)
    {
        this.referralCode = referralCode;
    }
    
                    /**
     * setter untuk mengatur extraFee
     *
     * @param  extraFee  parameter untuk mengganti extraFee
     */
    public void setExtraFee(int extraFee)
    {
        this.extraFee = extraFee;
    }
    
                        /**
     * setter untuk mengatur total fee minimal
     *
     * @param  minTotalFee  parameter untuk mengganti minTotalFee
     */
    public void minTotalFee(int minTotalFee)
    {
        this.minTotalFee = minTotalFee;
    }
    
                            /**
     * setter untuk mengatur total fee minimal
     *
     * @param  minTotalFee  parameter untuk mengganti minTotalFee
     */
    public void setMinTotalFee(int minTotalFee)
    {
        this.minTotalFee = minTotalFee;
    }
    
                                /**
     * setter untuk mengatur status active
     *
     * @param  active  parameter untuk mengganti active
     */
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    /**
     * metode untuk mencetak data
     */
    public String toString(){
        return "\nID = " + id +
                "\nReferral Code = " + referralCode +
                "\nExtra Fee = " + extraFee +
                "\nMin Total Fee = " + minTotalFee +
                "\nActive Status = " + active;
    }
}
