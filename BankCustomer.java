// BankCustomer class
public class BankCustomer {
    private int CustomerID;
    private double Balance;
    private AccountType Account;

    //constructor
    public BankCustomer(AccountType acctType) {
        this.Account = acctType;
        this.Balance = 0;
    }

    //getter and setter methods
    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public AccountType getAccount() {
        return Account;
    }

    public void setAccount(AccountType account) {
        Account = account;
    }

    //make deposit
    public void makeDeposit(double amount) {
        this.Balance += amount;
    }

    //make withdrawal
    public void makeWithdrawal(double amount) {
        this.Balance -= amount;
    }

    //calculate interest earned
    public double calculateInterest() {
        return this.Balance * this.Account.getInterestRate();
    }

}
