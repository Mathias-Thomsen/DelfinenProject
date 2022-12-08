package financials;

public class Financials {
    private int totalIncome;
    private int unpayedAmount;
    private int seniorAmount;
    private int seniorPlusAmount;
    private int juniorAmount;
    private int passiveAmount;



    public Financials(){

    }

    public Financials(int totalIncome, int unpayedAmount, int seniorAmount, int seniorPlusAmount, int juniorAmount, int passiveAmount) {
        this.totalIncome = totalIncome;
        this.unpayedAmount = unpayedAmount;
        this.seniorAmount = seniorAmount;
        this.seniorPlusAmount = seniorPlusAmount;
        this.juniorAmount = juniorAmount;
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

    public int getJuniorAmount() {
        return juniorAmount;
    }

    public void setJuniorAmount(int juniorAmount) {
        this.juniorAmount = juniorAmount;
    }

    public int getPassiveAmount() {
        return passiveAmount;
    }

    public void setPassiveAmount(int passiveAmount) {
        this.passiveAmount = passiveAmount;
    }



}
