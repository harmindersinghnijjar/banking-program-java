import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

// Main class
public class BankingProgram {
    public static void main(String[] args) {
        //menu for bank manager and customer
        System.out.println("Welcome to Harminder's banking program!");
        System.out.println("-----------------------------------");
        System.out.println("1) Bank Manager");
        System.out.println("2) Bank Customer");

        //prompt user to select an option
        Scanner sc = new Scanner(System.in);
        System.out.print("Select an Option: ");
        int option = sc.nextInt();

        //if bank manager is selected
        if(option == 1){
            //call bank manager method
            bankManager();
        }
        //if bank customer is selected
        else if(option == 2){
            //call bank customer method
            bankCustomer();
        }
        //if invalid option is selected
        else{
            System.out.println("Invalid Option!");
        }

    }

    //bank manager method
    public static void bankManager(){
        //prompt user to enter customer information
        System.out.println("Enter customer information: ");

        //create an arraylist to store customer info
        ArrayList<String> customerInfo = new ArrayList<String>();

        //loop to enter customer info
        while(true){
            //prompt user to enter customer id
            System.out.print("Enter customer id: ");
            Scanner sc = new Scanner(System.in);
            String customerId = sc.nextLine();

            //if customer id is empty, terminate the loop
            if(customerId.isEmpty()){
                break;
            }

            //prompt user to enter customer name
            System.out.print("Enter customer name: ");
            String name = sc.nextLine();

            //prompt user to enter customer email
            System.out.print("Enter customer email: ");
            String email = sc.nextLine();

            //add customer information to arraylist
            customerInfo.add(customerId);
            customerInfo.add(name);
            customerInfo.add(email);
        }

        //write customer information to file
        try{
            FileWriter writer = new FileWriter("BankCustInfo.txt");
            BufferedWriter bw = new BufferedWriter(writer);

            for(int i=0; i<customerInfo.size(); i++){
                bw.write(customerInfo.get(i));
                bw.newLine();
            }

            bw.close();
            System.out.println("Customer information saved to file.");
        }catch(Exception e){
            System.out.println("Error writing to file!");
        }

        //display all customer records
        try{
            FileReader reader = new FileReader("BankCustInfo.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }

            br.close();
        }catch(Exception e){
            System.out.println("Error reading from file!");
        }
    }

    //bank customer method
    public static void bankCustomer(){
        //prompt user to enter account type
        System.out.print("Enter account type (1 for checking, 2 for savings): ");
        Scanner sc = new Scanner(System.in);
        int accountType = sc.nextInt();

        //create account type object
        AccountType acctType = new AccountType(accountType);

        //create bank customer object
        BankCustomer cust = new BankCustomer(acctType);

        //display customer balance
        System.out.println("Customer Balance: " + cust.getBalance());

        //prompt user to enter deposit amount
        System.out.print("Enter deposit amount: ");
        double depositAmount = sc.nextDouble();

        //make deposit
        cust.makeDeposit(depositAmount);

        //display customer balance
        System.out.println("Customer Balance: " + cust.getBalance());

        //prompt user to enter withdrawal amount
        System.out.print("Enter withdrawal amount: ");
        double withdrawalAmount = sc.nextDouble();

        //make withdrawal
        cust.makeWithdrawal(withdrawalAmount);

        //display customer balance
        System.out.println("Customer Balance: " + cust.getBalance());

        //calculate and display interest earned
        System.out.println("Interest Earned: " + cust.calculateInterest());
    }
}

