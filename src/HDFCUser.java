import java.util.Objects;
import java.util.UUID;

public class HDFCUser implements BankInterface {
    private String name;
    private String accountNumber;
    private double balance;
    private String password;
    private static double rateOfInterest;

    public HDFCUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        // bank is initialize
        rateOfInterest = 6.5;
        this.accountNumber = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        HDFCUser.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return this.balance;
    }

    @Override
    public String addMoney(int amount) {
        balance = balance + amount;
        return "Rs "+ amount + " is Credited in your account";
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {

        if(Objects.equals(enteredPassword,password)){
            if(amount > balance){
                return "Insufficient fund!";
            }
            else {
                balance = balance-amount;
                return "Rs " + amount + " is Debited from your account";
            }
        }
        else{
            return "Wrong Password!";
        }
    }

    @Override
    public double calculateInterest(int year) {
        return (balance * year * rateOfInterest)/100;
    }
}
