package Financials;

public class Financials {
    private int totalIncome;
    private int unpayedAmount;
    private int seniorAmount;
    private int seniorPlusAmount;
    private int junoirAmount;
    private int passiveAmount;



    public Financials(){

    }

    public Financials(int totalIncome, int unpayedAmount, int seniorAmount, int seniorPlusAmount, int junoirAmount, int passiveAmount) {
        this.totalIncome = totalIncome;
        this.unpayedAmount = unpayedAmount;
        this.seniorAmount = seniorAmount;
        this.seniorPlusAmount = seniorPlusAmount;
        this.junoirAmount = junoirAmount;
        this.passiveAmount = passiveAmount;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getUnpayedAmount() {
        return unpayedAmount;
    }

    public void setUnpayedAmount(int unpayedAmount) {
        this.unpayedAmount = unpayedAmount;
    }

    public int getSeniorAmount() {
        return seniorAmount;
    }

    public void setSeniorAmount(int seniorAmount) {
        this.seniorAmount = seniorAmount;
    }

    public int getSeniorPlusAmount() {
        return seniorPlusAmount;
    }

    public void setSeniorPlusAmount(int seniorPlusAmount) {
        this.seniorPlusAmount = seniorPlusAmount;
    }

    public int getJunoirAmount() {
        return junoirAmount;
    }

    public void setJunoirAmount(int junoirAmount) {
        this.junoirAmount = junoirAmount;
    }

    public int getPassiveAmount() {
        return passiveAmount;
    }

    public void setPassiveAmount(int passiveAmount) {
        this.passiveAmount = passiveAmount;
    }



}
