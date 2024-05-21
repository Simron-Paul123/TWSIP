import java.util.ArrayList;
import java.util.Scanner;
public class atmmmanagement {
    ArrayList<Integer>bal=new ArrayList<>();
    static ArrayList<Integer>ac=new ArrayList<>(5);
    static ArrayList<Integer>pin=new ArrayList<>();
    void deposit(int i){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter amount you want to deposit: ");
        int amount = sc.nextInt();
        if(bal.size()-1<i)
            bal.add(amount);
        else
            bal.set(i,bal.get(i)+amount);
        System.out.println("the amount dedposited successfully");
    }
    void withdraw(int i,int min){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter amount you want to withdraw: ");
        int amount = sc.nextInt();
        if(amount>bal.get(i) || bal.get(i)<min){
            System.out.println("Insufficient Balance\n your minimum balance should be Rs:"+min+"/-");
        }
        else if(amount<bal.get(i) &&(bal.get(i)-amount)<min){
            System.out.println("Rs:100/ penalty charge");
            bal.set(i,bal.get(i)-(amount+100));
        }
        else{
            bal.set(i,bal.get(i)-amount);
        }
        System.out.println("the amount withdrwal successfully");
    }
    int check(int i){
        return bal.get(i);
    }
    int create_pin(){
        Scanner sc = new Scanner(System.in);
        System.err.println("enter new pin: ");
        int p=sc.nextInt();
        System.out.println("enter ac/no: ");
        int p1=sc.nextInt();
        ac.add(p1);
        int j=ac.indexOf(p1);
        pin.add(j,p);

        return p;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert your card");
       atmmmanagement atm = new atmmmanagement();
       System.out.println("press 1 for entering pin");
       System.out.println("press 2 for creating pin");
       System.out.println("press 3 to EXIT");
       System.out.print("enter your choice: ");
       int n1=sc.nextInt();
       while(n1!=3){
            switch(n1){
                case 1:{
                    System.out.println("enter ac/no: ");
                    int ac1=sc.nextInt();
                    System.out.print("enter atm pin: ");
                    int p=sc.nextInt();
                    int count=0;
                    for(int i=0;i<ac.size();i++){
                        if(ac1!=ac.get(i) || ac.isEmpty()){
                           count=-1;
                        }
                        if(count==-1){
                            System.out.println("no such account found");
                        }
                        else{
                            int j=ac.indexOf(ac1);
                    if(pin.get(ac.indexOf(ac1))==p){
                        System.out.println("welcome to the ATM");
                        System.out.println("press->1 to Deposit");
                        System.out.println("press->2 to  Withdrawl");
                        System.out.println("press->3 to  check balance");
                        System.out.println("press->4 to exit");
                        System.out.print("enter your choice: ");
                        int n=sc.nextInt();
                        while(n!=4){
                            switch(n){
                                case 1:{
                                    atm.deposit(j);
                                    break;
                                }
                                case 2:{
                                    atm.withdraw(j, 0);
                                    break;
                                }
                                case 3:{
                                    System.out.println("available balance is: Rs: "+atm.check(j)+"/-");
                                    break;
                                }
                            }
                            System.out.println("press->1 to Deposit");
                            System.out.println("press->2 to  Withdrawl");
                            System.out.println("press->3 to  check balance");
                            System.out.println("press->4 to exit");
                            System.out.print("enter your choice: ");
                            n=sc.nextInt();
                        }
                    }
                    else{
                    System.out.println("wrong credentials");
                    }
                }
            }
                    break;
                }
                case 2: {
                    int p_new=atm.create_pin();
                    System.out.println("pin created successfully");
                    break;
                }
            }
            System.out.println("press 1 for entering pin");
            System.out.println("press 2 for creating pin");
            System.out.println("press 3 to EXIT");
            System.out.print("enter your choice: ");
            n1=sc.nextInt();
        }

    }
}
