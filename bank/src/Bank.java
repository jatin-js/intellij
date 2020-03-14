import java.util.Scanner;

class Bank {
    static class Account {
        String name;
        int accNo;
        String accType;
        int balance;

        Account(String name, int accNo, String accType) {
            this.name = name;
            this.accNo = accNo;
            this.accType = accType;
        }
        void displayBalance(){
            System.out.println("Your balance is Rs" + balance);
        }

    }

   static class Curr_acct extends Account {
       Curr_acct(String name, int accNo, String accType) {
           super(name, accNo, accType);
       }

       int charge(){
           if(balance<3000)return (int)(0.01*balance);
           return 0;
       }

       void addDeposit(int deposit) {
           int charge = charge();
           balance += deposit - charge;
           System.out.println(deposit + " added");
       }
       void withdrawal(int amt){
           int charge = charge();
           if(balance>=amt+charge) {
               balance -= (amt + charge);
               System.out.println("Rs" + amt + " withdrawn from account");
           }
           else System.out.println("Low balance");
       }
   }


    static class Sav_acct extends Account {
        Sav_acct(String name, int accNo, String accType) {
            super(name, accNo, accType);
        }
        void addDeposit(int deposit) {
            balance += deposit;
            System.out.println(deposit + " added");
        }
        void computeAndDepositInterest(){
            int interest = (int)(balance * 0.04);
            balance+=interest;
            System.out.println("Interest of Rs" + interest + " is added to your account");
        }
        void withdrawal(int amt){
            if(balance>=amt) {
                balance -= amt;
                System.out.println("Rs" + amt + " withdrawn from account");
            }
            else System.out.println("Low balance");
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        System.out.println("Enter type of account: 'saving' or 'current'");
        String accType = scr.nextLine();
        int amt, accNo;
        String name;
        boolean i=true;



        if(accType.equals("saving")){
            System.out.println("Enter name");
            name=scr.nextLine();
            System.out.println("Account no.");
            accNo=scr.nextInt();
            Sav_acct sa = new Sav_acct(name, accNo, "saving");

            while(i){
                System.out.println("1 to add deposit");
                System.out.println("2 to compute and deposit interest");
                System.out.println("3 to withdraw");
                System.out.println("4 to display balance");
                System.out.println("5 to end session");
                int n = scr.nextInt();
                switch (n){
                    case 1:
                        System.out.println("Enter amount to deposit");
                        amt = scr.nextInt();
                        sa.addDeposit(amt);
                        break;
                    case 2:
                        sa.computeAndDepositInterest();
                        break;
                    case 3:
                        System.out.println("Enter amount to withdraw");
                        amt=scr.nextInt();
                        sa.withdrawal(amt);
                        break;
                    case 4:sa.displayBalance();
                        break;
                    case 5:i=false;
                        break;
                    default:
                        System.out.println("Wrong option");
                }

            }
        }
       else if(accType.equals("current")){
            System.out.println("Enter name");
            name=scr.nextLine();
            System.out.println("Account no.");
            accNo=scr.nextInt();
            Curr_acct ca = new Curr_acct(name, accNo, "current");

            while(i){
                System.out.println("1 to add deposit");
                System.out.println("2 to withdraw");
                System.out.println("3 to display balance");
                System.out.println("4 to end session");
                int n = scr.nextInt();
                switch (n){
                    case 1:
                        System.out.println("Enter amount to deposit");
                        amt = scr.nextInt();
                        ca.addDeposit(amt);
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw");
                        amt=scr.nextInt();
                        ca.withdrawal(amt);
                        break;
                    case 3:ca.displayBalance();
                        break;
                    case 4:i=false;
                        break;
                    default:
                        System.out.println("Wrong option");
                }

            }
        }
       else System.out.println("Wrong account type");


    }
}

