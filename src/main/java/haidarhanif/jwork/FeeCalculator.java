package haidarhanif.jwork;
public class FeeCalculator implements Runnable{
    private Invoice inv;

    FeeCalculator (Invoice inv) {
        this.inv = inv;
    }

    @Override
    public void run() {
        System.out.println("Calculating invoice id: " + inv.getId());
        inv.setTotalFee();
        System.out.println("Finish calculating invoice id: " + inv.getId());
    }
}
