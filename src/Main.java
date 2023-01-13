import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bank Name i.e SBI or HDFC");
        String bank = sc.next();
        if(bank.equals("SBI")){
            // create user
            System.out.println("Enter your Name, Password, Balance to open an account in SBI");
            String name = sc.next();
            String password = sc.next();
            int balance = sc.nextInt();
            SBIUser user = new SBIUser(name, balance, password);
            System.out.println("The account number is:"+user.getAccountNunmber());

            // add money
            System.out.println(user.addMoney(balance));

            // withdraw money
            System.out.println("Enter amount to withdraw & password");
            int money = sc.nextInt();
            String ps = sc.next();
            System.out.println(user.withdrawMoney(money,ps));

            // interest
            System.out.println("The interest for 10 year on Rs "+user.getBalance()+" will be: "+user.calculateInterest(10));

        }
        else if(bank.equals("HDFC")){
            // create user
            System.out.println("Enter your Name, Password, Balance to open an account in SBI");
            String name = sc.nextLine();
            sc.next();
            String password = sc.next();
            int balance = sc.nextInt();
            HDFCUser user = new HDFCUser(name, balance, password);
            System.out.println("The account number is:"+user.getAccountNumber());
            // add money
            System.out.println(user.addMoney(balance));

            // withdraw money
            System.out.println("Enter amount to withdraw & password");
            int money = sc.nextInt();
            String ps = sc.next();
            System.out.println(user.withdrawMoney(money,ps));

            // interest
            System.out.println("The interest for 10 year on Rs "+user.getBalance()+" will be: "+user.calculateInterest(10));
        }

    }
}