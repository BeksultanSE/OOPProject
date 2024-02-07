import controllers.ClientController;

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
            /*
            System.out.println("Select your role:");
            System.out.println("1. Host");
            System.out.println("2. Client");
            System.out.println("3. Administrator");
            */

            try {
                //int role = sc.nextInt();
                //if(role == 3) {
                System.out.println("Select option:");
                System.out.println("1. Get all clients");
                //System.out.println("2. Get client by id");
                System.out.println("2. Get client by login");
                System.out.println("3. Add client");
                System.out.println("4. Make a deposit");
                System.out.println("5. Change password");
                System.out.println("6. Close account");
                System.out.println("0. EXIT\n");
                System.out.print("Enter option: ");
                int option = sc.nextInt();
                if (option == 1) {
                    getAllClientsMenu();
                } else if (option == 2) {
                    //getClientByIdMenu();
                    getClientByLogin();
                } else if (option == 3) {
                    addClientMenu();
                } else if (option == 4){
                    makeDeposit();
                }
                else if(option == 5){
                    changePassword();
                }
                else if(option == 6){
                    closeAccount();
                }
                else {
                    System.out.println("Operations finished!");
                    break;
                }
                //}
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer: " + e);
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        }
    }
    public void getAllClientsMenu(){
        String res = controller.getAllClients();
        System.out.println(res);
    }
    public void getClientByLogin(){
        System.out.print("Enter login: ");
        String login = sc.next();
        String res = controller.getClientByLogin(login);
        System.out.println(res);
    }
    public void getClientByIdMenu(){
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        String res = controller.getClientByID(id);
        System.out.println(res);
    }
    public void addClientMenu(){
        System.out.println("Please enter name:");
        String name = sc.next();
        System.out.println("Please enter surname:");
        String surname = sc.next();
        System.out.println("Please enter login:");
        String login = sc.next();
        while (controller.loginExists(login)){
            System.out.println("Login already exists!\nPlease enter another login:");
            login = sc.next();
        }
        String password = passwordCreation();
        System.out.println("Please enter your starting balance:");
        int balance = sc.nextInt();
        String res = controller.addClient(name, surname, login, password, balance);
        System.out.println(res);
    }

    public void makeDeposit(){
        System.out.println("Please enter the account login:");
        String login = sc.next();
        System.out.println("Please enter the funds:");
        int cash = sc.nextInt();
        String res = controller.updateClientAccount(login, cash);
        System.out.println(res);
    }
    public void changePassword(){
        System.out.println("Please enter login:");
        String login = sc.next();
        System.out.println("Please enter the password:");
        String password = sc.next();
        String newPassword = passwordCreation();
        String res = controller.changePassword(login, password, newPassword);
        System.out.println(res);
        while(res.charAt(0) == 'I') {
            System.out.println("Please enter the old password:");
            password = sc.next();
            newPassword = passwordCreation();
            res = controller.changePassword(login, password, newPassword);
            System.out.println(res);
        }
    }
    public void closeAccount(){
        System.out.println("Please enter login:");
        String login = sc.next();
        System.out.println("Please enter the password:");
        String password = sc.next();
        String res = controller.closeAccount(login, password);
        System.out.println(res);
        while(res.charAt(0) == 'I') {
            System.out.println("Please enter the password:");
            password = sc.next();
            res = controller.closeAccount(login, password);
            System.out.println(res);
        }
    }
    public String passwordCreation(){
        System.out.println("Please enter the new password:");
        String password = sc.next();
        System.out.println("Repeat the password:");
        String repeatedPassword = sc.next();
        while (!password.equals(repeatedPassword)){
            System.out.println("Passwords does not match! Please enter the password again:");
            password = sc.next();
            System.out.println("Repeat the password:");
            repeatedPassword = sc.next();
        }
        return password;
    }
}
