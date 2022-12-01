// AccountType class
public class AccountType {
    private int AccountID;
    private double InterestRate;

    //constructor
    public AccountType(int AccountID) {
        this.AccountID = AccountID;

        if (AccountID == 1) {
            this.InterestRate = 0.01;
        } else if (AccountID == 2) {
            this.InterestRate = 0.02;
        }
    }

    //getter and setter methods
    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public double getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(double interestRate) {
        InterestRate = interestRate;
    }


}
