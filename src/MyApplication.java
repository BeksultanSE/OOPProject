import controllers.ClientController;
import privileges.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final ClientController controller;
    private final Scanner sc;

    public MyApplication(ClientController controller){
        this.controller = controller;
        sc = new Scanner(System.in);
    }
    public void start(){
        while(true) {
            System.out.println("\nWelcome to bank management system!");
            System.out.println("Select your role:");
            System.out.println("1. Host");
            System.out.println("2. Client");
            System.out.println("3. Administrator");
            System.out.println("0. Exit");
            try {
                int role = sc.nextInt();
                pInterface roleInterface = null;
                if(role == 1) {
                    roleInterface = new pHost(controller, sc);
                }
                else if(role == 2){
                    System.out.println("Enter the login:");
                    String login = sc.next();
                    roleInterface = new pClient(controller, sc, login);
                }
                else if(role == 3){
                    System.out.println("Enter the secret code:");
                    String secretCode = sc.next();
                    if(secretCode.equals("adminadmin")){
                        roleInterface = new pAdmin(controller, sc);
                    }
                    else
                        System.out.println("Wrong secret code");
                }
                else {
                    System.out.println("Operations finished!");
                    System.out.println("Thank you for using our system!");
                    break;
                }
                while(roleInterface.mainMenu()){
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer: " + e);
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        }
    }

}
