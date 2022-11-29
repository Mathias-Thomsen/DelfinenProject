package Subscription;


public class Subscription {
    private final int JUNIOR_PAY = 1000;
    private final int SENIOR_PAY = 1600;
    private final int SENIOR_PLUS_PAY = 1200; // payment with senior discount
    private final int PASSIVE_PAY = 500;


    public int getJUNIOR_PAY() {
        return JUNIOR_PAY;
    }

    public int getSENIOR_PAY() {
        return SENIOR_PAY;
    }

    public int getSENIOR_PLUS_PAY() {
        return SENIOR_PLUS_PAY;
    }

    public int getPASSIVE_PAY() {
        return PASSIVE_PAY;
    }
}
