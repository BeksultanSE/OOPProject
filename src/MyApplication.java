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
            System.out.println("Select option:");
            System.out.println("1. Get all clients");
            System.out.println("2. Get client by id");
            System.out.println("3. Add client");
            System.out.println("0. EXIT\n");
            try {
                System.out.print("Enter option: ");
                int option = sc.nextInt();
                if (option == 1) {
                    getAllClientsMenu();
                } else if (option == 2) {
                    getClientByIdMenu();
                } else if (option == 3) {
                    addClientMenu();
                } else {
                    System.out.println("Operations finished!");
                    break;
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
    public void getAllClientsMenu(){
        String res = controller.getAllClients();
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
        System.out.println("Please enter the password:");
        String password = sc.next();
        System.out.println("Repeat the password:");
        String repeatedPassword = sc.next();
        while (!password.equals(repeatedPassword)){
            System.out.println("Passwords does not match! Please enter the password again:");
            password = sc.next();
            System.out.println("Repeat the password:");
            repeatedPassword = sc.next();
        }
        System.out.println("Please enter your starting balance:");
        int balance = sc.nextInt();
        String res = controller.addClient(name, surname, login, password, balance);
        System.out.println(res);
    }
}
