import java.util.*;
public class voting {
    ArrayList <String> f_name=new ArrayList<>();
    ArrayList <String> L_name=new ArrayList<>();
    static ArrayList <String> id=new ArrayList<>();
    static ArrayList <Integer> ph_no=new ArrayList<>();
    void register(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter first name: ");
        String f_nm=sc.nextLine();
        System.out.print("enter last name: ");
        String l_nm=sc.nextLine();
        System.out.print("enter voter id: ");
        String id1=sc.nextLine();
        System.out.print("enter phone no: ");
        int no=sc.nextInt();
        f_name.add(f_nm);
        L_name.add(l_nm);
        id.add(id1);
        ph_no.add(no);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        a=0;
        b=0;
        c=0;
        voting v = new voting();
        System.out.println("press 1 to register");
        System.out.println("press 2 to vote");
        System.out.println("press 3 to EXIT");
        System.out.println("enter your choice: ");
        int n=sc.nextInt();
        while(n!=3){
            switch(n){
                case 1:{
                    v.register();
                    break;
                }
                case 2:{
                    System.out.print("enter voter id: ");
                    String id1=sc.next();
                    int j=id.indexOf(id1);
                    System.out.print("enter phone no: ");
                    int no=sc.nextInt();
                    if(ph_no.get(j)==no){
                        System.out.println("enter 1 for voting party A\nenter 2 for voting party B\nenter 3 for voting party C");
                        int n1=sc.nextInt();
                        if(n1==1){
                            a=a+1;
                            System.out.println("vote is given successfully");
                        }
                        else if(n1==2){
                            b=b+1;
                            System.out.println("vote is given successfully");
                        }
                        else if(n1==3){
                            c=c+1;
                            System.out.println("vote is given successfully");
                        }
                    }
                    break;
                }
            }
            System.out.println("press 1 to register");
            System.out.println("press 2 to vote");
            System.out.println("press 3 to EXIT");
            System.out.println("enter your choice: ");
            n=sc.nextInt();
        }
    }
}
