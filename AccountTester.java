import java.util.*;


public class AccountTester
{
    public static String[] input;
    public static void main(String[] args)throws Exception{
        Scanner in = new Scanner(System.in);
        //String[] input;
        System.out.println("Welcome to JPax's dank password tester");
        
        while(true){
            input = in.nextLine().split(" ");
            if(input[0].equals("adduser"))
            {
                boolean passwordNotConfirmed = true;
                while(passwordNotConfirmed){
                    input = new String[4];
                
                    System.out.print("First name: ");
                    input[0] = in.nextLine();
                    
                    System.out.print("Last name: ");
                    input[1] = in.nextLine();
                
                    System.out.print("Password: ");
                    input[2] = in.nextLine();
                
                    System.out.print("Confirm password: ");
                    input[3] = in.nextLine();
                    
                    if(input[2].equals(input[3])) passwordNotConfirmed = false;
                }
                
                if(!Account.newAccount(input[0],input[1],input[2]))System.out.println("User already exists");
                
            }
            if(input[0].equals("sudo")){
                input = new String[2];
                
                System.out.print("Last name: ");
                input[0] = in.nextLine();
                
                System.out.print("Password: ");
                input[1] = in.nextLine();
                
                if(Account.validate(input[0],input[1])){
                    System.out.println("password accepted");
                }else{
                    System.out.println("password denied");
                }
            }
            if(input[0].equals("who")) System.out.println(Account.getCurrentUser());
            if(input[0].equals("save"))Account.saveAccounts();
            if(input[0].equals("load")) Account.loadAccounts();
            if(input[0].equals("exit")) System.exit(0);
            if(input[0].equals("reinforce")) Account.setIterations(Integer.parseInt(input[1]));
            if(input[0].equals("rm")){
                input = new String[2];
                
                System.out.print("Last name: ");
                input[0] = in.nextLine();
                
                System.out.print("Password: ");
                input[1] = in.nextLine();
                
                if(Account.removeAccount(input[0],input[1])){
                    System.out.println("account removed");
                }else{
                    System.out.println("password denied");
                }
            }
            if(input[0].equals("ls")){
                String str = Account.allUsers();
                System.out.println(str);
            }
        }
        
       
        
        
    }
}
